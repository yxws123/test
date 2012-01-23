<%@ page language="java"
	import="java.util.*,com.kline.*,com.kline.util.*,org.nutz.dao.QueryResult,com.kline.blconfirm.entity.*"
	contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	BlCargo blCargo = (BlCargo) request.getAttribute("blCargo");
%>
<div id="editBlCargo">
	<form id="frmBlCargo" name="frmBlCargo">
		<input type="hidden" name="blCargoId"
			value="<%=blCargo.getBlCargoId()%>"> <input type="hidden"
			name="blMasterId" value="<%=blCargo.getBlMasterId()%>"> <input
			type="hidden" name="outerPkgTypeCode"
			value="<%=blCargo.getOuterPkgTypeCode()%>"> <input
			type="hidden" name="innerPkgtypeCode"
			value="<%=blCargo.getInnerPkgTypeCode()%>">
		<table border=1 width="100%" cellspacing=0 cellpadding="0">
			<tr>
				<td width="25%" class="cell-3">Cargo Type</td>
				<td class="cell-4"><select name="cargoTypeCode">
						<option value="ORD">Ordinary</option>
						<option value="REF">Reefer</option>
						<option value="DAN">Dangerous</option>
						<option value="OOG">Non Standard</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="cell-3">Outer Pkg. Type</td>
				<td class="cell-4"><input type="text" name="outerPkgTypeName"
					value="<%=blCargo.getOuterPkgTypeName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Outer Qty.</td>
				<td class="cell-4"><input type="text" name="outerQty"
					value="<%=blCargo.getOuterQty()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Inner Pkg. Type</td>
				<td class="cell-4"><input type="text" name="innerPkgTypeName"
					value="<%=blCargo.getInnerPkgTypeName()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Inner Qty.</td>
				<td class="cell-4"><input type="text" name="innerQty"
					value="<%=blCargo.getInnerQty()%>" maxlength="20">
				</td>
			</tr>
			<tr>
				<td class="cell-3">Gross Wt.</td>
				<td class="cell-4"><input type="text" name="grossWt"
					value="<%=blCargo.getGrossWt()%>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Gross Meas.</td>
				<td class="cell-4"><input type="text" name="grossMeas"
					value="<%=blCargo.getGrossMeas()%>" maxlength="20"></td>
			</tr>
			<tr>
				<td class="cell-3">Description</td>
				<td class="cell-4"><textarea name="description" rows="5"
						cols="61" style="width: 480px"><%=blCargo.getDescription()%></textarea>
				</td>
			</tr>
			<tr>
				<td class="cell-4" colspan="2" align="center"><input
					id="btnSaveBlCargo" type="button" name="btnSaveBlCargo"
					value="Save"
					onclick="doSaveBlCargo('<%=contextPath%>/blconfirm/blCargoAdmin/saveBlCargo.do')" />
					<input type="button" name="btnCancel" value="Cancel"
					onclick="doCancel()" /></td>
			</tr>
		</table>
	</form>
</div>
