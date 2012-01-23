package com.kline.booking.entity;

//import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.kline.core.entity.BaseEntity;

@Table("tblBkgMaster")
public class BkgMasterA extends BaseEntity {

	private static final long serialVersionUID = 1596050620801895286L;

	@Id(auto=false)
	@Column
	private long bkgMasterId;

	@Column
	private String preVesselCode;
	@Column
	private String preVesselName;
	@Column
	private String preVesselVoyage;
	@Column
	private String preVesselBound;

	@Column
	private String blNextServiceCode;

	// 发货人，收货人，通知人
	@Column
	private int shipperCode;
	@Column
	private String shipperName;
	@Column
	private String shipperAddress;
	@Column
	private int consigneeCode;
	@Column
	private String consigneeName;
	@Column
	private String consigneeAddress;
	@Column
	private int notify_1Code;
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
	private String shipperDUNSCode;
	@Column
	private String consigneeDUNSCode;
//	@Column
//	private int notify_1Code;
	@Column
	private String notify_1DUNSCode;
	@Column
	private int notify_2Code;
	@Column
	private String notify_2DUNSCode;
	@Column
	private int notify_3Code;
	@Column
	private String notify_3DUNSCode;

//	@Column
	private String shipperDUNSValid;
//	@Column
	private String consigneeDUNSValid;
//	@Column
	private String notify_1DUNSValid;
//	@Column
	private String notify_2DUNSValid;
//	@Column
	private String notify_3DUNSValid;

	// 提单类型
	@Column
	private String blType;
	@Column
	private String placeCodeOfBLIssued;
	@Column
	private String placeNameOfBLIssued;
	@Column
	private int noOfOriginalBL;

	// 预付/到付
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

	// 交货条款
	@Column
	private String recTypeCode;
	@Column
	private String delTypeCode;

	// 收货地，装货港，卸货港，交货地
	@Column
	private String placeNameOfReceipt;
	@Column
	private String placeCodeOfReceipt;
	@Column
	private String LoadPortCode;
	@Column
	private String LoadPortName;
	@Column
	private String dischargePortCode;
	@Column
	private String dischargePortName;
	@Column
	private String placeCodeOfDelivery;
	@Column
	private String placeNameOfDelivery;

	// added at 4/16/03
	@Column
	private String transhipmentPortCode;
	@Column
	private String transhipmentPortName;

	@Column
	private String gateInCode;

	//
//	@Column
	private String usaServiceTypeCode;
//	@Column
	private String usaServiceFlag;
//	@Column
	private int principleCode;

	// private String commodityTypeCode;
	// private int totalTEU;

	@Column
	private String nvoccStatus;
	@Column
	private String nvoNo;
	@Column
	private String scNo;

	public long getBkgMasterId() {
		return bkgMasterId;
	}

