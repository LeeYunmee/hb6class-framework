package com.hb.day003.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day003.support.RowMapper;
import com.hb.day003.support.TemplateJDBC;

public class SimpleDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDAO() {
	
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
	

	public List<SimpleVO> selectAll() throws SQLException {
		String sql = "SELECT * FROM SIMPLE02";
		
		TemplateJDBC jdbc = new TemplateJDBC();
		return (List<SimpleVO>) jdbc.executeQuery(sql, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				List<SimpleVO> list = new ArrayList();
				while(rs.next()){
					SimpleVO bean = new SimpleVO();
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
					list.add(bean);
				}
				return list;
			}
			
		});
		
	}
	
	public SimpleVO selectOne(int sabun) throws SQLException {
		String sql = "select * from simple02 where sabun=?";
		
		TemplateJDBC jdbc = new TemplateJDBC();
		return (SimpleVO) jdbc.executeQuery(sql, new Object[]{sabun},new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				SimpleVO bean = new SimpleVO();
				
				if(rs.next()){
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
				}
				
				return bean;
			}
			
		});
		
	}



	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql = "insert into simple02 ( name, nalja,pay)";
		sql+="values (?,?,?)";
		
//		pstmt=conn.prepareStatement(sql);
//		pstmt.setString(1, name);
//		pstmt.setString(2, nalja);
//		pstmt.setInt(3, pay);
//		int result = pstmt.executeUpdate();
//		close();
//		
//		return result;
		Object[] objs = new Object[]{name,nalja,pay};
		TemplateJDBC jdbc = new TemplateJDBC();
		return jdbc.executeUpdate(sql,objs);
		
	}
	
	
	
	
	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		
		String sql = "update simple02 set name=?, nalja=?, pay=? where sabun=?";
//		int result =0;
//		pstmt=conn.prepareStatement(sql);
//		pstmt.setString(1, name);
//		pstmt.setString(2, nalja);
//		pstmt.setInt(3, pay);
//		pstmt.setInt(4, sabun);
//		result = pstmt.executeUpdate();
//		
//		close();
//		return result;
		Object[] objs = new Object[]{name,nalja,pay,sabun};
		TemplateJDBC jdbc = new TemplateJDBC();
		return jdbc.executeUpdate(sql,objs);
	}
	
	
	
}
