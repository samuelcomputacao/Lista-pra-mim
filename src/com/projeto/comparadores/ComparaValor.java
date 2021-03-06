package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

/**
 * Classe Voltada para a comparacao de dois itens atraves do seu menor preco.
 */
public class ComparaValor implements Comparator<Item> {
	
	/**
	 * Metodo voltado para a comparacao de dois itens atraves dos seus respectivos precos.
	 */
	@Override
	public int compare(Item item1, Item item2) {
		if (item1.getMenorPreco() == item2.getMenorPreco())
			return 0;
		else if (item1.getMenorPreco() > item2.getMenorPreco())
			return 1;
		else
			return -1;
	}

}
