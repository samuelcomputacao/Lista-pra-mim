package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

/**
 * Classe que compara dois item atraves das suas categorias
 */
public class ComparaCategoria implements Comparator<Item> {

	/**
	 * Método que compara dois itens baseado na categoria dos mesmos.
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getCategoria().compareTo(item2.getCategoria());
	}

}
