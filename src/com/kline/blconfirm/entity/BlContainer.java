package com.kline.blconfirm.entity;

import java.math.BigDecimal;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLContainer")
public class BlContainer extends BaseEntity {

	private static final long serialVersionUID = 1729235110213062318L;

	@Id
	@Column("BLContainerId0")
	private long blContainerId;
	@Column("BLMasterId0")
	private long blMasterId;

	@Column
	private String blno;
	@Column
	private int seq;
	@Column
	private String containerNo;
	@Column
	private String sealNo1;
	@Column
	private String sealNo2;
	@Column
	private String sealNo3;
	@Column
	private int qty;
	@Column
	private String pkgTypeCode;
	@Column
	private String pkgTypeName;
	@Column
	private BigDecimal grossWt;
	@Column
	private BigDecimal grossMeas;
	@Column
	private String recTypeCode;
	@Column
	private String delTypeCode;
	@Column
	private String containerType;
	@Column
	private String containerSize;
	@Column
	private String containerHeight;
	@Column
	private String flag;
	@Column
	private String containerNoFlag;
	@Column
	private String sealNo1Flag;
	@Column
	private String sealNo2Flag;
	@Column
	private String sealNo3Flag;
	@Column
	private String qtyFlag;
	@Column
	private String pkgTypeCodeFlag;
	@Column
	private String grossWtFlag;
	@Column
	private String grossMeasFlag;
	@Column
	private String recTypeCodeFlag;
	@Column
	private String delTypeCodeFlag;
	@Column
	private String containerTypeFlag;

	@Column
	private String ctrNoValid;
	@Column
	private String cisCtrType;
	@Column
	private String cisCtrSize;
	@Column
	private String cisCtrHeight;

	public long getBlContainerId() {
		return blContainerId;
	}

	public void setBlContainerId(long blContainerId) {
		this.blContainerId = blContainerId;
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

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public String getSealNo1() {
		return sealNo1;
	}

	public void setSealNo1(String sealNo1) {
		this.sealNo1 = sealNo1;
	}

	public String getSealNo2() {
		return sealNo2;
	}

	public void setSealNo2(String sealNo2) {
		this.sealNo2 = sealNo2;
	}

	public String getSealNo3() {
		return sealNo3;
	}

	public void setSealNo3(String sealNo3) {
		this.sealNo3 = sealNo3;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPkgTypeCode() {
		return pkgTypeCode;
	}

	public void setPkgTypeCode(String pkgTypeCode) {
		this.pkgTypeCode = pkgTypeCode;
	}

	public String getPkgTypeName() {
		return pkgTypeName;
	}

	public void setPkgTypeName(String pkgTypeName) {
		this.pkgTypeName = pkgTypeName;
	}

	public BigDecimal getGrossWt() {
		return grossWt;
	}

	public void setGrossWt(BigDecimal grossWt) {
		this.grossWt = grossWt;
	}

	public BigDecimal getGrossMeas() {
		return grossMeas;
	}

	public void setGrossMeas(BigDecimal grossMeas) {
		this.grossMeas = grossMeas;
	}

	public String getRecTypeCode() {
		return recTypeCode;
	}

	public void setRecTypeCode(String recTypeCode) {
		this.recTypeCode = recTypeCode;
	}

	public String getDelTypeCode() {
		return delTypeCode;
	}

	public void setDelTypeCode(String delTypeCode) {
		this.delTypeCode = delTypeCode;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getContainerNoFlag() {
		return containerNoFlag;
	}

	public void setContainerNoFlag(String containerNoFlag) {
		this.containerNoFlag = containerNoFlag;
	}

	public String getSealNo1Flag() {
		return sealNo1Flag;
	}

	public void setSealNo1Flag(String sealNo1Flag) {
		this.sealNo1Flag = sealNo1Flag;
	}

	public String getSealNo2Flag() {
		return sealNo2Flag;
	}

	public void setSealNo2Flag(String sealNo2Flag) {
		this.sealNo2Flag = sealNo2Flag;
	}

	public String getSealNo3Flag() {
		return sealNo3Flag;
	}

	public void setSealNo3Flag(String sealNo3Flag) {
		this.sealNo3Flag = sealNo3Flag;
	}

	public String getQtyFlag() {
		return qtyFlag;
	}

	public void setQtyFlag(String qtyFlag) {
		this.qtyFlag = qtyFlag;
	}

	public String getPkgTypeCodeFlag() {
		return pkgTypeCodeFlag;
	}

	public void setPkgTypeCodeFlag(String pkgTypeCodeFlag) {
		this.pkgTypeCodeFlag = pkgTypeCodeFlag;
	}

	public String getGrossWtFlag() {
		return grossWtFlag;
	}

	public void setGrossWtFlag(String grossWtFlag) {
		this.grossWtFlag = grossWtFlag;
	}

	public String getGrossMeasFlag() {
		return grossMeasFlag;
	}

	public void setGrossMeasFlag(String grossMeasFlag) {
		this.grossMeasFlag = grossMeasFlag;
	}

	public String getRecTypeCodeFlag() {
		return recTypeCodeFlag;
	}

	public void setRecTypeCodeFlag(String recTypeCodeFlag) {
		this.recTypeCodeFlag = recTypeCodeFlag;
	}

	public String getDelTypeCodeFlag() {
		return delTypeCodeFlag;
	}

	public void setDelTypeCodeFlag(String delTypeCodeFlag) {
		this.delTypeCodeFlag = delTypeCodeFlag;
	}

	public String getContainerTypeFlag() {
		return containerTypeFlag;
	}

	public void setContainerTypeFlag(String containerTypeFlag) {
		this.containerTypeFlag = containerTypeFlag;
	}

	public String getCtrNoValid() {
		return ctrNoValid;
	}

	public void setCtrNoValid(String ctrNoValid) {
		this.ctrNoValid = ctrNoValid;
	}

	public String getCisCtrType() {
		return cisCtrType;
	}

	public void setCisCtrType(String cisCtrType) {
		this.cisCtrType = cisCtrType;
	}

	public String getCisCtrSize() {
		return cisCtrSize;
	}

	public void setCisCtrSize(String cisCtrSize) {
		this.cisCtrSize = cisCtrSize;
	}

	public String getCisCtrHeight() {
		return cisCtrHeight;
	}

	public void setCisCtrHeight(String cisCtrHeight) {
		this.cisCtrHeight = cisCtrHeight;
	}

}
