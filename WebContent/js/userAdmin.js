
function doSearch(url, sData) {

	// alert("doSearch()!" + msg);
	// $("#list").css("display", "none");

//	var url = "<%=contextPath%>/core/user/showAllusers.do";

//	var sData = $("#frmSearch").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(userCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#listArea #content").empty().append(data);
			$("#listArea #content").show();

			// alert(oUser);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		}
	});
}

function doSelectAll(thisCheckbox) {
	$("#frmList :checkbox[name='userId']").attr("checked",
			thisCheckbox.checked);
	$("#frmList input:disabled").attr("checked", false);
	// $("#frmList").find("input[type='checkbox'][name='userCode']").find("input:disabled").attr("checked",
	// thisCheckbox.checked);

}

function gotoList() {
	$("#viewArea").hide();
	$("#listArea").show();
	//jumpToPosition('listArea_start');
}

function doNewUser() {
	doEditUser('');
}

function doEditUser(url, userCode) {

//	var url = "<%=contextPath%>/core/user/editUser.do";

	var sData = "action=create&userId=";

	var editTitle = null;
	if (userCode != '') {
		sData = "action=edit&userId=" + userCode;
		editTitle = "Edit User";
	} else {
		editTitle = "New User";
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(userCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#editUser #editTitle").empty().append(editTitle);
			$("#editUser #content").empty().append(data);

			$("#listArea").hide();
			$("#viewArea #viewUser").hide();
			$("#viewArea #editUser").show();
			$("#viewArea").show();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});
}

/**
 * function doEditUser(userCode) { $("#list_block").css("display", "none");
 * 
 * showMsg("");
 * 
 * $("#tr_others").css("display", ""); $("#tr_lastVisitIp").css("display", "");
 * $("#tr_lastVisitTime").css("display", ""); $("#tr_creator").css("display",
 * ""); $("#tr_dateCreated").css("display", "");
 * $("#tr_lastModifier").css("display", "");
 * $("#tr_lastModified").css("display", "");
 * 
 * $("#edit_area").css("display", ""); }
 */

function doSaveUser() {

	var url = "<%=contextPath%>/core/user/saveUser.do";

	var sData = $("#frmEdit").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			alert(data);
			/**
			 * if (data == null) { alert(userCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oUser);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});

	$("#edit_area").hide();
	$("#list_area").show();
	showMsg($("#frmEdit").serialize());
}

function doCancelEdit() {
	$("#viewArea").hide();
	$("#listArea").show();
}

function doAction(thisSelect) {
	alert(thisSelect.value);
	thisSelect.options[0].selected = true;
}

function doEnable(enabled) {
	alert(enabled);
}

function showMsg(msg) {
	$("#msg").empty().append(msg);
}

function doChangeClass(tr, className) {
	tr.className = className;
}

function doFocus(thisInput, s) {
	if (thisInput.value == s) {
		thisInput.value = "";
		thisInput.style.color = "";
	}
}

function doBlur(thisInput, s) {
	if (thisInput.value == '') {
		thisInput.value = s;
		thisInput.style.color = "#EEEEEE";
	}
}

function getAgentCodeList(url) {
	// alert("getAgentCodeList...");

	var officeCode = $("#frmSearch [name='officeCode']").val();
	if (officeCode == '') {
		$("#frmSearch [name='agentCode']").empty().append(
				'<option value=\"\">AgentCode</option>');
		return;
	}
	var userType = $("#frmSearch [name='userType']").val();
	// userType = 'A';
	// alert(officeCode + ":" + userType);
	if (userType != 'A' && userType != 'D') {
		$("#frmSearch [name='agentCode']").empty().append(
				'<option value=\"\">AgentCode</option>');
		return;
	}
	var o = null;
	// alert(officeArray.length);
	for ( var i = 0; i < officeArray.length; i++) {
		// alert(i + ':' + officeArray[i].officeCode);
		if (officeArray[i].officeCode == officeCode) {
			if (userType == 'A') {
				o = officeArray[i].agent;
				break;
			} else if (userType == 'D') {
				o = officeArray[i].directAgent;
				break;
			}
			if (o === null) {
				// alert('null, return...');
				return;
			}
		}
	}

	if (o === null) {
		// alert('null000');
		return;
	} else {
		// alert('obj.isLoad: ' + o.isLoad);
		if (o.isLoad == true) {
			alert("loaded from cache...");
			$("#frmSearch [name='agentCode']").empty().append(
					'<option value=\"\">AgentCode</option>');

			for ( var i = 0; i < o.agentArray.length; i++) {
				$("#frmSearch [name='agentCode']").append(
						'<option value=\"' + o.agentArray[i] + '\">'
								+ o.agentArray[i] + '</option>');
			}
			return;
		}
	}

	// 
	//var url = "<%=contextPath%>/core/agent/findAgent4Office.do";

	var sData = "officeCode=";
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "json",
		success : function(data) {
			//alert(data);
			/**
			 * if (data == null) { alert(userCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oUser);
			$("#frmSearch [name='agentCode']").empty().append(
					'<option value=\"\">AgentCode</option>');
			$.each(data, function(i, agent) {
				o.agentArray[i] = agent.agentCode;
				$("#frmSearch [name='agentCode']").append(
						'<option value=\"' + agent.agentCode + '\">'
								+ agent.agentCode + '</option>')
			});
			/**
			 * alert(data.length); for (var i = 0; i < data.length; i ++) { }
			 */
			o.isLoad = true;
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}

function getAgentCodeList4Edit(url) {
	var officeCode = $("#frmEdit [name='officeCode']").val();
	/**
	if (officeCode == '') {
		$("#frmEdit [name='agentCode']").empty().append(
				'<option value=\"\">AgentCode</option>');
		return;
	}
	*/
	var userType = $("#frmEdit [name='userType']").val();
	// userType = 'A';
	// alert(officeCode + ":" + userType);
	if (userType == 'I') {
		$("#tr_agentCode").hide();
		$("#frmEdit [name='agentCode']").empty().append(
				'<option value=\"\">AgentCode</option>');
		return;
	}

	//var url = "<%=contextPath%>/core/agent/findAgent4Office.do";

	var sData = "officeCode=" + officeCode + "&userType=" + userType;
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "json",
		success : function(data) {
			//alert(data);
			/**
			 * if (data == null) { alert(userCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oUser);
			$("#frmEdit [name='agentCode']").empty();
			//.append(
//					'<option value=\"\">AgentCode</option>');
			$.each(data, function(i, agent) {
				$("#frmEdit [name='agentCode']").append(
						'<option value=\"' + agent.agentCode + '\">'
								+ agent.agentCode + '</option>');
			});
			
			$("#tr_agentCode").show();

			/**
			 * alert(data.length); for (var i = 0; i < data.length; i ++) { }
			 */
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}