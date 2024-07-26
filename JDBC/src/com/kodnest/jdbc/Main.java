package com.kodnest.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		Scanner s = new Scanner(System.in);
		while(true) {
			DisplayRecords.display();
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			System.out.println("press 1 to insert");
			System.out.println("press 2 to update");
			System.out.println("press 3 to delete");
			System.out.println("press 4 to display table");
			System.out.println("press 0 to exit");
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			Thread.sleep(4000);
			System.out.println("enter your option");
			
				int c=s.nextInt();
				switch(c){
				case 1:InsertRecords.insert();
				break;
				case 2:UpdateRecords.update();
				break;
				case 3:Delete.delete();
				break;
				case 4:DisplayRecords.display();
				break;
				case 0:System.exit(0);	
				break;
				default:System.exit(0);
				break;
				}
			
	
	
		}
	}
}
