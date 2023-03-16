package dao;

import java.util.Scanner;

import test.Library;

public class LibraryMain {

	static void displayMenu() {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 1 to Add new Book.");
		System.out.println("Press 2 to Upgrade Quantity of a Book.");
		System.out.println("Press 3 to Search a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Student.");
		System.out.println("Press 6 to Show All Registered Students.");
		System.out.println("Press 7 to Issue Book.");
		System.out.println("Press 8 to Return Book.");
		System.out.println("Press 9 to Check Book Issue/Return Details.");
		System.out.println("Press 10 to Check Book Avalibility.");
		System.out.println("Press 0 to Exit Application.");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Library lb = new Library();
//		lb.bookDetails();

		System.out.println("********************Welcome to the Library!********************");
		System.out.println("                  Select From The Following Options:               ");
		System.out.println("**********************************************************************");

		int choice;
		int searchChoice;

		do {

			displayMenu();
			choice = input.nextInt();

			switch (choice) {

			case 1:
				lb.addBook();
				break;

			case 2:
				lb.upgradeQuentityOfBook();
				break;

			case 3:
				System.out.println(" Press 1 to Search with Book Id No.");
				System.out.println(" Press 2 to Search with Book's Author Name.");
				searchChoice = input.nextInt();
				switch (searchChoice) {
				case 1:
					lb.searchBookById();
					break;

				case 2:
					lb.searchByAuthorName();
				}
				break;

			case 4:
				lb.displayBook();
				break;

			case 5:
				lb.addStudentDetails();

				break;

			case 6:
				lb.displayStudent();
				break;

			case 7:
				lb.issueBook();
				break;

			case 8:
				lb.returnBook();
				break;

			case 9:
				lb.bookIssueDetails();
				break;

			case 10:
				lb.availabilityBook();
				break;

			default:

				System.out.println("ENTER BETWEEN 1 TO 10.");
			}

		}

		while (choice != 0);
	}
}
