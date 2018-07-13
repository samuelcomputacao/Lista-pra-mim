package com.projeto.principal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.excecoes.ItemInexistenteException;
import com.projeto.excecoes.ItemJaExisteException;
import com.projeto.principal.Sistema;

public class SistemaTest {

	private Sistema sistema;

	@Before
	public void inicalizar() {
		sistema = new Sistema();
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametros válidos.
	 */
	@Test
	public void testAdicionaItemPorQtd() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
		sistema.adicionaItemPorQtd("sabonete", "higiene pessoal", 10, "gramas", "ideal supermercados", 14.41);
		sistema.adicionaItemPorQtd("detergente", "higiene pessoal", 600, "ml", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorQtdJaExistente() {
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
		sistema.adicionaItemPorQtd("algodao", "higiene pessoal", 3, "quilos", "ideal", 1.57);
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
		sistema.adicionaItemPorQuilo("biscoito", "alimento industrializado", 12.5, "vitamassa", 30);
		sistema.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", 30);
		sistema.adicionaItemPorQuilo("sabao", "limpeza", 12.5, "ype supermercados", 30);
		sistema.adicionaItemPorQuilo("creme dental colgate", "higiene pessoal", 12.5, "ideal", 30);
		sistema.adicionaItemPorQuilo("sabonete", "higiene pessoal", 12.5, "ideal", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorQuiloJaExistente() {
		sistema.adicionaItemPorQuilo("sabonete", "higiene pessoal", 12.5, "ideal", 30);
		sistema.adicionaItemPorQuilo("sabonete", "higiene pessoal", 21.5, "supermercado qualquer", 50);
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
	 * Testa o metodo adicionaItemPorUnidade com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorUnidadeJaExistente() {
		sistema.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1000, "extra", 29.99);
		sistema.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1, "artxe", 99.999);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor inaceitavel(nome nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNomeNull() {
		sistema.adicionaItemPorUnidade(null, "limpeza", 1000, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor inaceitavel(nome vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNomeVazio() {
		sistema.adicionaItemPorUnidade("   ", "higiene pessoal", 100, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor inaceitavel(categoria
	 * invalida).
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testAdicionaItemPorUnidadeCategoriaInvalida() {
		sistema.adicionaItemPorUnidade("mouse", "eletronica", 100, "extra", 29.99);
	}
	
	/**
	 * Testa o metodo exibeItem com parametro key valido (e item devidamente cadastrado).
	 */
	@Test
	public void testExibeItem() {
		testAdicionaItemPorQtd();
		assertEquals("1. algodao, higiene pessoal, 2 gramas, Preco: <ideal supermercados, R$ 1,75;>", sistema.exibeItem(1));
		assertEquals("2. sabonete, higiene pessoal, 10 gramas, Preco: <ideal supermercados, R$ 14,41;>",sistema.exibeItem(2));
		assertEquals("3. detergente, higiene pessoal, 600 ml, Preco: <ideal supermercados, R$ 1,75;>",sistema.exibeItem(3));
	}
	
	/**
	 * Testa o metodo exibeItem com parametro key invalido (zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testExibeItemValorNulo() {
		sistema.exibeItem(0);	
	}
	
	/**
	 * Testa o metodo exibeItem com parametro key invalido (negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testExibeItemValorNegativo() {
		sistema.exibeItem(-1);	
	}
	
	/**
	 * Testa o metodo exibeItem com parametro key invalido (inexistente).
	 */
	@Test(expected = ItemInexistenteException.class)
	public void testExibeItemInexistente() {
		testAdicionaItemPorQtd();
		sistema.exibeItem(4);	
	}

	@Test
	public void testGetItemPorMenorPreco() {
		sistema.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistema.adicionaItemPorUnidade("mais sabonete", "limpeza", 2, "uau mart", 50.1);
		sistema.adicionaItemPorUnidade("mais outro sabonete", "limpeza", 1, "uau mart", 20.1);
		sistema.adicionaItemPorUnidade("por fim sabonete", "limpeza", 1, "uau mart", 1.0);
		assertEquals(sistema.getItemPorMenorPreco(1), "3. mais outro sabonete, limpeza, Preco: <uau mart, R$ 20,10;>");
	}

}
