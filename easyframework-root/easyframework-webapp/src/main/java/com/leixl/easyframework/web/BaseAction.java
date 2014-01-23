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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	protected String parseKeywords(String q){
		char c='\\';
		int cIndex=q.indexOf(c);
		if(cIndex!=-1&&cIndex==0){
			q=q.substring(1);
		}
		if(cIndex!=-1&&cIndex==q.length()-1){
			q=q.substring(0,q.length()-1);
		}
		try {
			String regular = "[\\+\\-\\&\\|\\!\\(\\)\\{\\}\\[\\]\\^\\~\\*\\?\\:\\\\]";
			Pattern p = Pattern.compile(regular);
			Matcher m = p.matcher(q);
			String src = null;
			while (m.find()) {
				src = m.group();
				q = q.replaceAll("\\" + src, ("\\\\" + src));
			}
			q = q.replaceAll("AND", "and").replaceAll("OR", "or").replace("NOT", "not");
		} catch (Exception e) {
			q=q;
		}
		return  q;
	}
	
}
