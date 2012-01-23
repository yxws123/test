package com.kline.core.entity;

//import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.*;
//import org.nutz.dao.tools.annotation.*;


@Table("tblUser")
public class User extends BaseEntity {

	private static final long serialVersionUID = -18721693532986308L;

	@Column
	@Name
	private String userId;
	
	@Column
	private String officeCode;
	
	@Column
	private String userType;
	
	@Column
	private String agentCode;

	@Column
	private String parentAgentCode;
	
	@Column
	private String role;
	
	@Column
	private String enabled;
	
	@Column
	private String email;
	
	@Column
	private String lastVisitIp;
	
	@Column
	private Date lastVisitTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastVisitIp() {
		return lastVisitIp;
	}

	public void setLastVisitIp(String lastVisitIp) {
		this.lastVisitIp = lastVisitIp;
	}

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}	
	
	public boolean isEnabled() {
		return "Y".equals(this.enabled);
	}
	
	public void setEnabled() {
		setEnabled("Y");
	}
	
	public void setDisabled() {
		setEnabled("N");		
	}
	
	public boolean isAgent() {
		return "A".equals(this.userType);
	}
	
	public boolean isDirectAgent() {
		return "D".equals(this.userType);
	}
	
	public boolean isInternalUser() {
		return "I".equals(this.userType);
	}
	
	public boolean isAdmin() {
		return "admin".equals(this.userId);
	}

	public String getParentAgentCode() {
		return parentAgentCode;
	}

	public void setParentAgentCode(String parentAgentCode) {
		this.parentAgentCode = parentAgentCode;
	}
}
