<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

  <div class="div1">编码映射表   </div>
   <div >
	<table id="listTable" class="tlist">
	    <thead>
	      <tr class="title">
	        <th align="left" style="width:30px">ID</th>
	        <th align="left" >字段名称</th>
	        <th align="left" style="width:250px" >编码名称</th>
	        <th align="left" style="width:250px">编码描述</th>
	        <th align="left" >系统编码</th>
	        <th align="left" >本地编码</th>        
	        <th align="left" style="width:85px">操作</th>
	      </tr>  
	</thead>
	<tbody>
	  <c:forEach items="${list}" var="list" varStatus="status">		
		<tr>  		 
	      <td>${status.count}</td>
	      <td>${list.field_Name}</td>
		  <td>${list.code_Name}</td>
	      <td>${list.description}</td>
	      <td>
	      	${list.code_Val_System}
	      	<c:if test="${list.code_Val_Local == null}">	      		
	      		<a  href="javascript:void(0);" onClick="copyF('${list.code_Val_System}','trId${status.count}')"><img src="../images/R.gif" align="right" alt="复制" title="复制" border="0"/></a>
	      	</c:if>	     	
	      </td>
	      <td width="130px">
      		<input id="trId${status.count}" type="text" value="${list.code_Val_Local}"></input>
	      	<input id="oldValue${status.count}" type="hidden" value="${list.code_Val_Local}"/>
	      </td>	       
	      <td class="operate">
	      	<c:if test='${list.myIndex != null}'>
	      		<a href="javascript:void(0);" onClick="javascript:savaOrUpdate('trId${status.count}','oldValue${status.count}','${list.myIndex}','${list.code_mark}','update')">
				<img src="../images/accept.png" alt="提交" title="提交" border="0" /></a>&nbsp;&nbsp;
	        </c:if> 
	        <c:if test='${list.myIndex == null}'>
	      		<a href="javascript:void(0);" onClick="javascript:savaOrUpdate('trId${status.count}','oldValue${status.count}','null','${list.code_mark}','add1')">
				<img src="../images/accept.png" alt="提交" title="提交" border="0" /></a>&nbsp;&nbsp;
	        </c:if>    	
	        <c:if test='${list.myIndex != null}'>      		          
			<a href="javascript:void(0);" onclick="javascript:del('oldValue${status.count}','${list.code_mark}')">
				<img src="../images/delete.gif" alt="删除" title="删除" border="0" /></a>&nbsp;&nbsp;
			</c:if>
			<c:if test='${list.myIndex != null}'>
				<a href="javascript:void(0);" onclick="javascript:savaOrUpdate('trId${status.count}','oldValue${status.count}','null','${list.code_mark}','add2')">
				<img src="../images/add.gif" alt="添加" title="添加" border="0" /></a>
			</c:if>			
		  </td>
		</tr>
	</c:forEach>		
	</tbody>    
	<tfoot>    
	</tfoot>
	</table>	
	</div>
	<div class="pagelist">
		${page}
	</div>