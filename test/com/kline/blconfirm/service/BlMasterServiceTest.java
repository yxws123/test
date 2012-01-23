package com.kline.blconfirm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.QueryResult;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.blconfirm.entity.BlMaster;
import com.kline.booking.entity.BkgMaster;

public class BlMasterServiceTest extends BaseTestCase {

	BlMasterService blMasterService = null;
	
	@Before
	public void setUp() throws Exception {
		blMasterService = acMgr.getBean(BlMasterService.class, "blMasterService");
	}

	@Test
	public void testFindPage() {
//		fail("Not yet implemented");
		int pageNumber = 11;
		int pageSize = 50;
		
		int status = 1;
		
		QueryResult qr = blMasterService.findPage(status, pageNumber, pageSize);
		
		int pageCount = qr.getPager().getPageCount();
		
		int totalCount = qr.getPager().getRecordCount();
		
		List<BkgMaster> list = (List<BkgMaster>) qr.getList();
		
		System.out.println("totalCount=" + totalCount);
		System.out.println("pageCount=" + pageCount);		
		System.out.println("pageNumber=" + qr.getPager().getPageNumber());		
		System.out.println("pageSize=" + qr.getPager().getPageSize());		

		String jUserList = Json.toJson(list, JsonFormat.full());
		System.out.println(jUserList);		

	}

	@Test
	public void testGetBLById() {
//		fail("Not yet implemented");
		int blMasterId = 4000;
		BlMaster blMaster = blMasterService.getBLById(blMasterId);
		
		System.out.println(Json.toJson(blMaster, JsonFormat.full()));
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
