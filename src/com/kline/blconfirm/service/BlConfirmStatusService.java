package com.kline.blconfirm.service;

import java.util.List;

import com.kline.blconfirm.entity.BlConfirmStatus;
import com.kline.core.service.BaseIdEntityService;

public interface BlConfirmStatusService extends BaseIdEntityService {

	public List<BlConfirmStatus> findByMasterId(long blMasterId);
}
