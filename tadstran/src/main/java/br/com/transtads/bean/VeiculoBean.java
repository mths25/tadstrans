package br.com.transtads.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.transtads.dao.PerfilDao;
import br.com.transtads.dao.PessoaDao;
import br.com.transtads.dao.UsuarioDao;
import br.com.transtads.dao.VeiculoDao;
import br.com.transtads.persistence.Carro;
import br.com.transtads.persistence.Perfil;
import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Usuario;
import br.com.transtads.persistence.Veiculo;
import org.primefaces.PF;

@SessionScoped
@ManagedBean(name = "veiculobean")
public class VeiculoBean {

    private List<Veiculo> listagem;
    Pessoa pessoa = new Pessoa();
    Veiculo veiculo = new Veiculo();
    Carro carro = new Carro();

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Veiculo> getListagem() {
        return listagem;
    }

    public void setListagem(List<Veiculo> listagem) {
        this.listagem = listagem;
    }

    public void refresh() {
        PessoaDao pedao = new PessoaDao();
        //setListagem(pedao.listPolices());
    }

    public void save() {
        PessoaDao pedao = new PessoaDao();
        VeiculoDao vdao = new VeiculoDao();
        if (veiculo.getId() == 0) {
            vdao.inserir(veiculo);
        } else {
            vdao.alterar(veiculo);
        }
        refresh();
    }

    /*public void deletepessoa() {
		PessoaDao pedao = new PessoaDao();
		UsuarioDao udao = new UsuarioDao();
		try {
			Usuario user = udao.getById(pessoa.getUsuario().getId());;
			pessoa.setUsuario(null);
			pedao.excluir(pessoa);
			user.setPerfil(null);
			udao.excluir(user);
			//setListagem(pedao.listPolices());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Policial excluído",
					"<a href=\"listaPessoa.xhtml\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
    @PostConstruct
    public void init() {
        refresh();
        VeiculoDao veiculodao = new VeiculoDao();
        pessoa = new Pessoa();
        veiculo = new Veiculo();
        carro = new Carro();
        veiculo.setCarro(carro);
        veiculo.setPessoa(pessoa);

        //setListagem(pedao.listPolices());
    }

    public void add() {
        veiculo = new Veiculo();
    }

    public List<Veiculo> listagem() {
        VeiculoDao vedao = new VeiculoDao();
        return vedao.getList();
    }

    public void setVerVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        PF.current().ajax().update("j_idt7:dialogDadosVeiculo");
    }

}
