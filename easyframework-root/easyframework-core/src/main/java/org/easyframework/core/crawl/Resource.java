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

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月29日 下午10:18:41
 * @version v1.0
 */
public class Resource {

	/**
	  * 需要获取资源的目标地址，不包含查询串
	  */
	 private String target;
	  /**
	  * get请求时的查询串，或post请求的请求数据
	  */
	 private String queryData = "";
	 
	 /**
	  * 请求方式，get / post
	  */
	 private String method = "GET";
	 
	 /**
	  * 返回的数据的编码类型
	  */
	 private String charset = "GBK";
	 
	 /**
	  * 抓取数据的模式，将根据模式的分组来返回数据列表
	  */
	 private String pattern;

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the queryData
	 */
	public String getQueryData() {
		return queryData;
	}

	/**
	 * @param queryData the queryData to set
	 */
	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * @param charset the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	 
	 
}
