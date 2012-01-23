package com.kline.util;

/**
 * Title:        ��������
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      www.justhis.com
 * @author:       acai
 * @version 1.0
 */

//import net.kline.util.*;
import java.text.*;
import java.util.Date;
import java.math.*;

/**
 * Title: �������� Description: Copyright: Copyright (c) 2002 Company:
 * 211.68.39.120��webcpu.51.net
 * 
 * @author acai
 * @version 1.0
 */

public class StringUtils {

	public static String getDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date Now = new java.util.Date();
		String NDate = formatter.format(Now);
		return NDate;
	}

	public static String getDateTime0() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date Now = new java.util.Date();
		String NDate = formatter.format(Now);
		return NDate;
	}

	public static String getStrDate(String DateString) {
		// 2005-12-13 gel �޸�
		if (null == DateString) {
			return "";
		}

		if (DateString.length() <= 10) {
			return DateString;
		}
		return DateString.substring(0, 10);
	}

	public static String toDateTime4Sql(String yyyyMMddHHmmss) {
		String s = null;
		try {
			if (null != yyyyMMddHHmmss) {
				s = yyyyMMddHHmmss.substring(0, 4) + "-"
						+ yyyyMMddHHmmss.substring(4, 6) + "-"
						+ yyyyMMddHHmmss.substring(6, 8) + " "
						+ yyyyMMddHHmmss.substring(8, 10) + ":"
						+ yyyyMMddHHmmss.substring(10, 12) + ":"
						+ yyyyMMddHHmmss.substring(12, 14);
			}
		} catch (Exception e) {
		}
		return s;
	}

	public static String toDateString(java.util.Date date, String simpleDateFormat) {
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter = new SimpleDateFormat(simpleDateFormat);
		//java.util.Date Now = new java.util.Date();
		if (null == date) {
			return "";
		}
		String NDate = formatter.format(date);
		return NDate;
	}
	
	public static String toDateString(java.util.Date date) {
		return toDateString(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String toDateString() {
		return toDateString(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/*
	 * public static String getStrDateTime(){ return
	 * StringUtils.replace(StringUtils.replace(StringUtils.replace(getDateTime(),":",""),"-",""),"
	 * ",""); }
	 */

	public static boolean compareTo(String last, String now) {
		try {
			// DateFormat formatter=DateFormat.getDateInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date temp1 = formatter.parse(last);
			Date temp2 = formatter.parse(now);
			if (temp1.after(temp2))
				return false;
			else if (temp1.before(temp2))
				return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isLaterThanNow(String last, int days) {
		try {
			// DateFormat formatter=DateFormat.getDateInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date temp1 = formatter.parse(last);

			Date temp2 = new java.util.Date();

			long t48H = days * 24 * 60 * 60 * 1000L;
			
			long t1 = temp1.getTime();
			long t2 = temp2.getTime();
			
//			System.out.println("t48H = " + t48H);
//			System.out.println("t1-t2 = " + (t1-t2));
			
			return (t1 - t2) > t48H;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * �ַ��滻���� source �е� oldString ȫ������ newString
	 * 
	 * @param source
	 *            Դ�ַ�
	 * @param oldString
	 *            �ϵ��ַ�
	 * @param newString
	 *            �µ��ַ�
	 * @return �滻����ַ�?
	 */
	public static String Replace(String source, String oldString,
			String newString) {
		StringBuffer output = new StringBuffer();

		int lengthOfSource = source.length(); // Դ�ַ���
		int lengthOfOld = oldString.length(); // ���ַ���

		int posStart = 0; // ��ʼ����λ��
		int pos; // �������ַ��λ��?

		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));

			output.append(newString);
			posStart = pos + lengthOfOld;
		}

		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}

		return output.toString();
	}

	public static String escapeSingleQuote(String s) {
		return Replace(Replace(Replace(s, "'", "\\'"), "\n", "\\n"), "\r", "\\r");
	}
	
	/*
	 * public static String ReplaceIgnoreCase(String source, String oldString,
	 * String newString) { }
	 */

	/**
	 * ���ַ��ʽ����? HTML �������? ֻת�������ַ��ʺ��� HTML �е�??����
	 * 
	 * @param str
	 *            Ҫ��ʽ�����ַ�
	 * @return ��ʽ������ַ�?
	 */
	public static String toHtmlInput(String str) {
		if (str == null)
			return null;

		String html = new String(str);

		html = Replace(html, "&", "&amp;");
		html = Replace(html, "<", "&lt;");
		html = Replace(html, ">", "&gt;");

		return html;
	}

	/**
	 * ���ַ��ʽ����? HTML �������?
	 * ����ͨ�����ַ��⣬���Կո��Ʊ��ͻ��н���ת���� �Խ����ݸ�ʽ�����?
	 * �ʺ��� HTML �е���ʾ���?
	 * 
	 * @param str
	 *            Ҫ��ʽ�����ַ�
	 * @return ��ʽ������ַ�?
	 */
	public static String toHtml(String str) {
		if (str == null)
			return "";

		String html = new String(str);

		html = toHtmlInput(html);
		html = Replace(html, "\r\n", "\n");
		html = Replace(html, "\n", "<br>\n");
		html = Replace(html, "\t", "    ");
		html = Replace(html, " ", " &nbsp;");

		return html;
	}
	
	public static int countLines(String s) {
		if (null == s) 
			return 0;
		
		int cl = 0;
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (c == '\n') {
				cl ++;
			}
		}
		return cl;
	}

	public static String blank2space(String str) {
		if ("".equals(str)) {
			return "&nbsp";
		}
		if ("0".equals(str)) {
			return "&nbsp";
		}
		return str;
	}

	/**
	 * ����ͨ�ַ��ʽ������ݿ��Ͽɵ��ַ���?
	 * 
	 * @param str
	 *            Ҫ��ʽ�����ַ�
	 * @return �Ϸ�����ݿ��ַ�?
	 */
	public static String toSql(String str) {
		if (null == str) {
			return "";
		}
		String sql = new String(str);
		return Replace(sql, "'", "''");
	}

	// Wu Shuo, 01/02/2005
	public static String toSqlString(String s) {
		if (s == null) {
			return "NULL";
		}
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("'").append(toSql(s)).append("'");
		return sbuf.toString();
	}

	public static String toSqlString(BigDecimal f) {
		if (f == null) {
			return "NULL";
		}

		String s = f.toString();
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("'").append(toSql(s)).append("'");
		return sbuf.toString();
	}

	public static String toSqlString(float f) {
		String s = String.valueOf(f);
		if (s == null) {
			return "NULL";
		}
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("'").append(toSql(s)).append("'");
		return sbuf.toString();
	}

	public static String toSqlString(int f) {
//		String s = String.valueOf(f);
//		if (s == null) {
//			return "NULL";
//		}
		StringBuffer sbuf = new StringBuffer();
//		sbuf.append("'").append(f).append("'");
		sbuf.append(f);
		return sbuf.toString();
	}

	public static String toSqlString4Number(String f) {
		// String s = f;
		if (f == null || "".equals(f)) {
			return "NULL";
		}
		// StringBuffer sbuf = new StringBuffer();
		// sbuf.append("'").append(toSql(s)).append("'");
		// return sbuf.toString();
		return f;
	}

	/*
	 * public static void main(String[] args) { String s = "<html> ddd"; Format
	 * f = new Format(); }
	 */

	// 2003-6-17, Wu Shuo
	public static String trim(String str) {

		if (str == null) {
			return new String("");
		} else {
			return str.trim();
		}
	}

	// 2003-8-31, Wu Shuo
	// ��ʽ�������?
	public static String formatInteger(int n, int len) {
		String str = Integer.toString(n);
		StringBuffer buf = new StringBuffer();
		if (len > str.length()) {
			for (int i = 0; i < (len - str.length()); i++) {
				buf.append('0');
			}
			buf.append(str);
			return buf.toString();
		} else {
			return str;
		}
	}

	public static String obj2String(Object obj) {
		if (null == obj) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}

	public static String convert(String s, String charsetFrom, String charsetTo) {
		if (null == s) {
			return null;
		}
		try {
			return new String(s.getBytes(charsetFrom), charsetTo);
		} catch (Exception e) {
			return s;
		}
	}

	public static String getNextMonth(String year, String month)
			throws Exception {

		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);

		if (intMonth < 0 || intMonth > 13) {
			throw new Exception("error month: " + month);
		}

		if (intMonth == 12) {
			intYear++;
			return String.valueOf(intYear) + "-" + "01";
		} else {
			intMonth++;
			return year + "-" + String.valueOf(intMonth);
		}

	}

	public static String getLast3Month(String year, String month){

	int intYear = Integer.parseInt(year);
	int intMonth = Integer.parseInt(month);

	if (intMonth < 0 || intMonth > 13) {
//		throw new Exception("error month: " + month);
	}

	if (intMonth < 0) {
		intMonth = 1;
	}
	
	if (intMonth > 12) {
		intMonth = 12;
	}

	int intLast3Month = intMonth -3;

	if (intLast3Month <= 0) {
		intYear--;
		intLast3Month += 12;
//		return String.valueOf(intYear) + "-" + "01";
	} else {
//		intMonth++;
//		return year + "-" + String.valueOf(intMonth);
	}
	
	return String.valueOf(intYear) + "-" + String.valueOf(intLast3Month);

}
	
	public static String getLastDay(String strDate) {

		int index4Dash = strDate.indexOf('-');
		int lastIndex4Dash = strDate.lastIndexOf('-');

		// System.out.println(strDate + ":" + index4Dash + ":" +
		// lastIndex4Dash);

		int intYear = Integer.parseInt(strDate.substring(0, index4Dash));
		int intMonth = Integer.parseInt(strDate.substring(index4Dash + 1,
				lastIndex4Dash));
		int intDay = Integer.parseInt(strDate.substring(lastIndex4Dash + 1));

		// System.out.println(strDate + ":" + intYear + ":" + intMonth + ":" +
		// intDay);

		if (intDay == 1) {
			switch (intMonth) {
			case 1:
				intDay = 31;
				intMonth = 12;
				intYear--;
				break;
			case 2:
			case 4:
			case 6:
			case 8:
			case 9:
			case 11:
				intDay = 31;
				intMonth--;
				break;
			case 3:
				intDay = ((0 == intYear % 4) && (0 != (intYear % 100)))
						|| (0 == intYear % 400) ? 29 : 28;
				intMonth--;
				break;
			case 5:
			case 7:
			case 10:
			case 12:
				intDay = 30;
				intMonth--;
				break;
			default:
				break;
			}
		} else {
			intDay--;
		}

		return intYear + "-" + formatInteger(intMonth, 2) + "-"
				+ formatInteger(intDay, 2);

	}

	public static String getNextDay(String strDate) {

		int index4Dash = strDate.indexOf('-');
		int lastIndex4Dash = strDate.lastIndexOf('-');

		// System.out.println(strDate + ":" + index4Dash + ":" +
		// lastIndex4Dash);

		int intYear = Integer.parseInt(strDate.substring(0, index4Dash));
		int intMonth = Integer.parseInt(strDate.substring(index4Dash + 1,
				lastIndex4Dash));
		int intDay = Integer.parseInt(strDate.substring(lastIndex4Dash + 1));

		// System.out.println(strDate + ":" + intYear + ":" + intMonth + ":" +
		// intDay);

		switch (intMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (intDay == 31) {
				intDay = 1;
				intMonth++;
				// intYear--;
			} else {
				intDay++;
			}
			break;
		case 2:
			if (intDay == 28) {
				if (((0 == intYear % 4) && (0 != (intYear % 100)))
						|| (0 == intYear % 400)) {
					intDay = 29;
				} else {
					intDay = 1;
					intMonth++;
				}
			} else if (intDay == 29) {
				intDay = 1;
				intMonth++;
			} else {
				intDay++;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (intDay == 30) {
				intDay = 1;
				intMonth++;
				// intYear--;
			} else {
				intDay++;
			}
			break;
		case 12:
			if (intDay == 31) {
				intDay = 1;
				intMonth = 1;
				intYear++;
			} else {
				intDay++;
			}
			break;
		default:
			break;
		}

		return intYear + "-" + formatInteger(intMonth, 2) + "-"
				+ formatInteger(intDay, 2);

	}

	public static int lastIndexOf(String s, String token, int before) {
		if (null == s) {
			return -1;
		}

		if (null == token) {
			return -1;
		}

		if (s.length() <= before) {
		
			int lastIndex = s.lastIndexOf(token);
			if (lastIndex <= 0 ) {
				return s.length();
			} else {
				return lastIndex;
			}

			//return s.lastIndexOf(token);

		} else {
			String subString = s.substring(0, before);
			
			int lastIndex = subString.lastIndexOf(token);
			if (lastIndex <= 0 ) {
				return before;
			} else {
				return lastIndex;
			}
		}

	}

	public static String getCurrencySymbol(String curCode) {
		if ("USD".equalsIgnoreCase(curCode)) {
			return "$";
		} else if ("CNY".equalsIgnoreCase(curCode)) {
			return "&yen;";
		} else {
			return "";
		}

	}

	public static boolean compareString(String str, String[] compareStr) {
		// try {
		if (null == str || "".equals(str)) {
			// throw new Exception("str can not be empty");
			return false;
		}

		if (null == compareStr) {
			return false;
		}

		String s = str.toUpperCase();

		int slen = s.length();

		// System.out.println("s=[" + s + "], len=" + slen);

		int count = compareStr.length;
		for (int i = 0; i < count; i++) {
			if (null == compareStr[i] || "".equals(compareStr[i])) {
				// throw new Exception("compareStr[" + i + "] can not be
				// empty");
				continue;
			}

			String cs = compareStr[i].toUpperCase();

			int cslen = cs.length();

			// if (str.indexOf(compareStr[i]) >= 0) {
			// return true;
			// }

			int index = s.indexOf(cs);

			// System.out.println("cs=[" + cs + "], cslen=" + cslen + ", index="
			// + index);

			if (index >= 0) {

				if (index > 0) {
					// System.out.println("charAt[" + (index -1) + "]=" +
					// s.charAt(index - 1));

					switch (s.charAt(index - 1)) {
					case ' ':
					case '\'':
					case '"':
					case ',':
					case ';':
					case ':':
					case '(':
					case '?':
					case '<':
					case '>':
					case '.':
					case '!':
					case '@':
					case '#':
					case '$':
					case '%':
					case '&':
					case '*':
					case '\n':
					case '\r':
					case '\t':
					case '\\':
						break;
					default:
						continue;
					}
				}

				if (slen - index - cslen > 0) {
					// System.out.println("charAt[" + (index + cslen) + "]=" +
					// s.charAt(index + cslen));
					switch (s.charAt(index + cslen)) {
					case ' ':
					case '\'':
					case '"':
					case ',':
					case ';':
					case ':':
					case ')':
					case '?':
					case '<':
					case '>':
					case '.':
					case '!':
					case '@':
					case '#':
					case '$':
					case '%':
					case '&':
					case '*':
					case '\n':
					case '\r':
					case '\t':
					case '\\':
						break;
					default:
						continue;
					}
				}

				return true;
			}
			// System.out.println("index:" + str.indexOf(compareStr[i]));
		}
		return false;
		// } catch (Exception e) {
		// throw new Exception(e);
		// }
	}

	public static boolean isSubString(String str, String subString) {

		// try {
		if (null == str || "".equals(str)) {
			// throw new Exception("str can not be empty");
			return false;
		}

		if (null == subString || "".equals(subString)) {
			return false;
		}

		String s = str.toUpperCase();

		int slen = s.length();

		// System.out.println("s=[" + s + "], len=" + slen);


		String cs = subString.toUpperCase();

		int cslen = cs.length();

		// if (str.indexOf(subString[i]) >= 0) {
		// return true;
		// }

		int index = s.indexOf(cs);

		// System.out.println("cs=[" + cs + "], cslen=" + cslen + ", index=" +
		// index);

		if (index >= 0) {

			if (index > 0) {
				// System.out.println("charAt[" + (index -1) + "]=" +
				// s.charAt(index - 1));

				switch (s.charAt(index - 1)) {
				case ' ':
				case '\'':
				case '"':
				case ',':
				case ';':
				case ':':
				case '(':
				case '?':
				case '<':
				case '>':
				case '.':
				case '!':
				case '@':
				case '#':
				case '$':
				case '%':
				case '&':
				case '*':
				case '\n':
				case '\r':
				case '\t':
				case '\\':
					break;
				default:
					return false;
				}
			}

			if (slen - index - cslen > 0) {
				// System.out.println("charAt[" + (index + cslen) + "]=" +
				// s.charAt(index + cslen));
				switch (s.charAt(index + cslen)) {
				case ' ':
				case '\'':
				case '"':
				case ',':
				case ';':
				case ':':
				case ')':
				case '?':
				case '<':
				case '>':
				case '.':
				case '!':
				case '@':
				case '#':
				case '$':
				case '%':
				case '&':
				case '*':
				case '\n':
				case '\r':
				case '\t':
				case '\\':
					break;
				default:
					return false;
				}
			}

			return true;
		}
		// System.out.println("index:" + str.indexOf(subString[i]));
		return false;
		// } catch (Exception e) {
		// throw new Exception(e);
		// }
	}
	
	
	public final static String highlightWord(String str, String word, String color) {
		
		String newWord = "<span style=\"background-color: " + color + "\">" + word + "</span>";
		
		return Replace(str, word, newWord);
		
	}
	
	public static String toString(String s) {
		
		return (null == s) ? "" : s.toString();
		
	}
	
	public static String[] reMakeStringArray(String[] a, String b) {
		String[] temp = null;
		if (null == a) {
			temp = new String[1];
			
		} else {
			temp = new String[a.length + 1];			
			for (int i = 0; i < a.length; i++) {
				temp[i] = a[i];
			}
		}
		temp[temp.length - 1] = b;
		return temp;
	}

	public static String[] reMakeStringArray(String[] a, String[] b) {
		String[] temp = null;
		if (null == a) {
			return b;			
		} if (null == b) {
			return a;
		}	else {
			temp = new String[a.length + b.length];		
			int i;
			for (i = 0; i < a.length; i++) {
				temp[i] = a[i];
			}
			for (; i < temp.length; i++) {
				temp[i] = b[i - a.length];
			}			
			return temp;
		}
	}

	public final static BigDecimal toBigDecimal(String s) {
		try {
			if (null == s || "".equals(s.trim())) {
				return null;
			}
			return new BigDecimal(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static boolean isAttackString(String s) {

		if (null == s)
			return false;

		String s1 = s.toLowerCase();

		if (s1.indexOf("%") >= 0)
			return true;

		if (s1.indexOf("=") >= 0)
			return true;

		if (s1.indexOf("like ") >= 0)
			return true;

		if (s1.indexOf(" like") >= 0)
			return true;

		if (s1.indexOf(" or") >= 0)
			return true;

		if (s1.indexOf("or ") >= 0)
			return true;

		return false;
	}
	
	public static boolean isBlankString(String s) {
		return null == s || "".equals(s.trim());
	}

	public static String toBriefString(String s, int len) {
		if (null == s) {
			return "";
		}
		
		if (len <= 0)
			return s;
		
		if (s.length() <= len) {
			return s;
		}
		
		return s.substring(0, len) + "...";
	}
}
