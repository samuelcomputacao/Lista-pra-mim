package com.projeto.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;

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
	 * Testa o metodo adicionaItemPorQtd com parametros válidos.
	 */
	@Test
	public void testAdicionaItemPorQtd() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro nome invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdNomeNull() {
		sistema.adicionaItemPorQtd(null, "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro nome invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdNomeVazio() {
		sistema.adicionaItemPorQtd("  ", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro categoria invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdCategoriaNull() {
		sistema.adicionaItemPorQtd("algodao", null, 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro categoria invalido(vazia).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdCategoriaVazia() {
		sistema.adicionaItemPorQtd("algodao", " ", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro quantidade invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdQuantidadeNula() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 0, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro quantidade
	 * invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdQuantidadeNegativa() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", -1, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro unidadeMedida invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdUnidadeMedidaNull() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, null, "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro unidadeMedida
	 * invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdUnidadeMedidaVazia() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro localDeCompra invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdLocalDeCompraNull() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", null, 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro localDeCompra
	 * invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdLocalDeCompraVazio() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "       ", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro preco invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdPrecoNulo() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 0.0);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro preco invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdPrecoNegativo() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", -1.0);
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
	@Test(expected = CategoriaInexistenteException.class)
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
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloComQuiloIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 0, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraNull() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, null, 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraVazio() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "   ", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", -1);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco valido, porem suspeito(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloPrecoIgualZero() {
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", 0);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valores aceitaveis.
	 */
	@Test
	public void testAdicionaItemPorUnidade() {
		assertEquals(sistema.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1000, "extra", 29.99), 1);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor inaceitavel(nome nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNomeNull() {
		sistema.adicionaItemPorUnidade(null, "limpeza", 1000, "extra", 29.99);
	}

}
