/**
 * Project: easyframework-service
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
package com.leixl.easyframework.system.service;

import java.util.List;

import org.easyframework.core.pager.Pagination;

import com.leixl.easyframework.system.entity.EUser;

/**
 *  
 * @author leixl
 * @date   2013-12-2 下午2:16:14
 * @version v1.0
 */
public interface EUserService {
 
	/**
	 * 用户列表
	 * @param username
	 * @param email
	 * @param groupId
	 * @param disabled
	 * @param admin
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination getPage(String username, String email, Integer groupId,
			Boolean disabled, Boolean admin, int pageNo, int pageSize);
	
	public EUser save(String username, String email, String password,
			String ip) ;
	
	public void updateLoginInfo(Long userId, String ip);
	
	public void updateLoginSuccess(Long userId, String ip) ;
	
	public boolean usernameExist(String username);
	
	public boolean emailExist(String email);
	
	public EUser getByUsername(String username);
	
	public List<EUser> getByEmail(String email);
	
	public EUser findById(Long id) ;
	
	public EUser update(Long id, String password, String email) ;
	
	public boolean isPasswordValid(Long id, String password);
	
	public EUser deleteById(Long id) ;
	
	public EUser[] deleteByIds(Long[] ids);
	
	public EUser active(String username, String activationCode);
	
	public EUser activeLogin(EUser user, String ip);
}
