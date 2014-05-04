package org.stockforecast.stockpoint.configuration;

import java.io.IOException;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.WebAttribute;
import org.xml.sax.SAXException;

public class testCon {

	public static void main(String[] args) throws IOException, TransformerException, SAXException {
		/*
		SetConfiguration SC= new SetConfiguration();
        SC.set();
        
        ReadConfiguration RC=new ReadConfiguration();
        RC.showDom();
        */
		GetConfiguration LC=new GetConfiguration();
	    for (WebAttribute WA:LC.getWebAttribute()){
	    	if(WA.getAccept_Encoding()==null)
	    		System.out.println("11");
	    }
	    System.out.println("11");
	}

}
