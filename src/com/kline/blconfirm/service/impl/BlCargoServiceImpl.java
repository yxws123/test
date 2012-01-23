package com.kline.blconfirm.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;

import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.service.BlCargoService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BlCargoServiceImpl extends BaseIdEntityServiceImpl<BlCargo>
		implements BlCargoService {

//	@Override
//	public <T> T insert(T obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int update(Object obj) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <T> T getById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int deleteById(long id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public List<BlCargo> findByMasterId(long blMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.where("blMasterId", "=", blMasterId), null);
	}

}
