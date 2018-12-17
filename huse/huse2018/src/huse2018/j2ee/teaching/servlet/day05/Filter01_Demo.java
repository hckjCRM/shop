package huse2018.j2ee.teaching.servlet.day05;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(value="*.do")
public class Filter01_Demo implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter1��ʼ���ˣ�");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�ж��Ƿ����ڹ�������������ݷ��͵���һ��servlet��
		HttpServletRequest req = (HttpServletRequest)request;
		req.setAttribute("name", "zs");
		System.out.println("����filter1---code1");
		chain.doFilter(req, response);
		System.out.println("����filter1---code2");
	}

	@Override
	public void destroy() {
		System.out.println("filter1������");
	}

}
