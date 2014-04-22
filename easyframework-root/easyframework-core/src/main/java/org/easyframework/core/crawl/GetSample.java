/**
 * Project: easyframework-core
 * 
 * File Created at 2014年3月29日
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package org.easyframework.core.crawl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetSample {

	public static String RESPONSE_TEXT = "responseText";
	public static String CHARSET = "charset";

	public static void main(String[] args) {
		String result = get(
				"http://item.taobao.com/item.htm?spm=a1z10.1.w5003-5248687655.2.Jda0US&id=37543958237&scene=taobao_shop")
				.get(GetSample.RESPONSE_TEXT);
		
		System.out.println(result);
	}

	public static Map<String, String> get(String url) {
		Map<String, String> result = new HashMap<String, String>();
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
		new DefaultHttpMethodRetryHandler(3, false));
		try {
			int statusCode = client.executeMethod(method);
			String charset = method.getResponseCharSet();
			method.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
			byte[] responseBody = method.getResponseBody();
			result.put(GetSample.RESPONSE_TEXT, new String(responseBody,
					charset));
			result.put(GetSample.CHARSET, charset);
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			method.releaseConnection();
			return result;
		}

	}
}
