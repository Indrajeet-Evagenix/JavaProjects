package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import pojo.Book;
import pojo.Student;

public class Library {

	Scanner sc = new Scanner(System.in);
	ArrayList<Book> book = new ArrayList<>();
	ArrayList<Student> stud = new ArrayList<>();
	ArrayList<Transaction> tr = new ArrayList<>();
	boolean bookAvailable = true;

	public Library() {
		book.add(new Book(1, 15, 15, "Java", "Suraj"));
		book.add(new Book(2, 14, 14, "C++", "Sonu"));
		book.add(new Book(3, 13, 13, "C", "Ajit"));
		book.add(new Book(4, 12, 12, "Python", "Amit"));

		stud.add(new Student(101, "Indra", "indra@gmail.com", "8412967583", "Computer"));
		stud.add(new Student(102, "Soni", "soni@gmail.com", "1523648755", "IT"));
		stud.add(new Student(103, "Suku", "suku@gmail.com", "8412968583", "Computer"));
		stud.add(new Student(104, "Sushil", "sushil@gmail.com", "9890656188", "IT"));
	}

	public void addBook() {
		// Taking Input From User
		System.out.println("Enter Book Details ");
		for (int i = 0; i < 1; i++) {
			System.out.println("Enter '" + (i + 1) + "' Book Details ");
			System.out.println("Enter Book ID ");
			int id = sc.nextInt();
			System.out.println("Enter Book Name ");
			String name = sc.next();
			System.out.println("Enter Book Author Name ");
			String author = sc.next();
			System.out.println("Enter Book Quentity");
			int quantity = sc.nextInt();
			int quantityCopy = quantity;

			Book bk = new Book();
			bk.setBookId(id);
			bk.setBookName(name);
			bk.setBookAuthor(author);
			bk.setBookQuentity(quantity);
			bk.setBookQuentityCopy(quantityCopy);

			book.add(bk);
		}
		System.out.println("Book Added Successfully");
	}

	public void displayBook() {
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("Id.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (Book bn : book) {
			if (bn != null) {
				System.out.println(bn.getBookId() + "\t\t" + bn.getBookName() + "\t\t" + bn.getBookAuthor() + "\t\t"
						+ bn.getBookQuentity() + "\t\t\t" + bn.getBookQuentityCopy());
			}
		}
	}

