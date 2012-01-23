package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgContainer;
import com.kline.core.service.BaseIdEntityService;

public interface BkgContainerService extends BaseIdEntityService {

	public List<BkgContainer> findMyBkgContainer(long bkgMasterId);
}
