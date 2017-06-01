package com.hb.struts2.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SimpleDAO {
	private static SqlMapClient smc;
	
	public SimpleDAO() {
		
		String path = "./SqlMapConfig.xml";
		try {
			Reader rd = Resources.getResourceAsReader(path);
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SimpleVO> selectAll() throws SQLException {
		
		List<SimpleVO> list = smc.queryForList("selectAll");
		
		
		/*			
		List<SimpleVO> list = new ArrayList<>();
	    list.add(new SimpleVO(1111,"test1",new Date(System.currentTimeMillis()),4321));
		list.add(new SimpleVO(2222,"test2",new Date(System.currentTimeMillis()),4321));
		list.add(new SimpleVO(3333,"test3",new Date(System.currentTimeMillis()),4321));
		*/
		return list;
	}

	public SimpleVO selectOne(int sabun) throws SQLException {
		
		return (SimpleVO) smc.queryForObject("selectOne", sabun);
	}

	public int updateOne(SimpleVO bean) throws SQLException {
		System.out.println(bean);
		return smc.update("updateOne", bean);
	}

	public void insertOne(SimpleVO bean) throws SQLException {
		smc.insert("insertOne", bean);
		
	}

	public int deleteOne(int sabun) throws SQLException {
		return smc.delete("deleteOne", sabun);
	}

	
	
}
