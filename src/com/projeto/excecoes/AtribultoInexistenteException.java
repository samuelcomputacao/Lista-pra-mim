package com.projeto.excecoes;

/**
 * Classe responsavel por lancar uma excecao quando um atribulto e inexistente
 *
 */
@SuppressWarnings("serial")
public class AtribultoInexistenteException extends RuntimeException{

	/**
	 * Inicializador da excecao que recebe uma mensagem
	 * @param msg : Mensagem que sera exibida quando a excecao for 
	 * lancada
	 */
	public AtribultoInexistenteException(String msg) {
		super(msg+"atributo nao existe.");
	}
	
	/**
	 * Inicializador da excecao que nao recebe mensagens para exibicao quando a excecao for
	 * lancada
	 */
	public AtribultoInexistenteException() {
	}

}
