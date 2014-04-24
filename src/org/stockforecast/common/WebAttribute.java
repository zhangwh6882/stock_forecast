package org.stockforecast.common;

public class WebAttribute {
	   private String  webName=null;
	   private String  URl=null;
	   private boolean changeable=false;
	   private String  parameter=null;
	   private boolean paramterIsNull=false;
	   private  String Accept=null;
	   private  String Accept_Encoding=null;
	   private  String Accept_Language=null;
	   private  String Cache_Control=null;
	   private  String Connection=null;
	   private  String Host=null;
	   private  String User_agent=null;
	   private  String X_Forwarded_For=null;
	   private  String Referer=null;
	   
	   private String  method=null;
	   
	   private String stockNameRegex=null;
	   private String stockCodeRegex=null;
	   

	

	public WebAttribute(){
		   
	   }
	  
	/*--------------------------get attribute part--------------------------*/  
	   public String getWebName() {
		   return webName;
	   }
	   public String getURl() {
		   return URl;
	   }
	   public String getMethod() {
		   return method;
	   }
	   public boolean isChangeable() {
		   return changeable;
	   }
	   public String getParameter() {
		   return parameter;
	   }
	   public boolean isParamterIsNull() {
		   return paramterIsNull;
	   }
	   
	   public String getAccept(){
			return Accept;
	   }
	   public String getAccept_Encoding(){
			return Accept_Encoding;
       }
      
	   public String getCache_Control(){
			return Cache_Control;
	   }
	   
	   public String getAccept_Language(){
			return Accept_Language;
	   }
        
	   public String getConnection(){
			return Connection;
	   } 
	   
	   public String getHost(){
			return Host;
	   }
	   
	   public String getUser_agent(){
			return User_agent;
	   }
	   
	   public String getX_Forwarded_For(){
			return X_Forwarded_For;
	   }
	   public String getReferer(){
			return Referer;
	   }
	   
	   public String getStockNameRegex() {
			  return stockNameRegex;
	   }

	   public String getStockCodeRegex() {
			 return stockCodeRegex;
	   }
	   
	/*--------------------set attribute part------------------------*/   
	   public void setWebName(String webName) {
		   this.webName = webName;
	   }
	   public void setURL(String uRl) {
		   URl = uRl;
	   }
	   public void setMethod(String method) {
		   this.method = method;
	   }
	   public void setChangeable(boolean changeable) {
		   this.changeable = changeable;
	   }
	   public void setParameter(String parameter) {
		   this.parameter = parameter;
	   }
	   public void setParamterIsNull(boolean paramterIsNull) {
		   this.paramterIsNull = paramterIsNull;
	   }
	   public void setAccept(String accept){
			Accept = accept;
	   }
	   public void setAccept_Encoding(String accept_Encoding){
			Accept_Encoding = accept_Encoding;
	   }
       public void setAccept_Language(String accept_Language){
			Accept_Language = accept_Language;
	   }
       public void setCache_Control(String cache_Control){
			Cache_Control = cache_Control;
	   }
       public void setConnection(String connection){
			Connection = connection;
	   }
       public void setHost(String host){
			Host = host;
	   }
       public void setUser_agent(String user_agent){
			User_agent = user_agent;
	   }
       public void setX_Forwarded_For(String x_Forwarded_For){
			X_Forwarded_For = x_Forwarded_For;
	   }
       public void setReferer(String referer){
			Referer = referer;
	   }
       
       public void setStockNameRegex(String stockNameRegex) {
   		    this.stockNameRegex = stockNameRegex;
   	  }

   	  public void setStockCodeRegex(String stockCodeRegex) {
   		  this.stockCodeRegex = stockCodeRegex;
   	  }
	   
}