package com.kline.blconfirm.service;

import java.util.List;

import com.kline.blconfirm.entity.BlCustomerRef;
import com.kline.core.service.BaseIdEntityService;

public interface BlCustomerRefService extends BaseIdEntityService {

	public List<BlCustomerRef> findByMasterId(long blMasterId);
}
