/**
 * Project: easyframework-webapp
 * 
 * File Created at 2013-11-29
 * $Id$
 * 
 * Copyright 2013 leixl.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.leixl.easyframework.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author leixl
 * @date   2013-11-29 上午12:37:23
 * @version v1.0
 */
@Controller
public class WelcomeAction {

	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/top.do")
	public String top() {
		return "top";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/menu.do")
	public String menu() {
		return "menu";
	}
	@RequestMapping("/archives.do")
	public String archives() {
		return "archives";
	}
	
	
}
