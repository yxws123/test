package com.kline;

//import org.nutz.demo.petstore.mvc.module.AccountModule;
//import org.nutz.demo.petstore.mvc.module.MessageModule;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.ioc.provider.JsonIocProvider;

import com.kline.blconfirm.ui.BlCargoModule;
import com.kline.blconfirm.ui.BlMarkNoModule;
import com.kline.blconfirm.ui.BlMasterBModule;
import com.kline.blconfirm.ui.BlMasterModule;
import com.kline.booking.ui.BookingModule;
import com.kline.core.entity.User;
import com.kline.core.ui.AgentModule;
import com.kline.core.ui.UserModule;
import com.kline.filter.MyCheckSession;
import com.kline.sds.ui.PayerModule;

//@Modules( { UserModule.class, MessageModule.class})
@Modules({ UserModule.class, AgentModule.class, PayerModule.class,
		BookingModule.class, BlMasterModule.class, BlMasterBModule.class,
		BlCargoModule.class, BlMarkNoModule.class})
@IocBy(type = JsonIocProvider.class, args = { "ioc" })
// "ioc/dao.js",
// "ioc/common.js" })
@Filters(@By(type = MyCheckSession.class, args = {
		"com.kline.core.entity.User", "/login.jsp" }))
@SetupBy(MvcSetup.class)
@Localization("msg")
@Fail("json")
public class MainModule {

}
