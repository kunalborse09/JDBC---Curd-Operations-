package com.r3sys.bankManagement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccount {
	
	void userInput()
	{
		
		try {
			Connection con = bankManagement.connect();
			int accNo = 0;
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter Your Name :");
			String name = s.next();
			
			System.out.println("Enter Your City :");
			String city = s.next();
			
			System.out.println("Enter Your Balance :");
			int bal = s.nextInt();
			
			
			PreparedStatement pstmt = con.prepareStatement("Insert into user values (?,?,?,?)");
			
			pstmt.setInt(1, accNo);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			pstmt.setInt(4, bal);
			
			int i = pstmt.executeUpdate();
			System.out.println("No of Row Count : "+i);
			System.out.println("Account Created Succesfully...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
