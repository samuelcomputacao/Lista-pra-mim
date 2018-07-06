package com.projeto.model;

public class ProdutoQuantidadeFixa extends Item{
	
	private int quantidade;
	
	private String medida;
	

	public ProdutoQuantidadeFixa(int identificadorBase, String nome, String categoria, int quantidade,String medida, String localCompra, double preco) {
		super(identificadorBase, nome, categoria);
		this.quantidade = quantidade;
		this.medida = medida;
	}
	
	
	
	
	

}
