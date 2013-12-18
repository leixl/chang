/*
 * @(#)WebUtil.java 2011-5-9上午09:28:44
 * Copyright 2012 juncsoft, Inc. All rights reserved.
 */
package com.leixl.easyframework.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web工具类
 * @modificationHistory.  
 * <ul>
 * <li>sunju 2011-5-9上午09:28:44 TODO</li>
 * </ul> 
 */
@SuppressWarnings("unchecked")
public class WebUtil {
	/**
	 * 获得真实IP地址
	 * @author sunju
	 * @param request 请求
	 * @creationDate. 2011-5-9 上午09:14:17 
	 * @return 真实IP地址
	 * @throws Exception 
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = request.getHeader("Proxy-Client-IP");
		}     
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
		    ip = request.getRemoteAddr();
		}
		if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) { // IPv4和IPv6的localhost
			// 客户端和服务端是在同一台机器上、获取本机的IP
			InetAddress inet = InetAddress.getLocalHost();
			ip = inet.getHostAddress();
		}
		return ip;
	}
	/**
	 * 获得Mac地址
	 * JDK1.6新特性
	 * @author sunju
	 * @creationDate. 2012-8-23 下午06:19:49 
	 * @return Mac地址
	 * @throws Exception
	 */
	public static String getMacAddr() throws Exception {
		Enumeration<NetworkInterface> el = NetworkInterface.getNetworkInterfaces();
		while (el.hasMoreElements()) {
			byte[] mac = el.nextElement().getHardwareAddress();
			if (mac == null || mac.length == 0) continue;
	        StringBuilder builder = new StringBuilder();
	        for (byte b : mac) {
	          builder.append(hexByte(b));
	          builder.append("-");
	        }
	        builder.deleteCharAt(builder.length() - 1);
	        return builder.toString();
		}
		return null;
	}
	/**
	 * 获得请求URL
	 * @author sunju
	 * @creationDate. 2011-5-10 下午06:39:11 
	 * @param request 请求
	 * @return 请求URL
	 */
	public static String getRequestURL(HttpServletRequest request) {
		StringBuilder url = new StringBuilder(request.getRequestURI());
		Map<String, String[]> parameterMap = request.getParameterMap();
		String key = null;
		String[] value = null;
		if (parameterMap != null && parameterMap.size() > 0) {
			url.append("?");
			for(Iterator<?> it = parameterMap.keySet().iterator(); it.hasNext(); ) {
				key = (String)it.next();
				value = parameterMap.get(key);
				if (value != null && value.length > 0) {
					for (String val : value) {
						url.append(key).append("=").append(val).append("&");
					}
				}
			}
			url.delete(url.length() - 1, url.length());
		}
		return url.toString();
	}
	/**
	 * 获得完全路径
	 * @author sunju
	 * @creationDate. 2012-7-5 下午10:08:02 
	 * @param request 请求
	 * @return 完全路径
	 */
	public static String getBasePath(HttpServletRequest request) {
		int port = request.getServerPort();
		return request.getScheme() + "://" + request.getServerName()
					+ ((port == 80) ? "" : (":" + port)) + request.getContextPath() + "/";
	}
	/**
	 * 是否为Ajax请求
	 * @author sunju
	 * @creationDate. 2011-8-24 下午08:46:46 
	 * @param request 请求
	 * @return 布尔
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		return (request.getHeader("x-requested-with") == null) ? false : true;
	}
	/**
	 * 向客户端输出
	 * @author sunju
	 * @creationDate. 2010-9-18 上午12:19:16 
	 * @response 响应对象
	 * @param outObj 输出的Object
	 * @param outEncoding 输出编码
	 * @throws IOException 
	 */
	public static void write(HttpServletResponse response, Object outObj, String outEncoding){
		// 设置默认响应类型
		if (response.getContentType() == null) response.setContentType("text/html");
		response.setCharacterEncoding(outEncoding);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			out.print(outObj);
			out.flush();
			out.close();
		}
		
	}
	/**
	 * 返回一个字节的十六进制字符串
	 * @author sunju
	 * @creationDate. 2012-8-23 下午06:18:25 
	 * @param b 字节
	 * @return 十六进制字符串
	 */
	private static String hexByte(byte b) {
		String s = "000000" + Integer.toHexString(b);
		return s.substring(s.length() - 2);
	}
	/**
	 * 测试main函数
	 * @author sunju
	 * @creationDate. 2012-8-23 下午06:20:50 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(getMacAddr());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
