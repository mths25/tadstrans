package br.com.tadstrans.persistence;

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
	private int id;
	private String nome;
	private String descricao;
	private List<Usuario> usuarios;
	private Collection<Permissao> permissoes;
	
	public Perfil() {}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	@OneToMany(mappedBy="perfil",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@ManyToMany(targetEntity = Permissao.class, fetch = FetchType.EAGER)
	@JoinTable(name = "perfilpermissao",
	joinColumns = {@JoinColumn(name = "idperfil")},
	inverseJoinColumns = {@JoinColumn(name = "idpermissao")})
	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
