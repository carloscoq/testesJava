package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.SessionScoped;


@SessionScoped
public class TemasBean implements Serializable{
	
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
