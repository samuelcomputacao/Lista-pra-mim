package com.projeto.model;

public class ProdutoQuantidadeFixa extends Item {
	
	private int quantidade;
	
	private String unidadeMedida;
	
	public ProdutoQuantidadeFixa(int id, String nome, String categoria, int quantidade, String unidadeMedida, String localCompra,
			double preco) {
		super(id, nome, categoria);
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		super.adicionarLocalCompra(localCompra, preco);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + this.quantidade + " " + this.unidadeMedida + ", Preco: " + super.getListaPrecos(); 
	}

}
