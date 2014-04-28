package org.stockforecast.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import org.stockforecast.dbase.DataBase;

public final class DataBaseHandler
{
    static{
    	
    }
    public static void handler(ArrayList<String> list){
    	int choice=list.size();
    	switch(choice){
    		case 3:DataBase.InsertSEInfo(list);break;
    		case 6:DataBase.InsertStockPoint(list);break;
    		default :break;
    	}
    }
    
    public static ArrayList<String> handler() throws SQLException{
    	ArrayList<String> stocklist=null;
    	stocklist=DataBase.SelectSEInfo();
    	return stocklist;
    }
    
    
}
