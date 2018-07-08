package com.projeto.model;

public class ProdutoQuantidadeFixa extends Item {
	
	private double quilo;
	
	private String localCompra;
	
	private Object preco;
	
	
	public ProdutoQuantidadeFixa(int id, String nome, String categoria, double quilo, String localCompra, 
			double preco) {
		super(id, nome, categoria);
		this.quilo = quilo;
		this.localCompra = localCompra;
		this.preco = preco;
	}
	
	public double getQuilo() {
		return quilo;
	}
	
	public String localCompra() {
		return localCompra;
	}
	
	public Object getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return this.getId() + ". " + this.getNome() + ", " + this.getCategoria()
		+ ", Preco: " + this.getPreco() + "<AINDA FALTA IMPLEMENTAR>";
	}

}
