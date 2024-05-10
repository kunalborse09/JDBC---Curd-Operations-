package com.r3sys.HotelMangement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotels {
	
	void AvailRooms()
	{
		Connection con = HotelManagement.connect();
		
		Scanner s = new Scanner(System.in);
		int id = 0;
		try {
			System.out.println("Enter Hotel name");
			String name = s.next();
			
			System.out.println("Enter City");
			String city = s.next();
			
			System.out.println("Enter Available Rooms");
			int room = s.nextInt();
			
			PreparedStatement pstmt = con.prepareStatement("insert into Hotel values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			pstmt.setInt(4, room);
			
			int i = pstmt.executeUpdate();
			System.out.println("No of row count "+i);
			System.out.println("Add Succesfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
