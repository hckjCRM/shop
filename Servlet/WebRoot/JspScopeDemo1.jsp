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
	绑定一个Application对象<%application.setAttribute("a", "我是全局的"); %><br>
	绑定一个session对象<%session.setAttribute("b", "我是session"); %><br>
	绑定一个request对象<%request.setAttribute("c", "我是request"); %><br>
	绑定一个pageContext对象<%pageContext.setAttribute("d", "我是pageContext"); %><br>
	<!-- <a href="JspScopeDemo2.jsp">点击绑定</a> -->
	<jsp:forward page="JspScopeDemo2.jsp"></jsp:forward>
	<%-- <%pageContext.forward("JspScopeDemo2.jsp"); %> --%>
	
  </body>
</html>