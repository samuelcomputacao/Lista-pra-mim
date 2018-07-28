package com.project.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.projeto.controller.SistemaController;
import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CategoriaInexistenteException;
import com.projeto.excecoes.CompraNaoCadastrada;
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
		sistemaController.atualizaItem(1, "nome", "new name");
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
	 * Metodo responsavel por adicionar um preco a um item já cadastrado
	 */
	@Test
	public void testAdicionaPrecoItem() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaPrecoItem(1, "Feira da prata", 20.0);
	}

	/**
	 * Metodo voltado para adicionar um preco a um item indefinido, esperando o
	 * levantamento de erro.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaPrecoItemLocalIndefinido() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaPrecoItem(1, "   ", 20.0);
	}

	/**
	 * Metodo responsavel por adicionar um preco com valor negativo, esperando um
	 * levantamento de erro.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaPrecoItemValorNegatico() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaPrecoItem(1, "Sadia", -20.0);
	}

	/**
	 * Metodo responsavel por deletar um item ja cadastrado
	 */
	@Test
	public void testDeletaItem() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.deletaItem(1);
	}

	/**
	 * Metodo responsavel deletar um item que nao existe e levantar erro
	 */
	@Test(expected = ItemInexistenteException.class)
	public void testDeletaItemNaoCadastrado() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.deletaItem(2);
	}

	/**
	 * Metodo responsavel por retornar a representacao textual de um item que sera
	 * pesquisado
	 */
	@Test
	public void testGetItem() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		assertEquals("1. carne rosa, alimento nao industrializado, Preco por quilo: <assai, R$ 10,30;>" + "",
				sistemaController.getItem(0));
	}

	/**
	 * Metodo responsavel por retornar uma representacao textual vazia " "" "
	 * indicando que nao existe um item nessa posicao.
	 */
	@Test
	public void testGetItemInvalido() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		assertEquals("", sistemaController.getItem(2));
	}

	/**
	 * Metodo responsavel por retornar um item na respectiva ordenacao.
	 */
	@Test
	public void testGetItemPorCategoria() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaItemPorQuilo("Iogurte", "alimento industrializado", 4, "assai", 10.30);
		sistemaController.adicionaItemPorQuilo("frango", "alimento nao industrializado", 5, "assai", 40.0);
		sistemaController.adicionaItemPorQuilo("carne vermelha", "alimento nao industrializado", 8, "assai", 29.90);
		assertEquals("3. frango, alimento nao industrializado, Preco por quilo: <assai, R$ 40,00;>",
				sistemaController.getItemPorCategoria("alimento nao industrializado", 2));
	}

	/**
	 * Metodo responsavel por retornar uma representacao textual vazia " "" "
	 * indicando que nao existe um item nessa posicao.
	 */
	@Test
	public void testGetItemPorCategoriaNaoCadastrada() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaItemPorQuilo("Iogurte", "alimento industrializado", 4, "assai", 10.30);
		sistemaController.adicionaItemPorQuilo("frango", "alimento nao industrializado", 5, "assai", 40.0);
		sistemaController.adicionaItemPorQuilo("carne vermelha", "alimento nao industrializado", 8, "assai", 29.90);
		assertEquals("", sistemaController.getItemPorCategoria("higiene pessoal", 2));
	}

	/**
	 * Metodo responsavel por levantar um erro em pegar um item em uma categoria que
	 * nao existe.
	 */
	@Test(expected = CategoriaInexistenteException.class)
	public void testGetItemPorCategoriaInvalida() {
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		sistemaController.adicionaItemPorQuilo("Iogurte", "alimento industrializado", 4, "assai", 10.30);
		sistemaController.getItemPorCategoria("higiene impessoal", 2);
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
		assertEquals(sistemaController.getItemPorMenorPreco(0),
				"4. por fim sabonete, limpeza, Preco: <uau mart, R$ 1,00;>");
		assertEquals(sistemaController.getItemPorMenorPreco(1),
				"3. mais outro sabonete, limpeza, Preco: <uau mart, R$ 20,10;>");
		assertEquals(sistemaController.getItemPorMenorPreco(2),
				"2. mais sabonete, limpeza, Preco: <uau mart, R$ 50,10;>");
		assertEquals(sistemaController.getItemPorMenorPreco(3), "1. sabonete, limpeza, Preco: <carrefuor, R$ 92,30;>");

	}

	/**
	 * Testa o metodo getItemPorMenorPreco com posicao invalida(negativa)
	 */
	@Test
	public void testGetItemPorMenorPrecoPosicaoNegativa() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);

		assertEquals("", sistemaController.getItemPorMenorPreco(-1));
		assertEquals("", sistemaController.getItemPorMenorPreco(-100));
	}

	/**
	 * Testa o metodo getItemPorMenorPreco com posicao invalida(maior que a qtd de
	 * itens)
	 */
	@Test
	public void testGetItemPorMenorPrecoPosicaoInvalida() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);

		assertEquals("", sistemaController.getItemPorMenorPreco(3));
		assertEquals("", sistemaController.getItemPorMenorPreco(100));
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

		assertEquals(sistemaController.getItemPorPesquisa("carne", 0),
				"1. carne moida, alimento nao industrializado, Preco por quilo: <atacadao, R$ 12,30;>");
		assertEquals(sistemaController.getItemPorPesquisa("carne", 1),
				"3. carne rosa, alimento nao industrializado, Preco por quilo: <assai, R$ 10,30;>");
		assertEquals(sistemaController.getItemPorPesquisa("carne", 2),
				"2. carne seca, alimento nao industrializado, Preco por quilo: <hiper, R$ 11,30;>");
	}

	/**
	 * Testa o método getItemPorPesquisa com strNome existentes e inexistentes.
	 */
	@Test
	public void testGetItemPorPesquisaComNomeInexistente() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);

		assertEquals("", sistemaController.getItemPorPesquisa("carne de dinosauro", 0));
		assertEquals("", sistemaController.getItemPorPesquisa("carnii", 0));
		assertEquals("", sistemaController.getItemPorPesquisa("carne da boa", 0));

		assertNotEquals("", sistemaController.getItemPorPesquisa("c", 0));
		assertNotEquals("", sistemaController.getItemPorPesquisa("ca", 0));
		assertNotEquals("", sistemaController.getItemPorPesquisa("carne", 0));
	}

	/**
	 * Testa o metodo getItemPorPesquisa com posicao invalida(negativa)
	 */
	@Test
	public void testGetItemPorPesquisaComPosicaoNegativa() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);

		assertEquals("", sistemaController.getItemPorPesquisa("carne", -1));
		assertEquals("", sistemaController.getItemPorPesquisa("carne", -100));
	}

	/**
	 * Testa o metodo getItemPorPesquisa com posicao invalida (maior que o tamanho
	 * da lista)
	 */
	@Test
	public void testGetItemPorPesquisaComPosicaoInvalida() {
		sistemaController.adicionaItemPorQuilo("carne moida", "alimento nao industrializado", 2, "atacadao", 12.30);
		sistemaController.adicionaItemPorQuilo("carne seca", "alimento nao industrializado", 3, "hiper", 11.30);
		sistemaController.adicionaItemPorQuilo("carne rosa", "alimento nao industrializado", 2, "assai", 10.30);
		assertEquals("", sistemaController.getItemPorPesquisa("carne", 3));

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

	/**
	 * Testa o metodo que adiona uma compra de tal id a uma lista de compras.
	 */
	@Test
	public void testAdicionaCompraLista() {
		sistemaController.adicionaItemPorQtd("carne", "alimento nao industrializado", 2, "kg", "hiper bom preco", 2.50);
		sistemaController.adicionaListaDeCompras("feira");
		sistemaController.adicionaCompraALista("feira", 2, 1);
	}

	/**
	 * Testa o metodo que adiciona um item inexistente a uma lista de compras.
	 */
	@Test(expected = ItemInexistenteException.class)
	public void testAdicionaCompraListaInexistente() {
		sistemaController.adicionaListaDeCompras("feira do mes");
		sistemaController.adicionaCompraALista("feira do mes", 3, 1);
	}

	/**
	 * Testa o metodo que adiciona um item a lista nao inicializada.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaCompraDescritorNulo() {
		sistemaController.adicionaCompraALista(null, 2, 1);
	}

	/**
	 * Testa o metodo que finaliza uma lista de compras que ja foi inicializada.
	 */
	@Test
	public void testFinalizarListaDeCompras() {
		sistemaController.adicionaListaDeCompras("feirinha");
		sistemaController.finalizarListaDeCompras("feirinha", "assai", 150);
	}

	/**
	 * Testa o metodo que finaliza uma lista de compras que possui o descritor
	 * vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testFinalizarListaDeComprasDescritorVazio() {
		sistemaController.finalizarListaDeCompras("   ", "hiper bom preco", 100);
	}

	/**
	 * Testa o metodo que finaliza uma lista de compras que possui o local de compra
	 * vazio.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testFinalizarListaDeComprasLocalCompraVazio() {
		sistemaController.finalizarListaDeCompras("feira semanal", "  ", 100);
	}

	/**
	 * Testa o metodo que finaliza uma lista de compras que possui o valor total da
	 * compra negativo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testFinalizarListaDeComprasValorTotalNegativo() {
		sistemaController.finalizarListaDeCompras("feira semanal", "hiper bom preco", -120);
	}

	/**
	 * Testa o metodo que pesquisa uma compra em uma lista de compras, com todos os
	 * dados válidos.
	 */
	@Test
	public void testPesquisaCompraEmListaValida() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.pesquisaCompraEmLista("feirao", 1);
	}

	/**
	 * Testa o metodo que pesquisa por uma compra em uma lista de compras, com um id
	 * de uma compra que ainda nao foi cadastrada.
	 */
	@Test(expected = CompraNaoCadastrada.class)
	public void testPesquisaCompraEmListaIdCompraInexistente() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.pesquisaCompraEmLista("feirao", 2);
	}

	/**
	 * Testa o metodo que pesquisa por uma compra em uma lista de compras, com um id
	 * de compra negativo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testPesquisaCompraEmListaIdCompraNegativo() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.pesquisaCompraEmLista("feirao", -2);
	}

	/**
	 * Testa o metodo que pesquisa por uma compra em uma lista de compras com o
	 * descritor da lista vazio e o id da compra como negativo.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testPesquisaCompraEmListaIdDescritorVazio() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.pesquisaCompraEmLista(" ", -2);
	}

	/**
	 * Testa o metodo que atualiza a compra de uma lista de compras, possui todos os
	 * seus dados válidos.
	 */
	@Test
	public void testAtualizarCompraDeLista() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		assertEquals("2 macarrao fortaleza, alimento industrializado, 2 kg",
				sistemaController.pesquisaCompraEmLista("feirao", 1));
		sistemaController.atualizaCompraDeLista("feirao", 1, "adiciona", 4);
		assertEquals("6 macarrao fortaleza, alimento industrializado, 2 kg",
				sistemaController.pesquisaCompraEmLista("feirao", 1));
	}

	/**
	 * Testa o metodo que atualiza uma compra de uma lista e passa uma operacao
	 * invalida, ao inves de adiciona ou diminui.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizarCompraDeListaOperacaoInvalida() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.atualizaCompraDeLista("feirao", 1, "adicionar", 2);
	}

	/**
	 * Testa o metodo que atualiza o valor de uma compra em uma determinada lista de
	 * compras, que na verdade, nao existe.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizarCompraDeListaInexistente() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.atualizaCompraDeLista("feirinha", 1, "adicionar", 2);
	}

	/**
	 * Testa o metodo que atualiza o valor de uma compra em uma determinada lista de
	 * compras, porem, com o id de uma compra que ainda nao foi cadastrada.
	 */
	@Test(expected = CompraNaoCadastrada.class)
	public void testAtualizarCompraDeListaItemInexistente() {
		sistemaController.adicionaListaDeCompras("feirao");
		sistemaController.adicionaItemPorQtd("macarrao fortaleza", "alimento industrializado", 2, "kg", "atacadao",
				2.30);
		sistemaController.adicionaCompraALista("feirao", 2, 1);
		sistemaController.atualizaCompraDeLista("feirao", 3, "adiciona", 2);
	}

	/**
	 * Testa o metodo que retorna o item na posicao especificada de uma lista de
	 * compras ordenada.
	 */
	@Test
	public void testGetItemLista() {
		sistemaController.adicionaListaDeCompras("feira da semana");
		sistemaController.adicionaItemPorUnidade("feijao preto", "alimento nao industrializado", 3, "sacolao vivenda",
				5.50);
		sistemaController.adicionaItemPorUnidade("feijao verde", "alimento nao industrializado", 3, "mercado preco bom",
				4.50);
		sistemaController.adicionaItemPorUnidade("arroz chines", "alimento industrializado", 3, "atacadao", 3.50);
		sistemaController.adicionaCompraALista("feira da semana", 3, 1);
		sistemaController.adicionaCompraALista("feira da semana", 3, 2);
		sistemaController.adicionaCompraALista("feira da semana", 3, 3);
		assertEquals("3 feijao verde, alimento nao industrializado",
				sistemaController.getItemLista("feira da semana", 2));
	}

	/**
	 * Testa o metodo que retorna o item na posicao especificada em uma determinada
	 * lista de compras. Porém, com o id de um item que nao foi cadastrado na lista,
	 * assim e retornada uma string vazia indicando que o item nao foi encontrado.
	 */
	@Test
	public void testGetItemListaItemNaoCadastrado() {
		sistemaController.adicionaListaDeCompras("feira da semana");
		sistemaController.adicionaItemPorUnidade("feijao preto", "alimento nao industrializado", 3, "sacolao vivenda",
				5.50);
		sistemaController.adicionaItemPorUnidade("feijao verde", "alimento nao industrializado", 3, "mercado preco bom",
				4.50);
		sistemaController.adicionaItemPorUnidade("arroz chines", "alimento industrializado", 3, "atacadao", 3.50);
		sistemaController.adicionaCompraALista("feira da semana", 3, 1);
		sistemaController.adicionaCompraALista("feira da semana", 3, 2);
		sistemaController.adicionaCompraALista("feira da semana", 3, 3);
		assertEquals("", sistemaController.getItemLista("feira da semana", 4));
	}

	/**
	 * Testa o metodo que retorna o item na posicao especificada em uma determinada
	 * lista de compras. Porém, com o descritor vazio que eh invalido para o
	 * sistema.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testGetItemListaDescritorInvalido() {
		sistemaController.adicionaListaDeCompras("feira da semana");
		sistemaController.adicionaItemPorUnidade("feijao preto", "alimento nao industrializado", 3, "sacolao vivenda",
				5.50);
		sistemaController.adicionaItemPorUnidade("feijao verde", "alimento nao industrializado", 3, "mercado preco bom",
				4.50);
		sistemaController.adicionaItemPorUnidade("arroz chines", "alimento industrializado", 3, "atacadao", 3.50);
		sistemaController.adicionaCompraALista("feira da semana", 3, 1);
		sistemaController.adicionaCompraALista("feira da semana", 3, 2);
		sistemaController.adicionaCompraALista("feira da semana", 3, 3);
		assertEquals("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.",
				sistemaController.getItemLista("   ", 2));
	}

	// ##########################################
	// ## METODOS QUE AINDA NAO FORAM TESTADOS ##
	// ##########################################

	// TEST (pesquisaListaDeCompras)

	// TEST (deletaCompraDeLista)

	// TEST (dataAtual)

	// TEST (getItemListaPorData)

	// TEST (getItemListaPorItem)

	// TEST (pesquisaListasDeComprasPorData)

	// TEST (pesquisaListasDeComprasPorItem)

	// TEST (geraAutomaticaUltimaLista)

	// TEST (geraAutomaticaItem)

	// TEST (geraAutomaticaItensMaisPresentes)

	// TEST (sugereMelhorEstabelecimento)

	// TEST (fechaSistema)

}
