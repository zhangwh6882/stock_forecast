package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;

import javax.xml.transform.TransformerException;

public class SetConfiguration {
	private WriteConfiguration _WC=null;
	public SetConfiguration() throws IOException, TransformerException{
		_WC=new WriteConfiguration();
	}
	public void set(){
	    _WC.setConfiguration();
	}
}
