package br.com.caelum.notasfiscais.validator;

import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("nomeProdutoExiste")
public class ProdutoExisteValidator implements Validator,Serializable{

	@Inject
	private EntityManager em;
	
	@Inject @InputField
	private String nome;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
				
				Query q = em.createQuery("SELECT count(p) FROM Produto p WHERE p.nome like :nome");
				q.setParameter("nome", nome);
				Long count = (Long) q.getSingleResult();
				
				if(count != 0){
					throw new ValidatorException(
							new FacesMessage("O nome do produto '"+nome+"' já existe")
							);
				}
	}

}
