package com.encodingset.bean;

/**     
 * 项目名称：EncodingSet   
 * 类名称：F_Local_XXXBean   
 * 类描述：映射数据库所有F_Local_XXX表的bean   
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41  
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41  
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class F_Local_XXXBean {
	private String local_xxx_ID;
	private String fields_local_id;
	private String code_mark;
	private String code_Val_Local;
	private String data_Provider_ID="0";
	
	public String getLocal_xxx_ID() {
		return local_xxx_ID;
	}
	public void setLocal_xxx_ID(String local_xxx_ID) {
		this.local_xxx_ID = local_xxx_ID;
	}
	public String getFields_local_id() {
		return fields_local_id;
	}
	public void setFields_local_id(String fields_local_id) {
		this.fields_local_id = fields_local_id;
	}
	public String getCode_mark() {
		return code_mark;
	}
	public void setCode_mark(String code_mark) {
		this.code_mark = code_mark;
	}
	public String getCode_Val_Local() {
		return code_Val_Local;
	}
	public void setCode_Val_Local(String code_Val_Local) {
		this.code_Val_Local = code_Val_Local;
	}
	public String getData_Provider_ID() {
		return data_Provider_ID;
	}
	public void setData_Provider_ID(String data_Provider_ID) {
		this.data_Provider_ID = data_Provider_ID;
	}
}

