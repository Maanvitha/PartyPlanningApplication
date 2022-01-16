package Project.a051.controller;
import java.sql.*;
public class DBHandler {
	public Connection establishConnection(){
	   	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//Retrieving properties from db.properties
		String url="jdbc:mysql://127.0.0.1:3306/party_planning_management";
		String username="root";
		String password="root";
		Connection connection=null;
		//Establishing connection and catching exception if connection is not established or url not found
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
