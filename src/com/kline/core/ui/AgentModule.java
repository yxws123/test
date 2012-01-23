package com.kline.core.ui;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.Agent;
//import org.nutz.demo.petstore.service.AgentService;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.kline.Constants;
import com.kline.core.entity.Agent;
import com.kline.core.service.AgentService;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("agentModule")
@Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp" }))
@At("/core/agentAdmin")
@Fail("json")
public class AgentModule {
	private AgentService agentService;

	@At
	@Ok("jsp:jsp.core.agent.agentAdmin")
	public void entryPoint() {
	}

	@At
	@Ok("jsp:jsp.core.agent.agentList")
	public void findPage(HttpServletRequest request,
			@Param("agentCode") String agentCode,
			@Param("officeCode") String officeCode,
			@Param("agentType") String agentType, @Param("pageNo") int pageNo,
			@Param("pageSize") int pageSize) {
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageSize <= 0) {
			pageSize = 50;
		}

		if ("AgentCode".equals(agentCode)) {
			agentCode = null;
		}

		request.setAttribute("queryResult", agentService.findPage(agentCode,
				officeCode, agentType, pageNo, pageSize));

		String url = ParamUtil.getRequestURLWithoutPageNo(request);

		request.setAttribute("url", url);

	}

	@At
	@Ok("json")
	public List<Agent> findAgent4Office(HttpServletRequest request,
			@Param("agentCode") String agentCode,
			@Param("officeCode") String officeCode,
			@Param("agentType") String agentType,
			@Param("directBookingFlag") String directBookingFlag) {
		return agentService.find(agentCode, officeCode, agentType, directBookingFlag);
	}

	@At
	@Ok("jsp:jsp.core.agent.agentEdit")
	public void editAgent(@Param("action") String action,
			@Param("agentCode") String agentCode, HttpServletRequest request) {

		if ("create".equals(action)) {
			Agent agent = new Agent();
			agent.setAgentCode(agentCode);

			agent.setAgentName("");
			agent.setOfficeCode("");
			agent.setAgentType("A");
			agent.setBookingReference("");
			agent.setEmailNotice4BkgAccepted("Y");
			agent.setEmailNotice4BkgRejected("Y");
			agent.setEmailNotice4CNCPSEnabled("N");
			agent.setEmail("");
			agent.setAddress("");
			agent.setTel("");
			agent.setFax("");
			agent.setContact("");

			request.setAttribute("agent", agent);

			// String action = "add";
			// request.setAttribute("actn", action);

		} else if ("edit".equals(action)) {
			Agent agent = agentService.getById(agentCode);

			request.setAttribute("agent", agent);
		}
	}

	@At
	@Ok("json")
	public Agent saveAgent(@Param("action") String action,
			@Param("agentCode") String agentCode,
			@Param("agentName") String agentName,
			@Param("officeCode") String officeCode,
			@Param("agentType") String agentType,
			@Param("isDirectBooking") String isDirectBooking,
			@Param("contact") String contact, @Param("address") String address,
			@Param("tel") String tel, @Param("fax") String fax,
			@Param("email") String email,
			@Param("bookingReference") String bookingReference,
			@Param("emailNotice4BkgAccepted") String emailNotice4BkgAccepted,
			@Param("emailNotice4BkgRejected") String emailNotice4BkgRejected,
			@Param("emailNotice4CNCPSEnabled") String emailNotice4CNCPSEnabled) {

		Agent agent = null;
		if ("create".equals(action)) {
			agent = new Agent();

			agent.setNewInfo("admin");
		} else {
			agent = agentService.getById(agentCode);

			agent.setUpdateInfo("admin");
		}

		agent.setAgentCode(agentCode);
		agent.setAgentName(agentName);
		agent.setOfficeCode(officeCode);
		agent.setAgentType(agentType);
		
		if (null == isDirectBooking) {
			agent.setNotDirectBooking();
		} else {
			agent.setDirectBooking();
		}

		agent.setBookingReference(bookingReference);

		if (null == emailNotice4BkgAccepted) {
			agent.setEmailNotice4BkgAccepted("N");
		} else {
			agent.setEmailNotice4BkgAccepted("Y");
		}

		if (null == emailNotice4BkgRejected) {
			agent.setEmailNotice4BkgRejected("N");
		} else {
			agent.setEmailNotice4BkgRejected("Y");
		}

		if (null == emailNotice4CNCPSEnabled) {
			agent.setEmailNotice4CNCPSEnabled("N");
		} else {
			agent.setEmailNotice4CNCPSEnabled("Y");
		}

		agent.setAddress(address);
		agent.setContact(contact);
		agent.setTel(tel);
		agent.setFax(fax);
		agent.setEmail(email);

		if ("create".equals(action)) {
			agentService.insert(agent);
		} else {
			agentService.update(agent);
		}

		return agent;
	}

	// @At
	// @Ok("json")
	// public void deleteAgent(@Param("agentids") String agentids[]) {
	// if (agentids != null) {
	// for (String agentid : agentids) {
	// agentService.deleteAgentByAgentid(agentid);
	// }
	// }
	// }

	@At
	@Ok("json")
	public boolean isExistAgent(@Param("agentCode") String agentCode) {
		Agent agent = agentService.getById(agentCode);

		return null != agent;
	}

}
