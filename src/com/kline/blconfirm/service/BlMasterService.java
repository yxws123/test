package com.kline.blconfirm.service;

import java.util.List;

import org.nutz.dao.QueryResult;

import com.kline.blconfirm.entity.BlMaster;
import com.kline.core.service.BaseIdEntityService;

public interface BlMasterService extends BaseIdEntityService {

	public QueryResult findPage(int status, int pageNumber, int pageSize);
	
	public BlMaster getBLById(long blMasterId);
	
//	public void insertBL(BlMaster blMaster);
	
//	public void deleteBL(BLMaster blMaster);
}
