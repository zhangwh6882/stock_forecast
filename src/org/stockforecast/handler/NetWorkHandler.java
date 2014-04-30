package org.stockforecast.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.TransformerException;

import org.stockforecast.common.WebAttribute;

public class NetWorkHandler
{    public ArrayList<WebAttribute> _wa;
     public NetWorkHandler() throws IOException, TransformerException{
    	_wa=ConfigurationHandler.getWebConfiguration();
     } 
     public HashMap <String,String> ReturnNameAndCode(){
    	 HashMap<String,String> nameAndCode=new HashMap<String,String>();
    	 
    	 return nameAndCode;
     }
     
}
