package com.kline.blconfirm.service;

import java.util.List;

import com.kline.blconfirm.entity.BlCargo;
import com.kline.core.service.BaseIdEntityService;

public interface BlCargoService extends BaseIdEntityService {

	public List<BlCargo> findByMasterId(long blMasterId);
}
