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
		System.out.println("调用的是demo2中的destroy方法！");		
	}

	public ServletDemo2() {
		System.out.println("调用的是demo2中的构造方法！");	}

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
		System.out.println("调用的是demo2中的初始化方法！");
		this.config=config;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("调用的是demo2中的sevice方法！");	
		System.out.println(config.getInitParameter("username"));
		ServletContext sc=config.getServletContext();
		System.out.println(sc.getInitParameter("hobby"));
		System.out.println(sc.getAttribute("hello"));
	}

}
