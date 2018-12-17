package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author ����
 * 1��HttpServlet����࣬����ӵ�и�������з���֮�⣬���ṩ�˶�HTTPЭ���֧�ֲ���
 * ��Բ�ͬ�����������ϸ�֣�
 * 2�����ǵ����󵽴�servlet֮���п��ܽ��뵽doget��dopost��service�����У�����
 * ����ķ�������ͬ�����뵽��ͬ��doXX���棬����һ������service������doXX�ķ����Ͳ���
 * ִ�У���������һ����ֱ����дservice�������ɣ��ڸ÷������棬����Բ�ͬ�����������
 * ������ת����
 *
 */
public class ServletDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����DOGET");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����DOPost");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��������get��ʱ�������е�����Ĭ��û���⣬������������⣬��ο�day02��
		//tomcat8�Ժ��������ⲻ������get��post����ȫ������ֱ��д�������оͿ��Խ����������
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("����Service");
		//������������
		String username = req.getParameter("username");
		//������ǵ�Ҫ���룬�ǵü���仰��ת�룬��Ϊtomcat��Ĭ�ϱ�����ISO-8859-1
//		username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		System.out.println(username+","+password);
		pw.println(username+","+password);
	}
}
