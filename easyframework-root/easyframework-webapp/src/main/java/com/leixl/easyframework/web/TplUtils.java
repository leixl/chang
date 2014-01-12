/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-23
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
import static com.leixl.easyframework.web.filter.ProcessTimeFilter.START_TIME;
import static com.leixl.easyframework.web.Constants.RES_PATH;
import static com.leixl.easyframework.common.Constants.UTF8;
import static com.leixl.easyframework.web.Constants.TPLDIR_STYLE_LIST;
import static com.leixl.easyframework.web.Constants.TPLDIR_TAG;
import static com.leixl.easyframework.web.Constants.TPL_STYLE_PAGE_CHANNEL;
import static com.leixl.easyframework.web.Constants.TPL_SUFFIX;
import static com.leixl.easyframework.web.freemarker.DirectiveUtils.PARAM_TPL_SUB;


import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.MessageSource;


import com.leixl.easyframework.web.freemarker.DirectiveUtils;
import com.leixl.easyframework.web.springmvc.MessageResolver;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 *  
 * @author leixl
 * @date   2013-12-23 下午3:59:04
 * @version v1.0
 */
public class TplUtils {
	
	/**
	 * 系统资源路径
	 */
	public static final String RES_SYS = "resSys";
	/**
	 * 模板资源路径
	 */
	public static final String RES_TPL = "res";
	/**
	 * 模板资源表达式
	 */
	public static final String RES_EXP = "${res}";
	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	/**
	 * 页面完整地址
	 */
	public static final String LOCATION = "location";
	/**
	 * 部署路径
	 */
	public static final String APP_SOLUTION = "";
	
	/**
	 * 页码
	 */
	public static final String PAGE_NO = "pageNo";
	/**
	 * 总条数
	 */
	public static final String COUNT = "count";
	/**
	 * 起始条数
	 */
	public static final String FIRST = "first";
	/**
	 * 传入参数，列表样式。
	 */
	public static final String PARAM_STYLE_LIST = "styleList";
	/**
	 * 传入参数，系统预定义翻页。
	 */
	public static final String PARAM_SYS_PAGE = "sysPage";
	/**
	 * 传入参数，用户自定义翻页。
	 */
	public static final String PARAM_USER_PAGE = "userPage";

	/**
	 * 返回页面
	 */
	public static final String RETURN_URL = "returnUrl";
	
	/**
	 * 获得模板路径。不对模板文件进行本地化处理。
	 * 
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。不本地化处理。
	 * @return
	 */
	public static String getTplPath(String dir, String name) {
		return APP_SOLUTION + "/" + dir + "/" + name + TPL_SUFFIX;
	}
	
	/**
	 * 获得模板路径。将对模板文件名称进行本地化处理。
	 * 
	 * @param request
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。本地化处理。
	 * @return
	 */
	public static String getTplPath(HttpServletRequest request,
			String dir, String name) {
		return APP_SOLUTION + "/" + dir + "/"
				+ MessageResolver.getMessage(request, name) + TPL_SUFFIX;
	}
	
	/**
	 * 获得模板路径。将对模板文件名称进行本地化处理。
	 * 
	 * @param messageSource
	 * @param lang
	 *            本地化语言
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。本地化处理。
	 * @return
	 */
	public static String getTplPath(MessageSource messageSource, String lang,
			String solution, String dir, String name) {
		LocaleEditor localeEditor = new LocaleEditor();
		localeEditor.setAsText(lang);
		Locale locale = (Locale) localeEditor.getValue();
		return solution + "/" + dir + "/"
				+ messageSource.getMessage(name, null, locale) + TPL_SUFFIX;
	}
	
	
	/**
	 * 标签中获得页码
	 * 
	 * @param env
	 * @return
	 * @throws TemplateException
	 */
	public static int getPageNo(Environment env) throws TemplateException {
		TemplateModel pageNo = env.getGlobalVariable(PAGE_NO);
		if (pageNo instanceof TemplateNumberModel) {
			return ((TemplateNumberModel) pageNo).getAsNumber().intValue();
		} else {
			throw new TemplateModelException("'" + PAGE_NO
					+ "' not found in DataModel.");
		}
	}

	public static int getFirst(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer first = DirectiveUtils.getInt(FIRST, params);
		if (first == null || first <= 0) {
			return 0;
		} else {
			return first - 1;
		}
	}

	/**
	 * 标签参数中获得条数。
	 * 
	 * @param params
	 * @return 如果不存在，或者小于等于0，或者大于5000则返回5000；否则返回条数。
	 * @throws TemplateException
	 */
	public static int getCount(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer count = DirectiveUtils.getInt(COUNT, params);
		if (count == null || count <= 0 || count >= 5000) {
			return 5000;
		} else {
			return count;
		}
	}

	public static void includePagination(String soltionPath,
			Map<String, TemplateModel> params, Environment env)
			throws TemplateException, IOException {
		String sysPage = DirectiveUtils.getString(PARAM_SYS_PAGE, params);
		String userPage = DirectiveUtils.getString(PARAM_USER_PAGE, params);
		if (!StringUtils.isBlank(sysPage)) {
			String tpl = TPL_STYLE_PAGE_CHANNEL + sysPage + TPL_SUFFIX;
			env.include(tpl, UTF8, true);
		} else if (!StringUtils.isBlank(userPage)) {
			String tpl = getTplPath(TPLDIR_STYLE_LIST,
					userPage);
			env.include(tpl, UTF8, true);
		} else {
			// 没有包含分页
		}
	}

	/**
	 * 标签中包含页面
	 * 
	 * @param tplName
	 * @param site
	 * @param params
	 * @param env
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void includeTpl(String tplName, 
			Map<String, TemplateModel> params, Environment env)
			throws IOException, TemplateException {
		String subTpl = DirectiveUtils.getString(PARAM_TPL_SUB, params);
		String tpl;
		if (StringUtils.isBlank(subTpl)) {
			tpl = getTplPath(TPLDIR_TAG, tplName);
		} else {
			tpl = getTplPath(TPLDIR_TAG, tplName + "_"
					+ subTpl);
		}
		env.include(tpl, UTF8, true);
	}

	/**
	 * 标签中包含用户预定义列表样式模板
	 * 
	 * @param listStyle
	 * @param site
	 * @param env
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void includeTpl(String listStyle, 
			Environment env) throws IOException, TemplateException {
		String tpl = getTplPath(TPLDIR_STYLE_LIST,
				listStyle);
		env.include(tpl, UTF8, true);
	}
	
	
	/**
	 * 为前台模板设置公用数据
	 * 
	 * @param request
	 * @param model
	 */
	public static void frontData(HttpServletRequest request,
			Map<String, Object> map) {
		String location = RequestUtils.getLocation(request);
		Long startTime = (Long) request.getAttribute(START_TIME);
		frontData(map, location, startTime);
	}

	public static void frontData(Map<String, Object> map, String location, Long startTime) {
		if (startTime != null) {
			map.put(START_TIME, startTime);
		}
		String ctx = "";
		map.put(BASE, ctx);
		map.put(RES_SYS, ctx + RES_PATH);
		String res = ctx + RES_PATH + "/" + "www" + "/"
				+ "douban";
		// res路径需要去除第一个字符'/'
		map.put(RES_TPL, res.substring(1));
		map.put(LOCATION, location);
	}
}
