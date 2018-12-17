package servletwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username");
		String password =req.getParameter("password");
		PrintWriter pw=resp.getWriter();
		try {
			Connection conn=ConnectionUtils.getConnection();
			String sql="insert into users values(?,?)";
			PreparedStatement prsm=conn.prepareStatement(sql);
			prsm.setString(1, username);
			prsm.setString(2, password);
			prsm.executeUpdate();
			pw.println("regist");
			resp.sendRedirect("login.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
