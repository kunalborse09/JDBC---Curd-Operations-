package com.r3sys.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	
	void deleteData()
	{
		Scanner s = new Scanner(System.in);
		try {
			Connection con = Dbconnection.connect();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM user WHERE ID = ?;");
			
			System.out.println("Which data do you want to delete");
			int id = s.nextInt();
			pstmt.setInt(1, id);
			
			int i = pstmt.executeUpdate();
			System.out.println("row updated count"+i);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
