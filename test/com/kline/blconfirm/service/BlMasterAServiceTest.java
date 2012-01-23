package com.kline.blconfirm.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.blconfirm.entity.BlMasterA;

public class BlMasterAServiceTest extends BaseTestCase {

	BlMasterAService blMasterAService = null;
	
	@Before
	public void setUp() throws Exception {
		blMasterAService = acMgr.getBean(BlMasterAService.class, "blMasterAService");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
//		fail("Not yet implemented");
		int blMasterId = 2;
		BlMasterA blMasterA = blMasterAService.getById(blMasterId);
		
		System.out.println(Json.toJson(blMasterA, JsonFormat.full()));
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
