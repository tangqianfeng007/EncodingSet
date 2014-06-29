package com.encodingset.bean;

/**     
 * 项目名称：EncodingSet   
 * 类名称：LocalFieldBean   
 * 类描述：本地字段集bean
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41    
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41   
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class LocalFieldBean {
	private long fields_Local_ID;
	private String field_Name;
	private String field_Description;
	private String fields_Global_ID;
	private String data_Type;
	private String is_Tran;
	private String regex;
	private String is_req;
	
	public String getIs_req() {
		return is_req;
	}
	public void setIs_req(String isReq) {
		is_req = isReq;
	}
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public long getFields_Local_ID() {
		return fields_Local_ID;
	}
	public void setFields_Local_ID(long fields_Local_ID) {
		this.fields_Local_ID = fields_Local_ID;
	}
	public String getField_Name() {
		return field_Name;
	}
	public void setField_Name(String field_Name) {
		this.field_Name = field_Name;
	}
	public String getField_Description() {
		return field_Description;
	}
	public void setField_Description(String field_Description) {
		this.field_Description = field_Description;
	}
	public String getFields_Global_ID() {
		return fields_Global_ID;
	}
	public void setFields_Global_ID(String fields_Global_ID) {
		this.fields_Global_ID = fields_Global_ID;
	}
	public String getData_Type() {
		return data_Type;
	}
	public void setData_Type(String data_Type) {
		this.data_Type = data_Type;
	}
	public String getIs_Tran() {
		return is_Tran;
	}
	public void setIs_Tran(String is_Tran) {
		this.is_Tran = is_Tran;
	}
	
}

