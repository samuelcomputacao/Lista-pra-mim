package com.projeto.model.excecoes;

@SuppressWarnings("serial")
public class CampoInvalidoException extends RuntimeException {
	
	public CampoInvalidoException(String str) {
		super(str);
	}

}
