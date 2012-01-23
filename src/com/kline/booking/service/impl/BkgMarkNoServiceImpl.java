package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgMarkNo;
import com.kline.booking.service.BkgMarkNoService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgMarkNoServiceImpl extends BaseIdEntityServiceImpl<BkgMarkNo> implements
		BkgMarkNoService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgMarkNoId=" + id);
//	}
	
	@Override
	public List<BkgMarkNo> findMyBkgMarkNo(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}

}
