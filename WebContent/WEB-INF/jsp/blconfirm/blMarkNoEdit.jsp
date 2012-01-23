<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.blconfirm.entity.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	BlMarkNo blMarkNo = (BlMarkNo) request.getAttribute("blMarkNo");
%>
<div id="editBlMarkNo">
	<form id="frmBlMarkNo" name="frmBlMarkNo">
		<input type="hidden" name="blMarkNoId"
			value="<%=blMarkNo.getBlMarkNoId()%>"> <input type="hidden"
			name="blMasterId" value="<%=blMarkNo.getBlMasterId()%>"> 
		<table border=1 width="100%" cellspacing=0 cellpadding="0">
			<tr>
				<td width="25%" class="cell-3">MarkNo</td>
				<td class="cell-4"><textarea name="description" rows="5"
						cols="61" style="width: 480px"><%=blMarkNo.getMarkNo()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="2" align="center"><input
					id="btnSaveBlMarkNo" type="button" name="btnSaveBlMarkNo"
					value="Save"
					onclick="doSaveBlMarkNo('<%=contextPath%>/blconfirm/blMarkNoAdmin/saveBlMarkNo.do')" />
					<input type="button" name="btnCancel" value="Cancel"
					onclick="doCancel()" /></td>
			</tr>
		</table>
	</form>
</div>
