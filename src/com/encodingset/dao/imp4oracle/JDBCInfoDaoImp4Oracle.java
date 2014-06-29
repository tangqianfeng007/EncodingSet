package com.encodingset.dao.imp4oracle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import com.encodingset.dao.JDBCInfoDao;
import com.encodingset.util.AESTool;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCLocalFieldDaoImp4Oracle   
 * 类描述：本地字段管理相关操作接口实现  
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class JDBCInfoDaoImp4Oracle implements JDBCInfoDao {

	@Override
	public int editPW(String role, String newPW) {	
		File sourceFile = new File("Administrators.properties");
		try {
			PrintWriter pWriter  = new PrintWriter(sourceFile);
			pWriter.write("name="+role+"\r\n"+"password="+newPW);
			pWriter.flush();
			pWriter.close();
			AESTool.encryptFile(sourceFile, null, AESTool.key);
			sourceFile.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
}

