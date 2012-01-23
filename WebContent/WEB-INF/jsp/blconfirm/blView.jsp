<%@ page language="java"
	import="java.util.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.core.entity.*,com.kline.blconfirm.entity.*,com.kline.blconfirm.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	User myAccount = AuthUtil.getMyAccount(request);

	BlMaster bl = (BlMaster) request.getAttribute("bl");

	boolean canViewBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_VIEW, bl);
	boolean canDeleteBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_DELETE, bl);
	boolean canDonotVerifyBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_DONOT_VERIFY, null);
	boolean canVerifyBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_VERIFY, null);
	boolean canVerifyingBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_VERIFYING, bl);
	boolean canSubmitBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_SUBMIT, bl);
	boolean canUnsubmitBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_UNSUBMIT, bl);
	boolean canProcessBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_PROCESS, bl);
	boolean canProcessingBL = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_PROCESSING, bl);
	boolean canUpdateSDS = BlConfirmHelper.canDoAction(myAccount,
			BlConfirmHelper.BL_ACT_UPDATE_SDS, bl);
	//boolean canUpdateSDS = canReadBlConfirm && canCreateBlConfirm;
%>
<script type="text/javascript">
<!--
//-->
</script>

<div id="" class="row" style="border-bottom: 0px solid #CCCCFF;">
	<div style="margin: 0 auto; border: 0px solid; width: 589px;">
		<div id="tab_blMaster" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blMaster')">Master</a>
		</div>
		<div id="tab_blCargo" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blCargo')">Cargo</a>
		</div>
		<div id="tab_blMarkNo" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blMarkNo')">MarkNo</a>
		</div>
		<div id="tab_blCtrOfBl" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blCtrOfBl')">Container
				Of Booking</a>
		</div>
		<div id="tab_blContainer" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blContainer')">Container
				Details</a>
		</div>
		<div id="tab_blNote" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blNote')">Notes</a>
		</div>
		<div id="tab_blStatus" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('blStatus')">Status</a>
		</div>
	</div>
</div>
<a name="blMaster_start" id="blMaster_start"></a>
<div id="blMaster" class="container container-f">
	<div class="titleBar">
		<div id="title" class="left">Master</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td class="cell-3" width="20%">B/L No.</td>
				<td class="cell-4" width="30%"><%=StringUtils.trim(bl.getBlno())%></td>
				<td class="cell-3" width="20%">ShipperRefNo</td>
				<td class="cell-4" width="30%"><%=StringUtils.trim(bl.getShipperRefNo())%></td>
			</tr>
			<tr>
				<td class="cell-3">Vessel</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getOceanVesselName())%>
				</td>
				<td class="cell-3">Pre-Vessel</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getPreVesselName())%></td>
			</tr>
			<tr>
				<td class="cell-3">Voyage</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getOceanVoyage())%></td>
				<td class="cell-3">Pre-Voyage</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getPreVesselVoyage())%></td>
			</tr>
			<tr>
				<td class="cell-3">Service</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getServiceCode())%></td>
				<td class="cell-3">Next Service</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Sailing Date</td>
				<td class="cell-4"><%=StringUtils.toDateString(bl.getSailingDate())%></td>
				<td class="cell-3"></td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Receipt Type - Delivery Type</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getRecTypeCode())%> - <%=StringUtils.trim(bl.getBlMasterA().getDelTypeCode())%></td>
				<td class="cell-3">B/L Form Type</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getBlType())%></td>
			</tr>
			<tr>
				<td class="cell-3">Place Of B/L Issued</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA()
					.getPlaceNameOfBLIssued())%></td>
				<td class="cell-3">No. Of Original B/L</td>
				<td class="cell-4"><%=bl.getBlMasterA().getNoOfOriginalBL()%></td>
			</tr>
			<tr>
				<td class="cell-3">Payment Type</td>
				<td class="cell-4" colspan=3><%=StringUtils.trim(bl.getBlMasterA().getPaymentType())%></td>
			</tr>
			<tr>
				<td class="cell-3">Prepaid At</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getPrepaidAtName())%></td>
				<td class="cell-3">Payable At</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getPayableAtName())%></td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4">Ports</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Rec.</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA()
					.getPlaceNameOfReceipt())%></td>
				<td class="cell-3">Place Of Rec. Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Load Port</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA().getRecTypeCode())%></td>
				<td class="cell-3">Load Port Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Discharge Port</td>
				<td class="cell-4"><%=StringUtils
					.trim(bl.getBlMasterA().getDischargePortName())%></td>
				<td class="cell-3">Discharge Port Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Delivery</td>
				<td class="cell-4"><%=StringUtils.trim(bl.getBlMasterA()
					.getPlaceNameOfDelivery())%></td>
				<td class="cell-3">Place Of Delivery Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4">Parties</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Shipper</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(bl.getBlMasterA().getShipperName())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils.toHtml(bl.getBlMasterA().getShipperAddress())%></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Consignee</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(bl.getBlMasterA().getConsigneeName())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils.toHtml(bl.getBlMasterA()
					.getConsigneeAddress())%></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Notify-1</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(bl.getBlMasterA().getNotify_1Name())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils
					.toHtml(bl.getBlMasterA().getNotify_1Address())%></td>
			</tr>
		</table>
	</div>
	<div id="actionBar" class="actionBar row">
		<div class="column left">
			<%
				if (canVerifyingBL) {
			%>
			<a href="javascript: void(0);"
				onclick="doEditBlMaster('<%=contextPath%>/blconfirm/blMasterBAdmin/editBlMaster.do', '<%=bl.getBlMasterId()%>')">Edit
				Master</a>
			<%
				}
			%>
			<%
				if (canProcessingBL) {
			%>
			<a href="javascript: void(0);"
				onclick="doEditBlMaster('<%=contextPath%>/blconfirm/blMasterBAdmin/processBlMaster.do', '<%=bl.getBlMasterId()%>')">Process
				Master</a>
			<%
				}
			%>
		</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="jumpToPosition('blView_start')">Top</a>
		</div>
	</div>
