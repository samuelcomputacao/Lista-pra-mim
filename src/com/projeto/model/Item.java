package com.projeto.model;

import java.util.HashMap;
import java.util.Map;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.util.ValidadorSistema;

/**Classe que representa um item no sistema
*
*/
public abstract class Item {

	/**
	 * Um inteiro representando a identificacao do item
	 */
	private int id;
	
	/**
	 * Uma String representando o nome do item
	 */
	private String nome;
	
	/**
	 * Uma String representando a qual categoria o item pertence
	 */
	private String categoria;
	
	/**
	 * Uma mapa de precos onde estao guardados locais e respectivos precos do item compravel
	 */
	private Map<String, Double> mapaPrecos;


	/**
	 * Método reponsável por inicializar um item no sistema
	 * @param id : O identificador do item
	 * @param nome : O nome do item
	 * @param categoria : A categoria do item
	 */
	public Item(int id, String nome, String categoria) {
		if (ValidadorSistema.validaItem(nome, categoria)) {
			this.id = id;
			this.nome = nome;
			this.categoria = categoria;
			this.mapaPrecos = new HashMap<>();
		}
	}
	
	/**
	 * Método responsável por adicionar ao mapa de locais de compra um novo local de compra do produto.
	 * @param local : Uma String representando um nome de um local para compra
	 * @param preco : Um double representando o preco do produto no local indicado
	 */
	public void adicionarLocalCompra(String local, Double preco) {
		if (preco <= 0) {
			throw new CampoInvalidoException("Erro no cadastro de item: preco de item invalido.");
		}
		mapaPrecos.put(local, preco);
	}

	/**
	 * Metodo responsavel por gerar uma numeracao unica para um item de acordo com sua categoria e nome
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
	 * @return Um valor bolleano que indica se os objetos sao iguais ou nao
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
	 * Metodo acessivel que permite alteracao do nome do item
	 * @param nome : Uma String que representa o nome do item
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo acessivel que permite a recuperacao do nome do item
	 * @return : Uma String que representa o nome do item
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo acessivel que permite a recuperacao da categoria do item
	 * @return : Uma String que representa a categoria do item
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Metodo acessivel que permite o acesso ao identificador do item
	 * @return : Um inteiro que representa o identificador do item
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Metodo que sobrescreve o toString
	 */
	@Override
	public String toString() {
		return this.id  + ". " + this.nome + ", " + this.categoria;
	}
	
	/**
	 * ######### Metodo com falha, corrigir depois...
	 * Metodo responsavel por gerar uma String do mapa de precos
	 * 
	 * @return Uma String que representa o mapa de precos de um item
	 */
	public String getListaPrecos() {
		String msg = "<";
		for (String local : this.mapaPrecos.keySet()) {
			msg += local + ", R$ " + String.format("%.2f", this.mapaPrecos.get(local));
		}
		msg += ">";
		return msg;
	}
}
