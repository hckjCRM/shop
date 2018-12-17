package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet {
	ServletConfig config;
	@Override
	public void destroy() {
		System.out.println("调用的是demo1中的destroy方法！");
	}
	
	
	public ServletDemo1() {
		System.out.println("调用的是demo1中的构造方法！");
	}


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
		System.out.println("调用的是demo1中的初始化方法！");
		this.config=config;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("调用的是demo1中的sevice方法！");
		System.out.println(config.getInitParameter("username"));
		Enumeration<String> enu=config.getInitParameterNames();
		while (enu.hasMoreElements()) {
			String name=  enu.nextElement();
			System.out.println(name+","+config.getInitParameter(name));
		}
		ServletContext sc=config.getServletContext();
		System.out.println(sc.getInitParameter("hobby"));
		sc.setAttribute("hello", "word");
	}

}
