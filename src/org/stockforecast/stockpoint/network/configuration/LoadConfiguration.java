package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;

import org.stockforecast.common.WebAttribute;

public class LoadConfiguration {
	WebAttribute webAttribute=null;
	private BasicConfiguration configuration=null;
	public LoadConfiguration() throws IOException{
		configuration=new BasicConfiguration();
	}
	public WebAttribute getWebAttribute(){
	   return webAttribute;
	}
	public void setWebAttribute(){
		
	}
	
 }
