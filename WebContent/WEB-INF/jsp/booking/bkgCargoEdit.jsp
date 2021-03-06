<%@ page language="java"
	import="java.util.*,com.kline.*, com.kline.util.*,org.nutz.dao.QueryResult,com.kline.booking.entity.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	BkgCargo bkgCargo = (BkgCargo) request.getAttribute("bkgCargo");
%>
<div id="editBkgCargo">
	<form id="frmBkgCargo" name="frmBkgCargo">
		<input type="hidden" name="bkgCargoId" value="<%= bkgCargo.getBkgCargoId() %>"> 
		<input type="hidden" name="bkgMasterId" value="<%= bkgCargo.getBkgMasterId() %>"> 
		<input type="hidden" name="outerPkgTypeCode" value="<%= bkgCargo.getOuterPkgTypeCode() %>"> 
		<input type="hidden" name="innerPkgtypeCode" value="<%= bkgCargo.getInnerPkgTypeCode() %>">
		<table border=1 width="100%" cellspacing=0 cellpadding="0">
			<tr>
				<td width="25%" class="cell-3">Cargo Type</td>
				<td class="cell-4"><select name="cargoTypeCode">
						<option value="ORD">Ordinary</option>
						<option value="REF">Reefer</option>
						<option value="DAN">Dangerous</option>
						<option value="OOG">Non Standard</option>
				</select></td>
			</tr>
			<tr>
				<td class="cell-3">Outer Pkg. Type</td>
				<td class="cell-4"><input type="text" name="outerPkgTypeName"
					value="<%= bkgCargo.getOuterPkgTypeName() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Outer Qty.</td>
				<td class="cell-4"><input type="text" name="outerQty"
					value="<%= bkgCargo.getOuterQty() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Inner Pkg. Type</td>
				<td class="cell-4"><input type="text" name="innerPkgTypeName"
					value="<%= bkgCargo.getInnerPkgTypeName() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Inner Qty.</td>
				<td class="cell-4"><input type="text" name="innerQty"
					value="<%= bkgCargo.getInnerQty() %>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Gross Wt.</td>
				<td class="cell-4"><input type="text" name="grossWt"
					value="<%= bkgCargo.getGrossWt() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Gross Meas.</td>
				<td class="cell-4"><input type="text" name="grossMeas"
					value="<%= bkgCargo.getGrossMeas() %>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Description</td>
				<td class="cell-4"><textarea name="description"
						rows="5" cols="61" style="width: 480px"><%= bkgCargo.getDescription() %></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="2" align="center"><input
					id="btnSaveBkgCargo" type="button" name="btnSaveBkgCargo"
					value="Save" onclick="saveBkgCargo()" /> <input type="button"
					name="btnCancel" value="Cancel" onclick="doCancel()" />
				</td>
			</tr>
		</table>
	</form>
</div>
