package StudentCRUDOperation;

import java.util.Arrays;
import java.util.Scanner;

public class StudentOperation {
	Scanner sc = new Scanner(System.in);
	static boolean flag = true;

	Student stud[] = new Student[10];

	public void addStudentDetails() {

		// Taking Input From The User
//		System.out.println("Enter How Students Record You want ?");
//		int size = sc.nextInt();
//
//		for (int i = 0; i < size; i++) {
//			System.out.println("Enter '" + (i + 1) + "' Student Roll Number ");
//			int rollNumber = sc.nextInt();
//			System.out.println("Enter '" + (i + 1) + "' Student Name");
//			String name = sc.next();
//			System.out.println("Enter '" + (i + 1) + "' Student Email");
//			String email = sc.next();
//			System.out.println("Enter '" + (i + 1) + "' Student Contact");
//			String contact = sc.next();
//			System.out.println("Enter '" + (i + 1) + "' Student Department");
//			String department = sc.next();
//			System.out.println("Enter '" + (i + 1) + "' Student Marks ");
//			int marks = sc.nextInt();
//
//			Student st = new Student();
//			st.setRollNumber(rollNumber);
//			st.setStudentName(name);
//			st.setStudentEmail(email);
//			st.setStudentDepartment(department);
//			st.setStudentContact(contact);
//			st.setStudentMarks(marks);
//
//			stud[i] = st;
//		}
		// HardCoding The Input Value
		stud[0] = new Student();
		stud[0].setRollNumber(11);
		stud[0].setStudentName("Indrajeet");
		stud[0].setStudentEmail("indrajeet@gmail.com");
		stud[0].setStudentDepartment("Computer");
		stud[0].setStudentContact("8412967583");
		stud[0].setStudentMarks(88);

		stud[1] = new Student();
		stud[1].setRollNumber(12);
		stud[1].setStudentName("Akash");
		stud[1].setStudentEmail("akash@gmail.com");
		stud[1].setStudentDepartment("Civil");
		stud[1].setStudentContact("8600674892");
		stud[1].setStudentMarks(85);

		stud[2] = new Student();
		stud[2].setRollNumber(13);
		stud[2].setStudentName("Aashish");
		stud[2].setStudentEmail("aashish@gmail.com");
		stud[2].setStudentDepartment("EXTC");
		stud[2].setStudentContact("7558278505");
		stud[2].setStudentMarks(82);

		stud[3] = new Student();
		stud[3].setRollNumber(14);
		stud[3].setStudentName("Ankit");
		stud[3].setStudentEmail("ankit@gmail.com");
		stud[3].setStudentDepartment("IT");
		stud[3].setStudentContact("8087984690");
		stud[3].setStudentMarks(80);

	}

	public void displayStudentData() {
		System.out.println(Arrays.toString(stud));
	}

	public void insertNewStudentRecord() {
		System.out.println("Enter Student Roll Number ");
		int rollNumber = sc.nextInt();
		System.out.println("Enter Student Name");
		String name = sc.next();
		System.out.println("Enter Student Email");
		String email = sc.next();
		System.out.println("Enter Student Contact");
		String contact = sc.next();
		System.out.println("Enter Student Department");
		String department = sc.next();
		System.out.println("Enter Student Marks ");
		int marks = sc.nextInt();

		Student st = new Student();
		st.setRollNumber(rollNumber);
		st.setStudentContact(contact);
		st.setStudentDepartment(department);
		st.setStudentEmail(email);
		st.setStudentMarks(marks);
		st.setStudentName(name);

		for (int j = 0; j < stud.length; j++) {
			if (stud[j] == null) {
				stud[j] = st;
				break;
			}
		}

		System.out.println("Student Record Successfully Added");

	}

	public void serachStudentDetails() {
		boolean found = false;
		System.out.println("Enter Student Roll Number");
		int num = sc.nextInt();
		for (Student st : stud) {
			if (st != null) {
				if (st.getRollNumber() == num) {
					System.out.println(st);
					found = true;
				}
			}
		}
		if (!found) {
			System.out.println("Student at This Roll Number Not Exist");
		} else {
			System.out.println("Student Record Found Successfully");
		}
	}

	public void updateStudentEmail() {

		for (Student st : stud) {
			if (st != null) {
				System.out.println("Enter Student Roll Number");
				int num = sc.nextInt();
				if (st.getRollNumber() == num) {
					System.out.println("Enter New Email");
					String email = sc.next();
					st.setStudentEmail(email);
					System.out.println("Student Email Successfully Changed");
					break;
				} else {
					System.out.println("Student at This Roll Number Does Not Exist !!");
				}
			}
		}
	}

	public void updateStudentContact() {
		for (Student st : stud) {
			if (st != null) {
				System.out.println("Enter Student Roll Number");
				int num = sc.nextInt();
				if (st.getRollNumber() == num) {
					System.out.println("Enter New Contact Number");
					String email = sc.next();
					st.setStudentEmail(email);
					System.out.println("Student Contact Number Successfully Changed");
					break;
				} else {
					System.out.println("Student at This Roll Number Does Not Exist !!");
				}
			}
		}
	}

	public void updateStudentData() {
		boolean found = false;
		boolean found1 = false;
		char ch = 'a';

		do {
			System.out.println("Enter Your Choice");
			System.out.println("Press 1. for Update Email" + "\nPress 2. for update Contact Number");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Student Roll Number");
				int num = sc.nextInt();
				for (Student st : stud) {
					if (st != null) {
						if (st.getRollNumber() == num) {
							System.out.println("Enter New Email");
							String email = sc.next();
							st.setStudentEmail(email);
							found = true;
							break;
						}
					}
				}
				if (!found) {
					System.out.println("Student at This Roll Number Does Not Exist");
				}
				break;

			case 2:
				System.out.println("Enter Student Roll Number");
				int roll = sc.nextInt();
				for (Student st : stud) {
					if (st != null) {
						if (st.getRollNumber() == roll) {
							System.out.println("Enter New Contact Number");
							String contact = sc.next();
							st.setStudentContact(contact);
							found1 = true;
							break;
						}
					}
				}
				if (!found1) {
					System.out.println("Student at This Roll Number Does Not Exist");
				}
				break;
			default:
				System.out.println("Please Enter Valid Choice");
			}
			System.out.println("Do You Want to Continue Press 'Y/N'");
			ch = sc.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');
	}

	public void deleteStudentRecord() {
		Student st[] = new Student[stud.length];
		System.out.println("Enter Student Roll Number");
		int num = sc.nextInt();
		int index = 0;
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				if (stud[i].getRollNumber() == num) {
					index = i;
				}
			}
		}

		int j = 0;
		for (int i = 0; i < stud.length; i++) {
			if (i == index) {
				continue;
			} else {
				st[j] = stud[i];
				j++;
			}
		}
		System.out.println("Student Record Successfully Deleted");
		System.out.println("After Deleting Remaining Student is:");
		System.out.println(Arrays.toString(st));
		for (int i = 0; i < st.length; i++) {
			stud[i] = st[i];
		}
	}
}
