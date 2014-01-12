/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月8日
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

import com.leixl.easyframework.doc.entity.EMovie;
import com.leixl.easyframework.doc.entity.EMovieTag;
import com.leixl.easyframework.doc.service.EMovieTagService;
import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.CookieUtils;

/**
 *  
 * @author leixl
 * @date   2014年1月8日 下午4:01:18
 * @version v1.0
 */
@Controller
public class EMovieTagAction extends BaseAction {

	@Autowired
	private EMovieTagService service;
	
	@RequestMapping("/doc/movietag/v_list.do")
	public String list(Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = service.getPage(cpn(pageNo),CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);
		return "doc/movietag/list";
	}
	
	@RequestMapping("/doc/movietag/v_add.do")
	public String add(){
		return "doc/movietag/add";
	}
	
	@RequestMapping(value = "/doc/movietag/o_save.do")
	public String save(EMovieTag bean , HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		service.save(bean);
		write(response,"success");
		return null;
	}
	
	@RequestMapping("/doc/movietag/v_edit.do")
	public String edit(Integer id, ModelMap model){
		model.addAttribute("movie", service.getById(id));
		return "doc/movietag/edit";
	}
	
	@RequestMapping(value = "/doc/movietag/o_update.do")
	public String update(EMovieTag bean , HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		service.update(bean);
		write(response,"success");
		return null;
	}
	
}
