package com.projeto.excecoes;

@SuppressWarnings("serial")
public class AtribultoInexistenteException extends RuntimeException{
	
	public AtribultoInexistenteException(String msg) {
		super(msg+"atributo nao existe.");
	}
	public AtribultoInexistenteException() {
	}

}
