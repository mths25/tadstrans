package br.com.transtads.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.transtads.dao.UsuarioDao;
import br.com.transtads.persistence.Usuario;

@SessionScoped
@ManagedBean(name = "loginbean")
public class LoginBean extends BackingBean{

	private Usuario usuario = new Usuario();
	private String login;
	private String senha;
	
	public LoginBean() {
		
	}
	
	public String logIn() {
		UsuarioDao udao = new UsuarioDao();
		if (!udao.getByLoginPassword(usuario.getLogin(), usuario.getSenha())) {
			String errMessage = "Login ou senha incorretos";
			setJsfMessage("loginError", FacesMessage.SEVERITY_ERROR, errMessage);
			return null;
		}
		else {
			return "/dadosPessoa";
		}
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
