package com.r3sys.bankManagement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Withdrawl {
	
	void WidrawMoney()
	{
		Connection con = bankManagement.connect();
		
		Scanner s = new Scanner(System.in);
		int oldBal=0;
		int newBal;
		try {
			PreparedStatement pstmt2 = con.prepareStatement("select * from user where AccNo = ?");
			System.out.println("Enter your Account no");
			int accNo = s.nextInt();
			
			pstmt2.setInt(1, accNo);
			
			ResultSet rc = pstmt2.executeQuery();
			while(rc.next())
			{
				oldBal = rc.getInt(4);
				System.out.println("privious balance : "+oldBal);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			
			
			
			System.out.println("Enter Balance for Withdrawl :");
			int Wbal = s.nextInt();
			
			System.out.println("Enter Acoount No :");
			int accNo = s.nextInt();
			
			newBal = oldBal - Wbal;
			
			PreparedStatement pstmt = con.prepareStatement("update user set Balance = ? where AccNo = ?");
			pstmt.setInt(1,newBal);
			pstmt.setInt(2, accNo);
			
			int i = pstmt.executeUpdate();
			System.out.println("Row Updated count : "+i);
			System.out.println("Withdrawl succesfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
