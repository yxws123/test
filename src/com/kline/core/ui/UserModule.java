package com.kline.core.ui;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.User;
//import org.nutz.demo.petstore.service.UserService;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.kline.Constants;
import com.kline.core.entity.User;
import com.kline.core.service.UserService;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;

@InjectName("userModule")
@At("/core/userAdmin")
@Fail("json")
public class UserModule {
	private UserService userService;

	@At
	@Ok("jsp:jsp.core.user.userAdmin")
	public void entryPoint() {
	}

	@At
	@Ok("jsp:jsp.core.user.userList")
	// @Ok("jsp:jsp.User.showallUsers")
	public void findPage(HttpServletRequest request,
			@Param("userId") String userId,
			@Param("officeCode") String officeCode,
			@Param("userType") String userType,
			@Param("agentCode") String agentCode, @Param("role") String role,
			@Param("enabled") String enabled, @Param("orderBy") String orderBy,
			@Param("pageNo") int pageNo, @Param("pageSize") int pageSize) {

		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageSize <= 0) {
			pageSize = 50;
		}

		if ("UserID".equals(userId)) {
			userId = null;
		}

		request.setAttribute("queryResult", userService.findPage(userId,
				officeCode, userType, agentCode, role, enabled, pageNo,
				pageSize));

		String url = ParamUtil.getRequestURLWithoutPageNo(request);

		request.setAttribute("url", url);
	}

	@At
	@Ok("jsp:jsp.core.user.userEdit")
	// @Ok("jsp:jsp.core.user.showallUsers")
	public void editUser(@Param("action") String action,
			@Param("userId") String userId, HttpServletRequest request) {

		if ("create".equals(action)) {
			User user = new User();
			user.setUserId(userId);

			request.setAttribute("user", user);

			// String action = "add";
			// request.setAttribute("actn", action);
			user.setOfficeCode("CNSHA");
			user.setUserType("I");
			user.setAgentCode("");
			user.setRole("");
			user.setEmail("");
			user.setEnabled("Y");

		} else if ("edit".equals(action)) {
			User user = userService.getById(userId);

			request.setAttribute("user", user);
		}
	}

	@At
	@Ok("json")
	public User saveUser(@Param("action") String action,
			@Param("userId") String userId,
			@Param("officeCode") String officeCode,
			@Param("userType") String userType,
			@Param("agentCode") String agentCode, @Param("role") String role,
			@Param("enabled") String enabled, @Param("email") String email) {

		User user = null;
		if ("create".equals(action)) {
			user = new User();

			user.setNewInfo("admin");
		} else {
			user = userService.getById(userId);

			user.setUpdateInfo("admin");
		}

		user.setUserId(userId);
		user.setOfficeCode(officeCode);
		user.setUserType(userType);

		if (user.isInternalUser()) {
			user.setAgentCode(null);
		} else {
			user.setAgentCode(agentCode);
		}

		if (null == enabled) {
			user.setDisabled();
		} else {
			// user.setEnabled(Constants.YES);
			user.setEnabled();
		}
		user.setRole(role);

		user.setEmail(email);

		if ("create".equals(action)) {
			userService.insert(user);
		} else {
			userService.update(user);
		}

		return user;
	}

	// @At
	// @Ok("json")
	// public void deleteUser(@Param("userids") String userids[]) {
	// if (userids != null) {
	// for (String userid : userids) {
	// userService.deleteUserByUserid(userid);
	// }
	// }
	// }
	//
	@At
	@Ok("json")
	// @Fail("json")
	public User showUser(@Param("userid") String userid) throws Exception {
		return userService.getById(userid);
		// return null;
		// throw new Exception("User [" + userid + "] not found");
	}

	//
	// @At
	// @Ok("json")
	// public void updateUser(@Param("User") User User,
	// @Param("olduserid") String olduserid) {
	// userService.updateUser(User, olduserid);
	// }

	@At
	@Filters
	@Ok("jsp:/main05")
	@Fail("jsp:/login")
	// @Ok("jsp:jsp.core.user.showallUsers")
	public void login(@Param("userId") String userId,
			@Param("password") String password, HttpServletRequest request)
			throws Exception {

		if (AuthUtil.isLogon(request)) {
			return;
		}

		User myAccount = userService.getById(userId);

		if (null == myAccount) {
			String errMsg = "user.login.fail";
			request.setAttribute("errMsg", errMsg);
			throw new Exception("error UserID or Password");
		}

		AuthUtil.logon(request, myAccount);

		myAccount.setLastVisitIp(request.getRemoteAddr());
		myAccount.setLastVisitTime(new Date());
		userService.update(myAccount);

		// request.getSession().setAttribute(User.class.getName(), myAccount);
	}

	@At
	@Ok("jsp:/login")
	// @Ok("jsp:jsp.User.showallUsers")
	public void logout(HttpServletRequest request) throws Exception {

		AuthUtil.logout(request);
	}

}
