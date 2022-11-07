package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFile {
	Connection con=null;
	public static Connection getConnectionDetails() throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/quiz","root","Root@2111");							
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
