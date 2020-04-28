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
	 * ɾ��clazz��ʾ���Ӧ�ı��еļ�¼��id������ֵ��
	 * @param clazz
	 * @param id
	 * @return	
	 */
	public void delete(Class clazz,int id);
	
	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼�������������Ӧ��������������Ӧ����¼��
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * ���¶����Ӧ�ļ�¼��ֻ����ָ���ֶε�ֵ
	 * @param obj ������µĶ���
	 * @param fieldNames ���Ա�
	 * @return
	 */
	public int update(Object obj,String[] fieldNames);

	/**
	 * ��ѯ���ض�����¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql,Class clazz,Object[] params);//���ж���
	
	/**
	 * ��ѯ����һ����¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);//һ�ж���

	/**
	 * ����һ������
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql,Object[] params);//һ��һ��
}
