<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/main.css" rel="stylesheet" type="text/css" />
	<script src="../scripts/jquery-1.3.2.min.js" language="javascript" type="text/javascript"></script>
	<script src="../scripts/info_m.js" language="javascript" type="text/javascript"></script>
	</head>
	<body>
		<!-- 密码修改  -->
		<div align="center" >			
		  <table>
		    <tr>
		     <td>		     
		      <table class="tlist" >
		      	<tr style='background-color:#d9e8f5'>
		         	<td colspan="2" align="center" style='width:400px'>		         		
			         	<h2>密码修改</h2>		         	
		         	</td>
		        </tr>   
		        <tr>
		        	 <td align="right">
			          <b>原密码：</b>
			        </td>
			        <td align="left">
			          	<input id="oldPW" type='password'  />
			        </td> 
			    </tr>
			    <tr>
			        <td align="right">
			          <b>新密码：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="newPW" type='password' />
			        </td> 
		         </tr>		       
		         <tr>
			        <td align="right">
			          <b>确认密码：</b>
			        </td>
			        <td align="left">		        	
			          	<input id="rnewPW" type='password' />
			        </td> 
		         </tr>	 
		         <tr>
		         	<td colspan="2" align="center">
		         		<input type="button" class="btn1" onclick="javascript:save('${user}')" value="&nbsp;保&nbsp;&nbsp;存&nbsp;"/>&nbsp;&nbsp;
		         		<input type="button" class="btn1" onclick="javascript:cancel()" value="&nbsp;取&nbsp;&nbsp;消&nbsp;"/>
		         	</td>
		         </tr>        
		      </table>		
		   </td> 
		  </tr>
		 </table>    	   
	    </div>	
	</body>
</html>