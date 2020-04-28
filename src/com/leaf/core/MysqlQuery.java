package com.leaf.core;

import java.util.List;

public class MysqlQuery implements Query{

	@Override
	public int executeDML(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class clazz, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Object obj, String[] fieldNames) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
