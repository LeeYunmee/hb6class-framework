package com.hb.sts01.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<SimpleVo> selectAll() throws SQLException{
		String sql = "select * from simple03 order by sabun";
		List<SimpleVo> list = new ArrayList<>();
		
		try{
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			list.add(new SimpleVo(rs.getInt("sabun")
					, rs.getString("name")
					, rs.getDate("nalja")
					, rs.getInt("pay")));
			}
		}finally {
			closeAll();
		}
		
		/*
		list.add(new SimpleVo(1111, "test1", new Date(System.currentTimeMillis()), 1000));
		list.add(new SimpleVo(2222, "test2", new Date(System.currentTimeMillis()), 2000));
		list.add(new SimpleVo(3333, "test3", new Date(System.currentTimeMillis()), 3000));*/
		
		return list;
		
	}

	public void closeAll() throws SQLException {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
		
	}

	public int insertOne(SimpleVo bean) throws SQLException {
		String sql ="insert into simple03 values (?,?,sysdate,?)";
		System.out.println("start" + bean.getSabun());
		try{
			pstmt = conn.prepareStatement(sql);
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
		SimpleVo bean = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new SimpleVo(rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"),
						rs.getInt("pay"));
				
			}
		}finally{
			closeAll();
		}
		
		return bean;
	}

	public int updateOne(SimpleVo bean) throws SQLException {
		String sql = "update simple03 set name=?, pay=? where sabun=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}

	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from simple03 where sabun=?";
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			result=pstmt.executeUpdate();
			
		}finally{
			closeAll();
		}
		return result;
		
	}

}
