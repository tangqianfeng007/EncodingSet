package com.encodingset.dao.imp4mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.encodingset.bean.LocalFieldBean;
import com.encodingset.dao.imp4oracle.JDBCLocalFieldDaoImp4Oracle;
import com.encodingset.util.DBTool;
import com.encodingset.util.Page;

/**
 * @author lijie
 * @version 创建时间：2014-3-26 上午11:12:06
 * 类说明
 */
public class JDBCLocalFieldDaoImp4MySQL extends JDBCLocalFieldDaoImp4Oracle {
	
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
			String sql = "select * from(select fields_local_id,field_name,field_description,fields_global_id,data_type,is_tran,"
					+ "regex from F_FIELDS_LOCAL where field_name like '%"+fieldnameIndex+"%' and field_description like '%"+fieldDescriptionIndex+"%' order by field_name) t limit "
					+ ((pageNumber - 1) * Page.pageSize)
					+ " , "
					+ Page.pageSize;
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
}
