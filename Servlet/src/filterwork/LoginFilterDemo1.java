package filterwork;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 
 * @author le
 *����������Ŀ��һ��������ƣ����еı����ύ����ͨ�������ļ��е�*.do������ƥ��ģ�
 *��ô������һ�����⣬����Ҫ���һ��������ʩ������
 *������ͨ����ַ������дĳ��ҳ���ʱ�򣬻�����жϣ��жϽ������ҳ����û��Ƿ��¼��
 *����ǵ�¼�Ļ�����ôȥ���ݿ�����������û���Ȩ���Ƿ��ܲ鿴�����վ��
 *���û�е�¼����ô������url�����url��index.jsp������login.jsp�Ļ���
 *�����κμ�飬������ǵĻ�������index.jspҳ�棻
 *
 */
@WebFilter(urlPatterns="*.jsp")
public class LoginFilterDemo1 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req=(HttpServletRequest)request;
		HttpServletResponse  reps=(HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		reps.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		String username=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");
//		System.out.println(username+" "+password);
		String uri=req.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri);
		if("log.jsp".equals(uri)){
			chain.doFilter(req, reps);
		}else if(username==null||password==null&&!"log.jsp".equals(uri)){
			reps.sendRedirect("log.jsp");
		}else{
			chain.doFilter(req, reps);
		}
	}

	@Override
	public void destroy() {
		
	}
	
}
