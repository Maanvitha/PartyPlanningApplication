package Project.a051.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import org.springframework.context.annotation.Configuration;
import Project.a051.model.Login;
import Project.a051.model.Registration;
import Project.a051.model.Validation;

@Configuration
public class DBClass {
	private DBHandler db = new DBHandler();
	String userid1 = null;
	Login l;

	// Registration
	public void setValues(Registration registration) {
		// TODO Auto-generated method stub\

		String firstName = registration.getFirstName();
		String lastName = registration.getLastName();
		Date uDob = registration.getDob();
		java.sql.Date sDob = new java.sql.Date(uDob.getTime());
		String gender = registration.getGender();
		String contactNumber = registration.getContactNum();
		String userId = registration.getUserID();
		String password = registration.getPassword();
		String sq_1_answer = registration.getSq1();
		String sq_2_answer = registration.getSq2();
		String sq_3_answer = registration.getSq3();
		System.out.println(sq_3_answer);
		String role = registration.getRoles();
		System.out.println("role is:" + role);
		Connection conn = db.establishConnection();
		System.out.println(conn);
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(
					"insert into user_details(first_name,last_name,dob,gender,contact_number,user_id,password,secret_question_1,secret_question_2,secret_question_3,role,approval)"
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedstatement.setString(1, firstName);
			preparedstatement.setString(2, lastName);
			preparedstatement.setDate(3, sDob);
			preparedstatement.setString(4, gender);
			preparedstatement.setString(5, contactNumber);
			preparedstatement.setString(6, userId);
			preparedstatement.setString(7, password);
			preparedstatement.setString(8, sq_1_answer);
			preparedstatement.setString(9, sq_2_answer);
			preparedstatement.setString(10, sq_3_answer);
			preparedstatement.setString(11, role);
			if (role == "customer")
				preparedstatement.setString(12, "yes");
			else
				preparedstatement.setString(12, "pending");
			preparedstatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("error in inserting values");
		}
	}

