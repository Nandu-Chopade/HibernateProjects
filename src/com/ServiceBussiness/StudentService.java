package com.ServiceBussiness;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HbConfiguration.HibernateUtil;
import com.Model.Address;
import com.Model.Student;


public class StudentService {
	 Scanner sc=new Scanner(System.in);
	 
	 Student st=new Student();
	 //collection 
	 List<Address> address = new ArrayList<Address>();
	 
	 
	
	SessionFactory sf= HibernateUtil.getFactory();
	public void insert()
	{   
		
		Session session=sf.openSession();
		Address studentAddress = new Address();
		
		System.out.println("plz enter name :");
		st.setName(sc.next());
		System.out.println("plz enter city :");
		studentAddress.setCity(sc.next());
		System.out.println("plz enter Area :");
		studentAddress.setArea(sc.next());
		
	    address.add(studentAddress);
	    
	    st.setAddresses(address);
	    studentAddress.setStudent(st);
	    
		session.save(st);
		session.beginTransaction().commit();
		session.close();
	}
	public void show()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List <Student> list = criteria.list();
		for(Student s:list)
		{
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("                                     ");
			System.out.println("id is : "+s.getId());
			System.out.println("                                     ");
			System.out.println("---------------------------------");
			System.out.println("Name is: "+s.getName());
			System.out.println("                                     ");
			System.out.println("++++++++++++++++++++++++++++++++++");
			System.out.println("Address is: "+s.getAddresses());
			System.out.println("                                     ");
			System.out.println("<<<<<<<<<<< Thank you >>>>>>>>>>>>>> ");
			System.out.println("                                     ");
			
		}
		session.close();
	}
	public void Update()
	{
		Session session = sf. openSession();
		Address studentAddress = new Address();
		System.out.println("plz enter id");
		int id = sc.nextInt();
		
		Student s1 = session. get(Student.class,id);
		System.out.println("enter name for update");
		s1.setName(sc.next());
		
		
		System.out.println("enter city for update");
		
		studentAddress.setCity(sc.next());
		
		
		
		
		System.out.println("Enter area");
		studentAddress.setArea(sc.next());
		s1.setAddresses(address);
		session.beginTransaction().commit();
		session.update(s1);
		session.getTransaction().commit();
	}
	public void delete()
	{
		Session session = sf.openSession();
		System.out.println("plz enter id");
		int id = sc.nextInt();
		
		Student s1 = session.get(Student.class,id);
		session.delete(s1);
		session.beginTransaction().commit();
		session.close();
	}
	
}