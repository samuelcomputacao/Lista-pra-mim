package com.projeto.model;

import org.junit.Before;
import org.junit.Test;
import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe responsável pelos testes da Classe ProdutoQuantidadeFixa.
 *
 */

public class ProdutoQuantidadeFixaTest {

	/**
	 * Produto utilizado como base para os testes.
	 */
	private ProdutoQuantidadeFixa produto;
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com todos os seus parâmetros válidos.
	 */
	@Before
	@Test
	public void testProdutoQuantidadeFixa() {
		produto = new ProdutoQuantidadeFixa(1, "Feijão Boa Safra", "alimento nao industrializado", 10, "kg", "Hiper Bom Preço", 4.99);
	}
	
	/**
	 * Testa o construtor da classe ProdutoQuantidadeFixa com o nome do produto null. (O que não é permitido!)
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoQuantidadeFixaNomeNull() {
		produto = new ProdutoQuantidadeFixa(1, null, "higiene pessoal", 5, "l", "Mercadinho São José", 10.00);
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
