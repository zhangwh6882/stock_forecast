package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
    	  NodeList websites=rootNode.getChildNodes();
    	  System.out.println(websites.item(1).getChildNodes().item(0).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(1).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(2).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(3).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(4).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(5).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(6).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(7).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(8).getNodeName());
    	  System.out.println(websites.item(1).getChildNodes().item(9).getNodeName());
    	  
    	  
      }
}
