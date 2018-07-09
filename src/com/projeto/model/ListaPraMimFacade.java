package com.projeto.model;

import easyaccept.EasyAccept;

public class ListaPraMimFacade implements ListaPraMim {
	
	private Sistema sistema;
	
	public ListaPraMimFacade() {
		this.sistema = new Sistema();
	}

	@Override
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		return this.sistema.adicionaItemPorQtd(nome, categoria, quantidade, unidadeMedida, localCompra, preco);
	}

	@Override
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		return this.sistema.adicionaItemPorQuilo(nome, categoria, quilo, localCompra, preco);
	}

	@Override
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		return this.sistema.adicionaItemPorUnidade(nome, categoria, unidade, localCompra, preco);
	}

	@Override
	public int removerItem(Integer key) {
		return this.sistema.removerItem(key);
	}

	@Override
	public String exibeItem(Integer key) {
		return this.sistema.exibeItem(key);
	}

	/**
	 * Metodo responsavel por atualizar um determinado atributo de um item do sistema
	 * @param identificador : Um inteiro indicando o identificador do item a ser atualizado
	 * @param atributo : Uma String indicanco o atributo do item que deve ser alerado
	 * @param novoValor : Uma string indicando o novo valor do atributo 
	 * @return : Um inteiro indicando o identificador do item atualizado
	 */
	@Override
	public int atualizar(Integer key,String atributo, String novoValor) {
		return this.sistema.atualizar(key, atributo, novoValor);
	}

	@Override
	public void adicionaPrecoItem(String local, double preco) {
		this.sistema.adiciomaPrecoItem(local, preco);
		
	}

	@Override
	public void deletaItem(Integer key) {
		this.sistema.deletaItem(key);
	}

	@Override
	public String listarTodosItens() {
		return this.sistema.listarTodosItens();
	}

	@Override
	public String listarPorCategoria() {
		return this.sistema.listarPorCategoria();
	}

	@Override
	public String listarOrdemValor() {
		return this.sistema.listarOrdemValor();
	}

	@Override
	public String listarPorNome() {
		return this.sistema.listarPorNome();
	}
	
	
	public static void main(String[] args) {
		args = new String[]{"com.projeto.model.ListaPraMimFacade","acceptance_test/use_case1_exception.txt"};
		EasyAccept.main(args);
		
	}
	

}
