package br.com.transtads.persistence;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="permissao")
public class Permissao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="descricao")
	private String descricao;
	@ManyToMany(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy="perfil",
			fetch = FetchType.EAGER)
	private Collection<Perfil> perfis;
	public Permissao(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Collection<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
	
}
