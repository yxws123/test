package com.kline.booking.entity;

//import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
//import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgMarkNo")
public class BkgMarkNo extends BaseEntity {

	private static final long serialVersionUID = -824749691506633125L;

	@Column
	private long bkgMarkNoId;

	@Column
	private long bkgMasterId;
	
	@Column
	private int seq;
	
	@Column
	private String markNo;

	public long getBkgMarkNoId() {
		return bkgMarkNoId;
	}

	public void setBkgMarkNoId(long bkgMarkNoId) {
		this.bkgMarkNoId = bkgMarkNoId;
	}

	public long getBkgMasterId() {
		return bkgMasterId;
	}

	public void setBkgMasterId(long bkgMasterId) {
		this.bkgMasterId = bkgMasterId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMarkNo() {
		return markNo;
	}

	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}
}
