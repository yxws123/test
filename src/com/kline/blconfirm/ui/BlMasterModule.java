package com.kline.blconfirm.ui;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BlMaster;
//import org.nutz.demo.petstore.service.BlMasterService;
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
import com.kline.blconfirm.service.BlMasterService;
import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.entity.BlMaster;
import com.kline.blconfirm.entity.BlMasterA;
import com.kline.blconfirm.*;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("blMasterModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/blconfirm/blAdmin")
@Fail("json")
public class BlMasterModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BlMasterModule.class);

	private BlMasterService blMasterService;

	@At
	@Ok("jsp:jsp.blconfirm.blAdmin")
	public void entryPoint() {
	}

	@At
	@Ok("jsp:jsp.blconfirm.blMasterList")
//	@Filters({
//			@By(type = MyCheckSession.class, args = {
//					"com.kline.core.entity.User", "/login.jsp" }),
//			@By(type = BLFilter.class, args = { "read", "/error/error.jsp" }) })
	public void findPage(HttpServletRequest request,
			@Param("pageNo") int pageNo, @Param("pageSize") int pageSize) {

		if (logger.isInfoEnabled()) {
			logger.info("findBlMaster(HttpServletRequest, int, int) - pageNo=" + pageNo + ", pageSize=" + pageSize); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageSize <= 0) {
			pageSize = 50;
		}

		int status = ParamUtil.getInt(request, "status", 1);

		request.setAttribute("queryResult",
				blMasterService.findPage(status, pageNo, pageSize));

		String url = ParamUtil.getRequestURLWithoutPageNo(request);

		request.setAttribute("url", url);
	}

	@At
	@Ok("json")
	public List<BlMaster> findBlMaster4Office(
			@Param("action") String officeCode,
			@Param("action") String blMasterType, HttpServletRequest request) {
		// return blMasterService.getAllBlMasters();

		return null;
	}

	@At
	@Ok("jsp:jsp.blconfirm.blView")
//	@Filters({
//			@By(type = MyCheckSession.class, args = {
//					"com.kline.core.entity.User", "/login.jsp" }),
//			@By(type = BLFilter.class, args = { "read", "/error/error.jsp" }) })
	public void viewBL(HttpServletRequest request,
			@Param("blMasterId") long blMasterId) {

		BlMaster blMaster = blMasterService.getBLById(blMasterId);

		request.setAttribute("bl", blMaster);
	}

	@At
	@Ok("jsp:jsp.blconfirm.blMasterEdit")
	public void editBlMaster(@Param("action") String action,
			@Param("blMasterId") long blMasterId, HttpServletRequest request) {

		if ("create".equals(action)) {
			BlMaster blMaster = new BlMaster();
			// blMaster.setBlMasterId(blMasterId);
			//
			// blMaster.setBlMasterName("");
			// blMaster.setOfficeCode("");
			// blMaster.setBlMasterType("A");
			// blMaster.setBLReference("");
			// blMaster.setEmailNotice4BlAccepted("Y");
			// blMaster.setEmailNotice4BlRejected("Y");
			// blMaster.setEmailNotice4CNCPSEnabled("N");
			// blMaster.setEmail("");
			// blMaster.setAddress("");
			// blMaster.setTel("");
			// blMaster.setFax("");
			// blMaster.setContact("");

			request.setAttribute("blMaster", blMaster);

			// String action = "add";
			// request.setAttribute("actn", action);

		} else if ("edit".equals(action)) {
			BlMaster blMaster = blMasterService
					.getById(blMasterId);

			request.setAttribute("blMaster", blMaster);
		}
	}

