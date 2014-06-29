<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  		<div id="dataset_filed" style="overflow-x:hidden; overflow-y:auto;height:400px">
  			<div><b style="font-size:16px ;color:#03427A; background-color:#d9e8f5 ">${name}->${description}:</b></div>
  			<table class="tlist">
  				<thead>
			      <tr class="title">
			        <th align="left" >ID</th>
			        <th align="left" width="100px">本地字段</th>
			        <th align="left" width="150px">字段描述</th>
			        <th align="left">对应的全局字段</th>
			        <th align="left">是否转码</th>
			        <th align="left">数据类型</th>
			        <th align="left">正则表达式</th>
			        <th align="left">是否必填</th>					              
			      </tr>  
				</thead>
				<tbody>
				  <c:forEach items="${DSLFlist}" var="list" varStatus="status">		
					<tr>         
					      <td>${status.count}</td>
						  <td>${list.field_Name}</td>
					      <td>${list.field_Description}</td>
					      <td>${list.fields_Global_ID}</td>
					      <td>
					      	<c:if test="${list.is_Tran == 'Y'}">是</c:if>
					     	<c:if test="${list.is_Tran == 'N'}">否</c:if>
					      </td>
					      <td>${list.data_Type}</td>
					      <td>${list.regex}</td>
					      <td>
					      	<c:if test="${list.is_Req == 'Y'}">是</c:if>
					     	<c:if test="${list.is_Req == 'N'}">否</c:if>
					      </td>     
						</tr>
				  </c:forEach>
				</tbody>    
				<tfoot>    
				</tfoot>		  				
  			</table>
  		</div>
