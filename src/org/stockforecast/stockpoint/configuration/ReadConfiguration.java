package org.stockforecast.stockpoint.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.stockforecast.common.WebAttribute;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadConfiguration extends BasicConfiguration
{     
	Document document;
	Node rootNode;
	
      public ReadConfiguration(){
        super();
        try{
			_document=builder.parse(FILE_PATH);
			rootNode=_document.getChildNodes().item(0);
		}
		catch (SAXException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void showDom(){

    	 System.out.println( getConfiguration().get(0).getAccept());  	  
      }
      
      public ArrayList<WebAttribute> getConfiguration(){
    	  List<WebAttribute> webAttribute =new ArrayList<WebAttribute>();   	  
    	  NodeList websites=rootNode.getChildNodes();
    	  ArrayList<String> RequestHeader=null;
     	  ArrayList<String> regex=null;
     	  
    	  for(int i=1;i<websites.getLength();i=i+2){
    		  WebAttribute listNode=new WebAttribute();
    		  NodeList websitesChildNode=websites.item(i).getChildNodes();
    		  /*------WebsitesName tags--------------*/
    		  listNode.setWebName(getWebSiteName(websites.item(i)));
    		  //System.out.println(listNode.getWebName());
    		  /*-------URL tags------*/
    		  listNode.setURL(getHostURL(websitesChildNode.item(1)));
    		  //System.out.println(listNode.getURl());
    		  /*------parameter tags-------*/
    		  listNode.setParamterIsNull(getParametersStatus(websitesChildNode.item(3), 1));
     		  listNode.setChangeable(getParametersStatus(websitesChildNode.item(3),2));
     		  if(listNode.isParamterIsNull()==false)
     	        listNode.setParameter(getParameter(websitesChildNode.item(3),listNode.isChangeable()));
     		  //System.out.println(listNode.getParameter());
     		  /*-------RequestHeader tags------*/
     		 RequestHeader=getRequestHeader(websitesChildNode.item(5));
     		 listNode.setAccept(RequestHeader.get(0));
     		 listNode.setAccept_Encoding(RequestHeader.get(1));
     		 listNode.setAccept_Language(RequestHeader.get(2));
     		 listNode.setCache_Control(RequestHeader.get(3));
     		 listNode.setConnection(RequestHeader.get(4));
     		 listNode.setHost(RequestHeader.get(5));
     		 listNode.setUser_agent(RequestHeader.get(6));
     		 listNode.setX_Forwarded_For(RequestHeader.get(7));
     		 listNode.setReferer(RequestHeader.get(8));
     		 /*--------Method tags------------*/
     		 listNode.setMethod(getMethod(websitesChildNode.item(7)));
     		 /*--------Regex tags----------*/
     		 regex=getRegex(websitesChildNode.item(9));
     		 listNode.setStockNameRegex(regex.get(0));
     		 listNode.setStockCodeRegex(regex.get(1));
     		 
     		 webAttribute.add(listNode);
    	  }
    	  return (ArrayList<WebAttribute>) webAttribute;
      }
      
      public String getWebSiteName(Node node){
    	  if (node.getNodeType() == Node.ELEMENT_NODE)
    	    return node.getAttributes().getNamedItem("name").getNodeValue();
    	  else
    		return null;
     }
      
      public String getHostURL(Node node){
    	  return node.getTextContent();
     }
      public String getMethod(Node node){
     	 return node.getTextContent();
      }
      
      public boolean getParametersStatus(Node node,int signal){
     	 switch(signal){
     		 case 1:if(node.getAttributes().getNamedItem("status").getNodeValue().equals("1"))
     			       return true;
     		        else
     		           return false;
     		 case 2:if(node.getAttributes().getNamedItem("status").getNodeValue().equals("3"))
     			       return true;
     		        else
     		           return false;
     	 }
 		return false;
      }
      
      public String getParameter(Node node,boolean changeable){
     	 String parameter="?";
     	 NodeList childs=node.getChildNodes();
     	 for(int i=1;i<childs.getLength()-2;i=i+2){
     		 parameter=parameter+childs.item(i).getAttributes().getNamedItem("name").getNodeValue()+"="+childs.item(i).getTextContent()+"&";
     	 }
     	 if(changeable)
       		 parameter=parameter+childs.item(childs.getLength()-2).getAttributes().getNamedItem("name").getNodeValue()+"=";
     	 else
     		 parameter=parameter+childs.item(childs.getLength()-2).getAttributes().getNamedItem("name").getNodeValue()+"="+childs.item(childs.getLength()-1).getNodeValue();
     	 return parameter;
      }
      
      public ArrayList<String> getRequestHeader(Node node){
     	 List<String> requestHeader=new ArrayList<String>();
     	 NodeList childs=node.getChildNodes();
     	 for(int i=1;i<childs.getLength();i=i+2){
     		 String header=childs.item(i).getTextContent();
     		 requestHeader.add(header);
     	 }
     	 return (ArrayList<String>) requestHeader;
      }
      
      public ArrayList<String> getRegex(Node node){
     	 List<String> regex=new ArrayList<String>();
     	 NodeList regexs=node.getChildNodes();
     	 for(int i=1;i<regexs.getLength();i=i+2){
     		 String childRegex=regexs.item(i).getTextContent();
     		 regex.add(childRegex); 
     	 }
     	 return (ArrayList<String>) regex;
      }
}
