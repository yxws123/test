<%@ page language="java"
	import="java.util.*,com.kline.util.*,
	org.nutz.dao.QueryResult"
	contentType="text/plain; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	//String url = ParamUtil.getRequestURLWithoutPageNo(request);
	String url = (String) request.getAttribute("url");

	QueryResult qr = (QueryResult) request.getAttribute("queryResult");
	//List<BkgMaster> list = (List<BkgMaster>) qr.getList();
%>
<div class="row" id="list_footer">
	<div class="column" id="list_footer_1"
		style="background-color: #EEEEEE; width: 50%; line-height: 30px; text-align: left; vertical-align: middle">
		Total:
		<%=qr.getPager().getRecordCount()%>
		| PageSize:
		<%=qr.getPager().getPageSize()%>
		| Page:
		<%=PagerHelper.getPageNo(qr.getPager().getPageNumber(), qr
					.getPager().getPageCount())%>/<%=qr.getPager().getPageCount()%></div>
	<div class="column" id="list_footer_2"
		style="background-color: #EEEEEE; width: 50%; line-height: 30px; text-align: right; vertical-align: middle">
		<%
			if (PagerHelper.isFirstPage(qr.getPager().getPageNumber())) {
		%>
		[First]
		<%
			} else {
		%>
		[<a href="javascript: void(0);" onclick="doSearch('<%=url%>', 'pageNo=1')">First</a>]
		<%
			}
		%>
		<%
			if (PagerHelper.hasPrevPage(qr.getPager().getPageNumber())) {
		%>
		[<a href="javascript: void(0);"
			onclick="doSearch('<%=url%>', 'pageNo=<%=qr.getPager().getPageNumber() - 1%>')">Prev</a>]
		<%
			} else {
		%>
		[Prev]
		<%
			}
		%>
		<%
			if (PagerHelper.hasNextPage(qr.getPager().getPageNumber(), qr
					.getPager().getPageCount())) {
		%>
		[<a href="javascript: void(0);"
			onclick="doSearch('<%=url%>', 'pageNo=<%=qr.getPager().getPageNumber() + 1%>')">Next</a>]
		<%
			} else {
		%>
		[Next]
		<%
			}
		%>
		<%
			if (PagerHelper.isLastPage(qr.getPager().getPageNumber(), qr
					.getPager().getPageCount())) {
		%>
		[Last]
		<%
			} else {
		%>
		[<a href="javascript: void(0);"
			onclick="doSearch('<%=url%>', 'pageNo=<%=qr.getPager().getPageCount()%>')">Last</a>]
		<%
			}
		%>
	</div>
</div>
