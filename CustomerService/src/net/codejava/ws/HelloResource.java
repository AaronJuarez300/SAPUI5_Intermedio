package net.codejava.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.codejava.dao.CustomerHibernateDao;

import net.codejava.dao.CustomerHibernateDao;
import net.codejava.dao.inter.CustomerDao;
import net.codejava.dao.inter.CustomerDao;
import net.codejava.model.Customer;
import net.codejava.model.Customer;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {
	
	
	@GET
	public List<Customer> getCustomers() {
		List<Customer> listCustomers= new ArrayList<>();
		HibernateUtil.buildSessionFactory();

    	try {
    	    HibernateUtil.openSessionAndBindToThread();

    	} finally {
    	    HibernateUtil.closeSessionAndUnbindFromThread();
    	}
		try {
			
			
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			CustomerDao dao = new CustomerHibernateDao();
			dao.setSession(session);
			
			
			listCustomers = dao.findAll();
			

		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			 HibernateUtil.closeSessionAndUnbindFromThread();
			
		}
		Gson gson = new Gson();
		System.out.println(listCustomers);
	    //String customers = gson.toJson(listCustomers);
	    //System.out.println(customers);
	    return listCustomers;   
	}
	
	@Path("/{id}")
	@GET
	public Response getCustomer(@PathParam("id") int id) {
		
	   
	    Customer customer = new Customer();
	    List<Customer> listCustomer= new ArrayList<>();
	    try {
	    	HibernateUtil.openSessionAndBindToThread();
	    }catch(Exception e){
	    	HibernateUtil.buildSessionFactory();
	    }
		try {
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			CustomerDao dao = new CustomerHibernateDao();
			dao.setSession(session);
			
			
			customer = dao.findById(id);
			
			listCustomer.add(customer);
			
		   
		    
		    GsonBuilder b = new GsonBuilder();
		    b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		    Gson gson = b.create();
		    String customerReturns = gson.toJson(customer);
		    System.out.println(customerReturns);
		    return Response.ok(customerReturns).build(); 
		    
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			 HibernateUtil.closeSessionAndUnbindFromThread();
			
		}
		
		return Response.ok("{\"msg\":false}",MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/{name}/{lastname}/{email}/{date}/{gender}")
	@POST
	public Response addCustomer(@PathParam("name") String name, @PathParam("lastname") String lastname,@PathParam("email") String email,@PathParam("date") String date, @PathParam("gender") String gender) {
		List<Customer> listCustomers= new ArrayList<>();
	    Customer product = new Customer(name, lastname, email, date, gender);
	    try {
	    	HibernateUtil.openSessionAndBindToThread();
	    }catch(Exception e){
	    	HibernateUtil.buildSessionFactory();
	    }
		try {
			
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			CustomerDao dao = new CustomerHibernateDao();
			dao.setSession(session);
			
			
			product = dao.save(product);
			listCustomers = dao.findAll();
			

			Gson gson = new Gson();
		    String customers = gson.toJson(listCustomers);
		    return Response.ok(customers).build(); 
		    
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			 HibernateUtil.closeSessionAndUnbindFromThread();
			
		}
		
		return Response.ok("{\"msg\":false}",MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/{id}/{name}/{lastname}/{email}/{date}/{gender}")
	@PUT
	public Response updateCustomer(@PathParam("id") int id,@PathParam("name") String name, @PathParam("lastname") String lastname,@PathParam("email") String email,@PathParam("date") String date,@PathParam("gender") String gender ) {
		List<Customer> listCustomers= new ArrayList<>();
	    Customer customer = new Customer(id, name, lastname, email, date, gender);
	    try {
	    	HibernateUtil.openSessionAndBindToThread();
	    }catch(Exception e){
	    	HibernateUtil.buildSessionFactory();
	    }
		try {
			
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			CustomerDao dao = new CustomerHibernateDao();
			dao.setSession(session);
			
			
			customer = dao.save(customer);
			listCustomers = dao.findAll();
			

			Gson gson = new Gson();
		    String customers = gson.toJson(listCustomers);
		    return Response.ok(customers).build(); 
		    
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			 HibernateUtil.closeSessionAndUnbindFromThread();
			
		}
		
		return Response.ok("{\"msg\":false}",MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/{id}/{name}/{lastname}/{email}/{date}/{gender}")
	@DELETE
	public Response deleteCustomer(@PathParam("id") int id,@PathParam("name") String name, @PathParam("lastname") String lastname,@PathParam("email") String email,@PathParam("date") String date,@PathParam("gender") String gender) {
		List<Customer> listCustomers= new ArrayList<>();
	    Customer customer = new Customer(id, name, lastname, email, date, gender);
	    try {
	    	HibernateUtil.openSessionAndBindToThread();
	    }catch(Exception e){
	    	HibernateUtil.buildSessionFactory();
	    }
		try {
			
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			CustomerDao dao = new CustomerHibernateDao();
			dao.setSession(session);
			
			
			dao.delete(customer);
			listCustomers = dao.findAll();
			

			Gson gson = new Gson();
		    String customers = gson.toJson(listCustomers);
		    return Response.ok(customers).build(); 
		    
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			 HibernateUtil.closeSessionAndUnbindFromThread();
			
		}
		
		return Response.ok("{\"msg\":false}",MediaType.APPLICATION_JSON).build();
	}
	
	
}
