import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DBOperations {

	int city_id, center_id, vaccination_id, slot_id, adhar_number;
	String center_name = "", first, last, city_name, full_name;
	String slottime = "";
	String aadhar_number, bookingdate, firstDoseDate;
	String secondDoseDate;

	static void displayCities(Connection conn) {

		try {
			PreparedStatement stmt = conn.prepareStatement("select * from cities");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void VaccinationCenterData(Connection conn) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter city name");
		String city_name = sc.next();
		try {
			PreparedStatement stmt = conn.prepareStatement("select center_id,center_name from vaccination_centers v"
					+ " join cities c on v.city_id=c.city_id  where city_name like ?");
			stmt.setString(1, city_name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void slots(Connection conn) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter center_id:");
		int center_id = sc.nextInt();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					" select s.slot_id,s.slottime,center_id from slots s natural join vaccination_centers b where center_id=?");
			stmt.setInt(1, center_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// System.out.println("slotid:"+rs.getInt(1));
				System.out.println("slottime:" + rs.getString("slottime"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter slotime:");
		String slottime = sc.next();
		try {
			PreparedStatement stmt1 = conn.prepareStatement("select slottime from slots where slottime=?");
			stmt1.setString(1, slottime);
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void closeddays(Connection conn) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter center_id");
		int center_id = sc.nextInt();
		System.out.println("Enter c_date");
		String c_date = sc.next();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select v.center_id,c_date,ct.city_id from vaccination_centers v,closeddays c,cities ct where "
							+ "v.city_id=ct.city_id and v.center_id=? and c_date=? ");
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, center_id);
			stmt.setString(2, c_date);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void usersData(Connection conn) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter id");
		// int id=sc.nextInt();
		// sc.nextLine();
		System.out.println("Enter fullname:");
		String fullname = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter dob:");

		String dob = sc.next();
		sc.nextLine();
		System.out.println("Enter aadhar_number:");
		String aadhar_number = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter contact:");
		String contact = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter gender:");
		String gender = sc.next();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"insert into users(first_name,last_name,date_of_borth,contact,age,gender)values" + "(?,?,?,?,?,?)");

			// stmt.setInt(1, id);
			stmt.setString(1, fullname);
			stmt.setString(2, dob);
			stmt.setString(3, aadhar_number);
			stmt.setString(4, contact);
			stmt.setInt(5, age);
			stmt.setString(6, gender);
			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void booking(Connection conn) {
		PreparedStatement pst;
		CallableStatement cst;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String bookingdate = sdf.format(c.getTime());

//		secondDoseDate = new Date();
		try {

			cst = conn.prepareCall("{? = call secondDoseDate(?)}");
			cst.registerOutParameter(1, Types.DATE);
			cst.setString(2, firstDoseDate);
			cst.execute();

			secondDoseDate = cst.getString(1);
			System.out.println("seconddosedate:" + secondDoseDate);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		System.out.println("Thank you for booking vaccination slot " + full_name + " your booking details as follow ");

		System.out.println("City:" + city_name);
		System.out.println("Center:" + center_name);
		System.out.println("BookingDate:" + bookingdate + " Slot:" + slottime);
		System.out.println("first dose date:" + firstDoseDate);
		System.out.println("Second dose date:(on or after)" + secondDoseDate);

		try

		{
			pst = conn.prepareStatement(
					"insert into booking(adhar_number,center_id,vaccination_id,booking_date,slot_id,first_dose_date,second_dose_date,) values(?,?,?,?,?,?,?)");
			pst.setInt(1, adhar_number);
			pst.setInt(2, center_id);
			pst.setInt(3, vaccination_id);
			pst.setString(4, bookingdate);
			pst.setInt(5, slot_id);
			pst.setString(6, firstDoseDate);
			pst.setString(7, secondDoseDate);

			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("Reacord inserted successfully......");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void displayBookingInfo(Connection conn) {
		System.out.println("\nThank You " + first + " " + last + " Your Vaccination Details are as Follows:");
		System.out.println("City Name: " + city_name);
		System.out.println("Center Name: " + center_name);
		System.out.println("First Dose: " + firstDoseDate + " Time: " + slottime);
		System.out.println("Second Dose: (On or After): " + secondDoseDate);
	}
}
