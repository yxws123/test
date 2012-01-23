package com.kline.booking.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.service.IdEntityService;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
//import org.nutz.service.NameEntityService;

import com.kline.booking.entity.BkgCargo;
import com.kline.booking.entity.BkgContainer;
import com.kline.booking.entity.BkgCtrOfBkg;
import com.kline.booking.entity.BkgMarkNo;
import com.kline.booking.entity.BkgMaster;
import com.kline.booking.entity.BkgMasterA;
import com.kline.booking.entity.BkgNote;
import com.kline.booking.entity.BkgStatus;
import com.kline.booking.service.BookingService;

public class BookingServiceImpl extends IdEntityService<BkgMaster> implements
		BookingService {

	@Override
	public QueryResult findPage(String status, int pageNumber, int pageSize) {
		Pager pager = this.dao().createPager(pageNumber, pageSize);

		Condition cnd = null;
		if (null != status && !"".equals(status)) {
			cnd = Cnd.where("Status", "=", status);
		}
		List<BkgMaster> list = this.query(cnd, pager);
		pager.setRecordCount(this.count(cnd));
		return new QueryResult(list, pager);
	}

	// Booking
	@Override
	public BkgMaster getBookingById(long bkgMasterId) {
		BkgMaster booking = this.fetch(bkgMasterId);
		booking.setBkgMasterA(this.dao().fetch(BkgMasterA.class, bkgMasterId));

		booking.setBkgCargoList(this.dao().query(BkgCargo.class,
				Cnd.where("BkgMasterId", "=", bkgMasterId), null));
		booking.setBkgMarkNoList(this.dao().query(BkgMarkNo.class,
				Cnd.where("BkgMasterId", "=", bkgMasterId), null));
		booking.setBkgCtrOfBkgList(this.dao().query(BkgCtrOfBkg.class,
				Cnd.where("BkgMasterId", "=", bkgMasterId), null));
		booking.setBkgContainerList(this.dao().query(BkgContainer.class,
				Cnd.where("BkgMasterId", "=", bkgMasterId), null));
		// booking.setBkgNoteList(this.dao().query(BkgNote.class,
		// Cnd.where("BkgMasterId", "=", bkgMasterId), null));
		booking.setBkgStatusList(this.dao().query(BkgStatus.class,
				Cnd.where("BkgMasterId", "=", bkgMasterId), null));

		return booking;

	}

	@Override
	public void insertBooking(BkgMaster bkgMaster) {
		// TODO Auto-generated method stub
		this.dao().insert(bkgMaster);
	}

	@Override
	public void deleteBookingById(final long bkgMasterId) {
		// TODO Auto-generated method stub

		Trans.exec(new Atom(){
			public void run() {
				dao().clear(BkgStatus.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
//				dao().clear(BkgNote.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().clear(BkgContainer.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().clear(BkgCtrOfBkg.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().clear(BkgMarkNo.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().clear(BkgCargo.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().clear(BkgMasterA.class, Cnd.wrap("BkgMasterId=" + bkgMasterId));
				dao().delete(BkgMaster.class, bkgMasterId);							
			}
		});
		
	}

	// BkgMaster

	@Override
	public BkgMaster getBkgMasterById(long bkgMasterId) {
		// TODO Auto-generated method stub
		return this.fetch(bkgMasterId);
	}

	@Override
	public void updateBkgMaster(BkgMaster bkgMaster) {
		// TODO Auto-generated method stub
		this.dao().update(bkgMaster);
	}

	@Override
	public BkgMaster getBkgMasterAById(long bkgMasterId) {
		// TODO Auto-generated method stub

		BkgMaster bkgMaster = this.fetch(bkgMasterId);
		bkgMaster
				.setBkgMasterA(this.dao().fetch(BkgMasterA.class, bkgMasterId));

		return bkgMaster;

	}

	@Override
	public void updateBkgMasterA(BkgMaster bkgMaster) {
		// TODO Auto-generated method stub
		this.dao().update(bkgMaster);
		this.dao().update(bkgMaster.getBkgMasterA());
	}

}
