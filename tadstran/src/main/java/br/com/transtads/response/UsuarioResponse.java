package br.com.transtads.response;

import java.util.Objects;


public class UsuarioResponse {
		
	private int id;
	private String login;
	private String senha;
	
	private PerfilResponse perfil;
	private PessoaResponse pessoa;
	 
	
	public UsuarioResponse() {}
	
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

	public PerfilResponse getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilResponse perfil) {
		this.perfil = perfil;
	}

	
	public PessoaResponse getPessoa() { return pessoa; }
	  
	public void setPessoa(PessoaResponse pessoa) { this.pessoa = pessoa; }
	 
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof UsuarioResponse)) return false;

        // Property checks.
        UsuarioResponse other = (UsuarioResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(login, other.login)
            && Objects.equals(senha, other.senha)
            && Objects.equals(perfil, other.perfil)
            && Objects.equals(pessoa, other.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, senha, perfil, pessoa);
    }
	
}
