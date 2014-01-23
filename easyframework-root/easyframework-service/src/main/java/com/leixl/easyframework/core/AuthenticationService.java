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
package com.leixl.easyframework.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leixl.easyframework.common.exception.BadCredentialsException;
import com.leixl.easyframework.common.exception.DisabledException;
import com.leixl.easyframework.common.exception.UsernameNotFoundException;
import com.leixl.easyframework.system.entity.EUser;

/**
 *  认证信息管理接口
 * @author leixl
 * @date   2014年1月23日 下午1:47:18
 * @version v1.0
 */
public interface AuthenticationService {

	
	/**
	 * 认证信息session key
	 */
	public static final String AUTH_KEY = "auth_key";
	
	public EUser login(String username, String password, String ip,
			HttpServletRequest request,HttpServletResponse response) throws UsernameNotFoundException
			,BadCredentialsException,DisabledException;
	
	public Long retrieveUserIdFromSession(HttpServletRequest request) ;
}
