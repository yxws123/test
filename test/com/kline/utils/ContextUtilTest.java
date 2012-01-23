package com.kline.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.Dao;

import com.kline.util.ContextUtil;

public class ContextUtilTest {

	@Before
	public void setUp() throws Exception {
		ContextUtil.initSpringContext(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBean() {
//		fail("Not yet implemented");
		Dao dao = ContextUtil.getBean(null, "dao");
		
		assertNotNull(dao);
		
	}

	@Test
	public void testInitSpringContext() {
//		fail("Not yet implemented");
		ContextUtil.initSpringContext(null);
	}

}
