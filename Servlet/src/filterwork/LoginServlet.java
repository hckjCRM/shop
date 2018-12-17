package filterwork;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletwork.ConnectionUtils;
@WebServlet(urlPatterns="/logs.action")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username");
		String password =req.getParameter("password");
//		System.out.println(username+" "+password);
		try {
			Connection conn=ConnectionUtils.getConnection();
			String sql="select * from users where username=? and password=?";
			PreparedStatement prsm=conn.prepareStatement(sql);
			prsm.setString(1, username);
			prsm.setString(2, password);
			ResultSet rs=prsm.executeQuery();
			if(rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
//				System.out.println(username+" "+password);
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}else{
				System.out.println("房东是个负担");
				req.getRequestDispatcher("log.jsp").forward(req, resp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
