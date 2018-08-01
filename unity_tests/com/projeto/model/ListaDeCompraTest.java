package com.projeto.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.projeto.excecoes.CampoInvalidoException;
import com.projeto.excecoes.CompraNaoCadastrada;

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


	/**
	 * Testa o metodo atualiza lista de compra com compra nao cadastrada
	 */
	@Test(expected = CompraNaoCadastrada.class)
	public void testAtualizaCompraDeListaCompraNaoCadatrada() {
		lista.atualizaCompraDeLista(1, "adiciona", 1);
	}
	
	/**
	 * Testa o metodo atualiza lista de compra com operacao invalida
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testAtualizaCompraDeListaCompraOperacaoInvalida() {
		lista.atualizaCompraDeLista(1, "removenerrr", 1);
	}

	/**
	 * Testas o metodo que retorna a compra de uma lista quando ele nao foi cadatrada
	 */
	@Test
	public void testGetItemListaCompraNaoCadatrada() {
		assertEquals("", lista.getItemLista(10));
	}
	
	/**
	 * Testas o metodo que retorna a compra de uma lista
	 */
	@Test
	public void testGetItemListaCompra() {
		lista.adicionaCompraALista(1, sabonete);
		assertEquals("1 sabonete, higiene pessoal", lista.getItemLista(0));
	}

	/**
	 * Testa o metodo que busca todos os itens de uma lita de compras
	 */
	@Test
	public void testBuscaTodosItens() {
		lista.adicionaCompraALista(1, sabonete);
		assertEquals("1 sabonete, higiene pessoal" + System.lineSeparator() , lista.buscaTodosItens());
	}
	
	/**
	 * Testa o metodo que busca todos os itens de uma lita de compras que nao possui itens
	 */
	@Test
	public void testBuscaTodosItensSemItens() {
		assertEquals("", lista.buscaTodosItens());
	}

	/**
	 * Testa a pesquisa de uma compra nao cadatrada na lista de compra 
	 */
	@Test(expected = CompraNaoCadastrada.class)
	public void testPesquisaCompraEmListaQueNaoTemCompras() {
		lista.pesquisaCompraEmLista(1);
	}
	
	/**
	 * Testa a pesquisa de uma compra cadatrada na lista de compra
	 */
	@Test
	public void testPesquisaCompraEmLista() {
		lista.adicionaCompraALista(1, sabonete);
		assertEquals("1 sabonete, higiene pessoal",lista.pesquisaCompraEmLista(1));
	}

	/**
	 * Testa a finalizcao de uma lista de compra
	 */
	@Test
	public void testFinalizar() {
		lista.finalizar("Hiper", 1000);
		assertTrue(lista.isFinalizada());
	}
	
	/**
	 * Testa a finalizacao de uma lista de compra com o local invalido
	 */
	@Test(expected = CampoInvalidoException.class)
	public void testFinalizarLocalInvalido() {
		lista.finalizar("", 1000);
	}

	/**
	 * Testa a remocao de uma compra nao cadatrada
	 */
	@Test(expected = CompraNaoCadastrada.class)
	public void testDeletaCompraDeLista() {
		lista.deletaCompraDeLista(1);
	}

	/**
	 * Testa o metodo que retorna o descritor da lista
	 */
	@Test
	public void testGetDescritor() {
		assertEquals("produtos de limpeza", lista.getDescritor());
	}

	/**
	 * Testa o toString de uma lista de compra
	 */
	@Test
	public void testToString() {
		assertEquals("produtos de limpeza", lista.toString());
	}

	/**
	 * Testa o metodo que retorna o valor final da lista
	 */
	@Test
	public void testGetValorFinal() {
		lista.finalizar("hiper", 1000);
		assertEquals(1000, lista.getValorFinal());
	}

	/**
	 * Testa a verificacao de que um item esta na lista
	 */
	@Test
	public void testContemItem() {
		lista.adicionaCompraALista(1, sabonete);
		assertTrue(lista.contemItem("sabonete"));
	}
	
	/**
	 * Testa a verificacao de que um item esta na lista
	 */
	@Test
	public void testContemItemFalse() {
		assertFalse(lista.contemItem("sabonete"));
	}

	
	/**
	 * Testa se a lista nao tem compras cadastradas
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(lista.isEmpty());
	}
	
	/**
	 * Testa se a lista nao tem compras cadastradas
	 */
	@Test
	public void testIsEmptyFalse() {
		lista.adicionaCompraALista(1, sabonete);
		assertFalse(lista.isEmpty());
	}

	/**
	 * Testa o metodo que retorna o local onde a lista foi finalizada
	 */
	@Test
	public void testGetLocal() {
		lista.finalizar("hiper", 1000);
		assertEquals("hiper", lista.getLocal());
	}


}
