package org.stockforecast.stockpoint.configuration;


import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 作为整个系统的配置部分
 * 基本内容是：
 * 1 需要抓去的信息的网站 <HostURl></HostURL>
 * 2 需要抓取信息的参数    <Parameter></Parameter>
 * 3 RequestHeader的内容<RequestHeader></RequestHeader>
 * 4 获取的方法，GET抑或POST<SendMethod></SendMethond>
 * 5 匹配时需要的正则表达式 <Regex></Regex>
 * 
 * 注意点：1 参数一般都是设置好的字符常量，如果有参数为null则表示为可变参量
 *      2 RequestHeader中并不一定包含全部参数，只是可选择性的加入一些参量
 *      3 参数总的XForward应该特殊对待，计划在这里弄一个动态IP
 *      4 以上所有信息全部包含在一个<WebSite name="">标签中
 * */

public class BasicConfiguration implements Configuration {

/*XML 包中的类*/ 
	protected Document _document=null;
/*元素节点*/     
	protected Element _root=null;
	protected Element _Website=null;
	protected Element _HostURL=null;
	protected Element _Parameter=null;
	protected Element _RequestHeader=null;
	protected Element _SendMethod=null;
	protected Element _Regex=null;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    
	protected Scanner _scanner =new Scanner(System.in);
     public BasicConfiguration(){
       
        try{
		    factory = DocumentBuilderFactory.newInstance();
		    builder = factory.newDocumentBuilder();		
	    }
		catch (ParserConfigurationException e){
			 System.out.println(e.getMessage());
		}
        
      }
     
}
