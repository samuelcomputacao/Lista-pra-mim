package com.projeto.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.projeto.util.ValidadorSistema;

/**
 * Classe responsavel por controlar todas as funcionalidades que envolvem locais de compras e precos
 */
public class PrecoService implements Serializable{
	
	
	private static final long serialVersionUID = 2011540169977318247L;
	/**
	 * Uma mapa de precos onde estao guardados locais e respectivos precos do item compravel.
	 */
	private Map<String, Double> mapaPrecos;

	/**
	 * Metodo responsavel por inicializar o controlador e seu mapeamento
	 * de locais para precos
	 */
	public PrecoService() {
		this.mapaPrecos = new HashMap<>();
	}

	/**
	 * Metodo responsavel por adicionar ao mapa de locais de compra um novo
	 * local de compra com seu respectivo preco.
	 * 
	 * @param local : Uma String representando um nome de um local para compra.
	 * @param preco : Um double representando o preco do produto no local indicado.
	 */
	public void adicionarLocalCompra(String local, Double preco) {
		if (ValidadorSistema.validaLocalDeCompra(local, preco)) {
			mapaPrecos.put(local, preco);
		}
	}
	
	/**
	 * Metodo responsavel por gerar uma String do mapa de precos.
	 * 
	 * @return : uma String que representa o mapa de precos de um item.
	 */
	public String getListaPrecos() {
		String msg = "<";
		for (String local : this.mapaPrecos.keySet()) {
			msg += local + ", R$ " + String.format("%.2f;", this.mapaPrecos.get(local));
		}
		msg += ">";
		return msg;
	}
	
	/**
	 * Metodo criado para pegar o menor preco do item.
	 * 
	 * @return : numero em ponto flutuante correspondente ao menor preco.
	 */
	public double getMenorPreco() {
		double menor = 0;
		for (double valor : mapaPrecos.values()) {
			if ((-1 * valor) < menor)
				menor = valor * -1;
		}
		return menor * -1;
	}

	/**
	 * Metodo responsavel por retornar um mapeamento de locais de compras e respectivos precos
	 * @return
	 */
	public Map<String, Double> getPrecos() {
		return this.mapaPrecos;
	}
	
}
