<%@ page language="java"
	import="java.util.*,com.kline.*, com.kline.util.*,org.nutz.dao.QueryResult,com.kline.booking.entity.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	BkgMaster bkgMaster = (BkgMaster) request.getAttribute("bkgMaster");
	BkgMasterA bkgMasterA = bkgMaster.getBkgMasterA();
%>
<div id="editBkgMaster">
	<form id="frmBkgMaster" name="frmBkgMaster">
		<input type="hidden" name="bkgMasterId" value="<%= bkgMaster.getBkgMasterId() %>"> 
		<input type="hidden" name="oceanVesselCode" value="<%= bkgMaster.getOceanVesselCode() %>"> 
		<input type="hidden" name="oceanBound" value="<%= bkgMaster.getOceanBound() %>">
		<table border=1 width="100%" cellspacing=0 cellpadding="0">
			<tr>
				<td width="20%" class="cell-3">Office</td>
				<td width="30%" class="cell-4"><select name="officeCode">
						<option value="" <%= "".equals(bkgMaster.getOfficeCode()) ? "selected" : "" %>>Office</option>
						<%
							for (String officeCode : Constants.officeArray) {
						%>
						<option value="<%=officeCode%>"  <%= officeCode.equals(bkgMaster.getOfficeCode()) ? "selected" : "" %>><%=officeCode%></option>
						<%
							}
						%>
				</select></td>
				<td width="20%" class="cell-3">Agent-Direct Agent</td>
				<td width="30%" class="cell-4"><select name="agentCode">
						<option value="">Agent Code</option>
				</select> - <select name="directAgentCode">
						<option value="">Direct Agent</option>
				</select></td>
			</tr>
			<tr>
				<td width="20%" class="cell-3">B/L No.</td>
				<td width="30%" class="cell-4"><input type="text" name="blno"
					value="<%= bkgMaster.getBlno() %>" maxlength="20">
				</td>
				<td width="20%" class="cell-3">ShipperRefNo</td>
				<td width="30%" class="cell-4"><input type="text"
					name="shipperRefNo" value="<%= bkgMaster.getShipperRefNo() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Vessel</td>
				<td class="cell-4"><input type="text" name="oceanVesselName"
					value="<%= bkgMaster.getOceanVesselName() %>" maxlength="20"></td>
				<td class="cell-3">Pre Vessel</td>
				<td class="cell-4"><input type="text" name="preVesselName"
					value="<%= bkgMasterA.getPreVesselName() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Voyage</td>
				<td class="cell-4"><input type="text" name="oceanVoyage"
					value="<%= bkgMaster.getOceanVoyage() %>" maxlength="20">
				</td>
				<td class="cell-3">Pre Voyage</td>
				<td class="cell-4"><input type="text" name="preVesselVoyage"
					value="<%= bkgMasterA.getPreVesselVoyage() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Service</td>
				<td class="cell-4"><input type="text" name="serviceCode"
					value="<%= bkgMaster.getServiceCode() %>" maxlength="20">
				</td>
				<td class="cell-3">Next Service</td>
				<td class="cell-4"><input type="text" name="nextServiceCode"
					value="" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Sailing Date</td>
				<td class="cell-4"><input type="text" name="sailingDate"
					value="<%= bkgMaster.getSailingDate() %>" maxlength="20">
				</td>
				<td class="cell-3"></td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Receipt Type - Delivery Type</td>
				<td class="cell-4"><select name="recTypeCode">
						<option value="CY">CY</option>
				</select> - <select name="delTypeCode">
						<option value="CY">CY</option>
				</select>
				</td>
				<td class="cell-3">B/L Form Type</td>
				<td class="cell-4"><input type="radio" name="blFormType"
					value="O" <%= "O".equals(bkgMasterA.getBlType()) ? "checked" : "" %>> Original Bill <input
					type="radio" name="blFormType" value="W" <%= "W".equals(bkgMasterA.getBlType()) ? "checked" : "" %>>
					Way Bill</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of B/L Issued</td>
				<td class="cell-4"><input type="text" name="placeNameOfIssue"
					value="<%= bkgMasterA.getPlaceNameOfBLIssued() %>" maxlength="20">
				</td>
				<td class="cell-3">No. Of Original B/L</td>
				<td class="cell-4"><input type="text" name="noOfOriginalBL"
					value="<%= bkgMasterA.getNoOfOriginalBL() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Full/LCL</td>
				<td class="cell-4"><input type="radio" name="fullLclFlag"
					value="F" <%= "F".equals(bkgMaster.getFullLclFlag()) ? "checked" : "" %>> Full <input type="radio"
					name="fullLclFlag" value="L"  <%= "L".equals(bkgMaster.getFullLclFlag()) ? "checked" : "" %>> LCL</td>
				<td class="cell-3">Master LCL No.</td>
				<td class="cell-4"><input type="text" name="masterLclNo"
					value="<%= bkgMaster.getMasterLclNo() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Payment Type</td>
				<td class="cell-4" colspan=3><input type="radio"
					name="paymentType" value="P" <%= "P".equals(bkgMasterA.getPaymentType()) ? "checked" : "" %>> Prepaid <input
					type="radio" name="paymentType" value="C" <%= "C".equals(bkgMasterA.getPaymentType()) ? "checked" : "" %>>
					Collect</td>
			</tr>
			<tr>
				<td class="cell-3">Prepaid At</td>
				<td class="cell-4"><input type="text" name="prepaidAtName"
					value="<%= bkgMasterA.getPrepaidAtName() %>" maxlength="20"></td>
				<td class="cell-3">Payable At</td>
				<td class="cell-4"><input type="text" name="payableAtName"
					value="<%= bkgMasterA.getPayableAtName() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">S/C No.</td>
				<td class="cell-4"><input type="text" name="scNo"
					value="<%= bkgMasterA.getScNo() %>" maxlength="20">
				</td>
				<td class="cell-3">&nbsp;</td>
				<td class="cell-4">&nbsp;</td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4">Ports</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Receipt</td>
				<td class="cell-4"><input type="text" name="placeNameOfReceipt"
					value="<%= bkgMasterA.getPlaceNameOfReceipt() %>" maxlength="20">
				</td>
				<td class="cell-3">Place Of Receipt Print</td>
				<td class="cell-4"><input type="text"
					name="placeNameOfReceiptPrint" value="<%= bkgMasterA.getPlaceNameOfReceipt() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Load Port</td>
				<td class="cell-4"><input type="text" name="loadPortName"
					value="<%= bkgMasterA.getLoadPortName() %>" maxlength="20">
				</td>
				<td class="cell-3">Load Port Print</td>
				<td class="cell-4"><input type="text" name="loadPortNamePrint"
					value="<%= bkgMasterA.getLoadPortName() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Discharge Port</td>
				<td class="cell-4"><input type="text" name="dischargePortName"
					value="<%= bkgMasterA.getDischargePortName() %>" maxlength="20">
				</td>
				<td class="cell-3">Disch. Port Print</td>
				<td class="cell-4"><input type="text"
					name="dischargePortNamePrint" value="<%= bkgMasterA.getDischargePortName() %>"
					maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Delivery</td>
				<td class="cell-4"><input type="text"
					name="placeNameOfDelivery" value="<%= bkgMasterA.getPlaceNameOfDelivery() %>" maxlength="20">
				</td>
				<td class="cell-3">Place Of Del. Print</td>
				<td class="cell-4"><input type="text"
					name="placeNameOfDeliveryPrint" value="<%= bkgMasterA.getPlaceNameOfDelivery() %>"
					maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3"><font color="#000000">Transhipment

						Port 
				</td>
				<td class="cell-4"><input type="text"
					name="transhipmentPortName" value="<%= bkgMasterA.getTranshipmentPortName() %>" maxlength="20">
				</td>
				<td class="cell-3">GateInCode</td>
				<td class="cell-4"><input type="text" name="gateInCode"
					value="<%= bkgMasterA.getGateInCode() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4" align="center">Parties</td>
			</tr>
			<tr>
				<td class="cell-3">NVOCC Status</td>
				<td class="cell-4"><input type="radio" name="nvoccStatus"
					value="NVO"> NVO <input type="radio"
					name="nvoccStatus" value="BCO"> BCO</td>
				<td class="cell-3">NVO No.</td>
				<td class="cell-4"><input type="text" name="nvoNo"
					value="<%= bkgMasterA.getNvoNo() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Shipper</td>
				<td class="cell-4" colspan="3"><input type="text"
					name="shipperName"
					value="<%= bkgMasterA.getShipperName() %>"
					maxlength="20" style="width: 480px"></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><textarea name="shipperAddress"
						rows="5" cols="61" style="width: 480px"><%= bkgMasterA.getShipperAddress() %></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Consignee</td>
				<td class="cell-4" colspan="3"><input type="text"
					name="consigneeName"
					value="<%= bkgMasterA.getConsigneeName() %>"
					maxlength="70" style="width: 480px"></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><textarea
						name="consigneeAddress" rows="5" cols="61" style="width: 480px"><%= bkgMasterA.getConsigneeAddress() %></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Notify-1</td>
				<td class="cell-4" colspan="3"><input type="text"
					name="notify_1Name"
					value="<%= bkgMasterA.getNotify_1Name() %>"
					maxlength="70" style="width: 480px">
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><textarea name="notify_1Address"
						rows="5" cols="61" style="width: 480px;"><%= bkgMasterA.getNotify_1Address() %></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="4" align="center"><input
					id="btnSaveBkgMaster" type="button" name="btnSaveBkgMaster"
					value="Save" onclick="saveBkgMaster()" /> <input type="button"
					name="btnCancel" value="Cancel" onclick="doCancel()" />
				</td>
			</tr>
		</table>
	</form>
</div>
