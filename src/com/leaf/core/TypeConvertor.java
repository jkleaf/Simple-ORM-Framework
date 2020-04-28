package com.leaf.core;

/**
 * java数据类型和数据库类型互相转换
 * @author leaf
 *
 */
public interface TypeConvertor {
	
	/**
	 * databaseType to javaType
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * javaType to databaseType
	 * @param javaDataType
	 * @return
	 */
	public String javaType2DatabaseType(String javaDataType);
}
