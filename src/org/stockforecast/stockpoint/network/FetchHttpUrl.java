package org.stockforecast.stockpoint.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;
/**
 * 获取网页正文
 * 支持部分RequestHeader参数的设置
 * 支持Get和Post方法的设置
 * 支持重定向
 * 返回网页正文为string类型
 * */
public class FetchHttpUrl {
     private  URL url;
     private  HttpURLConnection connection=null;
     private boolean _encode=false;
     public FetchHttpUrl(){
    	 
     }
     public FetchHttpUrl(String url) throws IOException{
    	 this.initialConnection(url);
    	 
     }
     public void initialConnection(String url) throws IOException{
    	 this.url= new URL(url);
    	 connection=(HttpURLConnection)this.url.openConnection();
     }
	 @SuppressWarnings("static-access")
	 public void SetMethod(String Method) throws ProtocolException{
    	 if(Method.equals("POST")){
    		 connection.setDoOutput(true);
    	     connection.setDoInput(true);
    	     connection.setUseCaches(false);
    	 }
    	 connection.setFollowRedirects(true);
    	 connection.setRequestMethod(Method);
     }
	 public void SetRequestHeader(String Header,String Body) throws Exception{
		 switch(Header){
		  case "Accept"          :connection.setRequestProperty("Accept", Body);break;
		  case "Accept-Encoding" :connection.setRequestProperty("Accept-Encoding", Body);break;
		  case "Accept-Language" :connection.setRequestProperty("Accept-Language",Body );break;
		  case "Cache-Control"   :connection.setRequestProperty("Cache-Control",Body);break;
		  case "Connection"      :connection.setRequestProperty("Connection", Body);break;
		  case "Host"            :connection.setRequestProperty("Host", Body);break;
		  case "User-Agent"      :connection.setRequestProperty("User-agent", Body);break;
		  case "X-Forwarded-For" :connection.setRequestProperty("X-Forwarded-For", Body);break;
		  case "Referer"         :connection.setRequestProperty("Referer",Body);break;
		  default: throw new  Exception("没想好");
		 }                		 
	 }
	 public void setEncode(boolean encode){
		 _encode=encode;
	 }
	public String FetchHtmlText(String ContentType) throws IOException{ 
		 BufferedReader reader = null;
    	 String line=null;
    	 String text=null;
    	 connection.connect();
    	 try{
		   if(_encode==true)
    	      reader=new BufferedReader(new InputStreamReader(
    			     new GZIPInputStream(connection.getInputStream()),ContentType
                     ));
		   else{
			  reader=new BufferedReader(new InputStreamReader(
	    			 connection.getInputStream(),ContentType
	                  ));	 
		   }
    	   while((line=reader.readLine())!=null){
    		   text=text+line;
    	   }
    	 }catch (SocketTimeoutException e){
    		 if(_encode==true)
       	      reader=new BufferedReader(new InputStreamReader(
       			     new GZIPInputStream(connection.getInputStream()),ContentType
                        ));
   		     else{
   			    reader=new BufferedReader(new InputStreamReader(
   	    			 connection.getInputStream(),ContentType
   	                  ));	 
   		     }
       	     while((line=reader.readLine())!=null){
       		   text=text+line;
       	     }
    	 }
    	 reader.close();
    	 connection.disconnect();
		 return text;
    }
}
