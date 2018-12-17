package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 汪洋
 * 1、HttpServlet这个类，除了拥有父类的所有方法之外，还提供了对HTTP协议的支持并且
 * 针对不同的请求进行了细分；
 * 2、我们的请求到达servlet之后，有可能进入到doget、dopost和service方法中，根据
 * 请求的方法名不同，进入到不同的doXX里面，但是一旦有了service方法，doXX的方法就不会
 * 执行，所以我们一向都是直接书写service方法即可，在该方法里面，会针对不同的情况来进行
 * 方法的转跳；
 *
 */
public class ServletDemo4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("调用DOGET");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("调用DOPost");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//当请求是get的时候，请求中的中文默认没问题，如果你们有问题，请参考day02，
		//tomcat8以后，乱码问题不再区分get和post请求，全部都是直接写以下两行就可以解决乱码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("调用Service");
		//测试乱码问题
		String username = req.getParameter("username");
		//如果你们的要乱码，记得加这句话来转码，因为tomcat的默认编码是ISO-8859-1
//		username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		System.out.println(username+","+password);
		pw.println(username+","+password);
	}
}
