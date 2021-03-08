package br.com.transtads.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Perfil;

public class PerfilDao extends PersistenceDao<Perfil> {
	
    public Perfil getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Perfil>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Perfil>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
}
