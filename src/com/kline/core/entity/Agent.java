package com.kline.core.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("tblAgent")
public class Agent extends BaseEntity {

	private static final long serialVersionUID = -8847582084992319885L;

	@Column
	@Name
	private String agentCode;
	
	@Column
	private String officeCode;

	@Column
	private String parentAgentCode;

	@Column
	private String agentName;
	
	@Column
	private String email;
	
	@Column
	private String contact;

	@Column
	private String bookingReference;

	@Column
	private String emailNotice4BkgAccepted;
	
	@Column
	private String emailNotice4BkgRejected;

	@Column
	private String emailNotice4CNCPSEnabled;

	@Column
	private String directBookingFlag;

	@Column
	private String address;

	@Column
	private String tel;

	@Column
	private String fax;
	
	@Column
	private String agentType;

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	/**
	 * @return
	 */
	public String getBookingReference() {
		return bookingReference;
	}

	/**
	 * @param string
	 */
	public void setBookingReference(String string) {
		bookingReference = string;
	}

	public String[] getEmails() {
		if (null == getEmail() || "".equals(getEmail().trim())) {
			return null;
		}
		return getEmail().split(";");
	}

	/**
	 * @return
	 */
	public String getEmailNotice4BkgAccepted() {
		return emailNotice4BkgAccepted;
	}

	/**
	 * @return
	 */
	public String getEmailNotice4BkgRejected() {
		return emailNotice4BkgRejected;
	}

	/**
	 * @param string
	 */
	public void setEmailNotice4BkgAccepted(String string) {
		emailNotice4BkgAccepted = string;
	}

	/**
	 * @param string
	 */
	public void setEmailNotice4BkgRejected(String string) {
		emailNotice4BkgRejected = string;
	}

	public String getEmailNotice4CNCPSEnabled() {
		return emailNotice4CNCPSEnabled;
	}

	public void setEmailNotice4CNCPSEnabled(String emailNotice4CNCPSEnabled) {
		this.emailNotice4CNCPSEnabled = emailNotice4CNCPSEnabled;
	}

//	public boolean isEmailNotice4CNCPSEnabled() {
//		return "Y".equals(this.emailNotice4CNCPSEnabled);
//	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getParentAgentCode() {
		return parentAgentCode;
	}

	public void setParentAgentCode(String parentAgentCode) {
		this.parentAgentCode = parentAgentCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public boolean isEmailNotice4BkgAccepted() {
		return "Y".equals(this.emailNotice4BkgAccepted);
	}
	
	public boolean isEmailNotice4BkgRejected() {
		return "Y".equals(this.emailNotice4BkgRejected);
	}

	public boolean isEmailNotice4CNCPSEnabled() {
		return "Y".equals(this.emailNotice4CNCPSEnabled);
	}

	public boolean isDirectBooking() {
		return "Y".equals(this.directBookingFlag);
	}

	public String getDirectBookingFlag() {
		return directBookingFlag;
	}

	public void setDirectBookingFlag(String directBookingFlag) {
		this.directBookingFlag = directBookingFlag;
	}
	
	public void setDirectBooking() {
		setDirectBookingFlag("Y");
	}
	
	public void setNotDirectBooking() {
		setDirectBookingFlag("N");		
	}
}