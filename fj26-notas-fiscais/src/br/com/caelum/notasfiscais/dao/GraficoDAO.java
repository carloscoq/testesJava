package br.com.caelum.notasfiscais.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.notasfiscais.modelo.QuantidadePorProduto;

public class GraficoDAO {

	private EntityManager em = new JPAUtil().getEntityManager();
	
	public List<QuantidadePorProduto> relatorioQuantidadePorProduto(){
		return em.createQuery("select new br.com.caelum.notasfiscais.modelo.QuantidadePorProduto(sum(i.quantidade),i.produto)"
				+" from Item i group by i.produto").getResultList();
	}
}
