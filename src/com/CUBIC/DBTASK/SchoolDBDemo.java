package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class SchoolDBDemo {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "reddy", "reddy");
		Scanner sc=new Scanner(System.in);
		System.out.println("\t-------------------------------------");
		System.out.println("\tWelcome To school DataBase Application");
		System.out.println("\t-------------------------------------");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Login");
		System.out.println("PLease Select You'r Option");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:AdminDemo.adminmodule(con);
		break;
		case 2:StudentDemo.studentModule(con);
		break;
		default:
			System.out.println("Invalid Selection");
		}
		sc.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
