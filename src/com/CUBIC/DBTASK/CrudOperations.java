package com.CUBIC.DBTASK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class CrudOperations {
	public static void insert(Connection con) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp Name");
		String uname=sc.next();
		System.out.println("Enter Emp dept");
		String dept=sc.next();
		System.out.println("Enter Emp mailid");
		String mailid=sc.next();
		System.out.println("Enter Unique id Of the Employee");
		int id=sc.nextInt();
		PreparedStatement pstmt=con.prepareStatement("insert into empdata(empname,empdept,empmailid,uniqueid) values(?,?,?,?)");
		pstmt.setString(1,uname);
		pstmt.setString(2, dept);
		pstmt.setString(3, mailid);
		pstmt.setInt(4, id);
		int i=pstmt.executeUpdate();
		if(i==1) {
			System.out.println("1-row Intserted");
		}else
			System.out.println("not inserted");
		sc.close();
	}
	public static void update(Connection con) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user name To update");
		String name=sc.next();
		PreparedStatement pstmt=con.prepareStatement("select * from empdata");
		ResultSet rs=pstmt.executeQuery();
		HashSet<String> hs=new HashSet<>();
		while(rs.next()) {
		hs.add(rs.getString("empname"));
		}
			if(hs.contains(name)) {
				System.out.println("Record found");
				System.out.println("enter dept");
				String dept=sc.next();
				System.out.println("enter mail id");
				String mailid=sc.next();
				PreparedStatement pstmt1=con.prepareStatement("update empdata set empdept=?,empmailid=? where empname=?");
				pstmt1.setString(1, dept);
				pstmt1.setString(2,mailid);
				pstmt1.setString(3,name);
				int i= pstmt1.executeUpdate();
				if(i==1) {
					System.out.println("records updated");
				}else {
					System.out.println("records not updated");
				}
			}else
				System.out.println("record not found");
			sc.close();
		}
	public static void delete(Connection con) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter table name to delete");
		String table=sc.next();
		System.out.println("enter user name to delete");
		String uname=sc.next();
		String sqlQuery="delete from "+table+" where empname=?";
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);
			pstmt.setString(1, uname);
			int i=pstmt.executeUpdate();
			if(i==0) {
				System.out.println("Not deleted");
			}else
				System.out.println("Deleted");
			sc.close();
	}
	public static void display(Connection con)throws Exception {
		Scanner sc=new Scanner(System.in);
			PreparedStatement pstmt=con.prepareStatement("select * from empdata");
			ResultSet rs=pstmt.executeQuery();
			System.out.println("EName\tEDept\tEMailid\t  UniqueId");
			System.out.println("-----\t-----\t-------\t  --------");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			}
			sc.close();
		}
	
}

