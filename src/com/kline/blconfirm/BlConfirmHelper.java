package com.kline.blconfirm;

import com.kline.blconfirm.entity.BlMaster;
import com.kline.core.entity.User;

public class BlConfirmHelper {

	// BLConfirmStatus
	public final static int BLConfirm_UNKNOWN = 0;
	public final static int BLConfirm_DRAFT = 1;
	public final static int BLConfirm_OK = 2;
	public final static int BLConfirm_VERIFYING = 3;
	public final static int BLConfirm_CORRECTION_NOTICE = 4;
	public final static int BLConfirm_PROCESSING = 5;
	// public final static int BLConfirm_ = 6;
	public final static int BLConfirm_PROCESSED = 6; // not used
	public final static int BLConfirm_PROCESSED_OK = 7; // not used
	public final static int BLConfirm_ACCEPTED = 8;
	public final static int BLConfirm_REJECTED = 9;

	public final static String[] blConfirmStatus = { "", "N", "O", "V", "C",
			"P", "", "", "A", "R" };

	public final static String getBlConfirmStatusName(int status) {
		if (status < 0 || status >= blConfirmStatus.length)
			return "";
		return blConfirmStatus[status];
	}

//	public static final int BL_ACT_UNKNOWN = 0;
	public static final int BL_ACT_DONOT_VERIFY = 1;
	public static final int BL_ACT_VERIFY = 2;
	public static final int BL_ACT_VERIFYING = 3;
	public static final int BL_ACT_SUBMIT = 4;
	public static final int BL_ACT_UNSUBMIT = 5;
	public static final int BL_ACT_PROCESS = 6;
	public static final int BL_ACT_PROCESSING = 7;
	public static final int BL_ACT_UPDATE_SDS = 8;
	public static final int BL_ACT_UPLOAD = 9;
	public static final int BL_ACT_VIEW = 10;
	public static final int BL_ACT_ACCEPT_ALL = 11;
	public static final int BL_ACT_REJECT_ALL = 12;
	public static final int BL_ACT_DELETE = 13;

	public final static boolean canDoAction(User myAccount, int action,
			BlMaster blMaster) {
		return true;
	}
}
