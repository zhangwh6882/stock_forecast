package org.stockforecast.dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.stockforecast.common.GetTime;

public final class DBHandler implements BasicDB{
     public static Connection conn;
     static Statement sm;
     static ResultSet rs = null;
     static{
    	 try {
			   conn=DriverManager.getConnection(_mysqlUrl, _username, _passwd);
			   if (!conn.isClosed())
				  System.out.println("Succeeded connecting to the Database!");	
			   sm = conn.createStatement();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public static void useDataBase(){
    	 try {
			sm.executeUpdate(_useDataBase);
		} catch (SQLException e) {
			initDataBase();
			e.printStackTrace();
		}
     }
     public static void initDataBase(){ 
		try {
			 sm.executeUpdate(_createDataBase);
			 useDataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /*Stock_Point 数据表初始化*/
     public static void initSPTable(){
    	 useDataBase();
    	 try{
			 sm.executeUpdate(_createStockPointTable);
    	 }catch (SQLException e) {
    		 e.printStackTrace();
    	 }
     }
     
     public static void initSHSETable(){
    	 String DBName=new GetTime().getYear()+"_"+new GetTime().getMonth()+"_"+new GetTime().getDay()+"_SSHE";
 		 String CreateTable="CREATE TABLE "+DBName+_seInfoTable;
 		 useDataBase();
    	 try {
            sm.executeUpdate(CreateTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
        
     public static ResultSet sqlquery(PreparedStatement ps){
    	 try {
    		useDataBase();
			rs=ps.executeQuery();
		 }  catch (SQLException e) {
			e.printStackTrace();
		 }
    	 return rs;
     }
     
     public static void sqlupdate(PreparedStatement ps){
    	 try {
    		 useDataBase();
    		 ps.executeUpdate();
		 } catch (SQLException e) {	
			 e.printStackTrace();
			/*当出现异常的时候,创建数据表*/
			initSHSETable();
			initSPTable();
			try {
				ps.executeUpdate();
			} catch (SQLException e1) {
				/*当再次出现异常的时候,创建数据库和数据表*/
				initDataBase();
				initSHSETable();
				initSPTable();
				try {
					ps.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
     }  
}
