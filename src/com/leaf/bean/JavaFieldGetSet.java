package com.leaf.bean;
/**
 * 封装java的属性和get和set方法的源代码
 * @author Lenovo
 *
 */
public class JavaFieldGetSet {
	private String fieldInfo;
	private String getInfo;
	private String setInfo;
	
	public JavaFieldGetSet() {
	}
	
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	
	@Override
	public String toString() {
		System.out.println(fieldInfo);
		System.out.println(setInfo);
		System.out.println(getInfo);
		return super.toString();
	}
}
