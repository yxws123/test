<%@ page language="java"
	import="java.util.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.core.entity.*,com.kline.booking.entity.*,com.kline.booking.helper.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	User myAccount = AuthUtil.getMyAccount(request);

	BkgMaster booking = (BkgMaster) request.getAttribute("booking");

	boolean canCreateBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_CREATE, null);
	boolean canReadBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_READ, booking);
	boolean canUpdateBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_UPDATE, booking);
	boolean canDeleteBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_DELETE, booking);
	boolean canSubmitBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_SUBMIT, booking);
	boolean canUnsubmitBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_UNSUBMIT, booking);
	boolean canProcessBooking = BookingHelper.canDoAction(myAccount,
			BookingHelper.BKG_ACT_PROCESS, booking);
	boolean canCopyBooking = canReadBooking && canCreateBooking;
%>
<script type="text/javascript">
<!--
//-->
</script>

<div id="" class="row" style="border-bottom: 0px solid #CCCCFF;">
	<div style="margin: 0 auto; border: 0px solid; width: 589px;">
		<div id="tab_bkgMaster" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgMaster')">Master</a>
		</div>
		<div id="tab_bkgCargo" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgCargo')">Cargo</a>
		</div>
		<div id="tab_bkgMarkNo" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgMarkNo')">MarkNo</a>
		</div>
		<div id="tab_bkgCtrOfBkg" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgCtrOfBkg')">Container
				Of Booking</a>
		</div>
		<div id="tab_bkgContainer" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgContainer')">Container
				Details</a>
		</div>
		<div id="tab_bkgNote" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgNote')">Notes</a>
		</div>
		<div id="tab_bkgStatus" class="column tab">
			<a href="javascript:void(0)" onclick="activeTab('bkgStatus')">Status</a>
		</div>
	</div>
