package com.app.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.utility.HibernateUtil;

public class TestApp_ManyToMany_Save {

	public static void main(String[] args) {
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		//create the objects and set the values
				Employee emp1=new Employee();
				Employee emp2=new Employee();
				Employee emp3=new Employee();
				emp1.setEmpId(1001);emp1.setEmpName("Pratik");
				emp2.setEmpId(1002);emp2.setEmpName("Rohit");
				emp3.setEmpId(1003);emp3.setEmpName("Shubham");
				
				Address addr1=new Address();
				Address addr2=new Address();
				addr1.setAddrId(101);addr1.setLocation("Pune");
				addr2.setAddrId(102);addr2.setLocation("Mumbai");
					//save the objects
				
				//set childs to parent
			
				addr1.getEmps().add(emp1);addr1.getEmps().add(emp2);
				addr2.getEmps().add(emp1);addr2.getEmps().add(emp3);
				

				//save objs (parent to child)

				emp1.getAddr().add(addr1);emp1.getAddr().add(addr2);
				emp2.getAddr().add(addr1);
				emp3.getAddr().add(addr2);
									
					try {
						tx=ses.beginTransaction();
				/*		ses.save(emp1);
						ses.save(emp2);
						ses.save(emp3);*/
						ses.save(addr1);
						ses.save(addr2);
				
						tx.commit();
						System.out.println("\n\n\t\tObjects saved Successfully");
						
					} catch (Exception e2) {
						tx.rollback();
						e2.printStackTrace();
						System.out.println("\n\n\t\tObjects not saved Successfully");
					}
						//close the session and session factory
					HibernateUtil.closeSession(ses);
					HibernateUtil.closeFactory();
	}

}
