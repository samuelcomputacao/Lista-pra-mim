package com.projeto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.ItemInexistenteException;
import com.projeto.util.ValidadorSistema;

public class Sistema {

	/**
	 * Uma lista com todas as listaDeCompras do sistema.
	 */
	//private List<ListaDeCompra> listas;

	/**
	 * Um mapa com todos os produtos cadastrados pelo sistema.
	 */
	private Map<Integer, Item> produtos;

	/**
	 * Um inteiro que representa o id dos produtos que serao cadastrados no sistema.
	 */
	private Integer identificadorBase;

	public Sistema() {
		//this.listas = new ArrayList<>();
		this.identificadorBase = 1;
		/**
		 * Mapa
		 */
		this.produtos = new HashMap<>();
	}

	/**
	 * Metodo responsavel por adicionar um produto com quantidade fixa no
	 * mapa de produtos.
	 * 
	 * @param nome : nome do produto.
	 * @param categoria : categoria do produto.
	 * @param unidadeMedida : unidade de medida do produto.
	 * @param localCompra : local de compra do produto.
	 * @param preco : preco do produto.
	 *            
	 * @return : retorna um inteiro representando o identificador do item adicionado.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida, String localCompra, double preco) {
		if(ValidadorSistema.validaItem(nome, categoria) && ValidadorSistema.validaProdutoQuantidadeFixa(quantidade, unidadeMedida, localCompra, preco)) {
			this.produtos.put(this.identificadorBase, new ProdutoQuantidadeFixa(this.identificadorBase, nome, categoria, quantidade, unidadeMedida, localCompra, preco));
			return this.identificadorBase++;
		}
		return 0;
	}

	/**
	 * Metodo responsavel por adicionar um produto não industrializado por quilo no
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
		if (ValidadorSistema.validaProdutoNaoIndustrializadoPorQuilo(quilo, localCompra, preco,nome,categoria)) {
			this.produtos.put(this.identificadorBase, new ProdutoNaoIndustrializadoPorQuilo(this.identificadorBase, nome, categoria, quilo, localCompra, preco));
			return this.identificadorBase++;
		}
		return -1;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		if(ValidadorSistema.validaProdutoPorUnidade(nome,unidade, categoria, localCompra,preco)) {
			this.produtos.put(this.identificadorBase, new ProdutoPorUnidade(this.identificadorBase, nome, categoria, unidade, localCompra, preco));
			return this.identificadorBase++;
					
		}
		return 0;
	}

	public int removerItem(Integer key) {
		// TODO implementar remoção de itens
		return 0;
	}

	public String exibeItem(Integer key) {
		if(key <= 0) {
			throw new CampoInvalidoException("Erro na listagem de item: id invalido.");
		}
		if(!this.produtos.containsKey(key)) {
			throw new ItemInexistenteException("Erro na listagem de item: item nao existe.");
		}
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
	public int atualizaItem(Integer key, String atribulto, String novoValor) {
		System.out.println(imprimeSet(produtos.keySet()));
		if (!produtos.containsKey(key))
			throw new ItemInexistenteException("Erro na atualizacao de item: item nao existe.");
		Item item = produtos.get(key);
		switch (atribulto) {
		case "nome":
			item.setNome(novoValor);
			break;
		case "unidade de medida":
			ProdutoQuantidadeFixa fixa  = (ProdutoQuantidadeFixa) item;
			fixa.setUnidadeDeMedida(novoValor);
			break;
		case "quantidade":
			fixa  = (ProdutoQuantidadeFixa) item;
			fixa.setQuantidade(Integer.parseInt(novoValor));
			break;
		default:
			throw new CampoInvalidoException("Erro na atualizacao de item: atributo nao existe.");
		}

		return item.getId();
	}

	private String imprimeSet(Set<Integer> keySet) {
		String r= "";
		for(Integer i : keySet) {
			r += " "+i;
		}
		return r;
	}

	public void adiciomaPrecoItem(String local, double preco) {
		// TODO implementar o adicionamento de precos a um item

	}

	/**
	 * Metodo responsavel por remover um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key Um inteiro que representa o ID do item.
	 */
	public void deletaItem(Integer key) {
		if (!this.produtos.containsKey(key)) {
			throw new ItemInexistenteException("Erro na remoção de item: item nao existe.");
		}
		this.produtos.remove(key);
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
