package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.chart.PieChartModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.dao.GraficoDAO;
import br.com.caelum.notasfiscais.datamodel.DataModelProdutos;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.modelo.QuantidadePorProduto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	private LazyDataModel<Produto> dataModel;

	private List<Produto> produtos;
	private Integer somaPrecos;
	
	private GraficoDAO graficoDAO = new GraficoDAO();
	
	public ProdutoBean(){
		this.dataModel = new DataModelProdutos();
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		this.dataModel.setRowCount(dao.contaTodos());
	}

	
	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		if(produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
		somaPrecos(this.produtos);
		
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("Carregando produtos...");
			produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		//somaPrecos(produtos);
		return produtos;
	}
	
	public void somaPrecos(List<Produto> produtos){
		/**
		 * TODO Refazer a soma de preços
		 */
		System.out.println("Somando preços...");
		int soma = 0;
		for (Produto produto : produtos) {
			soma+=produto.getPreco();
		}
		setSomaPrecos(soma);
	}
	
	
	public Integer getSomaPrecos() {
		if(somaPrecos == null){
			somaPrecos(produtos);
		}
		return somaPrecos;
	}

	public void setSomaPrecos(Integer somaPrecos) {
		this.somaPrecos = somaPrecos;
	}
	
	public void remove(Produto produto){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
		somaPrecos(produtos);
	}
	
	public void cancelaAlteracao(){
		this.produto = new Produto();
	}
	
	public PieChartModel getRelatorioQuantidadePorProduto(){
		List<QuantidadePorProduto> list = graficoDAO.relatorioQuantidadePorProduto();
		PieChartModel model = new PieChartModel();
		
		for (QuantidadePorProduto qtde : list) {
			model.set(qtde.getProduto().getNome(),qtde.getQuantidade());
		}
		
		return model;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Produto getProduto() {
		return this.produto;
	}

	public void setDataModel(LazyDataModel<Produto> dataModel) {
		this.dataModel = dataModel;
	}

	public LazyDataModel<Produto> getDataModel() {
		return dataModel;
	}


	public GraficoDAO getGraficoDAO() {
		return graficoDAO;
	}


	public void setGraficoDAO(GraficoDAO graficoDAO) {
		this.graficoDAO = graficoDAO;
	}


}
