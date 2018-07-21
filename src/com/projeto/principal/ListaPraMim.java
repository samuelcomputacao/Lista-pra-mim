package com.projeto.principal;

import java.util.Date;

import com.projeto.model.ListaDeCompra;

public interface ListaPraMim {

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
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco);

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
	public int adicionaItemPorQuilo(String nome, String categoria, double quilo, String localCompra, double preco);

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
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localCompra, double preco);

	/**
	 * Metodo responsavel por exibir um item cadastrado no sistema.
	 * 
	 * @param identificador
	 *            Um inteiro indicando qual a chave do item.
	 * 
	 * @return Uma String com a representacao textual do item.
	 */
	public String exibeItem(Integer identificador);

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
	public int atualizaItem(Integer identificador, String atributo, String novoValor);

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
	public void adicionaPrecoItem(Integer key, String local, double preco);

	/**
	 * Metodo responsavel por remover um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key
	 *            Um inteiro que representa o ID do item.
	 */
	public void deletaItem(Integer identificador);

	/**
	 * Metodo responsavel por buscar um item de acordo com uma posicao de forma que
	 * ele esteja ordenado pelo nome
	 * 
	 * @param position
	 *            : Um inteiro indicando a posicao do item na lista de itens
	 *            ordenada pelo nome
	 * @return : Uma String com a representacao textual do item selecionado
	 */
	public String getItem(int posicao);

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
	public String getItemPorCategoria(String categoria, int posicao);

	/**
	 * Metodo responsavel por realizar a busca de um item de acordo com uma string
	 * de pesquisa
	 * 
	 * @param strPesquisa
	 *            : Uma String indicando a string utilizada como filtro
	 * @param posicao
	 *            : Uma String indicando a posicao do item na lista ordenada e que
	 *            contem a string de pesquisa
	 * @return Uma string com a representacao textual do item que esta na posicao
	 *         informada
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao);

	/**
	 * Metodo responsavel por retornar o item em determinada posicao. Para isso os
	 * itens estarao sendo classificados do menor preco ao maior preco
	 * 
	 * @param posicao
	 *            : Posicao em que o item sera recuperado
	 * @return : Representacao textual do item nessa posicao
	 */
	public String getItemPorMenorPreco(int posicao);

	/**
	 * Adiciona uma nova lista de compras as listas do sistema.
	 * 
	 * @param descritor
	 *            : Descricao de uma lista de compras.
	 * 
	 * @return : Retorna a descricao da lista de compras.
	 */
	public String adicionaListaDeCompras(String descritor);

	/**
	 * Adiciona uma compra a lista de compras (quantidade inteira).
	 * 
	 * @param descritor
	 *            : Descricao da compra a ser inserida na lista.
	 * @param quantidade
	 *            : Quantidade de unidades do produto.
	 * @param idItem
	 *            : Id do produto a ser inserido na lista.
	 */
	public void adicionaCompraALista(String descritor, int quantidade, Integer idItem);

	/**
	 * Finaliza uma lista de compras já inicializada.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras a ser finalizada.
	 * @param localCompra
	 *            : Local onde a compra foi realizada.
	 * @param valorFinalDaCompra
	 *            : Valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritor, String localCompra, int valorFinalDaCompra);

	/**
	 * Pesquisa por uma compra em uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Id do item compravel.
	 * 
	 * @return : Retorna a representacao String da compra contida na lista de
	 *         compras.
	 */
	public String pesquisaCompraEmLista(String descritor, Integer idItem);

	/**
	 * Atualiza a quantidade de uma compra em uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Id do item a ser alterado.
	 * @param quantidade
	 *            : Nova quantidade a ser atualizada.
	 */
	public void atualizaCompraDeLista(String descritor, Integer idItem, String operacao, int quantidade);

	/**
	 * Retorna a representação String do item em uma lista de compras ordenada.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param posicao
	 *            : Posicao do item escolhido na lista.
	 * 
	 * @return : Retorna a representação String do item na posicao escolhida contida
	 *         na lista de compras ordenada.
	 */
	public String getItemLista(String descritor, int posicao);

	/**
	 * Pesquisa uma lista de compras nas listas de compras ja cadastradas a partir
	 * do seu descritor.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * 
	 * @return : Retorna a lista das compras cadastradas na lista de compras com o
	 *         descritor inserido.
	 */
	public String pesquisaListaDeCompras(String descritor);

	/**
	 * Deleta uma compra de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Identificador da compra a ser deletada da lista de compras.
	 */
	public void deletaCompraDeLista(String descritor, Integer idItem);

	/**
	 * Retorna a data atual.
	 * 
	 * @return : Retorna a data atual.
	 */
	public String dataAtual();

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
	public String getItemListaPorData(String data, int posicao);

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
	public String getItemListaPorItem(Integer idItem, int posicao);
	/**
	 * Retorna a pesquisa de listas de compras por data.
	 * @param data: data a ser pesquisada.
	 * @return representacao textual das listas de compra.
	 */
	public String pesquisaListasDeComprasPorData(String data);
	/**
	 * Retorna as listas que possuem tal produto.
	 * @param id :indentificador do produto.
	 * @return representacao textual das listas que contem o produto
	 */
	public String pesquisaListasDeComprasPorItem(int id);
	
}
