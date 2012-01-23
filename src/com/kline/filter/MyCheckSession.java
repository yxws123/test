package com.kline.filter;

import org.apache.log4j.Logger;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.View;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.view.ServerRedirectView;

public class MyCheckSession extends CheckSession {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyCheckSession.class);

	public MyCheckSession(String name, String path) {
		super(name, path);

		if (logger.isDebugEnabled()) {
			logger.debug("MyCheckSession(String, String) - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated constructor stub

		if (logger.isDebugEnabled()) {
			logger.debug("MyCheckSession(String, String) - end"); //$NON-NLS-1$
		}
	}
	
	public View match(ActionContext context) {
		if (logger.isDebugEnabled()) {
			logger.debug("match(ActionContext) - start"); //$NON-NLS-1$
		}
		
		return super.match(context);
	}

}
