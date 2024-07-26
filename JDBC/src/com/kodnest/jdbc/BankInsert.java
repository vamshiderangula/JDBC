package com.kodnest.jdbc;
import java.util.*;
import java.sql.*;
public class BankInsert {
	@SuppressWarnings("null")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("hello");
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		
		//inserting values
		String str1="update bank set balance =balance-70000 where acc_no=123";
		String str2="updates bank set balance =balance-70000 where acc_no=12";
		Connection connection = null;
	try {
		
		connection.setAutoCommit(false);
		//excuting sql statment to create a statement
		Statement st=connection.createStatement();
		connection=DriverManager.getConnection(url, username, password);
			st.addBatch(str1);
			st.addBatch(str2);
			st.executeBatch();
			connection.commit();
			}
	catch(Exception e) {
		connection.rollback();
	}
			
		
			
		
	
		System.out.println("success");
	}

}
