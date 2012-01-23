<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.util.*,com.kline.core.entity.Agent"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	Agent agent = (Agent) request.getAttribute("agent");

	String action = ParamUtil.getString(request, "action", "");
	//String actn = (String)request.getAttribute("actn");
	boolean isEdit = "edit".equals(action);
%>
<div id="edit_block">
	<form id="frmEdit" name="frmEdit">
		<input id="actn" type="hidden" name="action" value="<%=action%>" />
		<table id="edit" class="edit">
			<tr>
				<td class="cell-3">Office</td>
				<td class="cell-4"><select id="officeCode" name="officeCode" onchange="getParentAgentCodeList('<%=contextPath%>/core/agentAdmin/findAgent4Office.do')">
						<%
							for (String officeCode : Constants.officeArray) {
						%>
						<option value="<%=officeCode%>"
							<%=officeCode.equals(agent.getOfficeCode()) ? "selected"
						: ""%>><%=officeCode%></option>
						<%
							}
						%>
				</select>
				</td>
			</tr>
			<tr>
				<td class="cell-3">Agent Type</td>
				<td class="cell-4"><select id="agentType" name="agentType" onchange="getParentAgentCodeList('<%=contextPath%>/core/agentAdmin/findAgent4Office.do')">
						<option value="A">Agent</option>
						<option value="D">Direct Agent</option>
				</select>
				</td>
			</tr>
			<tr id="tr_parentAgentCode" style="display: none;">
				<td class="cell-3">Parent AgentCode</td>
				<td class="cell-4"><select id="parentAgentCode" name="parentAgentCode">
						<option value=""></option>
				</select>
				</td>
			</tr>
			<tr>
				<td width="25%" class="cell-3">AgentCode</td>
				<td class="cell-4"><input id="agentCode" type="text"
					name="agentCode" value="<%=agent.getAgentCode()%>" /> <input
					id="btnSelectAgentCode" type="button" name="btnSelectAgentCode"
					value="..." onclick="doOpenDialog('<%=contextPath%>/sds/payerAdmin/findPayer.do')"></td>
			</tr>
			<tr>
				<td class="cell-3">AgentName</td>
				<td class="cell-4"><textarea id="agentName" name="agentName"
						cols="60" rows="2"><%=agent.getAgentName()%></textarea>
				</td>
			</tr>
			<tr id="tr_isDirectBooking">
				<td class="cell-3"></td>
				<td class="cell-4"><input id="isDirectBooking"
					name="isDirectBooking" type="checkbox" value="Y"
					<%=agent.isDirectBooking() ? "checked" : ""%> />Is KLINE
					Forwarding</td>
			</tr>
			<tr id="tr_agentCode" style="display: ">
				<td class="cell-3">Booking Reference</td>
				<td class="cell-4"><input id="bookingReference" type="text"
					name="bookingReference" value="<%=agent.getBookingReference()%>" />
				</td>
			</tr>
			<tr>
				<td class="cell-3" rowspan="3">Email notice</td>
				<td class="cell-4"><input id="emailNotice4BkgAccepted"
					name="emailNotice4BkgAccepted" type="checkbox" value="Y"
					<%=agent.isEmailNotice4BkgAccepted() ? "checked" : ""%> /> booking
					accepted</td>
			</tr>
			<tr>
				<td class="cell-4"><input id="emailNotice4BkgRejected"
					name="emailNotice4BkgRejected" type="checkbox" value="Y"
					<%=agent.isEmailNotice4BkgRejected() ? "checked" : ""%> /> booking
					rejected</td>
			</tr>
			<tr>
				<td class="cell-4"><input id="emailNotice4CNCPSEnabled"
					name="emailNotice4CNCPSEnabled" type="checkbox" value="Y"
					<%=agent.isEmailNotice4CNCPSEnabled() ? "checked" : ""%> /> CNCPS</td>
			</tr>
			<tr>
				<td class="cell-3">Email</td>
				<td class="cell-4"><textarea id="email" name="email" cols="60"
						rows="2"><%=agent.getEmail()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3">Address</td>
				<td class="cell-4"><textarea id="address" name="address"
						cols="60" rows="2"><%=agent.getAddress()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-3">Tel</td>
				<td class="cell-4"><input id="tel" type="text" name="tel"
					value="<%=agent.getTel()%>" />
				</td>
			</tr>
			<tr>
				<td class="cell-3">Fax</td>
				<td class="cell-4"><input id="fax" type="text" name="fax"
					value="<%=agent.getFax()%>" />
				</td>
			</tr>
			<tr>
				<td class="cell-3">Contact</td>
				<td class="cell-4"><input id="contact" type="text"
					name="contact" value="<%=agent.getContact()%>" />
				</td>
			</tr>
			<%
				if ("edit".equals(action)) {
			%>
			<tr>
				<td colspan="2" class="cell-3 category left">Others</td>
			</tr>
			<tr>
				<td class="cell-3">Creator</td>
				<td class="cell-4"><%=agent.getCreator()%></td>
			</tr>
			<tr>
				<td class="cell-3">Created at</td>
				<td class="cell-4"><%=StringUtils.toDateString(agent.getDateCreated())%></td>
			</tr>
			<tr>
				<td class="cell-3">Modifier</td>
				<td class="cell-4"><%=agent.getModifier()%></td>
			</tr>
			<tr>
				<td class="cell-3">Modified at</td>
				<td class="cell-4"><%=StringUtils.toDateString(agent.getLastModified())%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td class="cell-3"></td>
				<td class="cell-4"><input id="btnSaveAgent" type="button"
					name="btnSaveAgent" value="Save"
					onclick="doSave('<%=contextPath%>/core/agentAdmin/saveAgent.do')" />
					<input id="btnCancelEdit" name="btnCancelEdit" type="button"
					name="" value="Cancel" onclick="doCancelEdit()" /></td>
			</tr>
		</table>
	</form>
</div>
<div id="selectPayer" class="container container-f"
	style="display: none">
	<div id="title" class="titleBar">
		<div class="left">Select AgentCode <span id="msg"></span></div>
	</div>
	<div id="actionbar" class="actionbar row" style="display: none;">
		<form id="frmSearchPayer" name="frmSearchPayer">
			<select name="officeCode">
				<%
					for (String officeCode : Constants.officeArray) {
				%>
				<option value="<%=officeCode%>"><%=officeCode%></option>
				<%
					}
				%>
			</select> <input type="text" name="payerCode" value="PayerCode"
				style="color: #CCCCCC" onfocus="doFocus(this, 'PayerCode')"
				onblur="doBlur(this, 'PayerCode')" /> <input id="btnSearchPayer"
				name="btnSearchPayer" type="button" value="Search"
				onclick="doSearchPayer('<%=contextPath%>/sds/payerAdmin/findPayer.do')" />
		</form>
	</div>	
	<div id="payer_list_block" style="height: 440px; overflow: auto;"></div>
</div>