	public void searchBookById() {
		System.out.println("\t\t\t\tSEARCH BY ID NUMBER\n");

		System.out.println("Enter Book Id Number");
		int id = sc.nextInt();

		int flag = 0;
		System.out.println("Id.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (Book bk : book) {
			if (id == bk.getBookId()) {
				System.out.println(bk.getBookId() + "\t\t" + bk.getBookName() + "\t\t" + bk.getBookAuthor() + "\t\t"
						+ bk.getBookQuentityCopy() + "\t\t\t" + bk.getBookQuentity());
				flag++;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("No Any Book for ID No '" + id + "' Found.");
		}
	}

	public void searchByAuthorName() {
		System.out.println("\t\t\t\tSEARCH BY ID NUMBER\n");

		System.out.println("Enter Book Author Name");
		String authorName = sc.next();

		int flag = 0;
		System.out.println("Id.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (Book bk : book) {
			if (authorName.equalsIgnoreCase(bk.getBookAuthor())) {
				System.out.println(bk.getBookId() + "\t\t" + bk.getBookName() + "\t\t" + bk.getBookAuthor() + "\t\t"
						+ bk.getBookQuentityCopy() + "\t\t\t" + bk.getBookQuentity());
				flag++;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("No Any Book for Author Name '" + authorName + "' Found.");
		}

	}

	public void upgradeQuentityOfBook() {
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter ID No of Book");

		int id = sc.nextInt();
		int num = 0;

		for (Book bk : book) {
			if (bk != null) {
				if (id == bk.getBookId()) {
					int num1 = bk.getBookQuentityCopy();
					int num2 = bk.getBookQuentity();
					System.out.println("Enter No of Books to be Added:");
					num = sc.nextInt();
					bk.setBookQuentityCopy(num + num1);
					bk.setBookQuentity(num + num2);
				}
			}
		}
		System.out.println("In ID " + id + " Number of " + num + " Books Added Successfully");
	}

	public void addStudentDetails() {
		// Taking Input From User
		System.out.println("Enter Student Details ");
		for (int i = 0; i < 1; i++) {
			System.out.println("Enter Student ID ");
			int id = sc.nextInt();
			System.out.println("Enter Student Name ");
			String name = sc.next();
			System.out.println("Enter Student Email ");
			String email = sc.next();
			System.out.println("Enter Student Contact ");
			String contact = sc.next();
			System.out.println("Enter Student Department ");
			String dept = sc.next();

			Student st = new Student();
			st.setStudentId(id);
			st.setStudentName(name);
			st.setStudentContact(contact);
			st.setStudentDepartment(dept);
			st.setStudentEmail(email);

			stud.add(st);
			System.out.println("Student Successfully Registered");

		}
	}

	public void displayStudent() {
		System.out.println("\t\t\t\tSHOWING ALL STUDENTS\n");
		System.out.println("ID.No\t\tName\t\tEmail\t\t\tContact\t\t\tDepartment");

		for (Student st : stud) {
			if (st != null) {
				System.out.println(st.getStudentId() + "\t\t" + st.getStudentName() + "\t\t" + st.getStudentEmail()
						+ "\t\t" + st.getStudentContact() + "\t\t" + st.getStudentDepartment());
			}
		}
	}

	public void issueBook() {
		Student s1 = new Student();
		Book b = new Book();
		System.out.println("Enter Student Details:sid,name,email,contact,dept");
		int id = sc.nextInt();
		String name = sc.next();
		String email = sc.next();
		String contact = sc.next();
		String dept = sc.next();
		s1.setStudentId(id);
		s1.setStudentName(name);
		s1.setStudentEmail(email);
		s1.setStudentContact(contact);
		s1.setStudentDepartment(dept);
		
		stud.add(s1);
//		for(Student st:stud) {
//			if(st.getStudentId()!=s1.getStudentId())
//				
//		}
		
//		for (int i = 0; i < stud.size(); i++) {
//			if (stud.get(i) != null) {
//				stud.add(s1);
//				break;
//			}
//
//		}

		Transaction tr1 = new Transaction();
		System.out.println("Enter Book Name:");
		String bookName = sc.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar c1 = Calendar.getInstance();
		String issueDate = sdf.format(c1.getTime());
		c1.add(Calendar.DATE, 30);
		String returnDate = sdf.format(c1.getTime());

		tr1.setStudent1(s1);
		tr1.setBookName(bookName);
		tr1.setIssueDate(issueDate);
		tr1.setReturnDate(returnDate);

		for (Book bk : book) {
			if (bk != null) {
				if (bk.getBookName().equalsIgnoreCase(bookName) && bk.getBookQuentity() == 0) {
					System.out.println("Book is Not Available");
					bookAvailable = false;
					break;
				}
			}
		}
		for (int i = 0; i < tr.size(); i++) {
			if (tr.get(i) == null) {
				tr.add(tr1);
				tr1.setBookIssue(true);
				break;
			}
		}
		for (Book bk : book) {
			if (bk != null) {
				if (bk.getBookName().equalsIgnoreCase(bookName)) {
					if (bookAvailable == true && bk.getBookQuentity() > 0) {
						int count = bk.getBookQuentity();
						bk.setBookQuentity(count - 1);
					}
//					else {
//						System.out.println("Book is Not Available");
//					}
				}
			}
		}

		System.out.println("Book Issued Successfully");

	}

	public void returnBook() {
		System.out.println("Enter bookname: ");
		String bookName = sc.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar c1 = Calendar.getInstance();
		String returnDate = sdf.format(c1.getTime());

		for (Transaction tran : tr) {
			if (tran != null) {
				if (tran.getBookName().equalsIgnoreCase(bookName)) {
					tran.setReturnDate(returnDate);
					tran.setBookIssue(false);
					System.out.println(
							"BookName: " + tran.getBookName() + " Issued on " + tran.getIssueDate() + " returned by "
									+ tran.getStudent1().getStudentName() + " on date " + tran.getReturnDate());
				}
			}
		}
		for (Book bk : book) {
			if (bk != null) {
				if (bk.getBookName().equalsIgnoreCase(bookName)) {
					int count = bk.getBookQuentity();
					bk.setBookQuentity(count + 1);
				}

			}
		}
		
		System.out.println("Book Returned Successfully");

	}

	public void availabilityBook() {
		System.out.println("Enter bookname: ");
		String bookName = sc.next();
		for (Book bk : book) {
			if (bk != null) {
				if (bk.getBookName().equalsIgnoreCase(bookName)) {
					if (bk.getBookQuentity() == 0) {
						System.out.println(bk.getBookName() + " is not available");
					} else
						System.out.println("Available copies of " + bk.getBookName() + " : " + bk.getBookQuentity());
				}
			}
		}
	}

	public void bookIssueDetails() {
		System.out.println("Enter Book Name:");
		String bk = sc.next();
		for (Transaction x : tr) {
			if (x != null) {
				if (x.getBookName().equalsIgnoreCase(bk)) {
					if (x.isBookIssue() == true) {
						System.out.println(x.getBookName() + " is issued to " + x.getStudent1().getStudentName()
								+ " on date " + x.getIssueDate());
						System.out.println("Book Not Returned Excepted return Date till: +" + x.getReturnDate());
					} else
						System.out.println(x.getBookName() + " returned by " + x.getStudent1().getStudentName()
								+ " on date " + x.getReturnDate());
				}
			}
		}
	}
}
