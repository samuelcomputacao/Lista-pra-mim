package com.projeto.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;

/**
 * Classe responsavel por testar a classe ProdutoNaoIndustrializadoPorQuilo.
 *
 */
public class ProdutoNaoIndustrializadoPorQuiloTest {
	
	/**
	 *  Produto utilizado como base para os testes.
	 */
	private ProdutoNaoIndustrializadoPorQuilo produto;
	
	/**
	 * Metodo responsavel por inicialiazar o produto base e testar o construtor quando ele deve acontecer.
	 */
	@Before
	@Test
	public void testProdutoNaoIndustrializadoPorQuilo() {
		produto= new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro nome invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloNomeNull() {
		new ProdutoNaoIndustrializadoPorQuilo(1, null, "higiene pessoal", 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro nome invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloNomeVazio() {
		new ProdutoNaoIndustrializadoPorQuilo(1, " ", "higiene pessoal", 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro categoria invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaNull() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", null, 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro categoria invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaVazia() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", " ", 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro categoria invalido(inexistente).
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testProdutoNaoIndustrializadoPorQuiloCategoriaInexistente() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene", 1, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro localCompra invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloLocalNull() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, null, 100);
	}
	
	/**
	 * Testa o construtor com parametro localCompra invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloLocalVazio() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, " ", 100);
	}
	
	/**
	 * Testa o construtor com parametro quilo invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloKgNegativo() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", -100, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro quilo invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloKGZerado() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 0, "Hiper", 100);
	}
	
	/**
	 * Testa o construtor com parametro preco invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloPrecoNegativo() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", -100);
	}
	
	/**
	 * Testa o construtor com parametro preco invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testProdutoNaoIndustrializadoPorQuiloPrecoZerado() {
		new ProdutoNaoIndustrializadoPorQuilo(1, "Sabonete", "higiene pessoal", 1, "Hiper", 0);
	}
	
	/**
	 * Testa o metodo getItem.
	 */
	@Test
	public void testGetQuilo() {
		assertTrue(1 == produto.getQuilo());
	}

	/**
	 * Testa o metodo toString.
	 */
	@Test
	public void testToString() {
		assertEquals("1. Sabonete, higiene pessoal, Preco por quilo: <Hiper, R$ 100,00;>", produto.toString());
	}

	/**
	 * Testa o metodo adicionarLocalCompra com parametros validos.
	 */
	@Test
	public void testAdicionarLocalCompraParametrosValidos() {
		this.produto.adicionarLocalCompra("hiper", 10.0);
		this.produto.adicionarLocalCompra("ideal", 11.5);
		this.produto.adicionarLocalCompra("redecompras", 9.60);
		this.produto.adicionarLocalCompra("wallmart", 14.0);
	}
	
	/**
	 * Testa o metodo adicionarLocalCompra com parametro localCompra vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraVazio() {
		this.produto.adicionarLocalCompra(" ", 10.1);
	}
	
	/**
	 * Testa o metodo adicionarLocalCompra com parametro localCompra null.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraNull() {
		this.produto.adicionarLocalCompra(null, 10.1);
	}
	
	/**
	 * Testa o metodo adicionarLocalCompra com parametro preco igual a zero.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraPrecoZero() {
		this.produto.adicionarLocalCompra("hiper", 0.0);
	}
	
	/**
	 * Testa o metodo adicionarLocalCompra com parametro preco igual a zero.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionarLocalCompraPrecoNegativo() {
		this.produto.adicionarLocalCompra("hiper", -0.01);
	}

	/**
	 * Testa o metodo equals baseando nos nomes de dois produtos.
	 */
	@Test
	public void testEqualsObjectNome() {
		ProdutoNaoIndustrializadoPorQuilo produto2 = new ProdutoNaoIndustrializadoPorQuilo(2, "Sabonete", "higiene pessoal", 10, "mercadinho ponto certo", 50);
		ProdutoNaoIndustrializadoPorQuilo produto3 = new ProdutoNaoIndustrializadoPorQuilo(2, "SabonetePoderoso", "higiene pessoal", 10, "mercadinho ponto certo", 50);
		assertTrue(this.produto.equals(produto2));
		assertFalse(this.produto.equals(produto3));
	}
	
	/**
	 * Testa o metodo equals baseando nas categorias de dois produtos.
	 */
	@Test
	public void testEqualsObjectCategoria() {
		ProdutoNaoIndustrializadoPorQuilo produto2 = new ProdutoNaoIndustrializadoPorQuilo(2, "Sabonete", "higiene pessoal", 10, "mercadinho ponto certo", 50);
		ProdutoNaoIndustrializadoPorQuilo produto3 = new ProdutoNaoIndustrializadoPorQuilo(2, "Sabonete", "limpeza", 10, "mercadinho ponto certo", 50);
		assertTrue(this.produto.equals(produto2));
		assertFalse(this.produto.equals(produto3));
	}

	/**
	 * Testa o metodo setNome.
	 */
	@Test
	public void testSetNome() {
		assertEquals("Sabonete", produto.getNome());
		produto.setNome("SaboneteAlterado");
		assertEquals("SaboneteAlterado", produto.getNome());
	}

	/**
	 * Testa o metodo getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Sabonete", produto.getNome());
	}

	/**
	 * Testa o metodo getCategoria.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals("higiene pessoal", produto.getCategoria());
	}

	/**
	 * Testa o metodo getId.
	 */
	@Test
	public void testGetId() {
		assertTrue(1 == produto.getId());
	}

}