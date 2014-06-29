
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>
      区卫前置机基础数据管理系统
    </title>
    <script src="scripts/jquery-1.4.2.min.js" language="javascript" type="text/javascript">
    </script>
    <script type="text/javascript">
      function check(){
        var role = document.getElementById("role");
        var password = document.getElementById("userPW");
        var message = document.getElementById("message");
        if(password.value == ""){
          message.innerHTML="提示信息：密码不能为空！";
          password.focus();
          return false;
        }
        return true;
      }
    </script>
    <style type="text/css">
      body{ background:url(images/login.jpg) repeat-x center top;} b{color: #60C0F0;} tr{line-height: 35px;}
      .text1{height: 25px; width: 150px;} #submit_btn {
      background-color:#72C6EF;border:none;border-radius:10px;box-shadow:0 0 3px #aaa;
      width:150px;height:30px;line-height:41px;color:#fff;font-size:18px;font-weight:bold;
      cursor:pointer;margin-right:20px;display:block;outline:none;text-shadow:0 1px 1px #777;} #submit_btn:hover
      {background-color:#4797ED;color:#0C62A9;text-shadow:1px 1px 1px #fff;}
    </style>
  </head>
  <body>
    <div align="center" style="margin-top: 300px;">
      <form name="login" action="/EncodingSet/login/loginCheck.action" method="post" onsubmit="return check();" >
        <table border='0px' align="center" width="300px">
          <tr>
            <td align="right">
              <b>
                用&nbsp;&nbsp;户：
              </b>
            </td>
            <td align="left">
              <select id="role" name='role' style="font-size: 14px; font-weight:bold; height: 25px; width: 150px;">
                <option  value="Administrators">
                  管理人员
                </option>
                <option  value="ImplementUser">
                  实施人员
                </option>
              </select>
            </td>
          </tr>
          <tr>
            <td align="right">
              <b>
                密&nbsp;&nbsp;码：
              </b>
            </td>
            <td align="left">
              <input type="password" id="userPW" name="userPW" class="text1">
            </input>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" id="submit_btn" name="" value="登&nbsp;&nbsp;录"/>
          </td>
        </tr>
      </table>
    </form>
  </div>
  <div id="message" style="color: red;text-align: center;font-weight: bold">
    ${message}
  </div>
</body>
</html>
<%request.removeAttribute("message");%>

