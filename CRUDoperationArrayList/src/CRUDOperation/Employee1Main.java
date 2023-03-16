package CRUDOperation;

import java.util.Scanner;

public class Employee1Main {
	static boolean order = true;

	static void menu() {
		System.out.println("------------Welcome to The Employee Management System------------");
		System.out.println("1. Add Employee" + "\n2. Search Employee" + "\n3. Update Employee" + "\n4. Delete Employee"
				+ "\n5. View All Employee" + "\n6. Exit");
	}

	public static void main(String[] args) {
		EmployeeServices service = new EmployeeServices();
		Scanner sc = new Scanner(System.in);

		do {
			menu();
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Add Employee");
				service.addEmployee();
				break;
			case 2:
				System.out.println("Search Employee");
				service.searchEmployee();
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
				service.viewAllEmployee();
				break;
			case 6:
				System.out.println("Thank You For Choose Our Application");
				System.exit(0);
			default:
				System.out.println("Please Enter Valid Choice");
				break;
			}
		} while (order);

	}

}
