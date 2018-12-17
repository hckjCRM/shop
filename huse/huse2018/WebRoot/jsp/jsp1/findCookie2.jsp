<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  </head>
  <body>
  <%
  	Cookie [] c = request.getCookies();
  	for(Cookie ck:c){  	
   %>
   <%="name:"+ck.getName()+",value"+ck.getValue() %>
   <%} %>
  </body>
</html>
