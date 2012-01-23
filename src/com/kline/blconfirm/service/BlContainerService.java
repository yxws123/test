package com.kline.blconfirm.service;

import java.util.List;

import com.kline.blconfirm.entity.BlContainer;
import com.kline.core.service.BaseIdEntityService;

public interface BlContainerService extends BaseIdEntityService {

	public List<BlContainer> findByMasterId(long blMasterId);
}
