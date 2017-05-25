package com.hb.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class SimpleDAOTest {
	static Logger log=Logger.getLogger(SimpleDAOTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testSimpleDAO() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new SimpleDAO());

	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		SimpleDAO dao = new SimpleDAO();
		List<Map<String, Object>> list = dao.selectAll();
		
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(1, list.size());
		
		for (Map<String, Object> map : list){
			log.debug(map.get("sabun"));
		}
		
	}

}
