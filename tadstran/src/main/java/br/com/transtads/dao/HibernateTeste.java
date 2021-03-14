package br.com.transtads.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Transferencia;
import br.com.transtads.util.HibernateUtil;

public class HibernateTeste {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		/*
		 * TransferenciaDao tdao = new TransferenciaDao();
		 * 
		 * int i = 41; Transferencia tsf = tdao.getByPerson(i); System.out.println(tsf);
		 */
		
		
		PessoaDao pdao = new PessoaDao();
		List<Pessoa>list = pdao.getGenericSearch("antelectus");
		System.out.println(list);
	}
}
