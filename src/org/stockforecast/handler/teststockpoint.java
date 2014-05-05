package org.stockforecast.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.stockforecast.common.GetTime;

public class teststockpoint
{  
   public static void main(String args[]) throws Exception{
	   NetWorkHandler nwh=new NetWorkHandler();
	   HashMap<String,String> map=new HashMap<String,String>();
	   map=nwh.ReturnPoint();
	   for(Entry<String, String> entry:map.entrySet()){
		    ArrayList<String> list=new ArrayList<String>();
		    list.add(entry.getKey());
		    list.add(String.valueOf(GetTime.getYear()));
		    list.add(String.valueOf(GetTime.getMonth()));
		    list.add(String.valueOf(GetTime.getDay()));
		    list.add(GetTime.getHour()+"_"+GetTime.getMinute()+"_"+GetTime.getSecond());
		    list.add(entry.getValue());
		    DataBaseHandler.handler(list);	    		   
	   }
   }
}
