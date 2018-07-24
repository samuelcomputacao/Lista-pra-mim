package com.projeto.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.AtribultoInexistenteException;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;

/**
 * Classe responsavel pelos testes da Classe ProdutoQuantidadeFixa.
 *
 */

public class ProdutoQuantidadeFixaTest {

	/**
	 * Produto utilizado como base para os testes.
	 */
	private ProdutoQuantidadeFixa produto;

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com todos os seus
	 * parametros válidos.
	 */
	@Before
	@Test
	public void testProdutoQuantidadeFixa() {
		produto = new ProdutoQuantidadeFixa(1, "Feijão Boa Safra", "alimento nao industrializado", 10, "kg",
				"Hiper Bom Preço", 4.99);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o nome do produto
	 * null. (O que nao e permitido!)
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaNomeNull() {
		new ProdutoQuantidadeFixa(1, null, "higiene pessoal", 5, "l", "Mercadinho São José", 10.00);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o nome do produto
	 * vazio. (O que nao e permitido!)
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaNomeVazio() {
		new ProdutoQuantidadeFixa(1, "  ", "alimento industrializado", 10, "kg", "Atacadão", 4.75);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria do produto
	 * nula.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaCategoriaNula() {
		new ProdutoQuantidadeFixa(1, "Arroz Chinês", null, 5, "kg", "Assaí", 3.75);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria do produto
	 * vazia.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaCategoriaVazia() {
		new ProdutoQuantidadeFixa(1, "Macarrão espaguete", "  ", 3, "kg", "Hiper Bom Preço", 3.99);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria
	 * inexistente.
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testProdutoQuantidadeFixaCategoriaInexistente() {
		new ProdutoQuantidadeFixa(1, "Carne de Sol", "alimento", 5, "kg", "Assaí", 10.99);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a quantidade zerada.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaQuantidadeNula() {
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", 0, "kg", "Mercadinho Preço Bom",
				3.49);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a quantidade negativa.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaQuantidadeNegativa() {
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", -10, "kg", "Mercadinho Preço Bom",
				3.49);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a unidade de medida
	 * nula.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaUnidadeMedidaNula() {
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", 10, null, "Mercadinho Preço Bom",
				3.49);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a unidade de medida
	 * vazia.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaUnidadeMedidaVazia() {
		new ProdutoQuantidadeFixa(1, "Carne de Sol", "alimento industrializado", 5, "  ", "Atacadão Rio do Peixe",
				14.49);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o local de compra
	 * nulo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaLocalDeCompraNulo() {
		new ProdutoQuantidadeFixa(1, "Carne de Charque", "alimento industrializado", 5, "kg", null, 7.50);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o local de compra
	 * vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaLocalDeCompraVazio() {
		new ProdutoQuantidadeFixa(1, "Detergente Ypê", "limpeza", 2, "l", "   ", 3.00);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o preco negativo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaPrecoNegativo() {
		new ProdutoQuantidadeFixa(1, "Desinfetante Ypê", "limpeza", 2, "l", "Hiper Bom Preço", -100.2);
	}

	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o preco igual a zero.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaPrecoNulo() {
		new ProdutoQuantidadeFixa(1, "Desinfetante Ypê", "limpeza", 2, "l", "Hiper Bom Preço", 0);
	}

	/**
	 * Testa a representação String de um ProdutoQuantidadeFixa.
	 */
	@Test
	public void testToString() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>",
				produto.toString());
	}

	/**
	 * Testa o metodo que retorna a quantidade de um produto.
	 */
	@Test
	public void testGetQuantidade() {
		assertEquals(10, produto.getQuantidade());
	}

	/**
	 * Testa o metodo que altera a quantidade de um produto.
	 */
	@Test
	public void testSetQuantidade() {
		assertEquals(10, produto.getQuantidade());
		produto.setQuantidade(20);
		assertEquals(20, produto.getQuantidade());
	}

	/**
	 * Testa o metodo que retorna a unidade de medida de um produto.
	 */
	@Test
	public void testGetUnidadeMedida() {
		assertEquals("kg", produto.getUnidadeMedida());
	}

	/**
	 * Testa o metodo que altera a unidade de medida de um produto.
	 */
	@Test
	public void testSetUnidadeDeMedida() {
		assertEquals("kg", produto.getUnidadeMedida());
		produto.setUnidadeDeMedida("g");
		assertEquals("g", produto.getUnidadeMedida());
	}

	/**
	 * Testa o metodo adicionarLocalCompra com todos os seus parametros validos.
	 */
	@Test
	public void testAdicionarLocalCompraValidos() {
		produto.adicionarLocalCompra("Assaí", 4.30);
		produto.adicionarLocalCompra("Atacadão", 3.80);
		produto.adicionarLocalCompra("Carrefour", 3.00);
	}

	/**
	 * Testa o metodo adicionarLocalCompra com parametro localCompra vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraVazio() {
		produto.adicionarLocalCompra("   ", 10.1);
	}

	/**
	 * Testa o metodo adicionarLocalCompra com parametro localCompra nulo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraNull() {
		produto.adicionarLocalCompra(null, 10.1);
	}

	/**
	 * Testa o metodo equals, dois ProdutoQuantidadeFixa sao iguais se possuem mesmo
	 * nome e categoria.
	 */
	@Test
	public void testEqualsObject() {
		ProdutoQuantidadeFixa produto2 = new ProdutoQuantidadeFixa(2, "Feijão Boa Safra",
				"alimento nao industrializado", 2, "kg", "Carrefour", 3.50);
		assertEquals(produto, produto2);
	}

	/**
	 * Testa o metodo setNome que altera o nome de um ProdutoQuantidadeFixa.
	 */
	@Test
	public void testSetNome() {
		assertEquals("Feijão Boa Safra", produto.getNome());
		produto.setNome("Arroz Chinês");
		assertEquals("Arroz Chinês", produto.getNome());
	}

	/**
	 * Testa o metodo getNome que retorna o nome de um ProdutoQuantidadeFixa.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Feijão Boa Safra", produto.getNome());
	}

	/**
	 * Testa o metodo getCategoria que altera a categoria do produto.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals("alimento nao industrializado", produto.getCategoria());
	}

	/**
	 * Testa o metodo getId que retorna o identintificador unico do produto.
	 */
	@Test
	public void testGetId() {
		assertTrue(1 == produto.getId());
	}

	/**
	 * Testa o metodo getListaPrecos que mostra uma lista dos locais de compra que
	 * possuem determinado produto e seus respectivos valores.
	 */
	@Test
	public void testGetListaPrecos() {
		assertEquals("<Hiper Bom Preço, R$ 4,99;>", produto.getListaPrecos());
	}

	/**
	 * Testa o metodo setCategoria que altera a categoria de um produto.
	 */
	@Test
	public void testSetCategoria() {
		assertEquals("alimento nao industrializado", produto.getCategoria());
		produto.setCategoria("alimento industrializado");
		assertEquals("alimento industrializado", produto.getCategoria());
	}
	
	/**
	 * Testa o metodo atualizar item, onde o atributo a ser atualizado eh o nome.
	 */
	@Test
	public void testAtualizaItemPorNome() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
		produto.atualiza("nome", "Café Maratá");
		assertEquals("1. Café Maratá, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
	}
	
	/**
	 * Testa o metodo atualizar item, onde o atributo a ser atualizado eh a categoria.
	 */
	@Test
	public void testAtualizaItemPorCategoria() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
		produto.atualiza("categoria", "alimento industrializado");
		assertEquals("1. Feijão Boa Safra, alimento industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
	}
	
	/**
	 * Testa o metodo atualizar item, onde o atributo a ser atualizado eh a unidade de medida.
	 */
	@Test
	public void testAtualizaItemPorUnidadeDeMedida() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
		produto.atualiza("unidade de medida", "g");
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 g, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
	}
	
	/**
	 * Testa o metodo atualizar item, onde o atributo a ser atualizado eh a quantidade.
	 */
	public void testAtualizaItemPorQuantidade() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
		produto.atualiza("quantidade", "20");
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 20 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
	}
	
	/**
	 * Testa o metodo atualizar item, onde o atributo a ser atualizado eh um atributo inexistente.
	 */
	@Test(expected = AtribultoInexistenteException.class)
	public void testAtualizaItemPorAtributoInexistente() {
		assertEquals("1. Feijão Boa Safra, alimento nao industrializado, 10 kg, Preco: <Hiper Bom Preço, R$ 4,99;>", produto.toString());
		produto.atualiza("nenhum", "hello");	
	}

}
