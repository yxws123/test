package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgMarkNo;
//import org.nutz.demo.petstore.service.BkgMarkNoService;
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
import com.kline.booking.entity.BkgMarkNo;
import com.kline.booking.service.BkgMarkNoService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgMarkNoModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgMarkNoAdmin")
@Fail("json")
public class BkgMarkNoModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BkgMarkNoModule.class);

	private BkgMarkNoService bkgMarkNoService;

	@At
	@Ok("jsp:jsp.booking.bkgMarkNoList")
	public void findMyBkgMarkNo(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgMarkNoService.findMyBkgMarkNo(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgMarkNoEdit")
	public void editBkgMarkNo(@Param("action") String action,
			@Param("bkgMarkNoId") long bkgMarkNoId, HttpServletRequest request) {

		BkgMarkNo bkgMarkNo = bkgMarkNoService.getById(bkgMarkNoId);

		request.setAttribute("bkgMarkNo", bkgMarkNo);
	}

	@At
	@Ok("json")
	public BkgMarkNo saveBkgMarkNo(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgMarkNoId") long bkgMarkNoId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgMarkNo bkgMarkNo = null;

		bkgMarkNo = bkgMarkNoService.getById(bkgMarkNoId);

		if (null == bkgMarkNo) {
			// TODO: error processing
		}
		bkgMarkNo.setUpdateInfo(myAccount.getUserId());

		setBkgMarkNo(bkgMarkNo, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgMarkNo(HttpServletRequest, String, long) - BkgMarkNo bkgMarkNo=" + Json.toJson(bkgMarkNo, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgMarkNoService.update(bkgMarkNo);

		return bkgMarkNo;
	}

	@At
	@Ok("json")
	public void deleteBkgMarkNo(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgMarkNoId") long bkgMarkNoId) {

		bkgMarkNoService.deleteById(bkgMarkNoId);

	}

	private void setBkgMarkNo(BkgMarkNo bkgMarkNo, HttpServletRequest req) {
		bkgMarkNo.setMarkNo(req.getParameter("markNo"));
	}
}
