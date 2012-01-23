package com.kline.blconfirm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.blconfirm.entity.BlMarkNo;

public class BlMarkNoServiceTest extends BaseTestCase{

	BlMarkNoService blMarkNoService = null;
	
	@Before
	public void setUp() throws Exception {
		blMarkNoService = acMgr.getBean(BlMarkNoService.class, "blMarkNoService");
	}

	@Test
	public void testFindByMasterId() {
//		fail("Not yet implemented");
		long blMasterId = 2;
		List<BlMarkNo> list = blMarkNoService.findByMasterId(blMasterId);
		
		System.out.println(Json.toJson(list, JsonFormat.full()));	
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
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
