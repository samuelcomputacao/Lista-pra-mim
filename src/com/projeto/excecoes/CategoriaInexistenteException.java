package com.projeto.excecoes;

/**
 * Excecao lancada quando e passada como parametro uma categoria que nao existe
 */
@SuppressWarnings("serial")
public class CategoriaInexistenteException extends RuntimeException{
	
	/**
	 * Metodo responsavel por inicializar a excecao e chamar a excecao mae
	 * 
	 * @param msg : Uma String com a mensagem exibida pela excecao
	 */
	public CategoriaInexistenteException(String msg) {
		super(msg + "categoria nao existe.");
	}
	
	public CategoriaInexistenteException() {
	}

}
