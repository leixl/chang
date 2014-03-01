/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年3月1日
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.ResponseUtils;

import freemarker.template.TemplateException;

/**
 *  
 * @author leixl
 * @date   2014年3月1日 上午10:23:13
 * @version v1.0
 */
@Controller
public class MainBuilderAction extends BaseAction{
	
	@Autowired
	private MainBuilderService service;

	/**
	 * 生成首页
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/doc/movie/o_home.do")
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
}
