package com.projeto.util;

/**
 * Enum responavel por definir tipos de estrategias para feracao de listas automaticas no sistema
 *
 */
public enum Estrategia {

	/**
	 * Estrategia do tipo que repete a ultima lista cadatrada 
	 */
	ESTRATEGIA_1("Lista automatica 1"),
	
	/**
	 * Estrategia do tipo que repete a ultima lista cadastrada que contem uma determinada compra
	 */
	ESTRATEGIA_2("Lista automatica 2"),
	
	/**
	 * Estrategia que cria listas a partir de melhores precos em seus respectivos locais de compra
	 */
	ESTRATEGIA_3("Lista automatica 3");
	
	/**
	 * Valor textual de cada categoria
	 */
	private String valor;
	
	/**
	 * Inicializador da categoria
	 * @param valor : Valor tesxtual para a categoria
	 */
	private Estrategia(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Metodo responsavel por retornar o valor textual da categoria
	 * @return
	 */
	public String get() {
		return this.valor;
	}
}
