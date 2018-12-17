package servlet;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("��Ϣչʾ��");
		Enumeration<String> emu = req.getHeaderNames();
		while(emu.hasMoreElements()){
			String headname=emu.nextElement();
			System.out.println("��Ϣͷ:"+headname+",��Ϣ:"+req.getHeader(headname));
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("����ķ�ʽ��"+req.getMethod());
		System.out.println("����Э��Ϊ��"+req.getProtocol());
		System.out.println("������Ϊ��"+req.getServletPath());
		System.out.println("����URIΪ��"+req.getRequestURI());
		System.out.println("����URLΪ��"+req.getRequestURL());
		System.out.println("-------------------------------------------------------");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("-------------------------------------------------------");
//		String hobby=req.getParameter("hobby");
		String[] hobbys=req.getParameterValues("hobby");
		System.out.println("hobby:"+Arrays.toString(hobbys));
		System.out.println("-------------------------------------------------------");
		Map<String,String[]> map=req.getParameterMap();
		Set<String> set=map.keySet();
		for (String s : set) {
			System.out.println(s+":"+Arrays.toString(map.get(s)));
		}
	}
}
