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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pessoa")
public class Pessoa {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="email")
	private String email;
	@Column(name="logradouro")
	private String logradouro;
	@Column(name="cep")
	private String cep;
	@Column(name="complemento")
	private String complemento;
	@Column(name="documento")
	private String documento;
	
	@ManyToOne
	@JoinColumn(name="idcidade")
	private Cidade cidade;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@OneToOne(mappedBy="pessoaOrigem")
	private Transferencia transferencia;
	
	@OneToMany(mappedBy = "pessoa",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Veiculo> veiculos;
	
	public Pessoa() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Pessoa)) return false;

        // Property checks.
        Pessoa other = (Pessoa) object;
        return Objects.equals(id, other.id)
            && Objects.equals(documento, other.documento)
            && Objects.equals(nome, other.nome)
            && Objects.equals(email, other.email)
            && Objects.equals(usuario, other.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documento, nome, email, usuario);
    }

	
	
}

