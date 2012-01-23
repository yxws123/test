package com.kline.booking.entity;

import java.math.BigDecimal;
//import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgContainer")
public class BkgContainer extends BaseEntity {

	private static final long serialVersionUID = -8391767227926096953L;

	@Id
	@Column
	private long bkgContainerId;
	
	@Column
	private long bkgMasterId;
	
	@Column
	private int Seq;
	
	@Column
	private int noOfPkg;
	
	@Column
	private String ContainerNo;
	  
	@Column
	private String SealNo;
	
	@Column
	private BigDecimal grossMeas;
	
	@Column
	private BigDecimal grossWt;

	@Column
	private String containerType;
	
	@Column
	private String containerSize;
	
	@Column
	private String containerHeight;

	public long getBkgContainerId() {
		return bkgContainerId;
	}

	public void setBkgContainerId(long bkgContainerId) {
		this.bkgContainerId = bkgContainerId;
	}

	public long getBkgMasterId() {
		return bkgMasterId;
	}

	public void setBkgMasterId(long bkgMasterId) {
		this.bkgMasterId = bkgMasterId;
	}

	public int getSeq() {
		return Seq;
	}

	public void setSeq(int seq) {
		Seq = seq;
	}

	public int getNoOfPkg() {
		return noOfPkg;
	}

	public void setNoOfPkg(int noOfPkg) {
		this.noOfPkg = noOfPkg;
	}

	public String getContainerNo() {
		return ContainerNo;
	}

	public void setContainerNo(String containerNo) {
		ContainerNo = containerNo;
	}

	public String getSealNo() {
		return SealNo;
	}

	public void setSealNo(String sealNo) {
		SealNo = sealNo;
	}

	public BigDecimal getGrossMeas() {
		return grossMeas;
	}

	public void setGrossMeas(BigDecimal grossMeas) {
		this.grossMeas = grossMeas;
	}

	public BigDecimal getGrossWt() {
		return grossWt;
	}

	public void setGrossWt(BigDecimal grossWt) {
		this.grossWt = grossWt;
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
	  
}
