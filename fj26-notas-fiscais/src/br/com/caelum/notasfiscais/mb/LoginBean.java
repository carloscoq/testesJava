package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public String efetuaLogin(){
		
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		
		if(loginValido){
			return "produto?faces-redirect=true";
		}else{
			return "login";
		}
	}
	
	public String logout(){
		this.usuario = new Usuario();
		
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado(){
		return usuario.getLogin() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
