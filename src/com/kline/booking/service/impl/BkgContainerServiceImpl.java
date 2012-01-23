package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgContainer;
import com.kline.booking.service.BkgContainerService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgContainerServiceImpl extends BaseIdEntityServiceImpl<BkgContainer> implements
		BkgContainerService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgContainerId=" + id);
//	}
	
	@Override
	public List<BkgContainer> findMyBkgContainer(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}

}
