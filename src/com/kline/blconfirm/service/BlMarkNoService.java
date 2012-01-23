package com.kline.blconfirm.service;

import java.util.List;

import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.core.service.BaseIdEntityService;

public interface BlMarkNoService extends BaseIdEntityService {

	public List<BlMarkNo> findByMasterId(long blMasterId);
}
