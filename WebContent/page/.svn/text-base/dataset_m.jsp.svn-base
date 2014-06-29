<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../css/main.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="../css/SimpleTree.css"/>
		<script src="../scripts/jquery-1.3.2.min.js" language="javascript" type="text/javascript"></script>
		<script src="../scripts/dataset_m.js" language="javascript" type="text/javascript"></script>
		<script type="text/javascript" src="../scripts/SimpleTree.js"></script>
		<script type="text/javascript">	
			$(function(){
				$(".st_tree").SimpleTree({
					click:function(a){
						if(!$(a).attr("hasChild"))
							alert($(a).attr("ref"));
					}
				});
			});
		</script>
	</head>
	<body>
	<div id="dataset_m">	
		<div class="mtitle"><h1>数据集管理</h1></div>
     <div id="div1">
		<table width='100%' border='1' cellpadding='1' cellspacing='1' align="left" height="430px" class="tlist1" style="margin-top:8px;">
		  <tr bgcolor='#f8f8f8' height="30px">
		   	<td width="30%">
				<b>数据集</b>
			</td>
			<td width="70%">
				<b>数据集对应字段</b>
			</td>
		  </tr> 
		  <tr height="380px">
		  	<td style="width='30%'">
		  		<div id="dataset_tree"></div>  			
		  	</td>
		  	<td style="width='70%'">
		  		<div id="filed_local"></div>
		  	</td>
		  </tr>	
		  <tr>
				<td align="center">
					<input type="hidden" id="dataset_id"/>
			  		<input type="button" class="btn1" onclick="javascript:add()" value="添&nbsp;&nbsp;加"/>&nbsp;&nbsp;
			  		<input type="button" class="btn1" onclick="javascript:edit()" value="编&nbsp;&nbsp;辑"/>&nbsp;&nbsp;
			  		<input type="button" class="btn1" onclick="javascript:del()" value="删&nbsp;&nbsp;除"/>
			  	</td>
				<td align="center" colspan="5">
				   <input type="button" class="btn1" onclick="javascript:editDatasetFiled()" value="编辑字段"/>
				</td>  
		  </tr>	 
		</table>	
	 </div>
	 <div id="div2">
	 	<div id="dataset_edit"></div>	 
	 </div>
	 <div id="div3">
	 	<div id="datasetField_edit"></div>	 
	 </div>
	 <div id="div4">
	 	<div id="localFiled_edit"></div>	 
	 </div>
	</div>
	</body>
</html>