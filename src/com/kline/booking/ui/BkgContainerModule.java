package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgContainer;
//import org.nutz.demo.petstore.service.BkgContainerService;
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
import com.kline.booking.entity.BkgContainer;
import com.kline.booking.service.BkgContainerService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgContainerModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgContainerAdmin")
@Fail("json")
public class BkgContainerModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BkgContainerModule.class);

	private BkgContainerService bkgContainerService;

	@At
	@Ok("jsp:jsp.booking.bkgContainerList")
	public void findMyBkgContainer(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgContainerService.findMyBkgContainer(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgContainerEdit")
	public void editBkgContainer(@Param("action") String action,
			@Param("bkgContainerId") long bkgContainerId,
			HttpServletRequest request) {

		BkgContainer bkgContainer = bkgContainerService.getById(bkgContainerId);

		request.setAttribute("bkgContainer", bkgContainer);
	}

	@At
	@Ok("json")
	public BkgContainer saveBkgContainer(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgContainerId") long bkgContainerId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgContainer bkgContainer = null;

		bkgContainer = bkgContainerService.getById(bkgContainerId);

		if (null == bkgContainer) {
			// TODO: error processing
		}
		bkgContainer.setUpdateInfo(myAccount.getUserId());
		bkgContainer.setUpdateInfo(myAccount.getUserId());

		setBkgContainer(bkgContainer, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgContainer(HttpServletRequest, String, long) - BkgContainer bkgContainer=" + Json.toJson(bkgContainer, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgContainerService.update(bkgContainer);

		return bkgContainer;
	}

	@At
	@Ok("json")
	public void deleteBkgContainer(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgContainerId") long bkgContainerId) {

		bkgContainerService.deleteById(bkgContainerId);

	}

	private void setBkgContainer(BkgContainer bkgContainer,
			HttpServletRequest req) {

		bkgContainer.setContainerNo(req.getParameter("ContainerNo"));
		bkgContainer.setContainerType(ParamUtil.getString(req, "containerType",
				""));
		bkgContainer.setContainerSize(ParamUtil.getString(req, "containerSize",
				""));
		bkgContainer.setContainerHeight(ParamUtil.getString(req,
				"containerHeight", ""));
		bkgContainer.setNoOfPkg(ParamUtil.getInt(req, "noOfPkg", 0));
		bkgContainer.setSealNo(ParamUtil.getString(req, "sealNo", ""));
		bkgContainer.setGrossMeas(ParamUtil.getBigDecimal(req, "grossMeas",
				new BigDecimal(0)));
		bkgContainer.setGrossWt(ParamUtil.getBigDecimal(req, "grossWt",
				new BigDecimal(0)));
	}
}
