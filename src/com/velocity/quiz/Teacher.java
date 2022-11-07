package com.velocity.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teacher {
	String Username = "admin123";
	static String Password = "Teacher123";

	public static void Login() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Credential");
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password ");
		String paswd = sc.next();
		Thread.sleep(2000);
		if (paswd.equals(Password)) {
			System.out.println("Login Sucessfully....");
			Thread.sleep(2000);
			getAllScore();
			getQuestion();
		} else {
			throw new customeException("Invalid Credential..");
		}
	}

	private static void getAllScore() {
		try {
			Connection con = ConnectionFile.getConnectionDetails();
			String sql = "select * from student";
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(sql);
			while (set.next()) {
				System.out.println("StudId: " + set.getInt(1) + "\nStudentName: " + set.getString(2) + "\nCity:"
						+ set.getString(3) + "\n Eamil Id: " + set.getString(4) + "\n Score:" + set.getInt(5)
						+ "\n Grade: " + set.getString(6));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getQuestion() {
		try {
			Connection con = ConnectionFile.getConnectionDetails();
			String sql = "select * from question";
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(sql);
			while (set.next()) {
				System.out.println("Question No.: " + set.getInt(1) + "\nQuestion: " + set.getString(2) + "\nOption A:"
						+ set.getString(3) + "\n Option B: " + set.getString(4) + "\n Option C:" + set.getString(5)
						+ "\n Option D: " + set.getString(6) + "\nCorrectAnswer:" + set.getString(7));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
