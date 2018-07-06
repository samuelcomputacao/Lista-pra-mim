package com.projeto.model;

public interface ListaPraMim {
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida, String localCompra, double preco); 
	
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco);
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco);
	
	public int removerItem(Integer key);
	
	public String exibeItem(Integer key);
	
	public int atualizar(String atribulto, String novoValor );
	
	public void adicionaPrecoItem(String local,double preco);
	
	public void deletaItem(Integer key);
	
	public String listarTodosItens();
	
	public String listarPorCategoria();
	
	public String listarOrdemValor();
	
	public String listarPorNome();
	
	
}
