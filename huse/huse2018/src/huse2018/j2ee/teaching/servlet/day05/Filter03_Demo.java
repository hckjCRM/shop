package huse2018.j2ee.teaching.servlet.day05;

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
@WebFilter(value="*.action",initParams=@WebInitParam(name="illstr",value="共产党"))
public class Filter03_Demo implements Filter{
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1、转换对象
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//2、设置编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//3、获取到页面数据
		String msg = req.getParameter("input");
		//4、获取到非法字符关键字
		String illstr = config.getInitParameter("illstr");
		//5、判断是否有非法字符
		if(msg.indexOf(illstr)>=0){
			resp.getWriter().println("页面有非法字符，不能提交！");
		}else{
			chain.doFilter(req, resp);
		}
		
		
	}

	@Override
	public void destroy() {
	}

}
