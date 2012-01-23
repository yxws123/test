package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgCtrOfBkg;
//import org.nutz.demo.petstore.service.BkgCtrOfBkgService;
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
import com.kline.booking.entity.BkgCtrOfBkg;
import com.kline.booking.service.BkgCtrOfBkgService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgCtrOfBkgModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgCtrOfBkgAdmin")
@Fail("json")
public class BkgCtrOfBkgModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BkgCtrOfBkgModule.class);

	private BkgCtrOfBkgService bkgCtrOfBkgService;

	@At
	@Ok("jsp:jsp.booking.bkgCtrOfBkgList")
	public void findMyBkgCtrOfBkg(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgCtrOfBkgService.findMyBkgCtrOfBkg(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgCtrOfBkgEdit")
	public void editBkgCtrOfBkg(@Param("action") String action,
			@Param("bkgCtrOfBkgId") long bkgCtrOfBkgId,
			HttpServletRequest request) {

		BkgCtrOfBkg bkgCtrOfBkg = bkgCtrOfBkgService.getById(bkgCtrOfBkgId);

		request.setAttribute("bkgCtrOfBkg", bkgCtrOfBkg);
	}

	@At
	@Ok("json")
	public BkgCtrOfBkg saveBkgCtrOfBkg(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgCtrOfBkgId") long bkgCtrOfBkgId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgCtrOfBkg bkgCtrOfBkg = null;

		bkgCtrOfBkg = bkgCtrOfBkgService.getById(bkgCtrOfBkgId);

		if (null == bkgCtrOfBkg) {
			// TODO: error processing
		}
		bkgCtrOfBkg.setUpdateInfo(myAccount.getUserId());
		bkgCtrOfBkg.setUpdateInfo(myAccount.getUserId());

		setBkgCtrOfBkg(bkgCtrOfBkg, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgCtrOfBkg(HttpServletRequest, String, long) - BkgCtrOfBkg bkgCtrOfBkg=" + Json.toJson(bkgCtrOfBkg, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgCtrOfBkgService.update(bkgCtrOfBkg);

		return bkgCtrOfBkg;
	}

	@At
	@Ok("json")
	public void deleteBkgCtrOfBkg(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgCtrOfBkgId") long bkgCtrOfBkgId) {

		bkgCtrOfBkgService.deleteById(bkgCtrOfBkgId);

	}

	private void setBkgCtrOfBkg(BkgCtrOfBkg bkgCtrOfBkg, HttpServletRequest req) {

		bkgCtrOfBkg.setNoOfCtr(ParamUtil.getInt(req, "noOfCtr", 0));
		bkgCtrOfBkg.setSoc(ParamUtil.getString(req, "soc", ""));

		bkgCtrOfBkg.setContainerType(ParamUtil.getString(req, "containerType",
				""));
		bkgCtrOfBkg.setContainerSize(ParamUtil.getString(req, "containerSize",
				""));
		bkgCtrOfBkg.setContainerHeight(ParamUtil.getString(req,
				"containerHeight", ""));

		bkgCtrOfBkg
				.setReeferAsDry(ParamUtil.getString(req, "reeferAsDry", "N"));

	}
}
