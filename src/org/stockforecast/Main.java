package org.stockforecast;

import org.stockforecast.control.StockForecastControl;

public class Main {
     public static void main(String args[]){
    	 StockForecastControl sfc=new StockForecastControl();	
    	 if(args.length==0){
    		 System.out.println("Description");
    		 System.out.println("add -run :Start to get stock point");
    		 System.out.println("add -conf:Start to set configuration file in this program");
    		 System.out.println("version 0.1 in 2014");
    		 return;
    	 }else if(args[0].equals("-conf")){
    		 sfc.configurationControl();
    	 }else if(args[0].equals("-run")){
    		 sfc.runnableControl();
    	 }
     }
}
