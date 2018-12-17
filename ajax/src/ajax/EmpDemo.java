package ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

@WebServlet(value="/cemp.do")
public class EmpDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<EMP> list = null;
		try {
			list = getTop3Emps();
			//转成Json对象
			String data = (String) JSON.toJSON(list);
			toString();
			//发送给前台
			resp.getWriter().write(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<EMP> getTop3Emps() throws SQLException{
		ArrayList<EMP> list = new ArrayList<EMP>();
		Connection conn = ConnectionUtils.getConnection();
		String sql="select * from (select empno,ename,job,sal,comm from EMP order by sal desc) where rownum<4";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			EMP e = new  EMP();
			e.setEMPNO(rs.getInt(1));
			e.setENAME(rs.getString(2));
			e.setJOB(rs.getString(3));
			e.setSAL(rs.getDouble(4));
			e.setCOMM(rs.getDouble(5));
			list.add(e);
		}
		return list;	
	}
	
}
