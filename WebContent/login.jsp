<%@ page language="java" import="java.util.*,com.kline.core.entity.User"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	//List<User> list = (List<User>)request.getAttribute("users");
	
	String errMsg = (String)request.getAttribute("errMsg");
	//String errMsg = "error UserID or Password!";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>KLine E-Service System | Login</title>
<link rel="stylesheet" href="<%=contextPath%>/css/style.css"
	type="text/css" media="screen, projection" />
<script src="<%=contextPath%>/include/jquery.js" type="text/javascript"></script>
<script type="text/javascript">

$(function(){
	<% if (null != errMsg && !"".equals(errMsg)){ %>
	$("#tr_errMsg").css("display", "");
	$("#errMsg").empty().append("<%= errMsg %>");
	<% } %>	
});

function doLogin() {
	$("#frmLogin").attr("action", "<%=contextPath%>/core/userAdmin/login.do").submit();
	}
</script>
</head>
<body>
	<div id="login">
		<form id="frmLogin" name="frmLogin" method="post" target="_top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th colspan="2" style="line-height: 30px">Welcome to "K"LINE
						E-Service System</th>
				</tr>
				<tr>
					<td width="35%" align="right">User ID:</td>
					<td><input id="userId" type="text" name="userId" value="" />
					</td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td><input id="password" type="password" name="password"
						value="" /></td>
				</tr>
				<tr id="tr_errMsg" style="display: none">
					<td></td>
					<td><div id="errMsg" class="errorMsg"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="btnLogin"
						type="button" name="btnLogin" value="Login" style="width: 75px;"
						onclick="doLogin()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
