package com.projeto.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe responsavel por testar a classe Produto por Unidade
 */
public class ProdutoPorUnidadeTest {
	private ProdutoPorUnidade produtoPorUnidade;

	/**
	 * Inicializa o ProdutoPorUnidade
	 */
	@Before
	public void testIniciaProdutoPorUnidade() {
		produtoPorUnidade = new ProdutoPorUnidade(1, "Pasta Dental", "higiene pessoal", 1, "Rede pharma", 13.95);
	}

	/**
	 * Testa a igualdade do toString do ProdutoPorUnidade
	 */
	@Test
	public void testToString() {
		assertEquals(produtoPorUnidade.toString(), "1. Pasta Dental, higiene pessoal, Preco: <Rede pharma, R$ 13,95;>");
	}

	/**
	 * Testa a criacao do Construtor e verifica se não ocorre nenhum erro.
	 */
	@Test
	public void testProdutoPorUnidade() {
		produtoPorUnidade = new ProdutoPorUnidade(2, "Cenoura", "alimento nao industrializado", 6,
				"Mercadinho do Cabral", 21.20);
	}

	/**
	 * Testa o levantamento de erro atraves de um nome null
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComNomeNull() {
		produtoPorUnidade = new ProdutoPorUnidade(1, null, "alimento nao industrializado", 2, "MarinasCO", 99.99);
	}

	/**
	 * Testa o levantamento de erro atraves de um nome vazio
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComNomeVazio() {
		produtoPorUnidade = new ProdutoPorUnidade(1, "   ", "higiene pessoal", 2, "carefur", 99.99);
	}

	/**
	 * Testa o levantamento de erro atraves da categoria com valor null
	 */
	public void testProdutoPorUnidadeComCategoriaNull() {
		produtoPorUnidade = new ProdutoPorUnidade(2, "Cha de linho", null, 2, "Ervas & CIA", 4.20);
	}

	/**
	 * Testa o levantamento de erro atraves da categoria com valor vazio
	 */
	public void testProdutoPorUnidadeComCategoriaVazia() {
		produtoPorUnidade = new ProdutoPorUnidade(2, "Cha de linho", "  ", 2, "Ervas & CIA", 4.20);
	}

	/**
	 * Testa o levantamento de erro atraves da quantidade de unidades abaixo de zero
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComUnidadeAbaixoZero() {
		produtoPorUnidade = new ProdutoPorUnidade(3, "Esponja", "limpeza", -3, "carrefuor", 2.43);
	}

	/**
	 * Testa o levantamento de erro atraves do preco abaixo de zero
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComPrecoAbaixoZero() {
		produtoPorUnidade = new ProdutoPorUnidade(1, "lingua de gato", "alimento industrializado", 3, "Cacau xou",
				-20.43);
	}

	@Test
	public void testAdicionarLocalCompra() {
		this.produtoPorUnidade.adicionarLocalCompra("Cacau xou", 60.0);
	}
	@Test(expected= CampoInvalidoException.class)
	public void testAdicionarLocalCompraNomeVazio() {
		this.produtoPorUnidade.adicionarLocalCompra("   ", 60.0);
	}

	@Test(expected= CampoInvalidoException.class)
	public void testAdicionarLocalCompraValorAbaixoZero() {
		this.produtoPorUnidade.adicionarLocalCompra("Matins&Co", -502.0);
	}
	
	@Test(expected= CampoInvalidoException.class)
	public void testAdicionarLocalCompraNomeNull() {
		this.produtoPorUnidade.adicionarLocalCompra(null, 60.0);
	}
	
	/**
	 * Testa a igualdade do getUnidade
	 */
	@Test
	public void testProdutoPorUnidade1() {
		assertEquals(produtoPorUnidade.getUnidade(), 1);

	}

}