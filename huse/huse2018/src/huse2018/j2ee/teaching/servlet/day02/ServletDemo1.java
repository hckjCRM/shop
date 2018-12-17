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
 * @author 汪洋
 * 1、servlet对象的第二种创建方式，实现servlet接口；
 * 2、servlet的运行周期
 * 3、servlet对象创建的两个不同的时间，以及如何让servlet对象随着容器一起来创建；
 * 4、ServletConfig在实现servlet接口的时候，如何获取；
 * 5、如何定义一个属于一个servlet的配置文件；
 * 6、如何通过ServletConfig来获取到该servlet的配置文件；
 * 7、servlet的运行机制
 *
 */
public class ServletDemo1 implements Servlet{
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("调用初始化方法");
		this.config = config;
	}

	public ServletDemo1() {
		System.out.println("调用构造器方法");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("调用service方法");		
		//取指定的一个配置信息
		System.out.println(config.getInitParameter("username"));
		//把该servlet下面的所有init配置信息都拿到
		Enumeration<String> enu = config.getInitParameterNames();
		while(enu.hasMoreElements()){
			String name = enu.nextElement();
			System.out.println(name+","+config.getInitParameter(name));
		}
		ServletContext sc = config.getServletContext();
		//ServletContext的作用之一：获取到全局的配置信息值
		System.out.println(sc.getInitParameter("wife"));
		//ServletContext的作用之二：绑定参数
		sc.setAttribute("呵呵", "哈哈");
	}

	@Override
	public String getServletInfo() {
		return null;
		
	}

	@Override
	public void destroy() {
		System.out.println("调用destroy方法");
	}

}
