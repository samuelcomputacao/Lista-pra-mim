package com.projeto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projeto.comparadores.ComparaValor;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.excecoes.ItemInexistenteException;
import com.projeto.excecoes.ItemJaExisteException;
import com.projeto.util.SistemaMensagens;
import com.projeto.util.ValidadorSistema;

/**
 * Classe que representa o sistema. Ela e responsavel por realizar grande parte
 * das funcionalidades do sistema.
 *
 */
public class Sistema {

	/**
	 * Uma lista com todas as listaDeCompras do sistema.
	 */
	// private List<ListaDeCompra> listas;

	/**
	 * Um mapa com todos os produtos cadastrados pelo sistema.
	 */
	private Map<Integer, Item> produtos;

	/**
	 * Um inteiro que representa o id dos produtos que serao cadastrados no sistema.
	 */
	private Integer identificadorBase;

	public Sistema() {
		// this.listas = new ArrayList<>();
		this.identificadorBase = 1;
		/**
		 * Mapa
		 */
		this.produtos = new HashMap<>();
	}

	/**
	 * Metodo responsavel por adicionar um produto com quantidade fixa no mapa de
	 * produtos.
	 * 
	 * @param nome
	 *            : nome do produto.
	 * @param categoria
	 *            : categoria do produto.
	 * @param unidadeMedida
	 *            : unidade de medida do produto.
	 * @param localCompra
	 *            : local de compra do produto.
	 * @param preco
	 *            : preco do produto.
	 *            
	 *@param quantidade :Um inteiro indicando a quantidade do produto
	 * 
	 * @return : retorna um inteiro representando o identificador do item
	 *         adicionado.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		try {
			if (ValidadorSistema.validaItem(nome, categoria)
					&& ValidadorSistema.validaProdutoQuantidadeFixa(quantidade, unidadeMedida, localCompra, preco)) {
				ProdutoQuantidadeFixa produto = new ProdutoQuantidadeFixa(this.identificadorBase, nome,categoria, quantidade, unidadeMedida, localCompra, preco);
				
				if(produtos.containsValue(produto)) {
					throw new ItemJaExisteException("Item ja cadastrado");
				}
				
				this.produtos.put(this.identificadorBase, produto);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTRO + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(SistemaMensagens.MSG_EXCECAO_CADASTRO);
		}
		return -1;
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
		try {
			if (ValidadorSistema.validaItem(nome, categoria)
					&& ValidadorSistema.validaProdutoNaoIndustrializadoPorQuilo(quilo, localCompra, preco)) {
				ProdutoNaoIndustrializadoPorQuilo produto = new ProdutoNaoIndustrializadoPorQuilo(this.identificadorBase,nome, categoria, quilo, localCompra, preco);
				
				if(produtos.containsValue(produto)) {
					throw new ItemJaExisteException("Item ja cadastrado");
				}
				this.produtos.put(this.identificadorBase, produto);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTRO + e.getMessage());
		}catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(SistemaMensagens.MSG_EXCECAO_CADASTRO);
		}
		return -1;
	}

	/**
	 * Metodo responsavel por adicionar um produto por unidade no mapa de produtos.
	 * 
	 * @param nome
	 *            Uma String indicando o nome do produto.
	 * @param categoria
	 *            Uma String indicando a categoria do produto.
	 * @param unidade
	 *            Um Inteiro indicando a quantidade de unidades.
	 * @param localCompra
	 *            Uma String indicando o local de compra.
	 * @param preco
	 *            Um double indicando o preco produto.
	 * @return Um Inteiro indicando o identificador do item adicionado.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		try {
			if (ValidadorSistema.validaItem(nome, categoria)
					&& ValidadorSistema.validaProdutoPorUnidade(unidade, localCompra, preco)) {
				ProdutoPorUnidade porUnidade = new ProdutoPorUnidade(this.identificadorBase, nome, categoria, unidade, localCompra, preco);
				if(produtos.containsValue(porUnidade)) {
					throw new ItemJaExisteException("Item ja cadastrado");
				}
				this.produtos.put(this.identificadorBase,porUnidade);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTRO + e.getMessage());
		}catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(SistemaMensagens.MSG_EXCECAO_CADASTRO);
		}
		return -1;
	}

	/**
	 * Metodo responsavel por exibir um item que esta previamente cadastrado no
	 * sistema
	 * 
	 * @param key
	 *            : Um inteiro indicando qual a chave do item
	 * @return : Uma String com a representacao textual do item
	 */
	public String exibeItem(Integer key) {
		
		if (key <= 0) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_LISTA_ITEM + "id invalido.");
		}
		if (!this.produtos.containsKey(key)) {
			throw new ItemInexistenteException(SistemaMensagens.MSG_EXCECAO_LISTA_ITEM);
		}
		return this.produtos.get(key).toString();
	}

	/**
	 * Metodo responsavel por atualizar um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key : Um inteiro indicando a chave do item onde sera adicionado
	 * o novo valor.
	 * @param atribulto
	 *            Uma String indicando qual o campo que sera atualizado.
	 * @param novoValor
	 *            Uma String indicando o novo valor que o capo ira assumir. Caso o
	 *            campo seja um valor numerico, esse valor deve ser transformado
	 *            antes de prosseguir.
	 * @return : Um Inteiro indicando o identificador do item atualizado.
	 */
	public int atualizaItem(Integer key, String atribulto, String novoValor) {
		
		if (atribulto == null || atribulto.trim().isEmpty())
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "atributo nao pode ser vazio ou nulo.");
		if (novoValor == null || novoValor.trim().isEmpty())
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "novo valor de atributo nao pode ser vazio ou nulo.");

		if (!produtos.containsKey(key))
			throw new ItemInexistenteException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM);
		Item item = produtos.get(key);
		switch (atribulto) {
		case "nome":
			item.setNome(novoValor);
			break;
		case "unidade de medida":
			ProdutoQuantidadeFixa fixa = (ProdutoQuantidadeFixa) item;
			fixa.setUnidadeDeMedida(novoValor);
			break;
		case "quantidade":
			int quantidade = Integer.parseInt(novoValor);
			if (quantidade < 0) {
				throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "valor de quantidade nao pode ser menor que zero.");
			}
			fixa = (ProdutoQuantidadeFixa) item;
			fixa.setQuantidade(Integer.parseInt(novoValor));
			break;
		case "kg":
			double quilos = Double.parseDouble(novoValor);
			if (quilos < 0) {
				throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "valor de quilos nao pode ser menor que zero.");
			}
			ProdutoNaoIndustrializadoPorQuilo quilo = (ProdutoNaoIndustrializadoPorQuilo) item;
			quilo.setQuilo(quilos);
			break;
		case "unidade":
			int unidades = Integer.parseInt(novoValor);
			if (unidades < 0) {
				throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "valor de unidade nao pode ser menor que zero.");
			}
			ProdutoPorUnidade produto = (ProdutoPorUnidade) item;
			produto.setUnidade(unidades);
			break;
		case "categoria":
			String categoria = novoValor;
			try {
			if (ValidadorSistema.validaCategoria(categoria)) {
				item.setCategoria(novoValor);
			}
			}catch (CategoriaInexistenteException e) {
				throw new CategoriaInexistenteException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM);
			}
			break;
		default:
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_ATUALIZA_ITEM + "atributo nao existe.");
		}

		return item.getId();
	}

	/**
	 * Metodo responsavel por adicionar um preco relacionado a um determinado local
	 * a um produto
	 * 
	 * @param key
	 *            : Um inteiro que indica a chave do item onde o preco sera
	 *            adicionado
	 * @param local
	 *            : Uma string que indica o local de compra que possui o preco
	 *            indicado
	 * @param preco
	 *            : Um valor de ponto flutuante que indica o preco que sera
	 *            adicionado
	 */
	public void adicionaPrecoItem(Integer key, String local, double preco) {
		
		if (key < 0) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTO_PRECO + "id de item invalido.");
		}
		if (!this.produtos.containsKey(key)) {
			throw new ItemInexistenteException(SistemaMensagens.MSG_EXCECAO_CADASTO_PRECO);
		}
		if (local == null || local.trim().isEmpty()) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTO_PRECO + "local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_CADASTO_PRECO + "preco de item invalido.");
		}
		Item item = this.produtos.get(key);
		item.adicionarLocalCompra(local, preco);

	}

	/**
	 * Metodo responsavel por remover um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key
	 *            Um inteiro que representa o ID do item.
	 */
	public void deletaItem(Integer key) {
		if (!this.produtos.containsKey(key)) {
			throw new ItemInexistenteException("Erro na remoção de item: item nao existe.");
		}
		this.produtos.remove(key);
	}

	/**
	 * Metodo responsavel por buscar um item de acordo com uma posicao de forma que
	 * ele esteja ordenado pelo nome
	 * 
	 * @param position
	 *            : Um inteiro indicando a posicao do item na lista de itens
	 *            ordenada pelo nome
	 * @return : Uma String com a representacao textual do item selecionado
	 */
	public String getItem(int position) {
		List<Item> itens = new ArrayList<Item>(this.produtos.values());
		Collections.sort(itens);
		if (itens.isEmpty() || position >= itens.size()) {
			return "";
		}
		return itens.get(position).toString();
	}

	/**
	 * Metodo responsavel por buscar um item de acordo com uma posicao na lista de
	 * itens ordenados pelo nome e que tenha a ctegoria indicada
	 * 
	 * @param categoria
	 *            : Uma String indicando qual a categoria usada que sera utilizada
	 *            no filtro
	 * @param posicao
	 *            : Um inteiro indicando a posicao do item na lista ordenada
	 * @return Uma String com a representacao textual do item selecionado
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		try {
			if (ValidadorSistema.validaCategoria(categoria)) {
				List<Item> itens = new ArrayList<Item>();
				for (Item item : produtos.values()) {
					if (item.getCategoria().equals(categoria)) {
						itens.add(item);
					}
				}
				if (!itens.isEmpty() && posicao < itens.size()) {

					Collections.sort(itens);
					return itens.get(posicao).toString();
				}
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(SistemaMensagens.MSG_EXCECAO_LISTA_ITEM + e.getMessage());
		}catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(SistemaMensagens.MSG_EXCECAO_LISTA_ITEM);
		}
		return "";

	}

	/**
	 * Metodo responsavel pela busca de um item quando a lista de itens esta ordendo
	 * pelo preco de forma crescente
	 * 
	 * @param posicao
	 *            : Um inteiro que representa a posicao do item na lista de itens
	 *            ordenados pelo preco
	 * @return Uma string com a representacao textual do item indicado
	 */
	public String getItemPorMenorPreco(int posicao) {
		if (posicao >= this.produtos.size()) {
			return "";
		}
		ArrayList<Item> itens = new ArrayList<>();
		itens.addAll(produtos.values());
		Collections.sort(itens, new ComparaValor());
		return itens.get(posicao).toString();
	}

	/**
	 * Metodo responsavel por realizar a busca de um item de acordo com uma string de pesquisa
	 * 
	 * @param strPesquisa : Uma String indicando a string utilizada como filtro
	 * @param posicao : uma String indicando a posicao do item na lista ordenada
	 *  e que contem a string de pesquisa
	 * @return Uma string com a representacao textual do item que esta na posicao informada
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		List<Item> itens = new ArrayList<Item>();
		for (Item item : produtos.values()) {
			if (item.getNome().toLowerCase().contains(strPesquisa.toLowerCase())) {
				itens.add(item);
			}
		}
		if (!itens.isEmpty() && posicao < itens.size()) {

			Collections.sort(itens);
			return itens.get(posicao).toString();
		}
		return "";
	}
}
