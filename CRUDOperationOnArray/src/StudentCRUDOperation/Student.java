package StudentCRUDOperation;

public class Student {

	int rollNumber, studentMarks;
	String studentName, studentEmail, studentDepartment, studentContact;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	@Override
	public String toString() {
		return "Student [RollNumber= " + rollNumber + ", StudentMarks= " + studentMarks + ", StudentName= " + studentName
				+ ", StudentEmail= " + studentEmail + ", StudentDepartment= " + studentDepartment + ", StudentContact= "
				+ studentContact + "]";
	}

}
