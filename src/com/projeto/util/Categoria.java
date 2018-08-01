package com.projeto.util;

/**
 * Enum responsavel por definir tipos de categorias
 *
 */
public enum Categoria {

	/**
	 * Categoria do tipo higiene persoal
	 */
	HIGIENE_PERSOAL("higiene pessoal"),
	
	/**
	 * Categoria do tipo limpeza
	 */
	LIMPEZA("limpeza"),
	
	/**
	 * Categoria do tipo alimento industrializado
	 */
	ALIMENTO_INDUSTRIALIZADO("alimento industrializado"),

	/**
	 * Categoria do tipo alimento nao industrializado
	 */
	ALIMENTO_NAO_INDUSTRIALIZADO("alimento nao industrializado");
	
	/**
	 * Uma string cotendo o valor de cada categoria
	 */
	private String valor;
	
	/**
	 * Construtor interno para a geracao dos valores
	  * @param valor : Uma STring contendo o valor da categoria
	 */
	private Categoria(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo responsavel por retornar o valor da categoria
	 * @return
	 */
	public String get() {
		return this.valor;
	}
	

}
