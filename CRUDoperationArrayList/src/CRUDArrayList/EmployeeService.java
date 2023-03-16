package CRUDArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

//		Employee[] empset = new Employee[4];
	ArrayList<Employee> empset1 = new ArrayList<>();

	Employee emp1 = new Employee(101, "Indrajeet", "Computer", 50000);
	Employee emp2 = new Employee(102, "Akash", "HR", 60000);
	Employee emp3 = new Employee(103, "Mukesh", "Sales", 70000);
	Employee emp4 = new Employee(104, "Aashsih", "Mechanic", 55000);

	Scanner sc = new Scanner(System.in);

	int id;
	String name, department;
	double salary;
	boolean found = false;

	public EmployeeService() {
		empset1.add(emp1);
		empset1.add(emp2);
		empset1.add(emp3);
		empset1.add(emp4);
	}

	public void viewAllEmployee() {
		for (Employee emp : empset1) {
			System.out.println(emp);
		}
	}

	public void searchEmployee() {
		boolean found = false;
		System.out.println("Enter id of an Employee: ");
		id = sc.nextInt();
		for (Employee emp : empset1) {
			if (emp.getEmpId() == id) {
				System.out.println(emp);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee With this id is not Exist");
		}
	}

	public void updateEmployee() {
		boolean found = false;
		System.out.println("Enter Employee Details");
		System.out.println("Enter id: ");
		id = sc.nextInt();
		for (Employee emp : empset1) {
			if (emp.getEmpId() == id) {
				System.out.println("Enter Name: ");
				name = sc.next();
				System.out.println("Enter Department: ");
				department = sc.next();
				System.out.println("Enter Salary: ");
				salary = sc.nextDouble();
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpDepartment(department);
				emp.setSalary(salary);
				System.out.println("Updated Deatils of Employee is: ");
				System.out.println(emp);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee is Not Exist");
		} else {
			System.out.println("Employee Details Updated Successfully.");
		}
	}

	public void deleteEmployee() {
		boolean found = false;
		System.out.println("Enter id of an Employee: ");
		id = sc.nextInt();
		Employee empDelete = null;
		for (Employee emp : empset1) {
			if (emp.getEmpId() == id) {
				empDelete = emp;
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee With this id is not Exist");
		} else {
			empset1.remove(empDelete);
			System.out.println("Employee Deleted Successfully");
		}
	}

	public void addEmployee() {
		System.out.println("Enter id of an Employee: ");
		id = sc.nextInt();
		System.out.println("Enter Name: ");
		name = sc.next();
		System.out.println("Enter Department: ");
		department = sc.next();
		System.out.println("Enter Salary: ");
		salary = sc.nextDouble();

		Employee emp = new Employee(id, name, department, salary);
		empset1.add(emp);
		System.out.println(emp);
		System.out.println("Employee Added Successfully");
	}

}
