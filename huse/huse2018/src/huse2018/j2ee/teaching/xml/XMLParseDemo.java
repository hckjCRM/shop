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
		//1、构建一个文档对象树
		Document doc = DocumentHelper.createDocument();
		//2、通过树来构建一个根节点
		Element root = doc.addElement("booklist");
		//3、通过根节点来创建二级节点
		Element book1 = root.addElement("book");
		//4、通过二级节点来创建三级节点
		Element name1 = book1.addElement("name");
		Element author1 = book1.addElement("author");
		Element price1 = book1.addElement("price");
		//5、为节点来赋值
		name1.setText("天龙八部");
		author1.setText("刘杰");
		price1.setText("19.9");
		//6、重复以上操作
		Element book2 = root.addElement("book");
		book2.setAttributeValue("hot", "true");
		Element name2 = book2.addElement("name");
		Element author2 = book2.addElement("author");
		Element price2 = book2.addElement("price");
		name2.setText("红楼梦");
		author2.setText("刘杰1");
		price2.setText("29.9");
		//重复以上操作
		Element book3 = root.addElement("book");
		Element name3 = book3.addElement("name");
		Element author3 = book3.addElement("author");
		Element price3 = book3.addElement("price");
		name3.setText("西游记");
		author3.setText("刘杰2");
		price3.setText("39.9");
		//7、创建一个字符输出流
		FileWriter fw = new FileWriter(new File("newbook.xml"));
		//8、如果你要使用中文，那么就要创建一个OutputFormat对象来设置编码格式
		OutputFormat of = new OutputFormat();
		of.setEncoding("gb2312");
		//构建一个能够让输出流和树对象结合在一起的，XMLWriter
		XMLWriter xw = new XMLWriter(fw, of);
		//9、把树写入进来
		xw.write(doc);
		//10、关流
		fw.close();
		xw.close();
	}
	public void readXML() throws DocumentException{
		//1、使用File类来加载你需要读取的XML文件路径
		File file = new File("src/huse2018/j2ee/teaching/xml/book.xml");
		//2、创建一个用来加载File的处理XML的对象
		SAXReader sr = new SAXReader();
		//3、使用SAXReader对象来读取File对象
		Document doc = sr.read(file);
		//4、通过树形结构来拿到根节点
		Node root = doc.selectSingleNode("书籍列表");
		//5、通过根节点来拿到指定的二级节点
		List<Element> list = root.selectNodes("武侠小说");
		//6、遍历集合
		for (Element e : list) {
			//拿到每一个节点，即是武侠小说节点下面的节点，比如说书名、作者、价格之类的
			System.out.println("书名："+e.elementTextTrim("书名"));
			//7、如果要获取到指定节点的属性的话，那么我们要首先把该节点得到
			Element bookname = e.element("书名");
			//8、调用获取到节点里面所有属性的方法，并且返回一个Iterator对象
			Iterator<Attribute> ite = bookname.attributeIterator();
			//9、迭代该Iterator对象
			while(ite.hasNext()){
				Attribute att = ite.next();
				//10、获取到里面的数据
				System.out.println(att.getName()+"："+att.getValue());
			}
			System.out.println("出版日期："+e.elementTextTrim("出版日期"));
			System.out.println("价格："+e.elementTextTrim("价格"));
			System.out.println("简介："+e.elementTextTrim("简介"));
			System.out.println("------------------------------------");
		}
	}
}
