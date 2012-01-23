package com.kline.blconfirm.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;

import com.kline.blconfirm.entity.BlCargo;
import com.kline.blconfirm.entity.BlConfirmStatus;
import com.kline.blconfirm.entity.BlContainer;
import com.kline.blconfirm.entity.BlCustomerRef;
import com.kline.blconfirm.entity.BlMarkNo;
import com.kline.blconfirm.entity.BlMaster;
import com.kline.blconfirm.entity.BlMasterA;
import com.kline.blconfirm.service.BlMasterService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BlMasterServiceImpl extends BaseIdEntityServiceImpl<BlMaster> implements
		BlMasterService {

	@Override
	public QueryResult findPage(int status, int pageNumber, int pageSize){
		// TODO Auto-generated method stub
		Pager pager = this.dao().createPager(pageNumber, pageSize);

		Condition cnd = null;
		if (status != 0) {
			cnd = Cnd.where("Status", "=", status);
		}
		List<BlMaster> list = this.query(cnd, pager);
		pager.setRecordCount(this.count(cnd));
		return new QueryResult(list, pager);
	}
	
	@Override
	public BlMaster getBLById(long blMasterId) {
		BlMaster bl = this.fetch(blMasterId);
		bl.setBlMasterA(this.dao().fetch(BlMasterA.class, blMasterId));

		bl.setBlCargoList(this.dao().query(BlCargo.class,
				Cnd.where("blMasterId", "=", blMasterId), null));
		bl.setBlMarkNoList(this.dao().query(BlMarkNo.class,
				Cnd.where("blMasterId", "=", blMasterId), null));
		bl.setBlContainerList(this.dao().query(BlContainer.class,
				Cnd.where("blMasterId", "=", blMasterId), null));
//		bl.setBlCustomerRefList(this.dao().query(BlCustomerRef.class,
//				Cnd.where("blMasterId", "=", blMasterId), null));
		// bl.setBlNoteList(this.dao().query(BlNote.class,
		// Cnd.where("BlMasterId", "=", blMasterId), null));
		bl.setBlConfirmStatusList(this.dao().query(BlConfirmStatus.class,
				Cnd.where("blMasterId", "=", blMasterId), null));

		return bl;
	}

}
