package com.projeto.model;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;

/**
 * Classe de teste que testa todas as funcionalidades da classe ListaDeCompras.
 */
public class ListaDeCompraTest {

	/**
	 * Lista de compras que sera usada nos testes.
	 */
	private ListaDeCompras lista;

	/**
	 * Itens que auxiliaram os testes.
	 */
	private Item cremeDental;
	private Item sabonete;

	@Before
	public void inicializa() {
		lista = new ListaDeCompras("produtos de limpeza");
		cremeDental = new ProdutoPorUnidade(1, "creme dental", "higiene pessoal", 1, "Rede pharma", 3.95);
		sabonete = new ProdutoPorUnidade(1, "sabonete", "higiene pessoal", 1, "dias", 0.95);
	}

	/**
	 * Testa o construtor com descritor valido.
	 */
	@Test
	public void testListaDeCompra() {
		new ListaDeCompras("compras que valeram a pena");
		new ListaDeCompras("feira de 12/12/2012");
		new ListaDeCompras("produtos para ceia natalina");
	}

	/**
	 * Testa o construtor com descritor invalido(nulo).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testListaDeCompraDescritorNull() {
		new ListaDeCompras(null);
	}

	/**
	 * Testa o construtor com descritor invalido(vazio).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testListaDeCompraDescritorVazio() {
		new ListaDeCompras("  ");
	}

	/**
	 * Testa o metodo adicionaCompraALista com tudo valido: compra ainda no
	 * adicionada e quantidade maior que zero.
	 */
	@Test
	public void testAdicionaCompraALista() {
		lista.adicionaCompraALista(10, cremeDental);
	}

	/**
	 * Testa o metodo adicionaCompraALista com Compra ja adicionada na lista de
	 * compras.
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaCompraAListaCompraJaAdicionada() {
		lista.adicionaCompraALista(2, cremeDental);
		lista.adicionaCompraALista(2, cremeDental);
	}

	/**
	 * Testa o metodo adicionaCompraALista com quantidade invalida (zero).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaCompraAListaQtdNula() {
		lista.adicionaCompraALista(0, cremeDental);
	}

	/**
	 * Testa o metodo adicionaCompraALista com quantidade invalida (negativa).
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAdicionaCompraAListaQtdNegativa() {
		lista.adicionaCompraALista(-1, cremeDental);
	}

	// Terminarei amanha (29/07/2018) o restante dos testes dessa classe.

	@Test
	public void testAtualizaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscaTodosItens() {
		fail("Not yet implemented");
	}

	@Test
	public void testPesquisaCompraEmLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFinalizada() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescritor() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testPossuiCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataFormatada() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataTextual() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValorFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetValorFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testContemItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaItens() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSugereMelhorEstabelecimento() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItens() {
		fail("Not yet implemented");
	}

}
