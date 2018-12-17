package filter;

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
@WebFilter(urlPatterns="/input.action",initParams=@WebInitParam(name="illeger",value="流氓琦") )
public class Filter03Demo implements Filter{
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
		String input=req.getParameter("context");
		String illeger=configs.getInitParameter("illeger");
		if(input.indexOf(illeger)>=0){
			input = input.replace(illeger,"xxx");
			req.setAttribute("input", input);
			chain.doFilter(req, reps);
			/*reps.getWriter().write("你的输入中含有非法字符！");*/
		}else{
			req.setAttribute("input", input);
			chain.doFilter(req, reps);
		}
	}
	@Override
	public void destroy() {
		
	}

}
