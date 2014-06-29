<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	 	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>区卫前置机基础数据管理系统</title>
		<script src="scripts/jquery-1.3.2.min.js" language="javascript" type="text/javascript"></script>
		<script src="scripts/frame.js" language="javascript" type="text/javascript"></script>
		<link href="css/frame.css" rel="stylesheet" type="text/css" />
	</head>  
	
	<%
		String user = (String) session.getAttribute("user");		
		if(user == null || "Administrators".equals(user))
			response.sendRedirect("../index.jsp");
	%>
	<body class="showmenu">
		<div class="pagemask"></div>
		<iframe class="iframemask"></iframe>
		<div class="head">
		<div class="top_logo"> <img src="images/logo3.gif"  alt="Logo" /> </div>
		    <div class="top_link">
		      <ul>
		      	<li class="welcome" style="color: blue">欢迎你${user}！</li>
				<li class="menuact"><a href="javascript:void(0);" id="togglemenu">隐藏菜单</a></li>
				<li><a href="./login/logout.action" target="_top">[退出]</a></li>
		      </ul>   
		    </div>
		    <div class="nav" id="nav">
		      <ul>
	              <li><a class="thisclass" href="page/map_list.jsp" _for="common" target="main">编码映射管理</a></li>
		      </ul>
		    </div>
		</div><!-- header end -->
		<div class="left">
			<div class="menu" id="menu">
				<div id="items_common">
					<dl id="dl_items_1_1">
						<dt>编码映射管理</dt>
						<dd>
							<ul>
								<li><a href="page/map_list.jsp" target="main">编码映射管理</a></li>
							</ul>
						</dd>
					</dl>
				</div><!-- Item End -->				
			</div>
		</div><!-- left end -->		
		<div class="right" style="height:100%;">
		  <div class="main">
		    <iframe id="main" name="main" style="overflow:scroll" frameborder="0" src="page/map_list.jsp"></iframe>
		  </div>
		</div><!-- right end -->			
	</body>
</html>
