package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/to.do")
public class ServletDemo6 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("之前发送过来的数据是："+req.getAttribute("uname"));
		//尝试再次发送一次请求到下一个servlet，看看下一个能不能拿到该数据
		req.getRequestDispatcher("/to2.do").forward(req, resp);
	}
}
