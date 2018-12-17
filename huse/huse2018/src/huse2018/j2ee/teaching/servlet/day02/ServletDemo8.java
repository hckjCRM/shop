package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 汪洋
 * 重定向
 * 1、重定向是由response对象调用的方法；
 * 2、重定向之后的页面地址栏信息会发生改变；
 * 3、重定向是进行了2次请求1次响应；
 * 4、重定向是不能访问WEB-INF下面的内容的；
 * 5、重定向可以跨项目进行访问；
 * 6、重定向不会携带数据；
 *
 */
@WebServlet(value="/redirect.do")
public class ServletDemo8 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//访问WEBROOT下面的页面
//		resp.sendRedirect("login.html");
		//访问WEB-INF下面的页面
//		resp.sendRedirect("/WEB-INF/otherSafe/reg.html");
		//访问其他服务器的页面，也可以跳到其他的web项目中的页面
//		resp.sendRedirect("http://www.baidu.com");
		req.setAttribute("uname", "张三");
		//重定向如果你打了斜杠，就变成了没有工程名了，所以具体的请求通过转发来写的话，不要打斜杠
		resp.sendRedirect("to.do");
	}
}
