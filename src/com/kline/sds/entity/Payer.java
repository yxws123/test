package com.kline.sds.entity;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

//import com.kline.core.entity.BaseEntity;

@Table("MPayer")
public class Payer implements Serializable {

	private static final long serialVersionUID = 3232763204511687033L;

	@Column
	@Name
	private String payerCode;

	@Column
	private String payerName;

	@Column
	private String payerCName;

	@Column
	private String bookingReference;
	
	@Column
	private String office;

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerCName() {
		return payerCName;
	}

	public void setPayerCName(String payerCName) {
		this.payerCName = payerCName;
	}

	public String getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}	

}