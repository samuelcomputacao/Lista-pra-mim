package com.projeto.util;

public enum Estrategia {
	
	ESTRATEGIA_1("Lista automatica 1"),
	ESTRATEGIA_2("Lista automatica 2"),
	ESTRATEGIA_3("Lista automatica 3");
	
	private String valor;
	
	private Estrategia(String valor) {
		this.valor = valor;
	}
	
	public String get() {
		return this.valor;
	}
}
