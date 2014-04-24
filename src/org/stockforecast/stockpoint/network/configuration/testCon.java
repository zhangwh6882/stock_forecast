package org.stockforecast.stockpoint.network.configuration;

import java.io.IOException;

import javax.xml.transform.TransformerException;

public class testCon {

	public static void main(String[] args) throws IOException, TransformerException {
	//	SetConfiguration SC= new SetConfiguration();
   //     SC.set();
	LoadConfiguration LC=new LoadConfiguration();
	 LC.setWebAttribute();
	 System.out.println(LC.getWebAttribute());
	}

}
