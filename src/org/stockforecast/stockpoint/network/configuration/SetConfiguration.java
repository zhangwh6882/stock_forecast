package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class SetConfiguration {
	private WriteConfiguration _WC=null;
	public SetConfiguration() throws IOException, TransformerException, SAXException{
		_WC=new WriteConfiguration("append");
	}
	public void set(){
	    _WC.setConfiguration();
	}
}
