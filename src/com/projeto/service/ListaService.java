package com.projeto.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projeto.comparadores.ComparaData;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.model.Compra;
import com.projeto.model.Estabelecimento;
import com.projeto.model.Item;
import com.projeto.model.ListaDeCompra;
import com.projeto.util.Estrategia;
import com.projeto.util.Mensagem;
import com.projeto.util.ValidadorSistema;

/**
 * Classe responsavel por realizar os servicos de listas.
 *
 */
public class ListaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134795757559679940L;

	/**
	 * Uma lista com todas as listaDeCompras do sistema.
	 */
	private Map<String, ListaDeCompra> listas;

	/**
	 * Metodo inicicializador do servico de sistema
	 */
	public ListaService() {
		this.listas = new HashMap<>();
	}

	/**
	 * Metodo responsavel por criar uma lista de compras com um nome. Alem disso,
	 * nao permite que descritores de listas de compras sejam repetidos.
	 * 
	 * @param descritor
	 *            : descritor da lista de compras
	 * @return representacao textual do nome do descritor
	 */
	public String adicionaListaDeCompras(String descritor) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_CRIACAO_COMPRA.get());
		ValidadorSistema.validaExistenciaDeListaDeCompras(descritor, this.listas,
				Mensagem.MSG_EXCECAO_CRIACAO_COMPRA.get());

		this.listas.put(descritor, new ListaDeCompra(descritor));
		return descritor;
	}

	/**
	 * Metodo responsavel por adicionar a uma lista de compras um item com uma certa
	 * quantidade.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param quantidade
	 *            : quantidade de itens que serao cadastrados.
	 * @param idItem
	 *            : id do item que sera adicionado na lista de compras.
	 */
	public void adicionaCompraALista(String descritor, int quantidade, Item item) {
		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		listaDeCompra.adicionaCompraALista(quantidade, item);
	}

	/**
	 * Metodo responsavel por finalizar uma lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param localCompra
	 *            : Local onde as compras foram efetuadas.
	 * @param valorFinalCompra
	 *            : Valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritor, String localCompra, int valorFinalDaCompra) {

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		listaDeCompra.finalizar(localCompra, valorFinalDaCompra);

	}

	/**
	 * Metodo responsavel por pesquisar na lista de compras um determinado produto.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param idItem
	 *            : id do item que sera pesquisado na lista de compras.
	 * @return Representacao textual do item que esta na lista.
	 */
	public String pesquisaCompraEmLista(String descritor, Integer idItem) {
		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		return listaDeCompra.pesquisaCompraEmLista(idItem);
	}

	/**
	 * Metodo responsavel por atualizar um produto da lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param idItem
	 *            : id do item que sera atualizado na lista de compras.
	 * @param quantidade
	 *            : nova quantidae de itens.
	 */
	public void atualizaCompraDeLista(String descritorLista, Integer idItem, String operacao, int quantidade) {
		ListaDeCompra listaDeCompra = this.listas.get(descritorLista);
		listaDeCompra.atualizaCompraDeLista(idItem, operacao, quantidade);
	}

	/**
	 * Metodo responsavel retornar o item na posicao da lista.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param posicao
	 *            : posicao do item que sera pesquisado.
	 * @return representacao textual do item na posicao requerida.
	 */

	public String getItemLista(String descritor, int posicao) {
		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		return listaDeCompra.getItemLista(posicao);
	}

	/**
	 * Metodo responsavel por pesquisar uma lista de compras atraves de um
	 * descritor.
	 * 
	 * @param descritor
	 *            : Descritor da compras que sera pesquisada.
	 * @return String com o toString da compra pesquisada.
	 */
	public String pesquisaListaDeCompras(String descritor) {
		ValidadorSistema.validaInexistenciaDeListaDeCompras(descritor, this.listas,
				Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());
		return this.listas.get(descritor).toString();
	}

	/**
	 * Deleta uma compra de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Identificador da compra a ser deletada da lista de compras.
	 */
	public void deletaCompraDeLista(String descritor, Integer idItem) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_EXCLUSAO_COMPRA.get());

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		listaDeCompra.deletaCompraDeLista(idItem);

	}

	/**
	 * Retorna o descritor de uma lista de compras que foi cadastrada na data e
	 * posicao especificada.
	 * 
	 * @param data
	 *            : Data da criacao da lista de compras.
	 * @param posicao
	 *            : Posicao da lista de compras.
	 * 
	 * @return : Retorna o descritor da lista de compras.
	 */
	public String getItemListaPorData(String dataString, int posicao) {
		try {

			Date data = formataData(dataString);
			List<ListaDeCompra> lista = buscaPorData(data);
			Collections.sort(lista);
			return lista.get(posicao).getDescritor();
		} catch (

		ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Metodo auxiliar criado para formatar a data.
	 * 
	 * @param dataString
	 *            Data a ser formatada
	 * @return Data no formato de data dd/MM/yyyy
	 * @throws ParseException
	 */
	private Date formataData(String dataString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dataString);
		return date;
	}

	/**
	 * Metodo responsavel por buscar listas que possuem tal data
	 * 
	 * @param data
	 *            Lista com Todas as compras que foram efetuadas nessa data
	 * @return Lista de lista de compras
	 */
	private List<ListaDeCompra> buscaPorData(Date data) {
		List<ListaDeCompra> lista = new ArrayList<>();
		for (ListaDeCompra list : this.listas.values()) {
			if (list.getDataFormatada().equals(data)) {
				lista.add(list);
			}
		}
		return lista;
	}

	/**
	 * Retorna a data e o descritor de uma lista de compras que foi contem o item
	 * com id e posicao especificada.
	 * 
	 * @param idItem
	 *            : Identificador do item da lista de compras.
	 * @param posicao
	 *            : Posicao da lista de compras.
	 * 
	 * @return : Retorna a data de criacao e o descritor da lista de compras.
	 */
	public String getItemListaPorItem(Integer idItem, int posicao) {
		List<ListaDeCompra> lista = buscaPorItem(idItem);
		Collections.sort(lista);
		ListaDeCompra listaCompra = lista.get(posicao);
		String retorno = listaCompra.getDataTextual() + " - " + listaCompra.getDescritor();
		return retorno;
	}

	/**
	 * Metodo auxiliar criado para retornar uma lista que tem um item dentro dela
	 * 
	 * @param idItem
	 *            Id do item que sera pesquisado
	 * @return Lista de lista de compras
	 */
	private List<ListaDeCompra> buscaPorItem(Integer idItem) {
		List<ListaDeCompra> lista = new ArrayList<>();
		for (ListaDeCompra list : this.listas.values()) {
			if (list.possuiCompra(idItem)) {
				lista.add(list);
			}
		}
		return lista;
	}

	/**
	 * Retorna a pesquisa de listas de compras por data.
	 * 
	 * @param data:
	 *            data a ser pesquisada.
	 * @return representacao textual das listas de compra.
	 */
	public String pesquisaListasDeComprasPorData(String dataString) {
		try {
			if (ValidadorSistema.validaData(dataString)) {

				Date data = formataData(dataString);
				for (ListaDeCompra lista : listas.values()) {
					if (lista.getData().equals(data)) {
						return lista.buscaTodosItens();
					}
				}
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get() + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retorna as listas que possuem tal produto.
	 * 
	 * @param id
	 *            :indentificador do produto.
	 * @return representacao textual das listas que contem o produto
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		String volta = "";
		for (ListaDeCompra lista : listas.values()) {
			if (lista.possuiCompra(id)) {
				volta += lista.getDescritor() + System.lineSeparator();
			}
		}
		ValidadorSistema.validaSaidaVazia(volta);
		return volta;
	}

	/**
	 * Metodo responsavel por gerar automaticamente o dia da ultima lista que foi
	 * cadastrada.
	 * 
	 * @return : representacao textual do dia em que foi realizada a ultima compra
	 */
	public String geraAutomaticaUltimaLista(String dataAtual) {
		ListaDeCompra lista = getUltimaLista();
		String descritor = Estrategia.ESTRATEGIA_1.get() + " " + dataAtual;
		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.setCompras(lista.getCompras());
		listaDeCompra.setValorFinal(lista.getValorFinal());
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo responsavel por retornar a ultima lista de compra realizada.
	 * 
	 * @return Lista de compra
	 */
	private ListaDeCompra getUltimaLista() {
		List<ListaDeCompra> lista = new ArrayList<>(this.listas.values());
		Collections.sort(lista, new ComparaData());
		return lista.get(lista.size() - 1);
	}

	/**
	 * Metodo responsavel por gerar automaticamente o dia da ultima compra em que o
	 * item foi cadastrado.
	 * 
	 * @param descritorItem
	 *            : Item a ser procurado.
	 * @return representacao textual do ultimo dia em que o item foi comprado.
	 */
	public String geraAutomaticaItem(String descritorItem, String dataAtual) {
		ListaDeCompra lista = getUltimaLista(descritorItem);
		ValidadorSistema.validaListaDeCompra(lista);

		String descritor = Estrategia.ESTRATEGIA_2.get() + " " + dataAtual;

		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.setCompras(lista.getCompras());
		listaDeCompra.setValorFinal(lista.getValorFinal());
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo responsavel por retornar uma lista que contem um respectivo item.
	 * 
	 * @param nomeItem
	 *            : Nome do Item a ser procurado nas listas.
	 * @return Lista de compras que contem o item.
	 */
	private ListaDeCompra getUltimaLista(String nomeItem) {
		List<ListaDeCompra> lista = new ArrayList<>(this.listas.values());
		Collections.sort(lista, new ComparaData());
		ListaDeCompra listaDeCompra = null;
		for (int i = lista.size() - 1; i >= 0; i--) {
			listaDeCompra = lista.get(i);
			if (listaDeCompra.contemItem(nomeItem)) {
				return listaDeCompra;
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por Gerar automaticamente o dia em que a lista possui
	 * compras que mais aparecem nas listas de compras anteriores.
	 * 
	 * @param itens
	 * 
	 * @return representacao textual do dia em que a lista ocorre.
	 */
	public String geraAutomaticaItensMaisPresentes(Collection<Item> itens, String dataAtual) {
		Map<Item, Integer> maisComprados = buscaMaisComprados(itens);

		String descritor = Estrategia.ESTRATEGIA_3.get() + " " + dataAtual;
		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.adicionaCompras(maisComprados);
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo auxiliar responsavel por retornar os itens mais comprados
	 * 
	 * @param itens
	 * 
	 * @return Mapa contendo os itens
	 */
	private Map<Item, Integer> buscaMaisComprados(Collection<Item> itens) {
		Map<Item, Integer> maisComprados = new HashMap<>();

		for (Item item : itens) {
			List<Compra> compraQuePossue = listasQuePossui(item);
			if (compraQuePossue.size() >= (this.listas.size() / 2)) {
				Integer quantidade = calculaTotal(compraQuePossue);
				quantidade = (int) Math.floor(quantidade / compraQuePossue.size());
				maisComprados.put(item, quantidade);

			}
		}
		return maisComprados;
	}

	/**
	 * Metodo auxiliar que serve para calcular o valor total das compras.
	 * 
	 * @param compraQuePossue
	 *            Lista que contem as compras.
	 * @return inteiro representando a soma total.
	 */
	private int calculaTotal(List<Compra> compraQuePossue) {
		int quantidade = 0;
		for (Compra compra : compraQuePossue) {
			quantidade += compra.getQuantidade();
		}
		return quantidade;
	}

	/**
	 * Metodo responsavel por verificar se um item existe nas listas de compras.
	 * 
	 * @param item
	 *            :Item a ser pesquisado.
	 * @return Lista contendo as compras que possuem tal item.
	 */
	private List<Compra> listasQuePossui(Item item) {
		List<Compra> compras = new ArrayList<>();

		for (ListaDeCompra lista : this.listas.values()) {
			Compra compra = lista.getCompra(item.getId());
			if (compra != null) {
				compras.add(compra);
			}
		}
		return compras;
	}

	public String sugereMelhorEstabelecimento(String descritor, int posicaoEstabelecimento, int posicaoLista) {

		if (!this.listas.containsKey(descritor)) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_DADOS_INSUFICIENTES.get());
		}
		ListaDeCompra lista = this.listas.get(descritor);
		Map<String, Estabelecimento> estabelecimentos = buscaLocais(lista);
		List<Estabelecimento> listaEstabelecimentos = new ArrayList<>(estabelecimentos.values());
		Collections.sort(listaEstabelecimentos);
		if (posicaoLista == 0) {
			if (posicaoEstabelecimento >= listaEstabelecimentos.size()) {
				throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_DADOS_INSUFICIENTES.get());
			}
			return listaEstabelecimentos.get(posicaoEstabelecimento).toString();
		} else {
			Estabelecimento estabelecimento = listaEstabelecimentos.get(posicaoEstabelecimento);
			Collections.sort(estabelecimento.getCompras());
			if (posicaoLista - 1 >= estabelecimento.getCompras().size()) {
				return "";
			}
			return estabelecimento.getCompras().get(posicaoLista - 1).toString();
		}
	}

	private Map<String, Estabelecimento> buscaLocais(ListaDeCompra lista) {
		Map<String, Estabelecimento> locais = new HashMap<>();

		for (Compra c : lista.getCompras().values()) {
			Item item = c.getItem();
			Map<String, Double> precos = item.getPrecos();
			for (String key : precos.keySet()) {
				if (locais.containsKey(key)) {
					locais.get(key).add(c, precos.get(key) * c.getQuantidade());
				} else {
					locais.put(key, new Estabelecimento(key));
					locais.get(key).add(c, precos.get(key) * c.getQuantidade());
				}
			}
		}
		return locais;
	}

	public List<Item> getItens(String descritor) {
		ListaDeCompra lista = this.listas.get(descritor);
		return lista.getItens();
	}

}
