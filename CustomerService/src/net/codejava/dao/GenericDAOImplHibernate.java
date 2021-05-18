package net.codejava.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import java.lang.reflect.ParameterizedType;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import net.codejava.ws.HibernateUtil;
import net.codejava.dao.inter.GenericDao;
import net.codejava.model.Customer;

public class GenericDAOImplHibernate <T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> persistentClass;
	private Session session;
	private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());
	
	@SuppressWarnings("unchecked")
	public GenericDAOImplHibernate(){
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public List<T> findAll() {
		  Session session = getSession();
		           try {
		        	   
		               Query query = session.createQuery("SELECT e FROM " + persistentClass.getName() + " e");
		             List<T> entities = query.list();
		           
		               return entities;
		           } catch (Exception exc1) {
		              try {
		                   if (session.getTransaction().isActive()) {
		                       session.getTransaction().rollback();
		                  }
		              } catch (Exception exc) {
		                   LOGGER.log(Level.DEBUG,"Falló al hacer un rollback", exc);
		               }
		              
		          }
				return null;
	}
	
	public T findById(ID id) {
		return (T) getSession().load(this.getPersistentClass(), id);
	}
	public T save(T entity) {
		Transaction tx = this.getSession().beginTransaction();
		this.getSession().saveOrUpdate(entity);
		tx.commit();
		return entity;
	}
	public void delete(T entity) {
		Transaction tx = this.getSession().beginTransaction();
		this.getSession().delete(entity);
		tx.commit();
		
	}
	public void flush() {
		this.getSession().flush();
		
	}
	public void clear() {
		this.getSession().clear();
		
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion ... criterion){
		Criteria crit = this.getSession().createCriteria(this.getPersistentClass());
		
		for(Criterion c: criterion){
			crit.add(c);
		}
		return (List<T>) crit.list();
		
	}
	
	public void setSession(Session session) {
		this.session = session;
		
	}
	
	protected Session getSession(){
		if(this.session == null){
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		}
		return this.session;
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}


}
