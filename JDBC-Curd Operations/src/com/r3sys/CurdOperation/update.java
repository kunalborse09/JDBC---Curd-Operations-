package com.r3sys.CurdOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class update {
	
	void updateData()
	{	
		Scanner s = new Scanner(System.in);
		
		try {
			Connection con = Dbconnection.connect();
			PreparedStatement pstmt = con.prepareStatement("update user set name = ? , city = ? , balance = ? where id = ?");
			
			System.out.println("Enter the new name ");
			String n = s.next();
			
			System.out.println("Enter the new city ");
			String c = s.next();
			
			System.out.println("Enter the new balance ");
			int b = s.nextInt();
			
			System.out.println("For which ID you want to update data");
			int id = s.nextInt();
			
			pstmt.setString(1,n);
			pstmt.setString(2,c);
			pstmt.setInt(3,b);
			pstmt.setInt(4,id);
			
			int i = pstmt.executeUpdate();
			System.out.println("Row updated count "+i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}
}
