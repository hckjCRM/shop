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
 * �ض���
 * 1���ض�������response������õķ�����
 * 2���ض���֮���ҳ���ַ����Ϣ�ᷢ���ı䣻
 * 3���ض����ǽ�����2������1����Ӧ��
 * 4���ض����ǲ��ܷ���WEB-INF��������ݵģ�
 * 5���ض�����Կ���Ŀ���з��ʣ�
 * 6���ض��򲻻�Я�����ݣ�
 *
 */
@WebServlet(value="/redirect.do")
public class ServletDemo8 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//����WEBROOT�����ҳ��
//		resp.sendRedirect("login.html");
		//����WEB-INF�����ҳ��
//		resp.sendRedirect("/WEB-INF/otherSafe/reg.html");
		//����������������ҳ�棬Ҳ��������������web��Ŀ�е�ҳ��
//		resp.sendRedirect("http://www.baidu.com");
		req.setAttribute("uname", "����");
		//�ض�����������б�ܣ��ͱ����û�й������ˣ����Ծ��������ͨ��ת����д�Ļ�����Ҫ��б��
		resp.sendRedirect("to.do");
	}
}
