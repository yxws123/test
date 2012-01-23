package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgStatus;
//import org.nutz.demo.petstore.service.BkgStatusService;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.kline.Constants;
import com.kline.booking.entity.BkgStatus;
import com.kline.booking.service.BkgStatusService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgStatusModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgStatusAdmin")
@Fail("json")
public class BkgStatusModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BkgStatusModule.class);

	private BkgStatusService bkgStatusService;

	@At
	@Ok("jsp:jsp.booking.bkgStatusList")
	public void findMyBkgStatus(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgStatusService.findMyBkgStatus(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgStatusEdit")
	public void editBkgStatus(@Param("action") String action,
			@Param("bkgStatusId") long bkgStatusId, HttpServletRequest request) {

		BkgStatus bkgStatus = bkgStatusService.getById(bkgStatusId);

		request.setAttribute("bkgStatus", bkgStatus);
	}

	@At
	@Ok("json")
	public BkgStatus saveBkgStatus(HttpServletRequest request,
			@Param("action") String action, @Param("bkgStatusId") long bkgStatusId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgStatus bkgStatus = null;

		bkgStatus = bkgStatusService.getById(bkgStatusId);

		if (null == bkgStatus) {
			// TODO: error processing
		}
		bkgStatus.setUpdateInfo(myAccount.getUserId());
		bkgStatus.setUpdateInfo(myAccount.getUserId());

		setBkgStatus(bkgStatus, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgStatus(HttpServletRequest, String, long) - BkgStatus bkgStatus=" + Json.toJson(bkgStatus, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgStatusService.update(bkgStatus);

		return bkgStatus;
	}

	@At
	@Ok("json")
	public void deleteBkgStatus(HttpServletRequest request,
			@Param("action") String action, @Param("bkgStatusId") long bkgStatusId) {

		bkgStatusService.deleteById(bkgStatusId);

	}

	private void setBkgStatus(BkgStatus bkgStatus, HttpServletRequest req) {

	}
}
