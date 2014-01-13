/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月12日
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.build;

import org.springframework.beans.factory.annotation.Autowired;

import com.leixl.easyframework.common.Constants;
import com.leixl.easyframework.web.springmvc.RealPathResolver;

/**
 *  
 * @author leixl
 * @date   2014年1月12日 上午11:42:56
 * @version v1.0
 */
public abstract class AbstractEMovieBuilder {


	/**
	 * 首页模板名称
	 */
	public static final String TPL_INDEX = "tpl.index";
	
	/**
	 * 列表模板名称
	 */
	public static final String TPL_MOVIE_LIST = "tpl.movie.list";
	
	/**
	 * 标签模板名称
	 */
	public static final String TPL_MOVIE_TAG = "tpl.movie.tag";
	
	
	public static final String LOCATION = "movie";

	/**
	 * 生成静态文件路径
	 * @return
	 */
	public String getIndexPath(String fileName) {
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION);
		pathBuff.append("/").append(fileName).append(
				".html");
		return realPathResolver.get(pathBuff.toString());
	}
	
	public String getListPath(int pageNo){
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION);
		if(pageNo > 1){
			pathBuff.append("/").append(Constants.INDEX).append("_"+pageNo).append(
					".html");
		}else{
			pathBuff.append("/").append(Constants.INDEX).append(
					".html");
		}
		
		return realPathResolver.get(pathBuff.toString());
	}
	
	public String getTagPath(String fileName){
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION);
		pathBuff.append("/").append(fileName).append(
				".html");
		return realPathResolver.get(pathBuff.toString());
	}
	
	@Autowired
	private RealPathResolver realPathResolver;
}
