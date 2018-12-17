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
		// 1��ʹ��File������������Ҫ��ȡ��XML�ļ�·��
		File file = new File("empList.xml");
		// 2������һ����������File�Ĵ���XML�Ķ���
		SAXReader sr = new SAXReader();
		// 3��ʹ��SAXReader��������ȡFile����
		Document doc = sr.read(file);
		// 4��ͨ�����νṹ���õ����ڵ�
		Node root = doc.selectSingleNode("emplist");
		// 5��ͨ�����ڵ����õ�ָ���Ķ����ڵ�
		List<Element> list = root.selectNodes("emp");
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		// 6����������
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
		// 1����ȡ���ݿ�����
		Connection conn = null;
		PreparedStatement psmt = null;
		// 2����дSQL���
		String sql = "insert into myemp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		// 3����д���ݿ����
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
		// 1������һ���ĵ�������
		Document doc = DocumentHelper.createDocument();
		// 2��ͨ����������һ�����ڵ�
		Element root = doc.addElement("emplist");
		FileWriter fw = null;
		XMLWriter xw = null;
		// 1����ȡ���ݿ�����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSetMetaData rmd = null;
		// 2����дSQL���
		String sql = "select * from emp";
		// 3����д���ݿ����
		try {
			conn = ConnectionUtils.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rmd = rs.getMetaData();
			ArrayList list = null;
			// 5������RS���������
			while (rs.next()) {
				list = new ArrayList();
				// 3�����ݼ��������ж��������ݣ���Ҫ�������ٸ�EMP���ӽڵ�
				Element e = root.addElement("emp");
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getInt(4));
				list.add(rs.getString(5));
				list.add(rs.getDouble(6));
				list.add(rs.getInt(7));
				list.add(rs.getInt(8));
				// 4�������ͷ����
				for (int i = 1; i <= rmd.getColumnCount(); i++) {
					Element ele = e.addElement(rmd.getColumnName(i));
					ele.setText(list.get(i - 1) + "");
				}
			}
			// 7������һ���ַ������
			fw = new FileWriter(new File("empList.xml"));
			// 8�������Ҫʹ�����ģ���ô��Ҫ����һ��OutputFormat���������ñ����ʽ
			OutputFormat of = new OutputFormat();
			of.setEncoding("gb2312");
			// ����һ���ܹ��������������������һ��ģ�XMLWriter
			xw = new XMLWriter(fw, of);
			// 9������д�����
			xw.write(doc);
		} catch (SQLException e) {
		} catch (IOException e1) {
		} finally {
			// 10������
			try {
				fw.close();
				xw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
