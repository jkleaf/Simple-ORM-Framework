package com.leaf.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leaf.bean.ColumnInfo;
import com.leaf.bean.JavaFieldGetSet;
import com.leaf.bean.TableInfo;
import com.leaf.core.DBmanager;
import com.leaf.core.MysqlTypeConvertor;
import com.leaf.core.TableContext;
import com.leaf.core.TypeConvertor;

/**
 * 封装生成java文件（源代码）常用操作
 * @author leaf
 *
 */
public class JavaFileUtils {
	
	/**
	 * 根据字段信息生成java属性信息 ：varchar username-->private String username;
	 * 以及相应get和set方法
	 * @param column 字段信息
	 * @param convertor 类型转换器
	 * @return java属性和set/get方法源码
	 */
	public static JavaFieldGetSet createFieldGetSetSrc(ColumnInfo column,TypeConvertor convertor){
		JavaFieldGetSet jfgs=new JavaFieldGetSet();
		String javaFieldType=convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("    private "+javaFieldType+" "+column.getName()+";\n");
		
		StringBuilder getSrc=new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n\n");
		jfgs.setGetInfo(getSrc.toString());
		
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n\n");
		jfgs.setSetInfo(setSrc.toString());
			
		return jfgs;
	}
	
	/**
	 * 根据表信息生成java类源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转换器
	 * @return java类源代码
	 */
    public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
		Map<String, ColumnInfo> columns=tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields=new ArrayList<>();
		for (ColumnInfo cInfo : columns.values()) {
			javaFields.add(createFieldGetSetSrc(cInfo, convertor));
		}
		StringBuilder src=new StringBuilder();
		
		src.append("package "+DBmanager.getConf().getPoPackage()+";\n\n");
		src.append("import java.sql.*;\n");
		src.append("import java.sql.Date;\n");
		src.append("import java.util.*;\n\n");
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		//生成属性列表
		for(JavaFieldGetSet fGetSet:javaFields){
			src.append(fGetSet.getFieldInfo());
		}
		src.append("\n");
		//生成get方法
		for (JavaFieldGetSet fGetSet : javaFields) {
			src.append(fGetSet.getGetInfo());
		}
		//生成set方法
		for (JavaFieldGetSet fGetSet : javaFields) {
			src.append(fGetSet.getSetInfo());
		}
		src.append("}");
//		System.out.println(src);
		return src.toString();
	}
	
    public static void createJavaPoFile(TableInfo tableInfo,TypeConvertor convertor){
    	String src=createJavaSrc(tableInfo, convertor);
    	String srcPath=DBmanager.getConf().getSrcPath();
    	String poPackage=DBmanager.getConf().getPoPackage().replaceAll("\\.", "\\\\");//same as:/
    	File file=new File(srcPath+poPackage);
    	if(!file.exists()){
    		file.mkdirs();
    	}
    	BufferedWriter bw=null;
    	try {
			bw=new BufferedWriter(new FileWriter(file.getAbsolutePath()
					+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java"));
			bw.write(src);
			System.out.println("successfully update "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java!");
    	} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
//	public static void main(String[] args) {
//		Map<String,TableInfo> map=TableContext.getTableInfos();
//		TableInfo t=map.get("emp");
////		createJavaSrc(t, new MysqlTypeConvertor());
//		createJavaPoFile(t, new MysqlTypeConvertor());
//	}
}
