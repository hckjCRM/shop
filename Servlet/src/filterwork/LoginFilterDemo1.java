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
 *假设你在项目有一个这样设计，所有的表单的提交都是通过配置文件中的*.do来进行匹配的，
 *那么现在有一个问题，我需要设计一个防范措施，即，
 *在我们通过地址栏来书写某个页面的时候，会进行判断，判断进入这个页面的用户是否登录，
 *如果是登录的话，那么去数据库中搜索这个用户的权限是否能查看这个网站，
 *如果没有登录，那么检查你的url，如果url是index.jsp或者是login.jsp的话，
 *不做任何检查，如果不是的话，跳回index.jsp页面；
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
