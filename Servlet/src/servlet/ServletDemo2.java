package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet {
	ServletConfig config;
	@Override
	public void destroy() {
		System.out.println("���õ���demo2�е�destroy������");		
	}

	public ServletDemo2() {
		System.out.println("���õ���demo2�еĹ��췽����");	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("���õ���demo2�еĳ�ʼ��������");
		this.config=config;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("���õ���demo2�е�sevice������");	
		System.out.println(config.getInitParameter("username"));
		ServletContext sc=config.getServletContext();
		System.out.println(sc.getInitParameter("hobby"));
		System.out.println(sc.getAttribute("hello"));
	}

}
