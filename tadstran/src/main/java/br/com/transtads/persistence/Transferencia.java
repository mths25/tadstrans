package br.com.transtads.persistence;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="transferencia")
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idveiculo")
	private Veiculo veiculo;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorigem")
	private Pessoa pessoaOrigem;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iddestino")
	private Pessoa pessoaDestino;
	
	@Column(name="datat")
	private Date dataTransferencia;
	@Column(name="valor")
	private float valor;
	
	public Transferencia(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Pessoa getPessoaOrigem() {
		return pessoaOrigem;
	}

	public void setPessoaOrigem(Pessoa pessoaOrigem) {
		this.pessoaOrigem = pessoaOrigem;
	}

	public Pessoa getPessoaDestino() {
		return pessoaDestino;
	}

	public void setPessoaDestino(Pessoa pessoaDestino) {
		this.pessoaDestino = pessoaDestino;
	}

	public Date getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Transferencia)) return false;

        // Property checks.
        Transferencia other = (Transferencia) object;
        return Objects.equals(id, other.id)
            && Objects.equals(veiculo, other.veiculo)
            && Objects.equals(pessoaOrigem, other.pessoaOrigem)
            && Objects.equals(pessoaDestino, other.pessoaDestino)
            && Objects.equals(dataTransferencia, other.dataTransferencia)
            && Objects.equals(valor, other.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, veiculo, pessoaOrigem, pessoaDestino,dataTransferencia,valor);
    }
	
}
