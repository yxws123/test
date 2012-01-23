package com.kline.sds.ui;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.Payer;
//import org.nutz.demo.petstore.service.PayerService;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.kline.Constants;
import com.kline.sds.entity.Payer;
import com.kline.sds.service.PayerService;
import com.kline.util.AuthUtil;

@InjectName("payerModule")
@At("/sds/payerAdmin")
@Fail("json")
public class PayerModule {
	private PayerService payerService;

//	@At
//	@Ok("jsp:jsp.sds.payer.payerAdmin")
//	public void payerAdmin() {
//	}

	@At
	@Ok("jsp:jsp.core.agent.payerList")
	public void findPayer(HttpServletRequest request) {
		request.setAttribute("payerList", payerService.getAllPayers());
	}

//	@At
//	@Ok("jsp:jsp.sds.payer.payerEdit")
//	public void editPayer(@Param("action")String action,
//			@Param("payerCode")String payerCode, 			
//			HttpServletRequest request) {
//		
//		if ("create".equals(action)) {
//			Payer payer = new Payer();
//			payer.setPayerCode(payerCode);
//			
//			request.setAttribute("payer", payer);			
//
////			String action = "add";
////			request.setAttribute("actn", action);
//
//		} else if ("edit".equals(action)) {
//			Payer payer = payerService.getPayerById(payerCode);
//			
//			request.setAttribute("payer", payer);			
//		}
//	}
//
//	@At
//	@Ok("json")
//	public Payer savePayer(@Param("action")String action,
//			@Param("payerCode")String payerCode,
//			@Param("payerName")String payerName,
//			@Param("officeCode")String officeCode,
//			@Param("payerType")String payerType,
//			@Param("contact")String contact,
//			@Param("address")String address,
//			@Param("tel")String tel,
//			@Param("fax")String fax,
//			@Param("email")String email,
//			@Param("bookingReference")String bookingReference,
//			@Param("emailNotice4BkgAccepted")String emailNotice4BkgAccepted,
//			@Param("emailNotice4BkgRejected")String emailNotice4BkgRejected,
//			@Param("emailNotice4CNCPSEnabled")String emailNotice4CNCPSEnabled
//			) {
//
//		Payer payer = null;		
//		if ("create".equals(action)) {
//			payer = new Payer();		
//			
//			payer.setNewInfo("admin");
//		} else {
//			payer = payerService.getPayerById(payerCode);
//			
//			payer.setUpdateInfo("admin");
//		}
//		
//		payer.setPayerCode(payerCode);
//		payer.setOfficeCode(officeCode);
//		payer.setPayerType(payerType);
//		
//		payer.setBookingReference(bookingReference);
//		
//		if (null == emailNotice4BkgAccepted) {
//			payer.setEmailNotice4BkgAccepted("N");			
//		} else {
//			payer.setEmailNotice4BkgAccepted("Y");			
//		}
//		
//		if (null == emailNotice4BkgRejected) {
//			payer.setEmailNotice4BkgRejected("N");			
//		} else {
//			payer.setEmailNotice4BkgRejected("Y");			
//		}
//
//		if (null == emailNotice4CNCPSEnabled) {
//			payer.setEmailNotice4CNCPSEnabled("N");			
//		} else {
//			payer.setEmailNotice4CNCPSEnabled("Y");			
//		}
//
//		payer.setAddress(address);
//		payer.setContact(contact);
//		payer.setTel(tel);
//		payer.setFax(fax);
//		payer.setEmail(email);
//				
//		if ("create".equals(action)) {
//			payerService.insertPayer(payer);
//		} else {
//			payerService.updatePayer(payer);
//		}
//
//		return payer;
//	}

//	@At
//	@Ok("json")
//	public void deletePayer(@Param("payerids") String payerids[]) {
//		if (payerids != null) {
//			for (String payerid : payerids) {
//				payerService.deletePayerByPayerid(payerid);
//			}
//		}
//	}

}
