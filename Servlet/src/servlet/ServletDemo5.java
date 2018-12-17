package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/demo5.do")
public class ServletDemo5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("uname", "张三");
		req.getRequestDispatcher("/demo6.do").forward(req, resp);
//		req.getRequestDispatcher("login.html").forward(req, resp);
//		req.getRequestDispatcher("http://www.baidu.com").forward(req, resp); //不能转发
	}
}
