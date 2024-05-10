package com.r3sys.HotelMangement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HotelManagement {
	
	static Connection con = null;
	static Connection connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
