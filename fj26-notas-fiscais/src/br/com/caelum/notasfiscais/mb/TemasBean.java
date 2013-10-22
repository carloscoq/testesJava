package br.com.caelum.notasfiscais.mb;

import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemasBean {
	
	private Map<String, String> temas;


	private String tema = "aristo";
	
	public TemasBean(){
		temas = new TreeMap<String,String>();
		
		temas.put("Aristo", "aristo");
		temas.put("Bluesky", "bluesky");
		temas.put("Cupertino", "cupertino");
		temas.put("Sam", "sam");
		temas.put("UI-Lightnes", "ui-lightnes");
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public Map<String, String> getTemas() {
		return temas;
	}

	public void setTemas(Map<String, String> temas) {
		this.temas = temas;
	}

}
