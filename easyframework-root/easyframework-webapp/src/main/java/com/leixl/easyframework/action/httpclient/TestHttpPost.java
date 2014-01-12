/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月10日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *  
 * @author leixl
 * @date   2014年1月10日 下午4:35:49
 * @version v1.0
 */
public class TestHttpPost {
	
	public static final String URL = "http://127.0.0.1:8080/yszx/rest/app/ask/make";

	public static void main(String[] args){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", 1);
		paramMap.put("desc", "撒邓丽君发了的撒件疯狂了电视剧发了的撒减肥了的说了句阿里");
		paramMap.put("payStatus", 1);
		
		//HttpConnUtils.postHttpContent(URL, paramMap);
		
		
		
		//构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(URL);
		// 填入各个表单域的值
		NameValuePair[] data = { new NameValuePair("uid", "1"),
		new NameValuePair("desc", "撒邓丽君发了的撒件疯狂了电视剧发了的撒减肥了的说了句阿里"),
		new NameValuePair("payStatus", "1")};
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		int statusCode;
		try {
			statusCode = httpClient.executeMethod(postMethod);
			if(statusCode == HttpStatus.SC_OK)
			  {
			   StringBuffer contentBuffer = new StringBuffer();
			   InputStream in = postMethod.getResponseBodyAsStream();
			            BufferedReader reader = new BufferedReader(new InputStreamReader(in,postMethod.getResponseCharSet()));
			            String inputLine = null;
			            while((inputLine = reader.readLine()) != null)
			            {
			             contentBuffer.append(inputLine);
			             System.out.println("input line:"+ inputLine);
			             contentBuffer.append("/n");
			            }
			            in.close();

			  }
			  else if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) 
			  {
			      // 从头中取出转向的地址
			      Header locationHeader = postMethod.getResponseHeader("location");
			      String location = null;
			      if (locationHeader != null) 
			      {
			       location = locationHeader.getValue();
			       System.out.println("The page was redirected to:" + location);
			      } 
			      else 
			      {
			       System.err.println("Location field value is null.");
			      }
			  }
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
