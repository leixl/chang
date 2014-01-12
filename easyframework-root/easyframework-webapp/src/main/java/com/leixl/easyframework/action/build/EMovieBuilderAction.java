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
package com.leixl.easyframework.action.build;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.ResponseUtils;

import freemarker.template.TemplateException;

/**
 *  电影模块 -- 页面静态化处理
 * @author leixl
 * @date   2013-12-23 下午5:07:08
 * @version v1.0
 */
@Controller
public class EMovieBuilderAction extends BaseAction{
	
	@Autowired
	private EMovieBuilderService service;

	@RequestMapping(value = "/doc/movie/v_index.do")
	public String indexInput(HttpServletRequest request, ModelMap model) {
		return "doc/movie/index";
	}

	/**
	 * 生成首页
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/doc/movie/o_index.do")
	public void indexSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			service.index();
			ResponseUtils.renderJson(response, "success");
		} catch (IOException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		} catch (TemplateException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		}
	}
	
	/**
	 * 生成列表页
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/doc/movie/o_list.do")
	public void listSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			service.list();
			ResponseUtils.renderJson(response, "success");
		} catch (IOException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		} catch (TemplateException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		}
	}
	
	
	/**
	 * 生成列表页
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/doc/movie/o_tag.do")
	public void tagIndexSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			service.tag();
			ResponseUtils.renderJson(response, "success");
		} catch (IOException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		} catch (TemplateException e) {
			ResponseUtils.renderJson(response,
					e.getMessage());
		}
	}
}
