package br.com.transtads.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nome")
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@OneToMany(mappedBy="cidade",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Pessoa>pessoas;
	
	public Cidade() {}

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Cidade)) return false;

        // Property checks.
        Cidade other = (Cidade) object;
        return Objects.equals(id, other.id)
            && Objects.equals(nome, other.nome)
            && Objects.equals(estado, other.estado)
            && Objects.equals(pessoas, other.pessoas);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado, pessoas);
    }


	
	
}
