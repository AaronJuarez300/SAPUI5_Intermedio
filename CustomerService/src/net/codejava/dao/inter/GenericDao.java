package net.codejava.dao.inter;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import net.codejava.model.*;

public interface GenericDao <T,ID extends Serializable> {

	public T findById(ID id);
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public void delete(T entity);
	
	public void flush();
	
	public void clear();

	public void setSession(Session session);

	
	
}
