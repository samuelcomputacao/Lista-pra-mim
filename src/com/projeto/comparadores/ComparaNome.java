package com.projeto.comparadores;

import java.util.Comparator;

import com.projeto.model.Compra;

/**
 * Classe que compara dois item atraves dos seus nomes.
 */
public class ComparaNome implements Comparator<Compra> {

	/**
	 * Método que compara dois itens baseado no nome dos mesmos.
	 */
	@Override
	public int compare(Compra compra1, Compra compra2) {
		return compra1.getItem().getNome().compareTo(compra2.getItem().getNome());
	}

}
