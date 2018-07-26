package com.projeto.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.projeto.comparadores.ComparaValor;
import com.projeto.excecoes.AtribultoInexistenteException;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.model.Item;
import com.projeto.model.ListaDeCompra;
import com.projeto.model.ProdutoNaoIndustrializadoPorQuilo;
import com.projeto.model.ProdutoPorUnidade;
import com.projeto.model.ProdutoQuantidadeFixa;
import com.projeto.service.ListaService;
import com.projeto.util.Mensagem;
import com.projeto.util.ValidadorSistema;

/**
 * Classe que representa o sistema. Ela e responsavel por realizar grande parte
 * das funcionalidades do sistema.
 *
 */
public class SistemaController {

	/**
	 * Uma lista com todas as listaDeCompras do sistema.
	 */
	private Map<String, ListaDeCompra> listas;

	/**
	 * Um mapa com todos os produtos cadastrados pelo sistema.
	 */
	private Map<Integer, Item> produtos;
	
	private ListaService listaService;

	/**
	 * Um inteiro que representa o id dos produtos que serao cadastrados no sistema.
	 */
	private Integer identificadorBase;

	public SistemaController() {
		this.listas = new HashMap<>();
		this.identificadorBase = 1;
		this.listaService = new ListaService();
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
	 * @param quantidade
	 *            : um inteiro indicando a quantidade do produto
	 * 
	 * @return : retorna um inteiro representando o identificador do item
	 *         adicionado.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeMedida,
			String localCompra, double preco) {
		try {
			if (ValidadorSistema.validaItem(nome, categoria)
					&& ValidadorSistema.validaProdutoQuantidadeFixa(quantidade, unidadeMedida, localCompra, preco)) {
				ProdutoQuantidadeFixa produto = new ProdutoQuantidadeFixa(this.identificadorBase, nome, categoria,
						quantidade, unidadeMedida, localCompra, preco);
				ValidadorSistema.validaProduto(produto, produtos);

				this.produtos.put(this.identificadorBase, produto);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_CADASTRO.get() + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(Mensagem.MSG_EXCECAO_CADASTRO.get());
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
				ProdutoNaoIndustrializadoPorQuilo produto = new ProdutoNaoIndustrializadoPorQuilo(
						this.identificadorBase, nome, categoria, quilo, localCompra, preco);
				ValidadorSistema.validaProduto(produto, produtos);

				this.produtos.put(this.identificadorBase, produto);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_CADASTRO.get() + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(Mensagem.MSG_EXCECAO_CADASTRO.get());
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
				ProdutoPorUnidade porUnidade = new ProdutoPorUnidade(this.identificadorBase, nome, categoria, unidade,
						localCompra, preco);
				ValidadorSistema.validaProduto(porUnidade, produtos);

				this.produtos.put(this.identificadorBase, porUnidade);
				return this.identificadorBase++;
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_CADASTRO.get() + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(Mensagem.MSG_EXCECAO_CADASTRO.get());
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
		ValidadorSistema.validaChave(key, produtos, Mensagem.MSG_EXCECAO_LISTA_ITEM.get());
		return this.produtos.get(key).toString();
	}

	/**
	 * Metodo responsavel por atualizar um item na colecao de itens cadastrados no
	 * sistema.
	 * 
	 * @param key
	 *            : Um inteiro indicando a chave do item onde sera adicionado o novo
	 *            valor.
	 * @param atribulto
	 *            Uma String indicando qual o campo que sera atualizado.
	 * @param novoValor
	 *            Uma String indicando o novo valor que o capo ira assumir. Caso o
	 *            campo seja um valor numerico, esse valor deve ser transformado
	 *            antes de prosseguir.
	 * @return : Um Inteiro indicando o identificador do item atualizado.
	 */
	public int atualizaItem(Integer key, String atribulto, String novoValor) {
		ValidadorSistema.validaChave(key, produtos, Mensagem.MSG_EXCECAO_ATUALIZA_ITEM.get());

		Item item = null;
		try {
			if (ValidadorSistema.validaAtualizacao(atribulto, novoValor)) {
				item = produtos.get(key);
				return item.atualiza(atribulto, novoValor);
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_ATUALIZA_ITEM.get() + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(Mensagem.MSG_EXCECAO_ATUALIZA_ITEM.get());
		} catch (AtribultoInexistenteException e) {
			throw new AtribultoInexistenteException(Mensagem.MSG_EXCECAO_ATUALIZA_ITEM.get());
		}
		return -1;
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
		ValidadorSistema.validaPrecoItem(key, local, preco, produtos);

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
		ValidadorSistema.validaInexistenciaDeProduto(key, produtos, Mensagem.MSG_EXCECAO_REMOCAO_ITEM.get());

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
		if (itens.isEmpty() || position >= itens.size())
			return "";

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
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_LISTA_ITEM + e.getMessage());
		} catch (CategoriaInexistenteException e) {
			throw new CategoriaInexistenteException(Mensagem.MSG_EXCECAO_LISTA_ITEM.get());
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
		if (posicao >= this.produtos.size() || posicao < 0) {
			return "";
		}
		ArrayList<Item> itens = new ArrayList<>(produtos.values());
		Collections.sort(itens, new ComparaValor());
		return itens.get(posicao).toString();
	}

	/**
	 * Metodo responsavel por realizar a busca de um item de acordo com uma string
	 * de pesquisa e uma posicao na lista ordenada
	 * 
	 * @param strPesquisa
	 *            : Uma String indicando a string utilizada como filtro
	 * @param posicao
	 *            : Uma String indicando a posicao do item na lista ordenada e que
	 *            contem a string de pesquisa.
	 * @return Uma string com a representacao textual do item que esta na posicao
	 *         informada na lista ordenada de todos ios produtos do tipo.
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		List<Item> itens = new ArrayList<Item>();
		for (Item item : produtos.values()) {
			if (item.getNome().toLowerCase().contains(strPesquisa.toLowerCase())) {
				itens.add(item);
			}
		}
		if (!itens.isEmpty() && posicao < itens.size() && posicao >= 0) {
			Collections.sort(itens);
			return itens.get(posicao).toString();
		}
		return "";
	}
 
	/**
	 * Metodo responsavel por criar uma lista de compras com um nome. Alem disso,
	 * nao permite que descritores de listas de compras sejam repetidos.
	 * 
	 * @param descritor
	 *            : descritor da lista de compras
	 * @return representacao textual do nome do descritor
	 */
	public String adicionaListaDeCompras(String descritor) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_CRIACAO_COMPRA.get());
		ValidadorSistema.validaExistenciaDeListaDeCompras(descritor, this.listas,
				Mensagem.MSG_EXCECAO_CRIACAO_COMPRA.get());

		this.listas.put(descritor, new ListaDeCompra(descritor));
		return descritor;
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
	public void adicionaCompraALista(String descritor, int quantidade, Integer idItem) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_COMPRA_ITEM.get());
		ValidadorSistema.validaInexistenciaDeProduto(idItem, this.produtos, Mensagem.MSG_EXCECAO_COMPRA_ITEM.get());

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		Item item = this.produtos.get(idItem);
		listaDeCompra.adicionaCompraALista(quantidade, item);

	}

	/**
	 * Metodo responsavel por finalizar uma lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param localCompra
	 *            : Local onde as compras foram efetuadas.
	 * @param valorFinalCompra
	 *            : Valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritor, String localCompra, int valorFinalDaCompra) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_FINALIZACAO_LISTA_COMPRAS.get());
		ValidadorSistema.validaLocalCompra(localCompra, Mensagem.MSG_EXCECAO_FINALIZACAO_LISTA_COMPRAS.get());
		ValidadorSistema.validaValorFinalDaCompra(valorFinalDaCompra,
				Mensagem.MSG_EXCECAO_FINALIZACAO_LISTA_COMPRAS.get());

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		listaDeCompra.finalizar(localCompra, valorFinalDaCompra);
	}

	/**
	 * Metodo responsavel por pesquisar na lista de compras um determinado produto.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param idItem
	 *            : id do item que sera pesquisado na lista de compras.
	 * @return Representacao textual do item que esta na lista.
	 */
	public String pesquisaCompraEmLista(String descritor, Integer idItem) {
		ValidadorSistema.validaIdItem(idItem, Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		return listaDeCompra.pesquisaCompraEmLista(idItem);
	}

	/**
	 * Metodo responsavel por atualizar um produto da lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras.
	 * @param idItem
	 *            : id do item que sera atualizado na lista de compras.
	 * @param quantidade
	 *            : nova quantidae de itens.
	 */
	public void atualizaCompraDeLista(String descritorLista, Integer idItem, String operacao, int quantidade) {
		ValidadorSistema.validaDescritor(descritorLista, Mensagem.MSG_EXCECAO_ATUALIZA_COMPRA.get());
		ListaDeCompra listaDeCompra = this.listas.get(descritorLista);

		listaDeCompra.atualizaCompraDeLista(idItem, operacao, quantidade);
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

	public String getItemLista(String descritor, int posicao) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());
		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		return listaDeCompra.getItemLista(posicao);
	}

	/**
	 * Metodo responsavel por verificar a existencia de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Nome da lista de compras que sera pesquisada.
	 * @return O nome do descritor, se existir, e null caso nao exista.
	 */
	public String pesquisaListaDeCompras(String descritor) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());
		ValidadorSistema.validaInexistenciaDeListaDeCompras(descritor, this.listas,
				Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get());

		return descritor;
	}

	/**
	 * Deleta uma compra de uma lista de compras.
	 * 
	 * @param descritor
	 *            : Descricao da lista de compras.
	 * @param idItem
	 *            : Identificador da compra a ser deletada da lista de compras.
	 */
	public void deletaCompraDeLista(String descritor, Integer idItem) {
		ValidadorSistema.validaDescritor(descritor, Mensagem.MSG_EXCECAO_EXCLUSAO_COMPRA.get());
		ValidadorSistema.validaInexistenciaDeProduto(idItem, produtos, Mensagem.MSG_EXCECAO_EXCLUSAO_COMPRA.get());

		ListaDeCompra listaDeCompra = this.listas.get(descritor);
		listaDeCompra.deletaCompraDeLista(idItem);

	}

	/**
	 * Retorna a data atual.
	 * 
	 * @return : Retorna a data atual.
	 */
	public String dataAtual() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date());
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
	public String getItemListaPorData(String dataString, int posicao) {
		try {
			if (ValidadorSistema.validaData(dataString)) {
				Date data = formataData(dataString);
				List<ListaDeCompra> lista = buscaPorData(data);
				Collections.sort(lista);
				return lista.get(posicao).getDescritor();
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get() + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Metodo auxiliar criado para formatar a data.
	 * 
	 * @param dataString
	 *            Data a ser formatada
	 * @return Data no formato de data dd/MM/yyyy
	 * @throws ParseException
	 */
	private Date formataData(String dataString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dataString);
		return date;
	}

	/**
	 * Metodo responsavel por buscar listas que possuem tal data
	 * 
	 * @param data
	 *            Lista com Todas as compras que foram efetuadas nessa data
	 * @return Lista de lista de compras
	 */
	private List<ListaDeCompra> buscaPorData(Date data) {
		List<ListaDeCompra> lista = new ArrayList<>();
		for (ListaDeCompra list : this.listas.values()) {
			if (list.getDataFormatada().equals(data)) {
				lista.add(list);
			}
		}
		return lista;
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
	public String getItemListaPorItem(Integer idItem, int posicao) {
		List<ListaDeCompra> lista = buscaPorItem(idItem);
		Collections.sort(lista);
		ListaDeCompra listaCompra = lista.get(posicao);
		String retorno = listaCompra.getDataTextual() + " - " + listaCompra.getDescritor();
		return retorno;
	}

	/**
	 * Metodo auxiliar criado para retornar uma lista que tem um item dentro dela
	 * 
	 * @param idItem
	 *            Id do item que sera pesquisado
	 * @return Lista de lista de compras
	 */
	private List<ListaDeCompra> buscaPorItem(Integer idItem) {
		List<ListaDeCompra> lista = new ArrayList<>();
		for (ListaDeCompra list : this.listas.values()) {
			if (list.possuiCompra(idItem)) {
				lista.add(list);
			}
		}
		return lista;
	}

	/**
	 * Retorna a pesquisa de listas de compras por data.
	 * 
	 * @param data:
	 *            data a ser pesquisada.
	 * @return representacao textual das listas de compra.
	 */
	public String pesquisaListasDeComprasPorData(String dataString) {
		try {
			if (ValidadorSistema.validaData(dataString)) {

				Date data = formataData(dataString);
				for (ListaDeCompra lista : listas.values()) {
					if (lista.getData().equals(data)) {
						return lista.buscaTodosItens();
					}
				}
			}
		} catch (CampoInvalidoException e) {
			throw new CampoInvalidoException(Mensagem.MSG_EXCECAO_PESQUISA_COMPRA.get() + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retorna as listas que possuem tal produto.
	 * 
	 * @param id
	 *            :indentificador do produto.
	 * @return representacao textual das listas que contem o produto
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		String volta = "";
		for (ListaDeCompra lista : listas.values()) {
			if (lista.possuiCompra(id)) {
				volta += lista.getDescritor() + System.lineSeparator();
			}
		}
		ValidadorSistema.validaSaidaVazia(volta);
		return volta;
	}

	/**
	 * Metodo responsavel por gerar automaticamente o dia da ultima lista que foi
	 * cadastrada.
	 * 
	 * @return : representacao textual do dia em que foi realizada a ultima compra
	 */
	public String geraAutomaticaUltimaLista() {
		ListaDeCompra lista = getUltimaLista();
		String descritor = Estrategia.ESTRATEGIA_1.get() + " " + this.dataAtual();
		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.setCompras(lista.getCompras());
		listaDeCompra.setValorFinal(lista.getValorFinal());
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo responsavel por retornar a ultima lista de compra realizada.
	 * 
	 * @return Lista de compra
	 */
	private ListaDeCompra getUltimaLista() {
		List<ListaDeCompra> lista = new ArrayList<>(this.listas.values());
		Collections.sort(lista, new ComparaData());
		return lista.get(lista.size() - 1);
	}

	/**
	 * Metodo responsavel por gerar automaticamente o dia da ultima compra em que o
	 * item foi cadastrado.
	 * 
	 * @param descritorItem
	 *            : Item a ser procurado.
	 * @return representacao textual do ultimo dia em que o item foi comprado.
	 */
	public String geraAutomaticaItem(String descritorItem) {
		ListaDeCompra lista = getUltimaLista(descritorItem);
		ValidadorSistema.validaListaDeCompra(lista);

		String descritor = Estrategia.ESTRATEGIA_2.get() + " " + this.dataAtual();

		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.setCompras(lista.getCompras());
		listaDeCompra.setValorFinal(lista.getValorFinal());
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo responsavel por retornar uma lista que contem um respectivo item.
	 * 
	 * @param descritorItem
	 *            : Item a ser procurado nas listas
	 * @return Lista de compras que contem o item.
	 */
	private ListaDeCompra getUltimaLista(String descritorItem) {
		List<ListaDeCompra> lista = new ArrayList<>(this.listas.values());
		Collections.sort(lista, new ComparaData());
		ListaDeCompra listaDeCompra = null;
		for (int i = lista.size() - 1; i >= 0; i--) {
			listaDeCompra = lista.get(i);
			if (listaDeCompra.contemItem(descritorItem)) {
				return listaDeCompra;
			}
		}
		return null;
	}

	/**
	 * Metodo responsavel por Gerar automaticamente o dia em que a lista possui
	 * compras que mais aparecem nas listas de compras anteriores.
	 * 
	 * @return representacao textual do dia em que a lista ocorre.
	 */
	public String geraAutomaticaItensMaisPresentes() {
		Map<Item, Integer> maisComprados = buscaMaisComprados();

		String descritor = Estrategia.ESTRATEGIA_3.get() + " " + this.dataAtual();
		ListaDeCompra listaDeCompra = new ListaDeCompra(descritor);
		listaDeCompra.adicionaItens(maisComprados);
		this.listas.put(descritor, listaDeCompra);
		return descritor;
	}

	/**
	 * Metodo auxiliar responsavel por retornar os itens mais comprados
	 * 
	 * @return Mapa contendo os itens
	 */
	private Map<Item, Integer> buscaMaisComprados() {
		Map<Item, Integer> maisComprados = new HashMap<>();

		for (Item item : this.produtos.values()) {
			List<Compra> compraQuePossue = listasQuePossui(item);
			if (compraQuePossue.size() >= (this.listas.size() / 2)) {
				Integer quantidade = calculaTotal(compraQuePossue);
				quantidade = (int) Math.floor(quantidade / compraQuePossue.size());
				maisComprados.put(item, quantidade);

			}
		}
		return maisComprados;
	}

	/**
	 * Metodo auxiliar que serve para calcular o valor total das compras.
	 * 
	 * @param compraQuePossue
	 *            Lista que contem as compras.
	 * @return inteiro representando a soma total.
	 */
	private int calculaTotal(List<Compra> compraQuePossue) {
		int quantidade = 0;
		for (Compra compra : compraQuePossue) {
			quantidade += compra.getQuantidade();
		}
		return quantidade;
	}

	/**
	 * Metodo responsavel por verificar se um item existe nas listas de compras.
	 * 
	 * @param item
	 *            :Item a ser pesquisado.
	 * @return Lista contendo as compras que possuem tal item.
	 */
	private List<Compra> listasQuePossui(Item item) {
		List<Compra> compras = new ArrayList<>();

		for (ListaDeCompra lista : this.listas.values()) {
			Compra compra = lista.getCompra(item.getId());
			if (compra != null) {
				compras.add(compra);
			}
		}
		return compras;
	}

	public String sugereMelhorEstabelecimento(String descritor, int posicaoEstabelecimento, int posicaoLista) {
		return this.listaService.sugereMelhorEstabelecimento(descritor,posicaoEstabelecimento,posicaoLista);
	}

}
