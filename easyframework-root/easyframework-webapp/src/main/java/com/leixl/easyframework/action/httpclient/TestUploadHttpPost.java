/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月11日
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

import java.util.HashMap;
import java.util.Map;

/**
 *  
 * @author leixl
 * @date   2014年1月11日 下午3:22:41
 * @version v1.0
 */

public class TestUploadHttpPost {

	public static final String URL = "http://127.0.0.1/rest/app/ask/make";
	
	public static void main(String[] args){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", 1);
		paramMap.put("desc", "撒邓丽君发了的撒件疯狂了电视剧发了的撒减肥了的说了句阿里");
		paramMap.put("payStatus", 1);
		
		HttpConnUtils.postHttpContent(URL, paramMap);
	}
}
