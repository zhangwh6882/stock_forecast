package org.stockforecast.stockpoint.network.configuration;

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
	    	System.out.println(WA.getURl());
	    	System.out.println(WA.getAccept());
	     	System.out.println(WA.getWebName());
	    	System.out.println(WA.getMethod());
	    	System.out.println(WA.getParameter());
	    }
	}

}
