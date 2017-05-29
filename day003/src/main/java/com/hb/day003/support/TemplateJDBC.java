package com.hb.day003.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TemplateJDBC {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public TemplateJDBC() {
	
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

	public Object executeQuery(String sql, RowMapper mapper) throws SQLException{
				return executeQuery(sql, new Object[]{}, mapper);
	}
	public Object executeQuery(String sql, Object[] objs, RowMapper mapper) throws SQLException{
		
		pstmt = conn.prepareStatement(sql);
		
		for (int i =0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		close();
		
		return obj;
	}
	
	public List QueryList(String sql, RowMapper mapper) throws SQLException{
		return QueryList(sql, new Object[]{}, mapper);
	}
	public List QueryList(String sql, Object[] objs, RowMapper mapper) throws SQLException{
	
		List list = RowMapper.list;
		pstmt = conn.prepareStatement(sql);
		
		for (int i =0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		close();
		
		return list;
	}
	
	public int executeUpdate(String sql , Object[] objs) throws SQLException {
		
		pstmt=conn.prepareStatement(sql);
		
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		int result = pstmt.executeUpdate();
		close();
		return result;
		
	}
	
	
	public void close() throws SQLException {
		if (rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null ) conn.close();
	}
	
}
