<%@ page language="java" 
	import="java.util.*,
			com.kline.core.entity.User,
			com.kline.util.*"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String contextPath = request.getContextPath();
  //List<User> list = (List<User>)request.getAttribute("users");

  User myAccount = AuthUtil.getMyAccount(request);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>KLine China E-Service System</title>
<link rel="stylesheet" href="<%= contextPath %>/css/style.css" type="text/css" media="screen, projection" />
<link href="<%= contextPath %>/include/xtree/xtree.css" rel="stylesheet" type="text/css" />
<script src="<%= contextPath %>/include/jquery.js" type="text/javascript"></script>
<script language="JavaScript" src="<%= contextPath %>/include/xtree/xtree.js" type="text/javascript"></script>
<script  type="text/javascript">
<!--
/**
function doLogout() {
	$("#frmLogin").attr("action", "<%= contextPath %>/main05.jsp").submit();
}
*/
//->
</script>
</head>
<body style="background-color: #FFF; margin: 0;">
<div class="row">
  <div class="column" id="left_side">
    <div id="logo"> "K"LINE China E-Service </div>
    <div id="logonInfo"><%= myAccount.getUserId() %><br />
      <%= StringUtils.toDateString(myAccount.getLastVisitTime()) %><br />
      <a href="javascript: void(0)">My Account</a> | <a href="<%= contextPath %>/core/user/logout.do" target="_top">Logout</a></div>
    <div id="side_menu">
<script language="javascript">
  if (document.getElementById) {
	  webFXTreeConfig.setRootIconPath('<%= contextPath %>/include/xtree');	 
	  webFXTreeConfig.setDefaultTarget('main');	 
	  
    	// Booking
        var a1 = new WebFXTree('Booking', '' );
		a1.setBehavior('classic');

        var a10 = new WebFXTreeItem('New Booking', '<%= contextPath %>/booking/bookingAdmin/newBooking.do' );
        a1.add( a10 );

        var a11 = new WebFXTreeItem('Booking List', '<%= contextPath %>/booking/bookingAdmin/entry.do' );
        a1.add( a11 );

        var a12 = new WebFXTreeItem('Search', 'net.kline.actions.BkgMasterBAction.do?actn=toFind' );
        a1.add( a12 );

        var a13 = new WebFXTreeItem('with new modification request', 'net.kline.actions.ModBookingAction.do?actn=find&Status=N' );
        a1.add( a13 );

        var a14 = new WebFXTreeItem('Print Booking in 2008', 'net.kline.actions.PrnBkgAction.do?actn=toFind&After=2008-01-01' );
        a1.add( a14 );

        var a15 = new WebFXTreeItem('Canceled Sail', 'net.kline.actions.SailMasterBAction.do?actn=find' );
        a1.add( a15 );

        var a16 = new WebFXTreeItem('Report', 'net.kline.actions.BookingRptAction.do?actn=toFind' );
        a1.add( a16 );

        var a2 = new WebFXTree('BL Management', '');
		a2.setBehavior('classic');

        var a21 = new WebFXTreeItem('Upload by BL', 'net.kline.actions.BLConfirmAction.do?actn=newBLConfirm');
        a2.add( a21 );

        var a22 = new WebFXTreeItem('Upload by Vessel', 'net.kline.actions.BLConfirmAction.do?actn=newBLConfirmByVessel');
        a2.add( a22 );

        var a23 = new WebFXTreeItem('Correction Notice', '<%= contextPath %>/blconfirm/blAdmin/entryPoint.do');
        a2.add( a23 );

        var a24 = new WebFXTreeItem('Processing', 'net.kline.actions.BLMasterAction.do?actn=find&Prefix=&BNo=&OceanVesselCode=&OceanVoyage=&Status=5&after=2005-1-1');
        a2.add( a24 );
        
        var a25 = new WebFXTreeItem('Search', 'net.kline.actions.BLMasterAction.do?actn=toFind&after=2005-1-1');
        a2.add( a25 );
        
        var a26 = new WebFXTreeItem('Correction Report', 'net.kline.actions.BLCorrectionRptAction.do?actn=toFind');
        a2.add( a26 );
        
        var a27 = new WebFXTreeItem('BL To Print', 'net.kline.actions.BLToPrintAction.do?actn=find');
        a2.add( a27 );

//        document.write(a2);

        var a3 = new WebFXTree('Configuration', '');
   		a3.setBehavior('classic');

        var a31 = new WebFXTreeItem('User', '<%= contextPath %>/core/userAdmin/entryPoint.do' );
        a3.add( a31 );

        var a32 = new WebFXTreeItem('Agent', '<%= contextPath %>/core/agentAdmin/entryPoint.do' );
        a3.add( a32 );

        var a34 = new WebFXTreeItem('Dan. Key Words', 'net.kline.actions.DanKeyWordAction.do?actn=find');
        a3.add( a34 );

        var a35 = new WebFXTreeItem('Blacklist', 'net.kline.actions.BlacklistAction.do?actn=find');
        a3.add( a35 );

        var a36 = new WebFXTreeItem('BLNo Settings', 'net.kline.actions.BlNoConfAction.do?actn=find');
        a3.add( a36 );

//        document.write(a3);

        var a4 = new WebFXTree('Schedule Search', 'net.kline.actions.SailAction.do?actn=toFind' );
   		a4.setBehavior('classic');

        var a43 = new WebFXTreeItem('Service', 'net.kline.actions.ServiceAction.do?actn=list&Page=1');
        a4.add( a43 );


//        document.write(a4);

/**                
        var a8 = new WebFXTreeItem('Change Password', 'net.kline.actions.UserAction.do?actn=editpass' );
        a0.add( a8 );

        var apm = new WebFXTreeItem('Payment Management', 'net.kline.actions.pm.PaymentMgtAction.do');
        a0.add( apm );
        
        var a7 = new WebFXTreeItem('Logout', 'net.kline.actions.LoginAction.do?actn=logout');
        a0.add( a7 );
*/            

        document.write(a1);
        document.write(a2);
        document.write(a3);
        document.write(a4);
  }
</script>
    </div>
  </div>
</div>
</body>
</html>
