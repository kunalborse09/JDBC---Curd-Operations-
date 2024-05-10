package com.r3sys.bankManagement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheakBalance {
	
	void cheakBal()
	{
		Scanner s = new Scanner(System.in);
		Connection con = bankManagement.connect();
		
		try {
			PreparedStatement pstmt2 = con.prepareStatement("select * from user where AccNo = ?");
			
			System.out.println("Enter your Account no");
			int accNo = s.nextInt();
			
			pstmt2.setInt(1, accNo);
			
			ResultSet rc = pstmt2.executeQuery();
			while(rc.next())
			{
				System.out.println("Total Ammount : "+rc.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
