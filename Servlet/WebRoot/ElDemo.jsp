<%@ page language="java" import="java.util.*,servletwork.User" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  	<hr>
	<h1>EL</h1>
	<hr>
	<%
	ArrayList<User> list=new ArrayList<User>();
	User u= new User();
	u.setUid(1001);
	u.setUsername("zhangsan");
	u.setPassword("123");
	list.add(u);
	User u1= new User();
	u1.setUid(1002);
	u1.setUsername("zhangsan");
	u1.setPassword("321");
	list.add(u1);
	User u2= new User();
	u2.setUid(1003);
	u2.setUsername("zhangsan");
	u2.setPassword("145");
	list.add(u2);
	request.setAttribute("list1", list);
	%>
	<hr>
	${list1}<br>
	${list1[0]}<br>
	${list1[2]}<br>
	${list1[1].username}<br>
	${list1[1]["username"]}<br>
	<hr>
	${param.age}<br>
	${paramValues.hobby[0]}<br>
	${paramValues.hobby[1]}<br>
	<hr>
	<h1>JSTL</h1>
	<hr>
	<c:if test="${param.age<18}" var="flag">
	<c:out value="你还太小了"></c:out>
	</c:if>
	<c:if test="${!flag}<">
	<c:out value="还是不行，因为太穷了"></c:out>
	</c:if>
  </body>
</html>