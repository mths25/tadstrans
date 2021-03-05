package br.com.transtads.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Pessoa;

public class PessoaDao extends PersistenceDao<Pessoa>{
	public List<Pessoa>getList(String search){
		Criterion ctrnDescription = Restrictions.like("nome", "%" + search + "%").ignoreCase();
        return getList();
	}
	
	public List<Pessoa>getList(){
		return getList(Order.asc("id").toString());
	}
	

}
