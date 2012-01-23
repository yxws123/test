package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgStatus;
import com.kline.core.service.BaseIdEntityService;

public interface BkgStatusService extends BaseIdEntityService {

	public List<BkgStatus> findMyBkgStatus(long bkgMasterId);
}
