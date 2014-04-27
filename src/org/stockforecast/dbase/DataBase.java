package org.stockforecast.dbase;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.stockforecast.common.GetTime;

public final class DataBase implements BasicDB{
	 static{
		 
	 }
	 /*
	  * index 1:股票名称
	  * index 2:股票代码
	  * index 3：股票类型
	  * */
	 public static void InsertSEInfo(ArrayList<String> seInfo){
		 String DBName=GetTime.getYear()+"_"+GetTime.getMonth()+"_"+GetTime.getDay()+"_SSHE";
		 String setSEInfo="Insert into "+DBName+" (StockName,StockCode,StockExchangeType) VALUES(?,?,?)";
		 PreparedStatement ps = null;
		 try {
			  ps=DBHandler.conn.prepareStatement(setSEInfo);
			  ps.setString(1, seInfo.get(0));
			  ps.setString(2, seInfo.get(1));
			  ps.setString(3, seInfo.get(2));
			  DBHandler.sqlupdate(ps);
		 } catch (SQLException e1) {
	     }
	 }
	 
	 public static ArrayList<String> SelectSEInfo() throws SQLException{
		 ArrayList<String> stockCode = new ArrayList<String>();
		 String DBName=GetTime.getYear()+"_"+GetTime.getMonth()+"_"+GetTime.getDay()+"_SSHE";
		 String selectResult="SELECT StockCode FROM "+DBName;
		 PreparedStatement ps = null;
		 ps=DBHandler.conn.prepareStatement(selectResult);
         ResultSet rs=DBHandler.sqlquery(ps);
		 while(rs.next()){
			 String StockCode=rs.getString("StockCode");
			 System.out.println(StockCode);
			 stockCode.add(StockCode);
		 }
		 rs.close(); 
		 return stockCode;
	 }
	 /*
	  * index 1:股票代码
	  * index 2:年
	  * index 3:月
	  * index 4:日
	  * index 5:当前时间
	  * index 6:股票指数
	  * */
	 public static void InsertStockPoint(ArrayList<String> stockPoint){
		 PreparedStatement ps = null;
		 try {
			ps=DBHandler.conn.prepareStatement(_setStockPointInfo);
			ps.setString(1, stockPoint.get(0));
			ps.setString(2, stockPoint.get(1));
			ps.setString(3, stockPoint.get(2));
			ps.setString(4, stockPoint.get(3));
			ps.setString(5, stockPoint.get(4));
			ps.setString(6, stockPoint.get(5));
			DBHandler.sqlupdate(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void SelectStockPoint(){}
}
