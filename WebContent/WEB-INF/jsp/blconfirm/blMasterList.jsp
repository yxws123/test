<%@ page language="java"
	import="java.util.*,
	com.kline.util.*,
	org.nutz.dao.QueryResult,
	com.kline.blconfirm.*,
	com.kline.blconfirm.entity.BlMaster"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	//String url = ParamUtil.getRequestURLWithoutPageNo(request);
	String url = (String) request.getAttribute("url");

	QueryResult qr = (QueryResult) request.getAttribute("queryResult");
	List<BlMaster> list = (List<BlMaster>) qr.getList();
%>
<form id="frmList" name="frmList">
	<table id="list" class="list">
		<thead>
			<tr>
				<th><input name="selectAll" type="checkbox" value=""
					onclick="doSelectAll(this)" />
				</th>
				<th>ID</th>
				<th>BLNo</th>
				<th>Office</th>
				<th>AgentCode</th>
				<th>ShipperRefNo</th>
				<th>Ocean Vessel</th>
				<th>Voyage</th>
				<th>Cut Off</th>
				<th>Status</th>
				<!--
				<th>StatusBy</th>
				<th>StatusAt</th>
				-->
			</tr>
		</thead>
		<tbody>
			<%
				for (BlMaster blMaster : list) {
			%>
			<tr onmousemove="doChangeClass(this, 'hl')"
				onmouseout="doChangeClass(this, '')">
				<td class="center"><input name="blMasterId" type="checkbox"
					value="<%=blMaster.getBlMasterId()%>"></td>
				<td class="center"><a href="javascript: void(0);"
					onclick="viewBL('<%=contextPath%>/blconfirm/blAdmin/viewBL.do', '<%=blMaster.getBlMasterId()%>')"><%=blMaster.getBlMasterId()%></a>
				</td>
				<td class="center"><%=StringUtils.toBriefString(blMaster.getBlno(), 0)%></td>
				<td class="center"><%=blMaster.getOfficeCode()%></td>
				<td class="center"><%=blMaster.getAgentCode()%></td>
				<td class="center"><%=StringUtils.trim(blMaster.getShipperRefNo())%></td>
				<td class="center"><%=StringUtils.trim(blMaster.getOceanVesselName())%></td>
				<td class="center"><%=StringUtils.trim(blMaster.getOceanVoyage())%></td>
				<td class="center"><%=StringUtils.toDateString(blMaster.getDateCutOff())%></td>
				<td class="center <%="bl-" + blMaster.getStatus()%>"><%=BlConfirmHelper.getBlConfirmStatusName(blMaster.getStatus())%><BR>
					<%=StringUtils.trim(blMaster.getStatusUserId())%><BR> <%=StringUtils.toDateString(blMaster.getStatusTime())%>
				</td>
				<!--
				<td class="center"><%=StringUtils.trim(blMaster.getStatusUserId())%></td>
				<td class="center"><%=StringUtils.toDateString(blMaster.getStatusTime())%></td>
				-->
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</form>
<jsp:include page="../footer4List.jsp" />
