<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id="a" style="overflow-x:hidden; overflow-y:auto;width: 100%; height:525px">
		<div id="div11">
			<form name='form_lf' action='javascript:searchField();' method='post'>
			<table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:8px">
			  <tr bgcolor='#f8f8f8'>
			    <td align='center'>
			      <table border='0' cellpadding='0' cellspacing='0'>
			        <tr>
			        	<td width='70'>
				          <b>本地字段：</b>
				        </td>
				        <td width='160'>
				          	<input id="fieldNameIndex" value="${fieldnameIndex}"  name="fieldNameIndex" type='text' class="txt" style='width:150px' value='' />
				        </td> 
				        <td width='70'>
				          <b>字段描述：</b>
				        </td>
				        <td width='160'>
				          	<input id="fieldDescriptionIndex" value="${fieldDescriptionIndex}" name="fieldDescriptionIndex" type='text' class="txt" style='width:150px' value='' />
				        </td>     
				        <td>
				          <button type="button" class="btn1" onclick="javascript:searchField();">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
				        </td>   
				        <td>
				          <button type="button" class="btn1" onclick="javascript:addField();">添加</button>
				        </td>       
			       </tr>
			      </table>
			    </td>
			  </tr> 
			</table>
			</form>		
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
		</div>
		<div id="div12" align="center">
			<button type="button" class="btn1" onclick="javascript:addRef()"><b style="color:#6FC361">&nbsp;&nbsp;&nbsp;&nbsp;增&nbsp;&nbsp;加&nbsp;∨&nbsp;&nbsp;&nbsp;&nbsp;</b></button>&nbsp;&nbsp;
			<button type="button" class="btn1" onclick="javascript:refresh()"><b style="color:#6FC361">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刷&nbsp;&nbsp;&nbsp;新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></button>
		</div><br/>
		<div id="div13">
			<div class="div1">数据集字段表   </div>
			<div id="dataset_filed" style="width: 100%;">
  			<table class="tlist" id="filedRef">
  				<thead>
			      <tr class="title">
			        <th align="left">ID</th>
			        <th align="left">本地字段</th>
			        <th align="left">字段描述</th>
			        <th align="left">对应的全局字段</th>
			        <th align="left">是否转码</th>
			        <th align="left">数据类型</th>
			        <th align="left">正则表达式</th>
			        <th align="left">是否必填</th>	
			        <th align="left">操作</th>					              
			      </tr>  
				</thead>
				<tbody>
				  <c:forEach items="${DSLFlist1}" var="list" varStatus="status">		
					<tr id="tr${list.rel_Id}">         
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
					      	<select id="is_Req${list.rel_Id}" name='is_Req' style="width:50px">
				        	 	<c:if test="${list.is_Req != null}">
				        			<c:if test="${list.is_Req == 'Y'}">
				        			    <option  value="N">否</option>
				        			 	<option value='${list.is_Req}' selected="selected">是</option>
				        			</c:if>
				        			<c:if test="${list.is_Req == 'N'}">
				        			    <option  value="Y">是</option>
				        			 	<option value='${list.is_Req}' selected="selected">否</option>
				        			</c:if>			        			
				        	    </c:if>		        	 	
				        		<c:if test="${list.is_Req == null}">
				        			<option  value="N">否</option>
									<option  value="Y">是</option>	
				        	    </c:if>
				           </select>		
					      </td>  
					      <td class="operate">
					        <a href="javascript:void(0);" onClick="javascript:updateRef(${list.rel_Id},'is_Req${list.rel_Id}')">
							<img src="../images/accept.png" alt="提交" title="提交" border="0" /></a>&nbsp;&nbsp;
					      	<a href="javascript:void(0);" onclick="javascript:delRef(${list.rel_Id},'tr${list.rel_Id}')">
							<img src="../images/delete.gif" alt="删除" title="删除" border="0" /></a>
					      </td>   
						</tr>										
				  </c:forEach>
				</tbody>    
				<tfoot>    
				</tfoot>		  				
  			</table>
  		</div>
	</div>
  </div>	
