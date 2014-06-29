package com.encodingset.dao;

import java.util.List;

import com.encodingset.bean.EncodeMapShowBean;
import com.encodingset.bean.F_Local_XXXBean;


/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCEncodeMapDao   
 * 类描述：编码映射管理相关操作接口   
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41  
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public interface JDBCEncodeMapDao {
	//查询映射
	public List<EncodeMapShowBean> getList(String encodetable,String fieldName,String encodename,int pageNumber);
	//修改映射
	public int encodingUpdate(String code_Val_Local,String code_mark,String tablename,String oldValue);
	//添加映射
	public int encodingAdd(F_Local_XXXBean f_Local_xxx,String tablename);
	//数据数量
	public int getCount(String encodetable,String fieldName,String encodenameIndex);
	//删除映射
	public int encodingDel(String code_mark,String tablename,String oldValue);

}
