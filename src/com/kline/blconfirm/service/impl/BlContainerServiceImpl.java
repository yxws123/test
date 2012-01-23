package com.kline.blconfirm.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;

import com.kline.blconfirm.entity.BlContainer;
import com.kline.blconfirm.service.BlContainerService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BlContainerServiceImpl extends BaseIdEntityServiceImpl<BlContainer> implements
		BlContainerService {

	@Override
	public List<BlContainer> findByMasterId(long blMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.where("blMasterId", "=", blMasterId), null);
	}

}
