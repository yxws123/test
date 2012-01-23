<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.core.entity.User"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>KLine E-Service System | Login</title>
<link rel="stylesheet" href="<%=contextPath%>/css/style.css"
	type="text/css" media="screen, projection" />
<script src="<%=contextPath%>/include/jquery.js"
	type="text/javascript"></script>
<script type='text/javascript' src='<%=contextPath%>/js/userAdmin.js'></script>
<script type="text/javascript">
<!--
var officeArray = new Array();
<%for (int i = 0; i < Constants.officeArray.length; i++) {%>
	officeArray[<%=i%>] = new Object();
	officeArray[<%=i%>].officeCode = "<%=Constants.officeArray[i]%>";
	officeArray[<%=i%>].directAgent = new Object();
	officeArray[<%=i%>].directAgent.isLoad = false;
	officeArray[<%=i%>].directAgent.agentArray = new Array();	
	officeArray[<%=i%>].agent = new Object();
	officeArray[<%=i%>].agent.isLoad = false;	
	officeArray[<%=i%>].agent.agentArray = new Array();	
<%}%>

	$(function() {
		$("#btnSearch").bind("click", function() {
			var sData = $("#frmSearch").serialize();
			doSearch('<%=contextPath%>/core/userAdmin/findPage.do',
									sData);
						});
		
		//$("#msg_block").hide();
		$("#viewArea").hide();
		$("#listArea").show();

	});
	//->
</script>
</head>
<body>
<!-- 
	<div id="breadcrumb">User Management</div>
	<div id="msg_block">
		<span id="msg"></span>
	</div>
 -->
	<div id="listArea">
		<div id="title" class="breadcrumb">User List</div>
		<div id="actionbar" class="actionbar row">
			<div class="column" style="margin-left: 0.5em;">
				<form id="frmSearch" name="frmSearch">
					<input type="text" name="userId" value="UserID"
						style="color: #CCCCCC; width: 70px;"
						onfocus="doFocus(this, 'UserID')" onblur="doBlur(this, 'UserID')" />
					<select name="officeCode" onchange="getAgentCodeList('<%=contextPath%>/core/agent/findAgent4Office.do')">
						<option value="">Office</option>
						<%
							for (String officeCode : Constants.officeArray) {
						%>
						<option value="<%=officeCode%>"><%=officeCode%></option>
						<%
							}
						%>
					</select> <select name="userType" onchange="getAgentCodeList('<%=contextPath%>/core/agent/findAgent4Office.do')">
						<option value="">User Type</option>
						<option value="I">Internal</option>
						<option value="A">Agent</option>
						<option value="D">Direct Agent</option>
					</select> <select name="agentCode">
						<option value="">AgentCode</option>
					</select> <select name="roleId">
						<option value="">Role</option>
					</select> <select name="enabled">
						<option value="">Enabled</option>
					</select><select name="orderBy">
						<option value="0">Order By</option>
						<option value="1">UserID</option>
						<option value="2">AgentCode</option>
					</select> <input id="btnSearch" name="btnSearch" type="button" value="Search" />
				</form>
			</div>
			<div class="column" style="padding-left: 3px;">
				<input id="btnNewUser" name="btnNewUser" type="button"
					value="New User" onclick="doEditUser('<%=contextPath%>/core/userAdmin/editUser.do', '')" /> <input id="btnEnable"
					name="btnEnable" type="button" value="Enable"
					onclick="doEnable('Y')" /> <input id="btnDisable"
					name="btnDisable" type="button" value="Disable"
					onclick="doEnable('N')" />
			</div>

		</div>
		<div id="content" style="display: "></div>
	</div>
	<div id="viewArea" style="display: ">
		<div id="viewUser">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">User List</a>
				>> User: <span id="id"></span>
			</div>
			<div id="content"></div>
		</div>
		<div id="editUser" style="display: none;">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">User List</a>
				>> <span id="editTitle"></span>
			</div>
			<div id="content"></div>
		</div>
	</div>
</body>
</html>
