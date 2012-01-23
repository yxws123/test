package com.kline.blconfirm.entity;

import java.math.BigDecimal;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLCargo")
public class BlCargo extends BaseEntity {

	private static final long serialVersionUID = -3628827654375982268L;

	@Id
	@Column("BLCargoId0")
	private long blCargoId;
	@Column("BLMasterId0")
	private long blMasterId;
	@Column
	private String blno;
	@Column
	private int seq;
	@Column
	private int innerQty;
	@Column
	private String innerPkgTypeCode;
	@Column
	private String innerPkgTypeName;
	@Column
	private int outerQty;
	@Column
	private String outerPkgTypeCode;
	@Column
	private String outerPkgTypeName;
	@Column
	private BigDecimal grossWt;
	@Column
	private BigDecimal grossMeas;
	@Column
	private BigDecimal netWt;
	@Column
	private BigDecimal netMeas;
	@Column
	private String commodityTypeCode;
	@Column
	private String description;

	@Column
	private String flag;
	@Column
	private String commodityTypeCodeFlag;
	@Column
	private String innerQtyFlag;
	@Column
	private String innerPkgTypeCodeFlag;
	@Column
	private String outerQtyFlag;
	@Column
	private String outerPkgTypeCodeFlag;
	@Column
	private String grossWtFlag;
	@Column
	private String grossMeasFlag;
	@Column
	private String netWtFlag;
	@Column
	private String netMeasFlag;
	@Column
	private String descFlag;

	@Column
	private String hsCode;

	@Column
	private String hsCodeFlag;

	public long getBlCargoId() {
		return blCargoId;
	}

	public void setBlCargoId(long blCargoId) {
		this.blCargoId = blCargoId;
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

	public int getInnerQty() {
		return innerQty;
	}

	public void setInnerQty(int innerQty) {
		this.innerQty = innerQty;
	}

	public String getInnerPkgTypeCode() {
		return innerPkgTypeCode;
	}

	public void setInnerPkgTypeCode(String innerPkgTypeCode) {
		this.innerPkgTypeCode = innerPkgTypeCode;
	}

	public String getInnerPkgTypeName() {
		return innerPkgTypeName;
	}

	public void setInnerPkgTypeName(String innerPkgTypeName) {
		this.innerPkgTypeName = innerPkgTypeName;
	}

	public int getOuterQty() {
		return outerQty;
	}

	public void setOuterQty(int outerQty) {
		this.outerQty = outerQty;
	}

	public String getOuterPkgTypeCode() {
		return outerPkgTypeCode;
	}

	public void setOuterPkgTypeCode(String outerPkgTypeCode) {
		this.outerPkgTypeCode = outerPkgTypeCode;
	}

	public String getOuterPkgTypeName() {
		return outerPkgTypeName;
	}

	public void setOuterPkgTypeName(String outerPkgTypeName) {
		this.outerPkgTypeName = outerPkgTypeName;
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

	public BigDecimal getNetWt() {
		return netWt;
	}

	public void setNetWt(BigDecimal netWt) {
		this.netWt = netWt;
	}

	public BigDecimal getNetMeas() {
		return netMeas;
	}

	public void setNetMeas(BigDecimal netMeas) {
		this.netMeas = netMeas;
	}

	public String getCommodityTypeCode() {
		return commodityTypeCode;
	}

	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCommodityTypeCodeFlag() {
		return commodityTypeCodeFlag;
	}

	public void setCommodityTypeCodeFlag(String commodityTypeCodeFlag) {
		this.commodityTypeCodeFlag = commodityTypeCodeFlag;
	}

	public String getInnerQtyFlag() {
		return innerQtyFlag;
	}

	public void setInnerQtyFlag(String innerQtyFlag) {
		this.innerQtyFlag = innerQtyFlag;
	}

	public String getInnerPkgTypeCodeFlag() {
		return innerPkgTypeCodeFlag;
	}

	public void setInnerPkgTypeCodeFlag(String innerPkgTypeCodeFlag) {
		this.innerPkgTypeCodeFlag = innerPkgTypeCodeFlag;
	}

	public String getOuterQtyFlag() {
		return outerQtyFlag;
	}

	public void setOuterQtyFlag(String outerQtyFlag) {
		this.outerQtyFlag = outerQtyFlag;
	}

	public String getOuterPkgTypeCodeFlag() {
		return outerPkgTypeCodeFlag;
	}

	public void setOuterPkgTypeCodeFlag(String outerPkgTypeCodeFlag) {
		this.outerPkgTypeCodeFlag = outerPkgTypeCodeFlag;
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

	public String getNetWtFlag() {
		return netWtFlag;
	}

	public void setNetWtFlag(String netWtFlag) {
		this.netWtFlag = netWtFlag;
	}

	public String getNetMeasFlag() {
		return netMeasFlag;
	}

	public void setNetMeasFlag(String netMeasFlag) {
		this.netMeasFlag = netMeasFlag;
	}

	public String getDescFlag() {
		return descFlag;
	}

	public void setDescFlag(String descFlag) {
		this.descFlag = descFlag;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	public String getHsCodeFlag() {
		return hsCodeFlag;
	}

	public void setHsCodeFlag(String hsCodeFlag) {
		this.hsCodeFlag = hsCodeFlag;
	}
}