</div>
<a name="bkgMaster_start" id="bkgMaster_start"></a>
<div id="bkgMaster" class="container container-f">
	<div class="titleBar">
		<div id="title" class="left">Master</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td class="cell-3" width="20%">B/L No.</td>
				<td class="cell-4" width="30%"><%=StringUtils.trim(booking.getBlno())%></td>
				<td class="cell-3" width="20%">ShipperRefNo</td>
				<td class="cell-4" width="30%"><%=StringUtils.trim(booking.getShipperRefNo())%></td>
			</tr>
			<tr>
				<td class="cell-3">Vessel</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getOceanVesselName())%>
				</td>
				<td class="cell-3">Pre-Vessel</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPreVesselName())%></td>
			</tr>
			<tr>
				<td class="cell-3">Voyage</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getOceanVoyage())%></td>
				<td class="cell-3">Pre-Voyage</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPreVesselVoyage())%></td>
			</tr>
			<tr>
				<td class="cell-3">Service</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getServiceCode())%></td>
				<td class="cell-3">Next Service</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Sailing Date</td>
				<td class="cell-4"><%=StringUtils.toDateString(booking.getSailingDate())%></td>
				<td class="cell-3"></td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Receipt Type - Delivery Type</td>
				<td class="cell-4"><%=StringUtils
					.trim(booking.getBkgMasterA().getRecTypeCode())%> - <%=StringUtils
					.trim(booking.getBkgMasterA().getDelTypeCode())%></td>
				<td class="cell-3">B/L Form Type</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA().getBlType())%></td>
			</tr>
			<tr>
				<td class="cell-3">Place Of B/L Issued</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPlaceNameOfBLIssued())%></td>
				<td class="cell-3">No. Of Original B/L</td>
				<td class="cell-4"><%=booking.getBkgMasterA().getNoOfOriginalBL()%></td>
			</tr>
			<tr>
				<td class="cell-3">Full/LCL</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getFullLclFlag())%></td>
				<td class="cell-3">Master LCL No.</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getMasterLclNo())%></td>
			</tr>
			<tr>
				<td class="cell-3">Payment Type</td>
				<td class="cell-4" colspan=3><%=StringUtils
					.trim(booking.getBkgMasterA().getPaymentType())%></td>
			</tr>
			<tr>
				<td class="cell-3">Prepaid At</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPrepaidAtName())%></td>
				<td class="cell-3">Payable At</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPayableAtName())%></td>
			</tr>
			<tr>
				<td class="cell-3">S/C No.</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(booking.getBkgMasterA().getScNo())%></td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4">Ports</td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Rec.</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPlaceNameOfReceipt())%></td>
				<td class="cell-3">Place Of Rec. Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Load Port</td>
				<td class="cell-4"><%=StringUtils
					.trim(booking.getBkgMasterA().getRecTypeCode())%></td>
				<td class="cell-3">Load Port Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Discharge Port</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getDischargePortName())%></td>
				<td class="cell-3">Discharge Port Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Place Of Delivery</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getPlaceNameOfDelivery())%></td>
				<td class="cell-3">Place Of Delivery Print</td>
				<td class="cell-4"></td>
			</tr>
			<tr>
				<td class="cell-3">Transhipment Port</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA()
					.getTranshipmentPortName())%></td>
				<td class="cell-3">GateInCode</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA().getGateInCode())%></td>
			</tr>
			<tr>
				<td class="cell-3 category left" colspan="4">Parties</td>
			</tr>
			<tr>
				<td class="cell-3">NVOCC Status</td>
				<td class="cell-4"><%=StringUtils
					.trim(booking.getBkgMasterA().getNvoccStatus())%></td>
				<td class="cell-3">NVO No.</td>
				<td class="cell-4"><%=StringUtils.trim(booking.getBkgMasterA().getNvoNo())%>
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Shipper</td>
				<td class="cell-4" colspan="3"><%=StringUtils
					.trim(booking.getBkgMasterA().getShipperName())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils.toHtml(booking.getBkgMasterA()
					.getShipperAddress())%></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Consignee</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(booking.getBkgMasterA()
					.getConsigneeName())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils.toHtml(booking.getBkgMasterA()
					.getConsigneeAddress())%></td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="2">Notify-1</td>
				<td class="cell-4" colspan="3"><%=StringUtils.trim(booking.getBkgMasterA()
					.getNotify_1Name())%></td>
			</tr>
			<tr>
				<td class="cell-4" colspan="3"><%=StringUtils.toHtml(booking.getBkgMasterA()
					.getNotify_1Address())%></td>
			</tr>
		</table>
	</div>
	<div id="actionBar" class="actionBar row">
		<div class="column left">
			<%
				if (canUpdateBooking) {
			%>
			<a href="javascript: void(0);"
				onclick="doEditBkgMaster('<%=contextPath%>/booking/bookingAdmin/editBkgMaster.do', '<%=booking.getBkgMasterId()%>')">Edit
				Master</a>
			<%
				}
			%>
		</div>
		<div class="column right">
			<a href="javascript: void(0);" onclick="jumpToPosition('bookingView_start')">Top</a>
		</div>
	</div>
