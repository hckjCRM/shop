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
		//request���������֮һ����ȡ�����󷽵���Ϣ
		//��ȡ����Ϣͷ
		Enumeration<String> enu = req.getHeaderNames();
		while(enu.hasMoreElements()){
			String headname = enu.nextElement();
			System.out.println("��Ϣͷ��"+headname+",��Ϣ��"+req.getHeader(headname));
		}
		System.out.println("-------------------------------------------------");
		System.out.println("����ʽΪ��"+req.getMethod());
		System.out.println("����Э��Ϊ��"+req.getProtocol());
		System.out.println("������Ϊ��"+req.getServletPath());
		System.out.println("����URIΪ��"+req.getRequestURI());
		System.out.println("����URLΪ��"+req.getRequestURL());
		//request���������֮������ȡ��ҳ�����������
		//��Ϣ����Ϊkey-value����ʽ
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
		//��Ϣ����Ϊkey-values����ʽ
//		String [] hobbys = req.getParameterValues("hobby");
//		System.out.println("hobby:"+Arrays.toString(hobbys));
		//��Ϣ��������key-values�ж������ʽʱ��map����ʽ��
		Map<String, String[]> map = req.getParameterMap();
		Set<String> set = map.keySet();
		for (String s : set) {
			System.out.println(s+":"+Arrays.toString(map.get(s)));
		}
	}
}
