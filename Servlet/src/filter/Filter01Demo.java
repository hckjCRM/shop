package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="*.do")
public class Filter01Demo implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("fiter1初始化");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		req.setAttribute("wife", "流氓琦");
		System.out.println("fiter1-doFilter1");
		chain.doFilter(req, response);
		System.out.println("fiter1-doFilter2");
	}

	@Override
	public void destroy() {
		System.out.println("fiter1销毁");
		
	}



}
