package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgMaster;
//import org.nutz.demo.petstore.service.BkgMasterService;
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
import com.kline.booking.entity.BkgMaster;
import com.kline.booking.entity.BkgMasterA;
import com.kline.booking.helper.*;
import com.kline.booking.service.BookingService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bookingModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bookingAdmin")
@Fail("json")
public class BookingModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BookingModule.class);

	private BookingService bkgMasterService;

	@At
	@Ok("jsp:jsp.booking.bookingAdmin")
	public void entry() {
	}

	@At
	@Ok("jsp:jsp.booking.bkgMasterList")
	@Filters({
			@By(type = MyCheckSession.class, args = {
					"com.kline.core.entity.User", "/login.jsp" }),
			@By(type = BookingFilter.class, args = { "read", "/error/error.jsp" }) })
	public void findBkgMaster(HttpServletRequest request,
			@Param("pageNo") int pageNo, @Param("pageSize") int pageSize) {

		if (logger.isInfoEnabled()) {
			logger.info("findBkgMaster(HttpServletRequest, int, int) - pageNo=" + pageNo + ", pageSize=" + pageSize); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageSize <= 0) {
			pageSize = 50;
		}

		String status = ParamUtil.getString(request, "status");

		request.setAttribute("queryResult",
				bkgMasterService.findPage(status, pageNo, pageSize));

		String url = ParamUtil.getRequestURLWithoutPageNo(request);

		request.setAttribute("url", url);
	}

	@At
	@Ok("json")
	public List<BkgMaster> findBkgMaster4Office(
			@Param("action") String officeCode,
			@Param("action") String bkgMasterType, HttpServletRequest request) {
		// return bkgMasterService.getAllBkgMasters();

		return null;
	}

	@At
	@Ok("jsp:jsp.booking.bookingView")
	@Filters({
			@By(type = MyCheckSession.class, args = {
					"com.kline.core.entity.User", "/login.jsp" }),
			@By(type = BookingFilter.class, args = { "read", "/error/error.jsp" }) })
	public void viewBooking(HttpServletRequest request,
			@Param("bkgMasterId") long bkgMasterId) {

		BkgMaster bkgMaster = bkgMasterService.getBookingById(bkgMasterId);

		request.setAttribute("booking", bkgMaster);
	}

	@At
	@Ok("jsp:jsp.booking.bkgMasterEdit")
	public void editBkgMaster(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		if ("create".equals(action)) {
			BkgMaster bkgMaster = new BkgMaster();
			// bkgMaster.setBkgMasterId(bkgMasterId);
			//
			// bkgMaster.setBkgMasterName("");
			// bkgMaster.setOfficeCode("");
			// bkgMaster.setBkgMasterType("A");
			// bkgMaster.setBookingReference("");
			// bkgMaster.setEmailNotice4BkgAccepted("Y");
			// bkgMaster.setEmailNotice4BkgRejected("Y");
			// bkgMaster.setEmailNotice4CNCPSEnabled("N");
			// bkgMaster.setEmail("");
			// bkgMaster.setAddress("");
			// bkgMaster.setTel("");
			// bkgMaster.setFax("");
			// bkgMaster.setContact("");

			request.setAttribute("bkgMaster", bkgMaster);

			// String action = "add";
			// request.setAttribute("actn", action);

		} else if ("edit".equals(action)) {
			BkgMaster bkgMaster = bkgMasterService
					.getBkgMasterAById(bkgMasterId);

			request.setAttribute("bkgMaster", bkgMaster);
		}
	}

	@At
	@Ok("json")
	public BkgMaster saveBkgMaster(HttpServletRequest request,
			@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgMaster bkgMaster = null;

		bkgMaster = bkgMasterService.getBkgMasterAById(bkgMasterId);

		if (null == bkgMaster) {
			// TODO: error processing
		}
		bkgMaster.setUpdateInfo(myAccount.getUserId());
		bkgMaster.getBkgMasterA().setUpdateInfo(myAccount.getUserId());

		setBkgMasterA(bkgMaster, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgMaster(HttpServletRequest, String, long) - BkgMaster bkgMaster=" + Json.toJson(bkgMaster, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgMasterService.updateBkgMasterA(bkgMaster);

		return bkgMaster;
	}

	// @At
	// @Ok("json")
	// public void deleteBkgMaster(@Param("bkgMasterids") String bkgMasterids[])
	// {
	// if (bkgMasterids != null) {
	// for (String bkgMasterid : bkgMasterids) {
	// bkgMasterService.deleteBkgMasterByBkgMasterid(bkgMasterid);
	// }
	// }
	// }

	@At
	@Ok("json")
	public boolean isExistBkgMaster(@Param("bkgMasterId") long bkgMasterId) {
		BkgMaster bkgMaster = bkgMasterService.getBkgMasterById(bkgMasterId);

		return null != bkgMaster;
	}

	private void setBkgMasterA(BkgMaster bkgMaster, HttpServletRequest req) {

		BkgMasterA bkgMasterA = bkgMaster.getBkgMasterA();

		// bkgMaster.setBkgMasterId(req
		// .getParameter("bkgMasterId")));

		bkgMaster.setBlno(ParamUtil.getString(req, "blno", ""));
		bkgMaster.setOceanVesselCode(ParamUtil.getString(req,
				"oceanVesselCode", ""));
		bkgMaster.setOceanVesselName(ParamUtil.getString(req,
				"oceanVesselName", ""));
		bkgMaster.setOceanVoyage(ParamUtil.getString(req, "oceanVoyage", ""));
		bkgMaster.setOceanBound(ParamUtil.getString(req, "oceanBound", ""));
		bkgMaster.setServiceCode(ParamUtil.getString(req, "serviceCode", ""));
		bkgMaster.setShipperRefNo(ParamUtil.getString(req, "shipperRefNo", ""));
		bkgMasterA.setBlType(ParamUtil.getString(req, "blType", ""));
		bkgMasterA.setPlaceCodeOfBLIssued(ParamUtil.getString(req,
				"placeCodeOfBLIssued", ""));
		bkgMasterA.setPlaceNameOfBLIssued(ParamUtil.getString(req,
				"placeNameOfBLIssued", ""));
		bkgMasterA
				.setNoOfOriginalBL(ParamUtil.getInt(req, "noOfOriginalBL", 0));
		// bkgMaster.setbkgPartyCode( MyAccount.getUserId() );
		bkgMasterA.setPaymentType(ParamUtil.getString(req, "paymentType", ""));
		bkgMasterA.setPrepaidAtCode(ParamUtil.getString(req, "prepaidAtCode",
				""));
		bkgMasterA.setPrepaidAtName(ParamUtil.getString(req, "prepaidAtName",
				""));
		bkgMasterA.setPayableAtCode(ParamUtil.getString(req, "payableAtCode",
				""));
		bkgMasterA.setPayableAtName(ParamUtil.getString(req, "payableAtName",
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
			String BLNo = bkgMaster.getBlno();
			if (BLNo.equals(masterLclNo)) {
				masterLclNo = "";
			}
		}

		// bkgMaster.setFullLclFlag( ParamUtil.getString(req, "FullLclFlag" ) );
		// bkgMaster.setMasterLclNo( ParamUtil.getString(req, "MasterLclNo" ) );
		bkgMaster.setFullLclFlag(fullLclFlag);
		bkgMaster.setMasterLclNo(masterLclNo);

		// bkgMaster.setFullLclFlag( ParamUtil.getString(req, "FullLclFlag" ) );
		// bkgMaster.setMasterLclNo( ParamUtil.getString(req, "MasterLclNo" ) );

		bkgMasterA.setRecTypeCode(ParamUtil.getString(req, "recTypeCode", ""));
		bkgMasterA.setDelTypeCode(ParamUtil.getString(req, "delTypeCode", ""));
		bkgMasterA.setPlaceCodeOfReceipt(ParamUtil.getString(req,
				"placeCodeOfReceipt", ""));
		bkgMasterA.setPlaceNameOfReceipt(ParamUtil.getString(req,
				"placeNameOfReceipt", ""));
		bkgMasterA
				.setLoadPortCode(ParamUtil.getString(req, "loadPortCode", ""));
		bkgMasterA
				.setLoadPortName(ParamUtil.getString(req, "loadPortName", ""));
		bkgMasterA.setDischargePortCode(ParamUtil.getString(req,
				"dischargePortCode", ""));
		bkgMasterA.setDischargePortName(ParamUtil.getString(req,
				"dischargePortName", ""));
		bkgMasterA.setPlaceCodeOfDelivery(ParamUtil.getString(req,
				"placeCodeOfDelivery", ""));
		bkgMasterA.setPlaceNameOfDelivery(ParamUtil.getString(req,
				"placeNameOfDelivery", ""));
		bkgMasterA.setTranshipmentPortCode(ParamUtil.getString(req,
				"transhipmentPortCode", ""));
		bkgMasterA.setTranshipmentPortName(ParamUtil.getString(req,
				"transhipmentPortName", ""));
		bkgMasterA.setGateInCode(ParamUtil.getString(req, "gateInCode", ""));

		bkgMasterA.setShipperCode(ParamUtil.getInt(req, "shipperCode", 0));
		bkgMasterA.setShipperName(ParamUtil.getString(req, "shipperName", ""));
		bkgMasterA.setConsigneeCode(ParamUtil.getInt(req, "consigneeCode", 0));
		bkgMasterA.setConsigneeName(ParamUtil.getString(req, "consigneeName",
				""));
		bkgMasterA.setNotify_1Code(ParamUtil.getInt(req, "notifyCode", 0));
		bkgMasterA.setNotify_1Name(ParamUtil.getString(req, "notifyName", ""));

		bkgMasterA.setShipperAddress(ParamUtil.getString(req, "shipperAddress",
				""));
		bkgMasterA.setConsigneeAddress(ParamUtil.getString(req,
				"consigneeAddress", ""));
		bkgMasterA.setNotify_1Address(ParamUtil.getString(req, "notifyAddress",
				""));
		bkgMasterA
				.setNotify_2Name(ParamUtil.getString(req, "notify_2Name", ""));
		bkgMasterA.setNotify_2Address(ParamUtil.getString(req,
				"notify_2Address", ""));
		bkgMasterA
				.setNotify_3Name(ParamUtil.getString(req, "notify_3Name", ""));
		bkgMasterA.setNotify_3Address(ParamUtil.getString(req,
				"notify_3Address", ""));

		// Wu shuo, 07/31/2005
		bkgMasterA.setPreVesselCode(ParamUtil.getString(req, "preVesselCode",
				""));
		bkgMasterA.setPreVesselName(ParamUtil.getString(req, "preVesselName",
				""));
		bkgMasterA.setPreVesselVoyage(ParamUtil.getString(req,
				"preVesselVoyage", ""));
		bkgMasterA.setPreVesselBound(ParamUtil.getString(req, "preVesselBound",
				""));

		if (!"".equals(bkgMasterA.getPreVesselCode())) {
			bkgMasterA.setPreVesselBound("O");
		}

		bkgMasterA.setNvoccStatus(ParamUtil
				.getString(req, "nvoccStatus", "BCO"));
		bkgMasterA.setNvoNo(ParamUtil.getString(req, "nvoNo", ""));

		// Wu Shuo, 2007/10/13
		bkgMasterA.setBlNextServiceCode(ParamUtil.getString(req,
				"blNextServiceCode", ""));

		bkgMasterA.setScNo(ParamUtil.getString(req, "scNo", ""));

	}
}
