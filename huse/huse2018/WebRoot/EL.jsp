<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8" import="java.util.*,huse2018.j2ee.teaching.servlet.day02.work.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>EL表达式的使用</h1>
	<h1>----------------------------------------------------</h1>
	<h1>数学表达式</h1>
	JSP:1+1=<%=1+1 %><br>
	EL:1+1=${1+1}<br>
	JSP:1+"1.2"=<%=1+"1.2"%><br>
	EL:1+"2.2"=${1+"2.2"}<br>
	JSP:"1.1"+"2.2"=<%="1.1"+"2.2"%><br>
	EL:"1.1"+"2.2"=${"1.1"+"2.2"}<br>
	注意：EL中的+号运算，只能做数学运算，会把字符串转为对应的数字来进行运算<br>
	<%-- EL:"a"+"b"=${"a"+"b"}--%>
	注意：如果在EL中，你使用了两个字符串的相加的话，就会进行报错；<br>
	<%-- EL:'a'+'b'=${'a'+'b'}--%>
	注意：EL表达式不能使用两个字符之间的运算；<br>
	<h2>empty运算符</h2>
	<%
		ArrayList<User> list = new ArrayList<User>();
		User user = new User();
		/* user.setName("youge");
		user.setAge(12); */
		String str = null;
		String str1 = "";
		String str2 = "abc";
		request.setAttribute("user",user);
	 %>
	使用empty运算符来对一个只实例化了的集合：${empty list}<br>
	使用empty运算符来对一个值为null的对象：${empty str}<br>
	使用empty运算符来对一个值为空串的对象：${empty str1}<br>
	使用empty运算符来对一个只实例化了的对象：${empty user}<br>
	注意：如果要使用empty来进行判断某个变量是否为空的话，注意一定要将jsp中定义的变量绑定到四个内置对象中；
	<h1>条件表达式</h1>
	<h1>----------------------------------------------------</h1>
	<%session.setAttribute("aaa","aa"); %>
	EL:${1==1}<br>
	EL:${"ab" eq "ab"} <br>
	EL:${1 eq 1}<br>
	EL:${"aa" == aaa}<br>
	EL:${"aa" eq aaa}<br>
	注意：EL中的判断是否相等有两种方式，一个是传统的双等号，一个是eq这个关键字，但是需要注意的是，如果在判断语句中出现了
	一个类似于变量的字母的话，EL表达式会自动去JSP的四个包含范围的内置对象中去寻找是否具有这个变量，如果没找到，则无论怎么
	匹配都是false，如果找到，则拿到相对于的值来进行匹配，查找的顺序是从小到大；	
	<h1>获取请求参数</h1>
	<h1>----------------------------------------------------</h1>
	获取单一的请求参数：${param.username}<br>
	获取多个请求参数的第一个值：${paramValues.interest[0]}<br>
	获取多个请求参数的第二个值：${paramValues.interest[1]}<br>
	获取多个请求参数的对象：${paramValues.interest}<br>
	使用param来获取多个请求参数：${param.interest}<br>
	获取web.xml中的全局变量信息：${initParam.charset}<br>
	<h1>获取cookie对象以及cookie的值</h1>
	<h1>----------------------------------------------------</h1>
	获取cookie对象：${cookie}<br>
	获取cookie对象中的名称：${cookie.JSESSIONID.name}<br>
	获取cookie对象中的值：${cookie.JSESSIONID.value}<br>
	<h1>获取对象</h1>
	<h1>----------------------------------------------------</h1>	
	<%
	User u = new User();
		/* User u = new User("zhangsan",15,new String[]{"cooking","reading"},new IdCard(1001,"buildingBank"));
		 */request.setAttribute("u",u);
	 %>
	使用三种方式来获取对象：<br>
	JSP：<%=u %><br>
	EL:${u}<br>
	JSP:<%=request.getAttribute("u")%><br>
	注意：直接使用EL表达式来获取到四个内置对象中的绑定参数的话，一样是有顺序，从小到大，并且，我们可以指定范围<br>
	指定EL表达式在page中来获取u：${pageScope.u}<br>
	指定EL表达式在request中来获取u：${requestScope.u}<br>
	指定EL表达式在session中来获取u：${sessionScope.u}<br>
	指定EL表达式在application中来获取u：${applicationScope.u}<br>
	使用X种方式来获取对象中的值<br>
	<%-- JSP：<%=u.getAge() %><br> --%>
	EL(第一种):${u.name}<br>
	EL(第二种):${u["name"]}<br>
	<%-- JSP取数组对象：<%=u.getInterest() %><br>
	JSP取数组对象中的值：<%=u.getInterest()[0] %><br> --%>
	EL来取数组对象：${u.interest}<br>
	EL来取数组对象中的值：${u.interest[0]}<br>
	<%-- JSP取对象中的对象的值：<%=u.getIdCard().getBank()%><br> --%>
	EL来取对象中的对象的值：${u.idCard["bank"]}<br>
</body>
</html>