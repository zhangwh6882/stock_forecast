package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.WebAttribute;

public class GetConfiguration {
    List<WebAttribute> webAttribute=null;
    ReadConfiguration RC;
	public GetConfiguration() throws IOException, TransformerException{
		RC=new ReadConfiguration();
	}
	public ArrayList<WebAttribute> getWebAttribute(){
	   return (ArrayList<WebAttribute>) webAttribute;
	}
	public void setWebAttribute(){
		webAttribute=RC.getConfiguration();
	}
	
 }
