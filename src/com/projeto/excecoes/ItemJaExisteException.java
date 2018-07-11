package com.projeto.excecoes;

@SuppressWarnings("serial")
public class ItemJaExisteException extends RuntimeException{
	
	public ItemJaExisteException(String msg) {
		super(msg);
	}

}
