package com.projeto.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.projeto.excecoes.CampoInvalidoException;

public class ListaDeCompra {

	/**
	 * Representa o descritor da lista de compras.
	 */
	private String descritor;

	private Date dataCriacao;

	private Map<Integer, Compra> compras;

	private boolean finalizada;

	private String local;

	private int valorFinal;

	/**
	 * Constroi uma listaDeCompras a partir de um descritor.
	 * 
	 * @param descritor
	 *            String que representa o descritor da lista de compras.
	 */
	public ListaDeCompra(String descritor) {
		this.dataCriacao = new Date();
		this.descritor = descritor;
		compras = new HashMap<>();
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
		Compra compra = new Compra(item, quantidade);
		this.compras.put(item.getId(), compra);
	}

	/**
	 * Metodo que atualiza a quantidade de itens de uma compra na lista de compras.
	 * Remove um produto da lista de compras se a quantidade for menor que 1.
	 * 
	 * @param idItem
	 *            id do produto.
	 * @param operacao
	 *            operacao a ser realizada: "adiciona" ou "diminui".
	 * @param quantidade
	 *            qtd a ser removida ou adicionada no atributo quantidade.
	 */
	public void atualizaCompraDeLista(Integer idItem, String operacao, int quantidade) {
		this.compras.get(idItem).atualizar(operacao, quantidade);
		if (this.compras.get(idItem).getQuantidade() <= 0)
			this.compras.remove(idItem);
	}

	public String getItemLista(int posicao) {

		return null;
	}

	public String pesquisaCompraEmLista(Integer idItem) {
		try {
			return this.compras.get(idItem).getDescricao();
		} catch (NullPointerException e) {
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
	}

	public void finalizar(String local, int valorFinal) {
		this.local = local;
		this.finalizada = true;
		this.valorFinal = valorFinal;
	}

	/**
	 * Metodo que verifica se uma listaDeCompras foi finalizada.
	 * 
	 * @return valor boleano indicando se foi finalidada ou nao.
	 */
	public boolean isFinalizada() {
		return this.finalizada;
	}
}
