package br.com.transtads.bean;

/*import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PF;

import br.com.transtads.persistence.Cidade;
import br.com.transtads.persistence.Estado;
import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Veiculo;

@ManagedBean(name = "VeiculoMB")
@ViewScoped
public class VeiculoMB implements Serializable{
    private List<Veiculo> veiculos;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private List<Pessoa> pessoas;
    private Veiculo veiculo;
    private Pessoa pessoaSelect;
    private Pessoa pessoa;
    
    @PostConstruct
    public void init() {   
        this.veiculos = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.cidades = new ArrayList<>();
        this.pessoas = new ArrayList<>();
        iniciaEstadosCidades();
        iniciaPessoas();
        iniciaVeiculo();           
    }
    
 
    public void setVerVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        PF.current().ajax().update("j_idt7:dialogDadosVeiculo");
    }
    
    public void setEditVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        PF.current().ajax().update("j_idt7:dialogVeiculo");
    }
    
    public void setNovoVeiculo() {
        this.veiculo = new Veiculo();
        PF.current().ajax().update("j_idt7:dialogVeiculo");
    }
    
    public void setEditMeusDados() {
        this.pessoa = this.pessoas.get(0);
        PF.current().ajax().update("j_idt7:dialogPessoa");
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getPessoaSelect() {
        return pessoaSelect;
    }

    public void setPessoaSelect(Pessoa pessoaSelect) {
        this.pessoaSelect = pessoaSelect;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }    
}
*/
