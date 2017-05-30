package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.util.MyOracle;

public class SimpleDAO {
	
	public static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List SelectAll() throws SQLException{
		
		String sql = "select * from Simple02 order by sabun";
		List list = new ArrayList<>();
		conn=MyOracle.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				map.put("sabun",  rs.getInt("sabun"));
				map.put("name",  rs.getString("name"));
				map.put("nalja",  rs.getString("nalja"));
				map.put("pay",  rs.getInt("pay"));
				list.add(map);
			}	
		} finally{
			closeAll();
		}
		
		return list;
	}

	public void closeAll() throws SQLException {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
		
	}
	
}
