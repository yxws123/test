<%@ page language="java" 
	import="java.util.*,
			com.kline.*,
			com.kline.util.*,
			com.kline.core.entity.User"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  String contextPath = request.getContextPath();
  User user = (User)request.getAttribute("user");
  
  String action = ParamUtil.getString(request, "action", "");
  //String actn = (String)request.getAttribute("actn");
%>
  <form id="frmEdit" name="frmEdit">
    <input id="actn" type="hidden" name="action" value="<%= action %>" />
    <table id="edit" class="edit">
      <tr>
        <td width="25%" class="cell-3">UserID</td>
        <td class="cell-4"><input id="userId" type="text" name="userCode" value="<%= user.getUserId() %>" /></td>
      </tr>
      <tr>
        <td class="cell-3">Office</td>
        <td class="cell-4"><select id="officeCode" name="officeCode" onchange="getAgentCodeList4Edit('<%=contextPath%>/core/agentAdmin/findAgent4Office.do')">
      <% for (String officeCode : Constants.officeArray) { %>
      <option value="<%= officeCode %>" <%= officeCode.equals(user.getOfficeCode()) ? "selected" : "" %>><%= officeCode %></option>      
      <% } %>
					</select></td>
      </tr>
      <tr>
        <td class="cell-3">User Type</td>
        <td class="cell-4">
          <select id="userType" name="userType" onchange="getAgentCodeList4Edit('<%=contextPath%>/core/agentAdmin/findAgent4Office.do')">
							<option value="I">Internal</option>
							<option value="A">Agent</option>
							<option value="F">KLine Forwarding</option>
							<option value="D">Direct Booking Agent</option>
					</select></td>
      </tr>
      <tr id="tr_agentCode" style="display: none;">
        <td class="cell-3">AgentCode</td>
        <td class="cell-4"><select name="agentCode">
						<option value="">AgentCode</option>
					</select></td>
      </tr>
      <tr>
        <td class="cell-3">Role</td>
        <td class="cell-4"><select id="role" name="role">
            <option value="">Role</option>
          </select></td>
      </tr>
      <tr>
        <td class="cell-3"></td>
        <td class="cell-4"><input id="enabled" name="enabled" type="checkbox" value="Y" <%= user.isEnabled() ? "checked" : "" %> />
          Enabled</td>
      </tr>
      <tr>
        <td class="cell-3">Email</td>
        <td class="cell-4"><textarea id="email" name="email" cols="60" rows="2"><%= user.getEmail() %></textarea></td>
      </tr>
      <tr>
        <td colspan="2" class="cell-3 category left">Preferences</td>
      </tr>
      <tr>
        <td class="cell-3">Rows to display per page</td>
        <td class="cell-4"><input id="pageCount" type="text" name="pageCount" value="" /></td>
      </tr>
      <tr>
        <td class="cell-3">Email on</td>
        <td class="cell-4"><input id="" name="" type="checkbox" value="Y" checked /></td>
      </tr>
      <% if ("edit".equals(action)) {%>
      <tr>
        <td colspan="2" class="cell-3 category left">Others</td>
      </tr>
      <tr>
        <td class="cell-3">Last visit IP</td>
        <td class="cell-4"><%= StringUtils.trim(user.getLastVisitIp()) %></td>
      </tr>
      <tr>
        <td class="cell-3">Last visit time</td>
        <td class="cell-4"><%= StringUtils.toDateString(user.getLastVisitTime()) %></td>
      </tr>
      <tr>
        <td class="cell-3">Creator</td>
        <td class="cell-4"><%= user.getCreator() %></td>
      </tr>
      <tr>
        <td class="cell-3">Created at</td>
        <td class="cell-4"><%= StringUtils.toDateString(user.getDateCreated()) %></td>
      </tr>
      <tr>
        <td class="cell-3">Modifier</td>
        <td class="cell-4"><%= user.getModifier() %></td>
      </tr>
      <tr>
        <td class="cell-3">Modified at</td>
        <td class="cell-4"><%= StringUtils.toDateString(user.getLastModified()) %></td>
      </tr>
      <% } %>
      <tr>
        <td class="cell-3"></td>
        <td class="cell-4"><input id="btnSaveUser" type="button" name="btnSaveUser" value="Save" onclick="doSaveUser()" />
          <input id="btnCancelEdit" name="btnCancelEdit" type="button" name="" value="Cancel" onclick="doCancelEdit()" />
        </td>
      </tr>
    </table>
  </form>
<script type="text/javascript">
<!--
function doAgentCodeFocus() {
	$("#frmEdit").find("#agentCode").attr("type", "")
}
//-->
</script>

