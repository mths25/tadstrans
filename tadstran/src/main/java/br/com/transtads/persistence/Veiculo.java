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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="renavam")
	private String renavam;
	@Column(name="chassi")
	private String chassi;
	@Column(name="anofabricacao")
	private String anoFabricacao;
	@Column(name="anomodelo")
	private String anoModelo;
	@Column(name="combustivel")
	private String combustivel;
	@Column(name="cor")
	private String cor;
	@Column(name="placa")
	private String placa;
	
	@ManyToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="idcarro")
	private Carro carro;
	
	@OneToMany(mappedBy = "veiculo",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	private List<Transferencia> transferencia;
	
	public Veiculo(){}

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

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object==this) return true;
		if (!(object instanceof Veiculo)) return false;
		
		Veiculo other = (Veiculo) object;
		return Objects.equals(id, other.id)
		&& Objects.equals(renavam, other.renavam)
		&& Objects.equals(chassi, other.chassi)
		&& Objects.equals(anoFabricacao, other.anoFabricacao)
		&& Objects.equals(anoModelo, other.anoModelo)
		&& Objects.equals(combustivel, other.combustivel)
		&& Objects.equals(cor, other.cor)
		&& Objects.equals(placa, other.placa)
		&& Objects.equals(pessoa, other.pessoa)
		&& Objects.equals(carro, other.carro)
		&& Objects.equals(transferencia, other.transferencia);
	}
    public int hashCode() {
        return Objects.hash(id, renavam, chassi, anoFabricacao,anoModelo,combustivel,cor,placa,pessoa,carro,transferencia);
    }
	
}
