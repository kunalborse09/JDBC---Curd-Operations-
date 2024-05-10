package com.r3sys.bankManagement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TransferMoney {
	
	void Transfer()
	{
		Scanner s = new Scanner(System.in);
		Connection con = bankManagement.connect();
		
		int oldBal=0;
		int newBal;
		try {
			PreparedStatement pstmt1 = con.prepareStatement("select * from user where AccNo = ?");
			System.out.println("Enter your Account no");
			int accNo = s.nextInt();
			
			pstmt1.setInt(1, accNo);
			
			ResultSet rc = pstmt1.executeQuery();
			while(rc.next())
			{
				oldBal = rc.getInt(4);
				System.out.println("privious balance : "+oldBal);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		int Mtransf = 0;
		try {
			PreparedStatement pstmt2 = con.prepareStatement("update user set balance = ? where AccNo = ?");
			
			System.out.println("Enter sender Account no");
			int accNo = s.nextInt();
			
			System.out.println("How much money you want to transfer");
			Mtransf = s.nextInt();
			
		    newBal = oldBal - Mtransf;
		    
		    pstmt2.setInt(1,newBal);
			pstmt2.setInt(2, accNo);
			
			int i = pstmt2.executeUpdate();
			System.out.println("Row Updated count : "+i);
			
			if(newBal > 0)
			{
			System.out.println("Transfer Money succesfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		int pBal=0;
		int nBal;
		try {
			PreparedStatement pstmt1 = con.prepareStatement("select * from user where AccNo = ?");
			System.out.println("Enter Reciver Account no");
			int accNo = s.nextInt();
			
			pstmt1.setInt(1, accNo);
			
			ResultSet rc = pstmt1.executeQuery();
			while(rc.next())
			{
				pBal = rc.getInt(4);
				System.out.println("privious balance : "+pBal);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
				
			System.out.println("Enter Reciver Acoount No :");
			int accNo = s.nextInt();
			
			nBal = pBal + Mtransf;
			
			PreparedStatement pstmt = con.prepareStatement("update user set balance = ? where AccNo = ?");
			pstmt.setInt(1,nBal);
			pstmt.setInt(2, accNo);
			
			int i = pstmt.executeUpdate();
			System.out.println("Row Updated count : "+i);
			
			if(nBal > 0)
			{
			System.out.println("Recive Money succesfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			PreparedStatement pstmt2 = con.prepareStatement("select * from user where AccNo = ?");
			
			System.out.println("Enter sender Account no");
			int accNo = s.nextInt();
			
			System.out.println("Enter Reciver Account no");
			int accnNo = s.nextInt();
			
			pstmt2.setInt(1, accNo);
			pstmt2.setInt(1, accnNo);
			
			ResultSet rc = pstmt2.executeQuery();
			while(rc.next())
			{
				accNo = rc.getInt(4);
				System.out.println("Total Ammount of Sender : "+accNo);
				
				accnNo = rc.getInt(4);
				System.out.println("Total Ammount of Reciver : "+accnNo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
