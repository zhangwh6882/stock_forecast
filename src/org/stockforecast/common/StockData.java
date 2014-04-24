package org.stockforecast.common;


public abstract class StockData implements Data {
    public String StockId;//股票交易代码
    public String AbstractName;//公司简称
    public String DataType;//数据类型
    public StockType stockType;//股票类型
    public StockData(){
    	super();
    	DataType=this.getClass().getName();
    }
    
    public abstract String ReturnDataType();
    public abstract void setData(String StockId,String StockName);
    
}
