


package com.r3sys.CurdOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {
	
	void insert()
	{
		try {
			Scanner s =new Scanner(System.in);
			
			System.out.println("Enter the id");
			int a = s.nextInt();
			
			System.out.println("Enter the name");
			String b = s.next();
			
			System.out.println("Enter the City");
			String c = s.next();
			
			System.out.println("Enter the Balance");
			int d = s.nextInt();
			
			Connection con = Dbconnection.connect();
			
			PreparedStatement pstmt = con.prepareStatement("Insert into user values(?,?,?,?)");
			
			
			pstmt.setInt(1, a);
			pstmt.setString(2, b);
			pstmt.setString(3, c);
			pstmt.setInt(4, d);
	
			
			
			int	i = pstmt.executeUpdate();
			System.out.println("row update count "+i);
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



