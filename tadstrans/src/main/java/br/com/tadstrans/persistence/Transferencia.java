package br.com.tadstrans.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="transferencia")
public class Transferencia {
	private int id;
	private Veiculo veiculo;
	private Pessoa pessoaOrigem;
	private Pessoa pessoaDestino;
	private Date dataTransferencia;
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
