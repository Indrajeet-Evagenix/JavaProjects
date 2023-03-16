package CRUDArrayList;

public class Employee {

	private int empId;
	private String empName;
	private String empDepartment;
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee: [empId= " + empId + ", empName= " + empName + ", empDepartment= " + empDepartment
				+ ", salary= " + salary + "]";
	}

	public Employee(int empId2, String empName2, String empDepartment2, double salary2) {

		this.empId = empId2;
		this.empName = empName2;
		this.empDepartment = empDepartment2;
		this.salary = salary2;

	}
}
