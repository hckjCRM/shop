package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author ����
 * GenericServlet��������Servlet�ӿڵ�һ��ʵ���࣬��ʵ������������Servlet�ӿ�
 * ����ĳ��󷽷�֮�⣬����˶�ServletConfig��ServletContext��֧�֣������ǿ���ֱ��
 * ��ʹ������������
 *
 */
public class ServletDemo3 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println(this.getServletInfo());
		System.out.println(this.getInitParameter("kk"));
		System.out.println(this.getServletName());
		System.out.println(this.getServletContext().getInitParameter("wife"));
	}
}
