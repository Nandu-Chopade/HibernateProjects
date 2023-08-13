package com.crude.controller;

import java.util.Scanner;

import com.crud.serviceBusiness.StudentService;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		StudentService studentService = new StudentService();
		System.out.println("Hi Users! ");
		boolean value = true;
		while (value) {
			System.out.println("1 Enter for Insert");
			System.out.println("2 Enter for Retrieve");
			System.out.println("3 Enter for Update");
			System.out.println("4 Enter for Delete");
			System.out.println("5 Enter for stop the Loop ");

			try {
				switch (Main.scanner.nextInt()) {
				case 1:
					studentService.insert();
					break;
				case 2:
					System.out.println("Enter A for calling student Id wise\n" + " Enter B for calling all Student ");
					Main.scanner.nextLine();
					switch (Main.scanner.nextLine()) {
					case "A":
						System.out.println("Enter the id:");
						int id = Integer.parseInt(scanner.nextLine());
						studentService.retrieveIdWise(id);
						break;
					case "B":
						studentService.retrieve();
						break;
					}
					break;
				case 3:
					System.out.println("Enter the id updating: ");
					studentService.update(Main.scanner.nextInt());
					break;
				case 4:
					System.out.println("Enter the id for deleting: ");
					studentService.delete(Main.scanner.nextInt());
					;
					break;
				case 5:
					value = false;
					System.out.println("Loop working has stop! run the programe again if you want");
					break;
				default:
					System.out.println("Case Not Match Enter Valid Input");
					break;
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

}
