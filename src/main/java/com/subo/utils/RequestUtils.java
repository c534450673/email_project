/************************************************************************************
 * @File name   :      RequestUtils.java
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
 * 2014-1-16 下午03:55:45			    "LiGang"			1.0				    Initial Version
 ************************************************************************************/
package com.subo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能说明：
 * 典型用法：
 * 特殊用法：
 * 创建者：LiGang
 * 创建时间：2014-1-16
 */
public abstract class RequestUtils {

	/**
	 * 
	 * 功能说明：
	 * @Author      :      "LiGang"
	 * @Date        :      2014-1-16
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		final HttpServletRequest request = (HttpServletRequest) ServletRequestStore.getServletRequest();
		return request;
	}
}
