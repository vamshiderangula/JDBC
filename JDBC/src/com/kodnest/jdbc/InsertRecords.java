package com.kodnest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecords {
	public static void insert() throws ClassNotFoundException, Exception , SQLException {
		
	  //loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection information
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);

		String sql="insert into student values(?,?)";
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id");
		int id=s.nextInt();
		s.nextLine();
		System.out.println("enter the name");
		String name=s.nextLine();
		
		
//		create the statment
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setInt(1,id);
		statement.setString(2,name);
		int i=statement.executeUpdate();
		if(i>0) {
			System.out.println("insertin succes");
		}
		else {
			System.out.println("insertion fail");
		}
		DisplayRecords.display();
		System.out.println("success- "+i);
		
	}
}

