/**
 * Project: easyframework-webapp
 * 
 * File Created at 2014年1月23日
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


import static com.leixl.easyframework.common.Constants.RETURN_URL;
import static com.leixl.easyframework.common.Constants.MESSAGE;
import static com.leixl.easyframework.core.AuthenticationService.AUTH_KEY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leixl.easyframework.common.exception.BadCredentialsException;
import com.leixl.easyframework.common.exception.DisabledException;
import com.leixl.easyframework.common.exception.UsernameNotFoundException;
import com.leixl.easyframework.core.AuthenticationService;
import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;
import com.leixl.easyframework.web.RequestUtils;


/**
 *  
 * @author leixl
 * @date   2014年1月23日 下午10:37:20
 * @version v1.0
 */
@Controller
public class LoginAction {
	
	@Autowired
	private SessionProvider session;
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private EUserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String input(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String message = RequestUtils.getQueryParam(request, MESSAGE);
		Long userId = (Long) session.getAttribute(request, AUTH_KEY);
		if (userId != null) {
			return "index";
		}
		if (!StringUtils.isBlank(message)) {
			model.addAttribute(MESSAGE, message);
		}
		return "login";
	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String submit(String username, String password, String captcha, String message,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try{
			String ip = RequestUtils.getIpAddr(request);
			EUser user = authService.login(username, password, ip,
					request, response);
			if(user!=null){
				//登录成功返回后台首页
				return "redirect:index.do";
			}else{
				return "redirect:login.do";
			}
		} catch (UsernameNotFoundException e) {
			message = e.getMessage();
		} catch (BadCredentialsException e) {
			message = e.getMessage();
		} catch (DisabledException e) {
			message = e.getMessage();
		}
			
		// 登录失败
		if (!StringUtils.isBlank(message)) {
			model.addAttribute(MESSAGE, message);
		}
		return "login";
	}
	
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Long userId = (Long) session.getAttribute(request, AUTH_KEY);
		if (userId != null) {
			session.logout(request, response);
		}
		String returnUrl = RequestUtils.getQueryParam(request, RETURN_URL);
		String view = getView(returnUrl);
		if (view != null) {
			return view;
		} else {
			return "redirect:login.do";
		}
	}
	
	/**
	 * 获得地址
	 * 
	 * @param processUrl
	 * @param returnUrl
	 * @param authId
	 * @param defaultUrl
	 * @return
	 */
	private String getView(String returnUrl) {
		if (!StringUtils.isBlank(returnUrl)) {
			StringBuilder sb = new StringBuilder("redirect:");
			sb.append(returnUrl);
			return sb.toString();
		} else {
			return null;
		}
	}
}
