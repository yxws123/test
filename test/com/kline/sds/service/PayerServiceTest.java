/**
 * 
 */
package com.kline.sds.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.sds.entity.Payer;


/**
 * @author Wu Shuo
 *
 */
public class PayerServiceTest  extends BaseTestCase {

	private PayerService payerService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		payerService = acMgr.getBean(null, "payerService");
	}

	/**
	 * Test method for {@link com.kline.sds.service.PayerService#getAllPayers()}.
	 */
	@Test
	public void testGetAllPayers() {
//		fail("Not yet implemented");
		
		List<Payer> list = payerService.getAllPayers();
		
		assertNotNull(list);

		String jPayerList = Json.toJson(list, JsonFormat.full());
		
		System.out.println(jPayerList);
	}

}
