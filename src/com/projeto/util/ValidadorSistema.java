package com.projeto.util;

import java.util.Map;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.excecoes.ItemInexistenteException;
import com.projeto.model.Item;
import com.projeto.model.ListaDeCompra;

/**
 * Classe responsavel por realizar validacoes de campos no sistema.
 *
 */
public class ValidadorSistema {

	/**
	 * Metodo responsavel por validar os campos de um item
	 * 
	 * @param nome
	 *            : Uma string representando o nome do item
	 * @param categoria
	 *            : Uma String representando a categoria do item
	 * @return Um valor bolleano indicado se os campos sao validos ou nao
	 */
	public static boolean validaItem(String nome, String categoria) {
		validaNome(nome);
		validaCategoria(categoria);
		return true;
	}

	/**
	 * Metodo responsavel por validar os campos de um produto nao industrializado
	 * por quilo
	 * 
	 * @param quilo
	 *            : Um valor de ponto flutuante indicando o quilo do produto
	 * @param localCompra
	 *            : Uma string indicando o local da compra a ser adicionado no item
	 * @param preco
	 *            : Um valor de ponto flutuante que indica o valor do produto no
	 *            local de compra indicado
	 * @param nome
	 *            : Uma String indicando o nome do produto
	 * @param categoria
	 *            : Uma String indicando a categoria do produto
	 * @return Um valor bolleano indicando se os campos estao validos ou nao
	 */
	public static boolean validaProdutoNaoIndustrializadoPorQuilo(double quilo, String localCompra, double preco) {
		validaLocalDeCompra(localCompra, preco);
		validaQuilo(quilo);
		return true;
	}

	/**
	 * Metodo responsavel por realizar a validacao dos campos do produto por
	 * quantidade fixa
	 * 
	 * @param quantidade
	 *            : Um Inteiro indicando a quantidade do produto
	 * @param unidadeMedida
	 *            : Uma String indicando a unidade de medida do produto
	 * @param localCompra
	 *            : Uma String indicando
	 * @param preco
	 * @return
	 */
	public static boolean validaProdutoQuantidadeFixa(int quantidade, String unidadeMedida, String localCompra,
			double preco) {
		validaLocalDeCompra(localCompra, preco);
		validaQuantidade(quantidade);
		validaUnidadeMedida(unidadeMedida);
		return true;
	}

	/**
	 * Metodo respondavel pela validacao dos campos do produto por unidade
	 * 
	 * @param unidade
	 *            : Um inteiro indicando a quantidade de unidades do produto
	 * @param localCompra
	 *            : Uma String indicando o local de compra que sera cadastrado
	 * @param preco
	 *            : Um valor de ponto flutuante indicando o preco que sera
	 *            adicionado ao local de compra
	 * @return Um valor bolleano indicando se as entradas estao validas ou nao
	 */
	public static boolean validaProdutoPorUnidade(int unidade, String localCompra, double preco) {
		validaLocalDeCompra(localCompra, preco);
		validaUnidade(unidade);
		return true;
	}

