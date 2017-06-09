package com.hb.stsday02.userModel;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestUserDaoIMPLTest {
	private static GuestUserDaoIMPL dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String path = "/config-context.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		dao = (GuestUserDaoIMPL) ac.getBean("guestUser");
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
	public void testSelectAll() throws SQLException{
		List<GuestUserVo> list = dao.selectAll();
		assertNotNull("list==null", list);
		assertSame(0, list.size());
	}

}
