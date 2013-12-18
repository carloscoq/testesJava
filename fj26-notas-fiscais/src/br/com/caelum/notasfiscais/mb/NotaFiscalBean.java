package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

public class NotaFiscalBean implements Serializable{

	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;

	public void gravar(){
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
	}
	
	public void guardaItem(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		Produto produto = dao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
	}
	
	public void remover(NotaFiscal notaFiscal){
		if(notaFiscal == null || notaFiscal.getId() == null){
			System.out.println("num tem");
		}
		System.out.println("ok");
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		System.out.print("nota: ");
		System.out.print(notaFiscal.getCnpj());
		System.out.print(" / ");
		System.out.print(notaFiscal.getData());
		dao.remove(notaFiscal);
	}
	
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
}
