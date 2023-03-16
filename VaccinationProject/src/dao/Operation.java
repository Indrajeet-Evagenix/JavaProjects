package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Operation {
	Connection con;
	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	public void bookvacinatation(Connection con) {
		try {
			System.out.println("------**City name*-------");
			pst = con.prepareStatement("select * from city ");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			pst = con.prepareStatement("select city_id from city where city_name like ?");
			System.out.println("enter the city name");
			String cityname = sc.next();
			pst.setString(1, cityname);
			ResultSet rs = pst.executeQuery();
			int cid = 0;
			while (rs.next()) {
				cid = rs.getInt(1);
			}

			// city popup and display
			pst = con.prepareStatement("select center_id,center_name from vacination_center where city_id=?");
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			String center_name = "";
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));

			}

			System.out.println("enetr center id which u want to book");
			int center_id = sc.nextInt();
			pst = con.prepareStatement("select center_name from vacination_center where center_id=?");
			pst.setInt(1, center_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				center_name = rs.getString(1);
			}

			// Time slot popup and select
			pst = con.prepareStatement("select * from time_slot");
			rs = pst.executeQuery();
			System.out.println("Choose any one time slot from below table");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			System.out.println("enetr time slot id which u want to book");
			int tid = sc.nextInt();
			String timeslot = "";
			pst = con.prepareStatement("select timeslot from time_slot where slot_id=?");
			pst.setInt(1, tid);
			rs = pst.executeQuery();
			while (rs.next()) {
				timeslot = rs.getString(1);
			}

			// Person detail insert

			pst = con.prepareStatement("insert into person_detail values(?,?,?,?,?,?,?,?,?)");
			System.out.println("enter Adhar number");
			String adhar = sc.next();
			sc.nextLine();
			System.out.println("enter your full name");
			String name = sc.nextLine();

			System.out.println("enter yor Date of Birth in yyyy-mm-dd");
			String Dob = sc.next();
			System.out.println("enter age");
			int age = sc.nextInt();

			pst.setString(1, adhar);
			pst.setString(2, name);
			pst.setString(3, Dob);
			pst.setInt(4, age);
			pst.setString(5, cityname);
			pst.setString(6, center_name);
			pst.setString(7, timeslot);

			// Date d=new Date();

			// calculate date of 1st and second date and if sunday then close and take next
			// day
			LocalDate firstdate = LocalDate.now();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c1 = Calendar.getInstance();

			c1.add(Calendar.DATE, 7);
			String firstdate1 = sdf.format(c1.getTime());
			CallableStatement cst;
			cst = con.prepareCall("{call day(?,?)}");
			cst.setString(1, firstdate1);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			String day = cst.getNString(2);

			if (day.equals("sunday")) {
				c1.add(Calendar.DATE, 8);
				String firstdate2 = sdf.format(c1.getTime());
				pst.setString(8, firstdate2);
			} else {
				pst.setString(8, firstdate1);
			}

			c1.add(Calendar.DATE, 60);
			String seconddateDate = sdf.format(c1.getTime());

			cst = con.prepareCall("{call day(?,?)}");
			cst.setString(1, seconddateDate);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			String day1 = cst.getNString(2);
			if (day.equals("sunday")) {
				c1.add(Calendar.DATE, 61);
				String seconddate23 = sdf.format(c1.getTime());
				pst.setString(9, seconddate23);
			} else {
				pst.setString(9, seconddateDate);
			}

			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("booked succesfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}