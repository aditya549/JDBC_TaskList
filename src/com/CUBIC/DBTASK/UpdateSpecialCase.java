package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class UpdateSpecialCase {
public static void UpdateSpecial(Connection con)throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Unique id Of The Employee To Update Details");
	String id=sc.next();
	HashSet<String> hs=new HashSet<>();
	PreparedStatement pst=con.prepareStatement("select * from empdata");
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		hs.add(rs.getString(4));
	}
	if(hs.contains(id)) {
		System.out.println("Record Found");
		System.out.println("Enter New Emp name");
		String name=sc.next();
		System.out.println("Enter DEPT To Update");
		String dept=sc.next();
		System.out.println("Enter mailid To Update");
		String mailid=sc.next();
		PreparedStatement pst1=con.prepareStatement("update empdata set empname=?,empdept=?,empmailid=? where Uniqueid=?");
		pst1.setString(1, name);
		pst1.setString(2, dept);
		pst1.setString(3, mailid);
		pst1.setString(4, id);
		int i=pst1.executeUpdate();
		if(i==1) {
			System.out.println("Record Updated");
		}else
			System.out.println("Records Not Updated");
	}
	else
		System.out.println("Records Not Found");
	sc.close();
}
}
