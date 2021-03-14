package br.com.transtads.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Veiculo;


public class VeiculoDao extends PersistenceDao<Veiculo>{
    public Veiculo getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Veiculo>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Veiculo>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
    public List<Veiculo> getListByPerson(int search){
		List<Veiculo> lista = new ArrayList();

        String sqlScript = "select * from veiculo where idpessoa = ?;";
        Session session = sessionBuilder.getSession();
        
        SQLQuery qr = session.createSQLQuery(sqlScript);
        qr.setParameter(0, search);
        UsuarioDao udao = new UsuarioDao();
        TransferenciaDao tdao = new TransferenciaDao();
        CarroDao cdao = new CarroDao();
        Veiculo ev;
        List<Object[]> objLst = qr.list();
        if (!objLst.isEmpty()) {
            for (Object[] obj : objLst) {
                ev = new Veiculo(
                        (int) obj[0], 
                        (String) obj[1],
                        (String) obj[2], 
                        (String) obj[3], 
                        (String) obj[4],
                        (String) obj[5],
                        (String) obj[6],
                        (String) obj[7],
                        cdao.getById((int)obj[8]));
                lista.add(ev);
            }
        }
        return lista;
	}

    
}
