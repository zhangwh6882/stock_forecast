package org.stockforecast.stockpoint.configuration;

public interface Configuration
{
	/*目录文件*/
	 public final String FILE_PATH = "conf/configuration.xml";
/*配置文件中的标签名称*/	 
	 public final String HOST_URL = "HostURL";
	 public final String PARAMETER = "Parameter";
	 public final String REQUESTHEADER = "RequestHeader";
	 public final String SENDMETHOD = "SendMethod";
	 public final String WEBSITE = "WebSite";
	 public final String REGEX="Regex";
/*RequestHeader 内容*/	 
	 public final String ACCEPT="Accept";
	 public final String ACCEPT_ENCODING="Accept-Encoding";
	 public final String ACCEPT_LANGUAGE="Accept-Language";
	 public final String CACHE_CONTROL="Cache-Control";
	 public final String CONNECTION="Connection";
	 public final String HOST="Host";
	 public final String USER_AGENT="User-agent";
	 public final String X_FORWARDED_FOR="X-Forwarded-For";
	 public final String REFERER="Referer";
	
}
