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
		//��ȡ�����������cookie���Ҵ�����������
		Cookie [] cookies = req.getCookies();
		//2.�ж������Ƿ�������
		if(cookies!=null){
			//3���������������
			for(Cookie c:cookies){
				System.out.println("name:"+c.getName()+"value:"+c.getValue());
			}
		}else{
			//4.���û�����ݣ���ô�½�һ��cookie
			Cookie ck =new Cookie("uname", "zhangsan");
			//5.��cookie���뵽resp������
			resp.addCookie(ck);
			pw.println("cookie add successfull!");
		}
	}
}
