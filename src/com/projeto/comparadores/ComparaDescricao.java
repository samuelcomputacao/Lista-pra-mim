package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

/**
 * Comparador que compara dois item de acordo com o seu nome (descricao) 
 * 
 */
public class ComparaDescricao implements Comparator<Item> {

	/**
	 * Metodo responsavel pela comparacao
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}

}
