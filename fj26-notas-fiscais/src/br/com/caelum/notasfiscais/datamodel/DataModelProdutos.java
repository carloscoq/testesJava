package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

public class DataModelProdutos extends LazyDataModel<Produto> {

	@Override
	public List<Produto> load(int inicio, int quantidade, String campoOrdenacao,
			SortOrder sentidoOrdenacao, Map<String, String> filtros) {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		return dao.listaTodosPaginada(inicio, quantidade);
		
	}
}
