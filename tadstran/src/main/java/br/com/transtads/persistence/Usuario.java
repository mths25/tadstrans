package br.com.transtads.persistence;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="login")
	private String login;
	@Column(name="senha")
	private String senha;
	@ManyToOne()
	@JoinColumn(name="tipoperfil")
	private Perfil perfil;
	@JsonIgnore
	@OneToOne(mappedBy="usuario")
	private Pessoa pessoa;

	
	public Usuario() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Perfil getPerfil() {
		return perfil;
		
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Usuario)) return false;

        // Property checks.
        Usuario other = (Usuario) object;
        return Objects.equals(id, other.id)
            && Objects.equals(login, other.login)
            && Objects.equals(senha, other.senha)
            && Objects.equals(perfil, other.perfil)
            && Objects.equals(pessoa, other.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, senha, perfil);
    }

	
	
	
	
}