//	@At
//	@Ok("json")
//	public BlMaster saveBlMaster(HttpServletRequest request,
//			@Param("action") String action,
//			@Param("blMasterId") long blMasterId) {
//
//		User myAccount = AuthUtil.getMyAccount(request);
//
//		BlMaster blMaster = null;
//
//		blMaster = blMasterService.getBlMasterAById(blMasterId);
//
//		if (null == blMaster) {
//			// TODO: error processing
//		}
//		blMaster.setUpdateInfo(myAccount.getUserId());
//		blMaster.getBlMasterA().setUpdateInfo(myAccount.getUserId());
//
//		setBlMasterA(blMaster, request);
//
//		if (logger.isInfoEnabled()) {
//			logger.info("saveBlMaster(HttpServletRequest, String, long) - BlMaster blMaster=" + Json.toJson(blMaster, JsonFormat.full())); //$NON-NLS-1$
//		}
//
//		blMasterService.updateBlMasterA(blMaster);
//
//		return blMaster;
//	}

	// @At
	// @Ok("json")
	// public void deleteBlMaster(@Param("blMasterids") String blMasterids[])
	// {
	// if (blMasterids != null) {
	// for (String blMasterid : blMasterids) {
	// blMasterService.deleteBlMasterByBlMasterid(blMasterid);
	// }
	// }
	// }

