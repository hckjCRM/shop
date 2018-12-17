package huse2018.j2ee.teaching.servlet.day04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/add.do")
public class AddCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		//获取到请求里面的cookie并且存在数组里面
		Cookie [] cookies = req.getCookies();
		//2.判断里面是否有内容
		if(cookies!=null){
			//3、遍历里面的内容
			for(Cookie c:cookies){
				System.out.println("name:"+c.getName()+"value:"+c.getValue());
			}
		}else{
			//4.如果没有内容，那么新建一个cookie
			Cookie ck =new Cookie("uname", "zhangsan");
			//5.把cookie加入到resp对象中
			resp.addCookie(ck);
			pw.println("cookie add successfull!");
		}
	}
}
