package com.projeto.excecoes;

@SuppressWarnings("serial")
public class CampoInvalidoException extends RuntimeException {
	
	public CampoInvalidoException(String str) {
		super(str);
	}

}