//	@At
//	@Ok("json")
//	public boolean isExistBlMaster(@Param("blMasterId") long blMasterId) {
//		BlMaster blMaster = blMasterService.getBlMasterById(blMasterId);
//
//		return null != blMaster;
//	}

	private void setBlMasterA(BlMaster blMaster, HttpServletRequest req) {

		BlMasterA blMasterA = blMaster.getBlMasterA();

		// blMaster.setBlMasterId(req
		// .getParameter("blMasterId")));

		blMaster.setBlno(ParamUtil.getString(req, "blno", ""));
		blMaster.setOceanVesselCode(ParamUtil.getString(req,
				"oceanVesselCode", ""));
		blMaster.setOceanVesselName(ParamUtil.getString(req,
				"oceanVesselName", ""));
		blMaster.setOceanVoyage(ParamUtil.getString(req, "oceanVoyage", ""));
		blMaster.setOceanBound(ParamUtil.getString(req, "oceanBound", ""));
		blMaster.setServiceCode(ParamUtil.getString(req, "serviceCode", ""));
		blMaster.setShipperRefNo(ParamUtil.getString(req, "shipperRefNo", ""));
		blMasterA.setBlType(ParamUtil.getString(req, "blType", ""));
		blMasterA.setPlaceCodeOfBLIssued(ParamUtil.getString(req,
				"placeCodeOfBLIssued", ""));
		blMasterA.setPlaceNameOfBLIssued(ParamUtil.getString(req,
				"placeNameOfBLIssued", ""));
		blMasterA
				.setNoOfOriginalBL(ParamUtil.getInt(req, "noOfOriginalBL", 0));
		// blMaster.setblPartyCode( MyAccount.getUserId() );
		blMasterA.setPaymentType(ParamUtil.getString(req, "paymentType", ""));
		blMasterA.setPrepaidAtCode(ParamUtil.getString(req, "prepaidAtCode",
				""));
		blMasterA.setPrepaidAtName(ParamUtil.getString(req, "prepaidAtName",
				""));
		blMasterA.setPayableAtCode(ParamUtil.getString(req, "payableAtCode",
				""));
		blMasterA.setPayableAtName(ParamUtil.getString(req, "payableAtName",
				""));

		// 2003-9-9, Wu Shuo
		// §³?????FullLclFlag?F???MasterLclNo???????
		String fullLclFlag = ParamUtil.getString(req, "fullLclFlag", "");
		// if (fullLclFlag == null) {
		// throw new Exception("FullLclFlag cannot be null");
		// }
		String masterLclNo = ParamUtil.getString(req, "masterLclNo", "");
		// if (masterLclNo == null) {
		// throw new Exception("MasterLclNo cannot be null!");
		// }
		// if ("F".equals(fullLclFlag) && !"".equals(masterLclNo)) {
		// throw new Exception(
		// "MasterLclNo must be empty when FullLclFlag is F");
		// }

		// ??FullLclFlag?L???MasterLclNo??BLNo???????
		if ("L".equals(fullLclFlag)) {
			String BLNo = blMaster.getBlno();
			if (BLNo.equals(masterLclNo)) {
				masterLclNo = "";
			}
		}

		// blMaster.setFullLclFlag( ParamUtil.getString(req, "FullLclFlag" ) );
		// blMaster.setMasterLclNo( ParamUtil.getString(req, "MasterLclNo" ) );
//		blMaster.setFullLclFlag(fullLclFlag);
//		blMaster.setMasterLclNo(masterLclNo);

		// blMaster.setFullLclFlag( ParamUtil.getString(req, "FullLclFlag" ) );
		// blMaster.setMasterLclNo( ParamUtil.getString(req, "MasterLclNo" ) );

		blMasterA.setRecTypeCode(ParamUtil.getString(req, "recTypeCode", ""));
		blMasterA.setDelTypeCode(ParamUtil.getString(req, "delTypeCode", ""));
		blMasterA.setPlaceCodeOfReceipt(ParamUtil.getString(req,
				"placeCodeOfReceipt", ""));
		blMasterA.setPlaceNameOfReceipt(ParamUtil.getString(req,
				"placeNameOfReceipt", ""));
		blMasterA
				.setLoadPortCode(ParamUtil.getString(req, "loadPortCode", ""));
		blMasterA
				.setLoadPortName(ParamUtil.getString(req, "loadPortName", ""));
		blMasterA.setDischargePortCode(ParamUtil.getString(req,
				"dischargePortCode", ""));
		blMasterA.setDischargePortName(ParamUtil.getString(req,
				"dischargePortName", ""));
		blMasterA.setPlaceCodeOfDelivery(ParamUtil.getString(req,
				"placeCodeOfDelivery", ""));
		blMasterA.setPlaceNameOfDelivery(ParamUtil.getString(req,
				"placeNameOfDelivery", ""));
//		blMasterA.setTranshipmentPortCode(ParamUtil.getString(req,
//				"transhipmentPortCode", ""));
//		blMasterA.setTranshipmentPortName(ParamUtil.getString(req,
//				"transhipmentPortName", ""));
//		blMasterA.setGateInCode(ParamUtil.getString(req, "gateInCode", ""));

//		blMasterA.setShipperCode(ParamUtil.getInt(req, "shipperCode", 0));
		blMasterA.setShipperName(ParamUtil.getString(req, "shipperName", ""));
//		blMasterA.setConsigneeCode(ParamUtil.getInt(req, "consigneeCode", 0));
		blMasterA.setConsigneeName(ParamUtil.getString(req, "consigneeName",
				""));
//		blMasterA.setNotify_1Code(ParamUtil.getInt(req, "notifyCode", 0));
		blMasterA.setNotify_1Name(ParamUtil.getString(req, "notifyName", ""));

		blMasterA.setShipperAddress(ParamUtil.getString(req, "shipperAddress",
				""));
		blMasterA.setConsigneeAddress(ParamUtil.getString(req,
				"consigneeAddress", ""));
		blMasterA.setNotify_1Address(ParamUtil.getString(req, "notifyAddress",
				""));
		blMasterA
				.setNotify_2Name(ParamUtil.getString(req, "notify_2Name", ""));
		blMasterA.setNotify_2Address(ParamUtil.getString(req,
				"notify_2Address", ""));
		blMasterA
				.setNotify_3Name(ParamUtil.getString(req, "notify_3Name", ""));
		blMasterA.setNotify_3Address(ParamUtil.getString(req,
				"notify_3Address", ""));

		// Wu shuo, 07/31/2005
		blMasterA.setPreVesselCode(ParamUtil.getString(req, "preVesselCode",
				""));
		blMasterA.setPreVesselName(ParamUtil.getString(req, "preVesselName",
				""));
		blMasterA.setPreVesselVoyage(ParamUtil.getString(req,
				"preVesselVoyage", ""));
		blMasterA.setPreVesselBound(ParamUtil.getString(req, "preVesselBound",
				""));

		if (!"".equals(blMasterA.getPreVesselCode())) {
			blMasterA.setPreVesselBound("O");
		}

//		blMasterA.setNvoccStatus(ParamUtil
//				.getString(req, "nvoccStatus", "BCO"));
//		blMasterA.setNvoNo(ParamUtil.getString(req, "nvoNo", ""));
//
//		// Wu Shuo, 2007/10/13
//		blMasterA.setBlNextServiceCode(ParamUtil.getString(req,
//				"blNextServiceCode", ""));
//
//		blMasterA.setScNo(ParamUtil.getString(req, "scNo", ""));

	}
}
