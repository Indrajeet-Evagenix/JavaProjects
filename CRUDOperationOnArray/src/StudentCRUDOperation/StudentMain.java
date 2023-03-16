package StudentCRUDOperation;

import java.util.Scanner;

public class StudentMain {

	static boolean flag = true;

	static void menu() {
		System.out.println("------------Welcome to The Student Management System------------");
		System.out.println("1. Add New Student Record" + "\n2. Search Student Record" + "\n3. Update Student Record"
				+ "\n4. Delete Student Record" + "\n5. View All Student Data" + "\n6. Exit");
	}

	public static void main(String[] args) {
		StudentOperation student = new StudentOperation();
		Scanner sc = new Scanner(System.in);

		student.addStudentDetails();
//		student.displayStudentData();

		do {
			menu();
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Add New Student Record");
				student.insertNewStudentRecord();
				break;
			case 2:
				System.out.println("Search Student Record");
				student.serachStudentDetails();
				break;
			case 3:
//				System.out.println("Press 1. for Update Email" + "\nPress 2. for update Contact Number");
//				int input = sc.nextInt();
//				switch (input) {
//				case 1:
//					student.updateStudentEmail();
//					break;
//				case 2:
//					student.updateStudentContact();
//				}
				student.updateStudentData();
				break;
			case 4:
				System.out.println("Delete Student Record");
				student.deleteStudentRecord();
				break;
			case 5:
				System.out.println("View All Student Deatils");
				student.displayStudentData();
				break;
			case 6:
				System.out.println("Thank You For Choose Our Application");
				System.exit(0);
			default:
				System.out.println("Please Enter Valid Choice");
				break;
			}

		} while (flag);

	}

}
