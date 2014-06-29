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
public interface JDBCLocalFieldDao {
	//查询本地字段集
	public List<LocalFieldBean> getList(String fieldnameIndex, String fieldDescriptionIndex, int pageNumber);
	//记录数
	public int getCount(String fieldnameIndex, String fieldDescriptionIndex);
	//全局字段集获取
	public List<F_Fields_GlobalBean> getF_Fields_Global(String screenIndex);
	//根据id查询
	public LocalFieldBean getLocalFieldById(Long id);
	//更新本地字段集
	public int updateLocalField(LocalFieldBean bean);
	//增加本地字段集
	public int addLocalField(LocalFieldBean bean);
	//删除本地字段
	public int deleteLocalField(Long id);
}

