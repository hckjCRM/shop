package huse2018.j2ee.teaching.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class DBAndXmlDemo {
	@Test
	public void FromXml2Db() throws DocumentException {
		// 1、使用File类来加载你需要读取的XML文件路径
		File file = new File("empList.xml");
		// 2、创建一个用来加载File的处理XML的对象
		SAXReader sr = new SAXReader();
		// 3、使用SAXReader对象来读取File对象
		Document doc = sr.read(file);
		// 4、通过树形结构来拿到根节点
		Node root = doc.selectSingleNode("emplist");
		// 5、通过根节点来拿到指定的二级节点
		List<Element> list = root.selectNodes("emp");
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		// 6、遍历集合
		for (Element e : list) {
			Emp emp = new Emp();
			emp.setEMPNO(Integer.parseInt(e.elementTextTrim("EMPNO")));
			emp.setENAME(e.elementTextTrim("ENAME"));
			emp.setJOB(e.elementTextTrim("JOB"));
			emp.setSAL(Double.parseDouble(e.elementTextTrim("SAL")));
			emp.setMGR(Integer.parseInt(e.elementTextTrim("MGR")));
			emp.setDEPTNO(Integer.parseInt(e.elementTextTrim("DEPTNO")));
			emp.setCOMM(Double.parseDouble(e.elementTextTrim("COMM")));
			emp.setHIREDATE(e.elementTextTrim("HIREDATE"));
			emplist.add(emp);
		}
		// 1、获取数据库连接
		Connection conn = null;
		PreparedStatement psmt = null;
		// 2、书写SQL语句
		String sql = "insert into myemp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		// 3、书写数据库操作
		try {
			conn = ConnectionUtils.getConnection();
			for (int i = 0; i < emplist.size(); i++) {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, emplist.get(i).getEMPNO());
				psmt.setString(2, emplist.get(i).getENAME());
				psmt.setString(3, emplist.get(i).getJOB());
				psmt.setInt(4, emplist.get(i).getMGR());
				psmt.setString(5, emplist.get(i).getHIREDATE().substring(0,10));
				psmt.setDouble(6, emplist.get(i).getSAL());
				psmt.setDouble(7, emplist.get(i).getCOMM());
				psmt.setInt(8, emplist.get(i).getDEPTNO());
				psmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void FromDb2Xml() {
		// 1、构建一个文档对象树
		Document doc = DocumentHelper.createDocument();
		// 2、通过树来构建一个根节点
		Element root = doc.addElement("emplist");
		FileWriter fw = null;
		XMLWriter xw = null;
		// 1、获取数据库连接
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSetMetaData rmd = null;
		// 2、书写SQL语句
		String sql = "select * from emp";
		// 3、书写数据库操作
		try {
			conn = ConnectionUtils.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rmd = rs.getMetaData();
			ArrayList list = null;
			// 5、处理RS里面的数据
			while (rs.next()) {
				list = new ArrayList();
				// 3、数据集合里面有多少条数据，就要创建多少个EMP的子节点
				Element e = root.addElement("emp");
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getInt(4));
				list.add(rs.getString(5));
				list.add(rs.getDouble(6));
				list.add(rs.getInt(7));
				list.add(rs.getInt(8));
				// 4、处理表头数据
				for (int i = 1; i <= rmd.getColumnCount(); i++) {
					Element ele = e.addElement(rmd.getColumnName(i));
					ele.setText(list.get(i - 1) + "");
				}
			}
			// 7、创建一个字符输出流
			fw = new FileWriter(new File("empList.xml"));
			// 8、如果你要使用中文，那么就要创建一个OutputFormat对象来设置编码格式
			OutputFormat of = new OutputFormat();
			of.setEncoding("gb2312");
			// 构建一个能够让输出流和树对象结合在一起的，XMLWriter
			xw = new XMLWriter(fw, of);
			// 9、把树写入进来
			xw.write(doc);
		} catch (SQLException e) {
		} catch (IOException e1) {
		} finally {
			// 10、关流
			try {
				fw.close();
				xw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
