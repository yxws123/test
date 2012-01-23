package com.kline.blconfirm.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;

import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.blconfirm.service.BlMarkNoService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BlMarkNoServiceImpl extends BaseIdEntityServiceImpl<BlMarkNo> implements
		BlMarkNoService {

	@Override
	public List<BlMarkNo> findByMasterId(long blMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.where("blMasterId", "=", blMasterId), null);
	}

}
