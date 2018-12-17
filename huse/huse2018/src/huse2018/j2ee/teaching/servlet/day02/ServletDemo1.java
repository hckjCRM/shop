package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author ����
 * 1��servlet����ĵڶ��ִ�����ʽ��ʵ��servlet�ӿڣ�
 * 2��servlet����������
 * 3��servlet���󴴽���������ͬ��ʱ�䣬�Լ������servlet������������һ����������
 * 4��ServletConfig��ʵ��servlet�ӿڵ�ʱ����λ�ȡ��
 * 5����ζ���һ������һ��servlet�������ļ���
 * 6�����ͨ��ServletConfig����ȡ����servlet�������ļ���
 * 7��servlet�����л���
 *
 */
public class ServletDemo1 implements Servlet{
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("���ó�ʼ������");
		this.config = config;
	}

	public ServletDemo1() {
		System.out.println("���ù���������");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("����service����");		
		//ȡָ����һ��������Ϣ
		System.out.println(config.getInitParameter("username"));
		//�Ѹ�servlet���������init������Ϣ���õ�
		Enumeration<String> enu = config.getInitParameterNames();
		while(enu.hasMoreElements()){
			String name = enu.nextElement();
			System.out.println(name+","+config.getInitParameter(name));
		}
		ServletContext sc = config.getServletContext();
		//ServletContext������֮һ����ȡ��ȫ�ֵ�������Ϣֵ
		System.out.println(sc.getInitParameter("wife"));
		//ServletContext������֮�����󶨲���
		sc.setAttribute("�Ǻ�", "����");
	}

	@Override
	public String getServletInfo() {
		return null;
		
	}

	@Override
	public void destroy() {
		System.out.println("����destroy����");
	}

}