	public void setBkgMasterId(long bkgMasterId) {
		this.bkgMasterId = bkgMasterId;
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

	public String getBlNextServiceCode() {
		return blNextServiceCode;
	}

	public void setBlNextServiceCode(String blNextServiceCode) {
		this.blNextServiceCode = blNextServiceCode;
	}

	public int getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(int shipperCode) {
		this.shipperCode = shipperCode;
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

	public int getConsigneeCode() {
		return consigneeCode;
	}

	public void setConsigneeCode(int consigneeCode) {
		this.consigneeCode = consigneeCode;
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

	public int getNotify_1Code() {
		return notify_1Code;
	}

	public void setNotify_1Code(int notify_1Code) {
		this.notify_1Code = notify_1Code;
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

	public String getShipperDUNSCode() {
		return shipperDUNSCode;
	}

	public void setShipperDUNSCode(String shipperDUNSCode) {
		this.shipperDUNSCode = shipperDUNSCode;
	}

	public String getConsigneeDUNSCode() {
		return consigneeDUNSCode;
	}

	public void setConsigneeDUNSCode(String consigneeDUNSCode) {
		this.consigneeDUNSCode = consigneeDUNSCode;
	}

//	public int getNotify_1Code() {
//		return notify_1Code;
//	}
//
//	public void setNotify_1Code(int notify_1Code) {
//		this.notify_1Code = notify_1Code;
//	}

	public String getNotify_1DUNSCode() {
		return notify_1DUNSCode;
	}

	public void setNotify_1DUNSCode(String notify_1dunsCode) {
		notify_1DUNSCode = notify_1dunsCode;
	}

	public int getNotify_2Code() {
		return notify_2Code;
	}

	public void setNotify_2Code(int notify_2Code) {
		this.notify_2Code = notify_2Code;
	}

	public String getNotify_2DUNSCode() {
		return notify_2DUNSCode;
	}

	public void setNotify_2DUNSCode(String notify_2dunsCode) {
		notify_2DUNSCode = notify_2dunsCode;
	}

	public int getNotify_3Code() {
		return notify_3Code;
	}

	public void setNotify_3Code(int notify_3Code) {
		this.notify_3Code = notify_3Code;
	}

	public String getNotify_3DUNSCode() {
		return notify_3DUNSCode;
	}

	public void setNotify_3DUNSCode(String notify_3dunsCode) {
		notify_3DUNSCode = notify_3dunsCode;
	}

	public String getShipperDUNSValid() {
		return shipperDUNSValid;
	}

	public void setShipperDUNSValid(String shipperDUNSValid) {
		this.shipperDUNSValid = shipperDUNSValid;
	}

	public String getConsigneeDUNSValid() {
		return consigneeDUNSValid;
	}

	public void setConsigneeDUNSValid(String consigneeDUNSValid) {
		this.consigneeDUNSValid = consigneeDUNSValid;
	}

	public String getNotify_1DUNSValid() {
		return notify_1DUNSValid;
	}

	public void setNotify_1DUNSValid(String notify_1dunsValid) {
		notify_1DUNSValid = notify_1dunsValid;
	}

	public String getNotify_2DUNSValid() {
		return notify_2DUNSValid;
	}

	public void setNotify_2DUNSValid(String notify_2dunsValid) {
		notify_2DUNSValid = notify_2dunsValid;
	}

	public String getNotify_3DUNSValid() {
		return notify_3DUNSValid;
	}

	public void setNotify_3DUNSValid(String notify_3dunsValid) {
		notify_3DUNSValid = notify_3dunsValid;
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

	public String getLoadPortCode() {
		return LoadPortCode;
	}

	public void setLoadPortCode(String loadPortCode) {
		LoadPortCode = loadPortCode;
	}

	public String getLoadPortName() {
		return LoadPortName;
	}

	public void setLoadPortName(String loadPortName) {
		LoadPortName = loadPortName;
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

	public String getTranshipmentPortCode() {
		return transhipmentPortCode;
	}

	public void setTranshipmentPortCode(String transhipmentPortCode) {
		this.transhipmentPortCode = transhipmentPortCode;
	}

	public String getTranshipmentPortName() {
		return transhipmentPortName;
	}

	public void setTranshipmentPortName(String transhipmentPortName) {
		this.transhipmentPortName = transhipmentPortName;
	}

	public String getGateInCode() {
		return gateInCode;
	}

	public void setGateInCode(String gateInCode) {
		this.gateInCode = gateInCode;
	}

	public String getUsaServiceTypeCode() {
		return usaServiceTypeCode;
	}

	public void setUsaServiceTypeCode(String usaServiceTypeCode) {
		this.usaServiceTypeCode = usaServiceTypeCode;
	}

	public String getUsaServiceFlag() {
		return usaServiceFlag;
	}

	public void setUsaServiceFlag(String usaServiceFlag) {
		this.usaServiceFlag = usaServiceFlag;
	}

	public int getPrincipleCode() {
		return principleCode;
	}

	public void setPrincipleCode(int principleCode) {
		this.principleCode = principleCode;
	}

	public String getNvoccStatus() {
		return nvoccStatus;
	}

	public void setNvoccStatus(String nvoccStatus) {
		this.nvoccStatus = nvoccStatus;
	}

	public String getNvoNo() {
		return nvoNo;
	}

	public void setNvoNo(String nvoNo) {
		this.nvoNo = nvoNo;
	}

	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
}
