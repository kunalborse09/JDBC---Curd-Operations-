package com.r3sys.HotelMangement.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInfo {
	
	void BookHotel()
	{
		Connection con = HotelManagement.connect();
		Scanner s = new Scanner(System.in);
		int id =0;
		int hotelId = 0;
		int availableRooms = 0;
		String name = null;
		try {
		
			System.out.println("Enter your name");
			name = s.next();
			
			System.out.println("Enter your Mobile no");
			int mobNo = s.nextInt();
			
			PreparedStatement pstmt = con.prepareStatement("insert into userdata values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, mobNo);
			pstmt.setInt(4, hotelId);
			
			int i = pstmt.executeUpdate();
			System.out.println("no of rows : "+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Hotel where ID = ?");
			
			System.out.println("Select Hotel : \n 1.Taj \n 2.star \n 3.rcpit \n 4.king");
			int ch = s.nextInt();
			switch(ch)
			{
			case 1 : pstmt.setInt(1,ch);
					 break;
					 
			case 2 : pstmt.setInt(1,ch);
			 		 break;
			 		 
			case 3 : pstmt.setInt(1,ch);
					 break;
					 
			case 4 : pstmt.setInt(1,ch);
					 break;
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Hotel "+rs.getString(2)+" Booking Confirm...!");
				hotelId = rs.getInt(1);
				System.out.println("Your Hotel ID is : "+hotelId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try
		{
			PreparedStatement pst = con.prepareStatement("update userdata set HotelID = ? where name = ?");
			pst.setInt(1,hotelId);
			pst.setString(2,name);
			
			pst.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		try
			{
			PreparedStatement ps = con.prepareStatement("select * from Hotel where Id = ?");
			ps.setInt(1, hotelId);
			ResultSet r =  ps.executeQuery();
			while(r.next())
			{
				availableRooms = r.getInt(4);
				System.out.println("Available Rooms : "+availableRooms );	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try
		{
			PreparedStatement pst = con.prepareStatement("update Hotel set Rooms = ? where ID = ?");
			System.out.println("How many rooms are you wanted to book ?");
			int roombook = s.nextInt();
			
			System.out.println("please enter your id ");
			int id2 = s.nextInt();
			
			int book = availableRooms - roombook;
			
			System.out.println("Okk.. You are book "+roombook+" Rooms");
			System.out.println("Thank you");
			
			pst.setInt(1,book);
			pst.setInt(2, id2);
			
			pst.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
		
	}

}
