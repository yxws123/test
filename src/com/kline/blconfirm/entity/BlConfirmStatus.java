package com.kline.blconfirm.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLConfirmStatus")
public class BlConfirmStatus extends BaseEntity {

	private static final long serialVersionUID = 4077397916082066207L;

	@Id
	@Column("BLConfirmStatusId0")
	private long blConfirmStatusId;
	@Column("BLMasterId0")
	private long blMasterId;

	@Column("BLConfirmStatusTypeId")
	private int status;

	@Column
	private String comment;

	public long getBlConfirmStatusId() {
		return blConfirmStatusId;
	}

	public void setBlConfirmStatusId(long blConfirmStatusId) {
		this.blConfirmStatusId = blConfirmStatusId;
	}

	public long getBlMasterId() {
		return blMasterId;
	}

	public void setBlMasterId(long blMasterId) {
		this.blMasterId = blMasterId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
