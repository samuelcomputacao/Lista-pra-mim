package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

public class ComparaCategoria implements Comparator<Item>{

	@Override
	public int compare(Item item1, Item item2) {
		return item1.getCategoria().compareTo(item2.getCategoria());
	}

}
