package EmployeeCRUDOperation;

import java.util.Scanner;

public class EmployeeMain {

	static boolean order = true;

	static void menu() {
		System.out.println("------------Welcome to The Employee Management System------------");
		System.out.println("1. Add Employee" + "\n2. Search Employee" + "\n3. Update Employee" + "\n4. Delete Employee"
				+ "\n5. View All Employee" + "\n6. Exit");
	}

	public static void main(String[] args) {
		EmployeeOperations service = new EmployeeOperations();
		Scanner sc = new Scanner(System.in);
		service.addEmployee();

		do {
			menu();
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Add Employee");
				service.insertEmployee();
				break;
			case 2:
				System.out.println("Search Employee");

				break;
			case 3:
				System.out.println("Update Employee");
				service.updateEmployee();
				break;
			case 4:
				System.out.println("Delete Employee");
				service.deleteEmployee();
				break;
			case 5:
				System.out.println("View All Employee Deatils");
				service.displayEmployeeDetails();
				break;
			case 6:
				System.out.println("Thank You For Choose Our Application");
				System.exit(0);
			default:
				System.out.println("Please Enter Valic Choice");
				break;
			}
		} while (order);

	}

}
