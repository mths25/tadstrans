package br.com.transtads.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.transtads.persistence.Pessoa;
import util.HibernateUtil;

public class HibernateTeste {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		
		Query query = session.createQuery("FROM Pessoa");
		List<Pessoa> pessoas = query.list();
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getNome());
		}

	}
}
