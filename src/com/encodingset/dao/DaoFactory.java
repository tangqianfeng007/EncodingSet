package com.encodingset.dao;

import com.encodingset.dao.imp4mysql.JDBCDataSetDaoImp4MySQL;
import com.encodingset.dao.imp4mysql.JDBCEncodeMapDaoImp4MySQL;
import com.encodingset.dao.imp4mysql.JDBCLocalFieldDaoImp4MySQL;
import com.encodingset.dao.imp4oracle.JDBCDataSetDaoImp4Oracle;
import com.encodingset.dao.imp4oracle.JDBCEncodeMapDaoImp4Oracle;
import com.encodingset.dao.imp4oracle.JDBCInfoDaoImp4Oracle;
import com.encodingset.dao.imp4oracle.JDBCLocalFieldDaoImp4Oracle;
import com.encodingset.util.ReadProperties;

/**     
 * 项目名称：EncodingSet   
 * 类名称：DaoFactory   
 * 类描述：DaoFactory类   
 * 创建人：lijie   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class DaoFactory {
	
	public static final String ORCLE = "oracle";
	public static final String MYSQL = "mysql";
	public static final String SQLSERVER = "sqlserver";
	
	private static DaoFactory daoFactory =null;
	
	private static JDBCEncodeMapDao encodeMapDao = null;
	private static JDBCLocalFieldDao localFieldDao = null;
	private static JDBCDataSetDao dataSetDao = null;
	private static JDBCInfoDao infoSetDao = null;
	
	public static DaoFactory getInstance(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	
	public JDBCEncodeMapDao getEncodeMapDao(){
		if(encodeMapDao == null){
			if(ReadProperties.DATABASE_TYPE.equals(ORCLE) ){
				encodeMapDao = new JDBCEncodeMapDaoImp4Oracle();
			}
			else if(ReadProperties.DATABASE_TYPE.equals(MYSQL)){
				encodeMapDao = new JDBCEncodeMapDaoImp4MySQL();
			}
			else if(ReadProperties.DATABASE_TYPE .equals(SQLSERVER)){
				
			}
		}
		return encodeMapDao;
	}
	
	public JDBCLocalFieldDao getLocalFieldDao(){
		if(localFieldDao == null){
			if(ReadProperties.DATABASE_TYPE.equals(ORCLE) ){
				localFieldDao = new JDBCLocalFieldDaoImp4Oracle();
			}
			else if(ReadProperties.DATABASE_TYPE.equals(MYSQL)){
				localFieldDao = new JDBCLocalFieldDaoImp4MySQL();
				
			}
			else if(ReadProperties.DATABASE_TYPE .equals(SQLSERVER)){
				
			}
		}
		return localFieldDao;
	}
	
	public JDBCDataSetDao getDataSetDao(){
		if(dataSetDao == null){
			if(ReadProperties.DATABASE_TYPE.equals(ORCLE) ){
				dataSetDao = new JDBCDataSetDaoImp4Oracle();
			}
			else if(ReadProperties.DATABASE_TYPE.equals(MYSQL)){
				dataSetDao = new JDBCDataSetDaoImp4MySQL();				
			}
			else if(ReadProperties.DATABASE_TYPE .equals(SQLSERVER)){
				
			}
		}
		return dataSetDao;
	}
	
	public JDBCInfoDao getInfoDao(){
		if(infoSetDao == null){
			if(ReadProperties.DATABASE_TYPE.equals(ORCLE) ){
				infoSetDao = new JDBCInfoDaoImp4Oracle();
			}
			else if(ReadProperties.DATABASE_TYPE.equals(MYSQL)){
				//infoSetDao = new JDBCInfoDaoImp4MySQL();				
			}
			else if(ReadProperties.DATABASE_TYPE .equals(SQLSERVER)){
				
			}
		}
		return infoSetDao;
	}
}

