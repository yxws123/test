function doSearch(url, sData) {
	// alert("doSearch()!" + msg);
	// $("#list").css("display", "none");

	// var url = "<%=contextPath%>/core/agent/findAgent.do";

	// var sData = $("#frmSearch").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(agentCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#listArea #content").empty().append(data);
			$("#listArea #content").show();

			// alert(oAgent);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}

function doSelectAll(thisCheckbox) {
	$("#frmList :checkbox[name='agentCode']").attr("checked",
			thisCheckbox.checked);
	// $("#frmList input:disabled").attr("checked", false);
	// $("#frmList").find("input[type='checkbox'][name='agentCode']").find("input:disabled").attr("checked",
	// thisCheckbox.checked);
}

function gotoList() {
	$("#viewArea").hide();
	$("#listArea").show();
	// jumpToPosition('listArea_start');
}

function doNewAgent() {
	doEditAgent('');
}

function doEditAgent(url, agentCode) {

	// var url = "<%=contextPath%>/core/agent/editAgent.do";

	var sData = "action=create&agentCode=";

	var editTitle = null;
	if (agentCode != '') {
		sData = "action=edit&agentCode=" + agentCode;
		editTitle = "Edit Agent";
	} else {
		editTitle = "New Agent";
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(agentCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#editAgent #editTitle").empty().append(editTitle);
			$("#editAgent #content").empty().append(data);

			$("#listArea").hide();
			$("#viewArea #viewAgent").hide();
			$("#viewArea #editAgent").show();
			$("#viewArea").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});
}

/**
 * function doEditAgent(agentCode) { $("#list_block").css("display", "none");
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

function doSave(url) {

//	var url = "<%=contextPath%>/core/agent/saveAgent.do";

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
			 * if (data == null) { alert(agentCode + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			$("#viewArea").hide();
			$("#listArea").show();
//			showMsg($("#frmEdit").serialize());
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});
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

function doDeleteAgent() {
	alert('doDeleteAgent');
}

function getParentAgentCodeList(url) {
	var officeCode = $("#frmEdit [name='officeCode']").val();
	/**
	if (officeCode == '') {
		$("#frmEdit [name='agentCode']").empty().append(
				'<option value=\"\">AgentCode</option>');
		return;
	}
	*/
	var agentType = $("#frmEdit [name='agentType']").val();
	// agentType = 'A';
	// alert(officeCode + ":" + agentType);
	if (agentType != 'D') {
		$("#tr_parentAgentCode").hide();
		$("#frmEdit [name='parentAgentCode']").empty().append(
				'<option value=\"\"></option>');
	
		$("#tr_isDirectBooking").show();

		return;
	}

	$("#tr_isDirectBooking").hide();
	
	//var url = "<%=contextPath%>/core/agent/findAgent4Office.do";

	var sData = "officeCode=" + officeCode + "&agentType=A&directBookingFlag=Y";
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "json",
		success : function(data) {
			//alert(data);
			$("#frmEdit [name='parentAgentCode']").empty();
			//.append(
//					'<option value=\"\">AgentCode</option>');
			$.each(data, function(i, agent) {
				$("#frmEdit [name='parentAgentCode']").append(
						'<option value=\"' + agent.agentCode + '\">'
								+ agent.agentCode + '</option>');
			});
			
			$("#tr_parentAgentCode").show();

			/**
			 * alert(data.length); for (var i = 0; i < data.length; i ++) { }
			 */
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}

function doOpenDialog(url) {
	// $("#selectPayer").css("display", "");
	var officeCode = $("#frmEdit [name='officeCode']").val(); 
	var agentType = $("#frmEdit [name='agentType']").val();
	url += "?officeCode=" + officeCode;
	$('#selectPayer').modal({
		containerCss : {
			minHeight : 480,
			minWidth : 600
		},
		onShow: function(dialog) {
			doSearchPayer(url);
		}
	});
}

function doSearchPayer(url) {
//	 alert("doSearchPayer: " + url);

//	var url = "<%= contextPath %>/sds/payer/findPayer.do";

	var sData = '';
//		$("#frmSearchPayer").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(agentCode + " not found!");
			 *  // error processing
			 * 
			 * return; }
			 */

			$("#payer_list_block").empty().append(data);

			$("#payer_list_block").show();

			// alert(oAgent);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		}
	});
}

function doSelectPayer(rPayer, url) {
	var payerCode = rPayer.id;
	// alert(payerCode);

	var office = $("#payerList").find("#" + payerCode).find("#office").text();
	var payerName = $("#payerList").find("#" + payerCode).find("#payerName")
			.text();
	var payerCName = $("#payerList").find("#" + payerCode).find("#payerCName")
			.text();
	var bookingReference = $("#payerList").find("#" + payerCode).find(
			"#bookingReference").text();

	// alert(s + "\n\r" + payerName);

//	var url = "<%= contextPath %>/core/agent/isExistAgent.do";
	var sData = "agentCode=" + payerCode;
	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(result) {
			// alert(result);
			/**
			 * if (result == null) { alert(agentCode + " not found!");
			 *  // error processing
			 * 
			 * return; }
			 */

			if (result == 'true') {
//				alert("Agent exists: " + payerCode);
				showMsg(payerCode + " has been already added!");
				// $('#msg_block').modal();
			} else {
				// alert(result + ":" + payerCode);
				$("#frmEdit").find("#agentCode").attr("value", payerCode);
				$("#frmEdit").find("#agentName").attr("value", payerName);
				$("#frmEdit").find("#bookingReference").attr("value",
						bookingReference);

				// $("#selectPayer").css("display", "none");
				$.modal.close();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		}
	});

}
