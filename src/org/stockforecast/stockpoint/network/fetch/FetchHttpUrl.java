package org.stockforecast.stockpoint.network.fetch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;
public class FetchHttpUrl {
     private  URL url;
     private  HttpURLConnection connection=null;
     public  BufferedReader reader = null;
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
	 public FetchHttpUrl SetMethod(String Method) throws ProtocolException{
    	 if(Method.equals("POST")){
    		 connection.setDoOutput(true);
    	     connection.setDoInput(true);
    	     connection.setUseCaches(false);
    	 }
    	 connection.setFollowRedirects(true);
    	 connection.setRequestMethod(Method);
    	 return this;
     }
 	 public FetchHttpUrl SetAccept(String Accept){
     	connection.setRequestProperty("Accept", Accept);
     	return this; 	
     }  
	 public FetchHttpUrl SetAcceptEncoding(String AcceptEncoding){
    	 connection.setRequestProperty("Accept-Encoding", AcceptEncoding);
    	 return this;
     }
 	 public FetchHttpUrl SetAcceptLanguage(String AcceptLanguage){
     	connection.setRequestProperty("connections",AcceptLanguage );
     	return this;
     }
	 public FetchHttpUrl SetCacheControl(String CacheConrol){
    	 connection.setRequestProperty("Cache-Control",CacheConrol);
    	 return this;
     }
	 public FetchHttpUrl SetConnection(String Connection){
    	connection.setRequestProperty("Connection", Connection);
    	return this;
     }   
	 public FetchHttpUrl SetHost(String Host){
    	connection.setRequestProperty("Host", Host);
    	return this;
     }
	 public FetchHttpUrl SetUserAgent(String UserAgent){
		 connection.setRequestProperty("User-agent", UserAgent);
   	     return this;
     }
	 public FetchHttpUrl SetXForwardedFor(String XForwardedFor){
    	 connection.setRequestProperty("X-Forwarded-For", XForwardedFor);
         return  this;   
     }
	 public FetchHttpUrl SetReferer(String Referer){
    	 connection.setRequestProperty("Referer",Referer);
    	 return this;
     }
	 public String FetchHtmlText(String ContentType) throws IOException{ 
    	 String line=null;
    	 String text=null;
		 connection.connect();
    	 reader=new BufferedReader(new InputStreamReader(
                 connection.getInputStream(),"UTF-8"));
    	 while((line=reader.readLine())!=null){
    		 text=text+line;
    	 }
    	 reader.close();
		 return text;
    }
}
