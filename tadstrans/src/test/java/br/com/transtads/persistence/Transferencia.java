package br.com.transtads.persistence;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="transferencia")
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idveiculo")
	private Veiculo veiculo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idorigem")
	private Pessoa pessoaOrigem;
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
	
	
}
