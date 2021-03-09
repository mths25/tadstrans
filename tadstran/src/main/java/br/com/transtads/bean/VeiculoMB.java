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
    
    public void iniciaEstadosCidades() {
        Estado estado1 = new Estado();
        estado1.setId(1);
        estado1.setNome("Parana");
        estado1.setSigla("PR");
        
        Estado estado2 = new Estado();
        estado2.setId(2);
        estado2.setNome("Santa Catarina");
        estado2.setSigla("SC");
        
        Estado estado3 = new Estado();
        estado3.setId(3);
        estado3.setNome("São Paulo");
        estado3.setSigla("SP");
        
        
        Cidade cidade1 = new Cidade();
        cidade1.setEstado(estado1);
        cidade1.setId(1);
        cidade1.setNome("Curitiba");
        
        Cidade cidade2 = new Cidade();
        cidade2.setEstado(estado1);
        cidade2.setId(2);
        cidade2.setNome("Londrina");
        
        Cidade cidade3 = new Cidade();
        cidade3.setEstado(estado1);
        cidade3.setId(3);
        cidade3.setNome("Umuarama");
        
        Cidade cidade4 = new Cidade();
        cidade4.setEstado(estado2);
        cidade4.setId(4);
        cidade4.setNome("Florianopolis");
        
        Cidade cidade5 = new Cidade();
        cidade5.setEstado(estado2);
        cidade5.setId(5);
        cidade5.setNome("Balneario Camburiu");
        
        Cidade cidade6 = new Cidade();
        cidade6.setEstado(estado2);
        cidade6.setId(6);
        cidade6.setNome("Blumenau");
        
        Cidade cidade7 = new Cidade();
        cidade7.setEstado(estado3);
        cidade7.setId(7);
        cidade7.setNome("São Paulo");
        
        Cidade cidade8 = new Cidade();
        cidade8.setEstado(estado3);
        cidade8.setId(8);
        cidade8.setNome("Bauru");
        
        Cidade cidade9 = new Cidade();
        cidade9.setEstado(estado3);
        cidade9.setId(9);
        cidade9.setNome("Campinas");
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        this.estados.add(estado3);
        
        this.cidades.add(cidade1);
        this.cidades.add(cidade2);
        this.cidades.add(cidade3);
        this.cidades.add(cidade4);
        this.cidades.add(cidade5);
        this.cidades.add(cidade6);
        this.cidades.add(cidade7);
        this.cidades.add(cidade8);
        this.cidades.add(cidade9);
        
        List<Cidade> listaCidades = new ArrayList<>();
        listaCidades.add(cidade1);
        listaCidades.add(cidade2);
        listaCidades.add(cidade3);        
        estado1.setCidades(listaCidades);
        
        listaCidades.clear();
        listaCidades.add(cidade4);
        listaCidades.add(cidade5);
        listaCidades.add(cidade6);        
        estado2.setCidades(listaCidades);
        
        listaCidades.clear();
        listaCidades.add(cidade7);
        listaCidades.add(cidade8);
        listaCidades.add(cidade9);        
        estado3.setCidades(listaCidades);
    }

    public void iniciaPessoas() {
        Endereco end1 = new Endereco();
        end1.setBairro("Bairro 1");
        end1.setCep("11111-111");
        end1.setCidade(this.cidades.get(0));
        end1.setComplemento("Proxi ao mercado 1");
        end1.setId(1);
        end1.setNumero(1);
        end1.setRua("Rua da Couves A");
        
        Endereco end2 = new Endereco();
        end2.setBairro("Bairro 2");
        end2.setCep("11111-112");
        end2.setCidade(this.cidades.get(1));
        end2.setComplemento("Proxi ao mercado 2");
        end2.setId(2);
        end2.setNumero(2);
        end2.setRua("Rua da Couves B");
        
        Endereco end3 = new Endereco();
        end3.setBairro("Bairro 3");
        end3.setCep("11111-113");
        end3.setCidade(this.cidades.get(2));
        end3.setComplemento("Proxi ao mercado 3");
        end3.setId(3);
        end3.setNumero(3);
        end3.setRua("Rua da Couves C");
        
        Pessoa pessoa1 =  new Pessoa();
        pessoa1.setEmail("email1@email.com");
        pessoa1.setEndereco(end1);
        pessoa1.setId(1);
        pessoa1.setNome("Pessoa Da Silva");
        pessoa1.setRg("22.176.359-4");
        pessoa1.setCpf("957.562.600-13");
        end1.setMorador(pessoa1);
        
        Pessoa pessoa2 =  new Pessoa();
        pessoa2.setEmail("email2@email.com");
        pessoa2.setEndereco(end2);
        pessoa2.setId(2);
        pessoa2.setNome("Pessoa Da Silva II");
        pessoa2.setRg("27.925.157-9");
        pessoa2.setCpf("999.506.650-51");
        end2.setMorador(pessoa2);
        
        Pessoa pessoa3 =  new Pessoa();
        pessoa3.setEmail("email3@email.com");
        pessoa3.setEndereco(end3);
        pessoa3.setId(3);
        pessoa3.setNome("Pessoa Da Silva III");
        pessoa3.setRg("31.533.813-1");
        end1.setMorador(pessoa3);
        
        this.pessoas.add(pessoa1);
        this.pessoas.add(pessoa2);
        this.pessoas.add(pessoa3);
    }
    
    public void iniciaVeiculo() {
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setAnoFab(1991);
        veiculo1.setAnoModelo(1990);
        veiculo1.setChassi("1BX eV5TEB v0 3c9650");
        veiculo1.setCombustivel(1);
        veiculo1.setCor("Branco");
        veiculo1.setDono(this.pessoas.get(0));
        veiculo1.setId(1);
        veiculo1.setMarca("Fiat");
        veiculo1.setModelo("Palio");
        veiculo1.setPlaca("BDJ-8249");
        veiculo1.setRenavam("40297052593");
        
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setAnoFab(1996);
        veiculo2.setAnoModelo(1995);
        veiculo2.setChassi("1BX eV5TEB v0 3c9650");
        veiculo2.setCombustivel(2);
        veiculo2.setCor("Preto");
        veiculo2.setDono(this.pessoas.get(1));
        veiculo2.setId(2);
        veiculo2.setMarca("Chevrolet");
        veiculo2.setModelo("Chevette");
        veiculo2.setPlaca("BDJ-8255");
        veiculo2.setRenavam("40297052666");
        
        Veiculo veiculo3 = new Veiculo();
        veiculo3.setAnoFab(2006);
        veiculo3.setAnoModelo(2005);
        veiculo3.setChassi("1BX eV5TEB v0 3c9650");
        veiculo3.setCombustivel(0);
        veiculo3.setCor("Azul");
        veiculo3.setDono(this.pessoas.get(2));
        veiculo3.setId(3);
        veiculo3.setMarca("Volkswagen");
        veiculo3.setModelo("Jetta");
        veiculo3.setPlaca("BDJ-8277");
        veiculo3.setRenavam("40297052777");    
        
        this.veiculos.add(veiculo1);
        this.veiculos.add(veiculo2);
        this.veiculos.add(veiculo3);
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
