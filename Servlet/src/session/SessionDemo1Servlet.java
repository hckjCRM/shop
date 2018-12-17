package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/session1.do")
public class SessionDemo1Servlet extends HttpServlet{
	/**
	 * 书写一个可以统计用户访问网站次数的案例
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		HttpSession session=req.getSession();
		Integer sum= (Integer) session.getAttribute("sum");
		if(sum==null){
			sum=1;
		}else{
			sum++;
		}
		session.setAttribute("sum", sum);
		pw.write("访问次数为："+sum);
		System.out.println("访问次数为："+sum);
	}
}
