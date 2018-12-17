package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/add.do")
public class AddCookie  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies=req.getCookies();
		PrintWriter pw=resp.getWriter();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				System.out.println("name:"+cookie.getName()+",value:"+cookie.getValue());
			}
		}else{
			Cookie cook=new Cookie("uname", "ÕÅÈý"); 
			cook.setMaxAge(50);
			pw.write("add seccesfull!");
			resp.addCookie(cook);
		}
	}
}