</div>
<a name="blCargo_start" id="blCargo_start"></a>
<div id="blCargo" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Cargo</div>
		<div class="column right">
			<%
				if (canVerifyingBL) {
			%>
			<a href="javascript: void(0);"
				onclick="editBlMaster('<%=bl.getBlMasterId()%>')">New</a>
			<%
				}
			%>
		</div>
	</div>
	<div id="content">
		<table width="100%">
			<thead>
				<tr>
					<td class="cell-5">Cargo Type</td>
					<td class="cell-5">Outer PkgType</td>
					<td class="cell-5">Outer Qty.</td>
					<td class="cell-5">Gross Wt.(kg)</td>
					<td class="cell-5">Gross Meas.</td>
					<td class="cell-5" width="15%">Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BlCargo blCargo : bl.getBlCargoList()) {
				%>
				<tr>
					<td class="cell-6"><%=blCargo.getCommodityTypeCode()%></td>
					<td class="cell-6"><%=blCargo.getOuterPkgTypeName()%></td>
					<td class="cell-6"><%=blCargo.getOuterQty()%></td>
					<td class="cell-6"><%=blCargo.getGrossWt()%></td>
					<td class="cell-6"><%=blCargo.getGrossMeas()%></td>
					<td class="cell-6">
						<%
							if (canVerifyingBL) {
						%> <a href="javascript: void(0);"
						onclick="doEditBlCargo('<%=contextPath%>/blconfirm/blCargoAdmin/editBlCargo.do', '<%=blCargo.getBlCargoId()%>', '<%=blCargo.getBlMasterId()%>')">Edit</a>
						Delete <%
 	}
 %>
						<%
							if (canProcessingBL) {
						%> <a href="javascript: void(0);"
						onclick="doEditBlCargo('<%=contextPath%>/blconfirm/blCargoAdmin/editBlCargo.do', '<%=blCargo.getBlCargoId()%>', '<%=blCargo.getBlMasterId()%>')">Processt</a>
						<a href="javascript: void(0);"
						onclick="doEditBlCargo('<%=contextPath%>/blconfirm/blCargoAdmin/editBlCargo.do', '<%=blCargo.getBlCargoId()%>', '<%=blCargo.getBlMasterId()%>')">Accept</a>
						Delete <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<td colspan="6" class="cell-6 left"><%=StringUtils.toHtml(blCargo.getDescription())%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<a name="blMarkNo_start" id="blMarkNo_start"></a>
<div id="blMarkNo" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">MarkNo</div>
		<div class="column right">
			<%
				if (canVerifyingBL) {
			%>
			<a href="javascript: void(0);"
				onclick="editBlMaster('<%=bl.getBlMasterId()%>')">New</a>
			<%
				}
			%>
		</div>
	</div>
	<div id="content">
		<table width="100%">
			<thead>
				<tr>
					<td class="cell-5">MarkNo</td>
					<td class="cell-5" width="15%">Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BlMarkNo blMarkNo : bl.getBlMarkNoList()) {
				%>
				<tr>
					<td class="cell-6 left"><%=blMarkNo.getMarkNo()%></td>
					<td class="cell-4 center">
						<%
							if (canVerifyingBL) {
						%> <a href="javascript: void(0);"
						onclick="doEditBlMarkNo('<%=contextPath%>/blconfirm/blMarkNoAdmin/editBlMarkNo.do', '<%=blMarkNo.getBlMarkNoId()%>', '<%=blMarkNo.getBlMasterId()%>')">Edit</a>
						Delete <%
 	}
 %>
						<%
							if (canProcessingBL) {
						%> <a href="javascript: void(0);" onclick="edit('BlCargo')">Process</a>
						<a href="javascript: void(0);" onclick="edit('BlCargo')">Accept</a> <%
 	}
 %>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<a name="blContainer_start" id="blContainer_start"></a>
<div id="blContainer" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Container Detail</div>
		<div class="column right">
			<%
				if (canVerifyingBL) {
			%>
			<a href="javascript: void(0);"
				onclick="editBlMaster('<%=bl.getBlMasterId()%>')">New</a>
			<%
				}
			%>
		</div>
	</div>
	<div id="content">
		<table width="100%">
			<thead>
				<tr>
					<td class="cell-5">Container No.</td>
					<td class="cell-5">Container Type</td>
					<td class="cell-5">Container Size</td>
					<td class="cell-5">Container Height</td>
					<td class="cell-5">Seal No.(1)</td>
					<td class="cell-5">No. of Pkg.</td>
					<td class="cell-5">Gross Wt.</td>
					<td class="cell-5">Gross Meas.</td>
					<td class="cell-5" width="15%">Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BlContainer blContainer : bl.getBlContainerList()) {
				%>
				<tr>
					<td class="cell-6 center"><%=blContainer.getContainerNo()%></td>
					<td class="cell-6 center"><%=blContainer.getContainerType()%></td>
					<td class="cell-6 center"><%=blContainer.getContainerSize()%></td>
					<td class="cell-6 center"><%=blContainer.getContainerHeight()%></td>
					<td class="cell-6 center"><%=blContainer.getSealNo1()%></td>
					<td class="cell-6 center"><%=blContainer.getQty()%></td>
					<td class="cell-6 center"><%=blContainer.getGrossWt()%></td>
					<td class="cell-6 center"><%=blContainer.getGrossMeas()%></td>
					<td class="cell-6 center">
						<%
							if (canVerifyingBL) {
						%> <a href="javascript: void(0);" onclick="edit('BlCtrOfBl')">Edit</a>
						Delete <%
 	}
 %>
						<%
							if (canProcessingBL) {
						%> <a href="javascript: void(0);" onclick="edit('BlCtrOfBl')">Process</a>
						<a href="javascript: void(0);" onclick="edit('BlCtrOfBl')">Accept</a> <%
 	}
 %>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<a name="blNote_start" id="blNote_start"></a>
<div id="blNote" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Notes</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="editBlMaster('<%=bl.getBlMasterId()%>')">New</a>
		</div>
	</div>
	<div id="content">
		Note<br /> <input id="btnEditBlMaster" type="button"
			name="btnEditBlMaster" value="Edit" onclick="edit('BlNote')" />
	</div>
</div>
<a name="blStatus_start" id="blStatus_start"></a>
<div id="blStatus" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Status</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="editBlMaster('<%=bl.getBlMasterId()%>')">New</a>
		</div>
	</div>
	<div id="content">
		<table width="100%">
			<thead>
				<tr>
					<td class="cell-5">Status</td>
					<td class="cell-5">UserId</td>
					<td class="cell-5">Time</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BlConfirmStatus blStatus : bl.getBlConfirmStatusList()) {
				%>
				<tr>
					<td class="cell-6"><%=blStatus.getStatus()%></td>
					<td class="cell-6"><%=blStatus.getCreator()%></td>
					<td class="cell-6"><%=StringUtils.toDateString(blStatus.getDateCreated())%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<div id="blOther" class="container">
	<div class="titleBar">
		<div id="title" class="left">Others</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Booking ID</td>
				<td width="30%" class="cell-4"><%=bl.getBlMasterId()%></td>
				<td width="20%" class="cell-3">Status</td>
				<td width="30%" class="cell-4 bl-<%=bl.getStatus()%>"><%=bl.getStatus()%>&nbsp;<%=bl.getStatusUserId()%>&nbsp;<%=StringUtils.toDateString(bl.getStatusTime())%></td>
			</tr>
			<tr>
				<td class="cell-3">Office</td>
				<td class="cell-4"><%=bl.getOfficeCode()%></td>
				<td class="cell-3">Agent-Direct Agent</td>
				<td class="cell-4"><%=bl.getAgentCode()%> - <%=bl.getDirectAgentCode()%></td>
			</tr>
			<tr>
				<td class="cell-3">Created by</td>
				<td class="cell-4"><%=bl.getCreator() + "&nbsp;"
					+ StringUtils.toDateString(bl.getDateCreated())%></td>
				<td class="cell-3">Modified by</td>
				<td class="cell-4"><%=bl.getModifier() + "&nbsp;"
					+ StringUtils.toDateString(bl.getLastModified())%></td>
			</tr>
		</table>
	</div>
</div>
<%
	if (canSubmitBL) {
%>
<div id="" class="container">
	<div class="titleBar">
		<div id="title" class="left">Submit BL Confirm</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Remark</td>
				<td class="cell-4" colspan="3"><textarea name="remark" rows="5"
						cols="61" style="width: 480px;"></textarea></td>
			</tr>
			<tr>
				<td class="cell-4" align="left"></td>
				<td class="cell-4" align="left"><input id="btnSaveBlMaster"
					type="button" name="btnSaveBlMaster" value="Submit"
					onclick="saveBlMaster()" /></td>
			</tr>
		</table>
	</div>
</div>
<%
	}
%>

<%
	if (canUpdateSDS) {
%>
<div id="" class="container">
	<div class="titleBar">
		<div id="title" class="left">Update SDS</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Remark</td>
				<td class="cell-4" colspan="3"><textarea name="remark" rows="5"
						cols="61" style="width: 480px;"></textarea></td>
			</tr>
			<tr>
				<td class="cell-4" align="left"></td>
				<td class="cell-4" align="left"><input id="btnSaveBlMaster"
					type="button" name="btnSaveBlMaster" value="Update SDS"
					onclick="saveBlMaster()" /></td>
			</tr>
		</table>
	</div>
</div>
<%
	}
%>

<div id="blconfirm-action" class="container">
	<div id="actionbar" class="actionBar row">
		<div class="column left">
			<%
				if (canDonotVerifyBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="No Correction Notice" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canVerifyBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Correction Notice" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canUnsubmitBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Unsubmit" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canProcessBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Process" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canProcessingBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Accept All" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canProcessingBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Reject All" onclick="edit('BlNote')" />
			<%
				}
			%>
			<%
				if (canDeleteBL) {
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="Delete This BL" onclick="edit('BlNote')" />
			<%
				}
			%>
			<input id="btnEditBlMaster" type="button" name="btnEditBlMaster"
				value="goto Booking List" onclick="gotoList()" />
		</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="jumpToPosition('blView_start')">Top</a>
		</div>
	</div>
</div>


