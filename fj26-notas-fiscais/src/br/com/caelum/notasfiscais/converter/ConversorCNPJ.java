package br.com.caelum.notasfiscais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.caelum.stella.format.CNPJFormatter;

@FacesConverter("cnpj")
public class ConversorCNPJ implements Converter{

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("desformatando: "+value);
		return new CNPJFormatter().unformat(value);
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String valor = value.toString();
		System.out.println("Formatando: "+valor);
		return new CNPJFormatter().format(valor);
	}

}
