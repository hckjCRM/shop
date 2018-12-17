package huse2018.j2ee.teaching.servlet.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 汪洋
 * 转发
 * 1、转发的时候，request里面绑定数据是可以携带到下一个页面的；
 * 2、request里面的数据的有效期为一次完整的请求和响应；
 * 3、如何通过转发来访问WEB-INF下面的隐私页面
 * 4、转发只能访问当前工程里面的内容
 *
 */
@WebServlet(urlPatterns="/from.do")
public class ServletDemo5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//把数据绑定在request里面
		req.setAttribute("uname", "zhangsan");
		//转发该数据到下一个servlet中
//		req.getRequestDispatcher("/to.do").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/otherSafe/reg.html").forward(req, resp);
		req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		//如果发送的是页面，那么不需要考虑其他事情，页面会有Request对象直接getAttribute来拿
	}
}
