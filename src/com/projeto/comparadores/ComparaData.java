package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.ListaDeCompra;

public class ComparaData implements Comparator<ListaDeCompra>{

	@Override
	public int compare(ListaDeCompra lista1, ListaDeCompra lista2) {
		return lista1.getData().compareTo(lista2.getData());
	}

}
