package huse2018.j2ee.teaching.servlet.day05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/count.do")
public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		Integer count = (Integer)session.getAttribute("count");
		if(count==null){
			count = 1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		pw.print("当前你登录了该网站"+session.getAttribute("count")+"次！");
		
	}
}
