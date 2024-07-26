package com.kodnest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecords {
	public static void update() throws ClassNotFoundException, Exception , SQLException {
	
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);
		String sql="update student set name =? where id=?;";
		Scanner s=new Scanner(System.in);
		System.out.println("enter the name to update");
		String newname=s.nextLine();
		
		System.out.println("enter the id where you want to update");
		int newid=s.nextInt();
		s.close();
		
		
//		create the statment
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,newname);
		statement.setInt(2,newid);		
		int i=statement.executeUpdate();
		if(i>0) {
			System.out.println("update succes");
		}
		else {
			System.out.println("update fail");
		}
		DisplayRecords.display();
		System.out.println("success- "+i);

		
	}
}

