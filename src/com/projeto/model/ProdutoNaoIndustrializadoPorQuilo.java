package com.projeto.model;

public class ProdutoNaoIndustrializadoPorQuilo extends Item {

	/**
	 * Um double que representa a quantidade em quilos do produto.
	 */
	private double quilo;

	/**
	 * Uma String que representa o local de compra.
	 */
	private String localCompra;

	/**
	 * Preco do produto.
	 */
	private Object preco;

	/**
	 * Construtor que constroi um produto nao industrializado por quilo atraves de
	 * um id, nome, categoria, qtd em quili, local de compra do produto e um preco.
	 * 
	 * @param id
	 *            Um inteiro que representa o id do produto.
	 * @param nome
	 *            Uma string que representa o nome do produto
	 * @param categoria
	 *            Uma string que representa a categoria do produto.
	 * @param quilo
	 *            Um double que representa a quantidade em quilos do produto.
	 * @param localCompra
	 *            Uma string que representa o local de compra.
	 * @param preco
	 *            Um double que representa o preco do produto.
	 */
	public ProdutoNaoIndustrializadoPorQuilo(int id, String nome, String categoria, double quilo, String localCompra,
			double preco) {
		super(id, nome, categoria);
		this.quilo = quilo;
		this.localCompra = localCompra;
		this.preco = preco;
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
	 * Metodo acessivel que retorna o local de compra do produto.
	 * 
	 * @return : Uma String que representa o local de compra do produto.
	 */
	public String getLocalCompra() {
		return localCompra;
	}

	/**
	 * Metodo acessivel que retorna o preco do produto.
	 * 
	 * @return : 
	 */
	public Object getPreco() {
		return preco;
	}

	/**
	 * Método qeu sobrescreve o toString.
	 */
	@Override
	public String toString() {
		return this.getId() + ". " + this.getNome() + ", " + this.getCategoria()
				+ ", Preco por quilo: <AINDA FALTA IMPLEMENTAR>";
	}

}
