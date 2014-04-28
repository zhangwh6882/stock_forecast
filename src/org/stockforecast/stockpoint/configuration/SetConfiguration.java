package org.stockforecast.stockpoint.configuration;

import java.io.IOException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class SetConfiguration {
	private WriteConfiguration _WC=null;
	public SetConfiguration(String choice) throws IOException, TransformerException, SAXException{
		_WC=new WriteConfiguration(choice);
	}
	public void set(){
	    _WC.setConfiguration();
	}
}
