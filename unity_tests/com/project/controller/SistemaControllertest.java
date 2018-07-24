package com.project.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.projeto.controller.SistemaController;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.excecoes.ItemInexistenteException;
import com.projeto.excecoes.ItemJaExisteException;

/**
 * Classe de teste que verifica se todas as unidades da classe Sistema estao
 * funcionando da maneira esperada.
 *
 */
public class SistemaControllertest {

	private SistemaController sistemaController;

	/**
	 * Inicializando o sistema que sera testado.
	 */
	@Before
	public void inicalizar() {
		sistemaController = new SistemaController();
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametros válidos.
	 */
	@Test
	public void testAdicionaItemPorQtd() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
		sistemaController.adicionaItemPorQtd("sabonete", "higiene pessoal", 10, "gramas", "ideal supermercados", 14.41);
		sistemaController.adicionaItemPorQtd("detergente", "higiene pessoal", 600, "ml", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorQtdJaExistente() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 3, "quilos", "ideal", 1.57);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro nome invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdNomeNull() {
		sistemaController.adicionaItemPorQtd(null, "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro nome invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdNomeVazio() {
		sistemaController.adicionaItemPorQtd("  ", "higiene pessoal", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro categoria invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdCategoriaNull() {
		sistemaController.adicionaItemPorQtd("algodao", null, 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro categoria invalido(vazia).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdCategoriaVazia() {
		sistemaController.adicionaItemPorQtd("algodao", " ", 2, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro quantidade invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdQuantidadeNula() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 0, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro quantidade
	 * invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdQuantidadeNegativa() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", -1, "gramas", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro unidadeMedida invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdUnidadeMedidaNull() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, null, "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro unidadeMedida
	 * invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdUnidadeMedidaVazia() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "", "ideal supermercados", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro localDeCompra invalido(null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdLocalDeCompraNull() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", null, 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro localDeCompra
	 * invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdLocalDeCompraVazio() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "       ", 1.75);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro preco invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdPrecoNulo() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", 0.0);
	}

	/**
	 * Testa o metodo adicionaItemPorQtd com parametro preco invalido(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQtdPrecoNegativo() {
		sistemaController.adicionaItemPorQtd("algodao", "higiene pessoal", 2, "gramas", "ideal supermercados", -1.0);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com parametros válidos.
	 */
	@Test
	public void testAdicionaItemPorQuilo() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com nome invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloNomeNull() {
		sistemaController.adicionaItemPorQuilo(null, "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com nome invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloNomeVazio() {
		sistemaController.adicionaItemPorQuilo("  ", "limpeza", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categorias validas.
	 */
	@Test
	public void testAdicionaItemPorQuiloCategoriasValidas() {
		sistemaController.adicionaItemPorQuilo("biscoito", "alimento industrializado", 12.5, "vitamassa", 30);
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", 30);
		sistemaController.adicionaItemPorQuilo("sabao", "limpeza", 12.5, "ype supermercados", 30);
		sistemaController.adicionaItemPorQuilo("creme dental colgate", "higiene pessoal", 12.5, "ideal", 30);
		sistemaController.adicionaItemPorQuilo("sabonete", "higiene pessoal", 12.5, "ideal", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorQuiloJaExistente() {
		sistemaController.adicionaItemPorQuilo("sabonete", "higiene pessoal", 12.5, "ideal", 30);
		sistemaController.adicionaItemPorQuilo("sabonete", "higiene pessoal", 21.5, "supermercado qualquer", 50);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(nula).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloCategoriaNull() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", null, 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(vazia).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloCategoriaVazia() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "   ", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com categoria invalida(nome diferente).
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testAdicionaItemPorQuiloCategoriaInvalida() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "produtos bonitos", 12.5, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com quilo invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloComQuiloNegativo() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "limpeza", -1, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com quilo valido, porem suspeito(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloComQuiloIgualZero() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 0, "bar do cuzcuz", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraNull() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, null, 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com localDeCompra invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloLocalCompraVazio() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "   ", 30);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco invalido(negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", -1);
	}

	/**
	 * Testa o metodo adicionaItemPorQuilo com preco valido, porem suspeito(zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorQuiloPrecoIgualZero() {
		sistemaController.adicionaItemPorQuilo("cuzcuz", "alimento nao industrializado", 12.5, "bar do cuzcuz", 0);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valores validos.
	 */
	@Test
	public void testAdicionaItemPorUnidade() {
		assertEquals(sistemaController.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1000, "extra", 29.99), 1);
		assertEquals(sistemaController.adicionaItemPorUnidade("Sabao em po", "limpeza", 5, "extra", 26.88), 2);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorUnidadeJaExistente() {
		sistemaController.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1000, "extra", 29.99);
		sistemaController.adicionaItemPorUnidade("Saco de Lixo", "limpeza", 1, "artxe", 99.999);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(nome nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNomeNull() {
		sistemaController.adicionaItemPorUnidade(null, "limpeza", 1000, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(nome vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNomeVazio() {
		sistemaController.adicionaItemPorUnidade("   ", "higiene pessoal", 100, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(Categoria nula).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeCategoriaNull() {
		sistemaController.adicionaItemPorUnidade("Saco de lixo", null, 100, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(Categoria vazia).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeCategoriaVazia() {
		sistemaController.adicionaItemPorUnidade("Saco de lixo", "   ", 100, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(categoria
	 * inexistente).
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testAdicionaItemPorUnidadeCategoriaInvalida() {
		sistemaController.adicionaItemPorUnidade("mouse", "eletronica", 100, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com item ja existente.
	 */
	@Test(expected = ItemJaExisteException.class)
	public void testAdicionaItemPorUnidadeNomeIgual() {
		sistemaController.adicionaItemPorUnidade("sabao", "limpeza", 455, "maxx", 39.99);
		sistemaController.adicionaItemPorUnidade("sabao", "limpeza", 1000, "extra", 29.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(unidade nula).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeIgualAZero() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", 0, "maxx atacado", 39.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(unidade negativa).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeNegativa() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", -1, "maxx atacado", 39.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(localDeCompra null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeLocalCompraNull() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", 5, null, 39.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(localDeCompra
	 * vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadeLocalCompraVazio() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", 5, "  ", 39.99);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(preco igual a zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadePrecoIgualAZero() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", 5, "  ", 0.000);
	}

	/**
	 * Testa o metodo adicionaItemPorUnidade com valor invalido(preco negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaItemPorUnidadePrecoNegativo() {
		sistemaController.adicionaItemPorUnidade("sabao em po", "limpeza", 5, "  ", -1.22);
	}

	/**
	 * Testa o metodo exibeItem com parametro key valido (e item devidamente
	 * cadastrado).
	 */
	@Test
	public void testExibeItem() {
		testAdicionaItemPorQtd();
		assertEquals("1. algodao, higiene pessoal, 2 gramas, Preco: <ideal supermercados, R$ 1,75;>",
				sistemaController.exibeItem(1));
		assertEquals("2. sabonete, higiene pessoal, 10 gramas, Preco: <ideal supermercados, R$ 14,41;>",
				sistemaController.exibeItem(2));
		assertEquals("3. detergente, higiene pessoal, 600 ml, Preco: <ideal supermercados, R$ 1,75;>",
				sistemaController.exibeItem(3));
	}

	/**
	 * Testa o metodo exibeItem com parametro key invalido (zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testExibeItemValorNulo() {
		sistemaController.exibeItem(0);
	}

	/**
	 * Testa o metodo exibeItem com parametro key invalido (negativo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testExibeItemValorNegativo() {
		sistemaController.exibeItem(-1);
	}

	/**
	 * Testa o metodo exibeItem com parametro key invalido (inexistente).
	 */
	@Test(expected = ItemInexistenteException.class)
	public void testExibeItemInexistente() {
		testAdicionaItemPorQtd();
		sistemaController.exibeItem(4);
	}

	/**
	 * Testa o metodo atualizaItem com parametro invalido(key nula).
	 */
	@Test(expected = ItemInexistenteException.class)
	public void testAtualizaItem() {
		sistemaController.atualizaItem(0, "nome", "new name");
	}

	/**
	 * Testa o metodo atualizaItem com parametro invalido(atributo null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizaItemAtributoNull() {
		sistemaController.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistemaController.atualizaItem(1, null, "new name");
	}

	/**
	 * Testa o metodo atualizaItem com parametro invalido(atributo vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizaItemAtributoVazio() {
		sistemaController.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistemaController.atualizaItem(1, "     ", "new name");
	}

	/**
	 * Testa o metodo atualizaItem com parametro invalido(novoValor null).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizaItemNovoValorComValorNull() {
		sistemaController.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistemaController.atualizaItem(1, "nome", null);
	}

	/**
	 * Testa o metodo atualizaItem com parametro invalido(novoValor vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizaItemNovoValorComValorVazio() {
		sistemaController.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistemaController.atualizaItem(1, "nome", "   ");
	}

	/**
	 * Testa o metodo que retorna o produto na respectiva posicao requerida, depois
	 * de ordenada a partir do menor preco.
	 */
	@Test
	public void testGetItemPorMenorPreco() {
		sistemaController.adicionaItemPorUnidade("sabonete", "limpeza", 1, "carrefuor", 92.3);
		sistemaController.adicionaItemPorUnidade("mais sabonete", "limpeza", 2, "uau mart", 50.1);
		sistemaController.adicionaItemPorUnidade("mais outro sabonete", "limpeza", 1, "uau mart", 20.1);
		sistemaController.adicionaItemPorUnidade("por fim sabonete", "limpeza", 1, "uau mart", 1.0);
		assertEquals(sistemaController.getItemPorMenorPreco(1),
				"3. mais outro sabonete, limpeza, Preco: <uau mart, R$ 20,10;>");
	}

	/**
	 * Testa o metodo que retorna o produto na posicao requerida na lista ordenada
	 * de produtos com o nome especificado.
	 */
	@Test
	public void testGetItemPorPesquisa() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		assertEquals(sistemaController.getItemPorPesquisa("carne", 1),
				"3. carne rosa, alimento nao industrializado, Preco por quilo: <assai, R$ 10,30;>");
	}

	/**
	 * Testa o metodo que adiciona uma lista de compras com um descritor invalido.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaListaDeComprasDescritorInvalido() {
		sistemaController.adicionaListaDeCompras("   ");
	}

	/**
	 * Testa o metodo que adiciona uma lista de compras com o descritor nulo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaListaDeComprasDescritorNulo() {
		sistemaController.adicionaListaDeCompras(null);
	}

	/**
	 * Testa o metodo que adiciona uma lista de compras que já existe.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaListaDeComprasDescritorJaExistentes() {
		sistemaController.adicionaListaDeCompras("feira da semana");
		sistemaController.adicionaListaDeCompras("feira da semana");
	}

}
