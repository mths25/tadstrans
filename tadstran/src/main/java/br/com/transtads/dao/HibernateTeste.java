package br.com.transtads.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Carro;
import br.com.transtads.util.HibernateUtil;

public class HibernateTeste {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		
		//Query query = session.createQuery("FROM Carro");
		CarroDao uDau = new CarroDao();
		List<Carro> Carros = uDau.getList();
		
		
		for(Carro u: Carros) {
			System.out.println(u.getDescricao());
		}

	}
}
