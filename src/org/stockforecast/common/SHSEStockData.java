package org.stockforecast.common;

/**@author huxuehan
 * @version 0.1
 * 上海证券交易所股票数据信息
 * http://www.sse.com.cn/js/common/ssesuggestdata.js股票
 * http://www.sse.com.cn/js/common/ssesuggestfunddata.js基金
 * http://www.sse.com.cn/js/common/ssesuggestTbonddata.js国债
 * http://www.sse.com.cn/js/common/ssesuggestdataAll.js所有数据
 * A股6开头B股9开头
 * 上海证券交易所股票数据：股票交易代码，股票名称，公司全称，所属行业，公司网页
 * */

public class SHSEStockData extends StockData {
       
	 public SHSEStockData(){
    	   super();
     }
	 public SHSEStockData(String StockId,String AbstractName){
		   this();
		   this.setData(StockId, AbstractName);
	 }
	 @Override
	 public String ReturnDataType() {
		return DataType;
	 }
	@Override
	public void setData(String StockId, String AbstractName) {
		if(StockId.charAt(0)=='6')
			 stockType=StockType.STOCK_A;
		 else if(StockId.charAt(0)=='9')
			 stockType=StockType.STOCK_B; 
		 this.StockId=StockId;
		 this.AbstractName=AbstractName;		
	}
}

