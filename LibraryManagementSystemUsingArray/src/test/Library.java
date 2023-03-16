package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Scanner;

import pojo.Book;
import pojo.Student;

public class Library {
	Scanner sc = new Scanner(System.in);
	Book book[] = new Book[10];
	Student stud[] = new Student[10];
	Transaction tr[] = new Transaction[10];
	boolean bookAvailable = true;

	public void bookDetails() {

		book[0] = new Book();
		book[0].setBookId(11);
		book[0].setBookName("Java");
		book[0].setBookAuthor("Indra");
		book[0].setBookQuentity(10);
		book[0].setBookQuentityCopy(10);

		book[1] = new Book();
		book[1].setBookId(12);
		book[1].setBookName("C++");
		book[1].setBookAuthor("Akash");
		book[1].setBookQuentity(15);
		book[1].setBookQuentityCopy(15);

		book[2] = new Book();
		book[2].setBookId(13);
		book[2].setBookName("Python");
		book[2].setBookAuthor("Sushil");
		book[2].setBookQuentity(12);
		book[2].setBookQuentityCopy(12);

		book[3] = new Book();
		book[3].setBookId(14);
		book[3].setBookName("C");
		book[3].setBookAuthor("Ashish");
		book[3].setBookQuentity(5);
		book[3].setBookQuentityCopy(5);
	}

	public void addBook() {
		System.out.println("Enter Book id ");
		int bookId = sc.nextInt();
		System.out.println("Enter Book Name");
		String bookName = sc.next();
		System.out.println("Enter Author Name");
		String bookAuthor = sc.next();
		System.out.println("Enter Quentity");
		int bookQnt = sc.nextInt();
		int bookQuentityCopy = bookQnt;

		Book bk = new Book();
		bk.setBookId(bookId);
		bk.setBookName(bookName);
		bk.setBookAuthor(bookAuthor);
		bk.setBookQuentity(bookQnt);
		bk.setBookQuentityCopy(bookQuentityCopy);

		for (int i = 0; i < book.length; i++) {
			if (book[i] == null) {
				book[i] = bk;
				break;
			}
		}
	}

	public void addStudentDetails() {
		// Taking Input From User
		System.out.println("Enter Student Details ");
		for (int i = 0; i < stud.length; i++) {
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

			for (int j = 0; j < 1; j++) {
				if (stud[j] == null) {
					stud[j] = st;
					break;
				}
			}
		}
		System.out.println("Student Successfully Registered");
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
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] == null) {
				stud[i] = s1;
				break;
			}

		}

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
		for (int i = 0; i < tr.length; i++) {
			if (tr[i] == null) {
				tr[i] = tr1;
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
				}
			}
		}

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
						System.out.println(
								x.getBookName() + " is issued to " + x.getStudent1().getStudentName() + " on date " + x.getIssueDate());
						System.out.println("Book Not Returned Excepted return Date till: +" + x.getReturnDate());
					} else
						System.out.println(
								x.getBookName() + " returned by " + x.getStudent1().getStudentName() + " on date " + x.getReturnDate());
				}
			}
		}
	}

}
