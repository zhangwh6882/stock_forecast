package org.stockforecast.stockpoint.network;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 上海证券交易所stockname正则:val2:"(.*?)" stockcode正则:val:"(.*?)"
 * 深圳证券交易所stockname正则："href='http://disclosure.*?u>(.*?)\S/u> stockceod 正则: href="http://www.*?u>(.*?)\S/u>
 * 新浪股票数据接口http://hq.sinajs.cn/list=sh601006
 * 
 * */
public class ParserHtml {
      String  _stockcodeRegex;
      String  _stocknameRegex;
      String  _stockpointRegex;
      String  _htmltext;
      public ParserHtml(String htmltext,String stockcodeRegex,String stocknameRegex){
    	  _htmltext=htmltext;
    	  _stockcodeRegex=stockcodeRegex;
    	  _stocknameRegex=stocknameRegex;
     }
      
      public  ParserHtml(String htmltext,String stockpointRegex){
    	  _htmltext=htmltext;
    	  _stockpointRegex=stockpointRegex;
      }
     public HashMap<String,String> returnStockPoint(){
    	 Pattern prsp=Pattern.compile(_stockpointRegex);	
    	 Matcher mrsp=prsp.matcher(_htmltext);
    	 HashMap<String,String> sbd = new HashMap<String,String>();
    	 while(mrsp.find()){
    		 sbd.put(mrsp.group(1),mrsp.group(2));
    	 }
    	 return sbd; 	 
     }
     
     public Map<String, String> returnMap(String type){
		Map<String,String> nameAndCode=new HashMap<String,String>();
		Pattern psn=Pattern.compile(_stocknameRegex);
		Pattern psc=Pattern.compile(_stockcodeRegex);
		Matcher msn=psn.matcher(_htmltext);
		Matcher msc=psc.matcher(_htmltext);
		while(msn.find()&&msc.find()){
			   if(type.equals("SZSE"))
			       nameAndCode.put(msn.group(1), "sz"+msc.group(1));
			   else if(type.equals("SHSE"))
				   nameAndCode.put(msn.group(1), "sh"+msc.group(1));
			
		}
       return nameAndCode; 
     }
     
}
