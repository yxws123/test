package com.kline;

import org.junit.Before;

public abstract class BaseTestCase {

	protected ApplicationContextManager acMgr = ApplicationContextManager.getInstance();
	
	@Before
	public void setUp() throws Exception {
	}

}
