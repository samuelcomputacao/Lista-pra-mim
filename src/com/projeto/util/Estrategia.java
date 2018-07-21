package com.projeto.util;

public enum Estrategia {
	
	ESTRATEGIA_1("Lista automática 1"),
	ESTRATEGIA_2("Lista automática 2"),
	ESTRATEGIA_3("Lista automática 3");
	
	private String valor;
	
	private Estrategia(String valor) {
		this.valor = valor;
	}
	
	public String get() {
		return this.valor;
	}
}
