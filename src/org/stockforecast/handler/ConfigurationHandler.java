package org.stockforecast.handler;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.WebAttribute;
import org.stockforecast.stockpoint.configuration.GetConfiguration;
import org.stockforecast.stockpoint.configuration.SetConfiguration;
import org.xml.sax.SAXException;

public final class ConfigurationHandler
{
     static{   	
     }  
     public static void set(String choice) throws IOException, TransformerException, SAXException{
    	 SetConfiguration sc=new SetConfiguration(choice);
    	 sc.set();
     }
     
     public static ArrayList<WebAttribute> get() throws IOException, TransformerException{
    	 ArrayList<WebAttribute> wa=null;
    	 GetConfiguration gc=new GetConfiguration();
    	 wa=gc.getWebAttribute(); 
    	 return wa;
    	 
     }
     
     public static void setWebConfiguration() throws IOException, TransformerException, SAXException{
    	 System.out.println("-------------输入上海证券交易所网站配置信息--------------");
    	 set("new");
 		 System.out.println("-------------输入深圳证券交易所网站配置信息--------------");
 		 set("append");
 		 System.out.println("---------------输入新浪证券网站配置信息----------------");
 		 set("append");
     }
}
