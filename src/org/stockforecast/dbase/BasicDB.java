package org.stockforecast.dbase;

/**
 *数据表1：上海证券交易所股票条数
 *      数据库名称：当天日期+SHSE 
 *      字段：股票名称，股票代码
 *      StockName varchar(50)
 *      StockCode char(6)
 *      StockExchangeType char(4)      
 *数据表3:每天各种股票的数据
 *      数据库名称：STOCK_Point 
 *      字段：股票代码，年，月，日，当天时间（精确到秒），股指
 *      StockCode char(6)
 *      Year      char(4)
 *      Month     char(2)
 *      day       char(2)
 *      clock     char(8)
 *      StockPoint varchar(10)
 **/

public interface BasicDB {
   /*向Stock_Point插入数据*/ 
   public final String _setStockPointInfo="insert into Stock_Point (StockCode,Year,Month,day,clock,StockPoint) values(?,?,?,?,?,?)";
   
   /*证券交易所(SEInfo)数据字段*/
   public final String _seInfoTable="(StockName varchar(50),StockCode char(6),StockExchangeType char(4),primary key(StockCode))";
  
   /*创建数据表与数据库*/
   public final String _createStockPointTable="CREATE TABLE Stock_Point(StockCode char(6),Year char(4),Month char(2),day char(2),clock char(8),StockPoint varchar(10),PRIMARY KEY(StockCode))";
   public final String _createDataBase="CREATE DATABASE StockForecast";
   public final String _useDataBase="USE StockForecast";
  
   /*mysql地址，用户名和密码*/
   public final String _mysqlUrl="jdbc:mysql://localhost:3306/";
   public final String _username="root";
   public final String _passwd="huang19910311@he";
   
   
   
}
