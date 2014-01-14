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
package com.leixl.easyframework.action.admin.doc;

import static org.easyframework.core.pager.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.common.StrUtils;
import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.service.EMovieService;
import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.CookieUtils;
import com.leixl.easyframework.web.springmvc.MessageResolver;

/**
 *  
 * @author leixl
 * @date   2013-12-23 上午10:29:56
 * @version v1.0
 */
@Controller
public class EMovieAction extends BaseAction{

	@Autowired
	private EMovieService service;
	
	@RequestMapping("/doc/movie/v_list.do")
	public String list(String queryName,Boolean queryDisabled, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = service.getPage(queryName, queryDisabled, 
				cpn(pageNo),CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);
		model.addAttribute("queryName", queryName);
		model.addAttribute("queryDisabled", queryDisabled);
		return "doc/movie/list";
	}
	
	@RequestMapping("/doc/movie/v_add.do")
	public String add(){
		return "doc/movie/add";
	}
	
	@RequestMapping(value = "/doc/movie/o_save.do")
	public String save(EMovie bean ,String tagStr, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String[] tagArr = StrUtils.splitAndTrim(tagStr, ",", MessageResolver
				.getMessage(request, "tagStr.split"));
		service.save(bean,tagArr);
		write(response,"success");
		return null;
	}
	
	@RequestMapping("/doc/movie/v_edit.do")
	public String edit(Integer id, ModelMap model){
		model.addAttribute("movie", service.getById(id));
		return "doc/movie/edit";
	}
	
	@RequestMapping(value = "/doc/movie/o_update.do")
	public String update(EMovie bean ,String tagStr, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String[] tagArr = StrUtils.splitAndTrim(tagStr, ",", MessageResolver
				.getMessage(request, "tagStr.split"));
		service.update(bean,tagArr);
		write(response,"success");
		return null;
	}
}
