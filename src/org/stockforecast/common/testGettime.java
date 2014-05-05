package org.stockforecast.common;

public class testGettime
{

	public static void main(String[] args) throws InterruptedException
	{
		while(true){
			Thread.sleep(1000);
			System.out.println(new GetTime().getSecond());
		}

	}

}
