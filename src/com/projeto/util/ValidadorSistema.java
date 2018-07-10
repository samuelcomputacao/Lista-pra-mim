package com.projeto.util;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;

/**
 * Classe responsável por realizar validacoes de campos no sistema
 *
 */
public class ValidadorSistema {

	/**
	 * Metodo responsavel por validar os campos de um item
	 * 
	 * @param nome
	 *            : Uma string representadno o nome do item
	 * @param categoria
	 *            : Uma String representando a categoria do item
	 * @return Um valor bolleano indicado se os campos sao validos ou nao
	 */
	public static boolean validaItem(String nome, String categoria) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new CampoInvalidoException("nome nao pode ser vazio ou nulo.");
		}
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
		if (quilo <= 0) {
			throw new CampoInvalidoException("valor de quilos nao pode ser menor que zero.");
		}
		if (localCompra == null || localCompra.trim().isEmpty()) {
			throw new CampoInvalidoException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco <= 0) {
			throw new CampoInvalidoException("preco de item invalido.");
		}
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
		if (quantidade <= 0) {
			throw new CampoInvalidoException("valor de quantidade nao pode ser menor que zero.");
		}
		if (unidadeMedida == null || unidadeMedida.trim().isEmpty()) {
			throw new CampoInvalidoException("unidade de medida nao pode ser vazia ou nula.");
		}
		if (localCompra == null || localCompra.trim().isEmpty()) {
			throw new CampoInvalidoException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco <= 0) {
			throw new CampoInvalidoException("preco de item invalido.");
		}
		return true;
	}

	/**
	 * Metodo respondavel pela validacao dos campos do produto por unidade
	 * 
	 * @param unidade : Um inteiro indicando a quantidade de unidades do produto
	 * @param localCompra : Uma String indicando o local de compra que sera cadastrado
	 * @param preco : Um valor de ponto flutuante indicando
	 * o preco que sera adicionado ao local de compra
	 * @return Um valor bolleano indicando se as entradas estao validas ou nao
	 */
	public static boolean validaProdutoPorUnidade(int unidade,String localCompra,double preco) {
		if (preco <= 0) {
			throw new CampoInvalidoException("preco de item invalido.");
		}
		if (unidade <= 0) {
			throw new CampoInvalidoException("valor de unidade nao pode ser menor que zero.");
		}
		if (localCompra == null || localCompra.trim().isEmpty()) {
			throw new CampoInvalidoException("local de compra nao pode ser vazio ou nulo.");
		}
		return true;
	}

	/**
	 * Metodo responsavel por validar uma categoria
	 * 
	 * @param categoria : Uma String que representa a categoria que sera validada
	 * @return Uma String indicando se a categorria e valida ou nao
	 */
	public static boolean validaCategoria(String categoria) {
		if (categoria == null || categoria.trim().isEmpty()) {
			throw new CampoInvalidoException("categoria nao pode ser vazia ou nula.");
		}

		if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado")
				|| categoria.equals("limpeza") || categoria.equalsIgnoreCase("higiene pessoal"))) {
			throw new CategoriaInexistenteException("");
		}
		return true;
	}

}
