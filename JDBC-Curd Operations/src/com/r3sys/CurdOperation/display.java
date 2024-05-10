
package com.r3sys.CurdOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class display {
	
	void disp()
	{
		
		
		try {
			
			Connection con = Dbconnection.connect();
	
			PreparedStatement pstmt = con.prepareStatement("select * from user");
	 
			
			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("city : "+rs.getString(3));
				System.out.println("balance : "+rs.getInt(4));
				System.out.println("\n");
				
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}













