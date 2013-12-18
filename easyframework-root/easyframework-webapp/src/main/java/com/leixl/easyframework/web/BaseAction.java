/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-12
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 *  
 * @author leixl
 * @date   2013-12-12 下午11:56:31
 * @version v1.0
 */
public abstract class BaseAction {

	public static final String SYSTEM_DEFAULT_ENCODING = "UTF-8";

	/**
	 * 向客户端输出
	 * 
	 * @author sunju
	 * @creationDate. 2010-9-18 上午12:19:16
	 * @param obj
	 *            object对象
	 * @throws IOException
	 */
	protected void write(HttpServletResponse response,Object obj){
		WebUtil.write(response, obj,SYSTEM_DEFAULT_ENCODING);
	}
	
	
}
