package com.projeto.model;

public class ListaPraMimFacade implements ListaPraMim {
	
	private ListaCompraController listaCompraController;
	
	public ListaPraMimFacade() {
		this.listaCompraController = new ListaCompraController();
	}

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
		return this.listaCompraController.adicionaItemPorUnidade(nome,categoria,unidade,localCompra,preco);
	}

	@Override
	public int removerItem(Integer key) {
		return this.listaCompraController.removerItem(key);
	}

	@Override
	public String exibeItem(Integer key) {
		return this.listaCompraController.exibeItem(key);
	}

	@Override
	public int atualizar(String atribulto, String novoValor) {
		return this.listaCompraController.atualizar(atribulto,novoValor);
	}

	@Override
	public void adicionaPrecoItem(String local, double preco) {
		this.listaCompraController.adiciomaPrecoItem(local,preco);
		
	}

	@Override
	public void deletaItem(Integer key) {
		this.listaCompraController.deletaItem(key);
	}

	@Override
	public String listarTodosItens() {
		return this.listaCompraController.listarTodosItens();
	}

	@Override
	public String listarPorCategoria() {
		return this.listaCompraController.listarPorCategoria();
	}

	@Override
	public String listarOrdemValor() {
		return this.listaCompraController.listarOrdemValor();
	}

	@Override
	public String listarPorNome() {
		return this.listaCompraController.listarPorNome();
	}
	
	

}
