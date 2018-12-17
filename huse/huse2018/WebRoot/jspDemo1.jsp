<%@ page language="java" import="java.util.*,huse2018.j2ee.teaching.servlet.day02.work.EMP" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
	<% Date date = new Date(); %>
	<%=date %><br>
	<%for(int i = 0;i<5;i++){%>
	<%=i %>
	<%} %>
	<br>
	<%!public int add(int a,int b){return a+b;} %>
	<%=add(10,20) %>
	<%EMP e = new EMP(); %>
	<%=e %>
  </body>
</html>