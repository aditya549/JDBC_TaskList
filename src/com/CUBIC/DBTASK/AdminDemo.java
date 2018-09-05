package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Scanner;

public class AdminDemo {
	public static void adminmodule(Connection con)throws Exception {
		Scanner sc=new Scanner(System.in);
		PreparedStatement pst=con.prepareStatement("select * from admin");
		ResultSet rs=pst.executeQuery();
		HashMap<String,String> hm=new HashMap<>();
		while(rs.next()) {
			hm.put(rs.getString(1),rs.getString(2));
		}
		System.out.println("\t\t----------------------");
		System.out.println("\t\tWelcome To Admin Panel");
		System.out.println("\t\t----------------------");
		System.out.println("Enter Admin Name");
		String aname=sc.next();
		if(hm.containsKey(aname)) {
			System.out.println("User name is valid");
			System.out.println("Enter Admin Password");
			String apass=sc.next();
			String pass=hm.get(aname);
			if(pass.equals(apass)) {
				System.out.println("Login Successful");
				System.out.println("WelCome "+aname);
				System.out.println("\t---------------------------------");
				System.out.println("\tEnter Student Complete Details");
				System.out.println("\t---------------------------------");
				System.out.println("Enter Student Name");
				String sname=sc.next();
				System.out.println("Enter Student Password");
				String spass=sc.next();
				System.out.println("Enter Telugu marks:");
				int tmark=sc.nextInt();
				System.out.println("Enter Hindi marks:");
				int hmark=sc.nextInt();
				System.out.println("Enter English marks:");
				int emark=sc.nextInt();
				System.out.println("Enter Scoial marks:");
				int somark=sc.nextInt();
				System.out.println("Enter Science marks:");
				int smark=sc.nextInt();
				System.out.println("Enter maths marks:");
				int mmark=sc.nextInt();
				int total=tmark+hmark+emark+somark+smark+mmark;
				double percent=(total/6);
				PreparedStatement pst1=con.prepareStatement("insert into Studentdetails values(?,?,?,?,?,?,?,?,?,?)");
				pst1.setString(1, sname);
				pst1.setString(2, spass);
				pst1.setInt(3, tmark);
				pst1.setInt(4, hmark);
				pst1.setInt(5, emark);
				pst1.setInt(6, somark);
				pst1.setInt(7, smark);
				pst1.setInt(8, mmark);
				pst1.setInt(9, total);
				pst1.setDouble(10, percent);
				int i=pst1.executeUpdate();
				if(i==0) {
					System.out.println("Student Details Are Not Inerted");
				}else
					System.out.println("Student Details Are sucessfully Inerted");
					System.out.println("Student Total Marks are: "+total);
					System.out.println("Student Percentage is: "+percent);
			}else
				System.out.println("password is not Valid");
		}else
			System.out.println("User Name is Not Valid");
		sc.close();
	}
}
