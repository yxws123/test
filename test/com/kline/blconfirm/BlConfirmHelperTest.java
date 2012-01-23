package com.kline.blconfirm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlConfirmHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBlConfirmStatusName() {
		// fail("Not yet implemented");
		for (int status = -10; status < BlConfirmHelper.blConfirmStatus.length + 10; status++) {
			System.out.println(status + " : ["
					+ BlConfirmHelper.getBlConfirmStatusName(status) + "]");
		}
	}

}
