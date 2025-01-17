package com.leaf.bean;

import java.util.List;
import java.util.Map;

public class TableInfo {
	
	private String tname;//表名
	private Map<String, ColumnInfo> columns;//所有字段信息
	private ColumnInfo onlyPriKey;//唯一主键
	private List<ColumnInfo> priKeys;//联合主键	

	public TableInfo() {
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	
	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	
	public List<ColumnInfo> getPriKeys() {              
		return priKeys;                                 
    }                                                   
                                                        
    public void setPriKeys(List<ColumnInfo> priKeys) {  
    	this.priKeys = priKeys;                         
    }                                                 
} 