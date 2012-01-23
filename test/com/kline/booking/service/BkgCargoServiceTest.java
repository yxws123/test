package com.kline.booking.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.booking.entity.BkgCargo;

public class BkgCargoServiceTest  extends BaseTestCase {

	private BkgCargoService bkgCargoService;
	
	@Before
	public void setUp() throws Exception {
		bkgCargoService = acMgr.getBean(null, "bkgCargoService");
	}

	@Test
	public void testFindMyBkgCargo() {
//		fail("Not yet implemented");
		long bkgMasterId = 232;
		List<BkgCargo> list = bkgCargoService.findMyBkgCargo(bkgMasterId);
		
		System.out.println(Json.toJson(list, JsonFormat.full()));	
	}

	@Test
	public void testInsert() {
//		fail("Not yet implemented");
		long bkgCargoId = 7;
		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);
		
		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
		
		bkgCargoService.insert(bkgCargo);

		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
	}

	@Test
	public void testUpdate() {
//		fail("Not yet implemented");
	
		long bkgCargoId = 214;
		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);
		
		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
		
		bkgCargoService.update(bkgCargo);

		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));
	}

	@Test
	public void testGetByIdLong() {
		//fail("Not yet implemented");
		long bkgCargoId = 214;
		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);
		
		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
	}

//	@Test
//	public void testDelete() {
////		fail("Not yet implemented");
//		
//		long bkgCargoId = 214;
//		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);
//		
//		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
//		
//		bkgCargoService.delete(bkgCargo);
//		
//		bkgCargo = bkgCargoService.getById(bkgCargoId);
//		
//		assertTrue(null != bkgCargo);
//		
//		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
//	}

	@Test
	public void testDeleteByIdLong() {
//		fail("Not yet implemented");
		
		long bkgCargoId = -7;
		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);
		
		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
		
		bkgCargoService.deleteById(bkgCargoId);
		
		bkgCargo = bkgCargoService.getById(bkgCargoId);
		
		assertTrue(null != bkgCargo);
		
		System.out.println(Json.toJson(bkgCargo, JsonFormat.full()));	
	}

}
