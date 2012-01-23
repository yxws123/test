<%@ page language="java"
	import="java.util.*,org.nutz.dao.QueryResult,com.kline.util.*,com.kline.core.entity.Agent"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	QueryResult qr = (QueryResult) request.getAttribute("queryResult");
	List<Agent> list = (List<Agent>) qr.getList();
	//List<Agent> list = (List<Agent>) request.getAttribute("agentList");
%>
<form id="frmList" name="frmList">
	<table id="list" class="list">
		<thead>
			<tr>
				<th rowspan="2"><input name="selectAll" type="checkbox"
					value="" onclick="doSelectAll(this)" /></th>
				<th rowspan="2">Office</th>
				<th rowspan="2">Agent<BR>Type</th>
				<th rowspan="2">AgentCode</th>
				<th rowspan="2">AgentName</th>
				<th rowspan="2">Booking<BR>Reference</th>
				<th colspan="3">EmailNotice</th>
				<th rowspan="2">Email</th>
			</tr>
			<tr>
				<th>booking<BR>rejected</th>
				<th>booking<BR>rejected</th>
				<th>CNCPS</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Agent agent : list) {
					String defaultCssClass = "";
					if (agent.isDirectBooking()) {
						defaultCssClass = "hl";
					}
			%>
			<tr class="<%= defaultCssClass %>" onmousemove="doChangeClass(this, 'hl')"
				onmouseout="doChangeClass(this, '<%= defaultCssClass %>')">
				<td class="center"><input name="agentCode" type="checkbox"
					value="<%=agent.getAgentCode()%>">
				</td>
				<td><%=agent.getOfficeCode()%></td>
				<td class="center"><%=agent.getAgentType()%></td>
				<td class="center"><a href="javascript: void(0);"
					onclick="doEditAgent('<%=contextPath%>/core/agentAdmin/editAgent.do', '<%=agent.getAgentCode()%>')"><%=agent.getAgentCode()%></a>
				</td>
				<td title="<%=StringUtils.toBriefString(agent.getAgentName(), 0)%>"><%=StringUtils.toBriefString(agent.getAgentName(), 30)%></td>
				<td class="center"><%=StringUtils.trim(agent.getBookingReference())%></td>
				<td class="center"><%=StringUtils.trim(agent.getEmailNotice4BkgAccepted())%></td>
				<td class="center"><%=StringUtils.trim(agent.getEmailNotice4BkgRejected())%></td>
				<td class="center"><%=StringUtils.trim(agent.getEmailNotice4CNCPSEnabled())%></td>
				<td title="<%=StringUtils.toBriefString(agent.getEmail(), 0)%>"><%=StringUtils.toBriefString(agent.getEmail(), 30)%></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</form>
<jsp:include page="../../footer4List.jsp" />
