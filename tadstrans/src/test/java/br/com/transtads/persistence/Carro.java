package br.com.transtads.persistence;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carro")
public class Carro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="descricao")
	private String descricao;
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;
	@OneToOne(mappedBy="carro")
	private Veiculo veiculo;
	
	
	
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

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
            && Objects.equals(veiculo, other.veiculo);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, marca, veiculo);
    }
	
}
