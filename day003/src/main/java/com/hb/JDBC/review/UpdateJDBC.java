package com.hb.JDBC.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateJDBC {

		private Connection conn;
		private PreparedStatement pstmt;
		
		public UpdateJDBC() {
		
			String url = "jdbc:h2:tcp://localhost/~/test";
		      String user = "sa";
		      String pw = "";
		      
		      try {
		         Class.forName("org.h2.Driver");
		         conn = DriverManager.getConnection(url, user, pw);
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		}
	
		public void close() throws SQLException {
			if(pstmt != null) pstmt.close();
			if(conn != null ) conn.close();
		}
	
	public int executeUpdate(String sql , Object[] objs) throws SQLException {
		
		pstmt=conn.prepareStatement(sql);
		
//		pstmt.setString(1, name);
//		pstmt.setString(2, nalja);
//		pstmt.setInt(3, pay);
		
//		pstmt.setString(1, name);
//		pstmt.setString(2, nalja);
//		pstmt.setInt(3, pay);
//		pstmt.setInt(4, sabun);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		int result = pstmt.executeUpdate();
		close();
		return result;
		
	}

}
