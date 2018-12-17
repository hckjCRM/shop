package huse2018.j2ee.teaching.servlet.day01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//request对象的作用之一：获取到请求方的信息
		//获取到消息头
		Enumeration<String> enu = req.getHeaderNames();
		while(enu.hasMoreElements()){
			String headname = enu.nextElement();
			System.out.println("消息头："+headname+",消息："+req.getHeader(headname));
		}
		System.out.println("-------------------------------------------------");
		System.out.println("请求方式为："+req.getMethod());
		System.out.println("请求协议为："+req.getProtocol());
		System.out.println("请求名为："+req.getServletPath());
		System.out.println("请求URI为："+req.getRequestURI());
		System.out.println("请求URL为："+req.getRequestURL());
		//request对象的作用之二：获取到页面输出的内容
		//信息类型为key-value的形式
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
		//信息类型为key-values的形式
//		String [] hobbys = req.getParameterValues("hobby");
//		System.out.println("hobby:"+Arrays.toString(hobbys));
		//信息类型是以key-values有多个的形式时（map的形式）
		Map<String, String[]> map = req.getParameterMap();
		Set<String> set = map.keySet();
		for (String s : set) {
			System.out.println(s+":"+Arrays.toString(map.get(s)));
		}
	}
}
