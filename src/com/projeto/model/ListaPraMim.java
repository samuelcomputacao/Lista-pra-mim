package com.projeto.model;

public interface ListaPraMim {
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida, String localCompra, double preco); 
	
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco);
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco);
	
	public int removerItem(Integer identificador);
	
	public String exibeItem(Integer identificador);
	
	/**
	 * Metodo responsavel por atualizar um determinado atribulto de um item do sistema
	 * @param identificador : Um inteiro indicando o identificador do item a ser atualizado
	 * @param atribulto : Uma String indicanco o atribulto do item que deve ser alerado
	 * @param novoValor : Uma string indicando o novo valor do atribulto 
	 * @return : Um inteiro indicando o identificador do item atualizado
	 */
	public int atualizar(Integer identificador , String atribulto, String novoValor );
	
	public void adicionaPrecoItem(String local,double preco);
	
	public void deletaItem(Integer identificador);
	
	public String listarTodosItens();
	
	public String listarPorCategoria();
	
	public String listarOrdemValor();
	
	public String listarPorNome();
	
	
}
