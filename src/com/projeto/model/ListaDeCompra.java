package com.projeto.model;

import java.util.HashMap;
import java.util.Map;

public class ListaDeCompra {
	
	private String dataCriacao;
	
	@SuppressWarnings("unused")
	private Map<Integer,Item> lista;
	
	public ListaDeCompra(String dataCriacao) {
		this.dataCriacao = dataCriacao;
		this.lista = new HashMap<>();
	}
	
	public String getDataCriacao() {
		return this.dataCriacao;
	}
	

}
