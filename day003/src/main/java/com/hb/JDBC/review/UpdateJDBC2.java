package com.hb.JDBC.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hb.day003.model.SimpleVO;

public abstract class UpdateJDBC2 {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UpdateJDBC2() {
	
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

	public Object executeQuery(String sql) throws SQLException{
				return executeQuery(sql, new Object[]{});
	}
	public Object executeQuery(String sql, Object[] objs) throws SQLException{
		
		pstmt = conn.prepareStatement(sql);
		
		for (int i =0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		rs = pstmt.executeQuery();
		Object obj = mapRow(rs);
		close();
		
		return obj;
	}
	
	public abstract	Object mapRow(ResultSet rs) throws SQLException;
	
	public void close() throws SQLException {
		if (rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null ) conn.close();
	}
	
}
