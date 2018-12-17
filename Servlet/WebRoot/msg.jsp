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
	<form action="msg.action">
		<fieldset>
			<legend>评论</legend>
			请输入评论：<br>
			<textarea rows="10" cols="30" name="message"></textarea><br>
			<input type="submit" value="评论">
		</fieldset>
	</form>
  </body>
</html>