package com.kline.booking.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.QueryResult;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.booking.entity.BkgMaster;
import com.kline.booking.service.BookingService;

public class BkgMasterServiceTest extends BaseTestCase {

	private BookingService bkgMasterService;
	
	@Before
	public void setUp() throws Exception {
		bkgMasterService = acMgr.getBean(null, "bookingService");
	}

	@Test
	public void testInsertBkgMaster() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBkgMaster() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBkgMasterById() {
//		fail("Not yet implemented");
		long bkgMasterId = 232;
		
		BkgMaster booking = bkgMasterService.getBookingById(bkgMasterId);
		
		String jUserList = Json.toJson(booking, JsonFormat.full());
		
		System.out.println(jUserList);		
		
		bkgMasterService.deleteBookingById(bkgMasterId);
		
	}

	@Test
	public void testGetBkgMasterById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBookingById() {
//		fail("Not yet implemented");
		int bkgMasterId = 1699226;
		
		BkgMaster booking = bkgMasterService.getBookingById(bkgMasterId);
		
		String jUserList = Json.toJson(booking, JsonFormat.full());
		
		System.out.println(jUserList);		

	}

	@Test
	public void testGetAllBkgMasters() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPage() {
//		fail("Not yet implemented");
		
		int pageNumber = 12881;
		int pageSize = 50;
		
		String status ="N";
		QueryResult qr = bkgMasterService.findPage(status, pageNumber, pageSize);
		
		int pageCount = qr.getPager().getPageCount();
		
		int totalCount = qr.getPager().getRecordCount();
		
		List<BkgMaster> list = (List<BkgMaster>) qr.getList();
		
		System.out.println("pageCount=" + pageCount);		
		System.out.println("totalCount=" + totalCount);

		String jUserList = Json.toJson(list, JsonFormat.full());
		
//		System.out.println(jUserList);		

	}

}
