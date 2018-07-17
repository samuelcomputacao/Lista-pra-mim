package com.projeto.model;

public class Compra {

	private Item item;

	private int quantidade;

	public Compra(Item item, int quantidade) {
		this.item = item;
		this.quantidade = quantidade;
	}

	public void atualizar(String operacao,int valor) {
		if(operacao.equals("adiciona"))
			this.quantidade += valor;
		else if (operacao.equals("diminui"))
			this.quantidade -= valor;	
	}
	public String getDescricao() {
		return this.quantidade + " " + item.getDescricao();
	}
	public int getQuantidade() {
		return this.quantidade;
	}
}
