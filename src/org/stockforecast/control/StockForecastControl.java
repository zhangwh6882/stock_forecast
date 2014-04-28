package org.stockforecast.control;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.transform.TransformerException;
import org.stockforecast.handler.ConfigurationHandler;
import org.xml.sax.SAXException;

public class StockForecastControl{
	Timer timer;
	Scanner scanner=new Scanner(System.in);
	private final int aDay=1000*60*60*24;
	public StockForecastControl(){
		
	}
	
	public void start(){
		System.out.print("是否需要设置配置文件(Y/N)?：");
		String choice=scanner.nextLine();
		if(choice.equals("Y")||choice.equals("y")){
		  try{
		  	ConfigurationHandler.setWebConfiguration();
		  }
		  catch (IOException | TransformerException | SAXException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	    }
	    timer.schedule(new oneDayTask(), 0, aDay);	
		
	}
	class oneDayTask extends TimerTask{
		 public void run(){
    	 
		 }
	}
	
	class amTask extends TimerTask{
		public void run(){
	    	 
		 }
	}
	
	class pmTask extends TimerTask{
		public void run(){
	    	 
		}
	}
}

