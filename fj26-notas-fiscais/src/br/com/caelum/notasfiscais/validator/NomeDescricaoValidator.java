package br.com.caelum.notasfiscais.validator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("nomeedescricao")
public class NomeDescricaoValidator implements Validator, Serializable{

	@Inject @InputField
	private String nome;
	
	@Inject @InputField
	private String descricao;
	
	
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
					
				if(nome != null && descricao != null && nome.equals(descricao.replaceAll("\\<.*?>",""))){
					throw new ValidatorException(
							new FacesMessage("Nome e Descrição não podem ser iguais!")
							);
				}
		
	}
	

	public static String strip_tags(String text, String allowedTags) {
	      String[] tag_list = allowedTags.split(",");
	      Arrays.sort(tag_list);

	      final Pattern p = Pattern.compile("<[/!]?([^\\\\s>]*)\\\\s*[^>]*>",
	              Pattern.CASE_INSENSITIVE);
	      Matcher m = p.matcher(text);

	      StringBuffer out = new StringBuffer();
	      int lastPos = 0;
	      while (m.find()) {
	          String tag = m.group(1);
	          // if tag not allowed: skip it
	          if (Arrays.binarySearch(tag_list, tag) < 0) {
	              out.append(text.substring(lastPos, m.start())).append(" ");

	          } else {
	              out.append(text.substring(lastPos, m.end()));
	          }
	          lastPos = m.end();
	      }
	      if (lastPos > 0) {
	          out.append(text.substring(lastPos));
	          return out.toString().trim();
	      } else {
	          return text;
	      }
	  }
}
