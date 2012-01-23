<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.blconfirm.entity.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	BlMasterA blMasterA = (BlMasterA) request.getAttribute("blMasterA");
	//BlMasterA blMasterA = blMaster.getBlMasterA();
%>
<div id="editBlMaster">
	<form id="frmBlMaster" name="frmBlMaster">
		<input type="hidden" name="blMasterId"
			value="<%=blMasterA.getBlMasterId()%>"> <input
			type="hidden" name="oceanVesselCode"
			value="<%=blMasterA.getOceanVesselCode()%>"> <input
			type="hidden" name="oceanBound"
			value="<%=blMasterA.getOceanBound()%>">
		<table border=1 width="100%" cellspacing=0 cellpadding="0">
			<tr>
				<td width="25%" class="cell-3">B/L No.</td>
				<td class="cell-4"><input type="text" name="blno"
					value="<%=blMasterA.getBlno()%>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">ShipperRefNo <input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="shipperRefNo"
					value="<%=blMasterA.getShipperRefNo()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Vessel</td>
				<td class="cell-4"><input type="text" name="oceanVesselName"
					value="<%=blMasterA.getOceanVesselName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Voyage</td>
				<td class="cell-4"><input type="text" name="oceanVoyage"
					value="<%=blMasterA.getOceanVoyage()%>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Pre Vessel<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="preVesselName"
					value="<%=blMasterA.getPreVesselName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Pre Voyage</td>
				<td class="cell-4"><input type="text" name="preVesselVoyage"
					value="<%=blMasterA.getPreVesselVoyage()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Service</td>
				<td class="cell-4"><input type="text" name="serviceCode"
					value="<%=blMasterA.getServiceCode()%>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Next Service</td>
				<td class="cell-4"><input type="text" name="nextServiceCode"
					value="" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Receipt Type<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><select name="recTypeCode">
						<option value="CY">CY</option>
				</select></td>
			</tr>
			<tr>
				<td class="cell-3">Delivery Type<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><select name="delTypeCode">
						<option value="CY">CY</option>
				</select></td>
			</tr>
			<tr>
				<td class="cell-3">B/L Form Type<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="radio" name="blFormType"
					value="O" <%="O".equals(blMasterA.getBlType()) ? "checked" : ""%>>
					Original Bill <input type="radio" name="blFormType" value="W"
					<%="W".equals(blMasterA.getBlType()) ? "checked" : ""%>>
					Way Bill</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of B/L Issued<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="placeNameOfIssue"
					value="<%=blMasterA.getPlaceNameOfBLIssued()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">No. Of Original B/L<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="noOfOriginalBL"
					value="<%=blMasterA.getNoOfOriginalBL()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Payment Type</td>
				<td class="cell-4" colspan=3><input type="radio"
					name="paymentType" value="P"
					<%="P".equals(blMasterA.getPaymentType()) ? "checked" : ""%>>
					Prepaid <input type="radio" name="paymentType" value="C"
					<%="C".equals(blMasterA.getPaymentType()) ? "checked" : ""%>>
					Collect</td>
			</tr>
			<tr>
				<td class="cell-3">Prepaid At</td>
				<td class="cell-4"><input type="text" name="prepaidAtName"
					value="<%=blMasterA.getPrepaidAtName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Payable At</td>
				<td class="cell-4"><input type="text" name="payableAtName"
					value="<%=blMasterA.getPayableAtName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="2">Ports</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Receipt<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="placeNameOfReceipt"
					value="<%=blMasterA.getPlaceNameOfReceipt()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Receipt Print<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text"
					name="placeNameOfReceiptPrint"
					value="<%=blMasterA.getPlaceNameOfReceipt()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Load Port<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="loadPortName"
					value="<%=blMasterA.getLoadPortName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Load Port Print<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="loadPortNamePrint"
					value="<%=blMasterA.getLoadPortName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Discharge Port<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="dischargePortName"
					value="<%=blMasterA.getDischargePortName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Disch. Port Print<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text"
					name="dischargePortNamePrint"
					value="<%=blMasterA.getDischargePortName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Delivery<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text"
					name="placeNameOfDelivery"
					value="<%=blMasterA.getPlaceNameOfDelivery()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Del. Print<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text"
					name="placeNameOfDeliveryPrint"
					value="<%=blMasterA.getPlaceNameOfDelivery()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="2" align="center">Parties</td>
			</tr>
			<tr>
				<td class="cell-3">NVOCC Status</td>
				<td class="cell-4"><input type="radio" name="nvoccStatus"
					value="NVO"> NVO <input type="radio" name="nvoccStatus"
					value="BCO"> BCO</td>
			</tr>
			<tr>
				<td class="cell-3">NVO No.</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Shipper<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="shipperName"
					value="<%=blMasterA.getShipperName()%>" maxlength="20"
					style="width: 480px">
				</td>
			</tr>
			<tr>
				<td class="cell-4"><textarea name="shipperAddress" rows="5"
						cols="61" style="width: 480px"><%=blMasterA.getShipperAddress()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Consignee<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="consigneeName"
					value="<%=blMasterA.getConsigneeName()%>" maxlength="70"
					style="width: 480px">
				</td>
			</tr>
			<tr>
				<td class="cell-4"><textarea name="consigneeAddress" rows="5"
						cols="61" style="width: 480px"><%=blMasterA.getConsigneeAddress()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Notify-1<input type="checkbox"
					name="shipperRefNoFlag" value="Y"></td>
				<td class="cell-4"><input type="text" name="notify_1Name"
					value="<%=blMasterA.getNotify_1Name()%>" maxlength="70"
					style="width: 480px"></td>
			</tr>
			<tr>
				<td class="cell-4"><textarea name="notify_1Address" rows="5"
						cols="61" style="width: 480px;"><%=blMasterA.getNotify_1Address()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="2" align="center"><input
					id="btnSaveBlMaster" type="button" name="btnSaveBlMaster"
					value="Save" onclick="doSaveBlMaster('<%=contextPath%>/blconfirm/blMasterBAdmin/saveBlMaster.do')" /> <input type="button"
					name="btnCancel" value="Cancel" onclick="doCancel()" /></td>
			</tr>
		</table>
	</form>
</div>
