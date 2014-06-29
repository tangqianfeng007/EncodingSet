<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<!-- 本地编辑表  -->
		<div align="center">			
		  <table>
		    <tr>
		     <td>		     
		      <table class="tlist">
		      	<tr style='background-color:#d9e8f5'>
		         	<td colspan="2" align="center">
		         		<c:if test="${localFieldBean.fields_Local_ID == null}">		         		
			         		<h2>本地字段添加</h2>
		         		</c:if>
		         		<c:if test="${localFieldBean.fields_Local_ID != null}">
			         		<h2>本地字段编辑</h2>
		         		</c:if>
		         	</td>
		        </tr>   
		        <tr>
		        	 <td>
			          <b>本地字段：</b>
			        </td>
			        <td align="left">
			          	<input id="field_Name" type='text' style='width:300px' value='${localFieldBean.field_Name}' />
			        </td> 
			    </tr>
			    <tr>
			        <td>
			          <b>字段描述：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="field_Description" type='text'  style='width:300px' value='${localFieldBean.field_Description}' />
			        </td> 
		         </tr>
		         <tr>
			        <td>
			          <b>对应全局字段：</b>
			        </td>
			        <td align="left" style='height:50px' >
		            	<div id="screendiv">
						 	 <label><b>筛选条件：</b></label><input id="screenIndex" type="text" >&nbsp;&nbsp;
						     <input type="button"  onclick="javascript:screen()" value="&nbsp;筛&nbsp;&nbsp;选&nbsp;"/><br/><br/>	
							 <select id="fields_Global_ID" name='is_tran' style='width:300px'>   
							 	<option value=""></option>	  
							 	<c:forEach var="f_Fields_GlobalList" items="${f_Fields_GlobalList}">        	 		
							 		<c:if test="${f_Fields_GlobalList.fields_Global_ID == localFieldBean.fields_Global_ID}">
							 			<option value='${f_Fields_GlobalList.fields_Global_ID}' selected="selected">${f_Fields_GlobalList.fields_Global_ID}【${f_Fields_GlobalList.field_Name}】</option>
							 		</c:if>	
							 		<c:if test="${f_Fields_GlobalList.fields_Global_ID != localFieldBean.fields_Global_ID}">
							 			<option value='${f_Fields_GlobalList.fields_Global_ID}'>${f_Fields_GlobalList.fields_Global_ID}【${f_Fields_GlobalList.field_Name}】</option>        
							 		</c:if>							 			
						 		</c:forEach>  						 	
						   </select>
		            	</div>			         	              			        	
			        </td> 			       
		         </tr>		        
		         <tr>
			        <td>
			          <b>是否转码：</b>
			        </td>
			        <td align="left">
			        	 <select id="is_Tran" name='is_tran' style='width: 130px'>
			        	 	<c:if test="${localFieldBean.is_Tran != null}">
			        			<c:if test="${localFieldBean.is_Tran == 'Y'}">
			        			    <option  value="N">否</option>
			        			 	<option value='${localFieldBean.is_Tran}' selected="selected">是</option>
			        			</c:if>
			        			<c:if test="${localFieldBean.is_Tran == 'N'}">
			        			    <option  value="Y">是</option>
			        			 	<option value='${localFieldBean.is_Tran}' selected="selected">否</option>
			        			</c:if>			        			
			        	    </c:if>		        	 	
			        		<c:if test="${localFieldBean.is_Tran == null}">
			        			<option  value="N">否</option>
								<option  value="Y">是</option>	
			        	    </c:if>													
				          </select>				           	
			        </td> 
		         </tr>
		         <tr>
			        <td>
			          <b>数据类型：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="data_Type" type='text'  value='${localFieldBean.data_Type}' />
			        </td> 
		         </tr>
		         <tr>
			        <td>
			          <b>正则表达式：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="regex" type='text' value='${localFieldBean.regex}' />
			        </td> 
		         </tr>	 
		         <tr>
		         	<td colspan="2" align="center">
		         		<c:if test="${localFieldBean.fields_Local_ID == null}">		         		
			         		<input type="button" class="btn1" onclick="javascript:submitField('0','add1')" value="&nbsp;保&nbsp;&nbsp;存&nbsp;"/>&nbsp;&nbsp;
			         		<input type="button" class="btn1" onclick="javascript:submitField('0','add2')" value="&nbsp;保&nbsp;存&nbsp;并&nbsp;继&nbsp;续&nbsp;"/>
		         		</c:if>
		         		<c:if test="${localFieldBean.fields_Local_ID != null}">
			         		<input type="button" class="btn1" onclick="javascript:submitField(${localFieldBean.fields_Local_ID},'update')" value="&nbsp;提&nbsp;&nbsp;交&nbsp;"/>
		         		</c:if>
		         		&nbsp;&nbsp;<input type="button" class="btn1" onclick="javascript:cancel()" value="&nbsp;取&nbsp;&nbsp;消&nbsp;"/>
		         	</td>
		         </tr>        
		      </table>		
		   </td> 
		  </tr>
		 </table>    	   
	    </div>	
