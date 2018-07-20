package com.projeto.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe de teste responsavel por Testar a classe Compra.
 */
public class ComprasTest {
	/**
	 * Compra que sera tida como base para os testes.
	 */
	private Compra compras;

	/**
	 * Inicia o construtor Compra recebendo valores Validos.
	 */
	@Before
	public void iniciaCompra() {
		compras = new Compra(new ProdutoPorUnidade(1, "Cotonete", "higiene pessoal", 2, "Valmart", 21.1), 2);
	}

	/**
	 * Testa a inicializacao do construtor recebendo valores validos.
	 */
	@Test
	public void testCompra() {
		compras = new Compra(new ProdutoPorUnidade(1, "Cotonete", "higiene pessoal", 2, "Valmart", 21.1), 2);
	}

	/**
	 * Testa o metodo atualizar recebendo valores validos(operacao que adiciona).
	 */
	@Test
	public void testAtualizarAdiciona() {
		compras.atualizar("adiciona", 213);
		assertEquals(215, compras.getQuantidade());
	}

	/**
	 * Testa o metodo atualizar recebendo valores validos(operacao que diminui).
	 */
	@Test
	public void testAtualizarDiminui() {
		compras.atualizar("diminui", 1);
		assertEquals(1, compras.getQuantidade());
	}

	/**
	 * Testa o metodo atualizar recebendo operacao invalida.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizarOperacaoInvalida() {
		compras.atualizar("aumenta", 100000000);
	}

	/**
	 * Testa o metodo atualizar recebendo quantidade invalida.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizarQuantidadeInvalida() {
		compras.atualizar("adiciona", -200);
	}

	/**
	 * Testa o getDescricao da compra.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("2 Cotonete, higiene pessoal", compras.getDescricao());
	}

	/**
	 * Testa o metodo para pegar a quantidade de compras.
	 */
	@Test
	public void testGetQuantidade() {
		assertEquals(2, compras.getQuantidade());
	}

	/**
	 * Testa o metodo que retorna a representacao textual do produto.
	 */
	@Test
	public void testToString() {
		assertEquals("2 Cotonete, higiene pessoal", compras.toString());
		compras.atualizar("adiciona", 2);
		assertEquals("4 Cotonete, higiene pessoal", compras.toString());
	}

}
