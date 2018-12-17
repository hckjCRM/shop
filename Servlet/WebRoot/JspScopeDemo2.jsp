<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title></title>
  </head>
  <body>
	Application对象:<%=application.getAttribute("a") %><br>
	session对象:<%=session.getAttribute("b") %><br>
	request对象:<%=request.getAttribute("c") %><br>
	pageContext对象:<%=pageContext.getAttribute("d") %><br>
  </body>
</html>