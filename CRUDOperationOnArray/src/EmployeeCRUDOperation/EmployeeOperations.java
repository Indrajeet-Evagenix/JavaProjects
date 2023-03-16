package EmployeeCRUDOperation;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeOperations {

	Employee emp[] = new Employee[10];
	Scanner sc = new Scanner(System.in);

	void addEmployee() {
		// Taking Input From The User
//		System.out.println("Number of Employee to Add: ");
//		int num = sc.nextInt();
//		for (int i = 0; i < num; i++) {
//			System.out.println("Enter id of an Employee: ");
//			int id = sc.nextInt();
//			System.out.println("Enter Name: ");
//			String name = sc.next();
//			System.out.println("Enter Email: ");
//			String email = sc.next();
//			System.out.println("Enter Department: ");
//			String department = sc.next();
//			System.out.println("Enter Salary: ");
//			double salary = sc.nextDouble();
//
//			Employee emp1 = new Employee();
//			emp1.setId(id);
//			emp1.setName(name);
//			emp1.setEmail(email);
//			emp1.setDepartment(department);
//			emp1.setSalary(salary);
//
//			emp[i] = emp1;
//		}

		// HardCodeing The Input
		emp[0] = new Employee();
		emp[0].setId(101);
		emp[0].setName("Indrajeet");
		emp[0].setEmail("indrajeet@gmail.com");
		emp[0].setDepartment("Developer");
		emp[0].setSalary(55000);

		emp[1] = new Employee();
		emp[1].setId(102);
		emp[1].setName("Akash");
		emp[1].setEmail("akash@gmail.com");
		emp[1].setDepartment("Tester");
		emp[1].setSalary(60000);

		emp[2] = new Employee();
		emp[2].setId(103);
		emp[2].setName("Aashish");
		emp[2].setEmail("aashish@gmail.com");
		emp[2].setDepartment("Coder");
		emp[2].setSalary(75000);

		emp[3] = new Employee();
		emp[3].setId(104);
		emp[3].setName("Mukesh");
		emp[3].setEmail("mukesh@gmail.com");
		emp[3].setDepartment("Manager");
		emp[3].setSalary(90000);
	}

	public void displayEmployeeDetails() {
		System.out.println(Arrays.toString(emp));
	}

	public void insertEmployee() {
		System.out.println("Enter id of an Employee: ");
		int id = sc.nextInt();
		System.out.println("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter Email: ");
		String email = sc.next();
		System.out.println("Enter Department: ");
		String department = sc.next();
		System.out.println("Enter Salary: ");
		double salary = sc.nextDouble();

		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setDepartment(department);
		e.setSalary(salary);

		for (int i = 0; i < emp.length; i++) {
			if (emp[i] == null) {
				emp[i] = e;
				break;
			}
		}
	}

	public void updateEmployee() {
		boolean found = false;
		System.out.println("Enter Employee id: ");
		int id = sc.nextInt();
		System.out.println("Enter New Salary of Employee");
		double salary = sc.nextDouble();
		for (Employee e : emp) {
			if (e != null) {
				if (e.getId() == id) {
					e.setSalary(salary);
					System.out.println("Updated Deatils of Employee is: ");
					System.out.println(e);
					found = true;
				}
			}
		}
		if (!found) {
			System.out.println("Employee with this id does not Exist !!");
		} else {
			System.out.println("Employee Salary Successfully Updated !!");
		}
	}

	public void deleteEmployee() {
		Employee e[] = new Employee[emp.length];
		System.out.println("Enter Employee id: ");
		int id = sc.nextInt();
		int index = 0;
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				if (emp[i].getId() == id) {
					index = i;
				}
			}
		}
		int j = 0;
		for (int i = 0; i < emp.length; i++) {
			if (i == index) {
				continue;
			} else {
				e[j] = emp[i];
				j++;
			}
		}
		System.out.println("After Deleting Remaining Employee is:");
		System.out.println(Arrays.toString(e));
		for (int i = 0; i < e.length; i++) {
			emp[i] = e[i];
		}

	}

}
