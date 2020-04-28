package com.leaf.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leaf.bean.ColumnInfo;
import com.leaf.bean.TableInfo;
import com.leaf.utils.JavaFileUtils;
import com.leaf.utils.StringUtils;

/**
 * ��ȡ��ṹ����ṹ�Ĺ�ϵ�����ݱ�ṹ������ṹ
 * @author leaf
 *
 */
public class TableContext {
	
	private static Map<String, TableInfo> tables=new HashMap<>();//k:���� v:����Ϣ
	
	//��po��class����ͱ���Ϣ���������������������
	private static Map<Class, TableInfo> poClassTableMap=new HashMap<>();
	
	private TableContext(){}
	
	static{
		try {
			//��ʼ����ñ����Ϣ
			Connection conn=DBmanager.getConn();
			DatabaseMetaData dbmd=conn.getMetaData();
			ResultSet tableRet =dbmd.getTables(conn.getCatalog(), null, null, new String[]{"TABLE"});
			while (tableRet.next()) {	//conn.getCatalog()!!     //"%","%"
//				String tableName=(String)tableRet.getObject("TABLE_NAME");
				String tableName=tableRet.getString("TABLE_NAME").toLowerCase();
				TableInfo ti=new TableInfo(tableName,new HashMap<String,ColumnInfo>(),
						new ArrayList<ColumnInfo>());	
				tables.put(tableName, ti);
//				System.out.println(tableName);
				ResultSet set=dbmd.getColumns(null, "%", tableName, "%");//��ѯ���������ֶ�
				while(set.next()){
					ColumnInfo ci=new ColumnInfo(set.getString("COLUMN_NAME"),
							set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"),ci);
				}
				////////////////////////////////////
				ResultSet set2=dbmd.getPrimaryKeys(conn.getCatalog(), "%", tableName);//��ѯ���е�����
				while (set2.next()) {
					ColumnInfo ci2=(ColumnInfo)ti.getColumns().get(set2.getString("COLUMN_NAME"));
					ci2.setKeyType(1);//��Ϊ��������
					ti.getPriKeys().add(ci2);
				}
				if(ti.getPriKeys().size()>0){//ȡΨһ����������ʹ�á�(�����������������Ϊ�ա�?)
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݱ�ṹ���������õ�po�������java�� 
	 */
	public static void updateJavaPoFile(){
		Map<String, TableInfo> map=TableContext.getTableInfos();
		for (TableInfo t : map.values()) {
			JavaFileUtils.createJavaPoFile(t, new MysqlTypeConvertor());
			/***************************************************/
//			System.out.println("OnlyPriKey:");
//			System.out.print(t.getOnlyPriKey().getName()+":");
//			System.out.println(t.getOnlyPriKey().getKeyType());
//			System.out.println("-----------------------------");
//			System.out.println("PriKeys:");
//			List<ColumnInfo> list=t.getPriKeys();
//			for (ColumnInfo columnInfo : list) {
//				System.out.print(columnInfo.getName()+":");
//				System.out.println(columnInfo.getKeyType());
//			}
			/***************************************************/
		}
	}
	
	/**
	 *����po���µ���
	 */
	public static void loadPoTables(){ 
		for (TableInfo tableInfo : tables.values()) {
			try {
				Class c=Class.forName(DBmanager.getConf().getPoPackage()
						+"."+StringUtils.firstChar2UpperCase(tableInfo.getTname()));
				poClassTableMap.put(c, tableInfo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, TableInfo> getTableInfos(){
		return tables;
	}
	
	public static void main(String[] args) {
		updateJavaPoFile();
	}
	
}
