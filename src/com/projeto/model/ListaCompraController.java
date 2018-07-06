package com.projeto.model;

import java.util.HashMap;
import java.util.Map;

public class ListaCompraController {
	
	private Map<Integer,Item> lista;
	private int identificadorBase;
	
	public ListaCompraController() {
		this.lista = new HashMap<>();
		this.identificadorBase = 1;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		
		//@ TODO implementar a adicao de itens
		return 0;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		//@ TODO implementar a adicao de itens
		return 0;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		//@ TODO implementar a adicao de itens
		return 0;
	}

	public int removerItem(Integer key) {
		// TODO implementar remoção de itens
		return 0;
	}

	public String exibeItem(Integer key) {
		// TODO implementar exibicao de itens
		return null;
	}

	public int atualizar(String atribulto, String novoValor) {
		// TODO implementar método para atualização de um item
		return 0;
	}

	public void adiciomaPrecoItem(String local, double preco) {
		// TODO implementar o adicionamento de precos a um item
		
	}

	public void deletaItem(Integer key) {
		// TODO implementar a remocao de itens
		
	}

	public String listarTodosItens() {
		// TODO implementar o listamento d todos os itens
		return null;
	}

	public String listarPorCategoria() {
		// TODO implementar os itens por categorias e ordenado pelo nome
		return null;
	}

	public String listarOrdemValor() {
		// TODO implementar os itens se eles possuirem valor cadastrado e ordenado em ordem crescente
		return null;
	}

	public String listarPorNome() {
		// TODO implementar os itens por nome e ordenado pelo nome
		return null;
	}


}
