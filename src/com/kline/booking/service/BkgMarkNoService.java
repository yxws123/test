package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgMarkNo;
import com.kline.core.service.BaseIdEntityService;

public interface BkgMarkNoService extends BaseIdEntityService {

	public List<BkgMarkNo> findMyBkgMarkNo(long bkgMasterId);
}
