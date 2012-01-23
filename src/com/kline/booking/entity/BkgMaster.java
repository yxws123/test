package com.kline.booking.entity;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgMasterA")
public class BkgMaster extends BaseEntity {

	private static final long serialVersionUID = -1528942251115284239L;

	@Id
	@Column
	private long bkgMasterId;

	@Column
	private String blno;

	@Column
	private String shipperRefNo;

	@Column
	private String oceanVesselCode;

	@Column
	private String oceanVesselName;

	@Column
	private String oceanVoyage;

	@Column
	private String oceanBound;

	@Column
	private String serviceCode;

	@Column
	private Date sailingDate;

	@Column
	private String directAgentCode;

	@Column
	private String agentCode;

	@Column
	private Integer masterLclId;

	@Column
	private String fullLclFlag;

	@Column
	private String masterLclNo;

	@Column
	private String officeCode;

	@Column
	private String status;

	@Column
	private Date statusTime;

	@Column
	private String statusUserId;

	@Column
	private String placeCodeOfDelivery;

	@Column
	private String placeNameOfDelivery;

	public long getBkgMasterId() {
		return bkgMasterId;
	}

	public void setBkgMasterId(long bkgMasterId) {
		this.bkgMasterId = bkgMasterId;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
	}

	public String getShipperRefNo() {
		return shipperRefNo;
	}

	public void setShipperRefNo(String shipperRefNo) {
		this.shipperRefNo = shipperRefNo;
	}

	public String getOceanVesselCode() {
		return oceanVesselCode;
	}

	public void setOceanVesselCode(String oceanVesselCode) {
		this.oceanVesselCode = oceanVesselCode;
	}

	public String getOceanVesselName() {
		return oceanVesselName;
	}

	public void setOceanVesselName(String oceanVesselName) {
		this.oceanVesselName = oceanVesselName;
	}

	public String getOceanVoyage() {
		return oceanVoyage;
	}

	public void setOceanVoyage(String oceanVoyage) {
		this.oceanVoyage = oceanVoyage;
	}

	public String getOceanBound() {
		return oceanBound;
	}

	public void setOceanBound(String oceanBound) {
		this.oceanBound = oceanBound;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Date getSailingDate() {
		return sailingDate;
	}

	public void setSailingDate(Date sailingDate) {
		this.sailingDate = sailingDate;
	}

	public String getDirectAgentCode() {
		return directAgentCode;
	}

	public void setDirectAgentCode(String directAgentCode) {
		this.directAgentCode = directAgentCode;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public Integer getMasterLclId() {
		return masterLclId;
	}

	public void setMasterLclId(Integer masterLclId) {
		this.masterLclId = masterLclId;
	}

	public String getFullLclFlag() {
		return fullLclFlag;
	}

	public void setFullLclFlag(String fullLclFlag) {
		this.fullLclFlag = fullLclFlag;
	}

	public String getMasterLclNo() {
		return masterLclNo;
	}

	public void setMasterLclNo(String masterLclNo) {
		this.masterLclNo = masterLclNo;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public String getStatusUserId() {
		return statusUserId;
	}

	public void setStatusUserId(String statusUserId) {
		this.statusUserId = statusUserId;
	}

	public String getPlaceCodeOfDelivery() {
		return placeCodeOfDelivery;
	}

	public void setPlaceCodeOfDelivery(String placeCodeOfDelivery) {
		this.placeCodeOfDelivery = placeCodeOfDelivery;
	}

	public String getPlaceNameOfDelivery() {
		return placeNameOfDelivery;
	}

	public void setPlaceNameOfDelivery(String placeNameOfDelivery) {
		this.placeNameOfDelivery = placeNameOfDelivery;
	}
	
	private BkgMasterA bkgMasterA;

	public BkgMasterA getBkgMasterA() {
		return bkgMasterA;
	}

	public void setBkgMasterA(BkgMasterA bkgMasterA) {
		this.bkgMasterA = bkgMasterA;
	}
	
	private List<BkgCargo> bkgCargoList;
	private List<BkgMarkNo> bkgMarkNoList;
	private List<BkgCtrOfBkg> bkgCtrOfBkgList;
	private List<BkgContainer> bkgContainerList;
	private List<BkgNote> bkgNoteList;
	private List<BkgStatus> bkgStatusList;

	public List<BkgCargo> getBkgCargoList() {
		return bkgCargoList;
	}

	public void setBkgCargoList(List<BkgCargo> bkgCargoList) {
		this.bkgCargoList = bkgCargoList;
	}

	public List<BkgMarkNo> getBkgMarkNoList() {
		return bkgMarkNoList;
	}

	public void setBkgMarkNoList(List<BkgMarkNo> bkgMarkNoList) {
		this.bkgMarkNoList = bkgMarkNoList;
	}

	public List<BkgCtrOfBkg> getBkgCtrOfBkgList() {
		return bkgCtrOfBkgList;
	}

	public void setBkgCtrOfBkgList(List<BkgCtrOfBkg> bkgCtrOfBkgList) {
		this.bkgCtrOfBkgList = bkgCtrOfBkgList;
	}

	public List<BkgContainer> getBkgContainerList() {
		return bkgContainerList;
	}

	public void setBkgContainerList(List<BkgContainer> bkgContainerList) {
		this.bkgContainerList = bkgContainerList;
	}

	public List<BkgNote> getBkgNoteList() {
		return bkgNoteList;
	}

	public void setBkgNoteList(List<BkgNote> bkgNoteList) {
		this.bkgNoteList = bkgNoteList;
	}

	public List<BkgStatus> getBkgStatusList() {
		return bkgStatusList;
	}

	public void setBkgStatusList(List<BkgStatus> bkgStatusList) {
		this.bkgStatusList = bkgStatusList;
	}

}
