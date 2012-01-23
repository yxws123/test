package com.kline.util;

import javax.servlet.http.*;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import com.kline.core.entity.*;
//import com.kline.core.business.*;
//import com.kline.*;
//import com.kline.exception.*;
import com.kline.core.entity.User;
import com.kline.core.entity.*;

/**
 * CheckLogon
 * 
 * @author		Wu Shuo
 * @version	1.0
 * @since		2004/07/06
 *
 */
public class AuthUtil {

//	private static Log log = LogFactory.getLog(AuthUtil.class);
//
//	private final static ApplicationContextManager appContextMgr =
//		ApplicationContextManager.getInstance();
//
//	private final static UserPermissionBean upBean =
//		(UserPermissionBean) appContextMgr.getBean("userPermissionBean");

	/**
	 * 检查用户是否登录及是否有效
	 * 若未登录，则抛出异常，消息关键字为：error.logon.required
	 * 若非有效用户，则抛出异常，消息关键字为：error.invalid.user
	 * @param HttpServletRequest
	 * @return User
	 * @throws Exception
	 */
	public final static boolean isLogon(HttpServletRequest req){

		User user = getMyAccount(req);
		
		return (null != user);
//		if (user == null) {
//			throw new BaseException("error.logon.required");
//		}
//		if (!"Y".equals(user.getEnabled())) {
//			throw new BaseException("error.logon.userIsInvalid");
//		}
//		return user;

	}


    public final static void logon(HttpServletRequest request, User myAccount) {
		request.getSession(false).setAttribute(User.class.getName(), myAccount);
    }
    
	public final static void logout(HttpServletRequest request) {
		request.getSession().removeAttribute(User.class.getName());
	}
    
	public final static User getMyAccount(HttpServletRequest request) {
		return (User) request.getSession(false).getAttribute(User.class.getName());
	}

//	public final static boolean checkPermission(
//		User myAccount,
//		String permission)
//		throws BaseException {
//			
//			if (myAccount.isAdmin()) {
//				return true;
//			}
//
//		//return true;
//
//		//		DAOFactory dao = DAOFactory.getInstance();
//		//		UserPermissionDAO theUserPermissionDAO = null;
//		UserPermission theUserPermission = null;
//
//		try {
//			//			theUserPermissionDAO = dao.getUserPermissionDAO();
//			theUserPermission =
//				upBean.getById(myAccount.getUserId(), permission);
//		} catch (BaseException e) {
//			log.debug(e);
//			throw e;
//		}
//
//		if (theUserPermission != null) {
//			return "Y".equals(theUserPermission.getValid());
//		}
//
//		try {
//			theUserPermission =
//				upBean.getVirtualUserPermissionById(
//					myAccount.getUserId(),
//					permission);
//		} catch (BaseException e) {
//			throw e;
//		}
//
//		return (theUserPermission != null);
//	}

}
