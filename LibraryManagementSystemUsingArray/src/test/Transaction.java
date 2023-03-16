package test;

import pojo.Student;

public class Transaction {

	String bookName, issueDate, returnDate;
	private boolean bookIssue;
	Student student1;

//	public Transaction(Student s, String bookName, String issueDate, String returnDate) {
//		this.student1 = s;
//		this.bookName = bookName;
//		this.issueDate = issueDate;
//		this.returnDate = returnDate;
//	}

	public boolean isBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(boolean bookIssue) {
		this.bookIssue = bookIssue;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Student getStudent1() {
		return student1;
	}

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	@Override
	public String toString() {
		return "Transaction [bookName=" + bookName + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", student1=" + student1 + "]";
	}

}
