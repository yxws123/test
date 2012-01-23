package com.kline.booking.ui;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.nutz.demo.petstore.domain.BkgNote;
//import org.nutz.demo.petstore.service.BkgNoteService;
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
import com.kline.booking.entity.BkgNote;
import com.kline.booking.service.BkgNoteService;
import com.kline.core.entity.User;
import com.kline.util.AuthUtil;
import com.kline.util.ParamUtil;
import com.kline.filter.*;

@InjectName("bkgNoteModule")
// @Filters(@By(type = AuthFilter.class, args = { "admin", "/error/error.jsp"
// }))
@At("/booking/bkgNoteAdmin")
@Fail("json")
public class BkgNoteModule {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BkgNoteModule.class);

	private BkgNoteService bkgNoteService;

	@At
	@Ok("jsp:jsp.booking.bkgNoteList")
	public void findMyBkgNote(@Param("action") String action,
			@Param("bkgMasterId") long bkgMasterId, HttpServletRequest request) {

		request.setAttribute("list",
				bkgNoteService.findMyBkgNote(bkgMasterId));
	}

	@At
	@Ok("jsp:jsp.booking.bkgNoteEdit")
	public void editBkgNote(@Param("action") String action,
			@Param("bkgNoteId") long bkgNoteId, HttpServletRequest request) {

		BkgNote bkgNote = bkgNoteService.getById(bkgNoteId);

		request.setAttribute("bkgNote", bkgNote);
	}

	@At
	@Ok("json")
	public BkgNote saveBkgNote(HttpServletRequest request,
			@Param("action") String action, @Param("bkgNoteId") long bkgNoteId) {

		User myAccount = AuthUtil.getMyAccount(request);

		BkgNote bkgNote = null;

		bkgNote = bkgNoteService.getById(bkgNoteId);

		if (null == bkgNote) {
			// TODO: error processing
		}
		bkgNote.setUpdateInfo(myAccount.getUserId());
		bkgNote.setUpdateInfo(myAccount.getUserId());

		setBkgNote(bkgNote, request);

		if (logger.isInfoEnabled()) {
			logger.info("saveBkgNote(HttpServletRequest, String, long) - BkgNote bkgNote=" + Json.toJson(bkgNote, JsonFormat.full())); //$NON-NLS-1$
		}

		bkgNoteService.update(bkgNote);

		return bkgNote;
	}

	@At
	@Ok("json")
	public void deleteBkgNote(HttpServletRequest request,
			@Param("action") String action, @Param("bkgNoteId") long bkgNoteId) {

		bkgNoteService.deleteById(bkgNoteId);

	}

	private void setBkgNote(BkgNote bkgNote, HttpServletRequest req) {

	}
}
