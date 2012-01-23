package com.kline.blconfirm.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;

import com.kline.blconfirm.entity.BlCustomerRef;
import com.kline.blconfirm.service.BlCustomerRefService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BlCustomerRefServiceImpl extends BaseIdEntityServiceImpl<BlCustomerRef> implements
		BlCustomerRefService {

	@Override
	public List<BlCustomerRef> findByMasterId(long blMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.where("blMasterId", "=", blMasterId), null);
	}

}
