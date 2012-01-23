package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;

import com.kline.booking.entity.BkgNote;
import com.kline.booking.service.BkgNoteService;
import com.kline.core.service.impl.BaseIdEntityServiceImpl;

public class BkgNoteServiceImpl extends BaseIdEntityServiceImpl<BkgNote> implements
		BkgNoteService {

//	protected Condition getCnd4DeleteById(long id) {
//		return Cnd.wrap("BkgNoteId=" + id);
//	}
	
	@Override
	public List<BkgNote> findMyBkgNote(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.query(Cnd.wrap("BkgMasterId=" + bkgMasterId), null);
	}

}
