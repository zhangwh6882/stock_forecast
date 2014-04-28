package org.stockforecast.stockpoint.network;

import java.io.IOException;

public class testhttp {

	public static void main(String[] args) throws IOException {
		FetchHttpUrl fetchHttpUrl=new FetchHttpUrl("http://query.sse.com.cn/commonQuery.do?jsonCallBack=jsonpCallback90486&isPagination=true&sqlId=COMMON_SSE_ZQPZ_GPLB_MCJS_SSBG_L&pageHelp.pageSize=50&_=1394872168537");
        String  text=fetchHttpUrl.FetchHtmlText("GBK");
        System.out.println(text);
	}

}
