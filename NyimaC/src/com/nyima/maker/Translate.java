package com.nyima.maker;

/**
 * @author Chen Panwen
 * @data 2019/9/17 11:13
 */
public class Translate {
	/**
	 * 将String转化为int
	 * @param str
	 * @return
	 */
	public static int translateToInt(String str) {
		char a = str.charAt(0);
		int n = (int)a;
		return n;
	}

	/**
	 * 将int转化为String
	 * @param n
	 * @return
	 */
	public static String translateToString(int n) {
		char a = (char)n;
		String s = String.valueOf(a);
		return s;
	}
}
