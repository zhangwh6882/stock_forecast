package org.stockforecast.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
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
    private final int oneSecond=1000;
	private final int oneMinute=oneSecond*60;
	private final int oneDay=oneMinute*60*24;
	HashMap<String,String> map = null;
	ArrayList<String> stockCode=null;
	public StockForecastControl(){
		
	}
	public void configurationControl(){
		  try{
		  	ConfigurationHandler.setWebConfiguration();
		  }catch (IOException | TransformerException | SAXException e){
			e.printStackTrace();
		  }
	}
	public void runnableControl(){
		timer=new Timer();	
	    timer.schedule(new oneDayTask(),0, oneDay);
	}
	class oneDayTask extends TimerTask{
		 public void run(){ 
			 Calendar now=Calendar.getInstance();
			 Calendar getStockCodeTime=Calendar.getInstance();
			 Calendar getStockPointAM=Calendar.getInstance();
			 Calendar getStockPointPM=Calendar.getInstance();
			 getStockCodeTime.set(Calendar.HOUR_OF_DAY,1);
			 //getStockCodeTime.set(Calendar.MINUTE,49);
	         getStockPointAM.set(Calendar.HOUR_OF_DAY,1);
			 getStockPointAM.set(Calendar.MINUTE,30);
			 getStockPointPM.set(Calendar.HOUR_OF_DAY,5);
			 //getStockPointPM.set(Calendar.MINUTE,20);
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
	    	 try{
				stockCode=DataBaseHandler.handler();
			 }catch (SQLException e1){
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 }
	    	taskPerTwoSecond.schedule(new TimerTask(){
	    		public void run(){
	    		  try{
	  				  NetWorkHandler nwh = new NetWorkHandler();
	  	    		  map=nwh.ReturnPoint(stockCode);
	  	    		  System.out.println(new GetTime().getHour()+":"+new GetTime().getMinute()+":"+new GetTime().getSecond()+"   获取股票价格，完毕");
	  			  }catch ( Exception e ){
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
				 if(new GetTime().getHour()==3&&new GetTime().getMinute()==30){
					 taskPerTwoSecond.cancel();
				     break;
				 }else if(new GetTime().getHour()==7){
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
