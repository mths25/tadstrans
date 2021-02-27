package br.com.transtads.persistence;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="descricao")
	private String descricao;
	@OneToMany(mappedBy="perfil",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Usuario> usuarios;
	@ManyToMany(targetEntity = Permissao.class, fetch = FetchType.EAGER)
	@JoinTable(name = "perfilpermissao",
	joinColumns = {@JoinColumn(name = "idperfil")},
	inverseJoinColumns = {@JoinColumn(name = "idpermissao")})
	private Collection<Permissao> permissoes;
	
	public Perfil() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
