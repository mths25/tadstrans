package br.com.transtads.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
    

    
    public Transferencia getByPerson(int search){
		Transferencia tsf= new Transferencia();

        String sqlScript = "select * from transferencia where idorigem = ?";
        Session session = sessionBuilder.getSession();
        
        SQLQuery qr = session.createSQLQuery(sqlScript);
        qr.setParameter(0, search);

        TransferenciaDao tdao = new TransferenciaDao();
        VeiculoDao vdao = new VeiculoDao();
        PessoaDao pdao = new PessoaDao();
        Transferencia ev;
        List<Object[]> objLst = qr.list();
        if (!objLst.isEmpty()) {
            for (Object[] obj : objLst) {
                tsf = new Transferencia(
                        (int) obj[0], 
                        vdao.getById((int)obj[1]),
                        (Date) obj[2], 
                        (float) Float.parseFloat( obj[3].toString()), 
                        pdao.getById((int)obj[5]));
               
            }
        }
        return tsf;
	}
    
}
