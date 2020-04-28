package com.leaf.utils;

/**
 * 封装字符串常用操作
 * @author leaf
 *
 */
public class StringUtils {
	
	public static String firstChar2UpperCase(String str){
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
