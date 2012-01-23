package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgCargo;
//import org.nutz.demo.petstore.service.BkgCargoService;
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
import com.kline.booking.entity.BkgCargo;
import com.kline.booking.service.BkgCargoService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgCargoModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgCargoAdmin")
@Fail("json")
public class BkgCargoModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BkgCargoModule.class);

	private BkgCargoService bkgCargoService;

	@At
	@Ok("jsp:jsp.booking.bkgCargoList")
	public void findMyBkgCargo(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgCargoService.findMyBkgCargo(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgCargoEdit")
	public void editBkgCargo(@Param("action") String action,
			@Param("bkgCargoId") long bkgCargoId, HttpServletRequest request) {

		BkgCargo bkgCargo = bkgCargoService.getById(bkgCargoId);

		request.setAttribute("bkgCargo", bkgCargo);
	}

	@At
	@Ok("json")
	public BkgCargo saveBkgCargo(HttpServletRequest request,
			@Param("action") String action, @Param("bkgCargoId") long bkgCargoId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgCargo bkgCargo = null;

		bkgCargo = bkgCargoService.getById(bkgCargoId);

		if (null == bkgCargo) {
			// TODO: error processing
		}
		bkgCargo.setUpdateInfo(myAccount.getUserId());
		bkgCargo.setUpdateInfo(myAccount.getUserId());

		setBkgCargo(bkgCargo, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgCargo(HttpServletRequest, String, long) - BkgCargo bkgCargo=" + Json.toJson(bkgCargo, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgCargoService.update(bkgCargo);

		return bkgCargo;
	}

	@At
	@Ok("json")
	public void deleteBkgCargo(HttpServletRequest request,
			@Param("action") String action, @Param("bkgCargoId") long bkgCargoId) {

		bkgCargoService.deleteById(bkgCargoId);

	}

	private void setBkgCargo(BkgCargo bkgCargo, HttpServletRequest req) {

		bkgCargo.setBkgCargoId(ParamUtil.getInt(req, "bkgCargoId", 0));
		// bkgCargo.setBkgMasterId(Integer.parseInt(ParamUtil.getString(req,
		// "BkgMasterId", 0));
		// bkgCargo.setSeq(ParamUtil.getInt(req, "seq", 0));
		bkgCargo.setCargoTypeCode(ParamUtil.getString(req, "cargoTypeCode", ""));
		bkgCargo.setInnerQty(ParamUtil.getInt(req, "innerQty", 0));
		bkgCargo.setInnerPkgTypeCode(ParamUtil.getString(req,
				"innerPkgTypeCode", ""));
		bkgCargo.setInnerPkgTypeName(ParamUtil.getString(req,
				"innerPkgTypeName", ""));

		bkgCargo.setOuterQty(ParamUtil.getInt(req, "quterQty", 0));
		bkgCargo.setOuterPkgTypeCode(ParamUtil.getString(req,
				"OuterPkgTypeCode", ""));
		bkgCargo.setOuterPkgTypeName(ParamUtil.getString(req,
				"OuterPkgTypeName", ""));

		// bkgCargo.setGrossWt(new BigDecimal(ParamUtil.getString(req,
		// "GrossWt", 0));
		// bkgCargo.setGrossMeas(new BigDecimal(ParamUtil.getString(req,
		// "GrossMeas", 0));

		bkgCargo.setGrossWt(ParamUtil.getBigDecimal(req, "grossWt",
				new BigDecimal(0)));
		bkgCargo.setGrossMeas(ParamUtil.getBigDecimal(req, "grossMeas",
				new BigDecimal(0)));

		bkgCargo.setNetWt(ParamUtil.getBigDecimal(req, "netWt", new BigDecimal(
				0)));
		bkgCargo.setNetMeas(ParamUtil.getBigDecimal(req, "netMeas",
				new BigDecimal(0)));

		bkgCargo.setDgClass(ParamUtil.getString(req, "dgClass", ""));
		bkgCargo.setDgPage(ParamUtil.getString(req, "dgPage", ""));
		bkgCargo.setDgNo(ParamUtil.getString(req, "dgNo", ""));
		bkgCargo.setDgLabel(ParamUtil.getString(req, "dgLabel", ""));
		bkgCargo.setFlashPoint(ParamUtil.getString(req, "flashPoint", ""));
		bkgCargo.setEmsNo(ParamUtil.getString(req, "emsNo", ""));
		bkgCargo.setMfgNo(ParamUtil.getString(req, "mfgNo", ""));

		// bkgCargo.setMpt(ParamUtil.getString(req, "Mpt", ""));
		bkgCargo.setMpt(ParamUtil.getString(req, "mpt", "N"));

		bkgCargo.setEmsContact(ParamUtil.getString(req, "emsContact", ""));
		bkgCargo.setRvf(ParamUtil.getString(req, "rvf", ""));
		bkgCargo.setTempUnit(ParamUtil.getString(req, "tempUnit", ""));
		bkgCargo.setTempSetting(ParamUtil.getString(req, "tempSetting", ""));
		bkgCargo.setMinTemp(ParamUtil.getString(req, "minTemp", ""));
		bkgCargo.setMaxTemp(ParamUtil.getString(req, "maxTemp", ""));

		bkgCargo.setImdg(ParamUtil.getString(req, "imdg", ""));

		bkgCargo.setOverLenFront(ParamUtil.getInt(req, "overLenFront", 0));
		bkgCargo.setOverLenBack(ParamUtil.getInt(req, "overLenBack", 0));
		bkgCargo.setOverWidLeft(ParamUtil.getInt(req, "overWidLeft", 0));
		bkgCargo.setOverWidRight(ParamUtil.getInt(req, "overWidRight", 0));
		bkgCargo.setOverHeight(ParamUtil.getInt(req, "overHeight", 0));

		bkgCargo.setDescription(ParamUtil.getString(req, "description", ""));
		bkgCargo.setCdescription(ParamUtil.getString(req, "cdescription", ""));
	}
}
