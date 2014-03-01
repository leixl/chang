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
package com.leixl.easyframework.system.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.easyframework.core.pager.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leixl.easyframework.core.PwdEncoder;
import com.leixl.easyframework.system.dao.EUserDao;
import com.leixl.easyframework.system.entity.EUser;
import com.leixl.easyframework.system.service.EUserService;

/**
 * 用户管理
 * 
 * @author leixl
 * @date 2013-12-2 下午2:16:36
 * @version v1.0
 */
@Service
@Transactional
public class EUserServiceImpl implements EUserService {
	
	@Autowired
	private PwdEncoder pwdEncoder;
 
	@Autowired
	private EUserDao dao;

	public Pagination getPage(String username, String email, Integer groupId,
			Boolean disabled, Boolean admin, int pageNo, int pageSize) {

		Pagination page = dao.getPage(username, email, groupId, disabled,
				admin, pageNo, pageSize);
		return page;
	}
	
	public EUser save(String username, String email, String password,
			String ip)  {
		Date now = new Timestamp(System.currentTimeMillis());
		EUser user = new EUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pwdEncoder.encodePassword(password));
		user.setRegisterIp(ip);
		user.setRegisterTime(now);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(now);
		//不强制验证邮箱直接激活
		user.setActivation(true);
		user.init();
		dao.save(user);
		return user;
	}

	
	public void updateLoginSuccess(Long userId, String ip) {
		EUser user = findById(userId);
		Date now = new Timestamp(System.currentTimeMillis());

		user.setLoginCount(user.getLoginCount() + 1);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(now);

		user.setErrorCount(0);
		user.setErrorTime(null);
		user.setErrorIp(null);
	}
	
	public void updateLoginInfo(Long userId, String ip) {
		Date now = new Timestamp(System.currentTimeMillis());
		EUser user = findById(userId);
		if (user != null) {
			user.setLoginCount(user.getLoginCount() + 1);
			user.setLastLoginIp(ip);
			user.setLastLoginTime(now);
		}
	}

	public EUser registMember(String username, String password,String nickName, 
			String ip)  {
		Date now = new Timestamp(System.currentTimeMillis());
		EUser user = new EUser();
		user.setUsername(username);
		user.setPassword(pwdEncoder.encodePassword(password));
		user.setRegisterIp(ip);
		user.setRegisterTime(now);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(now);
		user.setAdmin(false);
		//不强制验证邮箱直接激活
		user.setActivation(true);
		user.init();
		dao.save(user);
		return user;
	}

	public boolean usernameExist(String username) {
		return getByUsername(username) != null;
	}

	public boolean emailExist(String email) {
		return dao.countByEmail(email) > 0;
	}

	public EUser getByUsername(String username) {
		return dao.findByUsername(username);
	}

	public List<EUser> getByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public EUser findById(Long id) {
		EUser entity = dao.findById(id);
		return entity;
	}

	
	

	/**
	 * @see EUserMng#update(Integer, String, String)
	 */
	public EUser update(Long id, String password, String email) {
		EUser user = findById(id);
		if (!StringUtils.isBlank(email)) {
			user.setEmail(email);
		} else {
			user.setEmail(null);
		}
		if (!StringUtils.isBlank(password)) {
			user.setPassword(pwdEncoder.encodePassword(password));
		}
		return user;
	}

	public boolean isPasswordValid(Long id, String password) {
		EUser user = findById(id);
		return pwdEncoder.isPasswordValid(user.getPassword(), password);
	}

	public EUser deleteById(Long id) {
		EUser bean = dao.deleteById(id);
		return bean;
	}

	public EUser[] deleteByIds(Long[] ids) {
		EUser[] beans = new EUser[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	public EUser active(String username, String activationCode) {
		EUser bean = getByUsername(username);
		bean.setActivation(true);
		bean.setActivationCode(null);
		return bean;
	}

	public EUser activeLogin(EUser user, String ip) {
		updateLoginSuccess(user.getId(), ip);
		return user;
	}
	
}
