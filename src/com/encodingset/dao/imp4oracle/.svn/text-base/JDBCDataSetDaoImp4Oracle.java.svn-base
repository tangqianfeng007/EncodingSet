package com.encodingset.dao.imp4oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encodingset.bean.DataSetBean;
import com.encodingset.bean.DatasetLocalFieldBean;
import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;
import com.encodingset.dao.JDBCDataSetDao;
import com.encodingset.util.DBTool;
import com.encodingset.util.PKGenerator;
import com.encodingset.util.Page;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCDataSetDaoImp4Oracle   
 * 类描述：数据集管理相关操作接口实现   
 * 创建人：lijie   
 * 创建时间：2014-1-2 下午04:23:48   
 * 修改人：lijie   
 * 修改时间：2014-1-2 下午04:23:48   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class JDBCDataSetDaoImp4Oracle implements JDBCDataSetDao {
	
	/**
	 * 获取全部数据集Map
	 */
	@Override
	public Map<String, List<DataSetBean>> getTree() {
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement psmt = null;
		List<DataSetBean> EHRlist = new ArrayList<DataSetBean>();
		List<DataSetBean> EMRlist = new ArrayList<DataSetBean>();
		List<DataSetBean> HIlist = new ArrayList<DataSetBean>();
		Map<String, List<DataSetBean>> map = new HashMap<String, List<DataSetBean>>();
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql1 = "select * from F_DATASET t where dataset_type='EHR' order by t.DATASET_NAME";
			psmt = con.prepareStatement(sql1);
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				DataSetBean bean = new DataSetBean();
				bean.setDataset_ID(resultSet.getLong("dataset_ID"));
				bean.setDataset_Name(resultSet.getString("dataset_Name"));
				bean.setDataset_Description(resultSet
						.getString("dataset_Description"));
				bean.setDataset_Type(resultSet.getString("dataset_Type"));
				EHRlist.add(bean);
				map.put("EHRlist", EHRlist);
			}
			String sql2 = "select * from F_DATASET t where dataset_type='EMR' order by t.DATASET_NAME";
			psmt = con.prepareStatement(sql2);
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				DataSetBean bean = new DataSetBean();
				bean.setDataset_ID(resultSet.getLong("dataset_ID"));
				bean.setDataset_Name(resultSet.getString("dataset_Name"));
				bean.setDataset_Description(resultSet
						.getString("dataset_Description"));
				bean.setDataset_Type(resultSet.getString("dataset_Type"));
				EMRlist.add(bean);
				map.put("EMRlist", EMRlist);
			}
			String sql3 = "select * from F_DATASET t where dataset_type='HI' order by t.DATASET_NAME";
			psmt = con.prepareStatement(sql3);
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				DataSetBean bean = new DataSetBean();
				bean.setDataset_ID(resultSet.getLong("dataset_ID"));
				bean.setDataset_Name(resultSet.getString("dataset_Name"));
				bean.setDataset_Description(resultSet
						.getString("dataset_Description"));
				bean.setDataset_Type(resultSet.getString("dataset_Type"));
				HIlist.add(bean);
				map.put("HIlist", HIlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBTool.close(con, resultSet, null, psmt);
		}
		return map;
	}

    /**
     * 获取数据集对应的本地字段
     */
	@Override
	public List<DatasetLocalFieldBean> getFLList(long dataSetId) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		List<DatasetLocalFieldBean> list = new ArrayList<DatasetLocalFieldBean>();
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select b.fields_local_id,b.field_name,b.field_description,b.fields_global_id,b.data_type,"
				+"b.is_tran,b.regex,a.rel_id,a.dataset_id,a.is_req from F_REL_DATASET_FIELD a left join F_FIELDS_LOCAL b "
				+"on a.fields_local_id=b.fields_local_id where a.dataset_id = ? order by b.fields_local_id";	
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, dataSetId);
			resultSet = psmt.executeQuery();
			while(resultSet.next()){
				DatasetLocalFieldBean bean =  new DatasetLocalFieldBean();
				bean.setDataset_ID(resultSet.getLong("dataset_id"));
				bean.setRel_Id(resultSet.getLong("rel_id"));
				bean.setIs_Req(resultSet.getString("is_req"));
				bean.setFields_Local_ID(resultSet.getLong("fields_local_id"));
				bean.setField_Name(resultSet.getString("field_name"));
				bean.setField_Description(resultSet.getString("field_description"));
				bean.setFields_Global_ID(resultSet.getString("fields_global_id"));
				bean.setData_Type(resultSet.getString("data_type"));
				bean.setIs_Tran(resultSet.getString("is_tran"));
				bean.setRegex(resultSet.getString("regex"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBTool.close(con, resultSet, null, psmt);
		}
		return list;
	}

	/**
     * 获取某一数据集
     */
	@Override
	public DataSetBean getDataset(long dataSetId) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		DataSetBean bean =  new DataSetBean();
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select * from F_DATASET t where t.dataset_id = ?";				
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, dataSetId);
			resultSet = psmt.executeQuery();
			while(resultSet.next()){				
				bean.setDataset_ID(resultSet.getLong("dataset_id"));
				bean.setDataset_Name(resultSet.getString("dataset_name"));
				bean.setDataset_Description(resultSet.getString("dataset_description"));
				bean.setDataset_Type(resultSet.getString("dataset_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBTool.close(con, resultSet, null, psmt);
		}
		return bean;
	}

	/**
     * 更新某一数据集
     */
	@Override
	public int updateDataset(DataSetBean bean) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql1 = "select count(*) as valueNum from F_DATASET t where t.dataset_name = ? and t.dataset_id != ?";
			psmt = con.prepareStatement(sql1);			
			psmt.setString(1, bean.getDataset_Name());
			psmt.setLong(2, bean.getDataset_ID());
			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				if (!"0".equals(resultSet.getString("valueNum"))) {
					return flag = -2;
				}
			}			
			String sql2 = "update F_DATASET set dataset_name=?,dataset_description=?,dataset_type=? where dataset_id=?";
			psmt = con.prepareStatement(sql2);			
			psmt.setString(1, bean.getDataset_Name());
			psmt.setString(2, bean.getDataset_Description());
			psmt.setString(3, bean.getDataset_Type());
			psmt.setLong(4, bean.getDataset_ID());
			flag =  psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     *添加数据集
     */
	@Override
	public int addDataset(DataSetBean bean) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql1 = "select count(*) as valueNum from F_DATASET t where t.dataset_name = ?";
			psmt = con.prepareStatement(sql1);			
			psmt.setString(1, bean.getDataset_Name());
			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				if (!"0".equals(resultSet.getString("valueNum"))) {
					return flag = -2;
				}
			}			
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "insert into F_DATASET(dataset_id,dataset_name,dataset_description,dataset_type) values(?,?,?,?)";
			psmt = con.prepareStatement(sql);			
			psmt.setLong(1, bean.getDataset_ID());
			psmt.setString(2, bean.getDataset_Name());
			psmt.setString(3, bean.getDataset_Description());
			psmt.setString(4, bean.getDataset_Type());
			flag =  psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     * 删除数据集
     */
	@Override
	public int deleteDataset(long dataset_ID) {
		int flag=0;
		try {
			Connection con = null;
			PreparedStatement psmt = null;
			ResultSet resultSet =null;
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "delete from F_DATASET where dataset_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, dataset_ID);
			flag = psmt.executeUpdate();
			String sql1 = "select count(*) as Num from F_REL_DATASET_FIELD where dataset_id=?";
			psmt = con.prepareStatement(sql1);
			psmt.setLong(1, dataset_ID);
			resultSet = psmt.executeQuery();
			resultSet.next();
			if(!"0".equals(resultSet.getString("Num"))){				
				String sql2 = "delete from F_REL_DATASET_FIELD where dataset_id=?";
				psmt = con.prepareStatement(sql2);
				psmt.setLong(1, dataset_ID);
				flag = psmt.executeUpdate();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	/**
     * 查询本地字段
     */
	@Override
	public List<LocalFieldBean> getList(String fieldnameIndex, String fieldDescriptionIndex, int pageNumber,long dataSet_id) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		List<LocalFieldBean> list = new ArrayList<LocalFieldBean>();
		Page.setPageSize(5);
		try {			
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select * from(select * from(select "
					+ "fields_local_id,field_name,field_description,fields_global_id,data_type,is_tran,"
					+ "regex,ROWNUM RN from F_FIELDS_LOCAL where field_name like '%"+fieldnameIndex+"%' and field_description like '%"+fieldDescriptionIndex+"%' "
					+ "and fields_local_id not in(select t.fields_local_id from F_REL_DATASET_FIELD t where t.dataset_id=?) order by field_name)"
					+ " where RN>"+(pageNumber-1)*Page.pageSize+") where  RN<="+(pageNumber)*Page.pageSize;
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, dataSet_id);
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				LocalFieldBean bean = new LocalFieldBean();
				bean.setFields_Local_ID(resultSet.getLong("fields_local_id"));
				bean.setField_Name(resultSet.getString("field_name"));
				bean.setField_Description(resultSet.getString("field_description"));
				bean.setFields_Global_ID(resultSet.getString("fields_global_id"));
				bean.setData_Type(resultSet.getString("data_type"));
				bean.setIs_Tran(resultSet.getString("is_tran"));
				bean.setRegex(resultSet.getString("regex"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBTool.close(con, resultSet, null, psmt);
		}
		return list;
	}

	/**
     * 获取本地字段数量
     */
	@Override
	public int getCount(String fieldnameIndex, String fieldDescriptionIndex, long dataSet_id) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int num = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select count(*) as countNum from F_FIELDS_LOCAL where field_name like '%"+fieldnameIndex+"%' and field_description like '%"+fieldDescriptionIndex+"%' "
					+ "and fields_local_id not in(select t.fields_local_id from F_REL_DATASET_FIELD t where t.dataset_id=?)";
			psmt = con.prepareStatement(sql);
			System.out.println(sql);
			psmt.setLong(1, dataSet_id);
			resultSet = psmt.executeQuery();
			if(resultSet.next()){
				num  = resultSet.getInt("countNum");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBTool.close(con, resultSet, null, psmt);
		}
		return num;
	}

	/**
     * 获取所有全局字段
     */
	@Override
	public List<F_Fields_GlobalBean> getF_Fields_Global(String screenIndex) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		String sql = null;
		List<F_Fields_GlobalBean> list = new ArrayList<F_Fields_GlobalBean>();
		try {
			con = DBTool.getInstance().getJdbcConnection();
			if("null".equals(screenIndex))
			  sql = "select * from F_Fields_Global";
			else
			  sql = "select * from F_Fields_Global t where  t.fields_global_id||t.field_name like '%"+screenIndex+"%'";
			psmt = con.prepareStatement(sql);
			resultSet = psmt.executeQuery();
			while(resultSet.next()){
				F_Fields_GlobalBean bean = new F_Fields_GlobalBean();
				bean.setFields_Global_ID(resultSet.getString("fields_global_id"));
				bean.setField_Description(resultSet.getString("field_description"));
				bean.setField_Name(resultSet.getString("field_name"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBTool.close(con, resultSet, null, psmt);
		}
		return list;
	}

	/**
     * 获取某一本地字段
     */
	@Override
	public LocalFieldBean getLocalFieldById(Long id) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		LocalFieldBean bean =new LocalFieldBean();
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select "
					+ "fields_local_id,field_name,field_description,fields_global_id,data_type,is_tran,regex "
					+ "from F_FIELDS_LOCAL where fields_local_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1,id);
			resultSet = psmt.executeQuery();
			if(resultSet.next()){
				bean.setFields_Local_ID(resultSet.getLong("fields_local_id"));
				bean.setField_Name(resultSet.getString("field_name"));
				bean.setField_Description(resultSet.getString("field_description"));
				bean.setFields_Global_ID(resultSet.getString("fields_global_id"));
				bean.setData_Type(resultSet.getString("data_type"));
				bean.setIs_Tran(resultSet.getString("is_tran"));
				bean.setRegex(resultSet.getString("regex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
     * 更新本地字段
     */
	@Override
	public int updateLocalField(LocalFieldBean bean) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql1 = "select count(*) as valueNum from f_fields_local t where t.field_name = ? and t.fields_local_id != ?";
			psmt = con.prepareStatement(sql1);
			psmt.setString(1, bean.getField_Name());
			psmt.setLong(2, bean.getFields_Local_ID());
			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				if (!"0".equals(resultSet.getString("valueNum"))) {
					return flag = -2;
				}
			}			
			String sql = "update f_fields_local set fields_local_id=?,field_name=?,field_description=?,"
					+ "fields_global_id=?,data_type=?,is_tran=?,regex=?"
					+ " where fields_local_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, bean.getFields_Local_ID());
			psmt.setString(2, bean.getField_Name());
			psmt.setString(3, bean.getField_Description());
			psmt.setString(4, bean.getFields_Global_ID());
			psmt.setString(5, bean.getData_Type());
			psmt.setString(6, bean.getIs_Tran());
			psmt.setString(7, bean.getRegex());
			psmt.setLong(8, bean.getFields_Local_ID());
			flag =  psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     * 添加本地
     */
	@Override
	public int addLocalField(LocalFieldBean bean) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql1 = "select count(*) as valueNum from f_fields_local t where t.field_name = ?";
			psmt = con.prepareStatement(sql1);
			psmt.setString(1, bean.getField_Name());
			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				if (!"0".equals(resultSet.getString("valueNum"))) {
					return flag = -2;
				}
			}			
			String sql = "insert into f_fields_local(fields_local_id,field_name,field_description,"
					+ "fields_global_id,data_type,is_tran,regex) values(?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, bean.getFields_Local_ID());
			psmt.setString(2, bean.getField_Name());
			psmt.setString(3, bean.getField_Description());
			psmt.setString(4, bean.getFields_Global_ID());
			psmt.setString(5, bean.getData_Type());
			psmt.setString(6, bean.getIs_Tran());
			psmt.setString(7, bean.getRegex());
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 删除本地字段
     */
	@Override
	public int deleteLocalField(Long id) {
		Connection con = null;
		PreparedStatement psmt = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "delete from f_fields_local where fields_local_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, id);
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     * 更新数据集字段关系
     */
	@Override
	public int updateRef(Long refId, String isReq) {
		Connection con = null;
		PreparedStatement psmt = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "update F_REL_DATASET_FIELD t set t.is_req=?  where t.rel_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, isReq);
			psmt.setLong(2, refId);
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     * 删除数据集字段关系
     */
	@Override
	public int delRef(Long refId) {
		Connection con = null;
		PreparedStatement psmt = null;
		int flag=0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "delete from F_REL_DATASET_FIELD where rel_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setLong(1, refId);
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
     * 添加数据集字段关系
     */
	@Override
	public int addRef(Long dataSetID, String[] arr) {
		Connection con = null;
		PreparedStatement psmt = null;
		int flag=0;		
		try {
			int i = 0;
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "insert into F_REL_DATASET_FIELD(rel_id,dataset_id,fields_local_id,is_req) values(?,?,?,'N')";
			psmt = con.prepareStatement(sql);
			for(;i < arr.length;i++){			
				psmt.setLong(1, PKGenerator.getInstance().generateKey());
				psmt.setLong(2, dataSetID);
				psmt.setLong(3, Long.parseLong(arr[i]));
				flag = psmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
