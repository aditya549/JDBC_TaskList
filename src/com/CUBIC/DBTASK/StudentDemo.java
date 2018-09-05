package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDemo {
	public static void studentModule(Connection con)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t-------------------------");
		System.out.println("\t\tWelcome to Student Module");
		System.out.println("\t\t-------------------------");
		HashMap<String, String> hm=new HashMap<>();
		PreparedStatement pst=con.prepareStatement("select * from studentdetails");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			hm.put(rs.getString(1),rs.getString(2));
		}
		System.out.println("Enter Student Name");
		String sname=sc.next();
		if(hm.containsKey(sname)) {
			System.out.println("Student Name is Valid");
			System.out.println("Enter Student Password");
			String spass=sc.next();
			String pass=hm.get(sname);
			System.out.println(pass);
			if(pass.equals(spass)) {
				System.out.println("Login Successful");
				System.out.println("\t\t------------------------------");
				System.out.println("\t\t"+sname+" Student Details are");
				System.out.println("\t\t------------------------------");
				PreparedStatement pst1=con.prepareStatement("select * from studentdetails where sname=? and spassword=?");
				pst1.setString(1, sname);
				pst1.setString(2, spass);
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next()) {
					System.out.println("Student Name : "+rs1.getString("sname"));
					System.out.println("Student Telugu Marks : "+rs1.getString("telugu"));
					System.out.println("Student Hindi Marks  : "+rs1.getString("hindi"));
					System.out.println("Student English Marks: "+rs1.getString("english"));
					System.out.println("Student social Marks : "+rs1.getString("social"));
					System.out.println("Student science Marks: "+rs1.getString("science"));
					System.out.println("Student maths Marks  : "+rs1.getString("maths"));
					System.out.println("\t-----------");
					System.out.println("\tTotal Marks :"+rs1.getString("total"));
					System.out.println("\tPercentage  :"+rs1.getString("percent"));
					System.out.println("\t-----------");
				}
			}else
				System.out.println("Student Password Is Not Valid");
		}else
			System.out.println("Student Name Is Not Valid");
		sc.close();
	}
}
