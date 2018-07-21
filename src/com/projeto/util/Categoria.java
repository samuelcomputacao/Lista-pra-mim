package com.projeto.util;

public enum Categoria {
	
	HIGIENE_PERSOAL("higiene pessoal"),
	
	LIMPEZA("limpeza"),
	
	ALIMENTO_INDUSTRIALIZADO("alimento industrializado"),

	ALIMENTO_NAO_INDUSTRIALIZADO("alimento nao industrializado");
	
	private String valor;
	
	private Categoria(String valor) {
		this.valor = valor;
	}
	
	public String get() {
		return this.valor;
	}
	

}
