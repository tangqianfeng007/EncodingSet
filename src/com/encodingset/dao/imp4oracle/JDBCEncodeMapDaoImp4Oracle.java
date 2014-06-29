package com.encodingset.dao.imp4oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.encodingset.bean.EncodeMapShowBean;
import com.encodingset.bean.F_Local_XXXBean;
import com.encodingset.dao.JDBCEncodeMapDao;
import com.encodingset.util.DBTool;
import com.encodingset.util.PKGenerator;
import com.encodingset.util.Page;

/**     
 * 项目名称：EncodingSet   
 * 类名称：JDBCEncodeMapDaoImp4Oracle   
 * 类描述：编码映射管理相关操作接口实现  
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41   
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41  
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class JDBCEncodeMapDaoImp4Oracle implements JDBCEncodeMapDao {
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
			String sql = "select * from( select field_name,code_name,description, val_sys, val_local ,code_mark,myindex, ROWNUM RN "
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
					+ "%' order by c.fields_global_id,a.code_val) "
					+ ") where RN between "
					+ ((pageNumber - 1) * Page.pageSize + 1)
					+ " and "
					+ pageNumber * Page.pageSize;
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
	/**
	 * 获取编码映射数量
	 */
	@Override
	public int getCount(String encodetable, String encodenameIndex1,String encodenameIndex2) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int num = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "select count(*) as countNum from(select distinct c.fields_global_id, c.field_name,a.code_name,a.description,a.code_val as val_sys,b.code_val as val_local ,a.code_mark,b.code_mark as myindex "
					+ " from "
					+ encodetable
					+ " a "
					+ "inner join f_fields_global c on a.fields_global_id = c.fields_global_id"
					+ " left join "
					+ encodetable.replaceAll("Global", "Local")
					+ " b on a.code_mark=b.code_mark"
					+ " where c.field_name like '%"
					+ encodenameIndex1
					+ "%' and code_name like '%"
					+ encodenameIndex2
					+ "%' order by val_sys) d";
			psmt = con.prepareStatement(sql);
			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				num = resultSet.getInt("countNum");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBTool.close(con, resultSet, null, psmt);
		}
		return num;
	}

	/**
	 * 更新编码映射
	 */
	@Override
	public int encodingUpdate(String code_Val_Local, String code_mark,
			String tablename, String oldValue) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			con.setAutoCommit(false);
			// 查询Code_Mark所对应的的所有filed__id
			String field_Id_SQL = "select a.fields_local_id from f_fields_local a"
					+ " inner join "
					+ tablename.replaceAll("Local", "Global")
					+ " b on a.fields_global_id=b.fields_global_id"
					+ " where b.code_mark=?";
			psmt = con.prepareStatement(field_Id_SQL);
			psmt.setString(1, code_mark);
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				String valueNumsql = "select count(*) as valueNum from "
						+ tablename + " where FIELDS_LOCAL_ID="
						+ resultSet.getString(1) + " and CODE_VAL=?";
				psmt = con.prepareStatement(valueNumsql);
				psmt.setString(1,code_Val_Local);
				resultSet = psmt.executeQuery();
				if (resultSet.next()) {
					if (!"0".equals(resultSet.getString("valueNum"))) {// 判断每个FIELDS_LOCAL_ID对应的CODE_VAL唯一
						return flag = -2;
					}
				}
			}
			String sql_update = "update " + tablename + " set Code_Val =? where Code_Mark =? and Code_Val =?";
			psmt = con.prepareStatement(sql_update);
			psmt.setString(1, code_Val_Local);
			psmt.setString(2, code_mark);
			psmt.setString(3, oldValue);
			flag = psmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				DBTool.close(con, resultSet, null, psmt);
			}
		return flag;	
	}	

	/**
	 * 添加编码映射
	 */
	@Override
	public int encodingAdd(F_Local_XXXBean f_Local_xxx, String tablename) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		int flag = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			con.setAutoCommit(false);
			// 查询Code_Mark所对应的的所有filed__id
			String field_Id_SQL = "select a.fields_local_id from f_fields_local a"
					+ " inner join "
					+ tablename.replaceAll("Local", "Global")
					+ " b on a.fields_global_id=b.fields_global_id"
					+ " where b.code_mark=?";
			psmt = con.prepareStatement(field_Id_SQL);
			psmt.setString(1, f_Local_xxx.getCode_mark());
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				String valueNumsql = "select count(*) as valueNum from "
						+ tablename + " where FIELDS_LOCAL_ID="
						+ resultSet.getString(1) + " and CODE_VAL=?";
				psmt = con.prepareStatement(valueNumsql);
				psmt.setString(1, f_Local_xxx.getCode_Val_Local());
				resultSet = psmt.executeQuery();
				if (resultSet.next()) {
					if (!"0".equals(resultSet.getString("valueNum"))) {// 判断每个FIELDS_LOCAL_ID对应的CODE_VAL唯一
						return flag = -2;
					}
				}
			}
			if (!resultSet.next()) {
				// 判断本地字段集是否有相关记录
				String field_Id_SQL2 = "select a.fields_local_id from f_fields_local a"
						+ " inner join "
						+ tablename.replaceAll("Local", "Global")
						+ " b on a.fields_global_id=b.fields_global_id"
						+ " where b.code_mark='"
						+ f_Local_xxx.getCode_mark()
						+ "'";
				psmt = con.prepareStatement(field_Id_SQL2);
				resultSet = psmt.executeQuery();
				if (!resultSet.next()) {
					return flag = -3;// 不存在fields_local_id
				} else {
					while (true) {
						String fields_local_id = resultSet.getString(1);
						String sql_add = "insert into "
								+ tablename
								+ "(Local_"
								+ tablename.split("_")[2]
								+ "_ID,Fields_Local_ID,Code_Mark,Data_Provider_ID,Code_Val) "
								+ "values(?,?,?,?,?)";
						psmt = con.prepareStatement(sql_add);
						psmt.setLong(1, PKGenerator.getInstance().generateKey());
						psmt.setLong(2, Long.parseLong(fields_local_id));
						psmt.setString(3, f_Local_xxx.getCode_mark());
						psmt.setLong(4, Long.parseLong(f_Local_xxx
								.getData_Provider_ID()));
						psmt.setString(5, f_Local_xxx.getCode_Val_Local());
						flag = psmt.executeUpdate();
						if (resultSet.next() == false)
							break;
					}
				}
			}
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBTool.close(con, resultSet, null, psmt);
		}
		return flag;
	}
	/**
	 * 删除编码映射
	 */
	@Override
	public int encodingDel(String code_mark, String tablename, String oldValue) {
		Connection con = null;
		PreparedStatement psmt = null;
		int flag = 0;
		try {
			con = DBTool.getInstance().getJdbcConnection();
			String sql = "delete from " + tablename
					+ " where Code_Mark = ?  and code_val = ? ";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, code_mark);
			psmt.setString(2, oldValue);
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBTool.close(con, null, null, psmt);
		}
		return flag;
	}

}
