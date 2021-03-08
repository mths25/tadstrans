package br.com.transtads.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Usuario;
import br.com.transtads.util.HibernateUtil;

public class HibernateTeste {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		
		//Query query = session.createQuery("FROM Usuario");
		UsuarioDao uDau = new UsuarioDao();
		List<Usuario> usuarios = uDau.getList();
		
		
		for(Usuario u: usuarios) {
			System.out.println(u.getLogin());
		}

	}
}
