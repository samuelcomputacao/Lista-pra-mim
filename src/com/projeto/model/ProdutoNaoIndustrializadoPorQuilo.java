package com.projeto.model;

import com.projeto.util.ValidadorSistema;

/**
 * 
 * Classe que representa uma um produto nao industrializado por quilo (subclasse
 * de da classe Item).
 *
 */
public class ProdutoNaoIndustrializadoPorQuilo extends Item {

	/**
	 * Um double que representa a quantidade em quilos do produto.
	 */
	private double quilo;

	/**
	 * Construtor que constroi um produto nao industrializado por quilo atraves de
	 * um id, nome, categoria, qtd em quilos, local de compra do produto e um preco.
	 * 
	 * @param id
	 *            : um inteiro que representa o id do produto.
	 * @param nome
	 *            : uma string que representa o nome do produto.
	 * @param categoria
	 *            : uma string que representa a categoria do produto.
	 * @param quilo
	 *            : um double que representa a quantidade em quilos do produto.
	 * @param localCompra
	 *            : uma string que representa o local de compra.
	 * @param preco
	 *            : um double que representa o preco do produto.
	 */
	public ProdutoNaoIndustrializadoPorQuilo(int id, String nome, String categoria, double quilo, String localCompra,
			double preco) {
		super(id, nome, categoria);
		if (ValidadorSistema.validaProdutoNaoIndustrializadoPorQuilo(quilo, localCompra, preco)) {
			this.quilo = quilo;
			super.adicionarLocalCompra(localCompra, preco);
		}
	}

	/**
	 * Metodo acessivel que retorna a quantidade em quilos do produto.
	 * 
	 * @return : um double que representa a quantidade em quilos do produto.
	 */
	public double getQuilo() {
		return quilo;
	}

	/**
	 * Metodo acessivel que altera a quantidade de quilos do produto.
	 * 
	 * @param quilo
	 *            um double que representa a quantidade em quilos do produto.
	 */
	public void setQuilo(double quilo) {
		if (ValidadorSistema.validaQuilo(quilo)) {
			this.quilo = quilo;
		}
	}

	/**
	 * Método que sobrescreve o toString.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Preco por quilo: " + super.getListaPrecos();
	}
}
