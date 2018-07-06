package com.projeto.model;

import java.util.HashMap;
import java.util.Map;

/**Classe que representa um item no sistema
*
*/
public abstract class Item {
	
	private int id;
	
	private String nome;
	
	private String categoria;
	
	private Map<String,Double> mapaPrecos;


	public Item(int id, String nome, String categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.mapaPrecos = new HashMap<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

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
	
	
	
	
}
