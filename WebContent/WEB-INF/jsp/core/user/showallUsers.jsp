<%@ page language="java" 
	import="java.util.*,
			com.kline.core.entity.User"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  String contextPath = request.getContextPath();
  List<User> list = (List<User>)request.getAttribute("users");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShowAllUsers</title>
<script type="text/javascript" src="<%= contextPath %>/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  //alert("ready!");	
  /**
  $("tr").bind("click", function(){
	  alert("getUser");
	  $.get("<%= contextPath %>/mvc/User/showUser.do", {userid: "admin"}, function(data){		  
		  alert(data.userCode);
		  //var oUser = jQuery.parseJSON(data);
		  //alert(oUser);
	  }, "json");
  });
  */
});

function getUser(userCode) {
	  alert(userCode);
	  var url = "<%= contextPath %>/mvc/User/showUser.do";
	  var sData = "userid=" + userCode;
	  alert(sData);
	  $.ajax({
			  type: "POST",
			  url: url, 
			  data: sData, 
	  		  dataType: "json",
			  success: function(data){	
				if (data == null) {
				  alert(userCode + " not found!");
				  
				  // error processing
				  return;
				}
				if (typeof(data.officeCode) == "undefined") {
			  		alert("officeCode undefined");					
				}
				if (typeof(data.userCode) == "undefined") {
				} else {
			  		alert(data.userCode);					
				}
		  		//var oUser = jQuery.parseJSON(data);
		  		//alert(oUser);
	  		  },
	  		  error: function(XMLHttpRequest, textStatus, errorThrown) {
	  			alert(textStatus);  
	  		  }
	  });	
}
</script>
</head>
<body>
<div id="userList">
User List
<table width="100%" border="1">
<tr>
<th>UserID</th>
<th>OfficeCode</th>
<th>UserType</th>
<th>Role</th>
<th>Enabled</th>
<th>Action</th>
</tr>
<%
  for (int i = 0; i < list.size(); i ++) {
	  User user = list.get(i);
%>
<tr>
<td id="userCode_<%= user.getUserId() %>">
<a href="javascript: getUser('<%= user.getUserId() %>');"><%= user.getUserId() %></a>
</td>
<td><%= user.getOfficeCode() %></td>
<td><%= user.getUserType() %></td>
<td><%= user.getRole() %></td>
<td><%= user.getEnabled() %></td>
<td>Edit Delete</td>
</tr>
<%	  
  }
%>
</table>
</div>
<div id="userEdit">
<form id="formUserEdit" action="">
<input id="" type=text value="">
<input id="" type=text value="">
<input id="btnSubmit" type=button name="btnSubmit" value="Submit">
</form>
</div>
</body>
</html>