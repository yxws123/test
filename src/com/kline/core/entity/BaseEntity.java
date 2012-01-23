package com.kline.core.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import com.kline.*;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1479954622357353923L;

	@Column
	private String valid;
	
	@Column
	private String creator;
	
	@Column
	private String modifier;
	
	@Column
	private Date dateCreated;
	
	@Column
	private Date lastModified;

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	public boolean isValid() {
		return Constants.YES.equals(this.valid);
	}
	
	public boolean isInvalid() {
		return Constants.NO.equals(this.valid);		
	}
	
	public void setValid() {
		this.setValid(Constants.YES);
	}
	
	public void setInvalid() {
		this.setValid(Constants.NO);
	}

	public void setNewInfo(String userCode) {
		this.setValid();
		this.setCreator(userCode);
		this.setModifier(userCode);
		this.setDateCreated(new Date());
		this.setLastModified(new Date());
	}
	
	public void setUpdateInfo(String userCode) {
		this.setModifier(userCode);
		this.setLastModified(new Date());		
	}
}
