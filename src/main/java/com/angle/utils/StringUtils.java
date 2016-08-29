package com.angle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 字符串工具类
 * 
 * @author zxl
 *
 */
public class StringUtils {

	public static boolean nullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static int getInt(String str, int defaultValue) {
		try {
			return getInt(str);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	public static long getLong(String str) {
		return Long.parseLong(str);
	}

	public static long getLong(String str, long defaultValue) {
		try {
			return getLong(str);
		} catch (RuntimeException e) {
			return defaultValue;
		}
	}

	public static int getInt(String str) {
		return Integer.parseInt(str);
	}

	public static String toString(Date date) {
		return toString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String toString(Date date, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}

	public static boolean getBoolean(String s, boolean defaultValue) {
		try {
			return getBoolean(s);
		} catch (RuntimeException e) {
			// failed to parse string to boolean value, returns the default
			// value.
			return defaultValue;
		}
	}

	public static boolean getBoolean(String s) {
		if (s == null)
			throw new NullPointerException("Input string can not be null");

		if ("1".equals(s) || "true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s))
			return true;
		else if ("0".equals(s) || "false".equalsIgnoreCase(s) || "no".equalsIgnoreCase(s))
			return false;
		else
			throw new IllegalArgumentException("Input string '" + s
					+ "' can not convert to boolean value.");
	}

	public static Date getDate(String s) {
		return getDate(s, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getDate(String s, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return null;
		} catch (RuntimeException e) {
			return null;
		}
	}

	public static String toHexString(byte[] value) {
		StringBuilder result = new StringBuilder(value.length * 2);
		for (byte ch : value) {
			result.append(toHexString(ch));
		}
		return result.toString();
	}

	public static String toHexString(byte value) {
		final char[] HEX_TABLE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
				'C', 'D', 'E', 'F' };

		byte low = (byte) (value & 0x0f);
		byte high = (byte) ((value & 0xf0) >> 4);
		StringBuilder result = new StringBuilder(2);
		result.append(HEX_TABLE[high]);
		result.append(HEX_TABLE[low]);

		return result.toString();
	}
}
