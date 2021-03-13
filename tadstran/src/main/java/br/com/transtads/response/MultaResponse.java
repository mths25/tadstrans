package br.com.transtads.response;

import java.sql.Timestamp;
import java.util.Objects;

public class MultaResponse {

	private int id;
	private String renavam;
	private String documento;
	private Timestamp datamulta;
	private String descricao;


	private InfracaoResponse infracao;
	private PagamentoResponse pagamento;

	public MultaResponse() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Timestamp getDatamulta() {
		return datamulta;
	}

	public void setDatamulta(Timestamp datamulta) {
		this.datamulta = datamulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public InfracaoResponse getInfracao() {
		return infracao;
	}

	public void setInfracao(InfracaoResponse infracao) {
		this.infracao = infracao;
	}

	@Override
	public boolean equals(Object object) {
		// Basic checks.
		if (object == this)
			return true;
		if (!(object instanceof MultaResponse))
			return false;

		// Property checks.
		MultaResponse other = (MultaResponse) object;
		return Objects.equals(id, other.id) && Objects.equals(renavam, other.renavam)
				&& Objects.equals(documento, other.documento) && Objects.equals(datamulta, other.datamulta)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(infracao, other.infracao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, renavam, documento, datamulta, descricao, infracao);
	}

}
