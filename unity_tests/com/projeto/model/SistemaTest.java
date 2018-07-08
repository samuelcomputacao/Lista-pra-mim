package com.projeto.model;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	private Sistema sistema;

	@Before
	public void inicalizar() {
		sistema = new Sistema();
	}

	/**
	 * Testa o método adicionaItemPorQuilo com parâmetros válidos.
	 */
	@Test
	public void testAdicionaItemPorQuilo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com nome inválido(nulo).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloNomeNull() {
		sistema.adicionaItemPorQuilo(null, "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com nome inválido(vazio).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloNomeVazio() {
		sistema.adicionaItemPorQuilo("  ", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com categorias válidas.
	 */
	@Test
	public void testAdicionaItemPorQuiloCategoriasValidas() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimentos industrializados", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "alimentos nao industrializados", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "higiene pessoal", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com categoria inválida(nula).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaNull() {
		sistema.adicionaItemPorQuilo("cuzcuz", null, 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com categoria inválida(vazia).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaVazia() {
		sistema.adicionaItemPorQuilo("cuzcuz", "   ", 12.5, "bar do cuzcuz", 30);
	}
	
	/**
	 * Testa o método adicionaItemPorQuilo com categoria inválida(nome diferente).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaInvalida() {
		sistema.adicionaItemPorQuilo("cuzcuz", "produtos bonitos", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com quilo inválido(negativo).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloComQuiloNegativo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", -1, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com quilo válido, porém suspeito(zero).
	 */
	@Test
	public void testAdicionaItemPorQuiloComQuiloIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 0, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com localDeCompra invalido(nulo).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloLocalCompraNull() {
		sistema.adicionaItemPorQuilo("cuzcuz", "comida", 12.5, null, 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com localDeCompra invalido(vazio).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloLocalCompraVazio() {
		sistema.adicionaItemPorQuilo("cuzcuz", "comida", 12.5, "   ", 30);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com preco invalido(negativo).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", -1);
	}

	/**
	 * Testa o método adicionaItemPorQuilo com preco valido, porem suspeito(zero).
	 */
	@Test
	public void testAdicionaItemPorQuiloPrecoIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 0);
	}

}
