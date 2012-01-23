package com.kline.blconfirm.ui;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BlMarkNo;
//import org.nutz.demo.petstore.service.BlMarkNoService;
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
import com.kline.blconfirm.service.BlMarkNoService;
import com.kline.blconfirm.service.BlMarkNoService;
import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.blconfirm.*;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("blMarkNoModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/blconfirm/blMarkNoAdmin")
@Fail("json")
public class BlMarkNoModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BlMarkNoModule.class);

	private BlMarkNoService blMarkNoService;

	@At
	@Ok("jsp:jsp.blconfirm.blMarkNoEdit")
	public void editBlMarkNo(HttpServletRequest request,
			@Param("action") String action, @Param("blMarkNoId") long blMarkNoId) {

		if ("create".equals(action)) {
			BlMarkNo blMarkNo = new BlMarkNo();
			// blMarkNo.setBlMarkNoId(blMarkNoId);
			//
			// blMarkNo.setBlMarkNoName("");
			// blMarkNo.setOfficeCode("");
			// blMarkNo.setBlMarkNoType("A");
			// blMarkNo.setBLReference("");
			// blMarkNo.setEmailNotice4BlAccepted("Y");
			// blMarkNo.setEmailNotice4BlRejected("Y");
			// blMarkNo.setEmailNotice4CNCPSEnabled("N");
			// blMarkNo.setEmail("");
			// blMarkNo.setAddress("");
			// blMarkNo.setTel("");
			// blMarkNo.setFax("");
			// blMarkNo.setContact("");

			request.setAttribute("blMarkNo", blMarkNo);

			// String action = "add";
			// request.setAttribute("actn", action);

		} else if ("edit".equals(action)) {
			BlMarkNo blMarkNo = blMarkNoService.getById(blMarkNoId);

			request.setAttribute("blMarkNo", blMarkNo);
		}
	}

	@At
	@Ok("json")
	public BlMarkNo saveBlMarkNo(HttpServletRequest request,
			@Param("action") String action, @Param("blMarkNoId") long blMarkNoId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BlMarkNo blMarkNo = null;

		blMarkNo = blMarkNoService.getById(blMarkNoId);

		if (null == blMarkNo) {
			// TODO: error processing
		}
		blMarkNo.setUpdateInfo(myAccount.getUserId());
		// blMarkNo.getBlMarkNo().setUpdateInfo(myAccount.getUserId());

		// setBlMarkNo(blMarkNo, request);

		// if (logger.isInfoEnabled()) {
		//			logger.info("saveBlMarkNo(HttpServletRequest, String, long) - BlMarkNo blMarkNo=" + Json.toJson(blMarkNo, JsonFormat.full())); //$NON-NLS-1$
		// }

		blMarkNoService.update(blMarkNo);

		return blMarkNo;
	}

	// @At
	// @Ok("json")
	// public void deleteBlMarkNo(@Param("blMarkNoids") String blMarkNoids[])
	// {
	// if (blMarkNoids != null) {
	// for (String blMarkNoid : blMarkNoids) {
	// blMarkNoService.deleteBlMarkNoyBlMarkNoid(blMarkNoid);
	// }
	// }
	// }

	// @At
	// @Ok("json")
	// public boolean isExistBlMarkNo(@Param("blMarkNoId") long blMarkNoId) {
	// BlMarkNo blMarkNo = blMarkNoService.getBlMarkNoyId(blMarkNoId);
	//
	// return null != blMarkNo;
	// }

	private void setBlMarkNo(HttpServletRequest req, BlMarkNo blMarkNo) {

	}
}
