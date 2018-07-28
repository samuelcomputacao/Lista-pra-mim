package com.projeto.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CompraNaoCadastrada;
import com.projeto.util.Mensagem;
import com.projeto.util.ValidadorSistema;

/**
 * Representa uma lista de compras. Toda lista de compras tem um descritor e uma
 * coleção de itens a comprar. Alem disso possui atributos que representam a
 * data de criacao, local de compra, se a mesma foi finalizada e o seu valor
 * final.
 */
public class ListaDeCompra implements Comparable<ListaDeCompra>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2980988884358572850L;

	/**
	 * String com o descritor da lista de compras. Um descritor de uma lista tem o
	 * papel de descrever a compra.(ex "feira 23/05/2018")
	 */
	private String descritor;

	/**
	 * Atributo que identifica a data/hora em que a lista de compras foi criada.
	 */
	private Date dataCriacao;

	/**
	 * Mapa que associa o id de um Item a uma Compra.
	 */
	private Map<Integer, Compra> compras;

	/**
	 * Boolean que indica se a lista de compras foi finalziada.
	 */
	private boolean finalizada;

	/**
	 * String que representa o local de compra.
	 */
	private String local;

	/**
	 * Inteiro que representa o valor final da lista de compras.
	 */
	private int valorFinal;

	/**
	 * Constroi uma listaDeCompras a partir de um descritor.
	 * 
	 * @param descritor
	 *            String que representa o descritor da lista de compras.
	 */
	public ListaDeCompra(String descritor) {
		ValidadorSistema.validaDescritor(descritor, "Erro em lista de compra: Descritor invalido.");

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// String dataString = dateFormat.format(new Date());
		try {
			// this.dataCriacao = dateFormat.parse(dataString);
			dataCriacao = new Date();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.descritor = descritor;
		this.compras = new HashMap<>();
		this.finalizada = false;
	}

	/**
	 * Metodo que adiciona uma compra na listaDeCompras, caso o item ainda nao tenha
	 * sido adicionado em alguma compra.
	 * 
	 * @param quantidade
	 *            quantidade de itens.
	 * @param item
	 *            instancia de Item.
	 */
	public void adicionaCompraALista(int quantidade, Item item) {
		if (this.compras.keySet().contains(item.getId())) {
			throw new CampoInvalidoException("Item ja cadastrado");
		}
		ValidadorSistema.validaQuantidade(quantidade);
		this.compras.put(item.getId(), new Compra(item, quantidade));
	}

	/**
	 * Metodo que atualiza a quantidade de itens de uma compra na lista de compras.
	 * Remove um produto da lista de compras se a quantidade for menor que 1.
	 * 
	 * @param idItem
	 *            Inteiro com o id do produto.
	 * @param operacao
	 *            String com a operacao a ser realizada: "adiciona" ou "diminui".
	 * @param quantidade
	 *            Inteiro com a qtd a ser removida ou adicionada no atributo
	 *            quantidade.
	 */
	public void atualizaCompraDeLista(Integer idItem, String operacao, int quantidade) {
		try {
			if (ValidadorSistema.validaOperacao(operacao)) {
				if (!this.compras.containsKey(idItem)) {
					throw new CompraNaoCadastrada(Mensagem.MSG_EXCECAO_ATUALIZA_COMPRA.get());
				}
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_ATUALIZA_COMPRA.get() + e.getMessage());
		}
		ValidadorSistema.validaQuantidade(quantidade);
		this.compras.get(idItem).atualizar(operacao, quantidade);
		if (this.compras.get(idItem).getQuantidade() <= 0)
			this.compras.remove(idItem);
	}

	/**
	 * Metodo que retorna a representacao visual de uma compra em uma lista de
	 * compras.
	 * 
	 * @param posicao
	 *            Inteiro com a posicao da Compra.
	 * @return String com o toString da Compra ou "" se a posicao for invalida.
	 */
	public String getItemLista(int posicao) {
		List<Compra> listaOrdenada = new ArrayList<>(this.compras.values());
		Collections.sort(listaOrdenada);
		if (posicao < listaOrdenada.size()) {
			return listaOrdenada.get(posicao).toString();
		}
		return "";
	}

	/**
	 * Metodo que retorna uma String com o toString de todas as Compras da
	 * listaDeCompras.
	 * 
	 * @return String com o toString de todas as compras da lista.
	 */
	public String buscaTodosItens() {
		String itens = "";
		for (Compra compra : this.compras.values()) {
			itens += compra.getDescricao() + System.lineSeparator();
		}
		return itens;
	}

	/**
	 * Metodo que retorna uma String com a descricao de uma Compra pertencente a
	 * listaDeCompras.
	 * 
	 * @param idItem
	 *            Inteiro com o id do Item associado a Compra.
	 * @return String com a descricao da Compra.
	 */
	public String pesquisaCompraEmLista(Integer idItem) {
		if (!this.compras.containsKey(idItem)) {
			throw new CompraNaoCadastrada(Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());
		}
		return this.compras.get(idItem).getDescricao();
	}

	/**
	 * Metodo responsavel por finalizar a lista de compras.
	 * 
	 * @param local
	 *            String com o local onde as compras foram efetuadas.
	 * @param valorFinal
	 *            Inteiro com o alor final da compra.
	 */
	public void finalizar(String local, int valorFinal) {
		this.local = local;
		this.valorFinal = valorFinal;
		this.finalizada = true;
	}

	/**
	 * Metodo que verifica se a listaDeCompras foi finalizada.
	 * 
	 * @return valor boleano indicando se foi finalidada ou nao.
	 */
	public boolean isFinalizada() {
		return this.finalizada;
	}

	/**
	 * Metodo responsavel por deletar uma compra da lista de compras.
	 * 
	 * @param idItem
	 *            Id do item associado a compra a ser deletada.
	 */
	public void deletaCompraDeLista(Integer idItem) {
		if (!this.compras.containsKey(idItem)) {
			throw new CompraNaoCadastrada(Mensagem.MSG_EXCECAO_EXCLUSAO_COMPRA.get());
		}
		this.compras.remove(idItem);
	}

	/**
	 * Metodo acessor que retorna a data de criacao da lista de compras.
	 * 
	 * @return Date com a data/hora em que a lista de compras foi criada
	 */
	public Date getData() {
		return this.dataCriacao;
	}

	/**
	 * Metodo acessor que retorna o descritor da lista de compras.
	 * 
	 * @return String com o descritor da lista de compras.
	 */
	public String getDescritor() {
		return this.descritor;
	}

	/**
	 * Metodo compareTo baseado no descritor da lista de compras.
	 */
	@Override
	public int compareTo(ListaDeCompra o) {
		return this.descritor.toLowerCase().compareTo(o.getDescritor().toLowerCase());
	}

	/**
	 * Metodo toString que retorna uma String com o descritor da lista de compras.
	 */
	@Override
	public String toString() {
		return this.descritor;
	}

	/**
	 * Metodo responsavel por verificar se a lista de compras possui uma determinada
	 * Compra.
	 * 
	 * @param idItem
	 *            Inteiro com o id do item associado a compra.
	 * @return valor boleano indicando se a compra pertence a lista de compras ou
	 *         nao.
	 */
	public boolean possuiCompra(int idItem) {
		for (Compra compra : this.compras.values()) {
			if (compra.getItem().getId() == idItem) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo acessor que retorna uma String com a data formatada.
	 * 
	 * @return String com a data formatada.
	 */
	public Date getDataFormatada() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String date = dateFormat.format(this.dataCriacao);
			return dateFormat.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo acessor que retorna uma String com a data em formato textual.
	 * 
	 * @return String com a data em formato textual.
	 */
	public String getDataTextual() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(this.dataCriacao);
	}

	/**
	 * Metodo acessor que retorna o mapa da lista de compras.
	 * 
	 * @return Map da lista de compras.
	 */
	public Map<Integer, Compra> getCompras() {
		return this.compras;
	}

	/**
	 * Metodo acessor que altera o mapa da lista de compras.
	 * 
	 * @param compras
	 *            Map da nova lista de compras.
	 */
	public void setCompras(Map<Integer, Compra> compras) {
		this.compras = compras;
	}

	/**
	 * Metodo acessor que retorna o valor final da lista de compras.
	 * 
	 * @return Inteiro com o valor final da lista de compras.
	 */
	public int getValorFinal() {
		return valorFinal;
	}

	/**
	 * Metodo acessor que alterra o valor final da lista de compras.
	 * 
	 * @param valorFinal
	 *            Inteiro com o novo valor final da lista de compras.
	 */
	public void setValorFinal(int valorFinal) {
		this.valorFinal = valorFinal;
	}

	/**
	 * Metodo responsavel por verificar se a lista de compras contem um determinado
	 * item.
	 * 
	 * @param nomeItem
	 *            Nome do item a ser procurado.
	 * @return valor boleano indicando se a lista de compras contem este item.
	 */
	public boolean contemItem(String nomeItem) {
		for (Compra compra : this.compras.values()) {
			if (compra.getItem().getNome().equals(nomeItem)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo responsavel por retornar uma Compra da lista de compras atraves do id
	 * do item associado.
	 * 
	 * @param id
	 *            Inteiro com o id do item associado a compra.
	 * @return retorna a Compra, se esta estiver na lista de compras.
	 */
	public Compra getCompra(Integer id) {
		for (Compra compra : this.compras.values()) {
			if (compra.getItem().getId().equals(id)) {
				return compra;
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por adicionar uma colecao de Compras a lista de compras.
	 * 
	 * @param maisComprados
	 */
	public void adicionaCompras(Map<Item, Integer> maisComprados) {
		for (Item item : maisComprados.keySet()) {
			this.adicionaCompraALista(maisComprados.get(item), item);
		}
	}

	/**
	 * Metodo responsaevl por verificar se o mapa com a lista de compras esta vazio
	 * ou nao.
	 * 
	 * @return valor boleano indicando se o mapa de lista de compras esta vazio ou
	 *         nao.
	 */
	public boolean isEmpty() {
		return this.compras.isEmpty();
	}

	/**
	 * Metodo acessor que retorna uma String com o local de compra.
	 * 
	 * @return String com o local de compra.
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Metodo acessor que retorna uma lista de Itens que estao presentes na lista de
	 * compras.
	 * 
	 * @return Lista com os Itens presentes nas compras da lista de compras.
	 */
	public List<Item> getItens() {
		List<Item> lista = new ArrayList<>();
		for (Compra c : this.compras.values()) {
			lista.add(c.getItem());
		}
		return lista;
	}
}
