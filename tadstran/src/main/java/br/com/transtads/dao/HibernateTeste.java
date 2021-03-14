package br.com.transtads.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.transtads.persistence.Veiculo;
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
		
		
		VeiculoDao pdao = new VeiculoDao();
		Veiculo v = pdao.getBy("placa", "RKE2534");
		System.out.println(v);
	}
}
