package org.stockforecast.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.transform.TransformerException;
import org.stockforecast.common.GetTime;
import org.stockforecast.handler.ConfigurationHandler;
import org.stockforecast.handler.DataBaseHandler;
import org.stockforecast.handler.NetWorkHandler;
import org.xml.sax.SAXException;

public class StockForecastControl{
	Timer timer;
	Scanner scanner=new Scanner(System.in);
    private final int oneSecond=1000;
	private final int oneMinute=oneSecond*60;
	private final int oneDay=oneMinute*60*24;
	public StockForecastControl(){
		
	}
	
	public void start(){
		timer=new Timer();
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
	    timer.schedule(new oneDayTask(),0, oneDay);
	    //while(true);
	}
	class oneDayTask extends TimerTask{
		 public void run(){
		//	 System.out.println("Time''s up!"); 
			 Calendar now=Calendar.getInstance();
			 Calendar getStockCodeTime=Calendar.getInstance();
			 Calendar getStockPointAM=Calendar.getInstance();
			 Calendar getStockPointPM=Calendar.getInstance();
			 getStockCodeTime.set(Calendar.HOUR_OF_DAY,9);
			// getStockCodeTime.set(Calendar.MINUTE,15);
	         getStockPointAM.set(Calendar.HOUR_OF_DAY,9);
			 getStockPointAM.set(Calendar.MINUTE, 30);
			 getStockPointPM.set(Calendar.HOUR_OF_DAY,13);
			 //getStockPointPM.set(Calendar.MINUTE,57);
			 Timer getStockCodeTimer=new Timer();
			 Timer getStockPointAMTimer=new Timer();
		     Timer getStockPointPMTimer=new Timer();
		     if(new GetTime().getWeekDay()!=Calendar.SUNDAY&&new GetTime().getWeekDay()!=Calendar.SATURDAY){
			    getStockCodeTimer.schedule(new getStockCode(),(getStockCodeTime.getTimeInMillis()-now.getTimeInMillis()));
			    getStockPointAMTimer.schedule(new getStockPoint(),(getStockPointAM.getTimeInMillis()-now.getTimeInMillis()));	 
			    getStockPointPMTimer.schedule(new getStockPoint(),(getStockPointPM.getTimeInMillis()-now.getTimeInMillis()));
		     }
		     else
		        System.out.println("周六周日不开盘");
		 }
	}
	/*八点半左右需要进行的工作*/
	class getStockCode  extends TimerTask {
		public void run(){
			HashMap<String,String> map=new HashMap<String,String>();
			try{
				 NetWorkHandler nwh=new NetWorkHandler();
				 map=nwh.ReturnNameAndCode();
			}catch (Exception e){
				e.printStackTrace();
			}
			for(Entry<String, String> entry:map.entrySet()){
				 if(entry.getValue().startsWith("sz300")||entry.getValue().startsWith("sh600")||
				    entry.getValue().startsWith("sh601")||entry.getValue().startsWith("sh900")||
					entry.getValue().startsWith("sz000")||entry.getValue().startsWith("sz002")||
					entry.getValue().startsWith("sz200")||entry.getValue().startsWith("sh730")){
				         ArrayList<String> list=new ArrayList<String>(3);
				         list.add(entry.getKey());
				         list.add(entry.getValue());
				         list.add("null");
				         DataBaseHandler.handler(list);
				         list=null;
				 }
		     }
			map=null;
			System.out.println(new GetTime().getHour()+":"+new GetTime().getMinute()+":"+new GetTime().getSecond()+"   获取股票代码，完毕");
		}
	}
	/*九点半到11点半需要做的任务,一点到三点需要做的任务*/
	class getStockPoint extends TimerTask{
		public void run(){
	    	 Timer taskPerTwoSecond=new Timer();
	    	 taskPerTwoSecond.schedule(new TimerTask(){
	    		  public void run(){
	    			HashMap<String,String> map = null;
					try{
						 NetWorkHandler nwh = new NetWorkHandler();
		    			 map=nwh.ReturnPoint();
		    			 System.out.println(new GetTime().getHour()+":"+new GetTime().getMinute()+":"+new GetTime().getSecond()+"   获取股票价格，完毕");
					}catch (IOException e){
						e.printStackTrace();
					}catch (TransformerException e){
						e.printStackTrace();
					}catch (Exception e){
						e.printStackTrace();
					}
	    			for(Entry<String, String> entry:map.entrySet()){
	    				  ArrayList<String> list=new ArrayList<String>(6);
	    				  list.add(entry.getKey());
	    				  list.add(String.valueOf(new GetTime().getYear()));
	    				  list.add(String.valueOf(new GetTime().getMonth()));
	    				  list.add(String.valueOf(new GetTime().getDay()));
	    				  list.add(new GetTime().getHour()+":"+new GetTime().getMinute()+":"+new GetTime().getSecond());
	    				  list.add(entry.getValue());
	    				  DataBaseHandler.handler(list);	
	    				  list=null;
	    			   }
	    			map=null;
	    			System.out.println(new GetTime().getHour()+":"+new GetTime().getMinute()+":"+new GetTime().getSecond()+"   插入股票价格，完毕");
	    		  } 
	    	 },0,oneMinute);
	    	 while(true){
				 if(new GetTime().getHour()==11&&new GetTime().getMinute()==30){
					 taskPerTwoSecond.cancel();
				     break;
				 }else if(new GetTime().getHour()==15){
					 taskPerTwoSecond.cancel();
				     break;     
				 }
				 try{
					Thread.sleep(10*oneSecond);
				 }catch (InterruptedException e){
					e.printStackTrace();
				 }
			 }
		}
	}
}
