package br.com.transtads.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Transferencia;
import br.com.transtads.persistence.Transferencia;

public class TransferenciaDao extends PersistenceDao<Transferencia>{
	
    public Transferencia getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Transferencia>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Transferencia>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
}
