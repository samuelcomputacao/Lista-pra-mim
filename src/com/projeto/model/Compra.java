package com.projeto.model;

public  class Compra {
	

	private Integer idItem;
	
	private int quantidade;
	
	public Compra(Integer iditem,int quantidade) {
		this.idItem = idItem;
		this.quantidade = quantidade;
	}
	
	
	public  void atualizar(int valor) {
		this.quantidade =  valor;
	}
	

}
