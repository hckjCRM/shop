package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/session3.do")
public class SessionDemo3Servlet extends HttpServlet{
	/**
	 * ʹ��session�����ҳ�����֤���ܣ�
	 * ���������û�е�½����ô�㽫�޷����뵽����ҳ�棬���һ��Զ�������½ҳ��
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session=req.getSession();
		
	}
}
