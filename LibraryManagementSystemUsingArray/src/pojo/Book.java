package pojo;

public class Book {

	int bookId, bookQuentity, bookQuentityCopy;
	String bookName, bookAuthor;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookQuentity() {
		return bookQuentity;
	}

	public void setBookQuentity(int bookQuentity) {
		this.bookQuentity = bookQuentity;
	}

	public int getBookQuentityCopy() {
		return bookQuentityCopy;
	}

	public void setBookQuentityCopy(int bookQuentityCopy) {
		this.bookQuentityCopy = bookQuentityCopy;
	}

	@Override
	public String toString() {
		return "Book [bookId = " + bookId + ", bookName = " + bookName + ", bookAuthor = " + bookAuthor
				+ ", Book Quentity = " + bookQuentity + ", Book Quentity Copy = " + bookQuentityCopy + "]";
	}

}
