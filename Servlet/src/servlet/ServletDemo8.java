package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/demo8.do")
public class ServletDemo8 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("login.html");
		//resp.sendRedirect("demo5.do");
		//resp.sendRedirect("http://www.baidu.com");
		//req.setAttribute("uname", "张三");
		//resp.sendRedirect("/WEB-INF/sc/regist.html");//不在webroot下出不来
		
	}
}
