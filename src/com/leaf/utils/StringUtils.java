package com.leaf.utils;

/**
 * ��װ�ַ������ò���
 * @author leaf
 *
 */
public class StringUtils {
	
	public static String firstChar2UpperCase(String str){
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
