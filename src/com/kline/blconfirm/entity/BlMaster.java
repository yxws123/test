package com.kline.blconfirm.entity;

import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLMasterA")
public class BlMaster extends BaseEntity {

	private static final long serialVersionUID = 5578285444368114843L;

	@Id
	@Column("BLMasterId0")
	private long blMasterId;
	@Column
	private int version;
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
	private String agentCode;
	@Column
	private String directAgentCode;
	@Column
	private Integer currentStatusId;
	@Column
	private Date dateCutOff;
	@Column
	private String latestFlag;
	@Column
	private String officeCode;
	@Column
	private int status;
	@Column
	private Date statusTime;
	@Column
	private String statusUserId;

	private BlMasterA blMasterA;
	private List<BlCargo> blCargoList;
	private List<BlMarkNo> blMarkNoList;
	private List<BlContainer> blContainerList;
	private List<BlCustomerRef> blCustomerRefList;
	private List<BlConfirmStatus> blConfirmStatusList;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getDirectAgentCode() {
		return directAgentCode;
	}

	public void setDirectAgentCode(String directAgentCode) {
		this.directAgentCode = directAgentCode;
	}

	public Integer getCurrentStatusId() {
		return currentStatusId;
	}

	public void setCurrentStatusId(Integer currentStatusId) {
		this.currentStatusId = currentStatusId;
	}

	public Date getDateCutOff() {
		return dateCutOff;
	}

	public void setDateCutOff(Date dateCutOff) {
		this.dateCutOff = dateCutOff;
	}

	public String getLatestFlag() {
		return latestFlag;
	}

	public void setLatestFlag(String latestFlag) {
		this.latestFlag = latestFlag;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public BlMasterA getBlMasterA() {
		return blMasterA;
	}

	public void setBlMasterA(BlMasterA blMasterA) {
		this.blMasterA = blMasterA;
	}

	public List<BlCargo> getBlCargoList() {
		return blCargoList;
	}

	public void setBlCargoList(List<BlCargo> blCargoList) {
		this.blCargoList = blCargoList;
	}

	public List<BlMarkNo> getBlMarkNoList() {
		return blMarkNoList;
	}

	public void setBlMarkNoList(List<BlMarkNo> blMarkNoList) {
		this.blMarkNoList = blMarkNoList;
	}

	public List<BlContainer> getBlContainerList() {
		return blContainerList;
	}

	public void setBlContainerList(List<BlContainer> blContainerList) {
		this.blContainerList = blContainerList;
	}

	public List<BlCustomerRef> getBlCustomerRefList() {
		return blCustomerRefList;
	}

	public void setBlCustomerRefList(List<BlCustomerRef> blCustomerRefList) {
		this.blCustomerRefList = blCustomerRefList;
	}

	public List<BlConfirmStatus> getBlConfirmStatusList() {
		return blConfirmStatusList;
	}

	public void setBlConfirmStatusList(List<BlConfirmStatus> blConfirmStatusList) {
		this.blConfirmStatusList = blConfirmStatusList;
	}

	public long getBlMasterId() {
		return blMasterId;
	}

	public void setBlMasterId(long blMasterId) {
		this.blMasterId = blMasterId;
	}
}
