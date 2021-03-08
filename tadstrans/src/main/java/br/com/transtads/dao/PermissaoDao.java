package br.com.transtads.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Permissao;
import br.com.transtads.persistence.Permissao;

public class PermissaoDao extends PersistenceDao<Permissao>{

	    public Permissao getBy(String attribute, Object value) {
	        Criterion ctrn = Restrictions.eq(attribute, value);
	        return getBy(ctrn);
	    }
	    
	    public List<Permissao>getList(){
	    	
	    	return getList(Order.asc("id"));
	    }
	    
	    public List<Permissao>getList(String search){
	    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
	        return getList(ctrnDescription, Order.asc("id"));
	    }
	    
	}

