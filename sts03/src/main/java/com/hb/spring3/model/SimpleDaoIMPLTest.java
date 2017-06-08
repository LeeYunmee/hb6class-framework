package com.hb.spring3.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.spring3.model.SimpleDao;
import com.hb.spring3.model.SimpleVo;

public class SimpleDaoIMPLTest {
	private static SimpleDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
/*
 		BasicDataSource ds = null;
			ds = new org.apache.tomcat.dbcp.dbcp.BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUsername("system");
			ds.setPassword("tiger");
		dao = new SimpleDaoIMPL(ds);
		
		*/
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/context-config.xml");
		dao = (SimpleDaoIMPL)ac.getBean("simpleDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws SQLException {
	
		List<SimpleVo> list = dao.SelectAll();
		if(list != null) {
			assertTrue(true);
			assertTrue(list.size()>0);
			return;
		}
		fail("Not yet implemented");
	}
	
	@Test
	public void testSelectOne() throws SQLException {
		
		
		fail("Not yet implemented");
	}


}
