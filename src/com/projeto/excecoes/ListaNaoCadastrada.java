package com.projeto.excecoes;

import com.projeto.util.Mensagem;

@SuppressWarnings("serial")
public class ListaNaoCadastrada extends RuntimeException{

	public ListaNaoCadastrada(String msg) {
		super(Mensagem.MSG_EXCECAO_ATUALIZA_COMPRA.get() + msg);
	}
}
