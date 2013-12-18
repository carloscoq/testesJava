package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.com.caelum.notasfiscais.modelo.Usuario;


@SessionScoped
public class UsuarioLogado implements Serializable{
	
	private Usuario usuario;
	
	public boolean isLogado(){
		return usuario != null;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
}
