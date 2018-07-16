package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

/**
 * Classe que compara dois item atraves dos seus nomes.
 */
public class ComparaNome implements Comparator<Item> {

	/**
	 * Método que compara dois itens baseado no nome dos mesmos.
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}

}
