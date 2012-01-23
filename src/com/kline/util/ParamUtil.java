package com.kline.util;

/**
 * Title:		ParamUtil.java
 * Description:
 * Copyright:		Copyright (c) 2003
 * Company:		ZWINFO
 * @author:		Wu Shuo
 * @version:		1.0
 * Date Created:	May. 10, 2003
 * Last Modified:	May. 10, 2003
 */

import javax.servlet.http.*;

import java.math.*;
import java.util.*;

/**
 *  ¿‡√˚: ParamUtil
 *  √Ë ˆ£∫
 */

public class ParamUtil {
	public static String getString(
		HttpServletRequest request,
		String paramName) {
		String temp = request.getParameter(paramName);
		if (temp != null && !temp.equals(""))
			return temp;
		else
			return null;
	}

	public static String getString(
		HttpServletRequest request,
		String paramName,
		String defaultString) {
		String temp = getString(request, paramName);
		if (temp == null)
			temp = defaultString;
		return temp;
	}

	public static int getInt(HttpServletRequest request, String paramName)
		throws NumberFormatException {
		try {
			return Integer.parseInt(getString(request, paramName));
		} catch (Exception e) {
			throw new NumberFormatException(
				"error get integer value for ["
					+ paramName
					+ "]: "
					+ e.getMessage());
		}
	}

	public static int getInt(
		HttpServletRequest request,
		String paramName,
		int defaultInt) {
		try {
			String temp = getString(request, paramName);
			if (temp == null)
				return defaultInt;
			else
				return Integer.parseInt(temp);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			//return 0;
			return defaultInt;
		}
	}

	public static float getFloat(
		HttpServletRequest request,
		String paramName)
		throws NumberFormatException {
		try {
			String temp = getString(request, paramName);
			return Float.parseFloat(temp);
		} catch (Exception e) {
			throw new NumberFormatException(
				"error get float value for ["
					+ paramName
					+ "]: "
					+ e.getMessage());
		}
	}

	public static float getFloat(
		HttpServletRequest request,
		String paramName,
		float defaultBD) {
		try {
			String temp = getString(request, paramName);
			if (temp == null)
				return defaultBD;
			else
				return Float.parseFloat(temp);
		} catch (Exception e) {
			e.printStackTrace();
			return defaultBD;
		}
	}
	
	public static BigDecimal getBigDecimal(HttpServletRequest request,
			String paramName) throws Exception {
		
		String temp = getString(request, paramName);
		
		return new BigDecimal(temp);
	}
	
	public static BigDecimal getBigDecimal(HttpServletRequest request,
			String paramName, BigDecimal defaultBD) {
		try {
			String temp = getString(request, paramName);
			if (temp == null || temp.equals(""))
				return defaultBD;
			else
				return new BigDecimal(temp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return defaultBD;
		}
	}


	public static final String REQUEST_URL = "requestURL";

	public static final String REQUEST_URL_WITHOUT_PAGENO =
		"requestURLWithoutPageNo";

	public static final void saveCurRequestURL(HttpServletRequest req) {

		String reqURL = getRequestURL(req, false);
		String reqURLWithoutPageNo = getRequestURLWithoutPageNo(req);
		req.getSession().setAttribute(REQUEST_URL, reqURL);
		req.getSession().setAttribute(
			REQUEST_URL_WITHOUT_PAGENO,
			reqURLWithoutPageNo);

	}

	public static final String getCurRequestURL(HttpServletRequest req) {
		return (String) req.getSession().getAttribute(REQUEST_URL);
	}

	public static final String getCurRequestURLWithoutPageNo(HttpServletRequest req) {
		return (String) req.getSession().getAttribute(
			REQUEST_URL_WITHOUT_PAGENO);
	}

	public static final String getRequestURL(HttpServletRequest req) {
		return getRequestURL(req, true);
	}

	public static final String getRequestURL(
		HttpServletRequest req,
		boolean withoutPageNo) {

		StringBuffer sbuf = new StringBuffer();

		Enumeration<?> e = req.getParameterNames();

		//PrintWriter out = res.getWriter();
		sbuf.append(req.getServletPath());

		boolean isFirst = true;
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = req.getParameter(name);

			// Wu Shuo, 07/22/2005
			try {
				value = java.net.URLEncoder.encode(value, "utf-8");
			} catch (Exception ex) {
			}

			if (isFirst) {
				isFirst = false;
				sbuf.append("?");
			} else {
				sbuf.append("&");
			}
			if (withoutPageNo && "pageNo".equals(name)) {
			} else {
				sbuf.append(name).append("=").append(value);
			}
		}
		return sbuf.toString();
	}

	public static final String getRequestURLWithoutPageNo(HttpServletRequest req) {
		
		StringBuffer sbuf = new StringBuffer();

		Enumeration<?> e = req.getParameterNames();

		//PrintWriter out = res.getWriter();
		//sbuf.append(req.getServletPath());
		sbuf.append(req.getRequestURI());

		boolean isFirst = true;
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = req.getParameter(name);

			// Wu Shuo, 06/22/2005
			try {
				value = java.net.URLEncoder.encode(value, "utf-8");
			} catch (Exception ex) {
			}

			if (isFirst) {
				if (!"pageNo".equals(name)) {
					isFirst = false;
					sbuf.append("?");
					sbuf.append(name).append("=").append(value);
				}
			} else {
				if (!"pageNo".equals(name)) {
					sbuf.append("&");
					sbuf.append(name).append("=").append(value);
				}
			}
		}
		return sbuf.toString();

	}

}
