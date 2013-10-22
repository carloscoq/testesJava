package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public void cadastrar(){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		
		if(usuario.getId() == null){
			dao.adiciona(usuario);
		}else{
			dao.atualiza(usuario);
		}
		
		this.usuario = new Usuario();
		this.usuarios = getUsuarios();
	}
	
	public List<Usuario> getUsuarios(){
		if(usuarios == null){
			System.out.println("Carregando Usuários...");
			usuarios = new DAO<Usuario>(Usuario.class).listaTodos();
		}
		
		return usuarios;
	}
	
	public void remove(Usuario usuario){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.remove(usuario);
		this.usuarios = getUsuarios();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
