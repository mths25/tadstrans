package br.com.transtads.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.transtads.util.HibernateUtil;

public abstract class PersistenceDao<T> implements EntityDao<T>,Serializable {
	protected transient HibernateUtil sessionBuilder;
	protected transient Class<T> persistentClass;
	
    public PersistenceDao() {
    	this.persistentClass = (Class<T>) ((ParameterizedType) 
	    	      getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	    @Override
	    public int inserir(T entity) {
	        int id = 0;
	        try {
	            Session session = HibernateUtil.getSession();
	            
	            Transaction tx = session.beginTransaction();
	            try {
	                
	                session.save(entity);
	                tx.commit();
	                
	
	            } catch (Exception ex) {
	                tx.rollback();                
	            }
	        } catch (Exception ex) {
	        }
	        return id;
	    }
	    @Override
	    public void alterar(T entity) {
	        try {
	            Session session = HibernateUtil.getSession();
	            Transaction tx = session.beginTransaction();
	            try {                
	                session.merge(entity);           
	                tx.commit();
	                
	
	            } catch (Exception ex) {
	                tx.rollback();
	            	ex.printStackTrace();
	            }
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	}
	     }
        @Override
        public void excluir(T entity) {
            try {
                Session session = HibernateUtil.getSession();
                Transaction tx = session.beginTransaction();
                try {
                    
                    session.refresh(entity);
                    session.delete(entity);
                    tx.commit();
                    
                      
                } catch (Exception ex) {
                    tx.rollback();
                	ex.printStackTrace();
                }
            } catch (Exception ex) {
            	ex.printStackTrace();
            	}
           
        }
            @Override
            public void excluir(List<T> entities) {
                try {
                    Session session = HibernateUtil.getSession();
                    Transaction tx = session.beginTransaction();
                    try {
                        for (T entity : entities) {
        	                session.refresh(entity);
        	                session.delete(entity);
                        }
                        tx.commit();
                        

                    } catch (Exception ex) {
                        tx.rollback();
                    }
                } catch (Exception ex) {
                }
            } 
        }

