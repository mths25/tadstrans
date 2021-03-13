package br.com.transtads.response;

import java.util.List;
import java.util.Objects;


public class InfracaoResponse {

	private int id;
	private String descricao;

	private TipoInfracaoResponse tipoinfracao;
	private List<MultaResponse> multas;

	public InfracaoResponse() {
	}

	public List<MultaResponse> getMultas() {
		return multas;
	}

	public void setMultas(List<MultaResponse> multas) {
		this.multas = multas;
	}

	public TipoInfracaoResponse getTipoinfracao() {
		return tipoinfracao;
	}

	public void setTipoinfracao(TipoInfracaoResponse tipoinfracao) {
		this.tipoinfracao = tipoinfracao;
	}

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

	@Override
	public boolean equals(Object object) {
		// Basic checks.
		if (object == this)
			return true;
		if (!(object instanceof InfracaoResponse))
			return false;

		// Property checks.
		InfracaoResponse other = (InfracaoResponse) object;
		return Objects.equals(id, other.id) && Objects.equals(tipoinfracao, other.tipoinfracao)
				&& Objects.equals(descricao, other.descricao);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoinfracao, descricao);
	}

}
