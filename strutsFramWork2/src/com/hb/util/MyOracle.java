package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyOracle {
 private static Connection conn;
 
 public MyOracle() {
}
	public static Connection getConnection() {
		
		try {
			if(conn==null || conn.isClosed()){
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
