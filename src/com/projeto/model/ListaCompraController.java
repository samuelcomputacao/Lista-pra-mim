package com.projeto.model;

import java.util.Map;

public class ListaCompraController {
	
	private Map<Integer,Item> lista;
	private int identificadorBase;

	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		ProdutoQuantidadeFixa produtoQuantidadeFixa = new ProdutoQuantidadeFixa(identificadorBase,nome,categoria,quantidade,unidadeMedida,localCompra,preco);
		lista.put(identificadorBase, produtoQuantidadeFixa);
		identificadorBase++;
		return identificadorBase-1;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		
		return 0;
	}


}
