package pojo;

public class Student {

	int studentId;
	String studentName, studentEmail, studentContact, studentDepartment;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	@Override
	public String toString() {
		return "Student [studentId= " + studentId + ", studentName = " + studentName + ", studentEmail= " + studentEmail
				+ ", studentContact = " + studentContact + ", studentDepartment = " + studentDepartment + "]";
	}

	public Student() {

	}

	public Student(int studentId, String studentName, String studentEmail, String studentContact,
			String studentDepartment) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentContact = studentContact;
		this.studentDepartment = studentDepartment;
	}

}
