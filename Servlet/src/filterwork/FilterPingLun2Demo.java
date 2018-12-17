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
@WebFilter(urlPatterns="/msg.action",initParams=@WebInitParam(name="illeger",value="流氓琦") )
public class FilterPingLun2Demo implements Filter{
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
		String illeger=configs.getInitParameter("illeger");
		if(message.indexOf(illeger)>=0){
			reps.getWriter().write("你的输入中含有非法字符，评论关闭！");
		}else{
			req.setAttribute("msg", message);
			chain.doFilter(req, reps);
		}
	}
	@Override
	public void destroy() {
		
	}

}
