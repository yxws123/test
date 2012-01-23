package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgCtrOfBkg;
import com.kline.booking.service.BkgCtrOfBkgService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgCtrOfBkgServiceImpl extends BaseIdEntityServiceImpl<BkgCtrOfBkg> implements
		BkgCtrOfBkgService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgCtrOfBkgId=" + id);
//	}
	
	@Override
	public List<BkgCtrOfBkg> findMyBkgCtrOfBkg(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}

}
