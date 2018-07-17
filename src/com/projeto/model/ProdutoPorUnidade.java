package com.projeto.model;

import com.projeto.excecoes.AtribultoInexistenteException;
import com.projeto.util.ValidadorSistema;

/**
 * Classe responsavel por Cadastrar os produtos por unidade.
 *
 */
public class ProdutoPorUnidade extends Item {

	/**
	 * Quantidade de itens que o produto tem.
	 */
	private int unidade;

	/**
	 * Construtor do ProdutoPorUnidade que cria um objeto atraves do id, nome,
	 * categoria e preco.
	 * 
	 * @param id
	 *            indentificacao do produto
	 * @param nome
	 *            nome do produto
	 * @param categoria
	 *            categoria em que o produto esta
	 * @param preco
	 *            preco do produto
	 */
	public ProdutoPorUnidade(int id, String nome, String categoria, int unidade, String localCompra, double preco) {
		super(id, nome, categoria);
		if (ValidadorSistema.validaProdutoPorUnidade(unidade, localCompra, preco)) {
			this.unidade = unidade;
			super.adicionarLocalCompra(localCompra, preco);
		}
	}

	/**
	 * Metodo de retorno da quantidade de unidades que o produto possui
	 * 
	 * @return inteiro correspondente a quantidade.
	 */
	public int getUnidade() {
		return this.unidade;
	}

	/**
	 * Metodo responsavel por alterar a quantidade de unidades que o produto possui
	 * 
	 * @param unidade
	 *            : Um inteiro que indica a nova quantidade de unidades do produto
	 */
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	/**
	 * Metodo responsavel por gerar uma representacao textual para o produto
	 * 
	 * @return a repressentacao textual gerada
	 */
	@Override
	public String toString() {
		return super.getId() + ". " + super.getNome() + ", " + super.getCategoria() + ", Preco: "
				+ super.getListaPrecos();
	}

	/**
	 * Metodo  reponsavel pela  atualizacao
	 * para os seus valores
	 * 
	 * @param atribulto : Nome do atribulto que sera atualizado
	 * @param novoValor : O novo valor que sera atribuido ao atribulto
	 * @return : O identificador do item
	 */
	@Override
	public int atualiza(String atribulto, String novoValor) {
		if (ValidadorSistema.validaAtualizacao(atribulto, novoValor)) {
			switch (atribulto) {

			case "nome":
				super.setNome(novoValor);
				break;
			case "categoria":
				super.setCategoria(novoValor);
				break;
			case "unidade":
				int unidades = Integer.parseInt(novoValor);
				if (ValidadorSistema.validaUnidade(unidades)) {
					this.setUnidade(unidades);
				}
				break;
			default:
				throw new AtribultoInexistenteException();
			}
		}
		return super.getId();
	}
	@Override
	public String getDescricao() {
		return super.getNome() + ", " + super.getCategoria();
	}


	@Override
	public int getQuantidade() {
		return 0;
	}

	@Override
	public String getUnidadeMedida() {
		return "";
	}
}
