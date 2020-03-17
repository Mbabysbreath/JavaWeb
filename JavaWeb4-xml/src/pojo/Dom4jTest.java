package pojo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author zhaomin
 * @date 2020/3/7 11:25
 */
public class Dom4jTest {
    /**
     * 使用dom4j解析xml文件测试
     * @throws Exception
     */
    @Test
    public void test1()  {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader=new SAXReader();
        try {
            Document document = saxReader.read("src/books.xml");
            System.out.println(document);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读取books.xml文件生成book类
     */
    @Test
    public void test2() throws Exception {
        //1 读取books.xml文件
        SAXReader reader=new SAXReader();
        //在Junit测试中，相对路径是从模块名开始算
        Document document=reader.read("src/books.xml");
        //2.通过DOcument对象获取根元素
        Element rootElement=document.getRootElement();
        //System.out.println(rootElement.asXML());
        System.out.println(rootElement);
        //3.通过根元素获取指定book标签对象，element（）和elements（）都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4.遍历，处理每个book标签转换为Book类
        for(Element book:books){
            //asXml()把标签对象，转换为标签字符串
            // System.out.println(book.asXML());

            Element nameElement=book.element("name");
            //System.out.println(nameElement.asXML());
            //getText():可以获取标签中的文本内容
            String nameText=nameElement.getText();
            //System.out.println(nameText);

            //elementText直接获取指定标签名的文本内容,比上边用book.element()和getText()简单
            String priceText=book.elementText("price");
            //System.out.println(priceText);
            String authorText=book.elementText("author");
            //System.out.println(authorText);

            String snValue = book.attributeValue("sn");
            //System.out.println(snValue);

            System.out.println(new Book(snValue, nameText, Double.parseDouble(priceText), authorText));


        }
    }
}
