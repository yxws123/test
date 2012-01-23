package com.kline.booking.helper;

import org.apache.log4j.Logger;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;

import com.kline.booking.entity.BkgMaster;
import com.kline.booking.service.BookingService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;

public class BookingFilter implements ActionFilter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BookingFilter.class);

	private BookingService bookingService;

	private String roleId;
	private String objectName;
	private String status;
	private int action;
	private String path;

	public BookingFilter(
//			String roleId,
	// String objectName,
	// String status,
			String sAction, String path) {
		//		this.roleId = roleId;
		this.path = path;
		this.action = BookingHelper.toAction(sAction);
	}

	@Override
	public View match(ActionContext ac) {
//		if (logger.isDebugEnabled()) {
//			logger.debug("match(ActionContext) - start: action[" + action + "] path[" + path + "]"); //$NON-NLS-1$
//		}

		// TODO Auto-generated method stub

		User myAccount = AuthUtil.getMyAccount(ac.getRequest());

		// TODO: check if logon

		// if (null == myAccount || !roleId.equals(myAccount.getUserId())) {
		// View returnView = new ServerRedirectView(path);
		// // if (logger.isDebugEnabled()) {
		////				logger.debug("match(ActionContext) - end"); //$NON-NLS-1$
		// // }
		// return returnView;
		// }

		bookingService = ac.getIoc()
				.get(BookingService.class, "bookingService");

		long bkgMasterId = ParamUtil.getInt(ac.getRequest(), "bkgMasterId", 0);
		if (logger.isInfoEnabled()) {
			logger.info("match(ActionContext) - long bkgMasterId=" + bkgMasterId); //$NON-NLS-1$
		}
		
		
		BkgMaster bkgMaster = null;
		if (bkgMasterId != 0) {
			bkgMaster = bookingService.getBkgMasterById(bkgMasterId);
		}

		if (!BookingHelper.canDoAction(myAccount, action, bkgMaster)) {
			View returnView = new ServerRedirectView(path);
			return returnView;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("match(ActionContext) - end"); //$NON-NLS-1$
		}
		return null;
	}

}
