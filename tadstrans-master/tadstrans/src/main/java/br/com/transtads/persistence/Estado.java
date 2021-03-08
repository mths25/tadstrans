package br.com.transtads.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Estado")

public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "sigla")
	private String sigla;
	@Column(name="nome")
	private String nome;
	@OneToMany(mappedBy ="estado")
	private List<Cidade> cidade;
	
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
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Estado)) return false;

        // Property checks.
        Estado other = (Estado) object;
        return Objects.equals(id, other.id)
            && Objects.equals(sigla, other.sigla)
            && Objects.equals(nome, other.nome)
            && Objects.equals(cidade, other.cidade);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sigla, nome, cidade);
    }

	
	
}
