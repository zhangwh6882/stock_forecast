package org.stockforecast.dbase;

import java.sql.SQLException;
import java.util.ArrayList;

public class testdbase
{
    public static void main(String args[]) throws SQLException{
    	ArrayList<String> seInfo=new ArrayList<String>();
    /*
     *  seInfo.add("bbddbb");
    	seInfo.add("cbcccc");
    	seInfo.add("bbbb");
    	DataBase.InsertSEInfo(seInfo);
     	System.out.println(GetTime.getYear()+"_"+GetTime.getMonth()+"_"+GetTime.getDay()+"_"+GetTime.getHour()+"_"+GetTime.getMinute());
     */
     //  seInfo=DataBase.SelectSEInfo();
    	seInfo.add("211111");
    	seInfo.add("1111");
    	seInfo.add("11");
    	seInfo.add("11");
    	seInfo.add("11111111");
    	seInfo.add("2003.11");
    	DataBase.InsertStockPoint(seInfo);
    }
}
