package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgCtrOfBkg;
import com.kline.core.service.BaseIdEntityService;

public interface BkgCtrOfBkgService extends BaseIdEntityService {

	public List<BkgCtrOfBkg> findMyBkgCtrOfBkg(long bkgMasterId);
}
