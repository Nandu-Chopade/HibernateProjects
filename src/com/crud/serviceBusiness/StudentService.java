package com.crud.serviceBusiness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.crud.DbConfiguration.HibernateUtil;
import com.crud.model.Student;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class StudentService {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session;

	Scanner scanner = new Scanner(System.in);
	Student student = new Student();

	public void insert() {
		// openSession
		session = sessionFactory.openSession();

		System.out.println("Enter your Id: ");
		student.setId(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter your full name");
		student.setFullName(scanner.nextLine());

		System.out.println("Enter your age");
		student.setAge(Integer.parseInt(scanner.nextLine()));

		System.out.println("Enter your standard");
		student.setStd(Integer.parseInt(scanner.nextLine()));

		System.out.println("Enter your address");
		student.setAddress(scanner.nextLine());

		// save session
		session.save(student);

		// begingTransaction and commit transaction
		session.beginTransaction().commit();
		
		// close the session 
		session.close();

	}

	public void retrieve() {
		// openSession
		session = sessionFactory.openSession();

		List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
		for (Student student : studentList) {

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("Id: " + student.getId());
			System.out.println(".....................................");
			System.out.println("Name: " + student.getFullName());
			System.out.println(".....................................");
			System.out.println("Age: " + student.getAge());
			System.out.println(".....................................");
			System.out.println("Standard: " + student.getStd());
			System.out.println(".....................................");
			System.out.println("Address: " + student.getAddress());
			System.out.println("..............Thank You..............");
			System.out.println("-------------------------------------");

		}
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		countQuery.select(builder.count(countQuery.from(Student.class)));

		long rowCount = session.createQuery(countQuery).getSingleResult();

		System.out.println("Number of students: " + rowCount);

		// begingTransaction and commit transaction
		session.beginTransaction().commit();

	}

	public void retrieveIdWise(int id) {
		// openSession
		session = sessionFactory.openSession();

		student = session.get(Student.class, id);

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Id: " + student.getId());
		System.out.println(".....................................");
		System.out.println("Name: " + student.getFullName());
		System.out.println(".....................................");
		System.out.println("Age: " + student.getAge());
		System.out.println(".....................................");
		System.out.println("Standard: " + student.getStd());
		System.out.println(".....................................");
		System.out.println("Address: " + student.getAddress());
		System.out.println("..............Thank You..............");
		System.out.println("-------------------------------------");

		// begingTransaction and commit transaction
		session.beginTransaction().commit();
	}

	public void update(int id) {
		// openSession
		session = sessionFactory.openSession();

		Student student = session.get(Student.class, id);

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Enter Name For Updating: ");
		student.setFullName(scanner.nextLine());
		System.out.println(".....................................");
		System.out.println("Enter  Age For Updating: ");
		student.setAge(scanner.nextInt());
		System.out.println(".....................................");
		System.out.println("Enter Standard For  Updating :  ");
		student.setStd(scanner.nextInt());
		System.out.println(".....................................");
		System.out.println("Enter Address For Updating:  ");
		student.setAddress(scanner.nextLine());
		System.out.println("..............Thank You..............");
		System.out.println("-------------------------------------");

		// update the student info in database using update() method
		session.update(student);

		// begingTransaction and commit transaction
		session.beginTransaction().commit();

	}

	public void delete(int id) {
		// openSession
		session = sessionFactory.openSession();

		Student student = session.get(Student.class, id);

		// delete the student info in database using delete() method
		session.delete(student);

		// begingTransaction and commit transaction
		session.beginTransaction().commit();

	}

}
