package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;
import java.util.Scanner;

public class SetConfiguration {
	private BasicConfiguration configuration=null;
	public SetConfiguration() throws IOException{
		configuration=new BasicConfiguration();
	}
	public void set(){
		configuration.SetWebsiteName();
		configuration.setUrl();
		configuration.setRequestHeader();
		configuration.setRegex();
		
		configuration.WriteConfiguration();
	}
	
	
	
	
}
