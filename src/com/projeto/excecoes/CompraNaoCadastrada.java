package com.projeto.excecoes;

public class CompraNaoCadastrada extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1450645015826308585L;

	public CompraNaoCadastrada(String msg) {
		super(msg + "compra nao encontrada na lista.");
	}
}
