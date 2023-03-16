import java.sql.Connection;

public class DBMain {

	static void menu() {
		System.out.println("------Welcome to The Vaccination Slot Booking------\n");
	}

	public static void main(String[] args) {
		Connection conn = DBConn.getConnection("vaccinationproject");

		menu();
	}

}
