package br.com.tadstrans.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="permissao")
public class Permissao {
	private int id;
	private String descricao;
	
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
	
	
}
