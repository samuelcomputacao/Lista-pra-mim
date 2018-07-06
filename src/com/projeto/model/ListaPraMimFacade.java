package com.projeto.model;

public class ListaPraMimFacade implements ListaPraMim {
	
	private ListaCompraController listaCompraController;

	@Override
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		return this.listaCompraController.adicionaItemPorQtd(nome,categoria,quantidade,unidadeMedida, localCompra,preco);
	}

	@Override
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		return this.listaCompraController.adicionaItemPorQuilo(nome,categoria,quilo,localCompra,preco);
	}

	@Override
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
