package com.encodingset.dao.imp4mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.encodingset.bean.EncodeMapShowBean;
import com.encodingset.dao.imp4oracle.JDBCEncodeMapDaoImp4Oracle;
import com.encodingset.util.DBTool;
import com.encodingset.util.Page;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCEncodeMapDaoImp4MySQL   
 * 类描述：   
 * 创建人：lijie   
 * 创建时间：2014-1-23 上午09:47:00   
 * 修改人：lijie   
 * 修改时间：2014-1-23 上午09:47:00   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class JDBCEncodeMapDaoImp4MySQL extends JDBCEncodeMapDaoImp4Oracle {	
	
	/**
	 *查询编码映射
	 */
	@Override
	public List<EncodeMapShowBean> getList(String encodetable,
			String encodenameIndex1,String encodenameIndex2, int pageNumber) {
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement psmt = null;
		List<EncodeMapShowBean> list = new ArrayList<EncodeMapShowBean>();
		Page.setPageSize(10);
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select * from( select field_name,code_name,description, val_sys, val_local ,code_mark,myindex"
					+ " from (select distinct c.fields_global_id, c.field_name,a.code_name,a.description,a.code_val as val_sys,b.code_val as val_local ,a.code_mark,b.code_mark as myindex "
					+ " from "
					+ encodetable
					+ " a inner join f_fields_global c on a.fields_global_id = c.fields_global_id "
					+ " left join "
					+ encodetable.replaceAll("Global", "Local")
					+ " b on a.code_mark=b.code_mark"
					+ " where c.field_name like '%"
					+ encodenameIndex1
					+ "%' and code_name like '%"
					+ encodenameIndex2
					+ "%' order by c.fields_global_id,a.code_val) d "
					+ ") e limit "
					+ ((pageNumber - 1) * Page.pageSize)
					+ " , "
					+ Page.pageSize;
			psmt = con.prepareStatement(sql);			
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				EncodeMapShowBean bean = new EncodeMapShowBean();
				bean.setField_Name(resultSet.getString("field_name"));
				bean.setCode_Name(resultSet.getString("code_name"));
				bean.setDescription(resultSet.getString("description"));
				bean.setCode_Val_System(resultSet.getString("val_sys"));
				bean.setCode_Val_Local(resultSet.getString("val_local"));
				bean.setCode_mark(resultSet.getString("code_mark"));
				bean.setMyIndex(resultSet.getString("myindex"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBTool.close(con, resultSet, null, psmt);
		}
		return list;
	}	
}
