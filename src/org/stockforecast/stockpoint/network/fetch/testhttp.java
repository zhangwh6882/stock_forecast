package org.stockforecast.stockpoint.network.fetch;

import java.io.IOException;

public class testhttp {

	public static void main(String[] args) throws IOException {
		FetchHttpUrl fetchHttpUrl=new FetchHttpUrl("http://query.sse.com.cn/commonQuery.do?jsonCallBack=jsonpCallback90486&isPagination=true&sqlId=COMMON_SSE_ZQPZ_GPLB_MCJS_SSBG_L&pageHelp.pageSize=50&_=1394872168537");
        fetchHttpUrl.SetAccept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        fetchHttpUrl.SetAcceptEncoding("gzip,deflate,sdch");
        fetchHttpUrl.SetAcceptLanguage("en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
        fetchHttpUrl.SetCacheControl("max-age=0");
        fetchHttpUrl.SetConnection("keep-alive");
        fetchHttpUrl.SetHost("query.sse.com.cn");
        fetchHttpUrl.SetXForwardedFor("10.0.0.1");
        fetchHttpUrl.SetReferer("http://www.sse.com.cn/assortment/stock/list/name/");
        fetchHttpUrl.SetUserAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");     
        String  text=fetchHttpUrl.FetchHtmlText("GBK");
        System.out.println(text);
           
        
        ;
	}

}
