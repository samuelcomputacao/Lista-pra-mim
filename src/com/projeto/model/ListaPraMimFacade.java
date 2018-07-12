package com.projeto.model;

import easyaccept.EasyAccept;

/**
 * Fachada do sistema responsavel pela delegacao de todos os metodos que o sistema possui.
 */
public class ListaPraMimFacade implements ListaPraMim {
	
	/**
	 * Representa um sistema. eh nele onde estara os codigos que realizarao a funcionalidades. 
	 */
	private Sistema sistema;
	
	/**
	 * Metodo responsavel por inicializar a facade no sistema.
	 */
	public ListaPraMimFacade() {
		this.sistema = new Sistema();
	}

	@Override
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		return this.sistema.adicionaItemPorQtd(nome, categoria, quantidade, unidadeMedida, localCompra, preco);
	}

	/**
	 * Sobrescreve o metodo adicionaItemPorQuilo.
	 */
	@Override
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		return this.sistema.adicionaItemPorQuilo(nome, categoria, quilo, localCompra, preco);
	}
	/**
	 * Metodo responsavel por adicionar um Item por unidade,
	 * @param nome : Nome do produto que sera adicionado.
	 * @param categoria : Categoria em que o produto que esta sendo adicionado sera classificado.
	 * @param unidade : Quantidade de itens que estao sendo adicionados.
	 * @param localCompra : Local onde o produto foi comprado.
	 * @param preco : Preco que o produto tem, por unidade.
	 * @return : Um inteiro indicando o identificador do item cadastrado
	 */
	@Override
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		return this.sistema.adicionaItemPorUnidade(nome, categoria, unidade, localCompra, preco);
	}

	@Override
	public String exibeItem(Integer key) {
		return this.sistema.exibeItem(key);
	}

	/**
	 * Metodo responsavel por atualizar um determinado atributo de um item do sistema.
	 * 
	 * @param identificador : um inteiro indicando o identificador do item a ser atualizado
	 * @param atributo : uma String indicanco o atributo do item que deve ser alerado
	 * @param novoValor : uma string indicando o novo valor do atributo 
	 * @return : um inteiro indicando o identificador do item atualizado
	 */
	@Override
	public int atualizaItem(Integer key,String atributo, String novoValor) {
		return this.sistema.atualizaItem(key, atributo, novoValor);
	}

	@Override
	public void adicionaPrecoItem(Integer key,String local, double preco) {
		this.sistema.adicionaPrecoItem(key,local, preco);
		
	}

	@Override
	public void deletaItem(Integer key) {
		this.sistema.deletaItem(key);
	}	
	
	public static void main(String[] args) {
		args = new String[]{"com.projeto.model.ListaPraMimFacade","acceptance_test/use_case1.txt","acceptance_test/use_case1_exception.txt","acceptance_test/use_case2.txt","acceptance_test/use_case2_exception.txt"};
		EasyAccept.main(args);
		
	}

	@Override
	public String getItem(int posicao) {
		return this.sistema.getItem(posicao);
	}

	@Override
	public String getItemPorCategoria(String categoria,int posicao) {
		return this.sistema.getItemPorCategoria(categoria, posicao);
	}
	/**
	 * Metodo responsavel por retornar o item em determinada posicao. Para isso os itens estarao sendo classificados do menor preco ao maior preco 
	 * @param posicao : posicao em que o item sera recuperado
	 * @return : Representacao textual do item nessa posicao
	 */
	@Override
	public String getItemPorMenorPreco (int posicao) {
		return this.sistema.getItemPorMenorPreco(posicao);
	}
	
	@Override
	public String getItemPorPesquisa(String strPesquisa, int posicao) { 
		return this.sistema.getItemPorPesquisa(strPesquisa,posicao);
	}
	

	

}
