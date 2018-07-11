package com.subo.utils;

import javax.servlet.ServletRequest;

/**
 * 
 * ����˵����
 * �����÷���
 * �����÷���
 */
public class ServletRequestStore {

    private final static ThreadLocal<ServletRequest> servletRequests = new ThreadLocal<ServletRequest>();

    private final static ThreadLocal<String> params = new ThreadLocal<String>();
    
    private final static ThreadLocal<byte[]> files = new ThreadLocal<byte[]>();
    
    public static void remove(){
    	servletRequests.remove();
    	params.remove();
    	files.remove();
    }
    
    public static void setServletRequest(ServletRequest request) {
        servletRequests.set(request);
    }

    public static ServletRequest getServletRequest() {
        return servletRequests.get();
    }
    
    public static void setParams(String parms){
    	params.set(parms);
    }
    
    public static String getParams(){
    	return params.get();
    }

	public static byte[] getFileByte() {
		return files.get();
	}
	
	public static void setFileByte(byte[] fileByte) {
		files.set(fileByte);
	}

}