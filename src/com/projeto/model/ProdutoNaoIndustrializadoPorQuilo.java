package com.projeto.model;

import com.projeto.util.ValidadorSistema;

public class ProdutoNaoIndustrializadoPorQuilo extends Item {

	/**
	 * Um double que representa a quantidade em quilos do produto.
	 */
	private double quilo;

	/**
	 * Construtor que constroi um produto nao industrializado por quilo atraves de
	 * um id, nome, categoria, qtd em quili, local de compra do produto e um preco.
	 * 
	 * @param id Um inteiro que representa o id do produto.
	 * @param nome Uma string que representa o nome do produto
	 * @param categoria Uma string que representa a categoria do produto.
	 * @param quilo Um double que representa a quantidade em quilos do produto.
	 * @param localCompra Uma string que representa o local de compra.
	 * @param preco Um double que representa o preco do produto.
	 */
	public ProdutoNaoIndustrializadoPorQuilo(int id, String nome, String categoria, double quilo, String localCompra, double preco) {
		super(id, nome, categoria);
		if (ValidadorSistema.validaProdutoNaoIndustrializadoPorQuilo(quilo, localCompra, preco,nome,categoria)) {
			this.quilo = quilo;
			super.adicionarLocalCompra(localCompra, preco);
		}
	}

	/**
	 * Metodo acessivel que retorna a quantidade em quilos do produto.
	 * 
	 * @return : Um double que representa a quantidade em quilos do produto.
	 */
	public double getQuilo() {
		return quilo;
	}

	/**
	 * Método que sobrescreve o toString.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Preco por quilo: " + super.getListaPrecos();
	}

	public void setQuilo(double quilo) {
		this.quilo = quilo;
	}

}
