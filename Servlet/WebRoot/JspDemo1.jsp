<%@ page language="java" import="java.util.*,servletwork.EMP" pageEncoding="UTF-8"%>
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
	<% Date date=new Date(); %>
	<%=date %><br>
	<%for(int i=1;i<8;i++){ %>
	<%=i %>
	<br>
	<%} %>
	<br>
	<%! public int add(int a,int b){return a*b;} %>
	<%int a=6; %>
	<%int b=12; %>
	<%="a*b=" %>
	<%=add(a,b) %>
	<br>
	<%="6*12=" %>
	<%=add(6,12) %>
	<br>
	<%EMP emp=new EMP(); %>
	<%=emp %>
  </body>
</html>