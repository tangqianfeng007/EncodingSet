package com.encodingset.dao;

import java.util.List;
import java.util.Map;

import com.encodingset.bean.DataSetBean;
import com.encodingset.bean.DatasetLocalFieldBean;
import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCDataSetDao   
 * 类描述：数据集管理相关操作接口   
 * 创建人：lijie   
 * 创建时间：2014-1-3 上午09:49:30   
 * 修改人：lijie   
 * 修改时间：2014-1-3 上午09:49:30   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public interface JDBCDataSetDao {
	//获得dataset树
	public  Map<String, List<DataSetBean>> getTree();
	//获得filedlocallist
	public List<DatasetLocalFieldBean> getFLList(long dataSet_id);
	//获得dataset
	public DataSetBean getDataset(long dataSet_id);
	//修改dataset
	public int updateDataset(DataSetBean bean);
	//添加dataset
	public int addDataset(DataSetBean bean);
	//删除dataset
	public int deleteDataset(long id);
	//查询本地字段集
	public List<LocalFieldBean> getList(String fieldnameIndex, String fieldDescriptionIndex, int pageNumber, long dataSet_id);
	//记录数
	public int getCount(String fieldnameIndex, String fieldDescriptionIndex, long dataSet_id);
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
	//添加数据集关系表
	public int addRef(Long dataSet_ID,String[] arr);
	//修改数据集关系表
	public int updateRef(Long refId,String is_Req);
	//删除数据集关系表
	public int delRef(Long refId);
}

