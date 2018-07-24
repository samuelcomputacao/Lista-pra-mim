package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Compra;

/**
 * Classe que compara dois item atraves das suas categorias
 */
public class ComparaCategoria implements Comparator<Compra> {

	/**
	 * Método que compara dois itens baseado na categoria dos mesmos.
	 */
	@Override
	public int compare(Compra compra1, Compra compra2) {
		return compra2.getItem().getCategoria().compareTo(compra1.getItem().getCategoria());
	}

}
