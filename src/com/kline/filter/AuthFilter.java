package com.kline.filter;

import org.apache.log4j.Logger;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;

import com.kline.core.entity.User;
import com.kline.util.AuthUtil;

public class AuthFilter implements ActionFilter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AuthFilter.class);

	private String roleId;
	private String objectName;
	private String status;
	private String action;
	private String path;

	public AuthFilter(String roleId,
	// String objectName,
	// String status,
	// String action
			String path) {
		this.roleId = roleId;
		this.path = path;
	}

	@Override
	public View match(ActionContext ac) {
		if (logger.isDebugEnabled()) {
			logger.debug("match(ActionContext) - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated method stub

		User myAccount = AuthUtil.getMyAccount(ac.getRequest());
		if (null == myAccount || !roleId.equals(myAccount.getUserId())) {
			View returnView = new ServerRedirectView(path);
//			if (logger.isDebugEnabled()) {
//				logger.debug("match(ActionContext) - end"); //$NON-NLS-1$
//			}
			return returnView;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("match(ActionContext) - end"); //$NON-NLS-1$
		}
		return null;
	}

}
