package huse2018.j2ee.teaching.servlet.day04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/delete.do")
public class deleteCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		Cookie [] cookies = req.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("uname")&&cookie.getValue().equals("ÕÅÈý"));
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}else{
			pw.print("no cookie!");
		}
	}
}
