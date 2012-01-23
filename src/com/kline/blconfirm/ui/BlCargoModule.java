package com.kline.blconfirm.ui;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BlCargo;
//import org.nutz.demo.petstore.service.BlCargoService;
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
import com.kline.blconfirm.service.BlCargoService;
import com.kline.blconfirm.service.BlCargoService;
import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.*;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("blCargoModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/blconfirm/blCargoAdmin")
@Fail("json")
public class BlCargoModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BlCargoModule.class);

	private BlCargoService blCargoService;

	@At
	@Ok("jsp:jsp.blconfirm.blCargoEdit")
	public void editBlCargo(HttpServletRequest request, @Param("action") String action,
			@Param("blCargoId") long blCargoId) {

		if ("create".equals(action)) {
			BlCargo blCargo = new BlCargo();
			// blCargo.setBlCargoId(blCargoId);
			//
			// blCargo.setBlCargoName("");
			// blCargo.setOfficeCode("");
			// blCargo.setBlCargoType("A");
			// blCargo.setBLReference("");
			// blCargo.setEmailNotice4BlAccepted("Y");
			// blCargo.setEmailNotice4BlRejected("Y");
			// blCargo.setEmailNotice4CNCPSEnabled("N");
			// blCargo.setEmail("");
			// blCargo.setAddress("");
			// blCargo.setTel("");
			// blCargo.setFax("");
			// blCargo.setContact("");

			request.setAttribute("blCargo", blCargo);

			// String action = "add";
			// request.setAttribute("actn", action);

		} else if ("edit".equals(action)) {
			BlCargo blCargo = blCargoService
					.getById(blCargoId);

			request.setAttribute("blCargo", blCargo);
		}
	}

	@At
	@Ok("json")
	public BlCargo saveBlCargo(HttpServletRequest request,
			@Param("action") String action,
			@Param("blCargoId") long blCargoId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BlCargo blCargo = null;

		blCargo = blCargoService.getById(blCargoId);

		if (null == blCargo) {
			// TODO: error processing
		}
		blCargo.setUpdateInfo(myAccount.getUserId());
//		blCargo.getBlCargo().setUpdateInfo(myAccount.getUserId());

//		setBlCargo(blCargo, request);

//		if (logger.isInfoEnabled()) {
//			logger.info("saveBlCargo(HttpServletRequest, String, long) - BlCargo blCargo=" + Json.toJson(blCargo, JsonFormat.full())); //$NON-NLS-1$
//		}

		blCargoService.update(blCargo);

		return blCargo;
	}

	// @At
	// @Ok("json")
	// public void deleteBlCargo(@Param("blCargoids") String blCargoids[])
	// {
	// if (blCargoids != null) {
	// for (String blCargoid : blCargoids) {
	// blCargoService.deleteBlCargoyBlCargoid(blCargoid);
	// }
	// }
	// }

//	@At
//	@Ok("json")
//	public boolean isExistBlCargo(@Param("blCargoId") long blCargoId) {
//		BlCargo blCargo = blCargoService.getBlCargoyId(blCargoId);
//
//		return null != blCargo;
//	}

	private void setBlCargo(HttpServletRequest req, BlCargo blCargo) {

	}
}
