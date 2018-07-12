package com.projeto.excecoes;

/**
 * Excecao lancada quando e passado algum campo invalido 
 * no sistema
 *
 */
@SuppressWarnings("serial")
public class CampoInvalidoException extends RuntimeException {

	/**
	 * Metodo responsavel por inicializar a excecao e chamar a excecao mae
	 * 
	 * @param str : Uma String que representa a mendagem que sera exibida 
	 * pela excecao
	 */
	public CampoInvalidoException(String str) {
		super(str);
	}
	
	public CampoInvalidoException() {
	}

}
