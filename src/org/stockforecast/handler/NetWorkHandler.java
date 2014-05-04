package org.stockforecast.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.TransformerException;

import org.stockforecast.common.WebAttribute;
import org.stockforecast.dbase.DataBase;
import org.stockforecast.stockpoint.network.FetchHttpUrl;
import org.stockforecast.stockpoint.network.ParserHtml;

public class NetWorkHandler
{    public ArrayList<WebAttribute> _wa;
     private FetchHttpUrl _fetchHttpUrl;
     public NetWorkHandler() throws IOException, TransformerException{
    	_wa=ConfigurationHandler.getWebConfiguration();
     } 
     public HashMap <String,String> ReturnNameAndCode() throws Exception{
    	 HashMap<String,String> nameAndCode=new HashMap<String,String>();
    	 for(int i=0;i<2;i++){
    		if(_wa.get(i).isParamterIsNull()==true){
    			nameAndCode.putAll(parameterIsNull(i));
    			continue;
    		}
    		if(_wa.get(i).isChangeable()==true){
    			nameAndCode.putAll(parameterIsUnchangeable(i));
    			continue;
    		}
    		else{
    			nameAndCode.putAll(parameterIsChangeable(i));
    			continue;
    		}
    	 }
    	 return nameAndCode;
     }
     public HashMap<String,BigDecimal> ReturnPoint(String StockCode) throws Exception{
    	 ArrayList<String> stockCode=DataBase.SelectSEInfo();
    	 HashMap<String,BigDecimal> codeAndPoint=new HashMap<String,BigDecimal>();
    	 for(int i=0;i<stockCode.size();i++){
    	 String url= _wa.get(2).getURl()+"=sh"+stockCode.get(i);
    	 _fetchHttpUrl=new FetchHttpUrl(url);
    	 _fetchHttpUrl.SetMethod(_wa.get(2).getMethod());
    	 setRequestHeader(2);
    	 String text=_fetchHttpUrl.FetchHtmlText("GBK");
    	 ParserHtml ph=new ParserHtml(text,_wa.get(2).getStockNameRegex());
    	 codeAndPoint.put(stockCode.get(i), ph.returnStockPoint());
     }
          return codeAndPoint;
    	 
     }
     
     private void setRequestHeader(int choice) throws Exception{
    	 if(_wa.get(choice).getAccept()!=null)
    		 _fetchHttpUrl.SetRequestHeader("Accept", _wa.get(choice).getAccept());
         if(_wa.get(choice).getAccept_Encoding()!=null){
        	 _fetchHttpUrl.setEncode(true);
        	 _fetchHttpUrl.SetRequestHeader("Accept-Encoding", _wa.get(choice).getAccept_Encoding());
         }
         else
        	 _fetchHttpUrl.setEncode(false);
         if(_wa.get(choice).getAccept_Language()!=null)
        	 _fetchHttpUrl.SetRequestHeader("Accept-Language", _wa.get(choice).getAccept_Language());
         if(_wa.get(choice).getCache_Control()!=null)
        	 _fetchHttpUrl.SetRequestHeader("Cache-Control", _wa.get(choice).getCache_Control());
         if(_wa.get(choice).getConnection()!=null)
        	 _fetchHttpUrl.SetRequestHeader("Connection", _wa.get(choice).getConnection());
         if(_wa.get(choice).getHost()!=null)
        	 _fetchHttpUrl.SetRequestHeader("Host", _wa.get(choice).getHost());
         if(_wa.get(choice).getReferer()!=null)
        	 _fetchHttpUrl.SetRequestHeader("Referer", _wa.get(choice).getReferer());
         if(_wa.get(choice).getUser_agent()!=null)
        	 _fetchHttpUrl.SetRequestHeader("User-Agent", _wa.get(choice).getUser_agent());
         if(_wa.get(choice).getX_Forwarded_For()!=null)
        	 _fetchHttpUrl.SetRequestHeader("X-Forwarded-For", _wa.get(choice).getX_Forwarded_For());
     }
     
     public HashMap<String,String> parameterIsNull(int index) throws Exception{
		 HashMap<String,String> nameAndCode=new HashMap<String,String>();
		 String url=_wa.get(index).getURl();
		 _fetchHttpUrl=new FetchHttpUrl(url);
		 _fetchHttpUrl.SetMethod(_wa.get(index).getMethod());
		 setRequestHeader(index);
		 String text=_fetchHttpUrl.FetchHtmlText("UTF-8");
		 ParserHtml ph=new ParserHtml(text,_wa.get(index).getStockCodeRegex(),_wa.get(index).getStockNameRegex());
		 nameAndCode.putAll(ph.returnMap());
    	 return nameAndCode;
    	 
     }
     public HashMap<String,String> parameterIsUnchangeable(int index) throws Exception{
    	 HashMap<String,String> nameAndCode=new HashMap<String,String>();
    	 String url=_wa.get(index).getURl()+_wa.get(index).getParameter();
    	 _fetchHttpUrl=new FetchHttpUrl(url);
		 _fetchHttpUrl.SetMethod(_wa.get(index).getMethod());
		 setRequestHeader(index);
		 String text=_fetchHttpUrl.FetchHtmlText("UTF-8");
		 ParserHtml ph=new ParserHtml(text,_wa.get(index).getStockCodeRegex(),_wa.get(index).getStockNameRegex());
		 nameAndCode.putAll(ph.returnMap());
    	 return null;
		
    	 
     }
     public HashMap<String,String> parameterIsChangeable(int index){
		return null;
    	 
     }
}
