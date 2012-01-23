<%@ page language="java"
	import="java.util.*,com.kline.util.*,com.kline.sds.entity.Payer"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	List<Payer> list = (List<Payer>) request.getAttribute("payerList");
%>
<table id="payerList" class="list">
	<thead>
		<tr>
			<th>Office</th>
			<th>PayerCode</th>
			<th>PayerName</th>
			<th>PayerCName</th>
			<th>Booking Reference</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (Payer payer : list) {
		%>
		<tr id="<%=StringUtils.trim(payer.getPayerCode())%>"
			onmousemove="doChangeClass(this, 'hl')"
			onmouseout="doChangeClass(this, '')" onclick="doSelectPayer(this, '<%= contextPath %>/core/agentAdmin/isExistAgent.do')">
			<td id="office"><%=payer.getOffice()%></td>
			<td id="payerCode"><a href="javascript: void(0);"
				onclick="javascript: void(0);"><%=StringUtils.trim(payer.getPayerCode())%></a>
			</td>
			<td id="payerName" title="<%=StringUtils.toBriefString(payer.getPayerName(), 0)%>"><%=StringUtils.trim(payer.getPayerName())%></td>
			<td id="payerCName" align="left"><%=StringUtils.trim(payer.getPayerCName())%></td>
			<td id="bookingReference"><%=StringUtils.trim(payer.getBookingReference())%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<div class="row" id="list_footer">
	<div class="column" id="list_footer_1"
		style="background-color: #EEEEEE; width: 50%; line-height: 30px; text-align: left; vertical-align: middle">
		Total: 346 | PageSize: 50 | Page: 2/7</div>
	<div class="column" id="list_footer_2"
		style="background-color: #EEEEEE; width: 50%; line-height: 30px; text-align: right; vertical-align: middle">
		[First] [Prev] [Next] [Last]</div>
</div>
