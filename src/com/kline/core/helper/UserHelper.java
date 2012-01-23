package com.kline.core.helper;

import com.kline.core.entity.User;

public class UserHelper {

	public final static String USERTYPE_INTERNAL = "I";
	public final static String USERTYPE_EXTERNAL = "E";
	public final static String USERTYPE_AGENT = "A";
	public final static String USERTYPE_KLINE_FORWARDING = "F";
	public final static String USERTYPE_DIRECT_BOOKING = "D";
	
	public final static String USER_ROLE_ADMIN = "Admin";
	public final static String USER_ROLE_INTERNAL = "Internal";
	public final static String USER_ROLE_AGENT = "Agent";
	public final static String USER_ROLE_KLINE_FORWARDER = "Kline_Forwarding";
	public final static String USER_ROLE_DIRECT_AGENT = "Direct_Booking";
	
	public final static String USER_ADMIN = "admin";
	
	public final static boolean isInternalUser(User user) {
		return USERTYPE_INTERNAL.equals(user.getUserType());
	}
	
	public final static boolean isAgentUser(User user) {
		return USERTYPE_AGENT.equals(user.getUserType());
	}

	public final static boolean isDirectBookingUser(User user) {
		return USERTYPE_DIRECT_BOOKING.equals(user.getUserType());
	}
	
	public final static boolean isAdmin(User user) {
		return USER_ROLE_ADMIN.equals(user.getRole()) || USER_ADMIN.equals(user.getUserId());
	}
	

}
