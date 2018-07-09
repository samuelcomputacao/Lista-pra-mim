package com.projeto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.ItemInexistenteException;

public class Sistema {

	/**
	 * Uma lista com todas as listaDeCompras do sistema.
	 */
	private List<ListaDeCompra> listas;

	/**
	 * Um mapa com todos os produtos cadastrados pelo sistema.
	 */
	private Map<Integer, Item> produtos;

	/**
	 * Um inteiro que representa o id dos produtos que serao cadastrados no sistema.
	 */
	private int identificadorBase;

	public Sistema() {
		this.listas = new ArrayList<>();
		this.identificadorBase = 1;
		/**
		 * Mapa
		 */
		this.produtos = new HashMap<>();
	}

	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {

		// @ TODO implementar a adicao de itens
		return 0;
	}

	/**
	 * Metodo responsavel por adicionar um produto não industrilizado por quilo no
	 * mapa de produtos.
	 * 
	 * @param nome
	 *            Uma String indicando o nome do produto.
	 * @param categoria
	 *            Uma String indicando a categoria do produto.
	 * @param quilo
	 *            Um double indicando a quantidade em quilos do produto.
	 * @param localCompra
	 *            Uma String indicando o local de compra.
	 * @param preco
	 *            Um double indicando o preco produto.
	 * @return Um Inteiro indicando o identificador do item adicionado.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		
		return identificadorBase++;
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
	 * Metodo responsavel por atualizar um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param atributo
	 *            : Uma String indicando qual o campo que sera atualizado.
	 * @param novoValor
	 *            : Uma String indicando o novo valor que o capo ira assumir. Caso o
	 *            campo seja um valor numerico, esse valor deve ser transformado
	 *            antes de prosseguir.
	 * @return: Um Inteiro indicando o identificador do item atualizado.
	 */
	public int atualizar(Integer key, String atribulto, String novoValor) {
		if (!produtos.containsKey(key))
			throw new ItemInexistenteException("Erro na atualizacao de item: item nao existe.");
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
