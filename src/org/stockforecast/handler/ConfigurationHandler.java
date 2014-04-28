package org.stockforecast.handler;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.WebAttribute;
import org.stockforecast.stockpoint.configuration.GetConfiguration;
import org.stockforecast.stockpoint.configuration.SetConfiguration;
import org.xml.sax.SAXException;

public class ConfigurationHandler
{
	SetConfiguration sc=null;
	GetConfiguration gc=null;
     public ConfigurationHandler(){
    	
     }
     
     public void set() throws IOException, TransformerException, SAXException{
    	 sc=new SetConfiguration("new");
    	 sc.set();
     }
     
     public ArrayList<WebAttribute> get() throws IOException, TransformerException{
    	 ArrayList<WebAttribute> wa=null;
    	 gc=new GetConfiguration();
    	 wa=gc.getWebAttribute(); 
    	 return wa;
    	 
     }
}
