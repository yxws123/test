package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgCargo;
import com.kline.core.service.BaseIdEntityService;

public interface BkgCargoService extends BaseIdEntityService {

	public List<BkgCargo> findMyBkgCargo(long bkgMasterId);
}
