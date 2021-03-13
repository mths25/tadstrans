package br.com.transtads.util;

import org.hibernate.SessionFactory;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.transtads.persistence.Carro;
import br.com.transtads.persistence.Cidade;
import br.com.transtads.persistence.Estado;
import br.com.transtads.persistence.Marca;
import br.com.transtads.persistence.Perfil;
import br.com.transtads.persistence.Permissao;
import br.com.transtads.persistence.Pessoa;
import br.com.transtads.persistence.Transferencia;
import br.com.transtads.persistence.Usuario;
import br.com.transtads.persistence.Veiculo;;
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	 
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL,"jdbc:postgresql://localhost:5433/transtads");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				settings.put(Environment.SHOW_SQL, true);
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Pessoa.class);
				configuration.addAnnotatedClass(Carro.class);
				configuration.addAnnotatedClass(Veiculo.class);
				configuration.addAnnotatedClass(Marca.class);
				configuration.addAnnotatedClass(Transferencia.class);
				configuration.addAnnotatedClass(Cidade.class);
				configuration.addAnnotatedClass(Estado.class);
				configuration.addAnnotatedClass(Permissao.class);
				configuration.addAnnotatedClass(Perfil.class);
				configuration.addAnnotatedClass(Usuario.class);
				
				

				ServiceRegistry serviceRegistry = 
						new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
		
		
		
	}
	
	public static Session getSession()
    {
        return getSessionFactory().openSession();
    }
}
