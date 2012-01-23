<%@ page language="java"
	import="java.util.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.booking.entity.BkgMaster"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	//String url = ParamUtil.getRequestURLWithoutPageNo(request);
	String url = (String) request.getAttribute("url");

	QueryResult qr = (QueryResult) request
			.getAttribute("queryResult");
	List<BkgMaster> list = (List<BkgMaster>) qr.getList();
%>
<form id="frmList" name="frmList">
	<table id="list" class="list">
		<thead>
			<tr>
				<th><input name="selectAll" type="checkbox" value=""
					onclick="doSelectAll(this)" />
				</th>
				<th>BookingID</th>
				<th>BLNo</th>
				<th>Office</th>
				<th>AgentCode</th>
				<th>ShipperRefNo</th>
				<th>Ocean Vessel</th>
				<th>Voyage</th>
				<th>PlaceOfDelivery</th>
				<th>Status</th>
				<!--
				<th>StatusBy</th>
				<th>StatusAt</th>
				-->
			</tr>
		</thead>
		<tbody>
			<%
				for (BkgMaster bkgMaster : list) {
			%>
			<tr onmousemove="doChangeClass(this, 'hl')"
				onmouseout="doChangeClass(this, '')">
				<td class="center"><input name="bkgMasterId" type="checkbox"
					value="<%=bkgMaster.getBkgMasterId()%>"></td>
				<td class="center"><a href="javascript: void(0);"
					onclick="viewBooking('<%=contextPath%>/booking/bookingAdmin/viewBooking.do', '<%=bkgMaster.getBkgMasterId()%>')"><%=bkgMaster.getBkgMasterId()%></a>
				</td>
				<td class="center"><%=StringUtils.toBriefString(bkgMaster.getBlno(), 0)%></td>
				<td class="center"><%=bkgMaster.getOfficeCode()%></td>
				<td class="center"><%=bkgMaster.getAgentCode()%></td>
				<td class="center"><%=StringUtils.trim(bkgMaster.getShipperRefNo())%></td>
				<td class="center"><%=StringUtils.trim(bkgMaster.getOceanVesselName())%></td>
				<td class="center"><%=StringUtils.trim(bkgMaster.getOceanVoyage())%></td>
				<td class="center"
					title="<%=StringUtils.trim(bkgMaster.getPlaceCodeOfDelivery())%>"><%=StringUtils.trim(bkgMaster.getPlaceNameOfDelivery())%></td>
				<td class="center <%="bkg-" + bkgMaster.getStatus()%>"><%=StringUtils.trim(bkgMaster.getStatus())%><BR>
					<%=StringUtils.trim(bkgMaster.getStatusUserId())%><BR> <%=StringUtils.toDateString(bkgMaster.getStatusTime())%>
				</td>
				<!--
				<td class="center"><%=StringUtils.trim(bkgMaster.getStatusUserId())%></td>
				<td class="center"><%=StringUtils.toDateString(bkgMaster.getStatusTime())%></td>
				-->
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</form>
<jsp:include page="../footer4List.jsp" />

