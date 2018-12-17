package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 汪洋
 * GenericServlet抽象类是Servlet接口的一个实现类，该实现类除了完成了Servlet接口
 * 里面的抽象方法之外，多出了对ServletConfig和ServletContext的支持，即我们可以直接
 * 来使用这两个对象
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
