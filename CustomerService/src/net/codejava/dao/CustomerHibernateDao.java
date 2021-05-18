package net.codejava.dao;

import net.codejava.dao.inter.CustomerDao;
import net.codejava.model.Customer;

public class CustomerHibernateDao extends GenericDAOImplHibernate<Customer,Integer> implements CustomerDao{

}
