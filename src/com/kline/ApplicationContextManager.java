/*
 * 文件�?   ApplicationContextManager.java
 * 创建�?   Administrator
 * 创建日期 2005-7-7
 * 版本     1.0
 * 修改历史
 * 1）Administrator 2005-7-7
 *    创建文件
 */
package com.kline;

//import javax.servlet.ServletContext;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

/**
 * @author Administrator
 * @since  2005-7-7 1:44:20
 */
public class ApplicationContextManager {
	
	private static ApplicationContextManager instance = new ApplicationContextManager();

    private static Ioc ioc;

	private ApplicationContextManager() {
    	ioc = new NutIoc(new JsonLoader("ioc"));
	}
	
	public static ApplicationContextManager getInstance() {
		return instance;
	}
	
	public <T> T getBean(Class<T> type, String name) {
		if (ioc != null) {
			return ioc.get(type, name);
		}
		return null;
	}
}
