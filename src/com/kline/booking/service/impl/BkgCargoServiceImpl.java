package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgCargo;
import com.kline.booking.service.BkgCargoService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgCargoServiceImpl extends BaseIdEntityServiceImpl<BkgCargo> implements
		BkgCargoService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgCargoId=" + id);
//	}
	
	@Override
	public List<BkgCargo> findMyBkgCargo(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}	

}
