package com.kline.blconfirm.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBLMaster")
public class BlMasterA extends BaseEntity {

	private static final long serialVersionUID = 3285223460324270491L;

	@Id(auto = false)
	@Column("BLMasterId0")
	private long blMasterId;

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
	private String shipperName;
	@Column
	private String shipperAddress;
	@Column
	private String consigneeName;
	@Column
	private String consigneeAddress;
	@Column
	private String notify_1Name;
	@Column
	private String notify_1Address;
	@Column
	private String notify_2Name;
	@Column
	private String notify_2Address;
	@Column
	private String notify_3Name;
	@Column
	private String notify_3Address;

	@Column
	private String blType;
	@Column
	private String placeCodeOfBLIssued;
	@Column
	private String placeNameOfBLIssued;
	@Column
	private String placeNameOfBLIssuedPrint;
	@Column
	private int noOfOriginalBL;

	@Column
	private String paymentType;
	@Column
	private String prepaidAtCode;
	@Column
	private String prepaidAtName;
	@Column
	private String payableAtCode;
	@Column
	private String payableAtName;

	@Column
	private String recTypeCode;
	@Column
	private String delTypeCode;

	@Column
	private String placeNameOfReceipt;
	@Column
	private String placeCodeOfReceipt;
	@Column
	private String placeNameOfReceiptPrint;
	@Column
	private String loadPortCode;
	@Column
	private String loadPortName;
	@Column
	private String loadPortNamePrint;
	@Column
	private String dischargePortCode;
	@Column
	private String dischargePortName;
	@Column
	private String dischargePortNamePrint;
	@Column
	private String placeCodeOfDelivery;
	@Column
	private String placeNameOfDelivery;
	@Column
	private String placeNameOfDeliveryPrint;

	@Column
	private String flag;
	@Column
	private String shipperRefNoFlag;

	@Column
	private String shipperNameFlag;
	@Column
	private String shipperAddressFlag;
	@Column
	private String consigneeNameFlag;
	@Column
	private String consigneeAddressFlag;
	@Column
	private String notify_1NameFlag;
	@Column
	private String notify_1AddressFlag;
	@Column
	private String notify_2NameFlag;
	@Column
	private String notify_2AddressFlag;
	@Column
	private String notify_3NameFlag;
	@Column
	private String notify_3AddressFlag;

	@Column
	private String blTypeFlag;
	@Column
	private String noOfOriginalBLFlag;
	@Column
	private String placeCodeOfBLIssuedFlag;
	@Column
	private String placeNameOfBLIssuedPrintFlag;

	// private String prepaidAtNameFlag;
	// private String payableAtNameFlag;

	@Column
	private String recTypeCodeFlag;
	@Column
	private String delTypeCodeFlag;
	@Column
	private String placeCodeOfReceiptFlag;
	@Column
	private String loadPortCodeFlag;
	@Column
	private String dischargePortCodeFlag;
	@Column
	private String placeCodeOfDeliveryFlag;
	@Column
	private String placeNameOfReceiptPrintFlag;
	@Column
	private String loadPortNamePrintFlag;
	@Column
	private String dischargePortNamePrintFlag;
	@Column
	private String placeNameOfDeliveryPrintFlag;

//	@Column
	private String dateIssue;
//	@Column
	private String dateIssueFlag;

	@Column
	private String freightRemark;
	@Column
	private String freightRemarkFlag;

	@Column
	private String preVesselCode;
	@Column
	private String preVesselName;
	@Column
	private String preVesselVoyage;
	@Column
	private String preVesselBound;

	@Column
	private String preVesselCodeFlag;
	@Column
	private String preVesselVoyageFlag;
	@Column
	private String preVesselBoundFlag;

//	@Column
	private String nvocc;

//	@Column
	private String nvoccFlag;

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

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getNotify_1Name() {
		return notify_1Name;
	}

	public void setNotify_1Name(String notify_1Name) {
		this.notify_1Name = notify_1Name;
	}

	public String getNotify_1Address() {
		return notify_1Address;
	}

	public void setNotify_1Address(String notify_1Address) {
		this.notify_1Address = notify_1Address;
	}

	public String getNotify_2Name() {
		return notify_2Name;
	}

	public void setNotify_2Name(String notify_2Name) {
		this.notify_2Name = notify_2Name;
	}

