package com.kline.booking.helper;

import com.kline.Constants;
import com.kline.booking.entity.BkgMaster;
import com.kline.core.entity.User;
import com.kline.core.helper.UserHelper;

public class BookingHelper {
	public final static String BKG_ST_DRAFT = "D";
	public final static String BKG_ST_PENDING = "P";
	public final static String BKG_ST_NEW = "N";
	public final static String BKG_ST_ACCEPTED = "A";
	public final static String BKG_ST_REJECTED = "R";

	public final static int BKG_ACT_READ = 1;
	public final static int BKG_ACT_UPDATE = 2;
	public final static int BKG_ACT_SUBMIT = 3;
	public final static int BKG_ACT_UNSUBMIT = 4;
	public final static int BKG_ACT_DELETE = 5;
	// public final static int BKG_ACT_ACCEPT = 6;
	// public final static int BKG_ACT_REJECT = 7;
	public final static int BKG_ACT_PROCESS = 8;
	// public final static int BKG_ACT_COPY = 9;
	public final static int BKG_ACT_CREATE = 10;

	// Wu Shuo, 2004-06-06
	public final static int BKG_ACT_CREATE_NOTICE = 11;
	public final static int BKG_ACT_READ_NOTICE = 12;
	public final static int BKG_ACT_UPDATE_NOTICE = 13;
	public final static int BKG_ACT_DELETE_NOTICE = 14;
	public final static int BKG_ACT_PROCESS_NOTICE = 15;

	// // Wu Shuo, 2004-06-17
	// public final static int BKG_ACT_ADDTOFAVORITE = 13;
	//
	// // Wu Shuo, 2004-07-22

	private final static boolean isBookingOfMyCompany(BkgMaster bkgMaster,
			User user) {
		if (UserHelper.isAgentUser(user)) {
			return bkgMaster.getAgentCode().equals(user.getAgentCode());
		} else if (UserHelper.isDirectBookingUser(user)) {
			return bkgMaster.getDirectAgentCode().equals(user.getAgentCode());
		}

		return false;
	}

	private final static boolean isMyBooking(BkgMaster bkgMaster, User myAccount) {
		if (null == bkgMaster) {
			return false;
		}

		return bkgMaster.getCreator().equals(myAccount.getUserId());
	}

	public final static boolean canDoAction(User myAccount, int action,
			BkgMaster bkgMaster) {

		if (null == myAccount) {
			return false;
		}
		
		if (null == bkgMaster) {
			switch (action) {
			case BKG_ACT_READ:
				return true;
			case BKG_ACT_CREATE:
				if (UserHelper.isAdmin(myAccount)
						|| UserHelper.isAgentUser(myAccount)
						|| UserHelper.isDirectBookingUser(myAccount)) {
					return true;
				}
				return false;
			default:
				return false;
			}
		}

		String status = bkgMaster.getStatus();

		if (BKG_ST_DRAFT.equals(status)) {
			switch (action) {
			case BKG_ACT_READ:
			case BKG_ACT_UPDATE:
			case BKG_ACT_DELETE:
			case BKG_ACT_SUBMIT:
				// if (UserHelper.isInternalUser(myAccount)) {
				// return true;
				// }
				if (UserHelper.isAdmin(myAccount)) {
					return true;
				}
				if (isMyBooking(bkgMaster, myAccount)) {
					return true;
				}
				// if (isBookingOfMyCompany(bkgMaster, myAccount)) {
				// return true;
				// }
				return false;
			case BKG_ACT_UNSUBMIT:
			case BKG_ACT_PROCESS:
			default:
				return false;
			}
		} else if (BKG_ST_NEW.equals(status)) {
			switch (action) {
			case BKG_ACT_READ:
				if (UserHelper.isInternalUser(myAccount)) {
					return true;
				}
				if (isBookingOfMyCompany(bkgMaster, myAccount)) {
					return true;
				}
				if (isMyBooking(bkgMaster, myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_UPDATE:
				if (UserHelper.isInternalUser(myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_DELETE:
				if (UserHelper.isAdmin(myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_SUBMIT:
				return false;
			case BKG_ACT_UNSUBMIT:
				if (isBookingOfMyCompany(bkgMaster, myAccount)) {
					return true;
				}
				if (isMyBooking(bkgMaster, myAccount)) {
					return true;
				}
				if (UserHelper.isAdmin(myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_PROCESS:
				if (UserHelper.isInternalUser(myAccount)) {
					return true;
				}
				return false;
			default:
				return false;
			}
		} else if (BKG_ST_ACCEPTED.equals(status)) {
			switch (action) {
			case BKG_ACT_READ:
				if (UserHelper.isInternalUser(myAccount)) {
					return true;
				}
				if (isBookingOfMyCompany(bkgMaster, myAccount)) {
					return true;
				}
				if (isMyBooking(bkgMaster, myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_CREATE_NOTICE:
			case BKG_ACT_READ_NOTICE:
			case BKG_ACT_UPDATE_NOTICE:
			case BKG_ACT_PROCESS_NOTICE:
				return false;
			case BKG_ACT_DELETE:
			case BKG_ACT_UPDATE:
			case BKG_ACT_SUBMIT:
			case BKG_ACT_UNSUBMIT:
			case BKG_ACT_PROCESS:
			default:
				return false;
			}
		} else if (BKG_ST_REJECTED.equals(status)) {
			switch (action) {
			case BKG_ACT_READ:
				if (UserHelper.isInternalUser(myAccount)) {
					return true;
				}
				if (isBookingOfMyCompany(bkgMaster, myAccount)) {
					return true;
				}
				if (isMyBooking(bkgMaster, myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_DELETE:
				if (UserHelper.isAdmin(myAccount)) {
					return true;
				}
				return false;
			case BKG_ACT_UPDATE:
			case BKG_ACT_SUBMIT:
			case BKG_ACT_UNSUBMIT:
			case BKG_ACT_PROCESS:
			default:
				return false;
			}
		} else {
			return false;
		}
	}

	public final static int toAction(String s) {
		if ("read".equals(s)) {
			return BKG_ACT_READ;
		} else if ("create".equals(s)) {
			return BKG_ACT_READ;
		} else if ("update".equals(s)) {
			return BKG_ACT_UPDATE;
		} else if ("delete".equals(s)) {
			return BKG_ACT_DELETE;
		} else if ("submit".equals(s)) {
			return BKG_ACT_SUBMIT;
		} else if ("unsubmit".equals(s)) {
			return BKG_ACT_UNSUBMIT;
		} else if ("process".equals(s)) {
			return BKG_ACT_PROCESS;
		} else if ("createNotice".equals(s)) {
			return BKG_ACT_CREATE_NOTICE;
		} else if ("readNotice".equals(s)) {
			return BKG_ACT_READ_NOTICE;
		} else if ("updateNotice".equals(s)) {
			return BKG_ACT_UPDATE_NOTICE;
		} else if ("deleteNotice".equals(s)) {
			return BKG_ACT_DELETE_NOTICE;
		} else if ("processNotice".equals(s)) {
			return BKG_ACT_PROCESS_NOTICE;
		} else {
			return 0;
		}
	}
}
