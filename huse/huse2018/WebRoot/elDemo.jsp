<%-- <%@ page language="java" import="java.util.*,huse2018.j2ee.teaching.servlet.day02.work.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1>EL表达式</h1>
  	<hr>
  	<%
  		ArrayList<User> list = new ArrayList<User>();
  		User u = new User();
  		u.setUid(1001);
  		u.setUsername("zhangsan");
  		u.setPassword("123");
  		list.add(u);
  		User u1 = new User();
  		u1.setUid(1002);
  		u1.setUsername("lisi");
  		u1.setPassword("1234");
  		list.add(u1);
  		User u2 = new User();
  		u2.setUid(1003);
  		u2.setUsername("wangwu");
  		u2.setPassword("4321");
  		list.add(u2);
  		String str = "abc";
  		request.setAttribute("s", str);
  		request.setAttribute("list1", list);
  	 %>
  	 ${1 == "1" }<br>
  	 ${1 eq '1'}<br>
  	 ${"abc" eq s}<br>
  	 ${1+"123" }<br>
  	 ${"123"+"123" }<br>
  	 ${"abc"+"123" }<br>
  	 ${empty list1 }<br>
  	 ${empty u }<br>
  	 ${empty str }<br>
  	 <hr>
  	 JSP获取list:<%=request.getAttribute("list1") %><br>
  	 JSP获取list里面的第一个User对象:<%=((ArrayList<User>)request.getAttribute("list1")).get(0) %><br>
  	 EL获取list:${list1 }<br>
  	 EL获取list里面的第一个User对象:${list1[0] }<br>
  	 EL获取list里面的第一个User对象中的一个属性:${list1[0].username }<br>
  	 EL获取list里面的第一个User对象中的一个属性:${list1[0]["username"] }<br>
  	 <hr>
  	 ${param.age }<br>
  	 ${paramValues.hobby[1] }<br>
  	 ${initParam.wife }
  	 <hr>
  	 <h1>JSTL</h1>
  	 <hr>
  	 <c:if test="${param.age<18 }" var="flag">
  	 	<c:out value="你年龄还太小了，不能出去浪！"></c:out>
  	 </c:if>	
  	 <c:if test="${!flag }">
  	 	<c:out value="你还是不能出去浪，因为没钱！"></c:out>
  	 </c:if>
  	 <hr>
  	 <c:choose>
  	 	<c:when test="${param.age<=6 }">你还没断奶！</c:when>
  	 	<c:when test="${param.age<12&&param.age>6 }">你也就刚刚断奶</c:when>
  	 	<c:when test="${param.age<18&&param.age>=12 }">你要好好学习</c:when>
  	 	<c:when test="${param.age>=18&&param.age<28 }">你要好好工作</c:when>
  	 	<c:otherwise>我也不知道你该干嘛了</c:otherwise>
  	 </c:choose>
  	 <hr>
  	 <table>
  	 <c:forEach var="u" items="${list1 }" begin="1" end="1">
  	 	<tr>
  	 		<td>${u.uid }</td>
  	 		<td>${u.username }</td>
  	 		<td>${u.password }</td>
  	 	</tr>
  	 </c:forEach>
  	 </table>
  </body>
</html> --%>