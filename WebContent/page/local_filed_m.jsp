<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/main.css" rel="stylesheet" type="text/css" />
	<script src="../scripts/jquery-1.3.2.min.js" language="javascript" type="text/javascript"></script>
	<script src="../scripts/local_filed_m.js" language="javascript" type="text/javascript"></script>
	</head>
	<body>
		<div class="mtitle"><h1>本地字段管理</h1></div>
		<!--  搜索表单  -->
		<div id="form_div1"">
		<form name='form_lf' action='javascript:search();' method='post'>
		<table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:8px">
		  <tr bgcolor='#f8f8f8'>
		    <td align='center'>
		      <table border='0' cellpadding='0' cellspacing='0'>
		        <tr>
		        	<td width='70'>
			          <b>本地字段：</b>
			        </td>
			        <td width='160'>
			          	<input id="fieldNameIndex" name="fieldNameIndex" type='text' class="txt" style='width:150px' value='' />
			        </td>  
			        <td width='70'>
			          <b>字段描述：</b>
			        </td>
			        <td width='160'>
			          	<input id="fieldDescriptionIndex" name="fieldDescriptionIndex" type='text' class="txt" style='width:150px' value='' />
			        </td>     
			        <td>
			          <button type="button" class="btn1" onclick="javascript:search();">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
			        </td>   
			        <td>
			          <button type="button" class="btn1" onclick="javascript:add();">添加</button>
			        </td>       
		       </tr>
		      </table>
		    </td>
		  </tr> 
		</table>
		</form>		
		<div id="local_filed_list"></div>
	</div>
	<div id="form_div2">
		<div id="local_filed_editlist"></div>
	</div>
	</body>
</html>