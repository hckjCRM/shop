package huse2018.j2ee.teaching.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class XMLParseDemo {
	@Test
	public void writeXML() throws IOException{
		//1������һ���ĵ�������
		Document doc = DocumentHelper.createDocument();
		//2��ͨ����������һ�����ڵ�
		Element root = doc.addElement("booklist");
		//3��ͨ�����ڵ������������ڵ�
		Element book1 = root.addElement("book");
		//4��ͨ�������ڵ������������ڵ�
		Element name1 = book1.addElement("name");
		Element author1 = book1.addElement("author");
		Element price1 = book1.addElement("price");
		//5��Ϊ�ڵ�����ֵ
		name1.setText("�����˲�");
		author1.setText("����");
		price1.setText("19.9");
		//6���ظ����ϲ���
		Element book2 = root.addElement("book");
		book2.setAttributeValue("hot", "true");
		Element name2 = book2.addElement("name");
		Element author2 = book2.addElement("author");
		Element price2 = book2.addElement("price");
		name2.setText("��¥��");
		author2.setText("����1");
		price2.setText("29.9");
		//�ظ����ϲ���
		Element book3 = root.addElement("book");
		Element name3 = book3.addElement("name");
		Element author3 = book3.addElement("author");
		Element price3 = book3.addElement("price");
		name3.setText("���μ�");
		author3.setText("����2");
		price3.setText("39.9");
		//7������һ���ַ������
		FileWriter fw = new FileWriter(new File("newbook.xml"));
		//8�������Ҫʹ�����ģ���ô��Ҫ����һ��OutputFormat���������ñ����ʽ
		OutputFormat of = new OutputFormat();
		of.setEncoding("gb2312");
		//����һ���ܹ��������������������һ��ģ�XMLWriter
		XMLWriter xw = new XMLWriter(fw, of);
		//9������д�����
		xw.write(doc);
		//10������
		fw.close();
		xw.close();
	}
	public void readXML() throws DocumentException{
		//1��ʹ��File������������Ҫ��ȡ��XML�ļ�·��
		File file = new File("src/huse2018/j2ee/teaching/xml/book.xml");
		//2������һ����������File�Ĵ���XML�Ķ���
		SAXReader sr = new SAXReader();
		//3��ʹ��SAXReader��������ȡFile����
		Document doc = sr.read(file);
		//4��ͨ�����νṹ���õ����ڵ�
		Node root = doc.selectSingleNode("�鼮�б�");
		//5��ͨ�����ڵ����õ�ָ���Ķ����ڵ�
		List<Element> list = root.selectNodes("����С˵");
		//6����������
		for (Element e : list) {
			//�õ�ÿһ���ڵ㣬��������С˵�ڵ�����Ľڵ㣬����˵���������ߡ��۸�֮���
			System.out.println("������"+e.elementTextTrim("����"));
			//7�����Ҫ��ȡ��ָ���ڵ�����ԵĻ�����ô����Ҫ���ȰѸýڵ�õ�
			Element bookname = e.element("����");
			//8�����û�ȡ���ڵ������������Եķ��������ҷ���һ��Iterator����
			Iterator<Attribute> ite = bookname.attributeIterator();
			//9��������Iterator����
			while(ite.hasNext()){
				Attribute att = ite.next();
				//10����ȡ�����������
				System.out.println(att.getName()+"��"+att.getValue());
			}
			System.out.println("�������ڣ�"+e.elementTextTrim("��������"));
			System.out.println("�۸�"+e.elementTextTrim("�۸�"));
			System.out.println("��飺"+e.elementTextTrim("���"));
			System.out.println("------------------------------------");
		}
	}
}
