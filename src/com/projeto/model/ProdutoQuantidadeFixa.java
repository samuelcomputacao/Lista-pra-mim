package com.projeto.model;

import com.projeto.util.ValidadorSistema;

/**
 * Representa um produto que possui uma quantidade fixa. Todo produto com quantidade 
 * fixa possui um id, nome, categoria, quantidade, unidade de medida, local de compra 
 * e um preço.
 *
 */

public class ProdutoQuantidadeFixa extends Item {
	
	/**
	 * Quantidade de um produto.
	 */
	private int quantidade;
	
	/**
	 * Unidade de medida do produto.
	 */
	private String unidadeMedida;
	
	/**
	 * Contrói um produto por quantidade fixa a partir do nome, categoria, quantidade, 
	 * unidade de medida, local de compra e preco.
	 * 
	 * @param id : identificador único de um produto.
	 * @param nome : nome do produto.
	 * @param categoria : categoria do produto. (higiene pessoal, alimentos nao industrializados ou alimentos industrializados)
	 * @param quantidade : quantidade do produto.
	 * @param unidadeMedida : unidade de medida do produto.
	 * @param localCompra : local de compra do produto.
	 * @param preco : preco do produto
	 */
	public ProdutoQuantidadeFixa(int id, String nome, String categoria, int quantidade, String unidadeMedida, String localCompra,
			double preco) {
		super(id, nome, categoria);
		if(ValidadorSistema.validaProdutoQuantidadeFixa(quantidade, unidadeMedida, localCompra, preco)) {
			this.quantidade = quantidade;
			this.unidadeMedida = unidadeMedida;
			super.adicionarLocalCompra(localCompra, preco);
		}
	}
	
	/**
	 * Retorna a quantidade do produto.
	 * 
	 * @return : retorna a quantidade do produto.
	 */
	public int getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Retorna a unidade de medida do produto.
	 * 
	 * @return : retorna a unidade de medida do produto.
	 */
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	
	/**
	 * Representação String de um produto por quantidade fixa.
	 */
	@Override
	public String toString() {
		return super.toString() + ", " + this.quantidade + " " + this.unidadeMedida + ", Preco: " + super.getListaPrecos(); 
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeMedida =  unidadeDeMedida;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
