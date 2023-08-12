package serviceBusiness;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configuration.HibernateUtil;
import model.Address;
import model.Patient;

public class PatientServiceBussiness {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session;

	Scanner sc = new Scanner(System.in);

	public void insert() {
		// openSession
		session = sf.openSession();
		// Making Patient object reference variable
		Patient patient = new Patient();

		// Name
		System.out.println("Enter the Petient Name: ");
		patient.setName(sc.nextLine());

		// Age
		System.out.println("Enter the Petient Age: ");
		patient.setAge(Integer.parseInt(sc.nextLine()));

		// Making Address object reference variable
		Address address = new Address();
		System.out.println("Enter the Petient City: ");
		address.setCity(sc.nextLine());

		System.out.println("Enter the Petient District");
		address.setDistrict(sc.nextLine());

		// let's bind address to patient as onetoone relationship
		patient.setAddress(address);

		// saving session
		session.save(patient);

		// begin and committing session
		session.beginTransaction().commit();

		// closing session
		session.close();
	}

	public void show() {
		// openSession
		session = sf.openSession();

		Criteria criteria = session.createCriteria(Patient.class);
		List<Patient> patientList = criteria.list();

//		System.out.println(patientList.toString());

		for (Patient patient : patientList) {

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("Id: " + patient.getId());
			System.out.println(".....................................");
			System.out.println(                                       );
			System.out.println("Patient Name: " + patient.getName());
			System.out.println(".....................................");
			System.out.println(                                       );
			System.out.println("Patient Age: " + patient.getAge());
			System.out.println(".....................................");
			System.out.println(                                       );
			System.out.println("Patient City: " + patient.getAddress().getCity());
			System.out.println(".....................................");
			System.out.println();
			System.out.println("Patient District: " + patient.getAddress().getDistrict());
			System.out.println("..............Thank You..............");
			System.out.println(                                       );
			System.out.println(                                       );
		}

		// begin and committing session
		session.beginTransaction().commit();

		// closing session
		session.close();
	}

	public void update(int id) {
		// openSession
		session = sf.openSession();
		// Making Patient object reference variable
		Patient patient = session.get(Patient.class, id);

		// Name
		System.out.println("Enter the Petient Name for Updating: ");
		patient.setName(sc.nextLine());

		// Age
		System.out.println("Enter the Petient Age for Updating:  ");
		patient.setAge(Integer.parseInt(sc.nextLine()));

		// Making Address object reference variable
		Address address = new Address();
		System.out.println("Enter the Petient City for Updating:  ");
		address.setCity(sc.nextLine());

		System.out.println("Enter the Petient District for Updating: ");
		address.setDistrict(sc.nextLine());

		// let's bind address to patient as onetoone relationship
		patient.setAddress(address);

		// updating session
		session.update(patient);

		// begin and committing session
		session.beginTransaction().commit();

		// closing session
		session.close();

	}

	public void delete(int id) {
		// openSession
		session = sf.openSession();
		Patient patient = session.get(Patient.class, id);

		// deleting session
		session.delete(patient);

		// begin and committing session
		session.beginTransaction().commit();

		// closing session
		session.close();
	}
}
