package com.kline.booking.entity;

//import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgCtrOfBkg")
public class BkgCtrOfBkg extends BaseEntity {

	private static final long serialVersionUID = -6073230377457083821L;

	@Id
	@Column
	private long bkgCtrOfBkgId;
	
	@Column
	private long bkgMasterId;
	
	@Column
	private int seq;
	
	@Column
	private int noOfCtr;
	
	@Column
	private String soc;

//	@Column
	private String status;
	
//	@Column
	private String masterLclNo;

	@Column
	private String containerType;
	
	@Column
	private String containerSize;
	
	@Column
	private String containerHeight;

//	@Column
	private String reeferAsDry;

	public long getBkgCtrOfBkgId() {
		return bkgCtrOfBkgId;
	}

	public void setBkgCtrOfBkgId(long bkgCtrOfBkgId) {
		this.bkgCtrOfBkgId = bkgCtrOfBkgId;
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

	public int getNoOfCtr() {
		return noOfCtr;
	}

	public void setNoOfCtr(int noOfCtr) {
		this.noOfCtr = noOfCtr;
	}

	public String getSoc() {
		return soc;
	}

	public void setSoc(String soc) {
		this.soc = soc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMasterLclNo() {
		return masterLclNo;
	}

	public void setMasterLclNo(String masterLclNo) {
		this.masterLclNo = masterLclNo;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}

	public String getContainerHeight() {
		return containerHeight;
	}

	public void setContainerHeight(String containerHeight) {
		this.containerHeight = containerHeight;
	}

	public String getReeferAsDry() {
		return reeferAsDry;
	}

	public void setReeferAsDry(String reeferAsDry) {
		this.reeferAsDry = reeferAsDry;
	}
}
