package com.projeto.excecoes;

public class CompraNaoCadastrada extends RuntimeException{

	public CompraNaoCadastrada(String msg) {
		super(msg + "compra nao encontrada na lista.");
	}
}