	/**
	 * Metodo responsavel por validar um local de compra juntamente com seu preco
	 * 
	 * @param local
	 *            : Uma string que representa o local de compra
	 * @param preco
	 *            :Um double que representa o preco do item
	 * @return Um valor bolleano indicando se os campos sao validos
	 */
	public static boolean validaLocalDeCompra(String local, Double preco) {
		if (local == null || local.trim().isEmpty()) {
			throw new CampoInvalidoException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco <= 0) {
			throw new CampoInvalidoException("preco de item invalido.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar uma categoria
	 * 
	 * @param categoria
	 *            : Uma String que representa a categoria que sera validada
	 * @return Um valor bolleano indicando se a categorria e valida ou nao
	 */
	public static boolean validaCategoria(String categoria) {
		if (categoria == null || categoria.trim().isEmpty()) {
			throw new CampoInvalidoException("categoria nao pode ser vazia ou nula.");
		}

		if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado")
				|| categoria.equals("limpeza") || categoria.equalsIgnoreCase("higiene pessoal"))) {
			throw new CategoriaInexistenteException();
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar um nome
	 * 
	 * @param nome
	 *            :Uma String que representa o nome a ser validado
	 * @return Um valor bolleano indicando se o nome eh valido
	 */
	public static boolean validaNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new CampoInvalidoException("nome nao pode ser vazio ou nulo.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar uma quantia em quilos
	 * 
	 * @param quilo
	 *            :Um double com os quilos
	 * @return Um valor bolleano indicando se a qtd em quilos eh valida
	 */
	public static boolean validaQuilo(Double quilo) {
		if (quilo <= 0) {
			throw new CampoInvalidoException("valor de quilos nao pode ser menor que zero.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar uma quantidade de itens que nao pode ser menor
	 * ou igual a zero.
	 * 
	 * @param quantidade
	 *            Um Inteiro indicando a quantidade do produto
	 * @return Um valor bolleano indicando se a quantidade eh valida
	 */
	public static boolean validaQuantidade(int quantidade) {
		if (quantidade <= 0) {
			throw new CampoInvalidoException("valor de quantidade nao pode ser menor que zero.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar uma unidade de medida
	 * 
	 * @param unidadeMedida
	 *            Uma String indicando a unidade de medida do produto
	 * @return Um valor bolleano indicando se a unidade de medida eh valida
	 */
	public static boolean validaUnidadeMedida(String unidadeMedida) {
		if (unidadeMedida == null || unidadeMedida.trim().isEmpty()) {
			throw new CampoInvalidoException("unidade de medida nao pode ser vazia ou nula.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar a quantidade de unidades do produto
	 * 
	 * @param unidade
	 *            Um inteiro indicando a quantidade de unidades do produto
	 * @return Um valor bolleano indicando se a quantidade de unidades de medida eh
	 *         valida
	 */
	public static boolean validaUnidade(int unidade) {
		if (unidade <= 0) {
			throw new CampoInvalidoException("valor de unidade nao pode ser menor que zero.");
		}
		return true;
	}

	/**
	 * Metodo responsavel pela valizacao de compos exigidos pela atualizacao de
	 * itens
	 * 
	 * @param atribulto
	 *            : Nome do atribulto que sera atualizado
	 * @param novoValor
	 *            : Novo valor que sera alocado ao atribulto
	 * @return Um bolleano que indica se os campos estao validos
	 */
	public static boolean validaAtualizacao(String atribulto, String novoValor) {
		if (atribulto == null || atribulto.trim().isEmpty())
			throw new CampoInvalidoException("atributo nao pode ser vazio ou nulo.");
		if (novoValor == null || novoValor.trim().isEmpty())
			throw new CampoInvalidoException("novo valor de atributo nao pode ser vazio ou nulo.");
		return true;
	}

	/**
	 * Metodo que valida uma operacao.
	 * 
	 * @param operacao
	 *            String com a operacao desejada.
	 * @return true se a operacao for valida.
	 */
	public static boolean validaOperacao(String operacao) {
		if (!operacao.equals("adiciona") && !operacao.equals("diminui")) {
			throw new CampoInvalidoException("operacao invalida para atualizacao.");
		}
		return true;
	}

	public static boolean validaData(String data) {
		if (data == null || data.trim().isEmpty()) {
			throw new CampoInvalidoException("data nao pode ser vazia ou nula.");
		}
		String[] dataArray = data.split("/");
		if (dataArray.length != 3) {
			throw new CampoInvalidoException("data em formato invalido, tente dd/MM/yyyy");
		}
		return true;
	}

	/**
	 * Metodo que valida um Descritor.
	 * 
	 * @param descritor
	 *            String que representa o descritor a ser validado.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o descritor for valido
	 */
	public static boolean validaDescritor(String descritor, String msgExcecaoMetodo) {
		if (descritor == null || descritor.trim().isEmpty()) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "descritor nao pode ser vazio ou nulo.");
		}
		return true;
	}

	/**
	 * Metodo que valida a existencia de um produto em um mapa de produtos.
	 * 
	 * @param idItem
	 *            inteiro com o id do item.
	 * @param produtos
	 *            Mapa de produtos.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o produto nao pertence ao mapa de produtos.
	 */
	public static boolean validaExistenciaDeProduto(int idItem, Map<Integer, Item> produtos, String msgExcecaoMetodo) {
		if (produtos.containsKey(idItem)) {
			throw new ItemInexistenteException(msgExcecaoMetodo + "item existente no sistema.");
		}
		return true;
	}

	/**
	 * Metodo que valida a inexistencia de um produto em um mapa de produtos.
	 * 
	 * @param idItem
	 *            inteiro com o id do item.
	 * @param produtos
	 *            Mapa de produtos.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o produto pertence ao mapa de produtos.
	 */
	public static boolean validaInexistenciaDeProduto(int idItem, Map<Integer, Item> produtos,
			String msgExcecaoMetodo) {
		if (!produtos.containsKey(idItem)) {
			throw new ItemInexistenteException(msgExcecaoMetodo + "item nao existe no sistema.");
		}
		return true;
	}

	/**
	 * Metodo que valida a existencia de uma lista de compras um mapa de lista de
	 * compras.
	 * 
	 * @param descritor
	 *            String com o descritor da lista de compras.
	 * @param listaCompras
	 *            Mapa com listas de compras.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se a lista de compras nao pertence ao mapa de lista de compras.
	 */
	public static boolean validaExistenciaDeListaDeCompras(String descritor, Map<String, ListaDeCompra> listaCompras,
			String msgExcecaoMetodo) {
		if (listaCompras.containsKey(descritor)) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "lista de compras ja existe.");
		}
		return true;
	}

	/**
	 * Metodo que valida a inexistencia de uma lista de compras um mapa de lista de
	 * compras.
	 * 
	 * @param descritor
	 *            String com o descritor da lista de compras.
	 * @param listaCompras
	 *            Mapa com listas de compras.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se a lista de compras pertence ao mapa de lista de compras.
	 */
	public static boolean validaInexistenciaDeListaDeCompras(String descritor, Map<String, ListaDeCompra> listaCompras,
			String msgExcecaoMetodo) {
		if (!listaCompras.containsKey(descritor)) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "lista de compras nao existe.");
		}
		return true;
	}

	/**
	 * Metodo que valida um local de compra.
	 * 
	 * @param localCompra
	 *            String representando o local de compra.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o local de compra for valido.
	 */
	public static boolean validaLocalCompra(String localCompra, String msgExcecaoMetodo) {
		if (localCompra == null || localCompra.trim().isEmpty()) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "local nao pode ser vazio ou nulo.");
		}
		return true;
	}

	/**
	 * Metodo que valida um valor final de compra.
	 * 
	 * @param valor
	 *            Inteiro com o valor a ser validado.
	 * @param msgExcecaoMetodo
	 *            String com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o valor for valido.
	 */
	public static boolean validaValorFinalDaCompra(int valor, String msgExcecaoMetodo) {
		if (valor <= 0) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "valor final da lista invalido.");
		}
		return true;
	}

	/**
	 * Metodo que valida um id de um item.
	 * 
	 * @param idItem
	 *            Inteiro com o id do item.
	 * @param msgExcecaoMetodoString
	 *            com a mensagem especifica de cada metodo que ira usar este
	 *            validador.
	 * @return true se o idTem for valido.
	 */
	public static boolean validaIdItem(int idItem, String msgExcecaoMetodo) {
		if (idItem < 0) {
			throw new CampoInvalidoException(msgExcecaoMetodo + "item id invalido.");
		}
		return true;
	}
}
