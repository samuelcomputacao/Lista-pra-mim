package com.projeto.excecoes;

@SuppressWarnings("serial")
public class CategoriaInexistenteException extends RuntimeException{
	
	public CategoriaInexistenteException(String msg) {
		super(msg + "categoria nao existe.");
	}

}
