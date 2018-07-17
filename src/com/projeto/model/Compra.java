package com.projeto.model;

/**
 * Representa uma Compra. Toda compra possui um Item e a sua quantidade.
 * 
 */
public class Compra {

	/**
	 * Item associado a compra.
	 */
	private Item item;

	/**
	 * Quantidade do item.
	 */
	private int quantidade;

	/**
	 * Controi uma compra a partir de um produto e a quantidade do mesmo.
	 * 
	 * @param item
	 *            uma instancia de Item.
	 * @param quantidade
	 *            int representando a qtd de itens.
	 */
	public Compra(Item item, int quantidade) {
		this.item = item;
		this.quantidade = quantidade;
	}

	/**
	 * Método que atualiza a quantidade de itens de um compra de um determinado
	 * item.
	 * 
	 * @param operacao
	 *            operacao a ser realizada: "adiciona" ou "diminui".
	 * @param quantidade
	 *            qtd a ser removida ou adicionada no atributo quantidade.
	 */
	public void atualizar(String operacao, int quantidade) {
		if (operacao.equals("adiciona"))
			this.quantidade += quantidade;
		else if (operacao.equals("diminui"))
			this.quantidade -= quantidade;
	}

	/**
	 * Metodo que retorna uma String com a quantidade de itens da compra junto com a
	 * descricao do item.
	 * 
	 * @return String representando a descricao da compra.
	 */
	public String getDescricao() {
		return this.quantidade + " " + item.getDescricao();
	}

	/**
	 * Metodo que retorna a quantidade de itens da compra.
	 * 
	 * @return int representando a quantidade de itens da compra.
	 */
	public int getQuantidade() {
		return this.quantidade;
	}
}
