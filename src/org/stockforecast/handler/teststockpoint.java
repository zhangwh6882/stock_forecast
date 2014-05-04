package org.stockforecast.handler;

import java.util.HashMap;
import java.util.Map.Entry;

public class teststockpoint
{  
   public static void main(String args[]) throws Exception{
	   NetWorkHandler nwh=new NetWorkHandler();
	   HashMap<String,String> map=new HashMap<String,String>();
	   map=nwh.ReturnPoint();
	   int i=0;
	   for(Entry<String, String> entry:map.entrySet()){
		    System.out.println(entry.getKey()+":"+entry.getValue());
			   i++;
		   
	   }
	   System.out.println(i);  
   }
}