	public String getNotify_2Address() {
		return notify_2Address;
	}

	public void setNotify_2Address(String notify_2Address) {
		this.notify_2Address = notify_2Address;
	}

	public String getNotify_3Name() {
		return notify_3Name;
	}

	public void setNotify_3Name(String notify_3Name) {
		this.notify_3Name = notify_3Name;
	}

	public String getNotify_3Address() {
		return notify_3Address;
	}

	public void setNotify_3Address(String notify_3Address) {
		this.notify_3Address = notify_3Address;
	}

	public String getBlType() {
		return blType;
	}

	public void setBlType(String blType) {
		this.blType = blType;
	}

	public String getPlaceCodeOfBLIssued() {
		return placeCodeOfBLIssued;
	}

	public void setPlaceCodeOfBLIssued(String placeCodeOfBLIssued) {
		this.placeCodeOfBLIssued = placeCodeOfBLIssued;
	}

	public String getPlaceNameOfBLIssued() {
		return placeNameOfBLIssued;
	}

	public void setPlaceNameOfBLIssued(String placeNameOfBLIssued) {
		this.placeNameOfBLIssued = placeNameOfBLIssued;
	}

	public String getPlaceNameOfBLIssuedPrint() {
		return placeNameOfBLIssuedPrint;
	}

	public void setPlaceNameOfBLIssuedPrint(String placeNameOfBLIssuedPrint) {
		this.placeNameOfBLIssuedPrint = placeNameOfBLIssuedPrint;
	}

	public int getNoOfOriginalBL() {
		return noOfOriginalBL;
	}

