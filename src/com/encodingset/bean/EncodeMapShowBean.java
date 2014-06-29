package com.encodingset.bean;

/**     
 * 项目名称：EncodingSet   
 * 类名称：EncodeMapShowBean   
 * 类描述：编码映射前端显示bean 三表级联bean   
 * 创建人：tangqianfeng   
 * 创建时间：2014-1-8 上午09:58:41    
 * 修改人：lijie   
 * 修改时间：2014-1-8 上午09:58:41    
 * 修改备注：   
 * @version V1.0 
 * 
 */ 
public class EncodeMapShowBean {
	private String field_Name;
	private String code_Name;
	private String description;
	private String code_Val_System;
	private String code_Val_Local;
	//前端隐藏字段
	private String code_mark;
	//前端隐藏字段
	private String myIndex;
	
	public String getMyIndex() {
		return myIndex;
	}

	public String getField_Name() {
		return field_Name;
	}

	public void setField_Name(String fieldName) {
		field_Name = fieldName;
	}

	public void setMyIndex(String myIndex) {
		this.myIndex = myIndex;
	}
	public String getCode_Name() {
		return code_Name;
	}
	public void setCode_Name(String code_Name) {
		this.code_Name = code_Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode_Val_System() {
		return code_Val_System;
	}
	public void setCode_Val_System(String code_Val_System) {
		this.code_Val_System = code_Val_System;
	}
	public String getCode_Val_Local() {
		return code_Val_Local;
	}
	public void setCode_Val_Local(String code_Val_Local) {
		this.code_Val_Local = code_Val_Local;
	}
	public String getCode_mark() {
		return code_mark;
	}
	public void setCode_mark(String code_mark) {
		this.code_mark = code_mark;
	}
}

