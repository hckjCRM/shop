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
		System.out.println("֮ǰ���͹����������ǣ�"+req.getAttribute("uname"));
		//�����ٴη���һ��������һ��servlet��������һ���ܲ����õ�������
		req.getRequestDispatcher("/to2.do").forward(req, resp);
	}
}
