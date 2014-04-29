package org.stockforecast.handler;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.WebAttribute;

public class NetWorkHandler
{    public ArrayList<WebAttribute> _wa;
     public NetWorkHandler() throws IOException, TransformerException{
    	_wa=ConfigurationHandler.getWebConfiguration();
     } 
     
     
}
