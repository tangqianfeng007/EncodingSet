<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div align="center">			
		  <table>
		    <tr>
		     <td>		     
		      <table class="tlist">
		      <tr>
		         	<td colspan="2" align="center" style='background-color:#d9e8f5'>
		         		<c:if test="${datasetBean.dataset_ID == null}">		         		
			         		<h2>数据集添加</h2>
		         		</c:if>
		         		<c:if test="${datasetBean.dataset_ID != null}">
			         		<h2>数据集编辑</h2>
		         		</c:if>
		         	</td>
		        </tr>   
		        <tr align="left" >
		        	 <td>
			          <b>数据集类型:</b>
			         </td>
			         <td>
			        	<select id="dataset_Type" name='dataset_Type' style='width: 130px'>
			        	 	<c:if test="${datasetBean.dataset_Type != null}">
			        			<c:if test="${datasetBean.dataset_Type == 'EHR'}">
			        			    <option  value="EHR" selected="selected">EHR</option> 
			        			    <option  value="EMR">EMR</option> 
			        			 	<option value='HI'>HI</option>
			        			</c:if>
			        			<c:if test="${datasetBean.dataset_Type == 'EMR'}">
			        			    <option  value="EHR">EHR</option> 
			        			    <option  value="EMR" selected="selected">EMR</option> 
			        			 	<option value='HI'>HI</option>
			        			</c:if>
			        			<c:if test="${datasetBean.dataset_Type == 'HI'}">
			        			    <option  value="EHR" >EHR</option> 
			        			    <option  value="EMR">EMR</option> 
			        			 	<option value='HI' selected="selected">HI</option>
			        			</c:if>	        			
			        	    </c:if>	
			        	    <c:if test="${datasetBean.dataset_Type == null}">
			        			 <option  value="EHR" >EHR</option> 
		        			    <option  value="EMR">EMR</option> 
		        			 	<option value='HI'>HI</option>
			        	    </c:if>	
			        	 </select>
			         </td>			      
			    </tr>
		         <tr>
			        <td>
			          <b>数据集名称：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="dataset_Name" type='text'  value='${datasetBean.dataset_Name}' />
			        </td> 
		         </tr>
			    <tr>
			        <td>
			          <b>数据集描述：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="dataset_Description" type='text'  style='width:300px' value='${datasetBean.dataset_Description}' />
			        </td> 
		         </tr>
		         <tr>
		         	<td colspan="2" align="center">
		         		<c:if test="${datasetBean.dataset_ID == null}">		         		
			         		<input type="button" class="btn1" onclick="javascript:submit('0')" value="&nbsp;保&nbsp;&nbsp;存&nbsp;"/>
		         		</c:if>
		         		<c:if test="${datasetBean.dataset_ID != null}">
			         		<input type="button" class="btn1" onclick="javascript:submit(${datasetBean.dataset_ID})" value="&nbsp;提&nbsp;&nbsp;交&nbsp;"/>
		         		</c:if>
		         		&nbsp;&nbsp;<input type="button" class="btn1" onclick="javascript:datasetCancel()" value="&nbsp;取&nbsp;&nbsp;消&nbsp;"/>
		         	</td>
		         </tr>        
		      </table>		
		   </td> 
		  </tr>
		 </table>    	   
	    </div>	
