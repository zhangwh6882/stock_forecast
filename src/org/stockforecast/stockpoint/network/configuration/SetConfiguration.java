package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;

import javax.xml.transform.TransformerException;

public class SetConfiguration {
	private BasicConfiguration configuration=null;
	public SetConfiguration() throws IOException, TransformerException{
		configuration=new BasicConfiguration();
	}
	public void set(){
		configuration.SetWebsiteName();
		configuration.setUrl();
		configuration.setParamter();
		configuration.setRequestHeader();
		configuration.setSendMethod();
		configuration.setRegex();

		configuration.WriteConfiguration();
	}
}
