package com.kline.booking.entity;

import java.math.BigDecimal;
//import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgCargo")
public class BkgCargo extends BaseEntity {

	private static final long serialVersionUID = -7838800509369575318L;

	@Id
	@Column("BkgCargoId0")
	private long bkgCargoId;
	
	@Column
	private long bkgMasterId;
	
	@Column
	private int seq;
	
	@Column
	private String cargoTypeCode;
	
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
	private String flag;
	
	@Column
	private String dgClass;
	
	@Column
	private String dgPage;
	
	@Column
	private String dgNo;
	
	@Column
	private String dgLabel;
	
	@Column
	private String flashPoint;
	
	@Column
	private String emsNo;
	
	@Column
	private String mfgNo;
	
	@Column
	private String mpt;
	
	@Column
	private String emsContact;

	@Column
	private String rvf;
	
	@Column
	private String tempUnit;
	
	@Column
	private String tempSetting;
	
	@Column
	private String minTemp;
	
	@Column
	private String maxTemp;
	
	@Column
	private int overLenFront;
	
	@Column
	private int overLenBack;
	
	@Column
	private int overWidLeft;
	
	@Column
	private int overWidRight;
	
	@Column
	private int overHeight;
	
	@Column
	private String description;
	
	@Column
	private String cdescription;
	
//	@Column
	private String imdg;
	
//	@Column
	private String properShippingName;

//	@Column
	private String packingGroup;

//	@Column
	private String chemicalNameRequired;

	public long getBkgCargoId() {
		return bkgCargoId;
	}

	public void setBkgCargoId(long bkgCargoId) {
		this.bkgCargoId = bkgCargoId;
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

	public String getCargoTypeCode() {
		return cargoTypeCode;
	}

	public void setCargoTypeCode(String cargoTypeCode) {
		this.cargoTypeCode = cargoTypeCode;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDgClass() {
		return dgClass;
	}

	public void setDgClass(String dgClass) {
		this.dgClass = dgClass;
	}

	public String getDgPage() {
		return dgPage;
	}

	public void setDgPage(String dgPage) {
		this.dgPage = dgPage;
	}

	public String getDgNo() {
		return dgNo;
	}

	public void setDgNo(String dgNo) {
		this.dgNo = dgNo;
	}

	public String getDgLabel() {
		return dgLabel;
	}

	public void setDgLabel(String dgLabel) {
		this.dgLabel = dgLabel;
	}

	public String getFlashPoint() {
		return flashPoint;
	}

	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
	}

	public String getEmsNo() {
		return emsNo;
	}

	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}

	public String getMfgNo() {
		return mfgNo;
	}

	public void setMfgNo(String mfgNo) {
		this.mfgNo = mfgNo;
	}

	public String getMpt() {
		return mpt;
	}

	public void setMpt(String mpt) {
		this.mpt = mpt;
	}

	public String getEmsContact() {
		return emsContact;
	}

	public void setEmsContact(String emsContact) {
		this.emsContact = emsContact;
	}

	public String getRvf() {
		return rvf;
	}

	public void setRvf(String rvf) {
		this.rvf = rvf;
	}

	public String getTempUnit() {
		return tempUnit;
	}

	public void setTempUnit(String tempUnit) {
		this.tempUnit = tempUnit;
	}

	public String getTempSetting() {
		return tempSetting;
	}

	public void setTempSetting(String tempSetting) {
		this.tempSetting = tempSetting;
	}

	public String getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	public String getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getOverLenFront() {
		return overLenFront;
	}

	public void setOverLenFront(int overLenFront) {
		this.overLenFront = overLenFront;
	}

	public int getOverLenBack() {
		return overLenBack;
	}

	public void setOverLenBack(int overLenBack) {
		this.overLenBack = overLenBack;
	}

	public int getOverWidLeft() {
		return overWidLeft;
	}

	public void setOverWidLeft(int overWidLeft) {
		this.overWidLeft = overWidLeft;
	}

	public int getOverWidRight() {
		return overWidRight;
	}

	public void setOverWidRight(int overWidRight) {
		this.overWidRight = overWidRight;
	}

	public int getOverHeight() {
		return overHeight;
	}

	public void setOverHeight(int overHeight) {
		this.overHeight = overHeight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public String getImdg() {
		return imdg;
	}

	public void setImdg(String imdg) {
		this.imdg = imdg;
	}

	public String getProperShippingName() {
		return properShippingName;
	}

	public void setProperShippingName(String properShippingName) {
		this.properShippingName = properShippingName;
	}

	public String getPackingGroup() {
		return packingGroup;
	}

	public void setPackingGroup(String packingGroup) {
		this.packingGroup = packingGroup;
	}

	public String getChemicalNameRequired() {
		return chemicalNameRequired;
	}

	public void setChemicalNameRequired(String chemicalNameRequired) {
		this.chemicalNameRequired = chemicalNameRequired;
	}

}
