package huse2018.j2ee.teaching.xml;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class XmlDome {
	public static void main(String[] args) throws Exception {
		setXml();
	}

	 private static void setXml() throws Exception {
	        List<HashMap<String,Object>> empslit=getMap();
	        FileWriter fw=new FileWriter(new File("emplist1.xml"));
	        OutputFormat of=new OutputFormat();
	        of.setEncoding("gb2312");
	        Document doc=DocumentHelper.createDocument();
	        Element root=doc.addElement("emplist");
	        for(HashMap<String,Object>  map:empslit){
	            Element viproot=root.addElement("emp");
	            for (String str : map.keySet()) {
	                viproot.addElement(str).setText((String)map.get(str));
	            }
	        }
	        XMLWriter xw=new XMLWriter(fw,of);
	        xw.write(doc);
	        fw.close();
	        xw.close();
	    }

	    public static List<HashMap<String,Object>> getMap() throws Exception {
	        List<String> names=new ArrayList<String>();
	        List<HashMap<String,Object>> maplist=new ArrayList<HashMap<String,Object>>();
	        Connection conn;
	        PreparedStatement psm;
	        ResultSet rs = null;
	        try {
	            conn = ConnectionUtils.getConnection();
	            String sql = "select * from emp";
	            psm = conn.prepareStatement(sql);
	            rs = psm.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        ResultSetMetaData rsmd = rs.getMetaData();
	        //获取到列的数量
	        int num = rsmd.getColumnCount();
	        //循环列的数量，拿到列名
	        for (int i = 1; i <= num; i++) {
	            names.add(rsmd.getColumnName(i));
	        }
	        while (rs.next()) {
	            HashMap<String,Object> map=new HashMap<String,Object>();
	            for(String str:names) {
	                map.put(str, rs.getString(str)!=null?rs.getString(str):"");
	            }
	            maplist.add(map);
	        }
	        return maplist;
	    }
	
}
