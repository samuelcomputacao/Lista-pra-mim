package com.projeto.excecoes;

import com.projeto.util.Mensagem;

/**
 * Excecao que sera lancada quando houver alguma operacao envolvendo uma lista de compra que ainda nao foi cadastrada
 *
 */
@SuppressWarnings("serial")
public class ListaNaoCadastrada extends RuntimeException{

	/**
	 * Metodo responsavel por inicializar a excecao
	 * @param msg  : Uma String que sera enviada como mensagem da excecao
	 */
	public ListaNaoCadastrada(String msg) {
		super(Mensagem.MSG_EXCECAO_ATUALIZA_COMPRA.get() + msg);
	}
}
