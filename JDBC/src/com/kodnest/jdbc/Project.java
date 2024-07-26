package com.kodnest.jdbc;
import java.util.*;
import java.sql.*;
public class Project {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int c=1;
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			System.out.println("press 1 to insert");
			System.out.println("press 2 to update");
			System.out.println("press 3 to delete");
			System.out.println("press 4 to display table");
			System.out.println("press 0 to exit");
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			Scanner s=new Scanner(System.in);
			c=s.nextInt();
			if(c==1) {
				insert();
			}
			else if(c==2) {
				update();
			}
			else if(c==3) {
				delete();
			}
			else if(c==4) {
				display();
			}
			else if(c==0) {
				System.out.println("ended");
				break;
			}
		}
	
	}
	public static void insert() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
	
		Connection connection=DriverManager.getConnection(url, username, password);
		String sql="insert into student values(?,?)";
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id");
		int id=s.nextInt();
		s.nextLine();
		System.out.println("enter the name");
		String name=s.nextLine();
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setInt(1,id);
		statement.setString(2,name);
		int i=statement.executeUpdate();
		try {
			display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hehe");
		}
	}
	public static void update() throws ClassNotFoundException, SQLException {
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
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,newname);
		statement.setInt(2,newid);	
		int i=statement.executeUpdate();
		
		
		try {
			display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hehe");
		}
		
	}
	public static void delete() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url=("jdbc:mysql://localhost/kodnest");
		String username=("root");
		String password=("root");
		//establishing connection
		Connection connection=DriverManager.getConnection(url, username, password);
		String sql="delete from student where id=?;";
		PreparedStatement statement=connection.prepareStatement(sql);
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id where you want to delete");
		int id=s.nextInt();
		s.close();
		
		statement.setInt(1,id);		
		int i=statement.executeUpdate();
		try {
			display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hehe");
		}
	}
	public static void display() throws ClassNotFoundException, SQLException {
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
	}
}
