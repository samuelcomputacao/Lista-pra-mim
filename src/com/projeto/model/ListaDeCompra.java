package com.projeto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaDeCompra {
	
	private String descritor;
	
	private Date dataCriacao;
	
	private Map<Integer,Compra> compras;
	
	public ListaDeCompra(String descritor) {
		this.dataCriacao = new Date();
		this.descritor = descritor;
	}

	public void adicionaCompraALista(int quantidade, Integer idItem) {
		Compra compra = new Compra(idItem, quantidade);
		this.compras.put(idItem, compra);
		
	}

	

	public void atualizaCompraDeLista(Integer idItem, int quantidade) {
		this.compras.get(idItem).atualizar(quantidade);
		
	}

}
