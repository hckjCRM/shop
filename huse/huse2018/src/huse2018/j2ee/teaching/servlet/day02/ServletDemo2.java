package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ServletDemo2 implements Servlet{
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("����demo2��ʼ������");
		this.config = config;
	}

	public ServletDemo2() {
		System.out.println("����demo2����������");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("����demo2��service����");		
		System.out.println(config.getInitParameter("username"));
		//���Ի�ȡServletDemo1�������ServletContext�����ֵ
		ServletContext sc = config.getServletContext();
		System.out.println(sc.getInitParameter("wife"));
		System.out.println(sc.getAttribute("�Ǻ�"));
	}

	@Override
	public String getServletInfo() {
		return null;
		
	}

	@Override
	public void destroy() {
		System.out.println("����demo2��destroy����");
	}

}
