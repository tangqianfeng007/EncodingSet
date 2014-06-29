<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
			
		<div id="local_filed_list">
				<div class="div1">本地字段表   </div>
				<table id="listTable" class="tlist" >
				    <thead>
				      <tr class="title">
				        <th align="left" width="50px"><input type="checkbox" id="all" value="全选" onclick="check()"/>全选</th>
				        <th align="left" width="120px">本地字段</th>
				        <th align="left" width="250px">字段描述</th>
				        <th align="left" width="100px">对应全局字段</th>
				        <th align="left" width="100px">是否转码</th>   
				        <th align="left" width="100px">数据类型</th>
				        <th align="left" width="100px">正则表达式</th>          
				        <th align="left" width="100px">操作</th>
				      </tr>  
				</thead>
				<tbody>
				  <c:forEach items="${FLList}" var="list" varStatus="status">		
					<tr>         
				      <td><input type="checkbox" name="filed" value="${list.fields_Local_ID}" onclick="check2()"/></td>
					  <td>${list.field_Name}</td>
				      <td>${list.field_Description}</td>
				      <td>${list.fields_Global_ID}</td>
				      <td>
				      	<c:if test="${list.is_Tran == 'Y'}">是</c:if>
				     	<c:if test="${list.is_Tran == 'N'}">否</c:if>
				      </td>
				      <td>${list.data_Type}</td>
				      <td>${list.regex}</td>     
				      <td class="operate">
							<a href="javascript:void(0);" onClick="javascript:editField(${list.fields_Local_ID})">
							<img src="../images/edit1.png" alt="编辑" title="编辑" border="0" /></a>&nbsp;&nbsp;
							<a href="javascript:void(0);" onclick="javascript:delField(${list.fields_Local_ID})">
							<img src="../images/delete.gif" alt="删除" title="删除" border="0" /></a>
					  </td>
					</tr>
				</c:forEach>		
				</tbody>    
				<tfoot>    
				</tfoot>
				</table>	
				<div class="pagelist">
					${page}
				</div>			
			</div>
