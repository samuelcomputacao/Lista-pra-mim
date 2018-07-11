package com.projeto.excecoes;

/**
 * Excecao lancada quando se tenta cadastrar um item ja cadastrado
 */
@SuppressWarnings("serial")
public class ItemJaExisteException extends RuntimeException{
	
	/**
	 * Metodo responsavel por lancar a excecao e chamar a excecao mae
	 * 
	 * @param msg Uma String que indica a mensagem que sera mostrada pela excecao
	 */
	public ItemJaExisteException(String msg) {
		super(msg);
	}

}
