package org.stockforecast.common;

/**
 * @author huxuehan
 * @version 0.1
 * @since 2014.3.13
 * @see setData()和getData()分别是设置和获得数据
 * */
public interface Data{
	 public enum StockType{
		 STOCK_A,STOCK_B
	 }
	 String ReturnDataType();
	 void setData(String StockId,String StockName);
   
}
