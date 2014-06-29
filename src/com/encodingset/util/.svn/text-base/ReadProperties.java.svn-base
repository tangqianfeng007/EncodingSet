package com.encodingset.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.encodingset.dao.DaoFactory;


/**
*
*@Author tangqianfeng 
*@Version 1.0
*
*/
public class ReadProperties {
	public static String DATABASE_TYPE;// 数据库类型

	static {
		ResourceBundle rBundle = ResourceBundle.getBundle("DBLoginKey");
		DATABASE_TYPE = getPropertyString(rBundle, "DATABASE_TYPE");
		
		/*
		 * 连接池配置
		 */
		if(DATABASE_TYPE.equals(DaoFactory.ORCLE)){
			connectionPoolInit("Druid4ORACLE.properties");
		}
		else if(DATABASE_TYPE.equals(DaoFactory.MYSQL)){
			connectionPoolInit("Druid4MYSQL.properties");
		}
		else if(DATABASE_TYPE.equals(DaoFactory.SQLSERVER)){
			connectionPoolInit("Druid4SQLSERVER.properties");
		}
	}
	
	private static void connectionPoolInit(String poolSet){
		try {
            Properties p = new Properties();
            InputStream inputStream = new BufferedInputStream(ReadProperties.class.getResourceAsStream(poolSet));
            p.load(inputStream);
            DBTool.getInstance().setDataSource(DruidDataSourceFactory.createDataSource(p));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static String getPropertyString(ResourceBundle rBundle, String key) {
		try {
			return rBundle.getString(key).trim();
		} catch (Exception ex) {
			return "";
		}
	}
}
