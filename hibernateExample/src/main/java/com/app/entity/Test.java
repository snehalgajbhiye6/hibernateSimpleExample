package com.app.entity;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {
	private static SessionFactory sf=null;
	Scanner sc=new Scanner(System.in);
	static
	{
	    Configuration con= new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(con.getProperties());
		ServiceRegistry serviceRegistry =builder.build();
		sf= con.buildSessionFactory(serviceRegistry);
   	}

	public void insert()
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		boolean flag=Boolean.FALSE;
		System.out.println("How many employee do you want?");
		int noOfemp=sc.nextInt();
		for(int i=0;i<noOfemp;i++)
		{
			Employee emp=new Employee();
			System.out.println("Enter name");
			emp.setName(sc.next());
			
			System.out.println("Enter mobile");
			emp.setMobile(sc.nextInt());
			
			System.out.println("Enter salary");
			emp.setSalary(sc.nextDouble());
		}
		tr.commit();
		if(flag==Boolean.TRUE)
		{
			System.out.println("Succesfull");
		}
		
		else
			System.out.println("Interupted");
		
	}
	
	public void select()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Employee.class);
		List<Employee>list=cr.list();
		list.forEach(System.out::println);
	}

	public static void main(String[] args) {
		Test t=new Test();
		t.insert();
		//t.select();

	}

}
