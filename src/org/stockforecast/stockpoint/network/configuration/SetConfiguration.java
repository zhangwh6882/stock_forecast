package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;

public class SetConfiguration {
	private BasicConfiguration configuration=null;
	public SetConfiguration() throws IOException{
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
