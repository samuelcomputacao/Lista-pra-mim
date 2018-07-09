package com.projeto.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe responsavel por testar a classe ProdutoNaoIndustrializadoPorQuilo
 *
 */
public class ProdutoNaoIndustrializadoPorQuiloTest {
	
	/**
	 *  Produto utilizado como base para os testes
	 */
	private ProdutoNaoIndustrializadoPorQuilo produto;
	
	/**
	 * Metodo responsavel por inicialiazar o produto base e testar o construtor quando ele deve acontecer
	 */
	@Before
	@Test
	public void testProdutoNaoIndustrializadoPorQuilo() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloNomeNull() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, null, "higiene pessoal", 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloNomeVazio() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, " ", "higiene pessoal", 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaNull() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", null, 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaVazia() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", " ", 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaInexistente() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene", 1, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloLocalNull() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, null, 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloLocalVazio() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, " ", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloKgNegativo() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", -100, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloKGZerado() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 0, "Hiper", 100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloPrecoNegativo() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", -100);
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloPrecoZerado() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", 0);
	}
	
	@Test
	public void testGetQuilo() {
		assertTrue(1 == produto.getQuilo());
	}

	@Test
	public void testGetPreco() {
		//assertTrue(100 == produto.getPreco());
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionarLocalCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

}
