package servletwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter pw = resp.getWriter();
		try {
			Connection conn=ConnectionUtils.getConnection();
			String sql="select * from users where username=? and password=?";
			PreparedStatement prsm=conn.prepareStatement(sql);
			prsm.setString(1, username);
			prsm.setString(2, password);
			ResultSet rs=prsm.executeQuery();
			if(rs.next()) {
				ArrayList<EMP> li=findAll();
				for (int i = 0; i < rmd.getColumnCount(); i++) {
					System.out.println(rmd.getColumnName(i));
				}
				pw.println("<table border='1px' width='600px' align='center'>");
				for (EMP emp : li) {
					pw.print("<tr>");
					pw.print("<td>");
						pw.print(emp.getEMPNO());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getENAME());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getMGR());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getJOB());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getSAL());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getCOMM());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getHIREDATE());
					pw.print("</td>");
					pw.print("<td>");
						pw.print(emp.getDEPTNO());
					pw.print("</td>");
					pw.print("</tr>");
				}
				pw.println("</table>");
			}else{
				pw.println("login error");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	ResultSetMetaData rmd;
	
	@SuppressWarnings("unused")
	public ArrayList<EMP> findAll() throws SQLException {
		ArrayList<EMP> list= new ArrayList<EMP>();
		Connection conn=ConnectionUtils.getConnection();
		String sql="select * from empp";
		PreparedStatement prsm=conn.prepareStatement(sql);
		ResultSet rs=prsm.executeQuery();
		ResultSetMetaData rmd=rs.getMetaData();
		while(rs.next()) {
			EMP e = new EMP();
			e.setEMPNO(rs.getInt(1));
			e.setENAME(rs.getString(2));
			e.setJOB(rs.getString(3));
			e.setMGR(rs.getInt(4));
			e.setHIREDATE(rs.getString(5));
			e.setSAL(rs.getDouble(6));
			e.setCOMM(rs.getDouble(7));
			e.setDEPTNO(rs.getInt(8));
			list.add(e);
		}
		return list;
	}
	
}