	public void setNoOfOriginalBL(int noOfOriginalBL) {
		this.noOfOriginalBL = noOfOriginalBL;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPrepaidAtCode() {
		return prepaidAtCode;
	}

	public void setPrepaidAtCode(String prepaidAtCode) {
		this.prepaidAtCode = prepaidAtCode;
	}

	public String getPrepaidAtName() {
		return prepaidAtName;
	}

	public void setPrepaidAtName(String prepaidAtName) {
		this.prepaidAtName = prepaidAtName;
	}

	public String getPayableAtCode() {
		return payableAtCode;
	}

	public void setPayableAtCode(String payableAtCode) {
		this.payableAtCode = payableAtCode;
	}

	public String getPayableAtName() {
		return payableAtName;
	}

	public void setPayableAtName(String payableAtName) {
		this.payableAtName = payableAtName;
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

	public String getPlaceNameOfReceipt() {
		return placeNameOfReceipt;
	}

	public void setPlaceNameOfReceipt(String placeNameOfReceipt) {
		this.placeNameOfReceipt = placeNameOfReceipt;
	}

	public String getPlaceCodeOfReceipt() {
		return placeCodeOfReceipt;
	}

	public void setPlaceCodeOfReceipt(String placeCodeOfReceipt) {
		this.placeCodeOfReceipt = placeCodeOfReceipt;
	}

	public String getPlaceNameOfReceiptPrint() {
		return placeNameOfReceiptPrint;
	}

	public void setPlaceNameOfReceiptPrint(String placeNameOfReceiptPrint) {
		this.placeNameOfReceiptPrint = placeNameOfReceiptPrint;
	}

	public String getLoadPortCode() {
		return loadPortCode;
	}

	public void setLoadPortCode(String loadPortCode) {
		this.loadPortCode = loadPortCode;
	}

	public String getLoadPortName() {
		return loadPortName;
	}

	public void setLoadPortName(String loadPortName) {
		this.loadPortName = loadPortName;
	}

	public String getLoadPortNamePrint() {
		return loadPortNamePrint;
	}

	public void setLoadPortNamePrint(String loadPortNamePrint) {
		this.loadPortNamePrint = loadPortNamePrint;
	}

	public String getDischargePortCode() {
		return dischargePortCode;
	}

	public void setDischargePortCode(String dischargePortCode) {
		this.dischargePortCode = dischargePortCode;
	}

	public String getDischargePortName() {
		return dischargePortName;
	}

	public void setDischargePortName(String dischargePortName) {
		this.dischargePortName = dischargePortName;
	}

	public String getDischargePortNamePrint() {
		return dischargePortNamePrint;
	}

	public void setDischargePortNamePrint(String dischargePortNamePrint) {
		this.dischargePortNamePrint = dischargePortNamePrint;
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

	public String getPlaceNameOfDeliveryPrint() {
		return placeNameOfDeliveryPrint;
	}

	public void setPlaceNameOfDeliveryPrint(String placeNameOfDeliveryPrint) {
		this.placeNameOfDeliveryPrint = placeNameOfDeliveryPrint;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getShipperRefNoFlag() {
		return shipperRefNoFlag;
	}

	public void setShipperRefNoFlag(String shipperRefNoFlag) {
		this.shipperRefNoFlag = shipperRefNoFlag;
	}

	public String getShipperNameFlag() {
		return shipperNameFlag;
	}

	public void setShipperNameFlag(String shipperNameFlag) {
		this.shipperNameFlag = shipperNameFlag;
	}

	public String getShipperAddressFlag() {
		return shipperAddressFlag;
	}

	public void setShipperAddressFlag(String shipperAddressFlag) {
		this.shipperAddressFlag = shipperAddressFlag;
	}

	public String getConsigneeNameFlag() {
		return consigneeNameFlag;
	}

	public void setConsigneeNameFlag(String consigneeNameFlag) {
		this.consigneeNameFlag = consigneeNameFlag;
	}

	public String getConsigneeAddressFlag() {
		return consigneeAddressFlag;
	}

	public void setConsigneeAddressFlag(String consigneeAddressFlag) {
		this.consigneeAddressFlag = consigneeAddressFlag;
	}

	public String getNotify_1NameFlag() {
		return notify_1NameFlag;
	}

	public void setNotify_1NameFlag(String notify_1NameFlag) {
		this.notify_1NameFlag = notify_1NameFlag;
	}

	public String getNotify_1AddressFlag() {
		return notify_1AddressFlag;
	}

	public void setNotify_1AddressFlag(String notify_1AddressFlag) {
		this.notify_1AddressFlag = notify_1AddressFlag;
	}

	public String getNotify_2NameFlag() {
		return notify_2NameFlag;
	}

	public void setNotify_2NameFlag(String notify_2NameFlag) {
		this.notify_2NameFlag = notify_2NameFlag;
	}

	public String getNotify_2AddressFlag() {
		return notify_2AddressFlag;
	}

	public void setNotify_2AddressFlag(String notify_2AddressFlag) {
		this.notify_2AddressFlag = notify_2AddressFlag;
	}

	public String getNotify_3NameFlag() {
		return notify_3NameFlag;
	}

	public void setNotify_3NameFlag(String notify_3NameFlag) {
		this.notify_3NameFlag = notify_3NameFlag;
	}

	public String getNotify_3AddressFlag() {
		return notify_3AddressFlag;
	}

	public void setNotify_3AddressFlag(String notify_3AddressFlag) {
		this.notify_3AddressFlag = notify_3AddressFlag;
	}

	public String getBlTypeFlag() {
		return blTypeFlag;
	}

	public void setBlTypeFlag(String blTypeFlag) {
		this.blTypeFlag = blTypeFlag;
	}

	public String getNoOfOriginalBLFlag() {
		return noOfOriginalBLFlag;
	}

	public void setNoOfOriginalBLFlag(String noOfOriginalBLFlag) {
		this.noOfOriginalBLFlag = noOfOriginalBLFlag;
	}

	public String getPlaceCodeOfBLIssuedFlag() {
		return placeCodeOfBLIssuedFlag;
	}

	public void setPlaceCodeOfBLIssuedFlag(String placeCodeOfBLIssuedFlag) {
		this.placeCodeOfBLIssuedFlag = placeCodeOfBLIssuedFlag;
	}

	public String getPlaceNameOfBLIssuedPrintFlag() {
		return placeNameOfBLIssuedPrintFlag;
	}

	public void setPlaceNameOfBLIssuedPrintFlag(String placeNameOfBLIssuedPrintFlag) {
		this.placeNameOfBLIssuedPrintFlag = placeNameOfBLIssuedPrintFlag;
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

	public String getPlaceCodeOfReceiptFlag() {
		return placeCodeOfReceiptFlag;
	}

	public void setPlaceCodeOfReceiptFlag(String placeCodeOfReceiptFlag) {
		this.placeCodeOfReceiptFlag = placeCodeOfReceiptFlag;
	}

	public String getLoadPortCodeFlag() {
		return loadPortCodeFlag;
	}

	public void setLoadPortCodeFlag(String loadPortCodeFlag) {
		this.loadPortCodeFlag = loadPortCodeFlag;
	}

	public String getDischargePortCodeFlag() {
		return dischargePortCodeFlag;
	}

	public void setDischargePortCodeFlag(String dischargePortCodeFlag) {
		this.dischargePortCodeFlag = dischargePortCodeFlag;
	}

	public String getPlaceCodeOfDeliveryFlag() {
		return placeCodeOfDeliveryFlag;
	}

	public void setPlaceCodeOfDeliveryFlag(String placeCodeOfDeliveryFlag) {
		this.placeCodeOfDeliveryFlag = placeCodeOfDeliveryFlag;
	}

	public String getPlaceNameOfReceiptPrintFlag() {
		return placeNameOfReceiptPrintFlag;
	}

	public void setPlaceNameOfReceiptPrintFlag(String placeNameOfReceiptPrintFlag) {
		this.placeNameOfReceiptPrintFlag = placeNameOfReceiptPrintFlag;
	}

	public String getLoadPortNamePrintFlag() {
		return loadPortNamePrintFlag;
	}

	public void setLoadPortNamePrintFlag(String loadPortNamePrintFlag) {
		this.loadPortNamePrintFlag = loadPortNamePrintFlag;
	}

	public String getDischargePortNamePrintFlag() {
		return dischargePortNamePrintFlag;
	}

	public void setDischargePortNamePrintFlag(String dischargePortNamePrintFlag) {
		this.dischargePortNamePrintFlag = dischargePortNamePrintFlag;
	}

	public String getPlaceNameOfDeliveryPrintFlag() {
		return placeNameOfDeliveryPrintFlag;
	}

	public void setPlaceNameOfDeliveryPrintFlag(String placeNameOfDeliveryPrintFlag) {
		this.placeNameOfDeliveryPrintFlag = placeNameOfDeliveryPrintFlag;
	}

	public String getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(String dateIssue) {
		this.dateIssue = dateIssue;
	}

	public String getDateIssueFlag() {
		return dateIssueFlag;
	}

	public void setDateIssueFlag(String dateIssueFlag) {
		this.dateIssueFlag = dateIssueFlag;
	}

	public String getFreightRemark() {
		return freightRemark;
	}

	public void setFreightRemark(String freightRemark) {
		this.freightRemark = freightRemark;
	}

	public String getFreightRemarkFlag() {
		return freightRemarkFlag;
	}

	public void setFreightRemarkFlag(String freightRemarkFlag) {
		this.freightRemarkFlag = freightRemarkFlag;
	}

	public String getPreVesselCode() {
		return preVesselCode;
	}

	public void setPreVesselCode(String preVesselCode) {
		this.preVesselCode = preVesselCode;
	}

	public String getPreVesselName() {
		return preVesselName;
	}

	public void setPreVesselName(String preVesselName) {
		this.preVesselName = preVesselName;
	}

	public String getPreVesselVoyage() {
		return preVesselVoyage;
	}

	public void setPreVesselVoyage(String preVesselVoyage) {
		this.preVesselVoyage = preVesselVoyage;
	}

	public String getPreVesselBound() {
		return preVesselBound;
	}

	public void setPreVesselBound(String preVesselBound) {
		this.preVesselBound = preVesselBound;
	}

	public String getPreVesselCodeFlag() {
		return preVesselCodeFlag;
	}

	public void setPreVesselCodeFlag(String preVesselCodeFlag) {
		this.preVesselCodeFlag = preVesselCodeFlag;
	}

	public String getPreVesselVoyageFlag() {
		return preVesselVoyageFlag;
	}

	public void setPreVesselVoyageFlag(String preVesselVoyageFlag) {
		this.preVesselVoyageFlag = preVesselVoyageFlag;
	}

	public String getPreVesselBoundFlag() {
		return preVesselBoundFlag;
	}

	public void setPreVesselBoundFlag(String preVesselBoundFlag) {
		this.preVesselBoundFlag = preVesselBoundFlag;
	}

	public String getNvocc() {
		return nvocc;
	}

	public void setNvocc(String nvocc) {
		this.nvocc = nvocc;
	}

	public String getNvoccFlag() {
		return nvoccFlag;
	}

	public void setNvoccFlag(String nvoccFlag) {
		this.nvoccFlag = nvoccFlag;
	}

}
