package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.ListaDeCompras;

/**
 * Classe responsavel por comparar duas listas de compras de acordo com sua data de criacao
 *
 */
public class ComparaData implements Comparator<ListaDeCompras>{

	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		return lista1.getData().compareTo(lista2.getData());
	}

}
