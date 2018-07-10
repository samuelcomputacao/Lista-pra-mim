package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

public class ComparaCadastro implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return item1.getId() - item2.getId();
	}

}
