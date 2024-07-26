package com.kodnest.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void delete()  throws ClassNotFoundException, Exception , SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);
		String sql="delete from student where id=?";
		PreparedStatement statment= connection.prepareStatement(sql);
		Scanner s=new Scanner(System.in);
		System.out.println("enter id where to delete");
		int a=s.nextInt();
			statment.setInt(1, a);
		statment.execute();
		System.out.println("deleted");
		
		
	}

}
