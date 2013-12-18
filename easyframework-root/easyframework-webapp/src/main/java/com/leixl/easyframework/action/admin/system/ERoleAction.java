/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-12-11
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leixl.easyframework.system.entity.ERole;
import com.leixl.easyframework.system.service.ERoleService;


/**
 *  角色
 * @author leixl
 * @date   2013-12-11 下午4:57:00
 * @version v1.0
 */
@Controller
public class ERoleAction {

	@Autowired
	private ERoleService service;
	
	@RequestMapping("/system/role/list.do")
	public String list(ModelMap model){
		List<ERole> list = service.getList();
		model.addAttribute("roleList", list);
		return "system/role/list";
	}
	
	@RequestMapping("/system/role/add.do")
	public String add(){
		return "system/role/add";
	}
}
