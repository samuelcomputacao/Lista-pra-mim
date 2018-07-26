package com.projeto.model;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento implements Comparable<Estabelecimento>{
	
	private String nome;
	
	private double valor;

	private List<Compra> compras;
	
	public Estabelecimento(String nome) {
		this.nome = nome;
		this.compras = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		
		return String.format("%s: R$ %.2f", nome,valor);
	}
	
	public void add(Compra compra,Double valor) {
		this.compras.add(compra);
		this.valor += valor;
		
	}

	@Override
	public int compareTo(Estabelecimento estabelecimento) {
		if(this.valor < estabelecimento.getValor()) {
			return -1;
		}else if(this.valor > estabelecimento.getValor()) {
			return 1;
		}
		return 0;
	}
	
	public double getValor() {
		return valor;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

}
