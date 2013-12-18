package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;


@Named
@RequestScoped
public class LoginBean implements Serializable{

	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDAO dao;
	
	@Inject
	private UsuarioLogado usuarioLogado;
	
	public String efetuaLogin(){
		
		boolean loginValido = dao.existe(this.usuario);
		
		if(loginValido){
			usuarioLogado.setUsuario(usuario);
			return "produto?faces-redirect=true";
		}else{
			usuarioLogado.setUsuario(null);
			return "login";
		}
	}
	
	public String logout(){
		usuarioLogado.setUsuario(null);
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado(){
		return usuarioLogado.isLogado();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
