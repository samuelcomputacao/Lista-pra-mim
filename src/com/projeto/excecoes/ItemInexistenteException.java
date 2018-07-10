package com.projeto.excecoes;

@SuppressWarnings("serial")
public class ItemInexistenteException extends RuntimeException {
	
	public ItemInexistenteException(String str) {
		super(str+"item nao existe.");
	}

}
