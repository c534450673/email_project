package com.subo.configs;

import java.util.logging.Level;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.subo.apis.EmailSend;


/**
 * @author Han Bingjiang
 * @Descrition jersey配置
 * @date:Jun 5, 2017   8:34:18 PM
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
	
	private final String API_PATH = "com.subo.apis";
	private final String FILTER_PATH = "com.subo.handler";

	/**
	 * 配置注册
	 */
	public JerseyConfig() {
		
		register(EmailSend.class);
		
		//添加包扫描地�?
		packages(API_PATH,FILTER_PATH);
		//�?启api请求日志记录
		register(new LoggingFeature(null, Level.INFO, null, null));
		register(JacksonJsonProvider.class);
	}
	
}
