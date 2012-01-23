package com.kline.core.service;

import java.util.List;

import org.nutz.dao.QueryResult;

import com.kline.core.entity.User;

public interface UserService extends BaseNameEntityService {

//	public void insertUser(User user);
//
//	public void updateUser(User user);
//
//	public void deleteUserById(String userCode);
//
//	public User getUserById(String userCode);

//	public List<User> getAllUsers();

	public QueryResult findPage(String userId,
			String officeCode,
			String userType,
			String agentCode,
			String role,
			String enabled,
			int pageNumber, 
			int pageSize);
}
