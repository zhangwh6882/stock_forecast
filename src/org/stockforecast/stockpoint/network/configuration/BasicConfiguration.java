package org.stockforecast.stockpoint.network.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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

public class BasicConfiguration  {
/*目录文件*/
	 private final String FILE_PATH = "conf/configuration.xml";
/*配置文件中的标签名称*/	 
	 private final String HOST_URL = "HostURL";
	 private final String PARAMETER = "Parameter";
	 private final String REQUESTHEADER = "RequestHeader";
	 private final String SENDMETHOD = "SendMethod";
	 private final String WEBSITE = "WebSite";
	 private final String REGEX="Regex";
/*RequestHeader 内容*/	 
	 private final String ACCEPT="Accept";
	 private final String ACCEPT_ENCODING="Accept-Encoding";
	 private final String ACCEPT_LANGUAGE="Accept-Language";
	 private final String CACHE_CONTROL="Cache-Control";
	 private final String CONNECTION="Connection";
	 private final String HOST="Host";
	 private final String USER_AGENT="User-agent";
	 private final String X_FORWARDED_FOR="X-Forwarded-For";
	 private final String REFERER="Referer";
/*XML 包中的类*/ 
	 private DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
     private DocumentBuilder builder =null;
     private Document doc=null;
     private InputStream file=null;
/*元素节点*/     
     private Element root=null;
     private Element Website=null;
     private Element HostURL=null;
     private Element Parameter=null;
     private Element RequestHeader=null;
     private Element SendMethod=null;
     private Element Regex=null;
     
/*初始化配置文件内容*/     
     private final String InitContent="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
     		                          + "\n<root>\n</root>";
/*控制内容输入*/   
     private Scanner scanner =new Scanner(System.in);
/*构造函数*/
     public BasicConfiguration() throws IOException{
    	    FileOutputStream fos=null;
			try {
				builder=builderFactory.newDocumentBuilder();
				try {
					file=new FileInputStream(FILE_PATH);
				} catch (FileNotFoundException e) {
					File  tempfile=new File(FILE_PATH);
					if(tempfile.createNewFile()){
						System.out.println("创建配置文件成功");
						fos=new FileOutputStream(FILE_PATH);
						fos.write(InitContent.getBytes());
						builder=builderFactory.newDocumentBuilder();
						file=new FileInputStream(FILE_PATH);
					}
					else{
						System.out.println("创建配置文件失败");
						return;
					}
				}
				doc=builder.parse(file);
				root = doc.getDocumentElement();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if (fos != null) {
					fos.close();
					fos = null;
				}
			}	
     }
/*设置抓取的网站的名称*/
     public void SetWebsiteName(){
    	 System.out.print("输入抓取的网站的名称:");
 		 String body=scanner.nextLine();
    	 Website=doc.createElement(WEBSITE);
    	 Website.setAttribute("name", body);
    	 root.appendChild(Website); 
 	 }
 /*设置要抓去的网站的网址*/    
 	 public void setUrl(){
 		System.out.print("输入网址:");
		String body=scanner.nextLine();
 		HostURL=doc.createElement(HOST_URL);
 		HostURL.setTextContent(body);
 		Website.appendChild(HostURL);
 	 }
	 
 	 public void setParamter(){
 		System.out.println("--------------输入抓取的时所需参数--------------");
 		Parameter=doc.createElement(PARAMETER);
 		System.out.print("如果该链接没有参数输入1\n如果有参数且参数是固定的输入2\n如果有参数且参数是变化的输入3\n对应选项输入参数：");
 		switch(scanner.nextLine()){
 		   case "1" :Parameter.setAttribute("status", "1"); break;
 		   case "2" :Parameter.setAttribute("status", "2");setParamterChildNode("2"); break;
 		   case "3" :Parameter.setAttribute("status", "3");setParamterChildNode("3"); break;
 		   default  :System.out.println("参数输入错误");break;
 		
 		}
 		Website.appendChild(Parameter);
 		
 	 }
 	 
 	 public void setParamterChildNode(String status){
 		boolean changeable = false; 
 		switch(status){
 		case "2" :changeable=true;break;
 		case "3" :changeable=true;break;
 		}
 		if(changeable){
 			while(true){
 				System.out.print("输入参数的名称:");
 				String name=scanner.nextLine();
 				Element element=doc.createElement("child");
 				element.setAttribute("name", name);
 				System.out.print("输入参数的内容：");
 				String body=scanner.nextLine();
 				element.setTextContent(body);
 				Parameter.appendChild(element);
 				System.out.print("是否完成输入？(Y/N):");
 				String choice=scanner.nextLine();
 				if(choice.equals("Y")||choice.equals("y"))
 					break;
 				else
 					continue;
 			}
 		}
 		else{
 			System.out.print("输入参数：");
 			String body=scanner.nextLine();
 			Parameter.setTextContent(body);
 		}
 	 }
/*设置setRequestHeader标签*/	 
 	 public void setRequestHeader(){
 		System.out.println("-------------输入RequestHeader-------------");
 		RequestHeader=doc.createElement(REQUESTHEADER);
 		Website.appendChild(RequestHeader);
 		setRequestHeaderChildNode(ACCEPT);
 		setRequestHeaderChildNode(ACCEPT_ENCODING);
 		setRequestHeaderChildNode(ACCEPT_LANGUAGE);
 		setRequestHeaderChildNode(CACHE_CONTROL);
 		setRequestHeaderChildNode(CONNECTION);
 		setRequestHeaderChildNode(HOST);
 		setRequestHeaderChildNode(USER_AGENT);
 		setRequestHeaderChildNode(X_FORWARDED_FOR);
 		setRequestHeaderChildNode(REFERER);		
 	 }
 	 
 	 public void setRequestHeaderChildNode(String RequestHeaderName){
 		 System.out.print("输入"+RequestHeaderName+"内容：");
 		 String body=scanner.nextLine();
 		 Element element=doc.createElement("child");
 		 element.setAttribute("name", RequestHeaderName);
 		 element.setTextContent(body);
 		 RequestHeader.appendChild(element);
 		 
 	 }
/*设置POST亦或是GET方法*/ 	 
 	 public void setSendMethod(){
 		 System.out.print("输入POST抑或是GET：");
 		 String body=scanner.nextLine();
 		 SendMethod=doc.createElement(SENDMETHOD);
 		 SendMethod.setTextContent(body);
 		 Website.appendChild(SendMethod);
 	 }
/*设置正则表达式*/	 
 	 public void setRegex(){
 		System.out.print("输入匹配正则表达式:");
		String body=scanner.nextLine();
 		Regex=doc.createElement(REGEX);
 		Regex.setTextContent(body);
 		Website.appendChild(Regex);
 	 }
 /*输出已经设置好的参数*/ 
 	 public void Output(Node node,String fileName){
 		 TransformerFactory transformerFactory=TransformerFactory.newInstance();
 		 try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			DOMSource source=new DOMSource();
			source.setNode(node);
			StreamResult result=new StreamResult();
			if(fileName==null){
				result.setOutputStream(System.out);
			}
			else{
				result.setOutputStream(new FileOutputStream(fileName));
				
			}
		   transformer.transform(source, result);	
		 } catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//nothing to do
			e.printStackTrace();
		 } catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	 }
     public void WriteConfiguration(){
    	 Output(root,FILE_PATH);
     }
     public void getConfiguration(){
    	 
     }
     public void Description(){
    	 
     }
}
