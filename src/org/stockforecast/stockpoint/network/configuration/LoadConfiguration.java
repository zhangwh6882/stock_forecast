package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;
import java.util.LinkedList;
import org.stockforecast.common.WebAttribute;

public class LoadConfiguration {
    LinkedList<WebAttribute> webAttribute=null;
	private BasicConfiguration configuration=null;
	public LoadConfiguration() throws IOException{
		configuration=new BasicConfiguration();
	}
	public LinkedList<WebAttribute> getWebAttribute(){
	   return webAttribute;
	}
	public void setWebAttribute(){
		webAttribute=configuration.getConfiguration();
	}
	
 }
