<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<!-- 数据集编辑表  -->
		<div align="center">			
		  <table>
		    <tr>
		     <td>		     
		      <table class="tlist">		        
		         <tr>
			        <td>
			          <b>数据集类型：</b>
			        </td>
			        <td align="left">
		        	 <select id="fields_Global_ID" name='is_tran' style='width: 130px'>   
		        	 	<c:forEach var="f_Fields_GlobalList" items="${f_Fields_GlobalList}">        	 		
			        		<c:if test="${f_Fields_GlobalList.fields_Global_ID == localFieldBean.fields_Global_ID}">
			        			<option value='${f_Fields_GlobalList.fields_Global_ID}' selected="selected">${f_Fields_GlobalList.fields_Global_ID}</option>
			        		</c:if>	
			        		<c:if test="${f_Fields_GlobalList.fields_Global_ID != localFieldBean.fields_Global_ID}">
			        			<option value='${f_Fields_GlobalList.fields_Global_ID}'>${f_Fields_GlobalList.fields_Global_ID}</option>        
			        		</c:if>			
			        	</c:forEach>    
			          </select>	    			        	
			        </td> 
		         </tr>
		         <tr>
			        <td>
			          <b>数据集名称：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="data_Type" type='text'  value='${localFieldBean.data_Type}' />
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
		         	<td colspan="2" align="center">
		         		<c:if test="${localFieldBean.fields_Local_ID == null}">		         		
			         		<input type="button" class="btn1" onclick="javascript:submit('0')" value="&nbsp;保&nbsp;&nbsp;存&nbsp;"/>
		         		</c:if>
		         		<c:if test="${localFieldBean.fields_Local_ID != null}">
			         		<input type="button" class="btn1" onclick="javascript:submit(${localFieldBean.fields_Local_ID})" value="&nbsp;提&nbsp;&nbsp;交&nbsp;"/>
		         		</c:if>
		         	</td>
		         </tr>        
		      </table>		
		   </td> 
		  </tr>
		 </table>    	   
	    </div>	
