package br.com.tadstrans.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Estado")

public class Estado {
	private int id;
	private String sigla;
	private String nome;
	private Estado estado;
	
	public Estado() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
