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

import static com.leixl.easyframework.common.Constants.UTF8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.leixl.easyframework.common.Constants;
import com.leixl.easyframework.web.springmvc.RealPathResolver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 *  
 * @author leixl
 * @date   2014年1月12日 上午11:42:56
 * @version v1.0
 */
public abstract class AbstractBuilder {


	/**
	 * 首页模板名称
	 */
	public static final String TPL_INDEX = "tpl.index";
	
	/**
	 * 列表模板名称
	 */
	public static final String TPL_MOVIE_LIST = "tpl.movie.list";
	
	/**
	 * 详情模板名称
	 */
	public static final String TPL_MOVIE_DETAIL = "tpl.movie.detail";
	
	/**
	 * 标签模板名称
	 */
	public static final String TPL_MOVIE_TAG = "tpl.movie.tag";
	
	
	public static final String LOCATION = "movie";
	
	/**
	 * 生成静态文件路径
	 * @return
	 */
	public String getHomePath(String fileName) {
		return realPathResolver.get("index.html");
	}

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
	
	public String getPagerPath(int pageNo){
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION);
			pathBuff.append("/").append(Constants.INDEX).append("_"+pageNo).append(
					".html");
		return realPathResolver.get(pathBuff.toString());
	}
	
	public String getDetailPath(String dateStr,Integer id){
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION).append("/");
		pathBuff.append(dateStr);
			pathBuff.append("/").append(id).append(
					".html");
		return realPathResolver.get(pathBuff.toString());
	}
	
	public String getTagPath(String fileName){
		StringBuilder pathBuff = new StringBuilder();
		pathBuff.append(LOCATION);
		pathBuff.append("/").append(fileName).append(
				".html");
		return realPathResolver.get(pathBuff.toString());
	}
	
	@Transactional(readOnly = true)
	public void build(String tpl,String filePath, Map<String, Object> data)
			throws IOException, TemplateException {
		long time = System.currentTimeMillis();
		File f = new File(filePath);
		File parent = f.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		Writer out = null;
		try {
			// FileWriter不能指定编码确实是个问题，只能用这个代替了。
			out = new OutputStreamWriter(new FileOutputStream(f), UTF8);
			Template template = conf.getTemplate(tpl);
			template.process(data, out);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		time = System.currentTimeMillis() - time;
	}


	private Configuration conf;
	
	@Autowired
	private RealPathResolver realPathResolver;
	
	
	
	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;


	@Autowired
	public void setFreeMarkerConfigurer() {
		this.conf = freemarkerConfig.getConfiguration();
	}
}
