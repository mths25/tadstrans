package br.com.transtads.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.transtads.persistence.Pessoa;

public class PessoaDao extends PersistenceDao<Pessoa> {
	public List<Pessoa> getList(String search) {
		Criterion ctrnDescription = Restrictions.like("nome", "%" + search + "%").ignoreCase();
		return getList();
	}

	public List<Pessoa> getList() {
		return getList(Order.asc("id"));
	}

	public List<Pessoa> getGenericSearch(String search){
		List<Pessoa> lista = new ArrayList();

        String sqlScript = "select * from pessoa where nome like ? or documento like ? or email like ?;";
        Session session = sessionBuilder.getSession();
        
        SQLQuery qr = session.createSQLQuery(sqlScript);
        qr.setParameter(0, "%"+search+"%");
        qr.setParameter(1, "%"+search+"%");
        qr.setParameter(2, "%"+search+"%");
        UsuarioDao udao = new UsuarioDao();
        TransferenciaDao tdao = new TransferenciaDao();
        VeiculoDao vdao = new VeiculoDao();
        CidadeDao cdao = new CidadeDao();
        Pessoa ev;
        List<Object[]> objLst = qr.list();
        if (!objLst.isEmpty()) {
            for (Object[] obj : objLst) {
                ev = new Pessoa(
                        (int) obj[0], 
                        (String) obj[1],
                        (String) obj[2], 
                        (String) obj[3], 
                        (String) obj[4],
                        (String) obj[5],
                        (String) obj[6],
                        cdao.getById((int)obj[7]),
                        (String) obj[8],
                        udao.getById((int)obj[9]),
                        		tdao.getByPerson((int)obj[0]),
                        				vdao.getListByPerson((int)obj[0]));
                lista.add(ev);
            }
        }
        return lista;
	}

}
