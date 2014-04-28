package org.stockforecast.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

import org.stockforecast.common.WebAttribute;

/**
 * 1 运行程序时先设置配置文件
   2 设置好配置文件之后存储配置文件
   3 从配置文件中读取（三个）配置信息并且传递给handler
   4 handler根据配置信息调用fetch 抓取前两个网址信息
   5 从fetch中获取的结果传递给parser
   6 得到的数据存储到数据库中
   7 从数据库中获得stockcode，并根据stock获得fetch的url
               重复上述步骤 5，6

 */
public class testHandler
{
	
	 public static void main(String args[]) throws SQLException, IOException, TransformerException{
	    	System.out.println("1111");
		    ArrayList<String> seInfo=new ArrayList<String>();
	    	ArrayList<WebAttribute> wa=ConfigurationHandler.get();
	    	System.out.println(wa.get(1).getStockNameRegex());
	    	
	    	
	    /*
	     *  seInfo.add("bbddbb");
	    	seInfo.add("cbcccc");
	    	seInfo.add("bbbb");
	    	DataBase.InsertSEInfo(seInfo);
	     	System.out.println(GetTime.getYear()+"_"+GetTime.getMonth()+"_"+GetTime.getDay()+"_"+GetTime.getHour()+"_"+GetTime.getMinute());
	     */
	     //  seInfo=DataBase.SelectSEInfo();
	    /*	seInfo.add("241911");
	    	seInfo.add("1111");
	    	seInfo.add("11");
	    	seInfo.add("11");
	    	seInfo.add("11111111");
	    	seInfo.add("2003.11");
	    	DataBaseHandler.handler(seInfo);*/
	    	
	    }
}
