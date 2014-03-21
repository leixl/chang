/**
 * Project: easyframework-service
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
package com.leixl.easyframework.core.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.common.exception.BadCredentialsException;
import com.leixl.easyframework.common.exception.DisabledException;
import com.leixl.easyframework.common.exception.UsernameNotFoundException;
import com.leixl.easyframework.core.AuthenticationService;
import com.leixl.easyframework.core.PwdEncoder;
import com.leixl.easyframework.core.SessionProvider;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;

/**
 *  
 * @author leixl
 * @date   2014年1月23日 下午1:47:39
 * @version v1.0
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{
	
	private Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	@Autowired
	private EUserService service;
	
	@Autowired
	private PwdEncoder pwdEncoder;
	
	@Autowired
	private SessionProvider session;

	public EUser login(String username, String password, String ip,boolean isAdmin,
			HttpServletRequest request,HttpServletResponse response) throws UsernameNotFoundException
			,BadCredentialsException,DisabledException{
		EUser user = null;
		if(isAdmin){
			user = service.getByUsername(username);
		}else{
			user = service.getByEmail(username);
		}
		if (user == null) {
			throw new UsernameNotFoundException("username not found: "
					+ username);
		}
		if (!pwdEncoder.isPasswordValid(user.getPassword(), password)) {
			throw new BadCredentialsException("password invalid");
		}
		if (!user.getActivation()) {
			throw new DisabledException("account not activated");
		}
		service.updateLoginSuccess(user.getId(), ip);
		session.setAttribute(request, response, AUTH_KEY, user.getId());
		return user;
	}
	
	
	public Long retrieveUserIdFromSession(HttpServletRequest request) {
		return (Long) session.getAttribute(request, AUTH_KEY);
	}
}
