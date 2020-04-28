package com.leaf.core;

import java.util.List;

/**
 * Query(Core Class)
 * @author leaf
 */
public interface Query {

	/**
	 * @param sql statement
	 * @param params  parameters
	 * @return counts of records
	 */

	public int executeDML(String sql,Object[] params);
	
	public void insert(Object obj);
	
	/**
	 * 删除clazz表示类对应的表中的记录（id：主键值）
	 * @param clazz
	 * @param id
	 * @return	
	 */
	public void delete(Class clazz,int id);
	
	/**
	 * 删除对象在数据库中对应的记录（对象所在类对应到表，对象主键对应到记录）
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * 更新对象对应的记录，只更新指定字段的值
	 * @param obj 所需更新的对象
	 * @param fieldNames 属性表
	 * @return
	 */
	public int update(Object obj,String[] fieldNames);

	/**
	 * 查询返回多条记录，并将每行记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params sql参数
	 * @return 查询到的结果
	 */
	public List queryRows(String sql,Class clazz,Object[] params);//多行多列
	
	/**
	 * 查询返回一条记录，并将每行记录封装到clazz指定的类的对象中
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);//一行多列

	/**
	 * 返回一个数字
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql,Object[] params);//一行一列
}
