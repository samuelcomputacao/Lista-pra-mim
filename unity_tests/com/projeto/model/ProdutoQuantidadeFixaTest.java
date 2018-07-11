package com.projeto.model;

import org.junit.Before;
import org.junit.Test;

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
	@SuppressWarnings("unused")
	private ProdutoQuantidadeFixa produto;
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com todos os seus parametros válidos.
	 */
	@Before
	@Test
	public void testProdutoQuantidadeFixa() {
		produto = new ProdutoQuantidadeFixa(1, "Feijão Boa Safra", "alimento nao industrializado", 10, "kg", "Hiper Bom Preço", 4.99);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o nome do produto null. (O que nao e permitido!)
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaNomeNull() {
		new ProdutoQuantidadeFixa(1, null, "higiene pessoal", 5, "l", "Mercadinho São José", 10.00);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o nome do produto vazio. (O que nao e permitido!)
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaNomeVazio() {
		new ProdutoQuantidadeFixa(1, "  ", "alimento industrializado", 10, "kg", "Atacadão", 4.75);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria do produto nula.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaCategoriaNula() {
		new ProdutoQuantidadeFixa(1, "Arroz Chinês", null, 5, "kg", "Assaí", 3.75);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria do produto vazia. 
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaCategoriaVazia() {
		new ProdutoQuantidadeFixa(1, "Macarrão espaguete", "  ", 3, "kg", "Hiper Bom Preço", 3.99);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a categoria inexistente.
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
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", 0, "kg", "Mercadinho Preço Bom", 3.49);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a quantidade negativa.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaQuantidadeNegativa() {
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", -10, "kg", "Mercadinho Preço Bom", 3.49);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a unidade de medida nula.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaUnidadeMedidaNula() {
		new ProdutoQuantidadeFixa(1, "Salsicha Perdigão", "alimento industrializado", 10, null, "Mercadinho Preço Bom", 3.49);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com a unidade de medida vazia.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaUnidadeMedidaVazia() {
		new ProdutoQuantidadeFixa(1, "Carne de Sol", "alimento industrializado", 5, "  ", "Atacadão Rio do Peixe", 14.49);
	}
	
	@Test
	public void testToString() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetQuantidade() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetQuantidade() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUnidadeMedida() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetUnidadeDeMedida() {
		//fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		//fail("Not yet implemented");
	}

	@Test
	public void testItem() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAdicionarLocalCompra() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetNome() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetNome() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCategoria() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetListaPrecos() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetCategoria() {
		//fail("Not yet implemented");
	}

}
