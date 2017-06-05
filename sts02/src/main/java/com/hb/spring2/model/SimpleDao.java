package com.hb.spring2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SimpleDao() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			
		}catch (Exception e) {
		 e.printStackTrace();
		}
	}
	
	public List<SimpleVo> selectAll() throws SQLException{
		String sql = "select * from simple03 order by sabun";
		
		List<SimpleVo> list = new ArrayList<>();
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SimpleVo bean = new SimpleVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				list.add(bean);
			}
			
		}finally{
			closeAll();
		}
		
		return list;
		
	}

	private void closeAll() throws SQLException {
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

	public void insertOne(SimpleVo simpleVo) throws SQLException {
		String sql ="insert into simple03 values (?,?,sysdate,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, simpleVo.getSabun());
			pstmt.setString(2, simpleVo.getName());
			pstmt.setInt(3, simpleVo.getPay());
			pstmt.executeUpdate();
		}finally {
			closeAll();
		}
		
	}

}
