package com.kodnest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("hello");
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);
		//excuting sql statment to create a table
		java.sql.Statement stmt=connection.createStatement();
		stmt.execute("create table santhosh(id int,name varchar(20))");
		System.out.println("success");
	}
}
