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
	private final int oneDay=1000*60*60*24;
	private final int oneSecond=1000;
	private final int oneMinute=1000*60;
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
	    timer.schedule(new oneDayTask(), 0, oneDay);	
		
	}
	class oneDayTask extends TimerTask{
		 public void run(){
    	 
		 }
	}
	/*九点到11点半需要做的任务*/
	class amTask extends TimerTask{
		public void run(){
	    	 
		 }
	}
	/*一点到三点需要做的任务*/
	class pmTask extends TimerTask{
		public void run(){
	    	 
		}
	}
}

