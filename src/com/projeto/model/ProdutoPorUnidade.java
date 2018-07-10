package com.projeto.model;

import com.projeto.util.ValidadorSistema;

/**
 * Classe responsavel por Cadastrar os produtos por unidade
 * 
 * @author Igor de Sousa Pereira
 *
 */
public class ProdutoPorUnidade extends Item {
    /**
     * Quantidade de itens que o produto tem.
     */
    private int unidade;

    /**
     * Construtor do ProdutoPorUnidade que cria um objeto atraves do id, nome,
     * categoria, preco
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
        if (ValidadorSistema.validaProdutoPorUnidade(nome,unidade,categoria, localCompra, preco)) {
            this.unidade = unidade;
            super.adicionarLocalCompra(localCompra, preco);
        }
    }

    /**
     * Metodo de retorno das unidades compradass
     */
    public int getUnidade() {
        return this.unidade;
    }
    
    public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
    
    /**
     */
    public String toString() {
        return super.getId() + ". " + super.getNome() + ", " + super.getCategoria()+", Preco: "+super.getListaPrecos();
    }

}
