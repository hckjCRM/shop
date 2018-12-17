package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author ����
 * ת��
 * 1��ת����ʱ��request����������ǿ���Я������һ��ҳ��ģ�
 * 2��request��������ݵ���Ч��Ϊһ���������������Ӧ��
 * 3�����ͨ��ת��������WEB-INF�������˽ҳ��
 * 4��ת��ֻ�ܷ��ʵ�ǰ�������������
 *
 */
@WebServlet(urlPatterns="/from.do")
public class ServletDemo5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����ݰ���request����
		req.setAttribute("uname", "zhangsan");
		//ת�������ݵ���һ��servlet��
//		req.getRequestDispatcher("/to.do").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/otherSafe/reg.html").forward(req, resp);
		req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		//������͵���ҳ�棬��ô����Ҫ�����������飬ҳ�����Request����ֱ��getAttribute����
	}
}
