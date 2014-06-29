package com.encodingset.dao.imp4oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.encodingset.bean.F_Fields_GlobalBean;
import com.encodingset.bean.LocalFieldBean;
import com.encodingset.dao.JDBCLocalFieldDao;
import com.encodingset.util.DBTool;
import com.encodingset.util.Page;

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
public class JDBCLocalFieldDaoImp4Oracle implements JDBCLocalFieldDao {
	/**
	 * 查询本地字段
	 */
	@Override
	public List<LocalFieldBean> getList(String fieldnameIndex, String fieldDescriptionIndex, int pageNumber) {
		Connection con = null;
		ResultSet resultSet =null;
		PreparedStatement psmt = null;
		List<LocalFieldBean> list = new ArrayList<LocalFieldBean>();
		Page.setPageSize(10);
		try {			
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select * from(select * from(select "
					+ "fields_local_id,field_name,field_description,fields_global_id,data_type,is_tran,"
					+ "regex,ROWNUM RN from F_FIELDS_LOCAL where field_name like '%"+fieldnameIndex+"%' and field_description like '%"+fieldDescriptionIndex+"%' order by field_name)"
					+ " where RN>"+(pageNumber-1)*Page.pageSize+") where  RN<="+(pageNumber)*Page.pageSize;
			psmt = con.prepareStatement(sql);
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
	 * 统计本地字段的数量
	 */
	@Override
	public int getCount(String fieldnameIndex, String fieldDescriptionIndex) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int num = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select count(*) as countNum from F_FIELDS_LOCAL where field_name like '%"+fieldnameIndex+"%' and field_description like '%"+fieldDescriptionIndex+"%'";
			psmt = con.prepareStatement(sql);
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
	 * 获取全局字段集
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
	 * 根据ID获取特定本地字段
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
			String sql2 = "update f_fields_local set fields_local_id=?,field_name=?,field_description=?,"
					+ "fields_global_id=?,data_type=?,is_tran=?,regex=?"
					+ " where fields_local_id=?";
			psmt = con.prepareStatement(sql2);
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
	 * 添加本地字段
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
}

