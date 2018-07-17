package com.projeto.model;

import java.util.Date;
import java.util.Map;

public class ListaDeCompra {
	
	private String descritor;
	
	private Date dataCriacao;
	
	private Map<Integer,Compra> compras;
	
	private boolean finalizada;
	
	private String local;
	
	private int valorFinal;
	
	public ListaDeCompra(String descritor) {
		this.dataCriacao = new Date();
		this.descritor = descritor;
		this.finalizada = false;
	}

	public void adicionaCompraALista(int quantidade, Integer idItem) {
		Compra compra = new Compra(idItem, quantidade);
		this.compras.put(idItem, compra);
		
	}

	

	public void atualizaCompraDeLista(Integer idItem, int quantidade) {
		this.compras.get(idItem).atualizar(quantidade);
		
	}

	public String getItemLista(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	public String pesquisaCompraEmLista(Integer idItem) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void finalizar(String local,int valorFinal) {
		this.local = local;
		this.finalizada = true;
		this.valorFinal = valorFinal;
	}
	
	public boolean isFinalizada() {
		return this.finalizada;
	}



}
