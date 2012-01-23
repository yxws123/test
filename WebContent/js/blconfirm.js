// listArea
function doSearch(url, sData) {
	// alert("search()!" + msg);
	// $("#list").css("display", "none");

	//var sData = '';
	if (null == sData) {
		sData = '';
	}

	/**
	if (url == '') {
		url = "";
		sData = $("#frmSearch").serialize();
	} else {
		sData = "pageNo=" + pageNo;
	}
	*/

	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(blMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#listArea #content").empty().append(data);

			$("#listArea #content").show();

			// alert(oBlMaster);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		}
	});
}

function doSelectAll(thisCheckbox) {
	$("#frmList :checkbox[name='blMasterId']").attr("checked",
			thisCheckbox.checked);
	// $("#frmList input:disabled").attr("checked", false);
	// $("#frmList").find("input[type='checkbox'][name='blMasterId']").find("input:disabled").attr("checked",
	// thisCheckbox.checked);
}

function gotoList() {
	$("#viewArea").hide();
	$("#listArea").show();
	jumpToPosition('listArea_start');
}

function doNewBlMaster() {
	doViewBL('');
}

function viewBL(url, blMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/viewBL.do";

	var sData;	// = "action=create&blMasterId=";

	if (blMasterId != '') {
		sData = "action=edit&blMasterId=" + blMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(blMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#viewBL #content").empty().append(data);
			$("#viewBL #title #id").empty().append(blMasterId);

			// alert(oBlMaster);

			$("#listArea").hide();
//			showMsg("");

			$("#editBL").hide();
			$("#viewBL").show();
			$("#viewArea").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});

	/**
	 * $("#tr_others").css("display", "none");
	 * $("#tr_lastVisitIp").css("display", "none");
	 * $("#tr_lastVisitTime").css("display", "none");
	 * $("#tr_creator").css("display", "none");
	 * $("#tr_dateCreated").css("display", "none");
	 * $("#tr_lastModifier").css("display", "none");
	 * $("#tr_lastModified").css("display", "none");
	 */
}

/**
 * function doViewBL(blMasterId) { $("#list_block").css("display",
 * "none");
 * 
 * showMsg("");
 * 
 * $("#tr_others").css("display", ""); $("#tr_lastVisitIp").css("display", "");
 * $("#tr_lastVisitTime").css("display", ""); $("#tr_creator").css("display",
 * ""); $("#tr_dateCreated").css("display", "");
 * $("#tr_lastModifier").css("display", "");
 * $("#tr_lastModified").css("display", "");
 * 
 * $("#editArea").css("display", ""); }
 */

function doCancelEdit() {
	$("#listArea").css("display", "");
	$("#editArea").css("display", "none");
}

function doAction(thisSelect) {
	alert(thisSelect.value);
	thisSelect.options[0].selected = true;
}

function doEnable(enabled) {
	alert(enabled);
}

//function showMsg(msg) {
//	$("#msg").empty().append(msg);
//}

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

function doDeleteBlMaster() {
	alert('doDeleteBlMaster');
}

function doCancel() {
	$("#editBL").hide();
	$("#viewBL").show();
}

function activeTab(tabId) {
	$("#tab_blMaster").removeClass("active");
	$("#tab_blCargo").removeClass("active");
	$("#tab_blMarkNo").removeClass("active");
	$("#tab_blCtrOfBl").removeClass("active");
	$("#tab_blContainer").removeClass("active");
	$("#tab_blNote").removeClass("active");
	$("#tab_blStatus").removeClass("active");

	/**
	 * $("#blMaster").hide(); $("#blCargo").hide(); $("#blMarkNo").hide();
	 * $("#blCtrOfBl").hide(); $("#blContainer").hide();
	 * $("#blNote").hide(); $("#blStatus").hide();
	 */

	// $("#tab_" + tabId).addClass("active");
	// $("#" + tabId).show();
	window.location = "#" + tabId;
}

function jumpToPosition(position) {
	window.location = "#" + position;
}

function doEdit(bl) {
	/**
	 * alert('doEditBlMaster...');
	 * 
	 * $("#frmBlMaster :input[type=text]").removeAttr("readonly").css("border",
	 * "1px solid"); $("#frmBlMaster
	 * textarea").removeAttr("readonly").css("border", "1px solid");
	 * $("#frmBlMaster :input[type=radio]").removeAttr("disabled");
	 * $("#frmBlMaster select").removeAttr("disabled").css("border", "1px
	 * solid");
	 */
	$("#viewBL").hide();
	$("#editBL p").empty().append("Edit " + bl);
	$("#editBL").show();
}

/**
 * function doCancel() { $("#editBL").hide(); $("#viewBL").show(); }
 */

function doEditBlMaster(url, blMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/editBlMaster.do";

	var sData = "action=create&blMasterId=";

	if (blMasterId != '') {
		sData = "action=edit&blMasterId=" + blMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);

			// $("#editArea").empty().append(data);
			// alert(oBlMaster);

			$("#editBL #title #id").empty().append(blMasterId);
			$("#editBL #title #editTitle").empty().append("Edit Master");
			$("#editBL #content").empty().append(data);

			$("#viewBL").hide();
			$("#editBL").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});
}

function doSaveBlMaster(url) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/saveBlMaster.do";

	var sData = $("#frmBlMaster").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(blMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oBlMaster);
			$("#editBL").hide();
			$("#viewBL").show();
			// showMsg($("#frmEdit").serialize());

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});

}

function doEditBlCargo(url, blCargoId, blMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/editBlCargo.do";

	var sData = "action=create&blCargoId=";

	if (blCargoId != '') {
		sData = "action=edit&blCargoId=" + blCargoId + "&blMasterId"
				+ blMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);

			// $("#editArea").empty().append(data);
			// alert(oBlMaster);

			$("#editBL #title #id").empty().append(blMasterId);
			$("#editBL #title #editTitle").empty().append("Edit Cargo");
			$("#editBL #content").empty().append(data);

			$("#viewBL").hide();
			$("#editBL").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}

function doSaveBlCargo(url) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/saveBlCargo.do";

	var sData = $("#frmBlCargo").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(blCargoId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oBlCargo);
			$("#editBL").hide();
			$("#viewBL").show();
			// showMsg($("#frmEdit").serialize());

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});
}

function doEditBlMarkNo(url, blMarkNoId, blMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/editBlMarkNo.do";

	var sData = "action=create&blMarkNoId=";

	if (blMarkNoId != '') {
		sData = "action=edit&blMarkNoId=" + blMarkNoId + "&blMasterId"
				+ blMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);

			// $("#editArea").empty().append(data);
			// alert(oBlMaster);

			$("#editBL #title #id").empty().append(blMasterId);
			$("#editBL #title #editTitle").empty().append("Edit MarkNo");
			$("#editBL #content").empty().append(data);

			$("#viewBL").hide();
			$("#editBL").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ": " + errorThrown);
		}
	});
}

function doSaveBlMarkNo(url) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/saveBlMarkNo.do";

	var sData = $("#frmBlMarkNo").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(blMarkNoId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oBlMarkNo);
			$("#editBL").hide();
			$("#viewBL").show();
			// showMsg($("#frmEdit").serialize());

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});

}
