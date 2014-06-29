<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

 	 <label><b>条件：</b></label><input id="screenIndex" type="text" >&nbsp;&nbsp;
     <input type="button"  onclick="javascript:screen()" value="&nbsp;筛&nbsp;&nbsp;选&nbsp;"/><br/><br/>	
	 <select id="fields_Global_ID" name='is_tran' style='width:300px'>   
	 	<c:forEach var="f_Fields_GlobalList" items="${f_Fields_GlobalList}">        	 		
	 		<c:if test="${f_Fields_GlobalList.fields_Global_ID == localFieldBean.fields_Global_ID}">
	 			<option value='${f_Fields_GlobalList.fields_Global_ID}' selected="selected">${f_Fields_GlobalList.fields_Global_ID}【${f_Fields_GlobalList.field_Name}】</option>
	 		</c:if>	
	 		<c:if test="${f_Fields_GlobalList.fields_Global_ID != localFieldBean.fields_Global_ID}">
	 			<option value='${f_Fields_GlobalList.fields_Global_ID}'>${f_Fields_GlobalList.fields_Global_ID}【${f_Fields_GlobalList.field_Name}】</option>        
	 		</c:if>			
 	    </c:forEach>    
    </select>
