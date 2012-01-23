package com.kline.util;

public class PagerHelper {

	public final static boolean isFirstPage(int pageNo) {
		return pageNo == 1;
	}

	public final static boolean isLastPage(int pageNo, int totalPages) {
		return pageNo >= totalPages;
	}

	public final static boolean hasPrevPage(int pageNo) {
		if (pageNo <= 1)
			return false;
		else
			return true;
	}

	public final static boolean hasNextPage(int pageNo, int totalPages) {
		if (totalPages == 0)
			return false;
		else if (pageNo >= totalPages)
			return false;
		else
			return true;
	}

	public final static int getPageNo(int pageNo, int totalPages) {
		return (pageNo > totalPages) ? totalPages : pageNo;
	}
}
