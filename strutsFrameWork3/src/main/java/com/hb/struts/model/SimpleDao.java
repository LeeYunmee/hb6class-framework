package com.hb.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class SimpleDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SimpleDao(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "tiger" ;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int updateOne(SimpleVo bean) throws SQLException {
		String sql = "update simple03 set name=?, pay=? where sabun=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
			
		}finally{
			closeAll();
		}
	}
	
	public List<SimpleVo> selectAll() throws SQLException{
		List<SimpleVo> list = new ArrayList<>();
		String sql ="select * from simple03 order by sabun";
		try{
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while (rs.next()) {
			list.add(new SimpleVo(rs.getInt("sabun"),
					rs.getString("name"),
					rs.getDate("nalja"),
					rs.getInt("pay")
					));
			}
		}finally {
			closeAll();
		}
		return list;
	}
	
	public int insertOne(int sabun, String name, int pay) throws SQLException{
		
		String sql = "insert into simple03 (sabun, name, pay) values (?,?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			return pstmt.executeUpdate();
			
			
		}finally{
			closeAll();
		}
		
		
	}

	public int insertOne(SimpleVo bean) throws SQLException{
		
		String sql = "insert into simple03 (sabun, name, pay) values (?,?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			return pstmt.executeUpdate();
			
			
		}finally{
			closeAll();
		}
		
		
	}

	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql = "select * from simple03 where sabun=?";
		
		SimpleVo bean = new SimpleVo();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				
			}
		}finally{
			closeAll();
		}
		return bean;
	}
	
	public void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
	}
}
