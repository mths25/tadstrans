package br.com.transtads.response;

import java.util.List;
import java.util.Objects;

public class TipoInfracaoResponse {


	private int id;
	private String descricao;
	private int pontuacao;
	private float valor;

	private List<InfracaoResponse> infracoes;
	
	
	public List<InfracaoResponse> getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(List<InfracaoResponse> infracoes) {
		this.infracoes = infracoes;
	}

	public TipoInfracaoResponse() {
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

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
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
		if (object == this)
			return true;
		if (!(object instanceof TipoInfracaoResponse))
			return false;

		// Property checks.
		TipoInfracaoResponse other = (TipoInfracaoResponse) object;
		return Objects.equals(id, other.id) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(pontuacao, other.pontuacao) && Objects.equals(valor, other.valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descricao, pontuacao, valor);
	}

}
