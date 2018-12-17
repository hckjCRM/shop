package filterwork;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns="/msg.action" )
public class FilterPingLun1Demo implements Filter{
	private FilterConfig configs;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.configs=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req=(HttpServletRequest)request;
		HttpServletResponse  reps=(HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		reps.setContentType("text/html;charset=utf-8");
		String message=req.getParameter("message");
		if(message.length()>30){
			reps.getWriter().write("你的输入字符太多了！");
		}else{
			req.setAttribute("msg", message);
			chain.doFilter(req, reps);
		}
	}
	@Override
	public void destroy() {
		
	}

}
