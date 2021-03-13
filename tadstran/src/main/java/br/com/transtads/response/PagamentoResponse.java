package br.com.transtads.response;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class PagamentoResponse {

	private int id;
	private Timestamp datapagamento;
	private int atrasodias;
	private float valor;
	

	private MultaResponse multa;
	
	
	public PagamentoResponse() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Timestamp datapagamento) {
		this.datapagamento = datapagamento;
	}

	public int getAtrasodias() {
		return atrasodias;
	}

	public void setAtrasodias(int atrasodias) {
		this.atrasodias = atrasodias;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public MultaResponse getMulta() {
		return multa;
	}

	public void setMulta(MultaResponse multa) {
		this.multa = multa;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PagamentoResponse)) return false;

        // Property checks.
        PagamentoResponse other = (PagamentoResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(datapagamento, other.datapagamento)
            && Objects.equals(atrasodias, other.atrasodias)
            && Objects.equals(valor, other.valor)
            && Objects.equals(multa, other.multa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datapagamento, atrasodias, valor, multa);
    }
	
}