	// check for an existing userid while registration
	public int checkuserid(String userId) {

		System.out.println(userId);

		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		int flag = 0;
		try {
			mystmt = conn.prepareStatement("select * from user_details where user_id = '" + userId + "';");
			ResultSet rs = mystmt.executeQuery();
			if (rs.next()) {
				flag = 1;
				return flag;

			} else {
				return flag;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	// correct login credentials
	public int check(Login login) {
		l = login;
		String userid = login.getUserid();
		userid1 = userid;
		String password = login.getPassword();
		System.out.println(userid);
		System.out.println(password);
		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		int flag = 0;
		try {
			mystmt = conn.prepareStatement(
					"select * from user_details where user_id = '" + userid + "' and password = '" + password + "';");
			ResultSet rs = mystmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(7).equals(password)) {
					flag = 1;
					break;
				} else {
					flag = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	// forget password
	public void storeNewPwd(String pwd, String userid) {
		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("update user_details set password = (?)  where user_id = (?);");
			mystmt.setString(1, pwd);
			mystmt.setString(2, userid);
			int rs = mystmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// validation for forget password
	public int checkDB(Validation validation) {
		// TODO Auto-generated method stub\

		String userId = validation.getUserid();
		System.out.println(userId);
		String q1 = validation.getSq1();
		String q2 = validation.getSq2();
		String q3 = validation.getSq3();
		String sq1, sq2, sq3;
		Connection conn = db.establishConnection();
		System.out.println(conn);
		Statement mystmt;
		try {
			mystmt = conn.createStatement();
			ResultSet myrs = mystmt.executeQuery("select * from user_details");
			while (myrs.next()) {
				// System.out.println(myrs.getString("secret_question_1"));
				if (userId.equals(myrs.getString("user_id"))) {
					sq1 = myrs.getString("secret_question_1");
					sq2 = myrs.getString("secret_question_2");
					sq3 = myrs.getString("secret_question_3");
					System.out.println(sq1 + " " + sq2 + " " + sq3);
					if (q1.equals(sq1) && q2.equals(sq2) && q3.equals(sq3)) {
						return 1;
					} else {
						return 0;
					}
				}
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("error in inserting values");
		}
		return 0;
	}

	// for forget user id
	public String checkDBU(String num, String q1, String q2, String q3) {
		// TODO Auto-generated method stub\

		String sq1 = "", sq2 = "", sq3 = "";

		Connection conn = db.establishConnection();
		System.out.println(conn);
		Statement mystmt;
		try {
			mystmt = conn.createStatement();
			ResultSet myrs = mystmt.executeQuery("select * from user_details");
			while (myrs.next()) {
				// System.out.println(myrs.getString("secret_question_1"));
				if (num.equals(myrs.getString("contact_number"))) {
					sq1 = myrs.getString("secret_question_1");
					sq2 = myrs.getString("secret_question_2");
					sq3 = myrs.getString("secret_question_3");
					System.out.println(sq1 + " " + sq2 + " " + sq3);
					if (q1.equals(sq1) && q2.equals(sq2) && q3.equals(sq3)) {
						return myrs.getString("user_id");
					} else {
						return "0";
					}
				}
			}
			return "0";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("error in inserting values");
		}
		return "0";
	}

	// Retrieve Venue details
	public ArrayList<String> retrieveVenueDetails(String place) {
//			String userid = login.getUserid();
//			String password = login.getPassword();
//			System.out.println(userid);
//			System.out.println(password);
		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			// System.out.println(place);
			mystmt = conn.prepareStatement("select * from venue_details where venue_location='" + place + "';");
			// mystmt.setString(1,place);
			ResultSet rs = mystmt.executeQuery();
			String[] venue = new String[100];
			int size = 0;
			while (rs.next()) {
				venue[size] = rs.getString("venue_id") + " " + rs.getString("venue_name") + " "
						+ rs.getString("venue_location") + " " + "Rs." + rs.getString("price");
				size++;
			}

			for (int i = 0; i < size; i++) {
				list.add(venue[i]);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// to store user feedback in db
	public void storeFeedback(String feedback, int booking_id) {

		Connection conn = db.establishConnection();
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn
					.prepareStatement("update booking_details set feedback = (?)  where booking_id = (?);");
			preparedstatement.setString(1, feedback);
			preparedstatement.setInt(2, booking_id);
			preparedstatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("error in inserting values");
		}

	}

	// ack approval by admin
	public ArrayList<String> retrieveAck() {
		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select * from booking_details where status = (?);");
			mystmt.setString(1, "pending");
			ResultSet rs = mystmt.executeQuery();
			String[] venue = new String[100];
			int size = 0;
			// System.out.println(rs.getInt("booking_id"));
			while (rs.next()) {
				System.out.println("booking ack");
				System.out.println(rs.getInt("booking_id"));
				venue[size] = rs.getInt("booking_id") + " " + rs.getString("booking_date") + " "
						+ rs.getString("venue_id") + " " + rs.getString("user_id") + " " + rs.getString("status");
				size++;
			}

			for (int i = 0; i < size; i++) {
				System.out.println(venue[i]);
				list.add(venue[i]);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// to add approved by admin
	public void addApproved(int booking_id) {
		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("UPDATE booking_details SET status = (?) WHERE booking_id=(?);");
			mystmt.setString(1, "Approved");
			mystmt.setInt(2, booking_id);
			int rs = mystmt.executeUpdate();
			System.out.println("no of rows updated " + rs);
			String[] venue = new String[100];
			int size = 0;
			// System.out.println(rs.getInt("booking_id"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DisApproved(int booking_id) {
		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("UPDATE booking_details SET status = (?) WHERE booking_id=(?);");
			mystmt.setString(1, "DisApproved");
			mystmt.setInt(2, booking_id);
			int rs = mystmt.executeUpdate();
			System.out.println("no of rows updated " + rs);
			String[] venue = new String[100];
			int size = 0;
			// System.out.println(rs.getInt("booking_id"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> retrieveAckd() {
		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select * from booking_details where status = (?);");
			mystmt.setString(1, "pending");
			ResultSet rs = mystmt.executeQuery();
			String[] venue = new String[100];
			int size = 0;
			// System.out.println(rs.getInt("booking_id"));
			while (rs.next()) {
				System.out.println("booking ack");
				System.out.println(rs.getInt("booking_id"));
				venue[size] = rs.getInt("booking_id") + " " + rs.getString("booking_date") + " "
						+ rs.getString("venue_id") + " " + rs.getString("user_id") + " " + rs.getString("status");
				size++;
			}

			for (int i = 0; i < size; i++) {
				System.out.println(venue[i]);
				list.add(venue[i]);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// checking venue availability
	public int checkVenueAvailability(int venue_id, String date) {
		Connection conn = db.establishConnection();
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement("select venue_id from booking_details where venue_id=" + venue_id
					+ " and booking_date='" + date + "';");
			ResultSet rs = preparedstatement.executeQuery();
			// System.out.println(rs.getString(columnIndex));

			if (rs.next()) {
				return 0;
			} else {
				preparedstatement = conn.prepareStatement(
						"insert into booking_details(booking_date,venue_id,user_id,status) values(?,?,?,?);");
				preparedstatement.setString(1, date);
				preparedstatement.setString(4, "pending");
				preparedstatement.setInt(2, venue_id);
				preparedstatement.setString(3, l.getUserid());
				preparedstatement.execute();
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in selecting venue");
		}
		return 0;
	}

	public Registration update() {

		Connection conn = db.establishConnection();

		Statement st;
		try {

			String query = "select * from user_details where user_id='" + userid1 + "';";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			String firstname = null;
			String lastname = null;
			String gender = null;
			String contactnumber = null;
			String userid = null;
			String password = null;
			String sq1 = null;
			String sq2 = null;
			String sq3 = null;
			// Date dateofbirth=null;
			String role = null;
			while (rs.next()) {
				firstname = rs.getString("first_name");
				lastname = rs.getString("last_name");
				gender = rs.getString("gender");
				// dateofbirth=rs.getDate(3);
				contactnumber = rs.getString("contact_number");
				userid = rs.getString("user_id");
				role = rs.getString("role");

				password = rs.getString("password");
				sq1 = rs.getString("secret_question_1");
				sq2 = rs.getString("secret_question_2");
				sq3 = rs.getString("secret_question_3");

			}
			Registration registration = new Registration();
			registration.setContactNum(contactnumber);
			registration.setFirstName(firstname);
			registration.setLastName(lastname);
			// registration.setDob(dateofbirth);
			registration.setGender(gender);
			registration.setUserID(userid);
			registration.setPassword(password);
			registration.setRoles(role);
			registration.setSq1(sq1);
			registration.setSq2(sq2);
			registration.setSq3(sq3);
			return registration;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<String> updateContacts() {

		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select email_id from contacts where user_id='" + userid1 + "';");
			ResultSet rs = mystmt.executeQuery();
			String[] venue = new String[100];
			int size = 0;
			while (rs.next()) {
				venue[size] = rs.getString("email_id");
				size++;
			}

			for (int i = 0; i < size; i++) {
				list.add(venue[i]);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public int addVenues(int venue_id, String venue_name, String venue_location, int price) {
		Connection conn = db.establishConnection();
		PreparedStatement preparedstatement;
		try {

			preparedstatement = conn.prepareStatement(
					"insert into venue_details(venue_id,venue_name,venue_location,price) values(?,?,?,?);");
			preparedstatement.setInt(1, venue_id);
			preparedstatement.setString(2, venue_name);
			preparedstatement.setString(3, venue_location);
			preparedstatement.setInt(4, price);
			preparedstatement.execute();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("error in selecting venue");
		}
		return 0;
	}

	public void updaterow(Registration r) {
		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		System.out.println("hjgiukjhlkh" + r.getFirstName());
		try {
			mystmt = conn.prepareStatement("update user_details set first_name = (?)  where user_id = (?);");
			mystmt.setString(1, r.getFirstName());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();
			// System.out.println("1225454"+r.getFirstName());

			mystmt = conn.prepareStatement("update user_details set last_name = (?)  where user_id = (?);");
			mystmt.setString(1, r.getLastName());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set contact_number = (?)  where user_id = (?);");
			mystmt.setString(1, r.getContactNum());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set password = (?)  where user_id = (?);");
			mystmt.setString(1, r.getPassword());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set secret_question_1 = (?)  where user_id = (?);");
			mystmt.setString(1, r.getSq1());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set secret_question_2 = (?)  where user_id = (?);");
			mystmt.setString(1, r.getSq2());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set secret_question_3 = (?)  where user_id = (?);");
			mystmt.setString(1, r.getSq3());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

			mystmt = conn.prepareStatement("update user_details set gender = (?)  where user_id = (?);");
			mystmt.setString(1, r.getGender());
			mystmt.setString(2, l.getUserid());
			mystmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// add contacts to database

	public int addContacts(String email) {
		Connection conn = db.establishConnection();
		PreparedStatement preparedstatement;

		try {

			preparedstatement = conn.prepareStatement("insert into contacts(user_id,email_id) values(?,?);");
			preparedstatement.setString(1, l.getUserid());
			preparedstatement.setString(2, email);
			preparedstatement.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("error in selecting venue");
		}

		return 0;
	}

	// Generating Report
	public void report() {

		try {
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\839069\\Desktop\\books_table1.csv"));
			StringBuilder sb = new StringBuilder();

			Connection conn = db.establishConnection();
			ResultSet rs = null;

			String query = "select * from booking_details";
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				sb.append(rs.getString("booking_id"));
				sb.append(",");
				sb.append(rs.getString("booking_date"));
				sb.append(",");
				sb.append(rs.getString("venue_id"));
				sb.append(",");
				sb.append(rs.getString("user_id"));
				// sb.append(",");
				// sb.append(rs.getString("publisher_name"));
				sb.append("\r\n");
			}

			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// for storing images in databases
	/*public void displayTemplates(ModelMap m, String category, String dresstype, String tid) {
		Connection conn = db.establishConnection();
		Statement st;
		try {

			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from patterns where tid='" + tid + "' and category='" + category
					+ "' and dresstype='" + dresstype + "';");
			List<String> tidList = new ArrayList();
			List<String> categoryList = new ArrayList();
			List<String> dressTypeList = new ArrayList();
			List<String> costList = new ArrayList();
			List<String> imageList = new ArrayList();
			while (rs.next()) {
				tidList.add(rs.getString("tid"));
				categoryList.add(rs.getString("category"));
				dressTypeList.add(rs.getString("dresstype"));
				costList.add(rs.getString("cost"));
				imageList.add("img//" + rs.getString("image"));

			}
			m.put("tidList", tidList);
			m.put("categoryList", categoryList);
			m.put("dressTypeList", dressTypeList);
			m.put("costList", costList);
			m.put("imageList", imageList);
			System.out.println(imageList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	// admin adding templates
	public int addTemplates(String img, String occasion) {
		Connection conn = db.establishConnection();
		PreparedStatement preparedstatement;
		try {

			FileInputStream fis = null;
			String fin = "C:\\Users\\839069\\Documents\\" + img;
			File bfile = new File("C:\\Users\\839069\\Desktop\\a051\\src\\main\\resources\\static\\img\\" + img);
			File ff = new File(fin);
			InputStream inStream = new FileInputStream(ff);
			OutputStream outStream = new FileOutputStream(bfile);
			fis = new FileInputStream(ff);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();

			outStream.close();
			preparedstatement = conn.prepareStatement("insert into templates(image,occasion) values(?,?);");
			preparedstatement.setBinaryStream(1, (InputStream) fis, (int) (ff.length()));
			preparedstatement.setString(2, occasion);
			preparedstatement.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("error in selecting venue");
		}
		return 0;
	}

	public ArrayList<String> retrievePlaceDetails() {

		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select distinct venue_location from venue_details;");
			ResultSet rs = mystmt.executeQuery();
			String[] venue = new String[100];
			int size = 0;
			while (rs.next()) {
				venue[size] = rs.getString("venue_location");
				size++;
			}

			for (int i = 0; i < size; i++) {
				list.add(venue[i]);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int checkadmin(Login login) {
		l = login;
		String userid = login.getUserid();
		userid1 = userid;
		String password = login.getPassword();
		System.out.println(userid);
		System.out.println(password);
		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		int flag = 0;
		try {
			mystmt = conn.prepareStatement(
					"select * from user_details where user_id = '" + userid + "' and password = '" + password + "';");
			ResultSet rs = mystmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("password").equals(password) && rs.getString("role").equals("admin")
						&& rs.getString("approval").equals("yes")) {
					flag = 1;
					break;
				} else {
					flag = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void editContact(String cont, String previous) {

		Connection conn = db.establishConnection();
		PreparedStatement mystmt;
		try {
			mystmt = conn
					.prepareStatement("update contacts set email_id = (?)  where user_id = (?) and email_id =(?);");
			mystmt.setString(1, cont);
			mystmt.setString(2, userid1);
			mystmt.setString(3, previous);

			int rs = mystmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> checkBookingStatus() {

		Connection conn = db.establishConnection();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select * from booking_details where user_id = (?);");
			mystmt.setString(1, l.getUserid());
			System.out.println("booking" + l.getUserid());
			ResultSet rs = mystmt.executeQuery();
			String[] status = new String[100];
			int size = 0;
			while (rs.next()) {

				status[size] = "Your recent booking_id " + rs.getInt("booking_id") + " for "
						+ rs.getString("booking_date") + " for " + rs.getString("venue_id") + " Status is"
						+ rs.getString("status");
				size++;
			}

			for (int i = 0; i < size; i++) {
				System.out.println(status[i]);
				list.add(status[i]);
				System.out.println("list is " + list.get(i));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
