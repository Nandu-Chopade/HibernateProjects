package com.MainController;

import java.util.Scanner;

import com.ServiceBussiness.StudentService;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StudentService sc1 = new StudentService();
		while (true) {
			System.out.println("1.for insert student record");
			System.out.println("2.for show student record");
			System.out.println("3.for update student record");
			System.out.println("4.for delete student record");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				sc1.insert();
				break;

			case 2:
				sc1.show();
				break;

			case 3:
				sc1.Update();
				break;

			case 4:
				sc1.delete();
				break;

			default:
				break;
			}
		}
	}
}
