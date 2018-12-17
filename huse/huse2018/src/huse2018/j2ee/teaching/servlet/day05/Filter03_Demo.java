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
@WebFilter(value="*.action",initParams=@WebInitParam(name="illstr",value="������"))
public class Filter03_Demo implements Filter{
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1��ת������
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//2�����ñ���
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//3����ȡ��ҳ������
		String msg = req.getParameter("input");
		//4����ȡ���Ƿ��ַ��ؼ���
		String illstr = config.getInitParameter("illstr");
		//5���ж��Ƿ��зǷ��ַ�
		if(msg.indexOf(illstr)>=0){
			resp.getWriter().println("ҳ���зǷ��ַ��������ύ��");
		}else{
			chain.doFilter(req, resp);
		}
		
		
	}

	@Override
	public void destroy() {
	}

}
