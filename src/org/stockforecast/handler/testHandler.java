package org.stockforecast.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
	 public static void main(String args[]) throws Exception{
		 NetWorkHandler nwh=new NetWorkHandler();
		 HashMap<String,String> map=new HashMap<String,String>();
		 map=nwh.ReturnNameAndCode();
		 for(Entry<String, String> entry:map.entrySet()){
			 if(entry.getValue().startsWith("sz300")||entry.getValue().startsWith("sh600")||
			    entry.getValue().startsWith("sh601")||entry.getValue().startsWith("sh900")||
				entry.getValue().startsWith("sz000")||entry.getValue().startsWith("sz002")||
				entry.getValue().startsWith("sz200")||entry.getValue().startsWith("sh730")){
			         ArrayList<String> list=new ArrayList<String>();
			         list.add(entry.getKey());
			         list.add(entry.getValue());
			         list.add("null");
			         DataBaseHandler.handler(list);
			 }
	     }
    }
	
}
