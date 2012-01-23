package com.kline.blconfirm.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLMarkNo")
public class BlMarkNo extends BaseEntity {

	private static final long serialVersionUID = -1973107504062700239L;

	@Id
	@Column("BLMarkNoId0")
	private long blMarkNoId;
	@Column("BLMasterId0")
	private long blMasterId;
	@Column
	private String blno;
	@Column
	private int seq;
	@Column
	private String markNo;

	@Column
	private String markNoFlag;
	@Column
	private String flag;

	public long getBlMarkNoId() {
		return blMarkNoId;
	}

	public void setBlMarkNoId(long blMarkNoId) {
		this.blMarkNoId = blMarkNoId;
	}

	public long getBlMasterId() {
		return blMasterId;
	}

	public void setBlMasterId(long blMasterId) {
		this.blMasterId = blMasterId;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
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

	public String getMarkNoFlag() {
		return markNoFlag;
	}

	public void setMarkNoFlag(String markNoFlag) {
		this.markNoFlag = markNoFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
