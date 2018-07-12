package com.projeto.model;

import com.projeto.util.ValidadorSistema;

/**
 * Classe que representa um item no sistema.
 *
 */
public abstract class Item implements Comparable<Item>{

	/**
	 * Um inteiro representando a identificacao do item.
	 */
	private int id;
	
	/**
	 * Uma String representando o nome do item.
	 */
	private String nome;

	/**
	 * Uma String representando a qual categoria o item pertence.
	 */
	private String categoria;
	
	/**
	 * Controlador dos precos e respectivos locais de compras que um produto possui
	 */
	private PrecoController precoController;

	/**
	 * Metodo reponsavel por inicializar um item no sistema.
	 * 
	 * @param id : O identificador do item.
	 * @param nome : O nome do item.
	 * @param categoria : A categoria do item.
	 */
	public Item(int id, String nome, String categoria) {
		if (ValidadorSistema.validaItem(nome, categoria)) {
			this.id = id;
			this.nome = nome;
			this.categoria = categoria;
			this.precoController = new PrecoController();
		}
	}
	
	/**
	 * Metodo responsavel por invocar o controlador de precos para ser
	 * adicionado um novo local de compra ao produto.
	 * 
	 * @param local : Uma String representando um nome de um local para compra.
	 * @param preco : Um double representando o preco do produto no local indicado.
	 */
	public void adicionarLocalCompra(String local, Double preco) {
		this.precoController.adicionarLocalCompra(local, preco);
	}

	/**
	 * Metodo responsavel por gerar uma numeracao unica para um item de acordo com sua categoria e nome.
	 * 
	 * @return : Um inteiro que representa o item de maneira unica
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo responsavel por comparar dois objetos e verificar se ele e um item.
	 * Caso seja um item ele verifica se sao iguais de acordo com seu nome e categoria.
	 * 
	 * @return : um valor bolleano que indica se os objetos sao iguais ou nao
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Metodo acessivel que permite alteracao do nome do item.
	 * 
	 * @param nome : uma String que representa o nome do item.
	 */
	public void setNome(String nome) {
		if (ValidadorSistema.validaNome(nome)) {
			this.nome = nome;
		}
	}
	
	/**
	 * Metodo acessivel que permite a recuperacao do nome do item.
	 * 
	 * @return : uma String que representa o nome do item.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo acessivel que permite a recuperacao da categoria do item.
	 * 
	 * @return : uma String que representa a categoria do item.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Metodo acessivel que permite o acesso ao identificador do item.
	 * 
	 * @return : um inteiro que representa o identificador do item.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Metodo responsavel por gerar uma representacao textual para um item.
	 */
	@Override
	public String toString() {
		return this.id  + ". " + this.nome + ", " + this.categoria;
	}
	
	/**
	 * Metodo responsavel invocar o controlador de precos para
	 * a geracao da lista de locais de compra e precos
	 * 
	 * @return : uma String que representa o mapa de precos de um item.
	 */
	public String getListaPrecos() {
		return this.precoController.getListaPrecos();
	}

	/**
	 * Metodo acessivel que altera a categoria do item. 
	 * 
	 * @param categoria uma String que representa a nova categoria do item.
	 */
	public void setCategoria(String categoria) {
		if (ValidadorSistema.validaCategoria(categoria)) {
			this.categoria = categoria;
		}
	}

	/**
	 * Metodo responsavel por invocar o controlador de precos 
	 * para a recuperacao do menor preco
	 * 
	 * @return : numero em ponto flutuante correspondente ao menor preco.
	 */
	public double getMenorPreco() {
		return this.precoController.getMenorPreco();
	}
	
	/**
	 * Metodo responsavel por comparar dois itens a partir do nome.
	 */
	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.getNome());
	}

	
	/**
	 * Metodo abstrado reponsavel por obrigar as classes filhas a implementar uma atualizacao
	 * para os seus valores
	 * 
	 * @param atribulto : Nome do atribulto que sera atualizado
	 * @param novoValor : O novo valor que sera atribuido ao atribulto
	 * @return : O identificador do item
	 */
	public abstract int atualiza(String atribulto, String novoValor);
}
