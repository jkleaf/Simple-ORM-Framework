package com.leaf.core;
/**
 * mysql与java类型转换
 * @author Lenovo
 *
 */
public class MysqlTypeConvertor implements TypeConvertor{

	/* 
	 * 
	 */
	@Override
	public String databaseType2JavaType(String columnType) {
		
		if("varchar".equalsIgnoreCase(columnType)||"char".equalsIgnoreCase(columnType)){
			return "String";
		}else if("int".equalsIgnoreCase(columnType)
				||"bigint".equalsIgnoreCase(columnType)
				||"smallint".equalsIgnoreCase(columnType)
				||"tinyint".equalsIgnoreCase(columnType)){
			return "Integer";
		}else if("datetime".equalsIgnoreCase(columnType)||"date".equalsIgnoreCase(columnType)){
			return "Date";
		}
		/*
		 * else if
		 * 
		 * 
		 * else if
		 * 
		 * 
		 */
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		return null;
	}
	
}
