package org.stockforecast.stockpoint.network;

import java.util.ArrayList;
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
      Pattern _pattern; 
      Matcher _matcher;
      String _htmltext;
      public ParserHtml(String htmltext,String stockcodeRegex,String stocknameRegex){
    	  _htmltext=htmltext;
    	  _stockcodeRegex=stockcodeRegex;
    	  _stocknameRegex=stocknameRegex;
     }
     public ArrayList<String> returnStockName(){
		return null;
    	 
     }
     
     public ArrayList<String> returnStockCode(){
		return null;
    	 
     }
     
}
