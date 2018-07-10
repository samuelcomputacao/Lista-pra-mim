package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

/**
 * Classe Voltada para a comparação de dois itens atravez do seu menor preco
 */
public class ComparaValor implements Comparator<Item> {
	/**
	 * Metodo voltado para a comparacao de dois itens atravez dos seus precos
	 */
	@Override
	public int compare(Item arg0, Item arg1) {
		if (arg0.getMenorPreco() == arg1.getMenorPreco())
			return 0;
		else if (arg0.getMenorPreco() > arg1.getMenorPreco())
			return 1;
		else
			return -1;
	}

}
