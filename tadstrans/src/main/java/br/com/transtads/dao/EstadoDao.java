package br.com.transtads.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Estado;


public class EstadoDao extends PersistenceDao<Estado>{
    public Estado getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Estado>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Estado>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
}
