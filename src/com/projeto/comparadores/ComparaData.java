package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.ListaDeCompras;

public class ComparaData implements Comparator<ListaDeCompras>{

	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		return lista1.getData().compareTo(lista2.getData());
	}

}
