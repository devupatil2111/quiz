package com.velocity.quiz;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Quiz");
		System.out.println("Select an option");
		System.out.println("1. Start Quiz");
		System.out.println("2. Admin");
		System.out.println("3. View Score(if already attended)");
		Student stud = new Student();
		Teacher tea = new Teacher();

		int a = sc.nextInt();
		switch (a) {
		case 1:
			stud.studentDetails();
			break;
		case 2:
			tea.Login();
			break;
		case 3:
			stud.getScore();
			break;
		default:
			System.out.println("Choose correct Option");
		}

	}

}
