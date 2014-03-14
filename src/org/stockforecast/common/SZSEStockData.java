package org.stockforecast.common;

/**
 *深圳证券交易所股票数据
 * http://www.szse.cn/szseWeb/FrontController.szse?ACTIONID=7&CATALOGID=1111&TABKEY=tab4&tab1PAGENUM=1
 * */
public class SZSEStockData extends StockData {
     public String CompanyName;//公司全称
     public String CompanyUrl;//所属行业
     public String Industry; //公司网址
     public SZSEStockData(){
    	 super();
     }
     public SZSEStockData(String StockId,String AbstractName){
    	 this();
    	 this.setData(StockId, AbstractName);	 
     }
     public SZSEStockData(String StockId,String AbstractName,String CompanyName,String CompanyUrl, String Industry){
        this();
        this.setData(StockId, AbstractName, CompanyName, CompanyUrl, Industry);
     }
     //设置类的值
     @Override
     public void setData(String StockId,String AbstractName){
    	 if(StockId.charAt(0)=='2')
    		 stockType=StockType.STOCK_A;
    	 else 
    	     stockType=StockType.STOCK_B;
    	 this.AbstractName=AbstractName;
    	 this.StockId=StockId;		
     }
     
     public void setData(String StockId,String AbstractName,String CompanyName,String CompanyUrl,String Industry){
    	 this.setData(StockId, AbstractName);
    	 this.CompanyName=CompanyName;
    	 this.Industry=Industry;
    	 this.CompanyUrl=CompanyUrl;
     }
     
     public String ReturnDataType() {
 		return DataType;
 	}
	
     
}
