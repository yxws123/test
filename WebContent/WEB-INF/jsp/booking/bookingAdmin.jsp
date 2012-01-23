<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.booking.entity.BkgMaster"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>KLine E-Service System | Login</title>
<link rel="stylesheet" href="<%=contextPath%>/css/style.css"
	type="text/css" media="screen, projection" />
<!-- Contact Form CSS files -->
<link type='text/css' href='<%=contextPath%>/css/basic.css'
	rel='stylesheet' media='screen' />
<script src="<%=contextPath%>/include/jquery.js" type="text/javascript"></script>
<script type='text/javascript'
	src='<%=contextPath%>/js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/booking.js'></script>
<script type="text/javascript">$(function() {
		/**
		 $("#btnGo").bind("click", function(){
		 alert("doSearch()");
		 $("#list").css("display", "none");
		 });
		 */
		$("#btnSearch").bind("click", function() {
			var sData = $("#frmSearch").serialize();
			doSearch('<%=contextPath%>/booking/bookingAdmin/findBkgMaster.do',
									sData);
						});

		$("#viewArea").hide();
		$("#listArea").show();

	});
//-->
</script>
</head>
<body>
	<div id="listArea">
		<a name="listArea_start" id="listArea_start"></a>
		<div id="title" class="breadcrumb">Booking List</div>
		<div id="actionbar" class="actionbar">
			<div class="row" style="margin-left: 0.5em;">
				<form id="frmSearch" name="frmSearch">
					<input type="text" name="bkgMasterId" value="BoookingID"
						style="color: #CCCCCC; width: 90px;"
						onfocus="doFocus(this, 'BoookingID')"
						onblur="doBlur(this, 'BoookingID')" /> <input type="text"
						name="blno" value="BLNo" style="color: #CCCCCC; width: 90px;"
						onfocus="doFocus(this, 'BLNo')" onblur="doBlur(this, 'BLNo')" />
					<select name="officeCode">
						<option value="">Office</option>
						<%
							for (String officeCode : Constants.officeArray) {
						%>
						<option value="<%=officeCode%>"><%=officeCode%></option>
						<%
							}
						%>
					</select> <select name="agentCode">
						<option value="">Agent Code</option>
					</select><select name="oceanVesselCode">
						<option value="">Ocean Vessel</option>
					</select><select name="oceanVoyage">
						<option value="">Ocean Voyage</option>
					</select><select name="status">
						<option value="">Status</option>
						<option value="D">Draft</option>
						<option value="P">Pending</option>
						<option value="N">New</option>
						<option value="A">Accepted</option>
						<option value="R">Rejected</option>
					</select><select name="orderBy">
						<option value="0">Order By</option>
						<option value="1">BkgMasterId</option>
						<option value="2">BkgMasterName</option>
					</select><input id="btnSearch" name="btnSearch" type="button" value="Search" />
				</form>
			</div>
			<div class="row" style="padding-left: 3px;">
				<input id="btnNewBkgMaster" name="btnNewBkgMaster" type="button"
					value="New BkgMaster" onclick="doNewBkgMaster()" /> <input
					id="btnDeleteBkgMaster" name="btnDeleteBkgMaster" type="button"
					value="Delete BkgMaster" onclick="doDeleteBkgMaster()" />
			</div>
		</div>
		<div id="content" style="display: "></div>
	</div>
	<div id="viewArea" style="display: ">
		<a name="bookingView_start" id="bookingView_start"></a>
		<div id="viewBooking">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">Booking List</a>
				>> Booking: <span id="id"></span>
			</div>
			<div id="content"></div>
		</div>
		<div id="editBooking" style="display: none;">
			<div id="title" class="breadcrumb">
				<a href="javascript: void(0);" onclick="gotoList()">Booking List</a>
				>> Booking: <a href="javascript: void(0);" onclick="doCancel()"><span
					id="id"></span> </a> >> <span id="editTitle"></span>
			</div>
			<div id="content"></div>
		</div>
	</div>
</body>
</html>
