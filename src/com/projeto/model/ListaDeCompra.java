package 	com.projeto.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.projeto.excecoes.ItemInexistenteException;

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
		compras = new HashMap<>();
		this.finalizada = false;
	}

	public void adicionaCompraALista(int quantidade, Item item) {
		Compra compra = new Compra(item, quantidade);
		this.compras.put(item.getId(), compra);
	}

	public void atualizaCompraDeLista(Integer idItem, String operacao,int quantidade) {
		this.compras.get(idItem).atualizar(operacao,quantidade);
		if(this.compras.get(idItem).getQuantidade() <= 0)
			this.compras.remove(idItem);
	}

	public String getItemLista(int posicao) {
		
		return null;
	}

	public String pesquisaCompraEmLista(Integer idItem) {
		try {
			return this.compras.get(idItem).getDescricao();
		}catch(NullPointerException e) {
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
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
