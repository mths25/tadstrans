package br.com.transtads.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PF;

import br.com.transtads.dao.UsuarioDao;
import br.com.transtads.persistence.Usuario;
import br.com.transtads.persistence.Veiculo;
import br.com.transtads.persistence.Perfil;

@SessionScoped
@ManagedBean(name = "usuariobean")
public class UsuarioBean {
	Usuario usuario = new Usuario();
	
	public void save() {
		UsuarioDao udao = new UsuarioDao();
		System.out.println(usuario);
		Perfil perfil = new Perfil();
		perfil.setId(13);
		usuario.setPerfil(perfil);
		if (usuario.getId() == 0) {
			udao.inserir(usuario);
		} else {
			udao.alterar(usuario);
		}
	}
	
	public String redireciona() {
        return "/index";
    }

	public void deleteusuario() {
		UsuarioDao udao = new UsuarioDao();
		try {
			udao.excluir(usuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluido",
					"<a href=\"\">Sair</a>");
			PF.current().dialog().showMessageDynamic(message, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		usuario = new Usuario();

		UsuarioDao udao = new UsuarioDao();
	}

	public void add() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}
