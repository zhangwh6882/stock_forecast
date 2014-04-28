package org.stockforecast.stockpoint.network;


public class testhttp {

	public static void main(String[] args) throws Exception {
		FetchHttpUrl fetchHttpUrl=new FetchHttpUrl("http://www.szse.cn/szseWeb/FrontController.szse?ACTIONID=7&CATALOGID=1111&TABKEY=tab1&tab1PAGENUM=1");
		fetchHttpUrl.SetMethod("GET");
		fetchHttpUrl.SetRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		fetchHttpUrl.SetRequestHeader("Accept-Encoding", "gzip,deflate,sdch");
		fetchHttpUrl.SetRequestHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		fetchHttpUrl.SetRequestHeader("Cache-Control", "max-age=0");
		fetchHttpUrl.SetRequestHeader("Connection", "keep-alive");
		fetchHttpUrl.SetRequestHeader("Host","www.szse.cn");
		fetchHttpUrl.SetRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");
        String text=fetchHttpUrl.FetchHtmlText("GBK");
        System.out.println(text);

	}

}
