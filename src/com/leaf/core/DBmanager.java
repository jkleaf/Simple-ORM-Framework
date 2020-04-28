package com.leaf.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.leaf.bean.Configuration;

/**
 * 根据配置信息，维持连接对象的管理(增加连接池的功能)
 * @author leaf
 *
 */
public class DBmanager {
	private static Configuration conf=null;
	private static Properties prop=null;
	static{//加载配置信息
		prop=new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		conf=new Configuration();
		conf.setDriver(prop.getProperty("driver"));
		conf.setUrl(prop.getProperty("url"));
		conf.setUser(prop.getProperty("user"));
		conf.setPwd(prop.getProperty("pwd"));
		conf.setUsingDB(prop.getProperty("usingDB"));
		conf.setSrcPath(prop.getProperty("srcPath"));
		conf.setPoPackage(prop.getProperty("poPackage"));
	}
	
	public static Connection getConn(){
		try {
			System.out.println(conf.getDriver());
			System.out.println(conf.getUrl());
			System.out.println(conf.getUser());
			System.out.println(conf.getPwd());
			Class.forName(conf.getDriver());//已封装好
			return DriverManager.getConnection(
					conf.getUrl(),conf.getUser(),conf.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void Closeall(AutoCloseable... states){
		for (AutoCloseable state : states) {
			try {
				if(state!=null)
					state.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static Configuration getConf(){
		return conf;
	}
}
