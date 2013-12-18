/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-2
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.admin.system;

import static org.easyframework.core.pager.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;

import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;
import com.leixl.easyframework.web.CookieUtils;

/**
 *  用户管理
 * @author leixl
 * @date   2013-12-2 下午12:59:10
 * @version v1.0
 */
@Controller
public class EUserAction {
	
	@Autowired
	private EUserService service;

	
	/**
	 * 用户列表
	 * @param queryUsername
	 * @param queryEmail
	 * @param queryGroupId
	 * @param queryDisabled
	 * @param pageNo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/system/user/list.do")
	public String list(String queryUsername, String queryEmail,
			Integer queryGroupId, Boolean queryDisabled, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = service.getPage(queryUsername, queryEmail, queryGroupId, queryDisabled, true, 
				cpn(pageNo),CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);

		model.addAttribute("queryUsername", queryUsername);
		model.addAttribute("queryEmail", queryEmail);
		model.addAttribute("queryGroupId", queryGroupId);
		model.addAttribute("queryDisabled", queryDisabled);
		
		return "system/user/list";
	}
	
	@RequestMapping("/system/user/add.do")
	public String add(){
		
		return "system/user/add";
	}
	
	@RequestMapping("/system/user/save.do")
	public String save(EUser user){
		
		
		return "redirect:list.do";
	}
	
}
