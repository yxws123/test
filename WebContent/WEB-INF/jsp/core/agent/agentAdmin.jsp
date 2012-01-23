<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.core.entity.Agent"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>KLine E-Service System | Login</title>
<link rel="stylesheet" href="<%=contextPath%>/css/style.css"
	type="text/css" media="screen, projection" />
<!-- Contact Form CSS files -->
<link type='text/css' href='<%=contextPath%>/css/basic.css'
	rel='stylesheet' media='screen' />
<script src="<%=contextPath%>/include/jquery.js" type="text/javascript"></script>
<script type='text/javascript'
	src='<%=contextPath%>/js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/agentAdmin.js'></script>
<script type="text/javascript">
<!--
	$(function() {
		$("#btnSearch").bind("click", function() {
			var sData = $("#frmSearch").serialize();
			doSearch('<%=contextPath%>/core/agentAdmin/findPage.do',
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
	<div id="listArea">
		<div id="title" class="breadcrumb">Agent List</div>
		<div id="actionbar" class="actionbar row">
			<div class="column" style="margin-left: 0.5em;">
				<form id="frmSearch" name="frmSearch">
					<input type="text" name="agentCode" value="AgentCode"
						style="color: #CCCCCC; width: 90px;"
						onfocus="doFocus(this, 'AgentCode')"
						onblur="doBlur(this, 'AgentCode')" /> <input type="text"
						name="agentName" value="AgentName"
						style="color: #CCCCCC; width: 90px;"
						onfocus="doFocus(this, 'AgentName')"
						onblur="doBlur(this, 'AgentName')" /> <select name="officeCode">
						<option value="">Office</option>
						<%
							for (String officeCode : Constants.officeArray) {
						%>
						<option value="<%=officeCode%>"><%=officeCode%></option>
						<%
							}
						%>
					</select> <select name="agentType">
						<option value="">Agent Type</option>
						<option value="A">Agent</option>
						<option value="D">Direct Agent</option>
					</select><select name="orderBy">
						<option value="0">Order By</option>
						<option value="1">AgentCode</option>
						<option value="2">AgentName</option>
					</select><input id="btnSearch" name="btnSearch" type="button" value="Search" />
				</form>
			</div>
			<div class="column" style="padding-left: 3px;">
				<input id="btnNewAgent" name="btnNewAgent" type="button"
					value="New Agent" onclick="doEditAgent('<%=contextPath%>/core/agentAdmin/editAgent.do', '')" /> <input
					id="btnDeleteAgent" name="btnDeleteAgent" type="button"
					value="Delete Agent" onclick="doDeleteAgent()" />
			</div>
		</div>
		<div id="content" style="display: "></div>
	</div>
	<div id="viewArea" style="display: ">
		<div id="viewAgent">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">Agent List</a>
				>> Agent: <span id="id"></span>
			</div>
			<div id="content"></div>
		</div>
		<div id="editAgent" style="display: none;">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">Agent List</a>
				>> <span id="editTitle"></span>
			</div>
			<div id="content"></div>
		</div>
	</div>
</body>
</html>
