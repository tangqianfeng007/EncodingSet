<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>编码映射管理</title>
	<link href="../css/main.css" rel="stylesheet" type="text/css" />
	<script src="../scripts/jquery-1.3.2.min.js" language="javascript" type="text/javascript"></script>	
	<script src="../scripts/map_list.js" language="javascript" type="text/javascript"></script>	
 </head>
<body>
<div class="mtitle">
  <h1>编码映射管理</h1>  
</div>
<!--  搜索表单  -->
<form name='form3' action='javascript:search();' method='post'>
<table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:8px">
  <tr bgcolor='#f8f8f8'>
    <td align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'><b>编&nbsp;码&nbsp;表：</b></td>
          <td width='160'>
          <select id="encodetable" name='encodetable' class="txt" style='width:150' onchange="search()">          
			<option  value="F_Global_BasicData">基础编码</option>
			<option  value="F_Global_Vaccine">疫苗编码</option>
			<option  value="F_Global_Drug">药物编码</option>
			<option  value="F_Global_Diagnosis">诊断编码</option>
			<option  value="F_Global_Dept">科室编码</option>
			<option  value="F_Global_Org">机构编码</option>
			<option  value="F_Global_Staff">员工编码</option>
			<option selected value="F_Global_Area">区域编码</option>
			<option  value="F_Global_Diseases">疾病编码</option>
          </select>
        </td>
         <td width='70'>
          <b>字段名称：</b>
        </td>
        <td width='160'>
          	<input id="encodenameIndex1" name="encodenameIndex1" type='text' class="txt" style='width:150px' value='' />
        </td>   
        <td width='70'>
          <b>编码名称：</b>
        </td>
        <td width='160'>
          	<input id="encodenameIndex2" name="encodenameIndex2" type='text' class="txt" style='width:150px' value='' />
        </td>     
        <td>
          <button type="button" class="btn1" onclick="javascript:search();">查询</button>&nbsp;&nbsp;
        </td>       
       </tr>
      </table>
    </td>
  </tr> 
</table>
</form>
<div id="map_list"></div>
</body>
</html>