package huse2018.j2ee.teaching.servlet.day02.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		//1、拿到页面的数据
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2、合并成一个User对象
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		//3、实例化一个dao层对象并且调用指定方法
		try {
			if(login(u)){
				//4、登录成功之后，展示主页面的信息
				//4.1、获取到主页面的所有内容
				ArrayList<EMP> list = findAll();
				//4.2、在上面获取到PrintWriter对象
				//4.3、遍历list集合，并且在外面构建一个table
				pw.println("<table border='1px' width='600px' align='center'>");
				for (EMP emp : list) {
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
				pw.println("login error!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<EMP> findAll() throws SQLException{
		ArrayList<EMP> list = new ArrayList<EMP>();
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO from emp";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
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
	public boolean login(User u) throws SQLException{
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select * from users where username=? and password=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, u.getUsername());
		psmt.setString(2, u.getPassword());
		ResultSet rs = psmt.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
		
	}
}
