<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8" import="java.util.*,huse2018.j2ee.teaching.servlet.day02.work.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>JSTL的使用</h1>
	<h2>set标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	使用内置对象来塞值：<%request.setAttribute("name","haoren"); %><br>
	使用JSTL来塞值①：<c:set value="huairen" var="name" scope="request"/><br>
	使用JSTL来塞值②：<c:set var="name" scope="request">youge</c:set><br>
	获取request中绑定的参数：${requestScope.name}<br>

	<h2>remove标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	使用内置对象来删除绑定的参数：<%request.removeAttribute("name"); %><br>
	查看request中绑定的参数是否被删除：${requestScope.name}<br>
	使用JSTL来删除绑定的参数：<c:remove var="name" scope="request"/><br>
	查看request中绑定的参数是否被删除：${requestScope.name}<br>
	<h2>out标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	使用out标签来输出EL表达式：<c:out value="${name}"></c:out><br>
	注意：因为以前的EL表达式是不具备输出功能的，所以需要使用out标签来进行输出EL表达式，但是现在EL表达式已经具有了
		 输出的功能，所以这个out标签就不怎么使用了；
	<h2>url标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	先来绑定一个参数到session中：<c:set scope="session" var="charset">utf-8</c:set><br>
	通过URL标签来实现转跳功能：<a href="<c:url value='JSTL02.jsp'/>">我跳</a><br>
	注意：url标签的使用可以无视浏览器的cookie是否被禁止，如果你没有禁止cookie，那么url标签将不会起太大的作用，只是
		 让value的值生效而已，如果你禁止掉cookie的话，那么页面被浏览器解析之后，就会自动的检测浏览器是否禁止了cookie
		 ，如果禁止了，就会自动在你需要转跳的地址后面加上jsessionid=xxxxxxxx；
	<h2>redirect标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	<c:redirect url="JSTL02.jsp"></c:redirect>
	注意：redirect标签就是不需要你进行任何操作就对你写明的url地址进行转跳，并且它也是无视客户端是否禁止cookie的
	<h2>import标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	使用import标签：<c:import url="JSTL02.jsp"></c:import>
	*********************看看我在不在************************************************
	注意：import标签使用的话，跟jsp中的include很类似，但是我们需要进入tomcat的安装目录的work文件夹内找到与之对应的
		 java代码，可以区分开import标签和jsp的include指令以及jsp的include动作的区别所在；
	<h2>if标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	*****************如果年龄小于22岁，则提示回家吃饭，否则提示，可以结婚了**************************<br>
	<c:if test="${param.age<22}" var="flag" scope="request">
		回家吃饭吧！！！
	</c:if>
	<c:if test="${!flag}">
		结婚去吧！
	</c:if>
	注意：test属性代表的是相当于java中条件判断语句，通常我们都在里面直接书写EL表达式，var属性代表的是test里面的内容
		 所指向的变量，scope表示这个变量所绑定的范围，可以不写，默认为page；
	<h2>chiose标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	<c:choose>
		<c:when test="${param.age<18}">要听妈妈的话</c:when>
		<c:when test="${param.age>=18&&param.age<30}">找工作，找老婆</c:when>
		<c:when test="${param.age>=30&&param.age<50}">当爸爸，搞外遇</c:when>
		<c:when test="${param.age>=50&&param.age<70}">准备安乐死</c:when>
		<c:otherwise>房子产权70到期，住大马路去吧</c:otherwise>
	</c:choose>
	<h2>foreach标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	<%
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("zhangsan","111"));
		list.add(new User("lisi","222"));
		list.add(new User("wangwu","333"));
		list.add(new User("zhaoliu","444"));
		list.add(new User("youge","555"));
		request.setAttribute("list",list);
	 %>
	 ************遍历全部*****************<br>
	 <c:forEach var="u" items="${list}" varStatus="x">
		序号：${x.index}
	 	次数：${x.count}
	 	name:${u.uname}
	 	pwd:${u.pwd }<br>
	 </c:forEach>
	 注意：var代表的是这个集合中的元素所对应的变量，items代表的是获取到整个集合对象；<br>
	 ************遍历部分*****************<br>
	 <c:forEach var="u" items="${list}" begin="2" end="4" step="2" >
	 	
	 	name:${u.uname}
	 	pwd:${u.pwd }<br>
	 </c:forEach>
	 注意：使用begin和end属性可以定义出这个集合遍历的元素从哪个开始，到哪个为止，值代表的是下标！！！
	 	  step代表的是这个集合遍历的步伐，相当于for循环中的i的自增数量；
	<h2>catch标签的使用</h2>
	<h1>---------------------------------------------------</h1>
	<c:catch var="msg">
		<%Integer.parseInt("abc123");%>
	</c:catch>
	${msg}
</body>
</html> --%>