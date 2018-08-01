package com.projeto.util;

import java.util.ArrayList;
import java.util.List;

import com.projeto.model.Compra;

/**
 * Classe utilitaria responsavel por associar um local de compra 
 * a diversos itens com seus respectivos valors naquele local
 *
 */
public class Estabelecimento implements Comparable<Estabelecimento>{
	
	/**
	 * Uma string representando o nome do local de compra
	 */
	private String nome;
	
	/**
	 * Um valor de ponto flutuante que indica o valor final de todos os itens deste local de compra
	 */
	private double valor;

	/**
	 * Uma lista contendo todas as compras de um local de compra
	 */
	private List<Compra> compras;
	
	/**
	 * Metodo responsavel por inicializar o estabelecimento na memoria
	 * @param nome : Uma String representando o nome do estabelecimento
	 */
	public Estabelecimento(String nome) {
		this.nome = nome;
		this.compras = new ArrayList<>();
	}
	
	/**
	 * Metodo responsavel por gerar uma representacao textual para o estabelecimento
	 */
	@Override
	public String toString() {
		
		return String.format("%s: R$ %.2f", nome,valor);
	}
	
	/**
	 * Metodo responsavel por adicionar uma compra a colecao de compras do estabelecimento
	 * @param compra : Um objeto do tipo compra que sera adicionado a colecao
	 * @param valor : O valor da compra
	 */
	public void add(Compra compra,Double valor) {
		this.compras.add(compra);
		this.valor += valor;
		
	}

	/**
	 * Metodo responsavel por comparar o estabelecimento pelo valor
	 */
	@Override
	public int compareTo(Estabelecimento estabelecimento) {
		if(this.valor < estabelecimento.getValor()) {
			return -1;
		}else if(this.valor > estabelecimento.getValor()) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Metodo responsavel por retornar o valor do estabelecimento
	 * @return
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Metodo responsavel por retornar a lista de compra do estabelecimento
	 * @return A lista de compra
	 */
	public List<Compra> getCompras() {
		return this.compras;
	}

}
