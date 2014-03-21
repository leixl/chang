/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年3月13日
 * $Id$
 * 
 * Copyright 2008 6677bank.com Croporation Limited.
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

import com.leixl.easyframework.doc.entity.EDongxi;
import com.leixl.easyframework.doc.service.EDongxiService;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.web.BaseAction;
import com.leixl.easyframework.web.CookieUtils;
import com.leixl.easyframework.web.interceptor.CmsUtils;

/**
 *  
 * @author leixl
 * @email  leixl0324@163.com
 * @date   2014年3月13日 下午12:46:46
 * @version v1.0
 */
@Controller
public class EDongxiAction extends BaseAction{

	
	@Autowired
	private EDongxiService service;
	
	
	/**
	 * 
	 * @param queryTitle
	 * @param queryDisabled
	 * @param pageNo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/doc/dongxi/v_list.do")
	public String list(String queryTitle,Boolean queryDisabled, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = service.getPage(queryTitle, queryDisabled, 
				cpn(pageNo),CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);
		model.addAttribute("queryTitle", queryTitle);
		model.addAttribute("queryDisabled", queryDisabled);
		return "doc/dongxi/list";
	}
	
	
	@RequestMapping("/doc/dongxi/v_add.do")
	public String add(){
		return "doc/dongxi/add";
	}
	
	@RequestMapping(value = "/doc/dongxi/o_save.do")
	public String save(EDongxi bean ,HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		EUser user = CmsUtils.getUser(request);
		if(bean != null){
			bean.setUserId(user.getId());
		}
		service.save(bean);
		write(response,"success");
		return null;
	}
	
	@RequestMapping("/doc/dongxi/v_edit.do")
	public String edit(Long id, ModelMap model){
		model.addAttribute("dongxi", service.getById(id));
		return "doc/dongxi/edit";
	}
	
	@RequestMapping(value = "/doc/dongxi/o_update.do")
	public String update(EDongxi bean, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		service.update(bean);
		write(response,"success");
		return null;
	}
}
