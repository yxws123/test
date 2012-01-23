<%@ page language="java"
	import="java.util.*,org.nutz.dao.QueryResult,com.kline.util.*,com.kline.core.entity.User"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	QueryResult qr = (QueryResult) request.getAttribute("queryResult");
	List<User> list = (List<User>) qr.getList();
	//List<User> list = (List<User>) request.getAttribute("users");
%>
<form id="frmList" name="frmList">
	<table id="list" class="list">
		<thead>
			<tr>
				<th><input name="selectAll" type="checkbox" value=""
					onclick="doSelectAll(this)" />
				</th>
				<th>UserID</th>
				<th>Office</th>
				<th>User<BR>Type</th>
				<th>AgentCode</th>
				<th>Role</th>
				<th>Enabled</th>
				<th>Email</th>
				<th>Last Access Time</th>
			</tr>
		</thead>
		<tbody>

			<%
				for (User user : list) {
			%>
			<tr onmousemove="doChangeClass(this, 'hl')"
				onmouseout="doChangeClass(this, '')">
				<td class="center"><input name="userId" type="checkbox"
					value="<%=user.getUserId()%>"
					<%=(user.isAdmin()) ? "disabled" : ""%>></td>
				<td class="center"><a href="javascript: void(0);"
					onclick="doEditUser('<%=contextPath%>/core/userAdmin/editUser.do', '<%=user.getUserId()%>')"><%=user.getUserId()%></a>
				</td>
				<td class="center"><%=user.getOfficeCode()%></td>
				<td class="center"><%=user.getUserType()%></td>
				<td class="center"><%=StringUtils.trim(user.getAgentCode())%></td>
				<td class="center"><%=StringUtils.trim(user.getRole())%></td>
				<td class="center"><%=user.getEnabled()%></td>
				<td title="<%=StringUtils.toBriefString(user.getEmail(), 0)%>"><%=StringUtils.toBriefString(user.getEmail(), 50)%></td>
				<td class="center"><%=StringUtils.toDateString(user.getLastVisitTime())%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</form>
<jsp:include page="../../footer4List.jsp" />
