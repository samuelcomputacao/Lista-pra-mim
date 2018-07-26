package com.projeto.model;

import com.projeto.excecoes.AtribultoInexistenteException;
import com.projeto.util.ValidadorSistema;

/**
 * 
 * Classe que representa uma um produto nao industrializado por quilo (subclasse
 * de da classe Item).
 *
 */
public class ProdutoNaoIndustrializadoPorQuilo extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6504601672287710007L;
	/**
	 * Um double que representa a quantidade em quilos do produto.
	 */
	private double quilo;

	/**
	 * Construtor que constroi um produto nao industrializado por quilo atraves de
	 * um id, nome, categoria, qtd em quilos, local de compra do produto e um preco.
	 * 
	 * @param id
	 *            : um inteiro que representa o id do produto.
	 * @param nome
	 *            : uma string que representa o nome do produto.
	 * @param categoria
	 *            : uma string que representa a categoria do produto.
	 * @param quilo
	 *            : um double que representa a quantidade em quilos do produto.
	 * @param localCompra
	 *            : uma string que representa o local de compra.
	 * @param preco
	 *            : um double que representa o preco do produto.
	 */
	public ProdutoNaoIndustrializadoPorQuilo(int id, String nome, String categoria, double quilo, String localCompra,
			double preco) {
		super(id, nome, categoria);
		if (ValidadorSistema.validaProdutoNaoIndustrializadoPorQuilo(quilo, localCompra, preco)) {
			this.quilo = quilo;
			super.adicionarLocalCompra(localCompra, preco);
		}
	}

	/**
	 * Metodo acessivel que retorna a quantidade em quilos do produto.
	 * 
	 * @return : um double que representa a quantidade em quilos do produto.
	 */
	public double getQuilo() {
		return quilo;
	}

	/**
	 * Metodo acessivel que altera a quantidade de quilos do produto.
	 * 
	 * @param quilo
	 *            um double que representa a quantidade em quilos do produto.
	 */
	public void setQuilo(double quilo) {
		if (ValidadorSistema.validaQuilo(quilo)) {
			this.quilo = quilo;
		}
	}

	/**
	 * Metodo responsavel por gerar uma representacao textual
	 * para um produto nao industrializado por quilo.
	 * 
	 * @return Uma String com a representacao textual gerada
	 */
	@Override
	public String toString() {
		return super.toString() + ", Preco por quilo: " + super.getListaPrecos();
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
		if(ValidadorSistema.validaAtualizacao(atribulto, novoValor)) {
			switch (atribulto) {
			
			case "nome":
				super.setNome(novoValor);
				break;
			case "categoria":
				super.setCategoria(novoValor);
				break;
			case "kg":
				
				double quilos = Double.parseDouble(novoValor);
				if(ValidadorSistema.validaQuilo(quilos)) {
					this.setQuilo(quilos);
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
		return super.getDescricao()+", "+ this.quilo;
	}

	@Override
	public int getQuantidade() {
		int quilos = (int) (this.quilo*100);
		return  quilos;
	}

	@Override
	public String getUnidadeMedida() {
		return "gramas";
	}
}
