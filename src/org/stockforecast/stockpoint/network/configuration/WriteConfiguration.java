package org.stockforecast.stockpoint.network.configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class WriteConfiguration extends BasicConfiguration
{
       public WriteConfiguration(String choice) throws SAXException, IOException{
    	   super();
    	   switch(choice){
    		   case "new" :    this._document = builder.newDocument();
    	                       _root = this._document.createElement("root");
    	                       this._document.appendChild(_root);
    	                       break;
    		   case "append":  this._document=builder.parse(FILE_PATH);
    		                   _root=this._document.getDocumentElement();
    		                   break;
    		    default:       break;
    	   }
       }
       
       public void setConfiguration(){
    	   this.setWebsiteName();
   		   this.setUrl();
   		   this.setParamter();
   	       this.setRequestHeader();
   		   this.setSendMethod();
   		   this.setRegex();
   		   this.OutputConfiguration();
       }
       /*设置抓取的网站的名称*/
       private void setWebsiteName(){
      	 System.out.print("输入抓取的网站的名称:");
   		 String body=_scanner.nextLine();
      	 _Website=_document.createElement(WEBSITE);
         _Website.setAttribute("name", body);
      	 _root.appendChild(_Website); 
   	 }
   /*设置要抓去的网站的网址*/    
       private void setUrl(){
   		System.out.print("输入网址:");
  		String body=_scanner.nextLine();
   		_HostURL=_document.createElement(HOST_URL);
   		_HostURL.setTextContent(body);
   		_Website.appendChild(_HostURL);
   	 }
  	 
       private void setParamter(){
   		System.out.println("--------------输入抓取的时所需参数--------------");
   		_Parameter=_document.createElement(PARAMETER);
   		System.out.print("如果该链接没有参数输入1\n如果有参数且参数是固定的输入2\n如果有参数且参数是变化的输入3\n对应选项输入参数：");
   		switch(_scanner.nextLine()){
   		   case "1" :_Parameter.setAttribute("status", "1"); break;
   		   case "2" :_Parameter.setAttribute("status", "2");setParamterChildNode("2"); break;
   		   case "3" :_Parameter.setAttribute("status", "3");setParamterChildNode("3"); break;
   		   default  :System.out.println("参数输入错误");break;
   		
   		}
   		_Website.appendChild(_Parameter);
   		
   	 }
   	 
       private void setParamterChildNode(String status){
   		boolean changeable = false; 
   		switch(status){
   		case "2" :changeable=true;break;
   		case "3" :changeable=true;break;
   		}
   		if(changeable){
   			while(true){
   				System.out.print("输入参数的名称:");
   				String name=_scanner.nextLine();
   				Element element=_document.createElement("child");
   				element.setAttribute("name", name);
   				System.out.print("输入参数的内容：");
   				String body=_scanner.nextLine();
   				element.setTextContent(body);
   				_Parameter.appendChild(element);
   				System.out.print("是否完成输入？(Y/N):");
   				String choice=_scanner.nextLine();
   				if(choice.equals("Y")||choice.equals("y"))
   					break;
   				else
   					continue;
   			}
   		}
   		else{
   			System.out.print("输入参数：");
   			String body=_scanner.nextLine();
   			_Parameter.setTextContent(body);
   		}
   	 }
  /*设置setRequestHeader标签*/	 
       private void setRequestHeader(){
   		System.out.println("-------------输入RequestHeader-------------");
   		_RequestHeader=_document.createElement(REQUESTHEADER);
   		_Website.appendChild(_RequestHeader);
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
   	 
       private void setRequestHeaderChildNode(String RequestHeaderName){
   		 System.out.print("输入"+RequestHeaderName+"内容：");
   		 String body=_scanner.nextLine();
   		 Element element=_document.createElement("child");
   		 element.setAttribute("name", RequestHeaderName);
   		 element.setTextContent(body);
   		 _RequestHeader.appendChild(element);
   		 
   	 }
  /*设置POST亦或是GET方法*/ 	 
       private void setSendMethod(){
   		 System.out.print("输入POST抑或是GET：");
   		 String body=_scanner.nextLine();
   		 _SendMethod=_document.createElement(SENDMETHOD);
   		 _SendMethod.setTextContent(body);
   		 _Website.appendChild(_SendMethod);
   	 }
  /*设置正则表达式*/	 
       private void setRegex(){
   		Element stockName=_document.createElement("stockname");
   		Element stockCode=_document.createElement("stockcode");
   		_Regex=_document.createElement(REGEX);
   		System.out.println("---------------------输入匹配正则表达式------------------------");
   		System.out.print("输入匹配股票简称的正则表达式：");
  		String name=_scanner.nextLine();
  	    stockName.setTextContent(name);
   		System.out.print("输入匹配股票名称的正则表达式：");
   		String code=_scanner.nextLine();
   		stockCode.setTextContent(code);
   		_Regex.appendChild(stockName);
   		_Regex.appendChild(stockCode);
   		_Website.appendChild(_Regex);
   	 }
   /*--------------------------------输出已经设置好的参数--------------------------------------*/ 
       private void OutputConfiguration(){
   		 TransformerFactory transformerFactory=TransformerFactory.newInstance();
   		 try {
  			Transformer transformer = transformerFactory.newTransformer();
  			DOMSource source=new DOMSource(_document);
  			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
  			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
  			PrintWriter pw = new PrintWriter(new FileOutputStream(FILE_PATH));
  			StreamResult result=new StreamResult(pw);
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
}
