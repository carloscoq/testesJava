package br.com.caelum.notasfiscais.modelo;

import java.io.Serializable;

public class QuantidadePorProduto implements Serializable{
	
	private final Produto produto;
	private final Long quantidade;
	
	public QuantidadePorProduto(Long quantidade, Produto produto){
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}
}