</div>
<a name="bkgCargo_start" id="bkgCargo_start"></a>
<div id="bkgCargo" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Cargo</div>
		<div class="column right">
			<%
				if (canUpdateBooking) {
			%>
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
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
					for (BkgCargo bkgCargo : booking.getBkgCargoList()) {
				%>
				<tr>
					<td class="cell-6"><%=bkgCargo.getCargoTypeCode()%></td>
					<td class="cell-6"><%=bkgCargo.getOuterPkgTypeName()%></td>
					<td class="cell-6"><%=bkgCargo.getOuterQty()%></td>
					<td class="cell-6"><%=bkgCargo.getGrossWt()%></td>
					<td class="cell-6"><%=bkgCargo.getGrossMeas()%></td>
					<td class="cell-6">
						<%
							if (canUpdateBooking) {
						%> <a href="javascript: void(0);"
						onclick="editBkgCargo('<%=bkgCargo.getBkgCargoId()%>', '<%=bkgCargo.getBkgMasterId()%>')">Edit</a>
						Delete <%
 	} else {
 %> Edit Delete <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<td colspan="6" class="cell-6 left"><%=StringUtils.toHtml(bkgCargo.getDescription())%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<a name="bkgMarkNo_start" id="bkgMarkNo_start"></a>
<div id="bkgMarkNo" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">MarkNo</div>
		<div class="column right">
			<%
				if (canUpdateBooking) {
			%>
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
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
					for (BkgMarkNo bkgMarkNo : booking.getBkgMarkNoList()) {
				%>
				<tr>
					<td class="cell-6 left"><%=bkgMarkNo.getMarkNo()%></td>
					<td class="cell-4 center">
						<%
							if (canUpdateBooking) {
						%> <a href="javascript: void(0);"
						onclick="edit('BkgCargo')">Edit</a> Delete <%
 	} else {
 %> Edit
						Delete <%
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
<a name="bkgCtrOfBkg_start" id="bkgCtrOfBkg_start"></a>
<div id="bkgCtrOfBkg" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Container of Booking</div>
		<div class="column right">
			<%
				if (canUpdateBooking) {
			%>
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
			<%
				}
			%>
		</div>
	</div>
	<div id="content">
		<table width="100%">
			<thead>
				<tr>
					<td class="cell-5">Container Type</td>
					<td class="cell-5">Container Size</td>
					<td class="cell-5">Container Height</td>
					<td class="cell-5">Reefer As Dry</td>
					<td class="cell-5">No. Of Ctr.</td>
					<td class="cell-5">SOC</td>
					<td class="cell-5" width="15%">Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BkgCtrOfBkg bkgCtrOfBkg : booking.getBkgCtrOfBkgList()) {
				%>
				<tr>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getContainerType()%></td>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getContainerSize()%></td>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getContainerHeight()%></td>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getReeferAsDry()%></td>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getNoOfCtr()%></td>
					<td class="cell-6 center"><%=bkgCtrOfBkg.getSoc()%></td>
					<td class="cell-6 center">
						<%
							if (canUpdateBooking) {
						%> <a href="javascript: void(0);"
						onclick="edit('BkgCtrOfBkg')">Edit</a> Delete <%
 	} else {
 %> Edit
						Delete <%
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
<a name="bkgContainer_start" id="bkgContainer_start"></a>
<div id="bkgContainer" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Container Detail</div>
		<div class="column right">
			<%
				if (canUpdateBooking) {
			%>
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
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
					<td class="cell-5">Seal No.</td>
					<td class="cell-5">No. of Pkg.</td>
					<td class="cell-5">Gross Wt.</td>
					<td class="cell-5">Gross Meas.</td>
					<td class="cell-5" width="15%">Actions</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (BkgContainer bkgContainer : booking.getBkgContainerList()) {
				%>
				<tr>
					<td class="cell-6 center"><%=bkgContainer.getContainerNo()%></td>
					<td class="cell-6 center"><%=bkgContainer.getContainerType()%></td>
					<td class="cell-6 center"><%=bkgContainer.getContainerSize()%></td>
					<td class="cell-6 center"><%=bkgContainer.getContainerHeight()%></td>
					<td class="cell-6 center"><%=bkgContainer.getSealNo()%></td>
					<td class="cell-6 center"><%=bkgContainer.getNoOfPkg()%></td>
					<td class="cell-6 center"><%=bkgContainer.getGrossWt()%></td>
					<td class="cell-6 center"><%=bkgContainer.getGrossMeas()%></td>
					<td class="cell-6 center">
						<%
							if (canUpdateBooking) {
						%> <a href="javascript: void(0);"
						onclick="edit('BkgCtrOfBkg')">Edit</a> Delete <%
 	} else {
 %> Edit
						Delete <%
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
<a name="bkgNote_start" id="bkgNote_start"></a>
<div id="bkgNote" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Notes</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
		</div>
	</div>
	<div id="content">
		Note<br /> <input id="btnEditBkgMaster" type="button"
			name="btnEditBkgMaster" value="Edit" onclick="edit('BkgNote')" />
	</div>
</div>
<a name="bkgStatus_start" id="bkgStatus_start"></a>
<div id="bkgStatus" class="container">
	<div id="title" class="titleBar row">
		<div class="column left">Status</div>
		<div class="column right">
			<a href="javascript: void(0);"
				onclick="editBkgMaster('<%=booking.getBkgMasterId()%>')">New</a>
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
					for (BkgStatus bkgStatus : booking.getBkgStatusList()) {
				%>
				<tr>
					<td class="cell-6"><%=bkgStatus.getStatus()%></td>
					<td class="cell-6"><%=bkgStatus.getStatusUserId()%></td>
					<td class="cell-6"><%=StringUtils.toDateString(bkgStatus.getStatusTime())%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="actionbar" class="actionbar"></div>
</div>
<div id="bkgOther" class="container">
	<div class="titleBar">
		<div id="title" class="left">Others</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Booking ID</td>
				<td width="30%" class="cell-4"><%=booking.getBkgMasterId()%></td>
				<td width="20%" class="cell-3">Status</td>
				<td width="30%" class="cell-4 bkg-<%=booking.getStatus()%>"><%=booking.getStatus()%>&nbsp;<%=booking.getStatusUserId()%>&nbsp;<%=StringUtils.toDateString(booking.getStatusTime())%></td>
			</tr>
			<tr>
				<td class="cell-3">Office</td>
				<td class="cell-4"><%=booking.getOfficeCode()%></td>
				<td class="cell-3">Agent-Direct Agent</td>
				<td class="cell-4"><%=booking.getAgentCode()%> - <%=booking.getDirectAgentCode()%></td>
			</tr>
			<tr>
				<td class="cell-3">Created by</td>
				<td class="cell-4"><%=booking.getCreator() + "&nbsp;"
					+ StringUtils.toDateString(booking.getDateCreated())%></td>
				<td class="cell-3">Modified by</td>
				<td class="cell-4"><%=booking.getModifier() + "&nbsp;"
					+ StringUtils.toDateString(booking.getLastModified())%></td>
			</tr>
		</table>
	</div>
</div>
<%
	if (canSubmitBooking) {
%>
<div id="" class="container">
	<div class="titleBar">
		<div id="title" class="left">Submit Booking</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Remark</td>
				<td class="cell-4" colspan="3"><textarea name="remark" rows="5"
						cols="61" style="width: 480px;"></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" align="left"></td>
				<td class="cell-4" align="left"><input id="btnSaveBkgMaster"
					type="button" name="btnSaveBkgMaster" value="Submit"
					onclick="saveBkgMaster()" />
				</td>
			</tr>
		</table>
	</div>
</div>
<%
	}
%>

<%
	if (canProcessBooking) {
%>
<div id="" class="container">
	<div class="titleBar">
		<div id="title" class="left">Process Booking</div>
	</div>
	<div id="content">
		<table class="width100">
			<tr>
				<td width="20%" class="cell-3">Remark</td>
				<td class="cell-4" colspan="3"><textarea name="remark" rows="5"
						cols="61" style="width: 480px;"></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" align="left"></td>
				<td class="cell-4" align="left"><input id="btnSaveBkgMaster"
					type="button" name="btnSaveBkgMaster" value="Accept"
					onclick="saveBkgMaster()" /><input id="btnSaveBkgMaster"
					type="button" name="btnSaveBkgMaster" value="Reject"
					onclick="saveBkgMaster()" />
				</td>
			</tr>
		</table>
	</div>
</div>
<%
	}
%>

<div id="booking-action" class="container">
	<div id="actionbar" class="actionBar row">
		<div class="column left">
			<%
				if (canUnsubmitBooking) {
			%>
			<input id="btnEditBkgMaster" type="button" name="btnEditBkgMaster"
				value="Unsubmit" onclick="edit('BkgNote')" />
			<%
				}
			%>
			<%
				if (canCopyBooking) {
			%>
			<input id="btnEditBkgMaster" type="button" name="btnEditBkgMaster"
				value="Copy" onclick="edit('BkgNote')" />
			<%
				}
			%>
			<%
				if (canDeleteBooking) {
			%>
			<input id="btnEditBkgMaster" type="button" name="btnEditBkgMaster"
				value="Delete" onclick="edit('BkgNote')" />
			<%
				}
			%>
			<input id="btnEditBkgMaster" type="button" name="btnEditBkgMaster"
				value="goto Booking List" onclick="gotoList()" />
		</div>
		<div class="column right">
			<a href="javascript: void(0);" onclick="jumpToPosition('bookingView_start')">Top</a>
		</div>
	</div>
</div>


