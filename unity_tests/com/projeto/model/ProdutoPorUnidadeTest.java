package com.projeto.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.AtribultoInexistenteException;
import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe responsavel por testar a classe Produto por Unidade.
 */
public class ProdutoPorUnidadeTest {
	private ProdutoPorUnidade produtoPorUnidade;

	/**
	 * Inicializa o ProdutoPorUnidade.
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
	 * Testa o levantamento de erro atraves de um nome vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComNomeVazio() {
		produtoPorUnidade = new ProdutoPorUnidade(1, "   ", "higiene pessoal", 2, "carefur", 99.99);
	}

	/**
	 * Testa o levantamento de erro atraves da categoria com valor null.
	 */
	public void testProdutoPorUnidadeComCategoriaNull() {
		produtoPorUnidade = new ProdutoPorUnidade(2, "Cha de linho", null, 2, "Ervas & CIA", 4.20);
	}

	/**
	 * Testa o levantamento de erro atraves da categoria com valor vazio.
	 */
	public void testProdutoPorUnidadeComCategoriaVazia() {
		produtoPorUnidade = new ProdutoPorUnidade(2, "Cha de linho", "  ", 2, "Ervas & CIA", 4.20);
	}

	/**
	 * Testa o levantamento de erro atraves da quantidade de unidades abaixo de
	 * zero.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComUnidadeAbaixoZero() {
		produtoPorUnidade = new ProdutoPorUnidade(3, "Esponja", "limpeza", -3, "carrefuor", 2.43);
	}

	/**
	 * Testa o levantamento de erro atraves do preco abaixo de zero.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoPorUnidadeComPrecoAbaixoZero() {
		produtoPorUnidade = new ProdutoPorUnidade(1, "lingua de gato", "alimento industrializado", 3, "Cacau xou",
				-20.43);
	}

	/**
	 * Metodo responsavel por adicionar locais de compra para o atual produto.
	 */
	@Test
	public void testAdicionarLocalCompra() {
		this.produtoPorUnidade.adicionarLocalCompra("Cacau xou", 60.0);
		this.produtoPorUnidade.adicionarLocalCompra("PharmaLive", 20.21);
		this.produtoPorUnidade.adicionarLocalCompra("MachFarma", 5.99);
	}

	/**
	 * Metodo responsavel por detectar um erro ao adicionar um local de compra com o
	 * nome vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraNomeVazio() {
		this.produtoPorUnidade.adicionarLocalCompra("   ", 60.0);
	}

	/**
	 * Metodo responsavel por detectar um erro em adicionar um local de compra com
	 * nome vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraNomeNull() {
		this.produtoPorUnidade.adicionarLocalCompra(null, 60.0);
	}

	/**
	 * Metodo responsavel por detectar um erro atravez de adicionar um local de
	 * compra com valor 0.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraValorZero() {
		this.produtoPorUnidade.adicionarLocalCompra("Matins&Co", 0.0);
	}

	/**
	 * Metodo responsavel por detectar um erro atravez de adicionar um local de
	 * compra com valor abaixo de 0.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraValorAbaixoZero() {
		this.produtoPorUnidade.adicionarLocalCompra("Matins&Co", -502.0);
	}

	/**
	 * Metodo responsavel pela analise da igualdade entre 3 produtos.
	 */
	@Test
	public void testIgualdadeProdutoPorUnidade() {
		ProdutoPorUnidade produtoPorUnidade2 = new ProdutoPorUnidade(2, "sabonete", "higiene pessoal", 1, "uaumart",
				5.7);
		ProdutoPorUnidade produtoPorUnidade3 = new ProdutoPorUnidade(1, "Pasta Dental", "higiene pessoal", 1, "Lamarck",
				13.95);
		assertFalse(produtoPorUnidade2.equals(produtoPorUnidade));
		assertTrue(produtoPorUnidade3.equals(produtoPorUnidade));
	}

	/**
	 * Metodo responsavel pela verificacao do getCategoria do produtoPorUnidade.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals(this.produtoPorUnidade.getCategoria(), "higiene pessoal");
	}

	/**
	 * Metodo responsavel pela verificacao do getNome do produtoPorUnidade.
	 */
	@Test
	public void testGetNome() {
		assertEquals(this.produtoPorUnidade.getNome(), "Pasta Dental");
	}

	/**
	 * Metodo responsavel pela verificacao do getListaPrecos do produtoPorUnidade.
	 */
	@Test
	public void testGetListaPrecos() {
		this.produtoPorUnidade.adicionarLocalCompra("Pharma raia", 8.2);
		assertEquals(this.produtoPorUnidade.getListaPrecos(), "<Rede pharma, R$ 13,95;Pharma raia, R$ 8,20;>");
	}

	/**
	 * Testa a igualdade do getUnidade.
	 */
	@Test
	public void testProdutoPorUnidade1() {
		assertEquals(produtoPorUnidade.getUnidade(), 1);
	}
	/**
	 * Testa o metodo atualiza recebendo parametros validos.
	 */
	@Test
	public void testAtualiza() {
		assertEquals(produtoPorUnidade.atualiza("nome", "100"),1);
		assertEquals(produtoPorUnidade.atualiza("unidade", "200"),1);
		
	}
	/**
	 * Testa o metodo atualiza recebendo em parametro "atribulto" um valor invalido 
	 */
	@Test(expected=AtribultoInexistenteException.class)
	public void testAtualizaComAtribultoInvalido() {
		assertEquals(produtoPorUnidade.atualiza("nome", "100"),1);
		assertEquals(produtoPorUnidade.atualiza("unidade", "200"),1);
		assertEquals(produtoPorUnidade.atualiza("viagem", "2"),1);
		
	}
	/**
	 * Testa o metodo atualiza recebendo em parametro "novoValor" um valor invalido
	 */
	@Test(expected=CampoInvalidoException.class)
	public void testAtualizaComNovoValorInvalido() {
		assertEquals(produtoPorUnidade.atualiza("nome", "100"),1);
		assertEquals(produtoPorUnidade.atualiza("unidade", "-200"),1);
		
	}

}