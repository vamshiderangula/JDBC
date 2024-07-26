package com.kodnest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayRecords {
	public static void display() throws ClassNotFoundException, Exception , SQLException {
		System.out.println("hello");
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);
		//excuting sql statment to create a statement
		Statement stmt=connection.createStatement();
		//excuting sql statment to create a table
		//stmt.execute("create table student(id int,name varchar(20))");
		//inserting values
		//String str="insert into student values (1,'john')";
//		String str="insert into student values (2,'jack'),(3,'anil'),(4,'raj'),(5,'rafi')";
//		String str="update student set name ='vamshi' where id>2";
//		int i =stmt.executeUpdate(str);
//		String str1="update student set name ='vamshi' where id<2";
//		boolean e =stmt.execute(str1);
//		String str="DELETE from student  WHERE ID>3;";
//		int i =stmt.executeUpdate(str);
		String str="select * from student;";
		ResultSet rs=stmt.executeQuery(str);
		while( rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		System.out.println("success");
	}
}

