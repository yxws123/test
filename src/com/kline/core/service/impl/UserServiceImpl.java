package com.kline.core.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;

import com.kline.core.entity.User;
import com.kline.core.service.UserService;
import com.kline.util.StringUtils;

public class UserServiceImpl extends BaseNameEntityServiceImpl<User> implements
		UserService {

	// @Override
	// public void insertUser(User user) {
	// // TODO Auto-generated method stub
	// this.dao().insert(user);
	// }
	//
	// @Override
	// public User getUserById(String userCode) {
	// // TODO Auto-generated method stub
	// return this.fetch(userCode);
	// }
	//
	// @Override
	// public List<User> getAllUsers() {
	// // TODO Auto-generated method stub
	// return this.query(null, null);
	// }
	//
	// // @Override
	// // public void updateUser(User User, String olduserCode) {
	// // // TODO Auto-generated method stub
	// //
	// // }
	//
	// @Override
	// public void deleteUserById(String userCode) {
	// // TODO Auto-generated method stub
	// this.delete(userCode);
	// }
	//
	// @Override
	// public void updateUser(User user) {
	// // TODO Auto-generated method stub
	// this.dao().update(user);
	// }

	@Override
	public QueryResult findPage(String userId, String officeCode,
			String userType, String agentCode, String role, String enabled,
			int pageNumber, int pageSize) {

		String sql = "where 1=1";
		if (null != userId && !"".equals(userId)) {
			sql += " and userId like " + StringUtils.toSqlString(userId + "%"); 
		}
		if (null != officeCode && !"".equals(officeCode)) {
			sql += " and officeCode=" + StringUtils.toSqlString(officeCode); 
		}
		if (null != userType && !"".equals(userType)) {
			sql += " and userType=" + StringUtils.toSqlString(userType); 
		}
		if (null != agentCode && !"".equals(agentCode)) {
			sql += " and agentCode=" + StringUtils.toSqlString(agentCode); 
		}
		if (null != role && !"".equals(role)) {
			sql += " and role=" + StringUtils.toSqlString(role); 
		}
		if (null != enabled && !"".equals(enabled)) {
			sql += " and enabled=" + StringUtils.toSqlString(enabled); 
		}
		
		Condition cnd = null;
//		if (null != userId && !"".equals(userId)) {
//			cnd = Cnd.where("UserId", "like", userId + "%");
//		}
		cnd = Cnd.wrap(sql);
		
		Pager pager = this.dao().createPager(pageNumber, pageSize);
		List<User> list = this.query(cnd, pager);
		pager.setRecordCount(this.count(cnd));
		return new QueryResult(list, pager);
	}
}
