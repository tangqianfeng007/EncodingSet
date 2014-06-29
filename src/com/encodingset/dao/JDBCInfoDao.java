package com.encodingset.dao;

import java.util.List;

import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCLocalFieldDao   
 * 类描述：本地字段管理相关操作接口 
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public interface JDBCInfoDao {
	//修改密码
	public int editPW(String role, String newPW);	
}

