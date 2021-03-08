package br.com.transtads.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.dao.PersistenceDao;
import br.com.transtads.persistence.Usuario;

public class UsuarioDao  extends PersistenceDao<Usuario> {
	public Usuario getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
	

    
    public List<Usuario>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("nome", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
	
	public boolean getByLoginPassword(String login, String senha) {
        String sqlScript = "Select 1 from Usuario where login = :login and senha = :senha ;";
        Session session = sessionBuilder.getSession();
        SQLQuery qr = session.createSQLQuery(sqlScript);
        System.out.println(qr.toString());
        qr.setParameter("login", login);
        qr.setParameter("senha", senha);
        if(qr.uniqueResult() != null)        	
        	return true;
        else
        	return false;
    }
	
}
	

