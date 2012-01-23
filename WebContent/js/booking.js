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
			 * if (data == null) { alert(bkgMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#listArea #content").empty().append(data);

			$("#listArea #content").show();

			// alert(oBkgMaster);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		}
	});
}

function doSelectAll(thisCheckbox) {
	$("#frmList :checkbox[name='bkgMasterId']").attr("checked",
			thisCheckbox.checked);
	// $("#frmList input:disabled").attr("checked", false);
	// $("#frmList").find("input[type='checkbox'][name='bkgMasterId']").find("input:disabled").attr("checked",
	// thisCheckbox.checked);
}

function gotoList() {
	$("#viewArea").hide();
	$("#listArea").show();
	jumpToPosition('listArea_start');
}

function doNewBkgMaster() {
	doViewBooking('');
}

function viewBooking(url, bkgMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/viewBooking.do";

	var sData;	// = "action=create&bkgMasterId=";

	if (bkgMasterId != '') {
		sData = "action=edit&bkgMasterId=" + bkgMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(bkgMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 */

			$("#viewBooking #content").empty().append(data);
			$("#viewBooking #title #id").empty().append(bkgMasterId);

			// alert(oBkgMaster);

			$("#listArea").hide();
//			showMsg("");

			$("#editBooking").hide();
			$("#viewBooking").show();
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
 * function doViewBooking(bkgMasterId) { $("#list_block").css("display",
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

function doDeleteBkgMaster() {
	alert('doDeleteBkgMaster');
}

function doCancel() {
	$("#editBooking").hide();
	$("#viewBooking").show();
}

function activeTab(tabId) {
	$("#tab_bkgMaster").removeClass("active");
	$("#tab_bkgCargo").removeClass("active");
	$("#tab_bkgMarkNo").removeClass("active");
	$("#tab_bkgCtrOfBkg").removeClass("active");
	$("#tab_bkgContainer").removeClass("active");
	$("#tab_bkgNote").removeClass("active");
	$("#tab_bkgStatus").removeClass("active");

	/**
	 * $("#bkgMaster").hide(); $("#bkgCargo").hide(); $("#bkgMarkNo").hide();
	 * $("#bkgCtrOfBkg").hide(); $("#bkgContainer").hide();
	 * $("#bkgNote").hide(); $("#bkgStatus").hide();
	 */

	// $("#tab_" + tabId).addClass("active");
	// $("#" + tabId).show();
	window.location = "#" + tabId;
}

function jumpToPosition(position) {
	window.location = "#" + position;
}

function doEdit(bkg) {
	/**
	 * alert('doEditBkgMaster...');
	 * 
	 * $("#frmBkgMaster :input[type=text]").removeAttr("readonly").css("border",
	 * "1px solid"); $("#frmBkgMaster
	 * textarea").removeAttr("readonly").css("border", "1px solid");
	 * $("#frmBkgMaster :input[type=radio]").removeAttr("disabled");
	 * $("#frmBkgMaster select").removeAttr("disabled").css("border", "1px
	 * solid");
	 */
	$("#viewBooking").hide();
	$("#editBooking p").empty().append("Edit " + bkg);
	$("#editBooking").show();
}

/**
 * function doCancel() { $("#editBooking").hide(); $("#viewBooking").show(); }
 */

function doEditBkgMaster(url, bkgMasterId) {

//	var url = "<%=contextPath%>/booking/bookingAdmin/editBkgMaster.do";

	var sData = "action=create&bkgMasterId=";

	if (bkgMasterId != '') {
		sData = "action=edit&bkgMasterId=" + bkgMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);

			// $("#editArea").empty().append(data);
			// alert(oBkgMaster);

			$("#editBooking #title #id").empty().append(bkgMasterId);
			$("#editBooking #title #editTitle").empty().append("Edit Master");
			$("#editBooking #content").empty().append(data);

			$("#viewBooking").hide();
			$("#editBooking").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});
}

function doSaveBkgMaster() {

	var url = "<%=contextPath%>/booking/bookingAdmin/saveBkgMaster.do";

	var sData = $("#frmBkgMaster").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(bkgMasterId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oBkgMaster);
			$("#editBooking").hide();
			$("#viewBooking").show();
			// showMsg($("#frmEdit").serialize());

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});

}

function doEditBkgCargo(bkgCargoId, bkgMasterId) {

	var url = "<%=contextPath%>/booking/bookingAdmin/editBkgCargo.do";

	var sData = "action=create&bkgCargoId=";

	if (bkgCargoId != '') {
		sData = "action=edit&bkgCargoId=" + bkgCargoId + "&bkgMasterId"
				+ bkgMasterId;
	}

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);

			// $("#editArea").empty().append(data);
			// alert(oBkgMaster);

			$("#editBooking #title #id").empty().append(bkgMasterId);
			$("#editBooking #title #editTitle").empty().append("Edit Cargo");
			$("#editBooking #content").empty().append(data);

			$("#viewBooking").hide();
			$("#editBooking").show();

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus + "|" + errorThrown);
		}
	});
}

function doSaveBkgCargo() {

	var url = "<%=contextPath%>/booking/bookingAdmin/saveBkgCargo.do";

	var sData = $("#frmBkgCargo").serialize();
	// $("#list tbody").load(url);

	$.ajax({
		type : "POST",
		url : url,
		data : sData,
		dataType : "text",
		success : function(data) {
			// alert(data);
			/**
			 * if (data == null) { alert(bkgCargoId + " not found!"); // error
			 * processing
			 * 
			 * return; }
			 * 
			 * $("#list tbody").empty().append(data);
			 */
			// alert(oBkgCargo);
			$("#editBooking").hide();
			$("#viewBooking").show();
			// showMsg($("#frmEdit").serialize());

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		}
	});

}
