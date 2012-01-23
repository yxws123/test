package com.kline.core.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.QueryResult;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.Constants;
import com.kline.core.entity.User;
import com.kline.core.helper.UserHelper;
import com.kline.core.service.UserService;

public class UserServiceTest extends BaseTestCase {

	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		userService = acMgr.getBean(null, "userService");
	}

	@Test
	public void testInsertUser() {
//		fail("Not yet implemented");
		
		User user = new User();
		user.setUserId("user2");
		user.setAgentCode(null);
		user.setUserType(UserHelper.USERTYPE_INTERNAL);
		user.setEnabled(Constants.YES);
		user.setRole(UserHelper.USER_ROLE_ADMIN);
		
//		user.setValid();
//		user.setCreator("admin");
//		user.setModifier("admin");
//		user.setDateCreated(new Date());
//		user.setLastModified(new Date());
		user.setNewInfo("admin");
		
		try {
			userService.insert(user);
		} catch (Exception e) {
			fail(e.toString());
		}				
	}

	@Test
	public void testGetUserById() {
//		fail("Not yet implemented");
		String userCode = "admin";
		User user = null;
		try {
			user = userService.getById(userCode);
		} catch (Exception e) {
			fail(e.toString());
		}
		assertNotNull(user);
		
		String jUser1 = Json.toJson(user);
		String jUser2 = Json.toJson(user, JsonFormat.full());
		
		System.out.println(jUser1);
		System.out.println(jUser2);
	}

	@Test
	public void testGetAllUsers() {
//		fail("Not yet implemented");
		QueryResult qr = userService.findPage(null, null, null, null, null, null, 1, 50);
		List<User> list = (List<User>) qr.getList();
		
		assertNotNull(list);
		
		String jUserList = Json.toJson(list, JsonFormat.full());
		
		System.out.println(jUserList);
	}

//	@Test
//	public void testUpdateUserUserString() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testDeleteUserById() {
//		fail("Not yet implemented");

		String userCode = "use'r1";
//		User user = null;
		try {
			userService.deleteById(userCode);
		} catch (Exception e) {
			fail(e.toString());
		}
//		assertNotNull(user);
	}

	@Test
	public void testUpdateUserUser() {
//		fail("Not yet implemented");
		
		String userCode = "user1";
		User user = null;
		try {
			user = userService.getById(userCode);
			user.setUpdateInfo("admin");
			
			userService.update(user);
		} catch (Exception e) {
			fail(e.toString());
		}
		assertNotNull(user);

	}

}
