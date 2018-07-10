package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Item;

public class ComparaValor implements Comparator<Item>{

	@Override
	public int compare(Item arg0, Item arg1) {
		if(arg0.getMenorPreco() == arg1.getMenorPreco())
			return 0;
		else if (arg0.getMenorPreco() > arg1.getMenorPreco())
			return 1;
		else
			return -1;
	}

}
