package com.projeto.excecoes;

/**
 * Excecao lancada quando e pedido um item que ainda
 * nao foi cadastrado no sistema
 *
 */
@SuppressWarnings("serial")
public class ItemInexistenteException extends RuntimeException {

	/**
	 * Metodo resposavel por inicializar a excecao 
	 * e chamar a excecao mae
	 * 
	 * @param str : Uma String que representa a mensagem que sera exibida
	 * pela excecao
	 */
	public ItemInexistenteException(String str) {
		super(str);
	}
	
	/**
	 * Inicializador da excecao que nao recebe mensagens para exibicao quando a excecao for
	 * lancada
	 */
	public ItemInexistenteException() {
	}

}
