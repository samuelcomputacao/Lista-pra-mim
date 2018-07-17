package com.projeto.principal;


import easyaccept.EasyAccept;

/**
 * Fachada do sistema responsavel pela delegacao de todos os metodos que o sistema possui.
 */
public class ListaPraMimFacade implements ListaPraMim {
	
	/**
	 * Representa um sistema. eh nele onde estara os codigos que realizarao a funcionalidades. 
	 */
	private Sistema sistema;
	
	/**
	 * Metodo responsavel por inicializar a facade no sistema.
	 */
	public ListaPraMimFacade() {
		this.sistema = new Sistema();
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
		return this.sistema.adicionaItemPorQtd(nome, categoria, quantidade, unidadeMedida, localCompra, preco);
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
		return this.sistema.adicionaItemPorQuilo(nome, categoria, quilo, localCompra, preco);
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
		return this.sistema.adicionaItemPorUnidade(nome, categoria, unidade, localCompra, preco);
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
		return this.sistema.exibeItem(key);
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
	public int atualizaItem(Integer key,String atributo, String novoValor) {
		return this.sistema.atualizaItem(key, atributo, novoValor);
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
	public void adicionaPrecoItem(Integer key,String local, double preco) {
		this.sistema.adicionaPrecoItem(key,local, preco);
		
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
		this.sistema.deletaItem(key);
	}	
	
	/**
	 * Metodo responsavel por realizar os testes de aceitacao
	 */
	public static void main(String[] args) {
		args = new String[]{"com.projeto.principal.ListaPraMimFacade",
							"acceptance_test/use_case1.txt",
							"acceptance_test/use_case1_exception.txt",
							"acceptance_test/use_case2.txt",
							"acceptance_test/use_case2_exception.txt",
							"acceptance_test/use_case3.txt"
							};
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
		return this.sistema.getItem(posicao);
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
	public String getItemPorCategoria(String categoria,int posicao) {
		return this.sistema.getItemPorCategoria(categoria, posicao);
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
	public String getItemPorMenorPreco (int posicao) {
		return this.sistema.getItemPorMenorPreco(posicao);
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
		return this.sistema.getItemPorPesquisa(strPesquisa,posicao);
	}

	@Override
	public String adicionaListaDeCompras(String descritor) {
		return this.sistema.adicionaListaDeCompras(descritor);
	}

	@Override
	public void adicionaCompraALista(String descritor, int quantidade, Integer idItem) {
		this.sistema.adicionaCompraALista(descritor, quantidade,idItem);
		
	}

	

	@Override
	public void finalizarListaDeCompras(String descritor, String localCompra, int valorFinalDaCompra) {
		this.sistema.finalizarListaDeCompras(descritor, localCompra, valorFinalDaCompra);
		
	}

	@Override
	public String pesquisaCompraEmLista(String descritor, Integer idItem) {
		return this.sistema.pesquisaCompraEmLista(descritor, idItem);
	}

	@Override
	public void atualizaCompraDeLista(String descritor, Integer idItem, int quantidade) {
		this.sistema.atualizaCompraDeLista(descritor, idItem, quantidade);
		
	}

	

	@Override
	public String getItemLista(String descritor, int posicao) {
		return this.sistema.getItemLista(descritor, posicao);
		
	}

	@Override
	public String pesquisaListaDeCompras(String descritor) {
		return this.sistema.pesquisaListaDeCompras(descritor);
	}
	

	

}
