/************************************************************************************
 * @File name   :      RequestListener.java
 *
 * @Author      :      "LiGang"
 *
 * @Date        :      2014-1-16
 *
 * @Copyright Notice: 
 * Copyright (c) 2011 SGM, Inc. All  Rights Reserved.
 * This software is published under the terms of the SGM Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------------
 * Date								Who					Version				Comments
 * 2014-1-16 下午03:53:42			    "LiGang"			1.0				    Initial Version
 ************************************************************************************/
package com.subo.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.subo.ApiApplication;
import com.subo.utils.ServletRequestStore;

/**
 * 功能说明�?
 * 典型用法�?
 * 特殊用法�?
 * 创建者：LiGang
 * 创建时间�?2014-1-16
 */
@WebListener
public class RequestListener implements ServletRequestListener{
	
	Logger logger = LoggerFactory.getLogger(ApiApplication.class); 

	/**
	 * @Author      :      "LiGang"
	 * @Date        :      2014-1-16
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	 * 功能说明�?
	 * overridden:
	 * @Author      :      "LiGang"
	 * @Date        :      2014-1-16
	 * @see javax.servlet.ServletRequestListener#requestInitialized(javax.servlet.ServletRequestEvent)
	**/
	public void requestInitialized(ServletRequestEvent event) {
		final ServletRequest request = event.getServletRequest();
		ServletRequestStore.remove();
		ServletRequestStore.setServletRequest(request);
		
		try {
			request.setCharacterEncoding("UTF-8");
			InputStreamReader isr = new InputStreamReader(request.getInputStream(), "UTF-8");
			BufferedReader os = new BufferedReader(isr);
			int len = request.getContentLength();
			if(len>0){
				StringBuilder params = new StringBuilder();
				String lineStr = null;
				while((lineStr = os.readLine())!=null){
					params.append(lineStr);
				}
				logger.info("request OutputStream: "+params.toString());
				ServletRequestStore.setParams(params.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * 功能说明�?
	 * overridden:
	 * @Author      :      "LiGang"
	 * @Date        :      2014-1-16
	 * @see javax.servlet.ServletRequestListener#requestDestroyed(javax.servlet.ServletRequestEvent)
	**/
	public void requestDestroyed(ServletRequestEvent arg0) {
		
	}
}
