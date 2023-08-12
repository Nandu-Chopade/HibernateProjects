package controller;

import java.util.Scanner;

import model.Patient;
import serviceBusiness.PatientServiceBussiness;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PatientServiceBussiness patient = new PatientServiceBussiness();

		while (true) {
			System.out.println("Press 1. Insert\nPress 2. Show\nPress 3. Update\nPress 4. Delete ");

			switch (sc.nextInt()) {
			case 1:
				patient.insert();
				break;
			case 2:
				patient.show();
				break;
			case 3:
				System.out.println("Enter the Id for update");
				patient.update(sc.nextInt());
				break;
			case 4:
				System.out.println("Enter the Id for delete");
				patient.delete(sc.nextInt());
				break;
			default:
				break;
			}
		}

	}

}
