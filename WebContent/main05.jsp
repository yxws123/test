<%@ page language="java"
	import="java.util.*,com.kline.core.entity.User,com.kline.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	//List<User> list = (List<User>)request.getAttribute("users");

	User myAccount = AuthUtil.getMyAccount(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title>KLINE E-Service System</title>
</head>
<frameset cols="20%,*">
	<frame name="menu" src="<%= contextPath %>/menu.jsp">
	<frame name="main" src="<%= contextPath %>/blank.html">

	<noframes>
		<body>
			<p>此网页使用了框架，但您的浏览器不支持框架。</p>
		</body>
	</noframes>
</frameset>

</html>
