package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDAO {
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;

		public SimpleDAO() throws ClassNotFoundException, SQLException {
			Connection myconn = null;
			Class.forName("org.h2.Driver");
			myconn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			conn=myconn;
		} 
		
		public List selectAll() throws SQLException{
			String sql = "SELECT * FROM SIMPLE01";
			List<Map<String, Object>> list = null;
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Map<String, Object>  map=new HashMap<String, Object>();
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getDate("nalja"));
				map.put("pay",  rs.getInt("pay"));
				list.add(map);
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
			return list;
			
		}
		
}
