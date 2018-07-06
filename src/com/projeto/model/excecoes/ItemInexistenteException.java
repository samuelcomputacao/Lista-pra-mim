package com.projeto.model.excecoes;

@SuppressWarnings("serial")
public class ItemInexistenteException extends RuntimeException {
	
	public ItemInexistenteException(String str) {
		super(str);
	}

}
