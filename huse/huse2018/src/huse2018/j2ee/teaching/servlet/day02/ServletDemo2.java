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
		System.out.println("调用demo2初始化方法");
		this.config = config;
	}

	public ServletDemo2() {
		System.out.println("调用demo2构造器方法");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("调用demo2的service方法");		
		System.out.println(config.getInitParameter("username"));
		//尝试获取ServletDemo1里面绑定在ServletContext里面的值
		ServletContext sc = config.getServletContext();
		System.out.println(sc.getInitParameter("wife"));
		System.out.println(sc.getAttribute("呵呵"));
	}

	@Override
	public String getServletInfo() {
		return null;
		
	}

	@Override
	public void destroy() {
		System.out.println("调用demo2的destroy方法");
	}

}
