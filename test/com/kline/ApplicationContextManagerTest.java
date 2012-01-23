package com.kline;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kline.core.service.UserService;

public class ApplicationContextManagerTest {

	private ApplicationContextManager acMgr = ApplicationContextManager.getInstance();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetBean() {
//		fail("Not yet implemented");
		
		UserService userService = acMgr.getBean(null, "userService");
		
		assertNotNull(userService);
	}

}
