package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgStatus;
import com.kline.booking.service.BkgStatusService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgStatusServiceImpl extends BaseIdEntityServiceImpl<BkgStatus> implements
		BkgStatusService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgStatusId=" + id);
//	}
	
	@Override
	public List<BkgStatus> findMyBkgStatus(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}

}
