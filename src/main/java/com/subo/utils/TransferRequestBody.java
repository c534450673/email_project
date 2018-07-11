package com.subo.utils;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TransferRequestBody {
	
	public static final Logger logger = LoggerFactory.getLogger(TransferRequestBody.class);

	public static String transferRequestBodyStream() throws UnsupportedEncodingException{
		
		JSONObject requestJosn=new JSONObject();
		//获取HttpServletRequest对象
		HttpServletRequest request=RequestUtils.getRequest();
		//获取请求body参数
		String params=ServletRequestStore.getParams();
		
		String contentType = request.getContentType();
		
		if (StringUtils.isNotBlank(params)) {
			logger.info("start get params from body........");
			logger.info("use startsWith method");
			if (contentType != null && contentType.startsWith("application/json") && params.startsWith("{")) {
				logger.info("user decode method");
				
				params=params.replace("\"[", "[");
				params=params.replace("]\"", "]");
				
				params=params.replace("\\\"", "\"");
				
				params = URLDecoder.decode(params, "UTF-8");
				requestJosn=JSONObject.fromObject(params);
			} else {
				logger.info("params split and put map");
				for (String str : params.split("&")) {
					String[] value = str.split("=");
					if (value.length == 2) {
						requestJosn.put(value[0], URLDecoder.decode(value[1], "UTF-8"));
					} else if (value.length == 1) {
						requestJosn.put(value[0], "");
					}
				}
			}
		}
		return requestJosn.toString();
	}
	
}
