package com.velocity.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	static String FirstName;
	static String city;
	String Email;
	int Score = 0;
	String Grade = null;

	public static void studentDetails() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("User Form");
		System.out.println("Enter First Name");
		String FirstName = sc.next();
		System.out.println("Enter your City");
		String city = sc.next();
		System.out.println("Enter your EmailId");
		String Email = sc.next();
		startQuiz(FirstName, city, Email);
	}

	public static void startQuiz(String FirstName, String City, String Email) throws Exception {
		try {

			Connection con = ConnectionFile.getConnectionDetails();
			PreparedStatement ps = con.prepareStatement("insert into student(StudentName,city,Email)values(?,?,?)");
			ps.setString(1, FirstName);
			ps.setString(2, City);
			ps.setString(3, Email);
			ps.execute();
			System.out.println(" Registered Sucessfully");
			Thread.sleep(2000);
			System.out.println(" Welcome to Quiz");
			Student stud = new Student();
			stud.getQuestion(Email);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void getQuestion(String Email) {

		try {
			Question que = new Question();
			List<Question> list = setQuestion();
			for (Question question : list) {

				System.out.println("Question: " + question.getQuestion());
				System.out.println("Option A " + question.getOptionA());
				System.out.println("Option B: " + question.getOptionB());
				System.out.println("Option C: " + question.getOptionC());
				System.out.println("Option D: " + question.getOptionD());
				Scanner sc = new Scanner(System.in);
				System.out.println("Select your Ans");
				String ans = sc.next();

				if (ans.equalsIgnoreCase(question.getCorrectAns())) {
					Score++;
				}

			}
			System.out.println("Your Score is:" + Score);

			if (Score >= 8 && Score <= 10) {
				Grade = "A";
				System.out.println(Grade);
			} else if (Score >= 6 && Score < 8) {
				Grade = "B";
				System.out.println(Grade);
			} else if (Score == 5) {
				Grade = "C";
				System.out.println(Grade);
			} else {
				Grade = "Grade D..You are fail";
				System.out.println(Grade);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		updateScoreGrade(Score, Grade, Email);
	}

	public static void updateScoreGrade(int scr, String Grd, String Emi) {

		try {
			Connection con = ConnectionFile.getConnectionDetails();
			PreparedStatement ps = con.prepareStatement("update student set Score=?,Grade=? where Email=? ");
			ps.setInt(1, scr);
			ps.setString(2, Grd);
			ps.setString(3, Emi);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<Question> setQuestion() {

		try {
			List<Question> questions = new ArrayList();
			Connection con = ConnectionFile.getConnectionDetails();
			String sql = "Select * from question";
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(sql);
			while (set.next()) {
				Question que = new Question();
				que.setQue_no(set.getInt(1));
				que.setQuestion(set.getString(2));
				que.setOptionA(set.getString(3));
				que.setOptionB(set.getString(4));
				que.setOptionC(set.getString(5));
				que.setOptionD(set.getString(6));
				que.setCorrectAns(set.getString(7));
				questions.add(que);

			}
			return questions;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void getScore() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email Id to get score");
		String Email = sc.next();
		try {
			Connection con = ConnectionFile.getConnectionDetails();
			PreparedStatement ps = con.prepareStatement("select * from student where Email=?");
			ps.setString(1, Email);
			ResultSet set = ps.executeQuery();
			while (set.next()) {

				System.out.println("Name: " + set.getString(2) + "\nEmailId: " + set.getString(4) + "\nScore: "
						+ set.getInt(5) + "\nGrade: " + set.getString(6));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
