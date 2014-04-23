package org.stockforecast.common;

public class WebAttribute {
	   private String  webName;
	   private String  URl;
	   private String  method;
	   private boolean changeable=false;
	   private String  parameter;
	   private boolean paramterIsNull=false;
	   
	   public WebAttribute(){
		   
	   }
	 /*get attribute part*/  
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
	/*set attribute part*/   
	   public void setWebName(String webName) {
		   this.webName = webName;
	   }
	   public void setURl(String uRl) {
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
	   
	   
}