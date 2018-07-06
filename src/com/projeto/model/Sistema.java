package com.projeto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projeto.excecoes.ItemInexistenteException;

public class Sistema {

	private List<ListaDeCompra> listas;
	private Map<Integer, Item> produtos;
	private int identificadorBase;

	public Sistema() {
		this.listas = new ArrayList<>();
		this.identificadorBase = 1;
		this.produtos = new HashMap<>();
	}

	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {

		// @ TODO implementar a adicao de itens
		return 0;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		// @ TODO implementar a adicao de itens
		return 0;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		// @ TODO implementar a adicao de itens
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

	/**
	 * Metodo responsavel por atualizar um item na colecaoo de itens cadastrados no
	 * sistema
	 * 
	 * @param atribulto
	 *            : Uma String indicanco qual o campo que sera atualizado
	 * @param novoValor
	 *            : Uma String indicanco o novo valor que o capo ira assumir. Caso o
	 *            campo seja um valor numerico, esse valor deve ser transformado
	 *            antes de prosseguir.
	 * @return: Um Inteiro indicando o identificador do item atualizado
	 */
	public int atualizar(Integer key , String atribulto, String novoValor) {
		if(!produtos.containsKey(key)) throw new ItemInexistenteException("Erro na atualizacao de item: item nao existe.");
		Item item = produtos.get(key);
		switch (atribulto) {

		case "nome":
			item.setNome(novoValor);
			break;
		case "unidade de medida":
			
			break;
		case "quantidade":

			break;
		}
			
		return item.getId();
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
		// TODO implementar os itens se eles possuirem valor cadastrado e ordenado em
		// ordem crescente
		return null;
	}

	public String listarPorNome() {
		// TODO implementar os itens por nome e ordenado pelo nome
		return null;
	}

}
