package br.com.transtads.persistence;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="carro")
public class Carro implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;
	
	@JsonIgnore
	@OneToMany(mappedBy="carro",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	private List<Veiculo> veiculos;
	
	
	
	public Carro() {}
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
	
	public Marca getMarca() {
		return marca;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Carro)) return false;

        // Property checks.
        Carro other = (Carro) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(marca, other.marca)
            && Objects.equals(veiculos, other.veiculos);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, marca);
    }
	
}