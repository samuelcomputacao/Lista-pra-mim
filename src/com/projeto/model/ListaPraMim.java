package com.projeto.model;

public interface ListaPraMim {
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida, String localCompra, double preco); 
	
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco);
	/**
	 * Metodo responsavel por adicionar um Item por unidade,
	 * @param nome : Nome do produto que sera adicionado.
	 * @param categoria : Categoria em que o produto que esta sendo adicionado sera classificado.
	 * @param unidade : Quantidade de itens que estao sendo adicionados.
	 * @param localCompra : Local onde o produto foi comprado.
	 * @param preco : Preco que o produto tem, por unidade.
	 * @return : Um inteiro indicando o identificador do item cadastrado
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco);
		
	public String exibeItem(Integer identificador);
	
	/**
	 * Metodo responsavel por atualizar um determinado atributo de um item do sistema
	 * @param identificador : Um inteiro indicando o identificador do item a ser atualizado
	 * @param atributo : Uma String indicanco o atributo do item que deve ser alterado
	 * @param novoValor : Uma string indicando o novo valor do atributo 
	 * @return : Um inteiro indicando o identificador do item atualizado
	 */
	public int atualizaItem(Integer identificador , String atributo, String novoValor );
	
	public void adicionaPrecoItem(Integer key ,String local,double preco);
	
	public void deletaItem(Integer identificador);
	
	public String getItem(int posicao);
	
	public String getItemPorCategoria(String categoria,int posicao);
	
	public String getItemPorPesquisa(String strPesquisa,int posicao);
	/**
	 * Metodo responsavel por retornar o item em determinada posicao. Para isso os itens estarao sendo classificados do menor preco ao maior preco 
	 * @param posicao : posicao em que o item sera recuperado
	 * @return : Representacao textual do item nessa posicao
	 */
	public String getItemPorMenorPreco(int posicao);
	
	
}
