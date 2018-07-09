package com.projeto.model;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;

public class SistemaTest {

	private Sistema sistema;

	@Before
	public void inicalizar() {
		sistema = new Sistema();
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com parametros válidos.
	 */
	@Test
	public void testAdicionaItemPorQuilo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com nome invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloNomeNull() {
		sistema.adicionaItemPorQuilo(null, "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com nome invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloNomeVazio() {
		sistema.adicionaItemPorQuilo("  ", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categorias validas.
	 */
	@Test
	public void testAdicionaItemPorQuiloCategoriasValidas() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento industrializado", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "higiene pessoal", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(nula).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloCategoriaNull() {
		sistema.adicionaItemPorQuilo("cuzcuz", null, 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(vazia).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloCategoriaVazia() {
		sistema.adicionaItemPorQuilo("cuzcuz", "   ", 12.5, "bar do cuzcuz", 30);
	}
	
	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(nome diferente).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloCategoriaInvalida() {
		sistema.adicionaItemPorQuilo("cuzcuz", "produtos bonitos", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com quilo invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloComQuiloNegativo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", -1, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com quilo valido, porem suspeito(zero).
	 */
	@Test
	public void testAdicionaItemPorQuiloComQuiloIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 0, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraNull() {
		sistema.adicionaItemPorQuilo("cuzcuz", "comida", 12.5, null, 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraVazio() {
		sistema.adicionaItemPorQuilo("cuzcuz", "comida", 12.5, "   ", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", -1);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco valido, porem suspeito(zero).
	 */
	@Test
	public void testAdicionaItemPorQuiloPrecoIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 0);
	}
	
}
