package com.projeto.excecoes;

import com.projeto.util.SistemaMensagens;

@SuppressWarnings("serial")
public class ListaNaoCadastrada extends RuntimeException{

	public ListaNaoCadastrada(String msg) {
		super(SistemaMensagens.MSG_EXCECAO_ATUALIZA_COMPRA.get() + msg);
	}
}
