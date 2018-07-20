package com.projeto.principal;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.projeto.controller.SistemaController;

import easyaccept.EasyAccept;

/**
 * Fachada do sistema responsavel pela delegacao de todos os metodos que o
 * sistema possui.
 */
public class ListaPraMimFacade implements ListaPraMim {

	/**
	 * Representa um sistema. eh nele onde estara os codigos que realizarao a
	 * funcionalidades.
	 */
	private SistemaController sistemaController;

	/**
	 * Metodo responsavel por inicializar a facade no sistema.
	 */
	public ListaPraMimFacade() {
		this.sistemaController = new SistemaController();
	}

	/**
	 * Metodo responsavel por adicionar um produto com quantidade fixa no mapa de
	 * produtos.
	 * 
	 * @param nome
	 *            : Nome do produto que sera adicionado.
	 * @param categoria
	 *            : Categoria em que o produto que esta sendo adicionado sera
	 *            classificado.
	 * @param quantidade
	 *            : Quantidade Um inteiro indicando a quantidade do produto
	 * @param unidadeMedida
	 *            : Unidade de medida do produto.
	 * @param localCompra
	 *            : Local onde o produto foi comprado.
	 * @param preco
	 *            : Preco que do produto.
	 * 
	 * @return Um inteiro indicando o identificador do item cadastrado.
	 */
	@Override
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		return this.sistemaController.adicionaItemPorQtd(nome, categoria, quantidade, unidadeMedida, localCompra, preco);
	}

	/**
	 * Metodo responsavel por adicionar um produto por unidade no mapa de produtos.
	 * 
	 * @param nome
	 *            : Nome do produto que sera adicionado.
	 * @param categoria
	 *            : Categoria em que o produto que esta sendo adicionado sera
	 *            classificado.
	 * @param quilo
	 *            : Um double indicando a quantidade em quilos do produto.
	 * @param localCompra
	 *            : Local onde o produto foi comprado.
	 * @param preco
	 *            : Preco que do produto.
	 * 
	 * @return Um inteiro indicando o identificador do item cadastrado.
	 */
	@Override
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco) {
		return this.sistemaController.adicionaItemPorQuilo(nome, categoria, quilo, localCompra, preco);
	}

	/**
	 * Metodo responsavel por adicionar um Item por unidade.
	 * 
	 * @param nome
	 *            : Nome do produto que sera adicionado.
	 * @param categoria
	 *            : Categoria em que o produto que esta sendo adicionado sera
	 *            classificado.
	 * @param unidade
	 *            : Quantidade de itens que estao sendo adicionados.
	 * @param localCompra
	 *            : Local onde o produto foi comprado.
	 * @param preco
	 *            : Preco que o produto tem, por unidade.
	 * 
	 * @return : Um inteiro indicando o identificador do item cadastrado.
	 */
	@Override
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco) {
		return this.sistemaController.adicionaItemPorUnidade(nome, categoria, unidade, localCompra, preco);
	}

	/**
	 * Metodo responsavel por exibir um item cadastrado no sistema.
	 * 
	 * @param identificador
	 *            Um inteiro indicando qual a chave do item.
	 * 
	 * @return Uma String com a representacao textual do item.
	 */
	@Override
	public String exibeItem(Integer key) {
		return this.sistemaController.exibeItem(key);
	}

	/**
	 * Metodo responsavel por atualizar um determinado atributo de um item do
	 * sistema
	 * 
	 * @param identificador
	 *            : Um inteiro indicando o identificador do item a ser atualizado
	 * @param atributo
	 *            : Uma String indicanco o atributo do item que deve ser alterado
	 * @param novoValor
	 *            : Uma string indicando o novo valor do atributo
	 * 
	 * @return : Um inteiro indicando o identificador do item atualizado
	 */
	@Override
	public int atualizaItem(Integer key, String atributo, String novoValor) {
		return this.sistemaController.atualizaItem(key, atributo, novoValor);
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
	@Override
	public void adicionaPrecoItem(Integer key, String local, double preco) {
		this.sistemaController.adicionaPrecoItem(key, local, preco);

	}

	/**
	 * Metodo responsavel por remover um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key
	 *            Um inteiro que representa o ID do item.
	 */
	@Override
	public void deletaItem(Integer key) {
		this.sistemaController.deletaItem(key);
	}

	/**
	 * Metodo responsavel por realizar os testes de aceitacao
	 */
	public static void main(String[] args) {
		args = new String[] { "com.projeto.principal.ListaPraMimFacade", "acceptance_test/use_case1.txt",
				"acceptance_test/use_case1_exception.txt", "acceptance_test/use_case2.txt",
				"acceptance_test/use_case2_exception.txt", "acceptance_test/use_case3.txt",
				"acceptance_test/use_case3_exception.txt","acceptance_test/use_case4.txt",
				"acceptance_test/use_case4_exception.txt"};
		EasyAccept.main(args);

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
	@Override
	public String getItem(int posicao) {
		return this.sistemaController.getItem(posicao);
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
	@Override
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.sistemaController.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo responsavel por retornar o item em determinada posicao. Para isso os
	 * itens estarao sendo classificados do menor preco ao maior preco
	 * 
	 * @param posicao
	 *            : Posicao em que o item sera recuperado
	 * @return : Representacao textual do item nessa posicao
	 */
	@Override
	public String getItemPorMenorPreco(int posicao) {
		return this.sistemaController.getItemPorMenorPreco(posicao);
	}

	/**
	 * Metodo responsavel por realizar a busca de um item de acordo com uma string
	 * de pesquisa
	 * 
	 * @param strPesquisa
	 *            : Uma String indicando a string utilizada como filtro
	 * @param posicao
	 *            : uma String indicando a posicao do item na lista ordenada e que
	 *            contem a string de pesquisa
	 * @return Uma string com a representacao textual do item que esta na posicao
	 *         informada
	 */
	@Override
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		return this.sistemaController.getItemPorPesquisa(strPesquisa, posicao);
	}

	/**
	 * Metodo responsavel por criar uma lista de compras com um nome
	 * 
	 * @param descritor
	 *            : Nome da lista de compras
	 */
	@Override
	public String adicionaListaDeCompras(String descritor) {
		return this.sistemaController.adicionaListaDeCompras(descritor);
	}

	/**
	 * Metodo responsavel por adicionar a uma lista de compras um item com uma certa
	 * quantidade.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param quantidade
	 *            : quantidade de itens que serao cadastrados.
	 * @param idItem
	 *            : id do item que sera adicionado na lista de compras.
	 */
	@Override
	public void adicionaCompraALista(String descritor, int quantidade, Integer idItem) {
		this.sistemaController.adicionaCompraALista(descritor, quantidade, idItem);
	}

	/**
	 * Metodo responsavel por finalizar uma lista de compras
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param localCompra
	 *            : Local onde as compras foram efetuadas.
	 * @param valorFinalCompra
	 *            : Valor final da compra.
	 */
	@Override
	public void finalizarListaDeCompras(String descritor, String localCompra, int valorFinalDaCompra) {
		this.sistemaController.finalizarListaDeCompras(descritor, localCompra, valorFinalDaCompra);

	}

	/**
	 * Metodo responsavel por pesquisar na lista de compras um determinado produto.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param idItem
	 *            : id do item que sera pesquisado na lista de compras.
	 *  @return Representacao textual do item que esta na lista. 
	 */
	@Override
	public String pesquisaCompraEmLista(String descritor, Integer idItem) {
		return this.sistemaController.pesquisaCompraEmLista(descritor, idItem);
	}

	/**
	 * Metodo responsavel retornar o item na posicao da lista.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param posicao
	 *            : posicao do item que sera pesquisado.
	 * @return representacao textual do item na posicao requerida.
	 */
	@Override
	public String getItemLista(String descritor, int posicao) {
		return this.sistemaController.getItemLista(descritor, posicao);
	}

	/**
	 * Metodo responsavel por verificar a existencia de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras que sera pesquisada.
	 *  @return O nome do descritor, se existir, e null caso nao exista.
	 */
	@Override
	public String pesquisaListaDeCompras(String descritor) {
		return this.sistemaController.pesquisaListaDeCompras(descritor);
	}
	/**
	 * Metodo responsavel por atualizar a quantidade de um item da lista de compras
	 * @param descritor :Nome do descritor em que sera feita a modificacao
	 * @param itemId : id do item que sera modificado
	 * @param operacao : operacao que o item sofrera
	 * @param quantidade : quantidade que o item ira mudar
	 */
	@Override
	public void atualizaCompraDeLista(String descritor, Integer itemId,String operacao,int quantidade) {
		this.sistemaController.atualizaCompraDeLista(descritor, itemId, operacao,quantidade);
	}
	/**
	 * Deleta uma compra de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Identificador da compra a ser deletada da lista de compras.
	 */
	@Override
	public void deletaCompraDeLista(String descritor, Integer idItem) {
		this.sistemaController.deletaCompraDeLista(descritor,idItem);
		
	}
	/**
	 * Retorna a data atual.
	 * 
	 * @return : Retorna a data atual.
	 */
	@Override
	public String dataAtual() {
		return this.sistemaController.dataAtual();
	}
	/**
	 * Retorna o descritor de uma lista de compras que foi cadastrada na data e
	 * posicao especificada.
	 * 
	 * @param data
	 *            : Data da criacao da lista de compras.
	 * @param posicao
	 *            : Posicao da lista de compras.
	 * 
	 * @return : Retorna o descritor da lista de compras.
	 */
	public String getItemListaPorData(String data, int posicao) {
		return this.sistemaController.getItemListaPorData(data, posicao);
	}
	
	/**
	 * Retorna a data e o descritor de uma lista de compras que foi contem o item
	 * com id e posicao especificada.
	 * 
	 * @param idItem
	 *            : Identificador do item da lista de compras.
	 * @param posicao
	 *            : Posicao da lista de compras.
	 * 
	 * @return : Retorna a data de criacao e o descritor da lista de compras.
	 */
	@Override
	public String getItemListaPorItem(Integer idItem, int posicao) {
		return this.sistemaController.getItemListaPorItem(idItem,posicao);
	}
	/**
	 * Retorna a pesquisa de listas de compras por data.
	 * @param data: data a ser pesquisada.
	 * @return representacao textual das listas de compra.
	 */
	@Override
	public String pesquisaListasDeComprasPorData(String data) {
		return this.sistemaController.pesquisaListasDeComprasPorData(data);
	}
	/**
	 * Retorna as listas que possuem tal produto.
	 * @param id :indentificador do produto.
	 * @return representacao textual das listas que contem o produto
	 */
	@Override
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.sistemaController.pesquisaListasDeComprasPorItem(id);
	}
}
