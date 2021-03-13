package br.com.transtads.response;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class PessoaResponse {
	
	public PessoaResponse(int id, String documento, String nome, String email, UsuarioResponse usuario) {
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
	}
	

	private int id;
	private String documento;
	private String nome;
	private String email;
	

	private UsuarioResponse usuario;
	
	

	public PessoaResponse() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public UsuarioResponse getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
	}
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PessoaResponse)) return false;

        // Property checks.
        PessoaResponse other = (PessoaResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(documento, other.documento)
            && Objects.equals(nome, other.nome)
            && Objects.equals(email, other.email)
            && Objects.equals(usuario, other.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documento, nome, email, usuario);
    }
	
	
}
