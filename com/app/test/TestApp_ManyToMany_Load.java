package com.app.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.utility.HibernateUtil;

public class TestApp_ManyToMany_Load {

	public static void main(String[] args) {
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		//create the query and get the values from parent
	/*	Query query=ses.createQuery("from Employee");
		
		List<Employee> emplist=query.list();
		for(Employee emps:emplist)
		{
			
			System.out.println("Parent:: "+emps);
			Set<Address> addrset=emps.getAddr();
				for(Address addr:addrset)
				{
					System.out.println("Child:: "+addr);
				}
		}*/
		//create the query and get the values from child
	Query query=ses.createQuery("from Address");
		
		List<Address> addrlist=query.list();
		for(Address addr:addrlist)
		{
			
			System.out.println("Child:: "+addr);
			Set<Employee> empset=addr.getEmps();
				for(Employee emp:empset)
				{
					System.out.println("Parent:: "+emp);
				}
		}
		
							//close the session and session factory
					HibernateUtil.closeSession(ses);
					HibernateUtil.closeFactory();
	}

}
