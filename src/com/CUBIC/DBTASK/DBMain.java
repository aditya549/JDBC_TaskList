package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBMain {
	public static void main(String[] args) {
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "reddy", "reddy");
	System.out.println("Enter You'r Choice");
	System.out.println("1.Insert");
	System.out.println("2.display");
	System.out.println("3.update");
	System.out.println("4.delete");
	System.out.println("5.Special Update");
	Scanner sc=new Scanner(System.in);
	int ch=sc.nextInt();
	switch(ch){
	case 1:
	CrudOperations.insert(con);
	break;
	case 2:
	CrudOperations.display(con);
	break;
	case 3:
	CrudOperations.update(con);
	break;
	case 4:
	CrudOperations.delete(con);
	break;
	case 5:
	UpdateSpecialCase.UpdateSpecial(con);
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
