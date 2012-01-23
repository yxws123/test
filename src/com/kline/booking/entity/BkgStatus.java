package com.kline.booking.entity;

//import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgStatus")
public class BkgStatus extends BaseEntity {

	private static final long serialVersionUID = 538905857839729434L;

	@Id
	@Column
	private long bkgStatusId;
	
	@Column
	private long bkgMasterId;

	@Column
	private String status;

	@Column
	private Date statusTime;

	@Column
	private String statusUserId;

	public long getBkgMasterId() {
		return bkgMasterId;
	}

	public void setBkgMasterId(long bkgMasterId) {
		this.bkgMasterId = bkgMasterId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public String getStatusUserId() {
		return statusUserId;
	}

	public void setStatusUserId(String statusUserId) {
		this.statusUserId = statusUserId;
	}

	public long getBkgStatusId() {
		return bkgStatusId;
	}

	public void setBkgStatusId(long bkgStatusId) {
		this.bkgStatusId = bkgStatusId;
	}
}
